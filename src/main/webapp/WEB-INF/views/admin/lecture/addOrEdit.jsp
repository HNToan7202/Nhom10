<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="main">
	<div style="margin: 0px;">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet">
			<div class="portlet-title">
				<div class="caption">
					<h2 class="text-center">${lecture.isEdit ? 'Edit Lecture' : 'Add New Lecture' }</h2>
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
									<form action="<c:url value="/admin/lecture/saveofUpdate"/>"
										method="post" enctype="multipart/form-data">
										<br />
										<div class="form-group">
											<label for="UserID">ID:</label> <input type="text" name="id"
												value="${lecture.id}" id="id" class="form-control" />
										</div>
										<div class="form-group">
											<label for="UserID">Tên đăng nhập:</label> <input type="text"
												name="username" value="${lecture.username}" id="username"
												class="form-control" />
										</div>

										<div class="form-group">
											<label for="categoryName">Họ và tên:</label> <input
												type="text" class="form-control" name="name" id="name"
												value="${lecture.name}" />
										</div>
										<div class="form-group">
											<label for="categoryCode">Ngày Sinh:</label> <input
												type="date" class="form-control" name="dob"
												value="${lecture.dob}" id="dob" />
										</div>
										<div class="form-group">
											<label for="images">Images:</label> <input type="file"
												class="form-control" name="imageFile" id="imageFile" />
										</div>
										<input type="text" class="form-control" name="image"
											id="image" value="${lecture.image}" hidden="true" />
										<div class="form-group">
											<label for="email">Địa chỉ :</label> <input type="text"
												class="form-control" name="address" id="address"
												value="${lecture.address}" />
										</div>
										<div class="form-group">
											<label for="deparment">Khoa :</label> <input type="text"
												class="form-control" name="facultyId" id="deparment"
												value="${lecture.facultyId}" />
										</div>
										<div class="form-group">
											<label for="deparment">Giới tính :</label> <input type="text"
												class="form-control" name="gender" id="deparment"
												value="${lecture.gender}" />
										</div>

										<br>


										<div class="form-check form-check-inline"
											style="display: flex; justify-content: space-evenly;">
											<label for="status">Status:</label> <label for="statuson"
												class="form-check-label">Hoạt động</label> <input
												id="statuson" class="form-check-input" type="radio"
												name="deleted" ${lecture.deleted == 1 ?'checked':''}
												value="true"> <label for="statusoff"
												class="form-check-label">Khóa</label> <input id="statusoff"
												class="form-check-input" type="radio" name="deleted"
												${lecture.deleted == 0?'checked':''} value="false">
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

<%-- <div class="" style="">
	<h2>${student.isEdit ? 'Edit Student' : 'Add New Student' }</h2>
	<form:form action="/admin/student/saveofUpdate" method="POST"
		modelAttribute="student" enctype="multipart/form-data">
	
	Mã số sinh viên: <form:input path="mssv" />
		<br />
	Họ tên :<form:input path="name" />
		<br />
	Email : <form:input path="email" />
		<br />
	Ngày sinh : <form:input path="dateofbirth" />
		<br />
	Chuyên ngành : <form:input path="faculty" />
		<br />
		<form:hidden path="image" />
		<input type="file" name="imageFile" />
		<br />
		<form:radiobutton path="is_active" value="false" />Khóa <form:radiobutton
			path="is_active" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div> --%>