package vn.iotstar.Model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@JacksonStdImpl
public class SubjectModel {
	private String id;
	private String name;
	private int credits;
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
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

	public SubjectModel() {
		super();
	}

	public SubjectModel(String id, String name, int credits, int deleted, Boolean isEdit) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.deleted = deleted;
		this.isEdit = isEdit;
	}

}
