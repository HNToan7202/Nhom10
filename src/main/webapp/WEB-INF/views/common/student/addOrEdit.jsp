<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="main">
	<div style="margin: 0px;">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet">
			<div class="portlet-title">
				<div class="caption">
					<h2>${student.isEdit ? 'Edit Student' : 'Add New Student' }</h2>
					<i class="fa fa-globe"></i>
				</div>
			</div>
			<div class="portlet-body d-flex justify-content-center">
				<div class="table-toolbar">
					<!-- Hiển thị thông báo -->
					<%@include file="/common/info.jsp"%>
					<!-- Kết thúc hiển thị thông báo -->
					<div class="row" style="margin: 0px;">
						<div class="">
							<div class="row" style="margin: 0px;">
								<div class="">
									<form action="<c:url value="/student/saveofUpdate"/>"
										method="post" enctype="multipart/form-data">
										<br />
										
										<div class="form-group">
											<label for="UserID">Tên đăng nhập:</label> <input type="text"
												name="username" value="${student.username}" id="username"
												class="form-control" />
										</div>
										<div class="form-group">
											<label for="UserID">Mã số sinh viên:</label> <input
												type="text" name="mssv" value="${student.mssv}" id="mssv"
												class="form-control" />
										</div>
										<div class="form-group">
											<label for="categoryName">Họ và tên:</label> <input
												type="text" class="form-control" name="name" id="name"
												value="${student.name}" />
										</div>
										<div class="form-group">
											<label for="categoryCode">Ngày sinh:</label> <input
												type="text" class="form-control" name="dob"
												value="${student.dob}" id="dob" />
										</div>
										<div class="form-group">
											<label for="images">Images:</label> <input type="file"
												class="form-control" name="imageFile" id="imageFile" />
										</div>
										<input type="text" class="form-control" name="image"
											id="image" value="${student.image}" hidden="true" />
										<div class="form-group">
											<label for="email">Địa chỉ sinh viên:</label> <input
												type="text" class="form-control" name="address" id="address"
												value="${student.address}" />
										</div>
										<div class="form-group">
											<label for="deparment">Khoa :</label> <input type="text"
												class="form-control" name="facultyId" id="deparment"
												value="${student.facultyId}" />
										</div>
										<div class="form-group">
											<label for="deparment">Giới tính :</label> <input type="text"
												class="form-control" name="gender" id="deparment"
												value="${student.gender}" />
										</div>
										<div class="form-group">
											<label for="deparment">Mã lớp :</label> <input type="text"
												class="form-control" name="studentClassId" id="deparment"
												value="${student.studentClassId}" />
										</div>
										<div class="form-group">
											<label for="deparment">Điện thoại :</label> <input
												type="text" class="form-control" name="phone" id="deparment"
												value="${student.phone}" />
										</div>

										<div class="form-check form-check-inline">
											<label for="status">Status:</label> <input id="statuson"
												class="form-check-input" type="radio" name="deleted"
												${student.deleted == 1 ?'checked':''} value="true">
											<label for="statuson" class="form-check-label">Hoạt
												động</label> <input id="statusoff" class="form-check-input"
												type="radio" name="deleted"
												${student.deleted == 0?'checked':''} value="false">
											<label for="statusoff" class="form-check-label">Khóa</label>
										</div>
										<br />
										<hr>
										<div class="form-group text-center">
											<button class="btn btn-info">
												Save <i class="fa fa-plus"></i>
											</button>

										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</div>