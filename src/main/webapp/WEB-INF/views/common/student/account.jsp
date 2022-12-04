<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="w-100" id="main">
	<div class="row">
		<div class="col-xl-4">

			<div class="card">
				<div
					class="card-body profile-card pt-4 d-flex flex-column align-items-center">

					<img src="${user.image }" alt="Profile" class="rounded-circle">
					<h2>${user.name }</h2>
					<h3>Sinh Viên</h3>
					<div class="social-links mt-2">
						<a class="twitter"><i class="bi bi-twitter"></i></a> <a
							class="facebook"><i class="bi bi-facebook"></i></a> <a
							class="instagram"><i class="bi bi-instagram"></i></a> <a
							class="linkedin"><i class="bi bi-linkedin"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<form action="<c:url value="/student/account"/>" method="post"
		enctype="multipart/form-data">
		<br>
		<div class="row mb-3">
			<label for="password" class="col-md-4 col-lg-3 col-form-label">Current
				Password</label>
			<div class="col-md-7 col-lg-8">
				<input name="password" type="text" class="form-control"
					id="password">
			</div>
		</div>

		<div class="row mb-3">
			<label for="newpassword" class="col-md-4 col-lg-3 col-form-label">New
				Password</label>
			<div class="col-md-7 col-lg-8">
				<input name="newpassword" type="text" class="form-control"
					id="newpassword">
			</div>
		</div>

		<!-- 		<div class="row mb-3">
			<label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter
				New Password</label>
			<div class="col-md-7 col-lg-8">
				<input name="renewpassword" type="password" class="form-control"
					id="renewpassword">
			</div>
		</div> -->

		<div class="text-center">
			<button type="submit" class="btn btn-primary">Change
				Password</button>
		</div>
		<!-- End Change Password Form -->
	</form>
</div>