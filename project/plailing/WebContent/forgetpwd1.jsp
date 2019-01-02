<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Author" contect="http://www.webqin.net">
<title>忘记密码</title>
<link rel="shortcut icon" href="${ctx }/images/favicon.ico" />
<link type="text/css" href="${ctx }/css/css.css" rel="stylesheet" />
<link rel="shortcut icon" href="${ctx }/favicon.ico">
<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx }/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css?=2016121272249">
<link href="${ctx }/css/whir_grzx.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	//导航定位
	$(function() {
		// $(".nav li:eq(2) a:first").addClass("navCur")
		//验证手机 邮箱 
		$(".selyz").change(function() {
			var selval = $(this).find("option:selected").val();
			if (selval == "0") {
				$(".sel-yzyx").hide()
			} else if (selval == "1") {
				$(".sel-yzyx").show()
			}
		})
	})
	function sendEmailSucess(){
		var email = $('#personemail').val();
		$.ajax({
			url:'forgetPwd',
			data:{
				'email':email
			},
			type:'post',
			asyn:false,
			success:function(result){
				if(result=="ok"){
					alert("发送成功请到邮箱验证");
				}
				if(result=="fail1"){
					document.getElementById("emailSpan").innerHTML = "请填写邮箱";
				}
				if(result=="fail2"){
					document.getElementById("emailSpan").innerHTML = "邮箱未注册";
				}
				if(result=="fail"){
					alert("发送不成功请重新发送");
				}
			}
		})
	}
	function checkEmail(){
		var email = $('#personemail').val();
		$.ajax({
			url:'checkEmail',
			data:{
				'email':email
			},
			type:'post',
			asyn:false,
			success:function(result){
				if(result=="fail"){
					document.getElementById("emailSpan").innerHTML = "邮箱未注册";
				}
				if(result=="fail1"){
					document.getElementById("emailSpan").innerHTML = "请填写邮箱";
				}
				if(result=="ok"){
					document.getElementById("emailSpan").innerHTML = "";
				}
			}
		})
	}
</script>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="content">
		<div class="web-width" style="margin-top: 68px;">
			<div class="for-liucheng" style="margin-left:350px">
				<div class="liulist for-cur" style="background: #11aa8c;"></div>
				<div class="liulist"></div>
				<div class="liulist"></div>
				<div class="liutextbox">
					<div class="liutext for-cur">
						<em style="background: #11aa8c;">1</em><br />
						<strong style="color: #11aa8c;">验证身份</strong>
					</div>
					<div class="liutext for-cur">
						<em style="background: #ccc;">2</em><br />
						<strong style="color: black;">设置新密码</strong>
					</div>
					<div class="liutext">
						<em>3</em><br />
						<strong>完成</strong>
					</div>
				</div>
			</div>
			<!--for-liucheng/-->
			<form class="forget-pwd" style="margin-left:400px">
				<dl class="sel-yzyx">
					<dt>邮箱：</dt>
					<dd>
						<input type="text" id="personemail" onblur="checkEmail()"/>
						<span id="emailSpan" style="font-size:12px;color:red"></span>
					</dd>
					<div class="clears"></div>
				</dl>
				<div >
					<input style="background: #11aa8c; color: white;margin-left:143px;" type="button"
						value="发送" class="input8" onclick="sendEmailSucess()"/>
				</div>
			</form>
			<!--forget-pwd/-->
		</div>
		<!--web-width/-->
	</div>
	<!--content/-->
	<%@include file="footer.jsp"%>
</body>
</html>