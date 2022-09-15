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
		<h1>対局記録一覧</h1>
		<div class="row mt-3">
			<div>
				<a class="btn btn-success"
					href="<%=request.getContextPath()%>/addresult">対局記録の登録</a>
			</div>
			<!-- <div class="col-4">
				<table>
					<tr>
						<th>ルール切り替え</th>
						<th><select class="form-select">
								<option value="1">東風</option>
								<option value="2">半荘</option>
						</select></th>
					</tr>
				</table>
			</div> -->
		</div>
		<div class="row mt-5">
			<div class="col-12">
				<!-- <ul class="nav nav-pills">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#tabel-view">テーブル表示</a></li>
					<li class="nav-item"><a class="nav-link"
						href="#scoregraph-view">順位の変遷</a></li>
					<li class="nav-item"><a class="nav-link" href="#avescore-view">平均順位</a>
					</li>
				</ul> -->

				<div id="table-view" class="toggle-display col-12 mt-3">
					<table class="table table-bordered table-hover text-center">
						<thead>
							<tr>
								<th class="col-3">日付</th>
								<th class="col-3">開始位置</th>
								<th class="col-3">対局順位</th>
								<th class="col-3">情報の編集</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty results}">
								<tr>
									<td colspan="9">記録はありません</td>
								</tr>
							</c:if>
							<c:forEach items="${results}" var="result">
								<tr>
									<td><fmt:formatDate value="${result.time}"
											pattern="y/MM/dd HH:mm:ss" /></td>
									<td><c:out value="${result.derection}" /></td>
									<td><c:out value="${result.rank}" />位</td>
									<td><a class="btn btn-warning me-lg-3"
										href="<%=request.getContextPath()%>/resultdetail?detail_id=<c:out value="${result.id}" />">詳細</a>
										<a class="btn btn-danger delete ms-lg-3" data-bs-toggle="modal"
										data-bs-target="#deleteModal" data-role="deleteResult"
										data-resultToDelete="<fmt:formatDate value="${result.time}" pattern="y/MM/dd HH:mm:ss" />"
										href="<%=request.getContextPath()%>/deleteresult?delete_id=<c:out value="${result.id}" />">削除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="scoregraph-view" class="toggle-display hide">
					<canvas id="score-chart"></canvas>
				</div>
				<div id="avescore-view" class="toggle-display hide">
					<canvas id="average-chart"></canvas>
				</div>
			</div>
		</div>
	</div>
	<!-- 削除モーダル -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLabel">記録の削除</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					「<span id="modal-date"></span>」の記録を削除しますか？
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">キャンセル</button>
					<a class="btn btn-danger" id="delete-link" href="">削除する</a>
				</div>
			</div>
		</div>
	</div>

	<c:import url="parts/commonJs.jsp" />
	<!-- 削除ボタン -->
	<script>
		$(document).ready(function() {
			$('[data-role="deleteResult"]').click(function() {
				$('#modal-date').text($(this).attr('data-resultToDelete'));
				$('#delete-link').attr('href', $(this).attr('href'));
			});
		});
	</script>
</body>
</html>