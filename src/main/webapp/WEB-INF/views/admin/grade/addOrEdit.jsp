<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<main id="main" class="main">
	<div class="" style="">
		<form:form action="/admin/grade/saveofUpdate" method="POST"
			modelAttribute="grade" enctype="multipart/form-data">
		ID: <form:input path="id" />
			<br />
		MSSV :<form:input path="mssv" />
			<br />
		Điểm :<form:input path="grade" />
			<br />
	Mã môn học :<form:input path="subjectId" />
			<br />
		Trạng thái :
		<form:radiobutton path="deleted" value="0" />Khóa <form:radiobutton
				path="deleted" value="1" />Hoạt động 
		<br />
			<button>Save</button>
		</form:form>
	</div>
</main>