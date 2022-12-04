<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="main">
	<td background="images/bg_title.gif">
		<table cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td width="42" align="center"><img border="0"
						src="/assets/img/chart.png" width="24" height="24"></td>
					<td width="300" align="left"><span
						id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lblThongbao"
						class="title">THỐNG KÊ </span></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</td> <br>
	<div class="col-lg-10">
		<div class="card">
			<div class="card-body">
				<br>
				<hr class="sidebar-divider">
				<h6>Tổng số môn : 10</h6>
				<hr class="sidebar-divider">



				<!-- Pie Chart -->
				<div id="pieChart"></div>

				<script>
                document.addEventListener("DOMContentLoaded", () => {
                  new ApexCharts(document.querySelector("#pieChart"), {
                    series: [44, 55],
                    chart: {
                      height: 350,
                      type: 'pie',
                      toolbar: {
                        show: true
                      }
                    },
                    labels: ['Môn Trên 5', 'Môn Dưới 5']
                  }).render();
                });
              </script>
				<!-- End Pie Chart -->

			</div>
		</div>
	</div>
</div>