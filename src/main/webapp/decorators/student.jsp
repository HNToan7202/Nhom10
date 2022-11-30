<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources/" var="URL"></c:url>
<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>QUẢN LÝ ĐỀ TÀI</title>

<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">

<link href="${URL}css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/common/student/header.jsp"%>
	<%@ include file="/common/student/slidebar.jsp"%>
	<!-- body -->
	<sitemesh:write property='body'></sitemesh:write>
	<!-- body -->

	<!--=== Footer v4 ===-->
	<jsp:include page="/common/student/footer.jsp"></jsp:include>
	<!--=== End Footer v4 ===-->

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min	.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="resources/js/script.js" type="text/javascript"></script>
</body>
</html>