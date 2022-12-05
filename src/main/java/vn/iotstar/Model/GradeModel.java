package vn.iotstar.Model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class GradeModel {
	private String id;

	private int mssv;
	private float grade;
	private String subjectId;
	private int deleted;
	private String studentName;
	private Boolean isEdit = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
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

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public GradeModel(String id, int mssv, float grade, String subjectId, int deleted, String studentName,
			Boolean isEdit) {
		super();
		this.id = id;
		this.mssv = mssv;
		this.grade = grade;
		this.subjectId = subjectId;
		this.deleted = deleted;
		this.studentName = studentName;
		this.isEdit = isEdit;
	}

	public GradeModel() {
		super();
	}

}
