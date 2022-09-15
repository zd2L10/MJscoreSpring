<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:import url="parts/commonCss.jsp" />
<title>対局記録</title>
</head>
<body>
<c:import url="navbar.jsp" />
	<div class="container mt-3">
		<h1>対局記録詳細</h1>
		<div id="table-view" class="toggle-display col-12 mt-5">
			<table class="table table-bordered table-hover text-center">
					
					<c:choose>
					
						<%-- ユーザーが東家の場合 --%>
						<c:when test="${user.login_id == result.east_player}">
						<thead>
							<tr>
								<th>順位</th>

								<th><c:out value="${result.east_player}" /></th>
								<th><c:out value="${result.south_player}" /></th>
								<th><c:out value="${result.west_player}" /></th>
								<th><c:out value="${result.north_player}" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><c:out value="${result.rank}" />位</td>
								<td>東家&emsp;<c:out value="${result.east_score}" />点
								</td>
								<td>南家&emsp;<c:out value="${result.south_score}" />点
								</td>
								<td>西家&emsp;<c:out value="${result.west_score}" />点
								</td>
								<td>北家&emsp;<c:out value="${result.north_score}" />点
								</td>
							</tr>
						</tbody>
					</c:when>
					
					<%-- ユーザーが南家の場合 --%>
					<c:when test="${user.login_id == result.south_player}">
						<thead>
							<tr>
								<th>順位</th>

								<th><c:out value="${result.south_player}" /></th>
								<th><c:out value="${result.west_player}" /></th>
								<th><c:out value="${result.north_player}" /></th>
								<th><c:out value="${result.east_player}" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><c:out value="${result.rank}" />位</td>
								<td>南家&emsp;<c:out value="${result.south_score}" />点
								</td>
								<td>西家&emsp;<c:out value="${result.west_score}" />点
								</td>
								<td>北家&emsp;<c:out value="${result.north_score}" />点
								</td>
								<td>東家&emsp;<c:out value="${result.east_score}" />点
								</td>
							</tr>
						</tbody>
					</c:when>
					
					<%-- ユーザーが西家の場合 --%>
					<c:when test="${user.login_id == result.west_player}">
						<thead>
							<tr>
								<th>順位</th>

								<th><c:out value="${result.west_player}" /></th>
								<th><c:out value="${result.north_player}" /></th>
								<th><c:out value="${result.east_player}" /></th>
								<th><c:out value="${result.south_player}" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><c:out value="${result.rank}" />位</td>
								<td>西家&emsp;<c:out value="${result.west_score}" />点
								</td>
								<td>北家&emsp;<c:out value="${result.north_score}" />点
								</td>
								<td>東家&emsp;<c:out value="${result.east_score}" />点
								</td>
								<td>南家&emsp;<c:out value="${result.south_score}" />点
								</td>
							</tr>
						</tbody>
					</c:when>
					
					
					<c:otherwise>
					<%-- ユーザーが北家の場合 --%>
						<thead>
							<tr>
								<th>順位</th>

								<th><c:out value="${result.north_player}" /></th>
								<th><c:out value="${result.east_player}" /></th>
								<th><c:out value="${result.south_player}" /></th>
								<th><c:out value="${result.west_player}" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><c:out value="${result.rank}" />位</td>
								<td>北家&emsp;<c:out value="${result.north_score}" />点
								</td>
								<td>東家&emsp;<c:out value="${result.east_score}" />点
								</td>
								<td>南家&emsp;<c:out value="${result.south_score}" />点
								</td>
								<td>西家&emsp;<c:out value="${result.west_score}" />点
								</td>
							</tr>
						</tbody>
						</c:otherwise>
						</c:choose>
			</table>
		</div>
			<a class="btn btn-warning me-5"
				href="<%=request.getContextPath()%>/fixresult?detail_id=<c:out value="${result.id}"/>">修正する</a>
			<a class="btn btn-secondary"
				href="<%=request.getContextPath()%>/result">一覧に戻る</a>
		</div>
	<c:import url="parts/commonJs.jsp" />
</body>
</html>