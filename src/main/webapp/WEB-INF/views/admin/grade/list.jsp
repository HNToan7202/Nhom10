<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<main id="main" class="main">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="row" style="margin: 0px;">
		<!-- Hiển thị thông báo -->
		<%@include file="/common/info.jsp"%>
		<!-- Kết thúc hiển thị thông báo -->
		<table class="table table-striped table-bordered table-hover"
			id="sample_2">
			<thead>
				<tr>
					<th>Mã điểm</th>
					<th>MSSV</th>
					<th>Điểm</th>
					<th>Mã môn học</th>
					<th>Trạng thái</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${grades}">
					<tr class="odd gradeX">
						<td>${item.id}</td>
						<td>${item.mssv}</td>
						<td>${item.grade}</td>
						<td>${item.subjectId}</td>
						<td>${item.deleted ==1?"Đang hoạt động" :"Tạm ngừng"}</td>
						<td><a href="<c:url value='/admin/grade/edit/${item.id}'/>"
							class="center">Edit</a> | <a
							href="<c:url value='/admin/grade/delete/${item.id}'/>"
							class="center">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="<c:url value='/admin/grade/add'/>" class="center">ADD</a>
		</div>
	</div>

</main>
