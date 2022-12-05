<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="main">
	<h2>${message}</h2>
	<div class="" style="">
		<form:form action="/admin/user/saveofUpdate" method="POST"
			modelAttribute="user" enctype="multipart/form-data">
			<c:if test="${user.isEdit}">
		ID: <form:input path="id" readonly="true" />
				<br />
			</c:if>
			<c:if test="${!user.isEdit}">
		ID: <form:input path="id" />
				<br />
			</c:if>
	Username :<form:input path="username" />
			<br />
		Password :<form:input path="password" />
			<br />
		RoleId :<form:input path="roleid" />
			<br />
		Trạng thái :
		<form:radiobutton path="deleted" value="0" />Khóa <form:radiobutton
				path="deleted" value="1" />Hoạt động 
		<br />
			<button>Save</button>
		</form:form>
	</div>
</div>