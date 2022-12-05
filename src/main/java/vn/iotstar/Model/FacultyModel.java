package vn.iotstar.Model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class FacultyModel {

	private String id;
	private String name;
	private int deleted;
	private Boolean isEdit = false;

	public int getDeleted() {
		return deleted;
	}

	public FacultyModel() {
		super();
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public FacultyModel(String id, String name, int deleted, Boolean isEdit) {
		super();
		this.id = id;
		this.name = name;
		this.deleted = deleted;
		this.isEdit = isEdit;
	}

}
