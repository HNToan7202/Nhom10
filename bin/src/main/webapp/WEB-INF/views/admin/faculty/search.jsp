<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="row" style="margin: 0px;">
	<!-- Hiển thị thông báo -->
	<%@include file="/common/info.jsp"%>
	<div class="row mt-2 mb-2">
		<div class="col-md-6">
			<form action="/admin/faculty/search">
				<div class="input-group">
					<input type="text" class="form-control ml-2" name=name id="name"
						placeholder="Nhập từ khóa tìm kiếm" />
					<button class="btn btn-outline-primary ml-2">Search</button>
				</div>

			</form>
		</div>
		<div class="col-md-6">
			<form action="/admin/student/add">
				<div class="input-group">
					<button class="btn btn-outline-primary ml-2">New Student</button>
				</div>
			</form>
		</div>
	</div>
	<!-- Kết thúc hiển thị thông báo -->
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">
		<thead>
			<tr>
				<th>ID</th>
				<th>Tên Khoa</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${faculties}">
				<tr class="odd gradeX">
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td><a href="<c:url value='/admin/faculty/edit/${item.id}'/>"
						class="center">Edit</a> | <a
						href="<c:url value='/admin/faculty/delete/${item.id}'/>"
						class="center">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>