<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>aboutus</title>
<link href="${ctx }/css/whir_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css?=2016121272249">

<link rel="shortcut icon" href="${ctx }/favicon.ico">
<link rel="stylesheet"
	href="${ctx }/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet" href="${ctx }/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/videojs/5.11.7/video-js.min.css">
<style>
@font-face {
	font-family: "lantingxihei";
	src: url("fonts/FZLTCXHJW.TTF");
}

/* modal 模态框*/
#invite-user .modal-body {
	overflow: hidden;
}

#invite-user .modal-body .form-label {
	margin-bottom: 16px;
	font-size: 14px;
}

#invite-user .modal-body .form-invite {
	width: 80%;
	padding: 6px 12px;
	background-color: #eeeeee;
	border: 1px solid #cccccc;
	border-radius: 5px;
	float: left;
	margin-right: 10px;
}

#invite-user .modal-body .msg-modal-style {
	background-color: #7dd383;
	margin-top: 10px;
	padding: 6px 0;
	text-align: center;
	width: 100%;
}

#invite-user .modal-body .modal-flash {
	position: absolute;
	top: 53px;
	right: 74px;
	z-index: 999;
}
/* end modal */
.en-footer {
	padding: 30px;
	text-align: center;
	font-size: 14px;
}
</style>
<style>
.privacy-title {
	font-weight: 100;
	font-family: "Microsoft Yahei";
	color: #1ABC9C;
	font-size: 32px;
}

.privacy-container {
	margin-bottom: 15px;
	background-color: #FFFFFF;
	box-shadow: #CCCCCC 0px 1px 3px 0px;
	padding: 40px;
}

.privacy-row {
	padding: 25px;
}

.privacy-h3 {
	margin-bottom: 24px;
	font-weight: 100;
	font-family: "Microsoft Yahei";
	color: #1ABC9C;
	font-size: 24px;
}

.privacy-row p {
	line-height: 32px;
	color: #6B767D;
	font-size: 16px;
	font-weight: 100;
}
</style>
</head>
<body>
	<!--头部-->
	<%@include file="header.jsp"%>

	<div class="container layout layout-margin-top">


		<div class="row">
			<div class="col-md-12 layout-body">

				<div class="container content privacy-container">
					<div class="row privacy-title">关于我们</div>
					<div class="row privacy-row">
						<h3 class="privacy-h3">平台简介</h3>
						<p>通过经营综合性互联网教育平台，我们向广大用户提供着覆盖种类多元化，具备高度互动特质的优秀互联网教育产品及服务，并以此展示了我们先进的互联网技术和对教育行业的透彻理解。</p>
						

						<h3 class="privacy-h3">业务体系</h3>

						<p>作为于提供互联网教育产品及服务，我们专注于开发可促进学习及改善学习表现的重要技术工具、媒介、程序及数据资源。尤其是，我们已成功开发我们自有的智能学习系统，该系统包含相互嵌合，且完善兼容的一系列技术或功能模块。整体而言，该等项目可有效将互联网技术改造应用在教师及学员于学习及认知过程中经历的各个场景，包括「教、学、练、测」。于管理自有品牌课程业务分部时，除采用该系统外，我们亦促使在我们平台注册的相关商户或自雇网师使用该平台上提供的功能，作为我们技术服务的一部份。</p>

						<h3 class="privacy-h3">特色班块</h3>

						<p> e享课堂笔记功能为视频学习做了专门设计。学习者添加笔记 时会自动保存视频的当前时间点，回顾笔记时就可观看当时 视频。学习者还可以对视频截图或上传本地图片保存到笔记 当中， 使得保存老师的板书、重要信息更快捷。学习者可将 笔记公开，也可评论、收藏他人笔记，加强了用户间学习交 流。用户还可以给网络教学视频课程评分来决定教学视频的 质量。</p>

						<p>系列课程</p>
						<p>将某一领域的内容进行打包并有序地呈现，给用户提供完整 的、有体系的学习方案。解决用户有计划学习某项技能，但 是又不知道应该如何开始学起的问题，同时能够让学员快 速、全面地掌握相关知识点。 进度管理与学习监督 e享课堂更关注用户个人学习的效率和效果。学习者学习过程 中，e享课堂支持自动\手动标记课时完成状态，或标记为“重 要\有疑问”等，以便用户回顾和把控学习进度。另外，用 户可设置课程的学习时间安排，e享课堂会定期发送提醒通知用户。</p>
						<p>帮助中心</p>
						<p>我怎样才能注册登录 e享课堂？ 您可以使用邮箱帐号登录 e享课堂。如果您还没有邮箱，您可以注册邮箱，注册成功后登录至 e享课堂。 为什么用电脑访问 e享课堂时视频无法播放？ 当您使用电脑访问 e享课堂时： − 支持浏览器 Chrome10.0+、FireFox4.0+、IE7.0+版本； − 必须安装 flash10+版本 我可以在 e享课堂中开设自己的课程吗？ 还有其他问题的话登录 xx网站进行查询或拨打电话或通过 微信公众号进行查询。</p>
						<p>退款规则</p>
						<p>1、非微专业课程： A、用户购买课程之日起 7天内非平台（即网易云课堂， 下同）技术原因不予退款。平台技术原因是指：由平 台技术故障引发的连续超过 24小时课程无法正常观 看、视频无法正常播放、PPT/PDF课程无法观看。如用户个人网络原因、观看设备故障、用户账号丢失等 类原因不属于平台技术故障。 B、用户购买超过 7天后一律不予退款。</p>
						<p>2、微专业课程： A、购买后 7日内且未开课，可无条件退款。其余情况， 非平台技术原因不予退款。 （平台技术原因是指：由平台技术故障引发的连续超 过 24小时课程无法正常观看、视频无法正常播放、PPT/PDF课程无法观看。如用户个人网络原因、观看 设备故障、用户账号丢失等类原因不属于平台技术故 障。） B、微专业不支持子订单或单门课程退款。 </p>
						<p> 3、参加特价优惠或促销活动课程： A、参加特价优惠或促销活动的退款规则以具体活动 规则为准。</p>
						<p> 4、iOSApp内购买课程： A、所有在苹果公司 iOSApp内购买课程不享受以上 退款服务。 </p>
						<p>5、使用花呗支付的课程： A、用户通过平台使用花呗支付的课程订单与与以上规 则一致，具体使用规则请参考花呗常见问题问答</p>
						<p>学习者在学习过程中可随时提问。e享课堂会根据问题 内容将问题呈现给相关学习者或讲师，帮助用户快速 获得答案。</p>
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<%@include file="login.jsp" %>



	<%@include file="footer.jsp"%>
</body>
</html>