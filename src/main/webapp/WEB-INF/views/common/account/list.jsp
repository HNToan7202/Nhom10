<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="row" style="margin: 0px;">
	<!-- Hiển thị thông báo -->
	<%@include file="/common/info.jsp"%>
	<!-- Kết thúc hiển thị thông báo -->

	<div style="padding-left: 220px;">
		<table class="table table-striped table-bordered table-hover"
			id="sample_2">
			<thead>
				<tr>
					<th>Email</th>
					<th>password</th>
					<th>Phân quyền</th>
					<th>Trạng thái</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${accounts.content}">
					<tr class="odd gradeX">
						<td>${item.email}</td>
						<td>${item.password}</td>
						<c:if test="${item.role_id >2}">
						<td>${item.role_id==3?'Lecture':'Leader Lecture'}</td>
						</c:if>
						<c:if test="${item.role_id <= 2}">
						<td>${item.role_id==1?'Admin':'Student'}</td>
						</c:if>
						<td><c:if test="${item.is_active == true}">
								<span class="label label-sm label-success"> Hoạt động </span>
							</c:if> <c:if test="${item.is_active ==false}">
								<span class="label label-sm label-warning"> Khóa</span>
							</c:if></td>
						<td><a href="<c:url value='/account/edit/${item.email}'/>"
							class="center">Edit</a> | <a
							href="<c:url value='account/delete/${item.email}'/>"
							class="center">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <div class="d-flex justify-content-center" style="width: 100%;">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${accounts.number>0}">
					<li class="page-item"><a class="page-link"
						href="/admin/student?p=${accounts.number-1}">Previous</a></li>
				</c:if>
				<c:if test="${accounts>0}">
					<c:forEach begin="1" end="${accounts.totalPages-1}" var="i">
						<li class="page-item ${accounts.number==i? 'active':'' }"><a
							class="page-link" href="/admin/student?p=${i}">${i}</a></li>
					</c:forEach>
				</c:if>
				<c:if test="${accounts.number < (accounts.totalPages-1)}">
					<li class="page-item"><a class="page-link"
						href="/admin/student?p=${accounts.number + 1}">Next</a></li>
				</c:if>
			</ul>
		</nav>
	</div> --%>
	</div>
</div>