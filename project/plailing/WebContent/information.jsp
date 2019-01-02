<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>information</title>
<link rel="shortcut icon" href="${ctx }/favicon.ico">
<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx }/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet"
	href="${ctx }/restatic/js/libs/marked/katex/katex.min.css">
<script type="text/javascript" src="${ctx }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function changeFollow(userId){
		$.ajax({
			url:'changeFollow',
			data:{
				'userId':userId,
			},
			type:'post',
			asyn:false,
			success:function(result){
				if(result=="add"){
					document.getElementById("followa").innerHTML = "★";
				}
				if(result=="delete"){
					document.getElementById("followa").innerHTML = "☆";
				}
				if(result=="login"){
					alert("请登录");
				}
			}
		})
	}
</script>
</head>
<body>

	<%@include file="header.jsp"%>
	<div class="container layout layout-margin-top">


		<div class="row">
			<div class="col-md-9 layout-body">
				<div class="content course-infobox">
					<div class="clearfix course-infobox-header">

						<div class="pull-right course-infobox-follow">
							<c:if test="${flag1==1}">
								<span>关注</span>
								<a href="#" onclick="changeFollow(${user.userId})" id="followa">
									<c:if test="${flag==0}">☆</c:if> <c:if test="${flag==1}">★</c:if>
								</a>
							</c:if>
							<c:if test="${flag1==0}">
							</c:if>
						</div>
					</div>
					<div class="clearfix course-infobox-body">
						<div class="sidebox1 mooc-teacher" border="0">
							<div class="sidebox-body mooc-content">
								<a href="#"> <img src="${ctx }/${user.photo}">
								</a>
								<div class="mooc-info">
									<div class="name">
										名字：<strong>${user.nickName}</strong>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学校：<strong>${user.school}</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										专业：<strong>${user.major}</strong>
									</div>
								</div>
								<div class="mooc-extra-info">
									<div class="word long-paragraph">
										<p>个人简介：</p>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.introduction}</p>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<c:if test="${courseCount==0}">
					<div class="content">
						<p class="wordstyle">
							您还没有上传任何课程，<a href="${ctx }/upload.jsp">点击此处上传</a>
						</p>
					</div>
				</c:if>
				<c:if test="${courseCount!=0}">
					<div class="content">
						<p class="wordstyle">老师的所有课程</p>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="labs">
								<c:forEach items="${Coursespage}" var="pc">
									<div class="col-md-4 col-sm-6  course">
										<a class="course-box" href="${ctx }/courseDetail?courseId=${pc.key.courseId}">
											<div class="course-img">
												<img alt="Linux 基础入门（新版）" src="${ctx}/${pc.key.photo}">
											</div>

											<div class="course-body">
												<span class="course-title">${pc.key.name}</span>
											</div>
											<div class="course-footer">
												<span class="course-per-num pull-left"> <i
													class="fa fa-users"></i> ${pc.value}
												</span>
											</div>
										</a>
									</div>
								</c:forEach>
								<div class="pagination-container pagemiddle">
									<a class="wordstyle" href="${ctx }/information?pageNum=1">
										首页 </a> &nbsp;&nbsp;&nbsp; <a class="wordstyle"
										href="${ctx }/information?pageNum=${personalCourses.prePageNum}">
										上一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
										href="${ctx }/information?pageNum=${personalCourses.nextPageNum}">
										下一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
										href="${ctx }/information?pageNum=${personalCourses.totalPageNum}">
										末页 </a>&nbsp;&nbsp;&nbsp;
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<%@include file="login.jsp"%>
	<%@include file="footer.jsp"%>
</body>
</html>