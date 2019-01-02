<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>videodetail</title>
<link href="${ctx}/css/whir_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="${ctx}/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">



<link rel="stylesheet"
	href="${ctx}/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet" href="${ctx}/css/style.css">
<link rel="stylesheet" href="${ctx}/css/comment.css">
<style type="text/css">
.guestbook .left868 .content .change .button {
	background-color: #0c9; /* Green */
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 0px 0px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	cursor: pointer;
	border: 1px solid #0c9;
	margin-bottom: 2px;
}

.guestbook .left868 .content .change .button:hover {
	background-color: white;
	color: #0c9;
}

.guestbook .left868 .content .tab-content a:hover {
	text-decoration: none;
}

.guestbook .left868 .content .tab-conten a:visited {
	text-decoration: none;
}
}
</style>
<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js">
	
</script>
<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flexText.js"></script>
<script type="text/javascript">
	function windowChat() {
		window.open("http://www.runoob.com/try/try.php?filename=tryjs_prompt",
				"newwindow", "height=650,width=600", top = 300, left = 400)

	}
	window.onload = function() {
		$("#labs").show();
		$("#labss").hide();
		$("#course").click(function() {
			$("#labs").show();
			$("#labss").hide();
		})
		$("#comment").click(function() {
			$("#labss").show();
			$("#labs").hide();
		})
	}
	detail=function(pageNum,courseId){
		console.log(pageNum);
		$.ajax({
			url:'${ctx}/comment/catalogDetail',
			data:{
				'pageNum':pageNum,
				'courseId':courseId
			},
			type:'get',
			asyn : false,
			success:function(result){
				document.getElementById("labs1").innerHTML='';
				var res = $.parseJSON(result);
				$.each(res,function(i,n){
					var text=n[0];
					var num= (pageNum-1)*3+n[2]-i;
					var con='<div class="lab-item "><div><img src="${ctx}/img/lab-not-ok.png" style="width: 24px;height: 24px;">'+
					'</div><div>第'+num+'节</div><div>'+text+'</div><ul id="list"></ul></div>';
					 $('#labs1').prepend(con);
					var list=n[1];
					for(var i=0;i<list.length;i++){
						var conn='<li><div class="lab-item "><div></div><div>'+list[i][1]+'</div><div class="pull-right lab-item-ctrl">'+
						'<a class="btn btn-primary" href="${ctx }/comment/find?catalogId='+list[i][0]+'&courseId='+courseId+'">开始学习</a>'+
						'</div></div></li>';
						$('#list').prepend(conn);
					}
				});
	        }
		});
	} 
	
	
	comments=function(pageNum,courseId,catalogId){
		var pagen=parseInt(document.getElementById("w2").innerHTML.substring(2,1));
		document.getElementById("w3").innerHTML='';
		if((pageNum+1==pagen) || pageNum==pagen){
			var con1='<a class="wordstyle" onclick="comments('+pagen+','+courseId+','+catalogId+')">下一页</a>&nbsp;&nbsp;&nbsp;';
			document.getElementById("w3").innerHTML=con1;
		}else{
			var con1='<a class="wordstyle" onclick="comments('+(pageNum+1)+','+courseId+','+catalogId+')">下一页</a>&nbsp;&nbsp;&nbsp;';
			document.getElementById("w3").innerHTML=con1;
		}
		document.getElementById("w5").innerHTML='';
		if(pageNum==1){
			var con1='<a class="wordstyle" onclick="comments(1,'+courseId+','+catalogId+')">上一页</a>&nbsp;&nbsp;&nbsp;';
			document.getElementById("w5").innerHTML=con1;
		}else{
			var con1='<a class="wordstyle" onclick="comments('+(pageNum-1)+','+courseId+','+catalogId+')">上一页</a>&nbsp;&nbsp;&nbsp;';
			document.getElementById("w5").innerHTML=con1;
		}
		console.log(pageNum);
		$.ajax({
			url:'${ctx}/comment/catalogComment',
			data:{
				'pageNum':pageNum,
				'courseId':courseId,
				'catalogId':catalogId
			},
			type:'get',
			asyn : false,
			success:function(result){
				document.getElementById("labss1").innerHTML='';
				var res = $.parseJSON(result);
				console.log(res);
				$.each(res,function(i,n){	
					var commentTime1=n[1];
	        		var commentTime2=new Date(commentTime1);
	        		var year=commentTime2.getFullYear();
			        //获取当前月
			        var month=commentTime2.getMonth()+1;
			        //获取当前日
			        var date=commentTime2.getDate();
			        var h=commentTime2.getHours();       //获取当前小时数(0-23)
			        var m=commentTime2.getMinutes();     //获取当前分钟数(0-59)
			        if(m<10) m = '0' + m;
			        var s=commentTime2.getSeconds();
			        if(s<10) s = '0' + s;
			        commentTime=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
					var con='<div class="comment-show-con clearfix"value="'+n[0]+'" id="'+n[0]+'"><div class="comment-show-con-img pull-left">'+
					'<img src="${ctx}/'+n[3]+'" alt="" style="width: 50px; height: 50px;"></div><div class="comment-show-con-list pull-left clearfix">'+
					'<div class="pl-text clearfix"><a href="#" class="comment-size-name" style="font-size: 15px;">'+n[4]+': </a> '+
					'<span class="my-pl-con" value="'+n[0]+'" style="font-size: 15px;">&nbsp;'+n[2]+'</span> </div> <div class="date-dz">'+
					'<span class="date-dz-left pull-left comment-time">'+commentTime+'</span><div class="date-dz-right pull-right comment-pl-block">'+
					'<a href="javascript:;"class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span>'+
					' <a href="javascript:;"class="date-dz-z pull-left hf-con-block-can"><i class="date-dz-z-click-red"></i>查看回复</a></div>'+
					'</div><div class="hf-list-con"></div></div></div>';
					$("#labss1").prepend(con);
				});
	        }
		});
	} 


</script>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="clear" style="margin-top: 70px;"></div>
	<!--container-->
	<div class="player_container">
		<h1 class="mod_player_title" title="java简介">${singleCourse.catalogName}</h1>
		<!--视频播放及相关视频-->
		<div class="mod_player_section cf" id="mod_inner">
			<div class="mod_player" id="mod_player">
				<video controls controlsList="nodownload" width="856" height="519"">
				<source src="${ctx }/${singleCourse.courseFile}" type="video/mp4" />
				</video>
			</div>
			<div class="divfloat">
				<div class="album_title">
					<br> <img src="${ctx }/${singlerUser.photo}" title="老师头像"
						width="130px" height="130px" /> <br>
					<h5>${singlerUser.nickName}</h5>
				</div>
				<div>
					<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${singlerUser.introduction}</h5>
				</div>
			</div>
		</div>

	</div>
	<div class="clear"></div>

	<!--留言-->
	<div class="lybox">
		<div class="guestbook">
			<div class="left868">
				<!--留言板-->
				<div class="content">
					<!-- <div class="change">


						<button id="course" type="button" class="button">章结</button>

						<button type="button" id="chat.jsp" class="button">聊天室</button>
						 onclick="windowChat()"

						<button id="comment" type="button" class="button">评论</button>

					</div> -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation"><a id="course">课程章节</a></li>

						<li role="presentation"><a id="comment">问答</a></li>
					</ul>
					<div class="tab-content">

						<div role="tabpanel" class="tab-pane active" id="labs">



							<div id="labs1">
								<c:forEach items="${catalogList}" var="cl">
									<div class="lab-item ">
										<div>
											<img src="${ctx}/img/lab-not-ok.png"
												style="width: 24px; height: 24px;">
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
															<a class="btn btn-primary"
																href="${ctx }/comment/find?catalogId=${ccl.catalogId}&courseId=${courseId}">开始学习</a>
														</div>
													</div>
												</li>
											</c:forEach>
										</ul>
									</div>
								</c:forEach>
							</div>

							<div class="pagination-container pagemiddle">
								<span class="wordstyle">共${pageCatalogList.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
								<a class="wordstyle" onclick="detail(1,${courseId},${count})">首页
								</a> &nbsp;&nbsp;&nbsp; <a class="wordstyle"
									onclick="detail(${pageCatalogList.prePageNum},${courseId},${count})">上一页
								</a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
									onclick="detail(${pageCatalogList.nextPageNum},${courseId},${count})">下一页
								</a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
									onclick="detail(${pageCatalogList.totalPageNum},${courseId},${count})">末页
								</a>&nbsp;&nbsp;&nbsp;
							</div>

						</div>
						<div role="tabpanel" class="tab-pane active" id="labss">
							<div class="commentAll" id="getcatalogId" value="${catalogId }">
								<!--评论区域 begin-->
								<div class="reviewArea clearfix">
									<textarea class="content comment-input"
										placeholder="Please enter a comment&hellip;"
										onkeyup="keyUP(this)"></textarea>
									<a href="javascript:;" class="plBtn">评论</a>
								</div>
								<!--评论区域 end-->
								<!--回复区域 begin-->
								<div class="comment-show">
									<input type="hidden" id="getCount" value="${pageCount}"/>
									<div id="labss1">
										<c:forEach items="${comments }" var="a">
											<div class="comment-show-con clearfix"
												value="${a.getCommentId() }" id="${a.getCommentId() }">
												<div class="comment-show-con-img pull-left">
													<img src="${ctx}/${ a.getUser().getPhoto()}" alt=""
														style="width: 50px; height: 50px;">
												</div>
												<div class="comment-show-con-list pull-left clearfix">
													<div class="pl-text clearfix">
														<a href="#" class="comment-size-name"
															style="font-size: 15px;">${ a.getUser().getNickName()}
															: </a> <span class="my-pl-con" value="${a.getCommentId() }"
															style="font-size: 15px;">&nbsp;${ a.getText()}</span>
													</div>
													<div class="date-dz">
														<span class="date-dz-left pull-left comment-time">${a.getCommentTime()}</span>
														<div class="date-dz-right pull-right comment-pl-block">
															<a href="javascript:;"
																class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span
																class="pull-left date-dz-line">|</span> <a
																href="javascript:;"
																class="date-dz-z pull-left hf-con-block-can"><i
																class="date-dz-z-click-red"></i>查看回复</a>
														</div>
													</div>
													<div class="hf-list-con"></div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="pagination-container pagemiddle">
										<input type="hidden" id="getCourseId" value="${courseId}"/>
										<input type="hidden" id="getCatalogId" value="${catalogId}"/>
										<span class="wordstyle" id="w2">共${page.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
										<a class="wordstyle" onclick="comments(1,${courseId},${catalogId})">首页 </a>&nbsp;&nbsp;&nbsp; 
										<span id="w5">
										<a class="wordstyle" onclick="comments(${page.prePageNum},${courseId},${catalogId})">上一页</a>&nbsp;&nbsp;&nbsp; 
										</span>
										<span id="w3">
										<a class="wordstyle" onclick="comments(${page.nextPageNum},${courseId},${catalogId})">下一页</a>&nbsp;&nbsp;&nbsp; 
										</span>
										<span id="w4">
										<a class="wordstyle" onclick="comments(${page.totalPageNum},${courseId},${catalogId})">末页</a>&nbsp;&nbsp;&nbsp;
										</span>
									</div>

								</div>
								<!--回复区域 end-->
							</div>
						</div>



						<!--textarea高度自适应-->
						<script type="text/javascript">
							$(function() {
								$('.content').flexText();
							});
						</script>
						<!--textarea限制字数-->
						<script type="text/javascript">
							function keyUP(t) {
								var len = $(t).val().length;
								if (len > 139) {
									$(t).val($(t).val().substring(0, 140));
								}
							}
						</script>
						<!--点击评论创建评论条-->
						<script type="text/javascript">
							$('.commentAll')
									.on(
											'click',
											'.plBtn',
											function() {
												var num; 
												var count=parseInt(document.getElementById("getCount").value);
												count=count+1;
												document.getElementById("getCount").value=count;
												if(count%10==0){
													num=count/10;
												}else{
													var count1=parseInt(count/10);
													num=count1+1;
												}
												document.getElementById("w2").innerHTML='';
												document.getElementById("w2").innerHTML='共'+num+'页'; 
											    var courseId=document.getElementById("getCourseId").value;
												var catalogId=document.getElementById("getCatalogId").value;
												if(num==2){
													console.log("5aaa");
													document.getElementById("w3").innerHTML='';
													var con1='<a class="wordstyle" onclick="comments(2,'+courseId+','+catalogId+')">下一页</a>&nbsp;&nbsp;&nbsp;';
													document.getElementById("w3").innerHTML=con1;
													document.getElementById("w4").innerHTML='';
													var con2='<a class="wordstyle" onclick="comments(2,'+courseId+','+catalogId+')">末页</a>&nbsp;&nbsp;&nbsp;';
													document.getElementById("w4").innerHTML=con2;
												}else{
													document.getElementById("w4").innerHTML='';
													var con2='<a class="wordstyle" onclick="comments('+num+','+courseId+','+catalogId+')">末页</a>&nbsp;&nbsp;&nbsp;';
													document.getElementById("w4").innerHTML=con2;
												} 

												var id;
												var oHtml;
												var myDate = new Date();
												//获取当前年
												var year = myDate.getFullYear();
												//获取当前月
												var month = myDate.getMonth() + 1;
												//获取当前日
												var date = myDate.getDate();
												var h = myDate.getHours(); //获取当前小时数(0-23)
												var m = myDate.getMinutes(); //获取当前分钟数(0-59)
												if (m < 10)
													m = '0' + m;
												var s = myDate.getSeconds();
												if (s < 10)
													s = '0' + s;
												var now = year + '-' + month
														+ "-" + date + " " + h
														+ ':' + m + ":" + s;
												console.log(now);
												//获取输入内容
												var oSize = $(this).siblings(
														'.flex-text-wrap')
														.find('.comment-input')
														.val();
												var img;
												var name;
												var catalogId=$("#getcatalogId").attr("value");
												console.log(oSize);
												if(oSize!=''){
												$
														.post(
																"${ctx}/comment/addcomment",
																{
																	text : oSize,
																	commentTime : now,
																	catalogId : catalogId
																},
																function(data) {
																	var res = $
																			.parseJSON(data);
																	console
																			.log(res);

																	id = res[0];
																	console
																			.log(res[0]);
																	img = "/plailing/"
																			+ res[1];
																	name = res[2];

																	//动态创建评论模块
																	console
																			.log("id:"
																					+ id);
																	oHtml = '<div class="comment-show-con clearfix" value="'+id+'"id="'+id+'"><div class="comment-show-con-img pull-left"><img src="'+img+'" alt="" style="width: 50px;height: 50px;"></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name" style="font-size: 15px;">'
																			+ name
																			+ ' : </a> <span class="my-pl-con"value="'+id+'"style="font-size: 15px;">&nbsp;'
																			+ oSize
																			+ '</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'
																			+ now
																			+ '</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left hf-con-block-can"><i class="date-dz-z-click-red"></i>查看回复</a> </div> </div><div class="hf-list-con"></div></div> </div>';
																	alert("您的评论发表成功！");
																	if (oSize
																			.replace(
																					/(^\s*)|(\s*$)/g,
																					"") != '') {
																		console
																				.log("id:"
																						+ res[0][0]);

																		$("#labss1").prepend(oHtml);
																		$(
																				'.plBtn')
																				.siblings(
																						'.flex-text-wrap')
																				.find(
																						'.comment-input')
																				.prop(
																						'value',
																						'')
																				.siblings(
																						'pre')
																				.find(
																						'span')
																				.text(
																						'');
																		console
																				.log("id:"
																						+ res[0][0]);
																	}
																});
												}else{
													alert("问答的内容不能为空！");
												}
											});
						</script>
						<!--点击回复动态创建回复块-->
						<script type="text/javascript">
							$('.comment-show')
									.on(
											'click',
											'.pl-hf',
											function() {
												//获取回复人的名字
												var fhName = $(this)
														.parents(
																'.date-dz-right')
														.parents('.date-dz')
														.siblings('.pl-text')
														.find(
																'.comment-size-name')
														.html();
												//回复@
												var fhN = '回复@' + fhName;
												//var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
												var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
												//显示回复
												if ($(this).is('.hf-con-block')) {
													$(this)
															.parents(
																	'.date-dz-right')
															.parents('.date-dz')
															.append(fhHtml);
													$(this).removeClass(
															'hf-con-block');
													$('.content').flexText();
													$(this)
															.parents(
																	'.date-dz-right')
															.siblings('.hf-con')
															.find('.pre').css(
																	'padding',
																	'6px 15px');
													//console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
													//input框自动聚焦
													// $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
												} else {
													$(this).addClass(
															'hf-con-block');
													$(this)
															.parents(
																	'.date-dz-right')
															.siblings('.hf-con')
															.remove();
												}
											});
						</script>
						<!--评论回复插入数据库-->
						<script type="text/javascript">
							$('.comment-show')
									.on(
											'click',
											'.hf-pl',
											function() {
												var oThis = $(this);
												var myDate = new Date();
												//获取当前年
												var year = myDate.getFullYear();
												//获取当前月
												var month = myDate.getMonth() + 1;
												//获取当前日
												var date = myDate.getDate();
												var h = myDate.getHours(); //获取当前小时数(0-23)
												var m = myDate.getMinutes(); //获取当前分钟数(0-59)
												if (m < 10)
													m = '0' + m;
												var s = myDate.getSeconds();
												if (s < 10)
													s = '0' + s;
												var now = year + '-' + month
														+ "-" + date + " " + h
														+ ':' + m + ":" + s;
												var oAt = '';

												console.log(now)
												//获取输入内容
												var oHfVal = $(this).siblings(
														'.flex-text-wrap')
														.find('.hf-input')
														.val();
												var th = $(this).parents(
														'.hf-con').parents(
														'.all-pl-con').css(
														'display', 'block')

												var oHfName = $(this).parents(
														'.hf-con').parents(
														'.date-dz').siblings(
														'.pl-text').find(
														'.comment-size-name')
														.html();
												var oHfId = $(this).parents(
														'.hf-con').parents(
														'.date-dz').siblings(
														'.pl-text').find(
														'.my-pl-con').attr(
														"value");
												var oHfTop = $(this).parents(
														'.hf-con').parents(
														'.comment-show-con')
														.attr("value");
												var catalogId=$("#getcatalogId").attr("value");

												console.log(oHfId)
												console.log(oHfTop)
												var oAllVal = '回复@' + oHfName;
												if (now == '') {
													oAt = res.hfContent;
												} else {
													oAt = '回复<a href="#" class="atName" style="font-size: 15px;">@'
															+ oHfName
															+ '</a> '
															+ oHfVal;
												}
												if (oHfVal.replace(/^ +| +$/g,
														'') == ''
														|| oHfVal == oAllVal) {

												} else {
													$
															.post(
																	"${ctx}/comment/addsoncomment",
																	{
																		time : now,
																		text : oHfVal,
																		commentPid : oHfId,
																		oHfTop : oHfTop,
																		catalogId : catalogId
																	},
																	function(
																			data) {

																		var res = $
																				.parseJSON(data);
																		if ($(
																				"#"
																						+ oHfTop
																						+ "")
																				.find(
																						'.comment-show-con-list')
																				.find(
																						'.date-dz-z')
																				.is(
																						'.hf-con-block-can')) {
																			alert("您的评论发表成功！");
																		} else {
																			alert("您的评论发表成功！");

																			console
																					.log(res)

																			var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name"style="font-size: 15px;"> '
																					+ res
																					+ ': </a><span class="my-pl-con" value=""style="font-size: 15px;">'
																					+ oAt
																					+ '</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'
																					+ now
																					+ '</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a></div> </div></div>';
																			th
																					.after(oHtml)
																					&& $(
																							"#"
																									+ oHfTop
																									+ "")
																							.find(
																									'.pl-hf')
																							.addClass(
																									'hf-con-block');
																		}
																	});
													$(this).parents('.hf-con')
															.remove()
												}
											});
						</script>

						<!--查看回复-->
						<script type="text/javascript">
							$('.comment-show')
									.on(
											'click',
											'.date-dz-z',
											function() {

												if ($(this).is(
														'.hf-con-block-can')) {
													var oHfName = $(this)
															.parents('.hf-con')
															.parents('.date-dz')
															.siblings(
																	'.pl-text')
															.find(
																	'.comment-size-name')
															.html();
													var oHfId = $(this)
															.parents('.hf-con')
															.parents('.date-dz')
															.siblings(
																	'.pl-text')
															.find('.my-pl-con')
															.attr("value");
													var oHfTop = $(this)
															.parents(
																	'.comment-show-con')
															.attr("value");
													console.log(oHfId)
													console.log(oHfTop)
													var oAllVal = '回复@'
															+ oHfName;
													$(this).removeClass(
															'hf-con-block-can');
													$
															.post(
																	"${ctx}/comment/findsoncomment",
																	{
																		oHfTop : oHfTop
																	},
																	function(
																			data) {
																		var res = $
																				.parseJSON(data);
																		var oAt = '';
																		var oHf = '';
																		var id;
																		$
																				.each(
																						res,
																						function(
																								n,
																								v) {
																							console
																									.log(res)
																							console
																									.log(1111111111111)
																							var arr;
																							var ohfNameArr;
																							var myDate = new Date(
																									v[1]);
																							//获取当前年
																							var year = myDate
																									.getFullYear();
																							//获取当前月
																							var month = myDate
																									.getMonth() + 1;
																							//获取当前日
																							var date = myDate
																									.getDate();
																							var h = myDate
																									.getHours(); //获取当前小时数(0-23)
																							var m = myDate
																									.getMinutes(); //获取当前分钟数(0-59)
																							if (m < 10)
																								m = '0'
																										+ m;
																							var s = myDate
																									.getSeconds();
																							if (s < 10)
																								s = '0'
																										+ s;
																							var now = year
																									+ '-'
																									+ month
																									+ "-"
																									+ date
																									+ " "
																									+ h
																									+ ':'
																									+ m
																									+ ":"
																									+ s;
																							if (v[1] == '') {
																								oAt = res.hfContent;
																							} else {
																								oAt = '回复<a href="#" class="atName" style="font-size: 15px;">@'
																										+ v[3]
																										+ '</a>  '
																										+ v[2];
																							}
																							oHf = oHfName;

																							var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name"style="font-size: 15px;">'
																									+ v[4]
																									+ ' : </a><span class="my-pl-con" value="'+v[0] +'"style="font-size: 15px;">'
																									+ oAt
																									+ '</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'
																									+ now
																									+ '</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> </div> </div></div>';

																							$(
																									"#"
																											+ oHfTop
																											+ "")
																									.find(
																											'.hf-list-con')
																									.css(
																											'display',
																											'block')
																									.prepend(
																											oHtml)
																									&& $(
																											"#"
																													+ oHfTop
																													+ "")
																											.find(
																													'.pl-hf')
																											.addClass(
																													'hf-con-block');
																						});
																	});
												} else {
													$(this).addClass(
															'hf-con-block-can');
													$(this)
															.parents('.date-dz')
															.siblings(
																	'.hf-list-con')
															.find('.all-pl-con')
															.remove();
												}

											})
						</script>



					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>

	<%@include file="footer.jsp"%>
</body>
</html>