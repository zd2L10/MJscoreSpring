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
	<div class="container mt-5">
		<div class="row">
			<div>
				<h1 class="text-center mb-3"><c:out value="${donetitle}" />完了しました</h1>

				<div class="row mt-5 justify-content-evenly">
					<div class="col-5 text-end">
						<a class="btn btn-secondary"
							href="<%=request.getContextPath()%>/result">一覧に戻る</a>
					</div>
					<div class="col-6 offset-1">
						<a class="btn btn-warning"
							href="<%=request.getContextPath()%>/addresult" >続けて結果を入力する</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="parts/commonJs.jsp" />
</body>
</html>