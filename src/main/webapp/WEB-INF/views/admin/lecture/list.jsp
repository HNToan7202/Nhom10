<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="row" style="margin: 0px;">
	<!-- Hiển thị thông báo -->
	<%@include file="/common/info.jsp"%>
	<!-- Kết thúc hiển thị thông báo -->
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">
		<thead>
			<tr>
				<th>Tên đăng nhập</th>
				<th>Họ tên</th>
				<th>Ảnh đại diện</th>
				<th>Ngày sinh</th>
				<th>Địa chỉ</th>
				<th>Giới tính</th>
				<th>Điện thoại</th>
				<th>Khoa</th>
				<th>Trạng thái</th>
				<th>Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${lectures}">
				<tr class="odd gradeX">
					<td>${item.username}</td>
					<td>${item.name}</td>
					<td><c:url value="${item.image}" var="imgUrl"></c:url> <img
						width="100px" height="100px" src="${imgUrl}"></td>
					<td>${item.dob}</td>
					<td>${item.address}</td>
					<td>${item.gender}</td>
					<td>${item.phone}</td>
					<td>${item.facultyId}</td>
					<td><c:if test="${item.deleted == 1}">
							<span class="label label-sm label-success"> Hoạt động </span>
						</c:if> <c:if test="${item.deleted ==0}">
							<span class="label label-sm label-warning"> Khóa</span>
						</c:if></td>
					<td><a href="<c:url value='/admin/lecture/edit/${item.id}'/>"
						class="center">Edit</a> | <a
						href="<c:url value='/admin/lecture/delete/${item.id}'/>"
						class="center">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value='/admin/lecture/add'/>" class="center">Add</a>
</div>