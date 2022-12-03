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
				<th>Tiêu đề</th>
				<th>Ngày gửi</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${notifies}">
				<tr class="odd gradeX">
					<td>${item.name}</td>
					<td>${item.createDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>