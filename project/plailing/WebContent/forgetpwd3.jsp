<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Cache-Control" content="o-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="csrf-token"
	content="1483758872##fd2cac389b2b7c009a744bcaecaa41d71592cfe8">
<title>忘记密码</title>
<link type="text/css" href="${ctx }/css/css.css" rel="stylesheet" />


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
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="clear"></div>
	<div class="content">
		<div class="web-width" style="margin-top: 68px;">
			<div class="for-liucheng" style="margin-left:350px">
				<div class="liulist for-cur" style="background: #11aa8c;"></div>
				<div class="liulist for-cur" style="background: #11aa8c;"></div>
				<div class="liulist for-cur" style="background: #11aa8c;"></div>
				<div class="liutextbox">
					<div class="liutext for-cur">
						<em style="background: #11aa8c;">1</em><br /> <strong
							style="color: #11aa8c;">验证身份</strong>
					</div>
					<div class="liutext for-cur">
						<em style="background: #11aa8c;">2</em><br /> <strong
							style="color: #11aa8c;">设置新密码</strong>
					</div>
					<div class="liutext for-cur">
						<em style="background: #11aa8c;">3</em><br/> <strong
							style="color: #11aa8c;">完成</strong>
					</div>
				</div>
			</div>
			<div class="successs" style="margin-left:0px">
				<h3 style="color: #11aa8c;">恭喜您，修改成功！</h3>
				<br/><a href="${ctx }/index.jsp"><input
					style="background: #11aa8c; color: white;margin-right:17px;"
					type="submit" value="快速登录" class="input8" /></a>
			</div>
		</div>
	</div>
	<!--content/-->
	<%@include file="footer.jsp"%>
</body>
</html>