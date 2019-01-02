<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>courselist</title>
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
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container layout layout-margin-top">
		<div class="row">
			<div class="col-md-9 layout-body">
				<div class="content">
					<div class="row course-cates">
						<div class="col-md-1 course-cates-title">类别：</div>
						<div class="col-md-11 course-cates-content" id="fdiv">
							<a class="active" href="${ctx }/courseListAll">全部</a>
							<c:forEach items="${parentType}" var="pt">
							<a href = "courseListF?fTypeId=${pt.typeId}">${pt.typeName}</a>
							</c:forEach>
						</div>
					</div>
					<c:if test="${mTag=='全部'}">
					<div class="row course-cates">
						<div class="col-md-1 course-cates-title">标签：</div>
						<div class="col-md-11 course-cates-content" id="typediv">
							<a class="active" href = "courseListF?fTypeId=${fTypeId}">${mTag}</a>
							<c:forEach items="${cCourseTypes}" var="ct">
							<a href="${ctx }/courseListT?cTypeId=${ct.typeId}">${ct.typeName}</a>
							</c:forEach>
						</div>
					</div>
					</c:if>
				</div>
				<div class="content position-relative">
					<ul class="nav nav-tabs" role="tablist">
						<li class="active"><a
							href="#">全部课程</a></li>
					</ul>
					<div class="clearfix"></div>
					<div class="search-result"></div>
					<div class="row">
						<c:forEach items="${Coursespage}" var="pc">
						<div class="col-md-4 col-sm-6  course">
							<a class="course-box" href="${ctx }/courseDetail?courseId=${pc.key.courseId}">
								<div class="sign-box">
									<i class="fa fa-star-o course-follow pull-right"
										data-follow-url="/courses/708/follow"
										data-unfollow-url="/courses/708/unfollow"
										style="display: none"></i>
								</div>
								<div class="course-img">
									<img alt="Python 3 实现 Markdown 解析器"
										src="${pc.key.photo}">
								</div>
								<div class="course-body">
									<span class="course-title" data-toggle="tooltip"
										data-placement="bottom" title="Python 3 实现 Markdown 解析器">${pc.key.name}
									</span>
								</div>
								<div class="course-footer">
									<span class="course-per-num pull-left"> <i
										class="fa fa-users"></i> ${pc.value}
									</span></span>
								</div>
							</a>
						</div>
						</c:forEach>
					</div>
					<c:if test="${tag=='ac'}">
					<nav class="pagination-container">
						<ul class="pagination">
							<li>
								<span>
								共${page.totalPageNum}页
								</span>
							</li>
							<li class="">
								<a href="${ctx }/courseListAll?pageNum=1" aria-label="Previous">
									<span aria-hidden="true">首页</span>
								</a>
							</li>
							<li class="">
								<a href="${ctx }/courseListAll?pageNum=${page.prePageNum}" aria-label="Previous">
									<span aria-hidden="true">上一页</span>
								</a>
							</li>
							<li class="">
								<a aria-label="Next" href="${ctx }/courseListAll?pageNum=${page.nextPageNum}">
									<span aria-hidden="true">下一页</span>
								</a>
							</li>
							<li class="">
								<a aria-label="Next" href="${ctx }/courseListAll?pageNum=${page.totalPageNum}">
									<span aria-hidden="true">末页</span>
								</a>
							</li>
						</ul>
					</nav>
					</c:if>
					<c:if test="${tag=='ctc'}">
					<nav class="pagination-container">
						<ul class="pagination">
							<li>
								<span>
								共${page.totalPageNum}页
								</span>
							</li>
							<li class="">
								<a href="${ctx }/courseListT?pageNum=1&cTypeId=${cTypeId}" aria-label="Previous">
									<span aria-hidden="true">首页</span>
								</a>
							</li>
							<li class="">
								<a href="${ctx }/courseListT?pageNum=${page.prePageNum}&cTypeId=${cTypeId}" aria-label="Previous">
									<span aria-hidden="true">上一页</span>
								</a>
							</li>
							<li class="">
								<a aria-label="Next" href="${ctx }/courseListT?pageNum=${page.nextPageNum}&cTypeId=${cTypeId}">
									<span aria-hidden="true">下一页</span>
								</a>
							</li>
							<li class="">
								<a aria-label="Next" href="${ctx }/courseListT?pageNum=${page.totalPageNum}&cTypeId=${cTypeId}">
									<span aria-hidden="true">末页</span>
								</a>
							</li>
						</ul>
					</nav>
					</c:if>
					<c:if test="${tag=='ftc'}">
					<nav class="pagination-container">
						<ul class="pagination">
							<li>
								<span>
								共${page.totalPageNum}页
								</span>
							</li>
							<li class="">
								<a href="${ctx }/courseListF?pageNum=1&fTypeId=${fTypeId}" aria-label="Previous">
									<span aria-hidden="true">首页</span>
								</a>
							</li>
							<li class="">
								<a href="${ctx }/courseListF?pageNum=${page.prePageNum}&fTypeId=${fTypeId}" aria-label="Previous">
									<span aria-hidden="true">上一页</span>
								</a>
							</li>
							<li class="">
								<a aria-label="Next" href="${ctx }/courseListF?pageNum=${page.nextPageNum}&fTypeId=${fTypeId}">
									<span aria-hidden="true">下一页</span>
								</a>
							</li>
							<li class="">
								<a aria-label="Next" href="${ctx }/courseListF?pageNum=${page.totalPageNum}&fTypeId=${fTypeId}">
									<span aria-hidden="true">末页</span>
								</a>
							</li>
						</ul>
					</nav>
					</c:if>
				</div>
			</div>
			<div class="col-md-3 layout-side">
				<div class="sidebox">
					<div class="sidebox-header">
						<h4 class="sidebox-title">最热课程</h4>
					</div>
					<div class="sidebox-body course-content side-list-body">
						<c:forEach items="${listHotCourse}" var="lh">
						<a href="${ctx}/courseDetail?courseId=${lh.courseId}">
							<img style="width: 25px; height: 25px" src="${lh.photo}">${lh.name}
						</a>
						</c:forEach>
					</div>

				</div>

			</div>
		</div>
	</div>


	<%@include file="login.jsp" %>

	<%@include file="footer.jsp"%>
</body>
</html>