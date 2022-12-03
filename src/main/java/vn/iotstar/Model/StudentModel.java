package vn.iotstar.Model;

public class StudentModel {
	private String mssv;
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

}
