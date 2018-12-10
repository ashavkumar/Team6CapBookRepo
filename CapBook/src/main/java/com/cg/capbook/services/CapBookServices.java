package com.cg.capbook.services;
import java.util.List;

import com.cg.capbook.beans.Comment;
import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.FriendshipAlreadyExistException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.RequestAlreadyReceivedException;
import com.cg.capbook.exceptions.RequestAlreadySentException;
import com.cg.capbook.exceptions.UserAuthenticationFailedException;
public interface CapBookServices {
	Profile registerUser(Profile profile) throws EmailAlreadyUsedException, EmailAlreadyUsedException;
	Profile loginUser(Profile profile) throws InvalidEmailIdException,InvalidPasswordException;
	Profile editProfile(Profile profile) throws InvalidEmailIdException;
	List<Profile> searchAllUsersByName(String userName) throws  NoUserFoundException;
	void sendMessage(Message message);
	List<Message> viewSentMessages(String emailId);
	List<Message> viewReceivedMessages(String emailId);
	Friend addFriend(String toUserId,String fromUserId) throws FriendshipAlreadyExistException, RequestAlreadyReceivedException, RequestAlreadySentException;
	Profile getProfile(String emailId) throws InvalidEmailIdException;
	Profile insertProfilePic(byte[] profilePic);
	byte[] fetchProfilePic();
	List<Byte[]> fetchAlbumPic(String userName);
	Friend acceptFriend(String fromUserId, String toUserId) throws RequestAlreadySentException;
	Profile changePassword(String emailId,String newPassword) throws InvalidEmailIdException, InvalidPasswordException;
	Friend rejectFriend(String fromUserId, String toUserId) throws RequestAlreadySentException;
	public List<Profile> getFriendList(String emailId);
	Profile forgotPassword(Profile profile)throws InvalidEmailIdException, UserAuthenticationFailedException;
	Post createPost(Post post);
	Post updatePostLikes(Post post);
	Post updatePostDislikes(Post post);
	Post addPostComment(Comment comment);
	Profile insertAlbumPic(byte[] albumPic);
	Post editPost(Post post);
}
