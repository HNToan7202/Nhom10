package vn.iotstar.Model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@JacksonStdImpl
public class StudentClassModel {
    private String id;
    private String name;
    private String facultyId;
    private String facultyName;
    private int deleted;
	private Boolean isEdit = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public StudentClassModel() {
		super();
	}
	public StudentClassModel(String id, String name, String facultyId, String facultyName, int deleted,
			Boolean isEdit) {
		super();
		this.id = id;
		this.name = name;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.deleted = deleted;
		this.isEdit = isEdit;
	}
	
    
}
