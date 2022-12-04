<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="main">
	<!-- Change Password Form -->
	<form action="/student/changepassword" method="POST"
		enctype="multipart/form-data">

		<div class="row mb-3">
			<label for="password" class="col-md-4 col-lg-3 col-form-label">Mật
				Khẩu Hiện Tại</label>
			<div class="col-md-8 col-lg-9">
				<input name="password" type="password" class="form-control"
					id="password">
			</div>
		</div>

		<div class="row mb-3">
			<label for="newPassword" class="col-md-4 col-lg-3 col-form-label">Nhập
				Mật Khẩu Mới</label>
			<div class="col-md-8 col-lg-9">
				<input name="newpassword" type="password" class="form-control"
					id="newpassword">
			</div>
		</div>

		<div class="row mb-3">
			<label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Nhập
				Lại Mật Khẩu</label>
			<div class="col-md-8 col-lg-9">
				<input name="renewpassword" type="password" class="form-control"
					id="renewPassword">
			</div>
		</div>

		<div class="text-center">
			<button type="submit" class="btn btn-primary">Đổi Mật Khẩu</button>
		</div>
	</form>
	<!-- End Change Password Form -->

</div>