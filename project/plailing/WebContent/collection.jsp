<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>collection</title>
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
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	function deleteCollection(courseId){
		$.ajax({
			url:'delete',
			data:{
				'courseId':courseId,
			},
			type:'post',
			asyn:false,
			success:function(result){
				if(result=="delete"){
					console.log(456789)
					document.getElementById("delete").href = 'collection';
					window.location.href="collection";
				}else{
					
				}
			}
		})
	}

</script>

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
					<a href="${ctx }/collection" class="on">收藏课程</a>
				</h1>
			</div>

			<div class="display">
				<div class="videoinfo1">
					<div class="left5020">
						<c:forEach var="collection" items="${mpc}">
							<div class="col-md-4 col-sm-6  course">
								<a class="course-box" href="${ctx }/courseDetail?courseId=${collection.key.courseId}">
									<div class="sign-box">
										<i class="fa fa-star-o course-follow pull-right"
											data-follow-url="/courses/1/follow"
											data-unfollow-url="/courses/1/unfollow" style="display: none"></i>
									</div>
									<div class="course-img">
										<img alt="${collection.key.name}" src="${collection.key.photo }">
									</div>
									<div class="course-body">
										<span class="course-title" data-toggle="tooltip"
											data-placement="bottom" title="${collection.key.name}">${collection.key.name}
											</span>
									</div>
									<div class="course-footer">
										<span class="course-per-num pull-left"> <i
											class="fa fa-users"></i>${collection.value }
										</span>
										<button style="float:right;border-style:solid;border-width:1px;background-color:#10be9d;color:#fff;border-radius:4px;padding:5px 5px 5px 5px;" type="button" onclick="deleteCollection(${collection.key.courseId})" id="delete"> 取消收藏</button> 
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="pagination-container pagemiddle">
					<span class="wordstyle disabled">共${pageCourse.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
					<a class="wordstyle disabled" href="${ctx }/collection?pageNum=1">首页</a> &nbsp;&nbsp;&nbsp;<a class="wordstyle disabled"
						href="${ctx }/collection?pageNum=${pageCourse.prePageNum }">上一页</a>&nbsp;&nbsp;&nbsp; <a class="wordstyle disabled"
						href="${ctx }/collection?pageNum=${pageCourse.nextPageNum }">下一页</a> &nbsp;&nbsp;&nbsp;<a class="wordstyle disabled"
						href="${ctx }/collection?pageNum=${pageCourse. totalPageNum}">末页</a>
				</div>
			</div>
		</div>
		<div class="clear"></div>

	</div>

	<%@include file="footer.jsp"%>



</body>
</html>