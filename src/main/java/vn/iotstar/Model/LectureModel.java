package vn.iotstar.Model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@JacksonStdImpl
public class LectureModel {
	private String id;
	private String username;
	private String facultyId;
	private String name;
	private String dob;
	private String address;
	private String gender;
	private String phone;
	private String image;
	private int deleted;
	private MultipartFile imageFile;
	private Boolean isEdit = false;

	public String getFacultyId() {
		return facultyId;
	}

	public LectureModel() {
		super();
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LectureModel(String id, String username, String facultyId, String name, String dob, String address,
			String gender, String phone, String image, int deleted, MultipartFile imageFile, Boolean isEdit) {
		super();
		this.id = id;
		this.username = username;
		this.facultyId = facultyId;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.image = image;
		this.deleted = deleted;
		this.imageFile = imageFile;
		this.isEdit = isEdit;
	}

}
