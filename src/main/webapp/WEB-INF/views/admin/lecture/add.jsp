<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Giảng Viên</title>
</head>
<body>
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Create Giảng Viên</h6>
	</div>

	<form action=<c:url value="/admin/add/saveOrUpdate" /> method="POST">
		<div class="card-body mx-auto">
			<div class="mb-3 mx-auto">
				<label for="role_id" class="form-label">Role</label> <input
					type="text" class="form-control" id="role_id"
					aria-describedby="role_id" name="role_id" value="1"
					readonly="readonly">

			</div>
			<div class="mb-3">
				<label for="role_name" class="form-label">Bộ phận</label> <input
					type="text" class="form-control" id="role_id"
					aria-describedby="role_id" name="role_name" value="Giảng Viên"
					readonly="readonly">

			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email"
					aria-describedby="email" name="email" value="${id}@gmail.com"
					placeholder="${id}@gmail.com">
			</div>
			<div class="mb-3">
				<label for="id" class="form-label">Mã số</label> <input type="text"
					class="form-control" id="id" aria-describedby="id" name="id">

			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu</label> <input
					type="text" class="form-control" id="password"
					aria-describedby="password" name="password" value="${id}"
					placeholder="${id}" readonly="readonly">
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">Tên</label> <input type="text"
					class="form-control" id="name" aria-describedby="name">
			</div>
			<div class="mb-3">
				<label for="image" class="form-label">Imagel</label> <input
					type="text" class="form-control" id="image"
					aria-describedby="image" name="image" placeholder="link ảnh">

			</div>
			<div class="mb-3">
				<label for="dateofbirth" class="form-label">Ngày sinh</label> <input
					type="date" class="form-control" id="dateofbirth"
					aria-describedby="dateofbirth">
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Địa chỉ</label> <input
					type="text" class="form-control" id="address"
					aria-describedby="address">
			</div>
			<div class="mb-3">
				<label for="id_project" class="form-label">Hướng dẫn Project</label>
				<input type="text" class="form-control" id="id_project"
					aria-describedby="id_project" name="id_project">

			</div>
			<div class="mb-3">
				<label for="id_hoidong" class="form-label">Thuộc hội đồng</label> <input
					type="text" class="form-control" id="id_project"
					aria-describedby="id_hoidong" name="id_hoidong">

			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="is_active ">
				<label class="form-check-label" for="is_active ">Is_active</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</body>
</html>