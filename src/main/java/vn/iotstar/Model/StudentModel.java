package vn.iotstar.Model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@JacksonStdImpl
public class StudentModel {

	private String id;
	private String mssv;
	private String username;
	private String studentClassId;
	private String studentClassName;
	private String name;
	private String dob;
	private String address;
	private String gender;
	private String phone;
	private int deleted;
	private String image;
	private String facultyId;
	private String facultyName;
	private MultipartFile imageFile;
	private Boolean isEdit = false;

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getStudentClassId() {
		return studentClassId;
	}

	public void setStudentClassId(String studentClassId) {
		this.studentClassId = studentClassId;
	}

	public String getStudentClassName() {
		return studentClassName;
	}

	public void setStudentClassName(String studentClassName) {
		this.studentClassName = studentClassName;
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

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public StudentModel() {
		super();
	}

	public StudentModel(String id, String mssv, String username, String studentClassId, String studentClassName,
			String name, String dob, String address, String gender, String phone, int deleted, String image,
			String facultyId, String facultyName, MultipartFile imageFile, Boolean isEdit) {
		super();
		this.id = id;
		this.mssv = mssv;
		this.username = username;
		this.studentClassId = studentClassId;
		this.studentClassName = studentClassName;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.deleted = deleted;
		this.image = image;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.imageFile = imageFile;
		this.isEdit = isEdit;
	}

}
