<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<title>coursedetail</title>




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
<script type="text/javascript"
	src="${ctx }/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function isJoin(email1,courseId,uploadId){
	if(email1==''){
		alert("请您登录后再加入课程！")
	}else{
		var con=confirm("您加入此课程需扣除您账户余额，是否确定加入此课程？");
		if(con==true){			
			var xmlhttp;
			if(window.XMLHttpRequest){
				xmlhttp=new XMLHttpRequest();
			}else{
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.open("GET","detailJoin?courseId="+courseId+"&uploadUser="+uploadId,true);
			xmlhttp.send();
			xmlhttp.onreadystatechange=function(){
				if(xmlhttp.readyState==4 && xmlhttp.status==200){
					var res=xmlhttp.responseText;
					if(res=="fail"){
						alert("您已加入过此课程，不能重复加入！");
					}else if(res=="checkfail"){
						alert("您的余额不足，请先去个人中心充值后在进行购买！");
					}else if(res=="buy"){
						alert("购买成功，钱数已从余额中扣除！");
						window.location.href='${ctx}/courseDetail?courseId='+courseId;
					}else if(res=="emailempty"){
						alert("请您先进行登录，如果没有登录不能加入此课程!");
					}
				}
			}
		}
	}

}

function stare(stare,starf,courseId){
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET","insertdetailCollection?courseId="+courseId,true);
		xmlhttp.send();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				var res=xmlhttp.responseText;
				if(res=="ok"){
					stare.style.display = "none";
					starf.style.display = "block";
					alert("您已收藏成功！");
				}else if(res=="false"){
					alert("您收藏失败!");
				}else if(res=="emailempty"){
					alert("请您先进行登录，如果没有登录不能收藏此课程");
				}
			}	
		}
}

function starf(stare,starf,courseId){	
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET","canceldetailCollection?courseId="+courseId,true);
		xmlhttp.send();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				var res=xmlhttp.responseText;
				if(res=="ok"){
					starf.style.display = "none";
					stare.style.display = "block";
					alert("您已取消收藏！");
				}else if(res=="false"){
					alert("您取消收藏失败!");
				}else if(res=="emailempty"){
					alert("请您先进行登录，如果没有登录不能收藏此课程");
				}
			}	
		}
}

function study(courseId,catalogId){
	$.ajax({
		url:'${ctx}/study',
		data:{
			'courseId':courseId,
		},
		type:'post',
		asyn:false,
		success:function(result){
			if(result=="pass"){
				window.location.href='${ctx }/comment/find?catalogId='+catalogId+'&courseId='+courseId;
			}else if(result=="fail"){
				alert("未登录不能进行学习");
			}else{
				alert("请先加入课程再进行学习");
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
						<h4 class="pull-left course-infobox-title">
							<span>${course.name}</span>
						</h4>
						<div class="pull-right course-infobox-follow">
							<span>收藏</span>&nbsp;&nbsp; <a> <c:if
									test="${isCollection=='fail'}">
									<span style="display: block; float: right; clear: right"
										id="star1" onclick="stare(star1,star2,${courseId})">☆</span>
									<span style="display: none; float: right; clear: right"
										id="star2" onclick="starf(star1,star2,${courseId})">★</span>
								</c:if> <c:if test="${isCollection=='ok'}">
									<span style="display: block; float: right; clear: right"
										id="star3" onclick="starf(star4,star3,${courseId})">★</span>
									<span style="display: none; float: right; clear: right"
										id="star4" onclick="stare(star4,star3,${courseId})">☆</span>
								</c:if>
							</a>
						</div>
					</div>
					<div class="clearfix course-infobox-body">
						<div class="sidebox1 mooc-teacher" border="0">
							<div class="sidebox-body mooc-content">

								<div class="mooc-info">
									<div class="name">
										<img src="${ctx }/${course.photo }"
											style="width: 50px; height: 30px;">&nbsp;&nbsp;&nbsp;
										综合评分：<strong>${course.grade}</strong>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学习人数：<strong>${studypeople }</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										课程价格：<strong>￥${course.price}</strong> <input type="submit"
											id="fl" class="input8" value="加入课程"
											onclick="javascript:isJoin('${email}',${courseId},${uploaduser})" />
									</div>
								</div>
								<div class="mooc-extra-info">
									<div class="word long-paragraph">
										<p>课程简介：</p>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${course.courseInfo }</p>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="content">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation"><a
							href="${ctx}/courseDetail?courseId=${courseId}">课程章节</a></li>

						<li role="presentation"><a
							href="${ctx}/coursecomment?courseId=${courseId}">课程评论</a></li>
					</ul>
					<div class="tab-content">

						<div role="tabpanel" class="tab-pane active" id="labs">

							<c:forEach items="${catalogList}" var="cl">
								<div class="lab-item ">
									<div>
										<img src="${ctx }/img/lab-not-ok.png">
									</div>
									<div>第${count=count+1}节</div>
									<div>${cl.catalogName}</div>
									<ul id="list">
										<c:forEach items="${cl.courseCatalogs}" var="ccl">
											<li>
												<div class="lab-item ">
													<div></div>
													<div>${ccl.catalogName}</div>
													<div class="pull-right lab-item-ctrl">
														<a class="btn btn-primary" onclick="study(${course.courseId},${ccl.catalogId})"
															href="#">开始学习</a>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</c:forEach>



							<div class="pagination-container pagemiddle">
								<span class="wordstyle disabled">共${pageCatalogList.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
								<a class="wordstyle disabled"
									href="${ctx}/courseDetail?courseId=${courseId}&pageNum=1">
									首页 </a> &nbsp;&nbsp;&nbsp; <a class="wordstyle"
									href="${ctx}/courseDetail?courseId=${courseId}&pageNum=${pageCatalogList.prePageNum}">
									上一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
									href="${ctx}/courseDetail?courseId=${courseId}&pageNum=${pageCatalogList.nextPageNum}">
									下一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
									href="${ctx}/courseDetail?courseId=${courseId}&pageNum=${pageCatalogList.totalPageNum}">
									末页 </a>&nbsp;&nbsp;&nbsp;
							</div>



						</div>

					</div>
				</div>


			</div>

			<div class="col-md-3 layout-side">
				<div class="side-image side-image-pc">
					<img src="${ctx }/${course.photo }">
				</div>

				<div class="sidebox mooc-teacher">
					<div class="sidebox-header mooc-header">
						<h4 class="sidebox-title">课程教师</h4>
					</div>
					<div class="sidebox-body mooc-content">
						<a href="${ctx}/information.jsp" target="_blank"> <img
							src="${ctx}/img/Linux&c.png">
						</a>
						<div class="mooc-info">
							<div class="name">
								<strong>${uploadCourseUser.nickName}</strong>
							</div>

							<div class="courses">
								共发布过<strong>${uploadCourseCount}</strong>门课程
							</div>
						</div>
						<div class="mooc-extra-info">
							<div class="word long-paragraph">
								${uploadCourseUser.introduction}</div>
						</div>
					</div>
					<div class="sidebox-footer mooc-footer">
						<a href="${ctx}/information?userId=${uploaduser}">查看老师的所有课程 ></a>
					</div>
				</div>


				<!-- 此处展示老师的另外一些课程 -->
				<div class="wordstyle">
					<strong>类似课程</strong>
				</div>
				<c:forEach items="${mpc}" var="lc">
					<div class="col-md-14 col-sm-16  course">
						<a class="course-box"
							href="${ctx}/courseDetail?courseId=${lc.key.courseId}">
							<div class="course-img">

								<img alt="${lc.key.name}" src="${lc.key.photo}">

							</div>

							<div class="course-body">
								<span class="course-title">${lc.key.name}</span>
							</div>
							<div class="course-footer">
								<span class="course-per-num pull-left"> <i
									class="fa fa-users"></i>${lc.value}</span>

							</div>
						</a>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<%@include file="login.jsp"%>
	<%@include file="footer.jsp"%>

</body>
</html>