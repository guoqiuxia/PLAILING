<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Lei Shi">
<meta http-equiv="Cache-Control" content="o-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="csrf-token"
	content="1483758872##fd2cac389b2b7c009a744bcaecaa41d71592cfe8">
<title>upload3</title>
<link href="${ctx}/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/whir_grzx.css" rel="stylesheet" type="text/css" />

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link rel="stylesheet"
	href="${ctx}/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx}/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet" href="${ctx}/app/css/dest/styles.css?=2016121272249">
</head>
<body>
	<div id="header">
		<%@include file="header.jsp"%>
	</div>
	<div class="clear"></div>
	<div class="subbox">
		<!--左侧部分-->
		<%@include file="left.jsp"%>
		<!--右侧部分-->
		<div class="right840">
			<div class="title6">
				<h1>
					<a href="application.html" class="on">上传文件</a>
				</h1>
			</div>	
			<div class="display">
					<div class="title12">
						<img src="img/scimg3.jpg" />
					</div>
					<div class="win">
						<div class="sccg">
							<div class="cgimg">
								<img src="img/sccg.jpg" />
							</div>
							<div class="cginfo">							
								<p>上传成功,视频正在转码审核中</p>
								<p>
									<span>去<a href="#">上传课程</a>查看发布的视频 或
									</span> <a href="upload1.jsp"><input type="submit" value="继续上传"
										class="input8" /></a>
								</p>
							</div>
						</div>
					</div>
					<div class="spbcxx">
						<span>视频信息已经保存！</span>
					</div>
			</div>
		</div>
		<div class="clear" style="height: 38px;"></div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>