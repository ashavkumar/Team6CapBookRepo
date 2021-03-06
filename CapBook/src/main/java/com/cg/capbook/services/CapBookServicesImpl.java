package com.cg.capbook.services;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Album;
import com.cg.capbook.beans.Comment;
import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.daoservices.AlbumDAO;
import com.cg.capbook.daoservices.FriendDAO;
import com.cg.capbook.daoservices.MessageDAO;
import com.cg.capbook.daoservices.PostDAO;
import com.cg.capbook.daoservices.ProfileDAO;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.FriendshipAlreadyExistException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.RequestAlreadyReceivedException;
import com.cg.capbook.exceptions.RequestAlreadySentException;
import com.cg.capbook.exceptions.UserAuthenticationFailedException;
@Component("capBookServices")
public class CapBookServicesImpl implements CapBookServices {
	@Autowired
	private ProfileDAO profileDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private FriendDAO friendDAO;
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private AlbumDAO albumDAO;
	@Autowired
	private CodecServices codecServices;
	static String sessionEmailId;
	@Override
	public Profile registerUser(Profile profile) throws EmailAlreadyUsedException {
		if(profileDAO.findById(profile.getEmailId()).isPresent())
			throw new EmailAlreadyUsedException();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date today = new Date();
		profile.setDateOfJoining(formatter.format(today).toString());
		profile.setPassword(codecServices.encrypt(profile.getPassword()));
		return profileDAO.save(profile);
	}
	@Override
	public Profile loginUser(Profile profile) throws InvalidEmailIdException, InvalidPasswordException {
		Profile profile1=profileDAO.findById(profile.getEmailId()).orElseThrow(()->new InvalidEmailIdException());
		if(!codecServices.decrypt(profile1.getPassword()).equals(profile.getPassword()))
			throw new InvalidPasswordException();
		sessionEmailId=profile.getEmailId();
		return profile1;
	}
	@Override
	public Profile forgotPassword(Profile profile) throws InvalidEmailIdException, UserAuthenticationFailedException{
		Profile profile1=profileDAO.findById(profile.getEmailId()).orElseThrow(()->new InvalidEmailIdException());
		if(profile.getSecurityQuestion().equals(profile1.getSecurityQuestion()) && profile.getSecurityAnswer().equals(profile1.getSecurityAnswer())) {
			profile1.setPassword(codecServices.decrypt(profile1.getPassword()));
			return profile1;
		}
		else
			throw new UserAuthenticationFailedException();	
	}
	@Override
	public Profile changePassword(String emailId,String newPassword) throws InvalidEmailIdException, InvalidPasswordException{
		Profile profile=profileDAO.findById(emailId).orElseThrow(()->new InvalidEmailIdException());
		profileDAO.changePassword(codecServices.encrypt(newPassword),profile.getEmailId());
		return null;
	}
	@Override
	public Profile editProfile(Profile profile) throws InvalidEmailIdException {
		Profile profile1=profileDAO.findById(sessionEmailId).orElseThrow(()->new InvalidEmailIdException());
		if(profile.getCurrentCity()!=null)
			profile1.setCurrentCity(profile.getCurrentCity());
		if(profile.getHighestEducation()!=null)
			profile1.setHighestEducation(profile.getHighestEducation());
		if(profile.getRelationshipStatus()!=null)
			profile1.setRelationshipStatus(profile.getRelationshipStatus());
		if(profile.getUserBio()!=null)
			profile1.setUserBio(profile.getUserBio());
		if(profile.getDesignation()!=null)
			profile1.setDesignation(profile.getDesignation());
		return profileDAO.save(profile1);
	}
	@Override
	public List<Profile> searchAllUsersByName(String userName) throws  NoUserFoundException{
		List<Profile> listUser=profileDAO.searchAllUserByName(userName.toLowerCase());
		if(listUser.isEmpty())
			throw new NoUserFoundException();
		return listUser;
	}
	@Override
	public Friend addFriend(String fromUserId,String toUserId) throws FriendshipAlreadyExistException, RequestAlreadyReceivedException, RequestAlreadySentException {
		Friend friend=friendDAO.checkFriendship(fromUserId,toUserId);
		Friend friend1=friendDAO.checkFriendship(toUserId,fromUserId);
		if(friend==null && friend1==null){
			friend=new Friend(toUserId,fromUserId);
			friend=friendDAO.save(friend);
			Profile profile=profileDAO.findById(fromUserId).get();
			Map<Integer, Friend> friendMap=new HashMap<>(profile.getFriends());
			friendMap.put(friend.getFriendId(), friend);
			profile.setFriends(friendMap);
			profileDAO.save(profile);
		}
		else if(friend==null && friend1!=null)
			throw new RequestAlreadyReceivedException();
		else if(friend!=null && friend1==null)
			throw new RequestAlreadySentException();
		else
			throw new FriendshipAlreadyExistException();
		return friend;
	}
	@Override
	public Friend acceptFriend(String fromUserId,String toUserId) throws RequestAlreadySentException {
		Friend friend=friendDAO.checkFriendship(fromUserId,toUserId);
		Profile profile=profileDAO.findById(toUserId).get();
		Map<Integer, Friend> friendMap=new HashMap<>(profile.getFriends());
		friendMap.put(friend.getFriendId(), friend);
		profile.setFriends(friendMap);
		profileDAO.save(profile);
		return friend;
	}
	@Override
	public Friend rejectFriend(String fromUserId,String toUserId) throws RequestAlreadySentException {
		Friend friend=friendDAO.checkFriendship(fromUserId,toUserId);
		Profile profile=profileDAO.findById(fromUserId).get();
		Map<Integer, Friend> friendMap=new HashMap<>(profile.getFriends());
		friendMap.remove(friend.getFriendId(),friend);
		profileDAO.save(profile);
		friendDAO.deleteById(friend.getFriendId());
		return null;
	}
	public List<Profile> getFriendList(String emailId){
		Profile profile=profileDAO.findById(emailId).get();
		Profile friendProfile;
		Map<Integer, Friend> friendMap=new HashMap<>();
		friendMap=profile.getFriends();
		List<Friend> friendList=new ArrayList<>(friendMap.values());
		//List<Friend> friendList2=new ArrayList<>();
		List<Profile> friendProfiles=new ArrayList<>();
		for(Friend friend:friendList) {
			//Friend friend=friendDAO.findById(friends.getFriendId()).get();
			if(friend.getFromUserId().equals(emailId)) 
				friendProfile=profileDAO.findById(friend.getToUserId()).get();
			//friendList2.add(friend);
			else//(friend.getToUserId().equalsIgnoreCase(emailId))
				//friendList2.add(friend);
				friendProfile=profileDAO.findById(friend.getFromUserId()).get();
			friendProfiles.add(friendProfile);
		}
		return friendProfiles;
	}
	@Override
	public void sendMessage(Message message) {
		messageDAO.save(message);
	}
	@Override
	public List<Message> viewSentMessages(String emailId) {
		return messageDAO.findMessagesBySender(emailId);
	}
	@Override
	public List<Message> viewReceivedMessages(String emailId) {
		return messageDAO.findMessagesByReceiver(emailId);
	}
	@Override
	public Profile getProfile(String emailId) throws InvalidEmailIdException {
		Profile profile=profileDAO.findById(emailId).orElseThrow(()->new InvalidEmailIdException());
		return profile;
	}
	@Override
	public Profile insertProfilePic(byte[] profilePic) {
		Profile profile=profileDAO.findById(sessionEmailId).get();
		profile.setProfilePic(profilePic);
		return profileDAO.save(profile);
	}
	@Override
	public byte[] fetchProfilePic() {
		Profile profile=profileDAO.findById(sessionEmailId).get();
		return profile.getProfilePic();
	}
	@Override
	public Post createPost(Post post) {
		post.setEmailId(sessionEmailId);
		post=postDAO.save(post);
		return post;
	}
	@Override
	public List<Post> getPost(){
		List<Post> listPost=postDAO.findPost(sessionEmailId);
		return listPost;
	}
	@Override
	public Post updatePostLikes(Post post) {
		Post oldPost=postDAO.findById(post.getPostId()).get();
		post.setNoOfPostLikes(oldPost.getNoOfPostLikes()+1);
		return postDAO.save(post);
	}
	@Override
	public Post updatePostDislikes(Post post) {
		Post oldPost=postDAO.findById(post.getPostId()).get();
		post.setNoOfPostLikes(oldPost.getNoOfPostDislikes()+1);
		return postDAO.save(post);
	}
	@Override
	public Post addPostComment(Comment comment) {
		//Post oldPost=postDAO.findById(comment.getPostId()).get();
		//Map<Integer, Comment> commentMap=new HashMap<>(oldPost.getComments());
		//commentMap.put(post.getComments()., value)
		return null;
	}
	@Override
	public Profile insertAlbumPic(byte[] albumPic) {
		Profile profile=profileDAO.findById(sessionEmailId).get();
		Album album=new Album();
		album.setImage(albumPic);
		album.setProfile(profile);
		albumDAO.save(album);
		return profile;
	}
	@Override
	public List<Byte[]> fetchAlbumPic(String userName) {
		List<Byte[]> pdu = new ArrayList<Byte[]>();
		pdu=albumDAO.findbyName(userName);
		System.out.println(pdu);
		return pdu;
	}
	public void displayFriendRequest() {
		Profile profile=profileDAO.findById(sessionEmailId).get();
		@SuppressWarnings("unused")
		Map<Integer, Friend> friendMap=profile.getFriends();
	}
}