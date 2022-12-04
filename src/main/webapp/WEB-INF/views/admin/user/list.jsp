<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="main">
	<div class="row" style="margin: 0px;">
		<!-- Hiển thị thông báo -->
		<%@include file="/common/info.jsp"%>
		<!-- Kết thúc hiển thị thông báo -->

		<table class="table table-striped table-bordered table-hover"
			id="sample_2">
			<thead>
				<tr>
					<th>Mã khoa</th>
					<th>Username</th>
					<th>Password</th>
					<th>roleid</th>
					<th>Trạng thái</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${users}">
					<tr class="odd gradeX">
						<td>${item.id}</td>
						<td>${item.username}</td>
						<td>${item.password}</td>
						<td>${item.roleid}</td>
						<td>${item.deleted ==1?"Đang hoạt động" :"Tạm ngừng"}</td>
						<td><a href="<c:url value='/admin/user/edit/${item.id}'/>"
							class="center">Edit</a> | <a
							href="<c:url value='/admin/user/delete/${item.id}'/>"
							class="center">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>