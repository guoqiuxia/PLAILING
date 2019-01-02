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
<meta name="author" content="Lei Shi">
<meta http-equiv="Cache-Control" content="o-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="csrf-token"
	content="1483758872##fd2cac389b2b7c009a744bcaecaa41d71592cfe8">


<title>index</title>


<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx }/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css">

<link rel="stylesheet" href="${ctx }/css/jquery.slider.css">

</head>

<body>
	<%@include file="header.jsp"%>
	<div class="navbar-banner layout-no-margin-top">
		<div class="testSlider" style="margin-top: 60px;"></div>
	</div>

	<div class="line-and-laboratory">
		<div class="container">
			<div class="clearfix text-center item-header">
				<span class="line"></span>
				<div class="text-center item-title">课程推荐</div>
				<span class="line"></span>
			</div>
			<div class="clearfix courses">
				<c:forEach items="${recomendCourses}" var="rc">
					<div class="col-md-3 col-sm-6  course">
						<a class="course-box" href="${ctx }/courseDetail?courseId=${rc.key.courseId}">
							<div class="sign-box">
								<i class="fa fa-star-o course-follow pull-right"
									data-follow-url="/courses/30/follow"
									data-unfollow-url="/courses/30/unfollow" style="display: none"></i>
							</div>
							<div class="course-img">
								<img alt="Python Django Web框架" src="${ctx}/${rc.key.photo}">

							</div>
							<div class="course-body">
								<span class="course-title" data-toggle="tooltip"
									data-placement="bottom" title="Python Django Web框架">${rc.key.name}
								</span>
							</div>
							<div class="course-footer">
								<span class="course-per-num pull-left"> <i
									class="fa fa-users"></i>${rc.value}
								</span>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div class="line-and-laboratory">
		<div class="container">
			<div class="clearfix text-center item-header">
				<span class="line"></span>
				<div class="text-center item-title">新上好课</div>
				<span class="line"></span>
			</div>
			<div class="clearfix courses">
				<c:forEach items="${hotCourses}" var="hc">
					<div class="col-md-3 col-sm-6  course">
						<a class="course-box" href="${ctx }/courseDetail?courseId=${hc.key.courseId}">
							<div class="sign-box">
								<i class="fa fa-star-o course-follow pull-right"
									data-follow-url="/courses/30/follow"
									data-unfollow-url="/courses/30/unfollow" style="display: none"></i>
							</div>
							<div class="course-img">
								<img alt="Python Django Web框架" src="${ctx }/${hc.key.photo}">
							</div>
							<div class="course-body">
								<span class="course-title" data-toggle="tooltip"
									data-placement="bottom" title="Python Django Web框架">${hc.key.name}
								</span>
							</div>
							<div class="course-footer">
								<span class="course-per-num pull-left"> <i
									class="fa fa-users"></i>${hc.value}
								</span>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	
	<%@include file="login.jsp"%>
	<%@include file="footer.jsp"%>
	
	<script type="text/javascript" src="${ctx }/js/jquery-1.7.2.min.js"></script>
	<script src="${ctx }/js/jquery.min-1.js"></script>
	<script src="${ctx }/js/jquery.slider.js"></script>
	<script>
		window.onload = function() {
			var currentIndex = 0;

			$('.testSlider').slider({
				originType : 'tuoyuan'
			});
		}
	</script>
</body>
</html>
