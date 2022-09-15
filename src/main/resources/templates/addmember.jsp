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
				<form action="" method="post">
					<h1 class="text-center mb-3">
						対局記録管理<br>新規登録
					</h1>
					<c:if test="${!empty errors}">
						<div class="alert alert-danger" role="alert">
							<c:forEach items="${errors}" var="error" varStatus="vs">
								<c:out value="${error}" />
								<c:out value="${vs.last ? '' : '<br>' }" escapeXml="false" />
							</c:forEach>
						</div>
					</c:if>


					<div class="form-floating">
						<input type="text" name="login_id" class="form-control"
							id="floatingInput" placeholder="ログインID"> <label
							for="floatingInput">ログインID</label>
					</div>
					<div class="form-floating">
						<input type="password" name="login_pass" class="form-control"
							id="floatingPassword" placeholder="パスワード"> <label
							for="floatingInput">パスワード</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" name="confpass" class="form-control"
							id="floatingconfPass" placeholder="パスワード(確認用)"> <label
							for="floatingInput">パスワード(確認用)</label>
					</div>

					<input type="submit" class="btn btn-lg btn-primary w-100 mb-3"
						value="新規登録"> <a
						href="<%=request.getContextPath()%>/login"
						class="btn btn-lg btn-secondary w-100">ログイン画面に戻る</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>