<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="main">
	<div class="" style="">
		<form:form action="/admin/faculty/saveofUpdate" method="POST"
			modelAttribute="faculty" enctype="multipart/form-data">
			<form:input path="id" />
			<br />
	Tên khoa :<form:input path="name" />
			<br />
		Trạng thái :
		<form:radiobutton path="deleted" value="0" />Khóa <form:radiobutton
				path="deleted" value="1" />Hoạt động 
		<br />
			<button>Save</button>
		</form:form>
	</div>
</div>