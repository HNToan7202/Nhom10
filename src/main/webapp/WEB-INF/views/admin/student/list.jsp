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
				<th>Mã số sinh viên</th>
				<th>Họ tên</th>
				<th>Ảnh đại diện</th>
				<th>Ngày sinh</th>
				<th>Email</th>
				<th>Chuyên ngành</th>
				<th>Trạng thái</th>
				<th>Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${students.content}">
				<tr class="odd gradeX">
					<td>${item.mssv}</td>
					<td>${item.name}</td>
					<td><c:url value="/images/${item.image}" var="imgUrl"></c:url>
						<img width="100px" height="100px" name="imageFile" src="${imgUrl}"></td>
					<td>${item.dateofbirth}</td>
					<td>${item.email}</td>
					<td>${item.faculty}</td>
					<td><c:if test="${item.is_active == true}">
							<span class="label label-sm label-success"> Hoạt động </span>
						</c:if> <c:if test="${item.is_active ==false}">
							<span class="label label-sm label-warning"> Khóa</span>
						</c:if></td>
					<td><a
						href="<c:url value='/admin/student/edit/${item.mssv}'/>"
						class="center">Edit</a> | <a
						href="<c:url value='/admin/student/delete/${item.mssv}'/>"
						class="center">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="d-flex justify-content-center" style="width: 100%;">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${students.number>0}">
					<li class="page-item"><a class="page-link"
						href="/admin/student?p=${students.number-1}">Previous</a></li>
				</c:if>
				<c:forEach begin="1" end="${students.totalPages-1}" var="i">
					<li class="page-item ${students.number==i? 'active':'' }"><a
						class="page-link" href="/admin/student?p=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${students.number < (students.totalPages-1)}">
					<li class="page-item"><a class="page-link"
						href="/admin/student?p=${students.number + 1}">Next</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>