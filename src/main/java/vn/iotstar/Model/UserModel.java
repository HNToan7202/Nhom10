package vn.iotstar.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UserModel {
	private String id;
	@NotEmpty(message = "tên đăng nhập không được để trống")
	private String username;
	@NotEmpty(message = "Mật khẩu không được để trống")
	@Min(value = 6, message = "Password phải từ 6 ký tự trở lên")
	private String password;

	private String roleid;
	private int deleted;
	private Boolean isEdit = false;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
