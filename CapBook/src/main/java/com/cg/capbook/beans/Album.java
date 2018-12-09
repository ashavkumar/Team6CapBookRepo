package com.cg.capbook.beans;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int imageId;
	@Column(columnDefinition="BLOB")
	private byte[] image;
	@ManyToOne
	@MapKey
	@JoinColumn(name="emailId")
	private Profile profile;
	public Album() {
		super();
	}
	public Album(int imageId, byte[] image, Profile profile) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.profile = profile;
	}
	public final int getImageId() {
		return imageId;
	}
	public final void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public final byte[] getImage() {
		return image;
	}
	public final void setImage(byte[] image) {
		this.image = image;
	}
	public final Profile getProfile() {
		return profile;
	}
	public final void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Album [imageId=" + imageId + ", image=" + Arrays.toString(image) + "]";
	}
}
