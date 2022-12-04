<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<main id="main" class="main">
	<td background="images/bg_title.gif">
		<table cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td width="42" align="center"><img border="0"
						src="/assets/img/grade.png" width="24" height="24"></td>
					<td width="300" align="left"><span
						id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lblThongbao"
						class="title">XEM ĐIỂM</span></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</td> <br>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div>
	<h5>Học Kỳ 2 / 2021 - 2022</h5>
		<div class="row" style="margin: 0px;">
			<!-- Hiển thị thông báo -->
			<%@include file="/common/info.jsp"%>
			<!-- Kết thúc hiển thị thông báo -->
			<table class="table table-striped table-bordered table-hover"
				id="sample_2">
				<thead>
					<tr>
						<th>Mã môn học</th>
						<!-- <th>Mã điểm</th> -->
						<!-- 					<th>MSSV</th> -->
						<th>Điểm</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${grades}">
						<tr class="odd gradeX">
							<td>${item.subjectId}</td>
							<%-- <td>${item.id}</td> --%>
							<%-- <td>${item.mssv}</td> --%>
							<td>${item.grade}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%-- 		<div>
			<a href="<c:url value='/admin/grade/add'/>" class="center">ADD</a>
		</div> --%>
		</div>
	</div>

</main>
