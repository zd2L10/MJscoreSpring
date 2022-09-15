<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<title>対局記録</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-4 offset-lg-4">
				<h1 class="text-center mb-3">登録完了しました</h1>
				<p class="text-center">
					ログイン画面に戻り<br>操作を続けてください
				</p>

				<p class="text-center">
					<a href="<%=request.getContextPath()%>/login">ログイン画面に戻る</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>