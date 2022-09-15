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
	<c:import url="parts/commonJs.jsp" />
	<form action="" method="post" id="mj">
		<div class="container mt-3">
		<input type="hidden" name="title" id="hidden1"
						value="<c:out value="${title}" />">
			<h1>
				対局記録<c:out value="${title}" />
			</h1>
			<c:if test="${!empty errors}">
				<div class="alert alert-danger" role="alert">
					<c:forEach items="${errors}" var="error" varStatus="vs">
						<c:out value="${error}" />
						<c:out value="${vs.last ? '' : '<br>'}" escapeXml="false" />
					</c:forEach>
				</div>
			</c:if>
			<!-- <div class="row mt-5">
			<div class="col-2">
				<h4>局数</h4>
			</div>
			<div class="col-2">
				<select class="form-select">
					<option value="1">東風</option>
					<option value="2">半荘</option>
				</select>
			</div>
		</div> -->
			<div class="row mt-3">
				<div class="col-12 col-sm-3 col-md-2">
					<h4>プレイヤー</h4>
				</div>
				<div class="col-9">
					<table>
						<tr>
							<th><label for="east">東家</label></th>
							<td><c:choose>
									<c:when test="${derection == '東家'}">
										<input type="radio" name="derection" id="east" value="東家"
											checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" name="derection" id="east" value="東家">
									</c:otherwise>
								</c:choose></td>
							<td><input type="text" name="east_player" id="east_player"
								value="<c:out value="${east_player}" />"></td>
						</tr>
						<tr>
							<th><label for="south">南家</label></th>
							<td><c:choose>
									<c:when test="${derection == '南家'}">
										<input type="radio" name="derection" id="south" value="南家"
											checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" name="derection" id="south" value="南家">
									</c:otherwise>
								</c:choose></td>
							<td><input type="text" name="south_player" id="south_player"
								value="<c:out value="${south_player}" />"></td>
						</tr>
						<tr>
							<th><label for="west">西家</label></th>
							<td><c:choose>
									<c:when test="${derection == '西家'}">
										<input type="radio" name="derection" id="west" value="西家"
											checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" name="derection" id="west" value="西家">
									</c:otherwise>
								</c:choose></td>
							<td><input type="text" name="west_player" id="west_player"
								value="<c:out value="${west_player}" />"></td>
						</tr>
						<tr>
							<th><label for="north">北家</label></th>
							<td>
								<c:choose>
									<c:when test="${derection == '北家'}">
										<input type="radio" name="derection" id="north" value="北家"
											checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" name="derection" id="north" value="北家">
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<input type="text" name="north_player" id="north_player"
								value="<c:out value="${north_player}" />">
							</td>
						</tr>
					</table>
					<input type="hidden" name="user_id" id="hidden1"
						value="<c:out value="${user.id}" />"> 
					<input type="hidden"name="login_id" id="hidden2"
						value="<c:out value="${user.login_id}" />"> 
					<input type="hidden" name="result_id" id="hidden3"
						value="<c:out value="${result_id}" />">
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-12 col-sm-3 col-md-2">
					<h4>終局点数</h4>
				</div>
				<div class="col-9">
					<table>
						<tr>
							<th>東家</th>
							<td><input type="text" name="east_score" id="east_score"
								value="<c:out value="${east_score}" />">点</td>
						</tr>
						<tr>
							<th>南家</th>
							<td><input type="text" name="south_score" id="south_score"
								value="<c:out value="${south_score}" />">点</td>
						</tr>
						<tr>
							<th>西家</th>
							<td><input type="text" name="west_score" id="west_score"
								value="<c:out value="${west_score}" />">点</td>
						</tr>
						<tr>
							<th>北家</th>
							<td><input type="text" name="north_score" id="north_score"
								value="<c:out value="${north_score}" />">点</td>
						</tr>
					</table>
				</div>
			</div>
			<div>
				<p class="mt-3">
					この対局、あなたは
						<select name="rank">
						<c:choose>
						<c:when test="${rank == 1}">
						<option value="1" selected>1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
						</c:when>
						<c:when test="${rank == 2}">
						<option value="1" >1</option>
						<option value="2" selected>2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
						</c:when>
						<c:when test="${rank == 3}">
						<option value="1" >1</option>
						<option value="2" >2</option>
						<option value="3" selected>3</option>
						<option value="4" >4</option>
						</c:when>
						<c:when test="${rank == 4}">
						<option value="1" >1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" selected>4</option>
						</c:when>
						<c:otherwise>
						<option value="1" >1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
						</c:otherwise>	
					</c:choose>
					</select>位です
				</p>
				<%-- <input type="hidden" name="id" value="<c:out value="${result.id}" />"> --%>
			</div>
				<input type="submit" class="btn btn-primary mt-1 me-5" value="<c:out value="${title}"/>する">
				<a class="btn btn-secondary mt-1"
					href="<%=request.getContextPath()%>/result">一覧に戻る</a>
		</div>
	</form>
	<!-- <script>
	$(document).ready(function(){
		$('input[name="derection"]').change(function(){
			const user = $('#hidden2').val();
			$(this).parent().next().children().attr('value', user);
		});
	});
	</script>  -->
	<script>
	
	var currentId = "";
	var previousId = "";
	
	function UpdateState(){

		/*
		value = $("#east").prop("checked");
		if(value == false){
			$("#east_player").val('');
		}
		value = $("#south").prop("checked");
		if(value == false){
			$("#south_player").val('');
		}
		value = $("#west").prop("checked");
		if(value == false){
			$("#west_player").val('');
		}
		value = $("#north").prop("checked");
		if(value == false){
			$("#north_player").val('');
		}
		*/
	}
	
	$(document).ready(function(){
		
		$('input[name="derection"]').change(function(){
			const user = $('#hidden2').val();

			/*   if($('#east_player').val() != user){
				var east = $('#east_player').val();
			}
			if($('#south_player').val() != user){
				var south = $('#south_player').val();
			}
			if($('#west_player').val() != user){
				var west = $('#west_player').val();
			}
			if($('#north_player').val() != user){
				var north = $('#north_player').val();
			}
			
			$("#east_player").val(east);
			$("#south_player").val(south);
			$("#west_player").val(west);
			$("#north_player").val(north); */  
			$(this).parent().next().children().val(user);
			previousId = currentId;
			currentId = $(this).attr('id');
			$("#" + previousId + "_player").val('');
			/* $('input[name="derection"]').change(function(){
				
			}) */
		});
		
	});
	</script>
		

</body>
</html>