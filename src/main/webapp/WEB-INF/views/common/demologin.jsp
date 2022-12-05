
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Login Page</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/assets/img/favicon.png" rel="icon">
<link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="/assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>

	<main>

		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="/assets/img/logospkt.webp" alt=""> <span
									class="d-none d-lg-block">HCMUTE</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">ĐĂNG NHẬP</h5>
										<p class="text-center small">Nhập tài khoản và mật khẩu để
											đăng nhập</p>
									</div>

									<form class="row g-3 needs-validation" novalidate
										action="<c:url value="/login"/>" method="post"
										enctype="multipart/form-data">

										<div class="col-12">
											<label for="yourUsername" class="form-label">Tài
												Khoản</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="username">MSSV</span> <input
													type="text" name="username" class="form-control"
													value="${user.username}" id="username" required>
												<div class="invalid-feedback">Vui lòng nhập tài khoản.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">Mật Khẩu</label>
											<input type="password" name="password" class="form-control"
												value="${user.password}" id="yourPassword" required>
											<div class="invalid-feedback">Vui lòng nhập mật khẩu !</div>
										</div>

										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="remember" value="true" id="rememberMe"> <label
													class="form-check-label" for="rememberMe">Remember
													me</label>
											</div>
										</div>
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Login</button>
										</div>
										<div class="col-12">
											<p class="small mb-0">
												Don't have account? <a href="pages-register.html">Create
													an account</a>
											</p>
										</div>
									</form>

								</div>
							</div>

							<div class="credits">
								<!-- All the links in the footer should remain intact. -->
								<!-- You can delete the links only if you purchased the pro version. -->
								<!-- Licensing information: https://bootstrapmade.com/license/ -->
								<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
							</div>

						</div>
					</div>
				</div>

			</section>

		</div>
	</main>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/vendor/chart.js/chart.min.js"></script>
	<script src="/assets/vendor/echarts/echarts.min.js"></script>
	<script src="/assets/vendor/quill/quill.min.js"></script>
	<script src="/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="/assets/js/main.js"></script>


	<!-- End #main -->
</body>


<%-- <form action="<c:url value="/login"/>" method="post"
	enctype="multipart/form-data">
	<br />
	<div class="form-group">
		<label for="UserID">Tên Đăng Nhập:</label> <input type="text"
			name="username" value="${user.username}" id="username" class="form-control" />
	</div>
	<div class="form-group">
		<label for="categoryName">Mật Khẩu:</label> <input type="text"
			class="form-control" name="password" id="password" value="${user.password}" />
	</div>
	<br />
	<hr>
	<div class="form-group">
		<button class="btn green">
			Save <i class="fa fa-plus"></i>
		</button>

	</div>
</form> --%>