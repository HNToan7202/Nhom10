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
				<th>Ngày bắt đầu</th>
				<th>Ngày kết thúc</th>
				<th>Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${timeresgiter}">
				<tr class="odd gradeX">
					<td>${item.create_at}</td>
					<td>${item.finish_at}</td>
					<td><a
						href="<c:url value='/admin/project/time/edit/${item.id}'/>"
						class="center">Edit</a> | <a
						href="<c:url value='/admin/project/time/delete/${item.id}'/>"
						class="center">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
