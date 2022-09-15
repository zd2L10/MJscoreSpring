<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav class="navbar navbar-dark bg-dark">
	<div class="container-fluid">
		<h4 class="navbar-brand">対局管理システム</h4>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarToggleExternalContent"
			aria-controls="navbarToggleExternalContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarToggleExternalContent">
			<div class="container-fluid mt-3">
				<ul class="nav-menu">
					<li class="nav-item dropdown text-end"><h5 class="text-light" ><c:out value="${user.login_id} " />さん</h5></li>
					<li class="nav-item dropdown text-end"><a class="nav-link text-danger"
						href="<%=request.getContextPath()%>/logout">ログアウト</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>