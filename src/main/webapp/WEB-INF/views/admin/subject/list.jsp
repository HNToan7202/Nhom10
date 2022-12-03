<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row" style="margin: 0px;">
	<!-- Hiển thị thông báo -->
	<%@include file="/common/info.jsp"%>
	<!-- Kết thúc hiển thị thông báo -->
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">
		<thead>
			<tr>
				<th>Mã môn</th>
				<th>Tên môn</th>
				<th>Số tín chỉ</th>
				<th>Trạng thái</th>
				<th>Chức năng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${subjects}">
				<tr class="odd gradeX">
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.credits}</td>
					<td>${item.deleted ==1?"Đang hoạt động" :"Tạm ngừng"}</td>
					<td><a href="<c:url value='/admin/subject/edit/${item.id}'/>"
						class="center">Edit</a> | <a
						href="<c:url value='/admin/subject/delete/${item.id}'/>"
						class="center">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="<c:url value='/admin/subject/add'/>" class="center">ADD</a>
	</div>
</div>
