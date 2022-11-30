<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Taọ đợt đăng ký đề tài</h2>
	<form action="/admin/project/time/saveOrUpdate" method="POST"
		enctype="multipart/form-data">
		<input type="text" value="${id}" name ="id" hidden="true">
		<label for="create_at">Ngày bắt đầu chọn đề tài</label>
		<input type="date" id="create_at" value="${create_at}" name = "create_at">
		<label for="finish_at">Ngày hết hạn chọn đề tài</label>
		<input type="date"id="finish_at" name = "finish_at" value="${finish_at}">
		<input type="submit" value="Save">
		</form>

</body>
</html>