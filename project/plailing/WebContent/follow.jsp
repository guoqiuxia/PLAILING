<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
<link rel="stylesheet" href="${ctx}/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet" href="${ctx}/app/css/dest/styles.css?=2016121272249">
<style type="text/css">
.product-buyer-name {
	max-width: 800px;
	overflow: hidden;
	text-overflow: ellipsis;
 	white-space: nowrap;
}
</style>
<script type="text/javascript">
	function deleteFollow(userId,deleId){
		var con=confirm("确定不在关注此人？");
		if(con==true){
			deleId.style.display="none";
			$.ajax({
				url:'deleteFollow',
				data:{
					'userId':userId,
				},
				type:'post',
				asyn:false,
			})
		}
	}
	function changemutualFollow(userId){
		var followf = document.getElementById("buto"+userId).value;
		var con;
		if(followf=='互相关注'){
			con=confirm("确定不再关注此人？");
		}else{
			con=confirm("确定关注此人？");
		}
		if(con==true){
			$.ajax({
				url:'changemutualFollow',
				data:{
					'userId':userId,
				},
				type:'post',
				asyn:false,
				success:function(result){
					if(result=="deletemtualfollow"){
	 					document.getElementById("buto"+userId).value = '＋关注';
					}else{
	 					document.getElementById("buto"+userId).value = '互相关注';
					}
					
				}
			})	
		}
	}
</script>
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
			<c:if test="${followFlag=='myfol'}">
			<div class="title6">
				<h1>
					<a href="follow" class="on">关注</a>
				</h1>
				<h1>
					<a href="followMe" class="">粉丝</a>
				</h1>
			</div>
			</c:if>
			<c:if test="${followFlag=='folme'}">
			<div class="title6">
				<h1>
					<a href="follow" class="">关注</a>
				</h1>
				<h1>
					<a href="followMe" class="on">粉丝</a>
				</h1>
			</div>
			</c:if>
			<c:if test="${followFlag=='myfol'}">
			<div>
				<div class="videoinfo2" id="myfollow">
					<!-- <div class="left502"> -->
					<c:forEach items="${myFollowPeopleMap}" var="mfpm">
					<div class="tab-pane active" id="lab${mfpm.key.userId}">
						<div class="lab-item " style="width: 770px;height:70px">
							<div>	
								<a href="${ctx}/information?userId=${mfpm.key.userId}"><img src="${ctx}/${mfpm.key.photo}" style="width:46px;height:46px;"></a>
							</div>
							<div style="width:600px;height:60px;margin:0px">
								<span style="font-size:12px;width:600px;height:20px;padding:0px">${mfpm.key.nickName}</span>
								<p style="font-size:12px;width:580px;height:30px;padding:0px;margin:10px 0px 0px 0px" class="product-buyer-name">${mfpm.key.introduction}</p>
							</div>
							<c:if test="${mfpm.value==0}">
								<a href="#"><input type="button" value="已关注" class="input8" style="width:70px;height:30px" onclick="deleteFollow(${mfpm.key.userId},lab${mfpm.key.userId})"></a>
							</c:if>
							<c:if test="${mfpm.value==1}">
								<a href="#"><input type="button" value="互相关注" class="input8" style="width:70px;height:30px" onclick="deleteFollow(${mfpm.key.userId},lab${mfpm.key.userId})"></a>
							</c:if>
						</div>
					</div>
					</c:forEach>
					<div style="padding-top: 50px;text-align: center">
						<span>共${myFollowPeople.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
						<a href="${ctx }/follow?pageNum=1">首页</a> &nbsp;&nbsp;&nbsp;<a
							href="${ctx }/follow?pageNum=${myFollowPeople.prePageNum }">上一页</a>&nbsp;&nbsp;&nbsp; <a
							href="${ctx }/follow?pageNum=${myFollowPeople.nextPageNum }">下一页</a> &nbsp;&nbsp;&nbsp;<a
							href="${ctx }/follow?pageNum=${myFollowPeople. totalPageNum}">末页</a>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${followFlag=='folme'}">
			<div id="followme">
				<div class="videoinfo2">
					<!-- <div class="left502"> -->
					<c:forEach items="${FollowMePeopleMap}" var="fmpp">
					<div class="tab-pane active">
						<div class="lab-item " style="width: 770px;height:70px">
							<div>	
								<a href="${ctx}/information?userId=${fmpp.key.userId}"><img src="${ctx}/${fmpp.key.photo}" style="width:46px;height:46px;"></a>
							</div>
							<div style="width:600px;height:60px;margin:0px">
								<span style="font-size:12px;width:600px;height:20px;padding:0px">${fmpp.key.nickName}</span>
								<p style="font-size:12px;width:580px;height:30px;padding:0px;margin:10px 0px 0px 0px">${fmpp.key.introduction}</p> 
							</div>
							<c:if test="${fmpp.value==0}">
								<a href="#"><input type="button" value="＋关注" class="input8" style="width:70px;height:30px;" id="buto${fmpp.key.userId}" onclick="changemutualFollow(${fmpp.key.userId})"></a>
							</c:if>
							<c:if test="${fmpp.value==1}">
								<a href="#"><input type="button" value="互相关注" class="input8" style="width:70px;height:30px" id="buto${fmpp.key.userId}" onclick="changemutualFollow(${fmpp.key.userId})"></a>
							</c:if>
						</div>
					</div>
					</c:forEach>
					<div style="padding-top: 50px;text-align: center">
						<span>共${FollowMePeople.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
						<a href="${ctx }/followMe?pageNum=1">首页</a> &nbsp;&nbsp;&nbsp;<a
							href="${ctx }/followMe?pageNum=${FollowMePeople.prePageNum }">上一页</a>&nbsp;&nbsp;&nbsp; <a
							href="${ctx }/followMe?pageNum=${FollowMePeople.nextPageNum }">下一页</a> &nbsp;&nbsp;&nbsp;<a
							href="${ctx }/followMe?pageNum=${FollowMePeople. totalPageNum}">末页</a>
					</div>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	<div class="clear" style="height: 7px;"></div>
	<%@include file="footer.jsp"%>
</body>
</html>