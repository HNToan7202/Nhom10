<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div style="padding-left: 220px;">
	<h2>${account.isEdit ? 'account lecture' : 'Add New account' }</h2>
	<form:form action="/account/saveofUpdate" method="POST"
		modelAttribute="account" enctype="multipart/form-data">
	Email : <form:input path="email" />
		<br />
	Password:  <form:input path="password" />
		<br />
	Phân quyền:
		<form:select path="role_id" items="${roles}" itemLabel="name"
			itemvalue="id">
		</form:select>
		<br />
		<form:radiobutton path="is_active" value="false" />Khóa <form:radiobutton
			path="is_active" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>