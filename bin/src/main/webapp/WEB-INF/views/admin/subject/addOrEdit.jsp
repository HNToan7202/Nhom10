<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<h2>${message}</h2>
<div class="" style="">
	<form:form action="/admin/subject/saveofUpdate" method="POST"
		modelAttribute="subject" enctype="multipart/form-data">
		<c:if test="${subject.isEdit}">
		ID: <form:input path="id" readonly="true" />
			<br />
		</c:if>
		<c:if test="${!subject.isEdit}">
		ID: <form:input path="id" />
			<br />
		</c:if>
	name :<form:input path="name" />
		<br />
		credits :<form:input path="credits" />
		<br />
		Trạng thái :
		<form:radiobutton path="deleted" value="0" />Khóa <form:radiobutton
			path="deleted" value="1" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>