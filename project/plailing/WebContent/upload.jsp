<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>upload</title>
<link href="${ctx}/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/whir_grzx.css" rel="stylesheet" type="text/css" />

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link rel="stylesheet"
	href="${ctx}/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx}/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/dest/styles.css?=2016121272249">

</head>
<body>
	<div id="header">
		<%@include file="header.jsp"%>
	</div>
	<!--container-->
	<div class="subbox">
		<%@include file="left.jsp"%>
		<!--右侧部分-->
		<div class="right840">
			<div class="title6">
				<h1>
					<a href="${ctx}/upload" class="on">上传课程</a>
				</h1>
			</div>
			<div>

				<div class="videoinfo2">
					<!-- <div class="left502"> -->
					<div class="tab-pane active" id="labs">
						<c:forEach items="${courseList}" var="cl">
							<div class="lab-item ">
								<div class="lab-item-title" title="Linux 系统简介">${cl.name}</div>
								<div class="pull-right lab-item-ctrl">
									<a href="${ctx}/applicationSite?courseId=${cl.courseId}"><input
										type="submit" value="申请场地" class="input8"></a> <a href="#"><input
										type="submit" value="申请直播" class="input8"></a> <a
										href="${ctx}/upload1/upload2?courseId=${cl.courseId}"><input type="submit" value="继续上传"
										class="input8"></a>
								</div>
							</div>
						</c:forEach>

						
					</div>
					<div>
						<a href="${ctx}/findFirstType">
							<button class="input8">
								<font size="3px">创建课程</font>
							</button>
						</a>
					</div>
					<div class="pagination-container pagemiddle">
							<span class="wordstyle disabled">共${coursepage.totalPageNum}页
								&nbsp;&nbsp;</span> <a class="wordstyle disabled"
								href="upload?pageNum=1"> 首页 </a>
							&nbsp;&nbsp;&nbsp; <a class="wordstyle"
								href="upload?pageNum=${coursepage.prePageNum}">
								上一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
								href="upload?pageNum=${coursepage.nextPageNum}">
								下一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
								href="upload?pageNum=${coursepage.totalPageNum}">
								末页 </a>&nbsp;&nbsp;&nbsp;
						</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear" style="height: 7px;"></div>
	<%@include file="footer.jsp"%>
</body>
</html>