<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<%-- <div style="margin: 0px;">
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
								<form action="<c:url value="/admin/student/saveofUpdate"/>"
									method="post" enctype="multipart/form-data">
									<br />
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
											type="text" class="form-control" name="dateofbirth"
											value="${student.dateofbirth}" id="dateofbirth" />
									</div>
									<div class="form-group">
										<label for="images">Images:</label> <input type="file"
											class="form-control" name="image" id="image"
											value="${student.image}" />
									</div>

									<div class="form-group">
										<label for="email">Email sinh viên:</label> <input type="text"
											class="form-control" name="email" id="email"
											value="${student.email}" />
									</div>
									<div class="form-group">
										<label for="deparment">Chuyên ngành sinh viên:</label> <input
											type="text" class="form-control" name="deparment"
											id="deparment" value="${student.deparment}" />
									</div>

									<div class="form-check form-check-inline">
										<label for="status">Status:</label> <input id="statuson"
											class="form-check-input" type="radio" name="status"
											${student.status?'checked':''} value="true"> <label
											for="statuson" class="form-check-label">Hoạt động</label> <input
											id="statusoff" class="form-check-input" type="radio"
											name="status" ${!student.status?'checked':''} value="false">
										<label for="statusoff" class="form-check-label">Khóa</label>
									</div>
									<br />
									<hr>
									<div class="form-group">
										<button class="btn green">
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
</div> --%>

<div>
	<h1>Hello</h1>
</div>