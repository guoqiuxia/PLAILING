<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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
<link href="${ctx }/css/whir_common.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx }/css/whir_grzx.css" rel="stylesheet" type="text/css" />

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
<link rel="stylesheet" href="${ctx }/css/style.css">
<link rel="stylesheet" href="${ctx }/css/comment.css">
<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js">
	
</script>
<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flexText.js"></script>
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
					<a href="${ctx }/relatecomment/find">问答</a>
				</h1>
				<h1>
					<a href="${ctx }/relatecoursecomment/find" class="on">课程评论</a>
				</h1>
			</div>
			<div role="tabpanel" class="tab-pane active" id="labs">

				<input type="hidden" id="getcourseId" value="${courseId}" />
				<div class="commentAll1">
					<!--评论区域 begin-->

					<!--评论区域 end-->
					<!--回复区域 begin-->
					<div class="comment-show" value="${user.nickName }">
						<c:forEach items="${commentList}" var="c">
							<div class="comment-show-con clearfix"
								value="${c.courseCommentId }" id="${c.courseCommentId }">
								<div class="comment-show-con-img pull-left">
									<img src="${ctx }/${c.user.photo}" alt="user photo"
										style="width: 50px; height: 50px;">
								</div>
								<div class="comment-show-con-list1 pull-left clearfix">
									<div class="pl-text clearfix">
										<a href="#" class="comment-size-name1">${c.user.nickName}:
										</a> <span class="my-pl-con1" value="${c.courseCommentId }">&nbsp;${c.text}</span>
										<div class="date-dz-right pull-right comment-pl-block">

											<a href="${ctx}/coursecomment?courseId=${c.course.courseId}"
												class="date-dz-pl pl-hf hf-con-block pull-left">${c.course.name}</a>
										</div>
									</div>
									<div class="date-dz">
										<span class="date-dz-left pull-left comment-time">${c.commentTime}</span>
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
					<!--回复区域 end-->
				</div>


				<div class="pagination-container pagemiddle">
					<span class="wordstyle">共${pageCommentList.totalPageNum}页</span> <a
						class="wordstyle"
						href="coursecomment?courseId=${courseId}&pageNum=1"> 首页 </a>
					&nbsp;&nbsp;&nbsp; <a class="wordstyle"
						href="coursecomment?courseId=${courseId}&pageNum=${pageCommentList.prePageNum}">
						上一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
						href="coursecomment?courseId=${courseId}&pageNum=${pageCommentList.nextPageNum}">
						下一页 </a>&nbsp;&nbsp;&nbsp; <a class="wordstyle"
						href="coursecomment?courseId=${courseId}&pageNum=${pageCommentList.totalPageNum}">
						末页 </a>&nbsp;&nbsp;&nbsp;
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
					$('.commentAll1')
							.on(
									'click',
									'.plBtn',
									function() {
										var photo;
										var name;
										var courseCommentId;
										var commentTime;
										var commenttext;
										var oHtml;
										var courseId = document
												.getElementById("getcourseId").value;

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
										var now = year + '-' + month + "-"
												+ date + " " + h + ':' + m
												+ ":" + s;
										//获取输入内容
										var oSize = $(this).parents(
												'.reviewArea ').find(
												'.comment-input').val();
										$
												.post(
														"insertCourseComment",
														{
															'text' : oSize,
															'courseId' : courseId
														},
														function(data) {

															console.log(2)
															console.log(data)
															var res = $
																	.parseJSON(data);
															console.log(res);
															$
																	.each(
																			res,
																			function(
																					i,
																					n) {
																				photo = n[0];
																				name = n[1];
																				courseCommentId = n[2];
																				var commentTime1 = n[3];
																				var commentTime2 = new Date(
																						commentTime1);
																				var year = commentTime2
																						.getFullYear();
																				//获取当前月
																				var month = commentTime2
																						.getMonth() + 1;
																				//获取当前日
																				var date = commentTime2
																						.getDate();
																				var h = commentTime2
																						.getHours(); //获取当前小时数(0-23)
																				var m = commentTime2
																						.getMinutes(); //获取当前分钟数(0-59)
																				if (m < 10)
																					m = '0'
																							+ m;
																				var s = commentTime2
																						.getSeconds();
																				if (s < 10)
																					s = '0'
																							+ s;
																				commentTime = year
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
																				commenttext = n[4];
																			});
															alert("您的评论以发表成功！");

															console
																	.log(courseId)
															console.log(photo)
															console.log(name)
															console
																	.log(courseCommentId)
															console
																	.log(commentTime)
															console
																	.log(commenttext)
															//动态创建评论模块
															oHtml = '<div class="comment-show-con clearfix" value="'+courseCommentId+'" id="'+courseCommentId+'"><div class="comment-show-con-img pull-left"><img src="'+photo+'" alt="user photo" style="width:50px;height:50px;"></div> <div class="comment-show-con-list1 pull-left clearfix">'
																	+ '<div class="pl-text clearfix"><a href="#" class="comment-size-name1">'
																	+ name
																	+ ': </a> <span class="my-pl-con1" value="'+courseCommentId+'">&nbsp;'
																	+ commenttext
																	+ '</span></div> <div class="date-dz">'
																	+ '<span class="date-dz-left pull-left comment-time">'
																	+ commentTime
																	+ '</span><div class="date-dz-right pull-right comment-pl-block">'
																	+ ' <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span><a href="javascript:;" class="date-dz-z pull-left hf-con-block-can"><i class="date-dz-z-click-red"></i>查看回复</a></div> </div><div class="hf-list-con"></div></div></div>';

															console.log(oHtml);
															if (oSize
																	.replace(
																			/(^\s*)|(\s*$)/g,
																			"") != '') {
																$('.plBtn')
																		.parents(
																				'.reviewArea ')
																		.siblings(
																				'.comment-show')
																		.prepend(
																				oHtml);
																$('.plBtn')
																		.parents(
																				'.reviewArea ')
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
															}
														});
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
										var fhName = $(this).parents(
												'.date-dz-right').parents(
												'.date-dz')
												.siblings('.pl-text').find(
														'.comment-size-name1')
												.html();
										//回复@
										var fhN = '回复@' + fhName;
										//var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
										var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
										//显示回复
										if ($(this).is('.hf-con-block')) {
											$(this).parents('.date-dz-right')
													.parents('.date-dz')
													.append(fhHtml);
											$(this).removeClass('hf-con-block');
											//$('.content').flexText();
											$(this).parents('.date-dz-right')
													.siblings('.hf-con').find(
															'.pre').css(
															'padding',
															'6px 15px');
											//console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
											//input框自动聚焦
											//$(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
										} else {
											$(this).addClass('hf-con-block');
											$(this).parents('.date-dz-right')
													.siblings('.hf-con')
													.remove();
										}
									});
				</script>
				<!--评论回复块创建-->
				<script type="text/javascript">
					$('.comment-show')
							.on(
									'click',
									'.hf-pl',
									function() {
										var courseId = document
												.getElementById("getcourseId").value;
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
										var now = year + '-' + month + "-"
												+ date + " " + h + ':' + m
												+ ":" + s;
										var oAt = '';
										var th = $(this).parents('.hf-con')
												.parents('.all-pl-con').css(
														'display', 'block')
										//获取输入内容
										var oHfVal = $(this).parents('.hf-con')
												.find('.hf-input').val();
										var oHfTop = $(this).parents('.hf-con')
												.parents('.comment-show-con')
												.attr("value");
										console.log("sssssssss")
										console.log(oHfVal)
										console.log("sssssssss")
										var oHfName = $(this)
												.parents('.hf-con').parents(
														'.date-dz').siblings(
														'.pl-text').find(
														'.comment-size-name')
												.html();
										var oHfId = $(this).parents('.hf-con')
												.parents('.date-dz').siblings(
														'.pl-text').find(
														'.my-pl-con1').attr(
														"value");
										var username = $(this).parents(
												'.hf-con').parents('.date-dz')
												.parents('.comment-show').attr(
														"value");
										console.log(oHfId)
										console.log(username)
										var oAllVal = '回复@' + oHfName;
										if (now == '') {
											oAt = res.hfContent;
										} else {
											oAt = '回复<a href="#" class="atName" style="font-size: 15px;">@'
													+ oHfName
													+ '</a> '
													+ oHfVal;
										}
										// || oHfVal == oAllVal
										if (oHfVal.replace(/^ +| +$/g, '') == '') {

										} else {
											$
													.post(
															"insertAnswerCourseComment",
															{
																'text' : oHfVal,
																'commentPid' : oHfId,
																'courseId' : courseId,
																oHfTop : oHfTop
															},
															function(result) {
																if (result == "emailempty") {
																	alert("请您登陆后在回复评论！");
																} else if (result = "ok") {
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
																		console
																				.log(1547)
																	} else {
																		console
																				.log(2222)
																		var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name"style="font-size: 15px;">'
																				+ username
																				+ ':</a><span class="my-pl-con" value=""style="font-size: 15px;">'
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
																	alert("您的评论发表成功！");
																} else if (result == "false") {
																	alert("您的评论发表失败，请重新发送！");
																}

															});

											oThis.parents('.hf-con').remove();

											//});
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
										if ($(this).is('.hf-con-block-can')) {
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
													'.my-pl-con').attr("value");
											var oHfTop = $(this).parents(
													'.comment-show-con').attr(
													"value");
											console.log(oHfId)
											console.log(oHfTop)
											var oAllVal = '回复@' + oHfName;
											$(this).removeClass(
													'hf-con-block-can');
											$
													.post(
															"${ctx}/findsoncomment",
															{
																oHfTop : oHfTop
															},
															function(data) {
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
																							+ ' : </a><span class="my-pl-con1" value="'+v[0] +'"style="font-size: 15px;">'
																							+ oAt
																							+ '</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'
																							+ now
																							+ '</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a></div> </div></div>';

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
											$(this)
													.addClass(
															'hf-con-block-can');
											$(this).parents('.date-dz')
													.siblings('.hf-list-con')
													.find('.all-pl-con')
													.remove();
										}

									})
				</script>
			</div>
		</div>
	</div>
	<div class="clear" style="height: 7px;"></div>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>