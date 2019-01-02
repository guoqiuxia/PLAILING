<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html>
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
<title>relate</title>
<link href="${ctx }/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/whir_grzx.css" rel="stylesheet" type="text/css" />

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

</head>
<body>
	<!--头部-->
	<div id="header">
		<%@include file="header.jsp"%>
	</div>
	<div class="clear"></div>
	<!--container-->
	<div class="subbox">
		<!--左侧部分-->
		<%@include file="left.jsp"%>
		<!--右侧部分-->
		<div class="right840">
			<div class="title6">
				<h1>
					<a href="${ctx }/relate">课程更新</a>
				</h1>
				<h1>
					<a href="${ctx }/release">审核通知</a>
				</h1>
				<h1>
					<a href="${ctx }/demandinform" class="on">需求更新</a>
				</h1>
			</div>
			<div class="display">
				<div>
				<c:forEach var="demand" items="${listDemand }">
				<c:forEach var="course" items="${demand.courses }">
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx }/courseDetail?courseId=${course.courseId}"><span style="color: #333; font-size: 16px;">您的${demand.text }的需求发布了新${course.name },您可以进入学习</span></a>

					</p>
				</c:forEach>
				</c:forEach>
				</div>
				<div class="pagination-container pagemiddle">
					<span class="wordstyle disabled">共${pageDemand.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
					<a class="wordstyle disabled" href="demandinform?pageNum=1">首页</a> &nbsp;&nbsp;&nbsp;<a class="wordstyle disabled"
						href="demandinform?pageNum=${pageDemand.prePageNum }">上一页</a>&nbsp;&nbsp;&nbsp; <a class="wordstyle disabled"
						href="demandinform?pageNum=${pageDemand.nextPageNum }">下一页</a> &nbsp;&nbsp;&nbsp;<a class="wordstyle disabled"
						href="demandinform?pageNum=${pageDemand. totalPageNum}">末页</a>
				</div>
			</div>
		</div>
	</div>
	<div class="clear" style="height: 7px;"></div>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>