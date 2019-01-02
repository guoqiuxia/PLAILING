<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<title>application</title>
<link href="${ctx}/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/whir_grzx.css" rel="stylesheet" type="text/css" />

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet"
	href="${ctx}/static/font-awesome/4.7.0/css/font-awesome.min.css" >
<link rel="stylesheet"
	href="${ctx}/static/highlight.js/9.8.0/monokai-sublime.min.css" >
<link rel="stylesheet"
	href="${ctx}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="${ctx}/app/css/libs/katex/0.6.0/katex.min.css" >
<link rel="stylesheet"
	href="${ctx}/app/css/libs/videojs/5.11.7/video-js.min.css" >
<link rel="stylesheet" href="${ctx}/app/css/dest/styles.css?=2016121272249">

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
					<a href="#" class="on">学习课程</a>
				</h1>
			</div>

			<div class="display">
				<div class="videoinfo1">
					<div class="left5020">
					
						<c:forEach items="${studyListPage.list}" var="c">
						<div class="col-md-4 col-sm-6  course">
							<a class="course-box" href="${ctx }/courseDetail?courseId=${c.course.courseId}">
								<div class="sign-box">
									<i class="fa fa-star-o course-follow pull-right"
										data-follow-url="/courses/1/follow"
										data-unfollow-url="/courses/1/unfollow" style="display: none"></i>
								</div>
								<div class="course-img">
									<img src="${ctx }/${c.course.photo}">
								</div>
								<div class="course-body">
									<span class="course-title" data-toggle="tooltip"
										data-placement="bottom" title="">${c.course.name}</span>
								</div>
								<div class="course-footer">
									<span class="course-per-num pull-left"> <i
										class="fa fa-users"></i> 上课人数${c.course.getJoinUsers().size() }
									</span>
								</div>
							</a>
						</div>
						</c:forEach>
							
						<div class="pagination-container pagemiddle">
							<span>
								共${studyListPage.totalPageNum}页
							</span>
							<a class="wordstyle" href="${ctx }/user/join?studyPageNum=1"><font size="2px"> 首页 </font></a>&nbsp;&nbsp;&nbsp; 
							<a class="wordstyle" href="${ctx }/user/join?studyPageNum=${studyListPage.prePageNum }"><font size="2px"> 上一页 </font></a>&nbsp;&nbsp;&nbsp; 
							<a class="wordstyle" href="${ctx }/user/join?studyPageNum=${studyListPage.nextPageNum }"><font size="2px"> 下一页 </font></a>&nbsp;&nbsp;&nbsp; 
							<a class="wordstyle" href="${ctx }/user/join?studyPageNum=${studyListPage.totalPageNum }"><font size="2px"> 末页 </font></a>&nbsp;&nbsp;&nbsp;
						</div>							
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>