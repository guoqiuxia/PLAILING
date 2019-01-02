<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function pleaseLogin() {
		$.ajax({
					url : '${ctx}/pleaseLogin',
					type : 'post',
					asyn : false,
					success : function(result) {
						if (result == "fail") {
							alert("请登录再查看");
						} else {
							document.getElementById("personCenter").href = '${ctx}/left';
							window.location.href='${ctx}/left';
						}
					}
				})
	}
</script>

<nav class="navbar navbar-default navbar-fixed-top header">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#header-navbar-collapse"
				aria-expanded="false">
				<span class="sr-only">e享课堂</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ctx }/index.jsp"> <img src="${ctx }/img/logo.png"
				width="90px" height="50px">
			</a>
		</div>
		<div class="collapse navbar-collapse" id="header-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class=""><a href="${ctx }/courseListAll">课程</a></li>
				<li class=""><a href="#" onclick="pleaseLogin()" id="personCenter">个人中心</a></li>
				<li class=""><a href="${ctx }/demand">需求热搜</a></li>
				<li class=""><a href="${ctx }/aboutus.jsp">关于我们</a></li>

			</ul>


			<c:if test="${loginFlag=='0'}">
				<div class="navbar-right btns" id="loginhidden">
					<a class="btn btn-default navbar-btn sign-in" data-sign="signin"
						href="${ctx }/#sign-modal" data-toggle="modal">登录</a> <a
						class="btn btn-default navbar-btn sign-up" data-sign="signup"
						href="${ctx }/#sign-modal" data-toggle="modal">注册</a>
				</div>
			</c:if>
			
			<c:if test="${loginFlag=='1'}">
				<div class="navbar-right btns" id="loginshow" style="float:right;">
					<img src="${ctx }/${user.photo}" style="width: 35px; height: 35px" href="${ctx }/#">
					<a class="btn btn-default navbar-btn sign-up" href="${ctx }/quit">退出</a>
				</div>
			</c:if>



		</div>
	</div>
</nav>


