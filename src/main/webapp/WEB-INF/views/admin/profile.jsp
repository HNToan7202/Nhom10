<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main id="main" class="main">

	<!-- End Page Title -->
	<h5 class="card-title fw-400">${message}</h5>

	<section class="section profile">
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

			<div class="col-xl-8">

				<div class="card">
					<div class="card-body pt-3">
						<!-- Bordered Tabs -->

						<ul class="nav nav-tabs nav-tabs-bordered" >

							<li class="nav-item" style="margin: auto;">
								<button class="nav-link active" data-bs-toggle="tab"
									data-bs-target="#profile-overview">Thông tin</button>
							</li>
<!-- 
							<li class="nav-item">
								<button class="nav-link" data-bs-toggle="tab"
									data-bs-target="#profile-edit">Chỉnh Sửa</button>
							</li> -->

							<!-- 							<li class="nav-item">
								<button class="nav-link" data-bs-toggle="tab"
									data-bs-target="#profile-settings">Settings</button>
							</li> -->

					<!-- 		<li class="nav-item">
								<button class="nav-link" data-bs-toggle="tab"
									data-bs-target="#profile-change-password">Đổi Mật Khẩu</button>
							</li> -->

						</ul>



						<div class="tab-content pt-2">

							<div class="tab-pane fade show active profile-overview" style="margin: azimuth: ;"
								id="profile-overview">

								<div class="row">
									<div class="col-lg-3 col-md-4 label ">Mã số </div>
									<div class="col-lg-9 col-md-8">${user.id}</div>
								</div>

								<div class="row">
									<div class="col-lg-3 col-md-4 label">Họ và Tên</div>
									<div class="col-lg-9 col-md-8">${user.name }</div>
								</div>

								<div class="row">
									<div class="col-lg-3 col-md-4 label">Số Tài Khoản</div>
									<div class="col-lg-9 col-md-8">${user.username}</div>
								</div>

								<div class="row">
									<div class="col-lg-3 col-md-4 label">Số Điện Thoại</div>
									<div class="col-lg-9 col-md-8">${user.phone}</div>
								</div>

								<div class="row">
									<div class="col-lg-3 col-md-4 label">
										<a href="/admin/edit/${user.id}"
											class="btn btn-outline-info"><i class="fa fa-info"></i>Chỉnh Sửa Thông Tin</a>

									</div>
									<div class="col-lg-9 col-md-8">
										<a href="/admin/account"
											class="btn btn-outline-warning"><i class="fa fa-edit"></i>Đổi Mật Khẩu</a>
									</div>
								</div>


							</div>

						</div>

					</div>
					<!-- End Bordered Tabs -->
				</div>
			</div>
		</div>
	</section>

</main>
<!-- End #main -->