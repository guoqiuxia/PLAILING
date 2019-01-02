<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>privacy</title>
<link href="${ctx }/css/whir_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css?=2016121272249">

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
					<div class="row privacy-title">隐私条款</div>
					<div class="row privacy-row">
						<p>E享课堂非常重视对您隐私的保护，请您仔细阅读如下声明。当您访问E享课堂网站或使用E享课堂提供的服务前，您需要同意隐私政策中具体解释的收集、使用、公布和以其它形式运用您或您的被代理人的个人信息的政策。如果您不同意隐私政策中的任何内容，请立即停止使用或访问E享课堂网站。</p>
						<p>
							为了给您提供更准确、更有针对性的服务，E享课堂可能会以如下方式，使用您提交的个人信息，但E享课堂会以高度的勤勉义务对待这些信息。</p>
						<p>
							我们的目标是使E享课堂成为IT在线实验方面最值得信任的网站，仅仅遵守标准的个人隐私保护条例是远远不够的。如果您对我们的隐私保护条款有任何疑问或建议，请发邮件support@shiyanlou.com</p>
						<br /> <br />
						<h3 class="privacy-h3">我们获得的资料</h3>
						<p>
							E享课堂会在您自愿选择服务或提供信息的情况下收集您的个人信息（简称"个人信息"），例如您的姓名、邮件地址、电话号码及其他身份信息等。我们有可能会保留一些用户的使用习惯信息（实验相关操作及数据），用于更好地了解和服务于用户。这些数据将有利于我们开发出更符合用户需求的功能、信息和服务。同时，这些信息将用于显示目标广告。</p>
						<p>
							我们可能会收集一些特定的关于您所使用的机器的技术信息，这些信息将用于提供更好的用户使用体验，提供更方便的服务，我们所收集的技术信息可能会包括：IP地址、操作系统版本、浏览器版本、显示器分辨率，推荐网站等。</p>

						<p>我们会记录您在E享课堂虚拟环境中的全部或部分操作行为（键盘及鼠标输入信息），此数据会用作E享课堂产品优化以及其他E享课堂及E享课堂合作方的数据分析应用。</p>

						<p>此外，我们还可能从其他合法来源收到关于您的信息并且将其加入我们的客户信息库。</p>

						<h3 class="privacy-h3">我们如何使用收集的用户信息</h3>

						<p>我们利用从所有服务中收集的信息来提供、维护、保护和改进这些服务，同时开发新的服务为您带来更好的用户体验，并提高我们的总体服务品质。经您的许可，我们还会使用此类信息为您提供定制内容，例如向您提供课程推送，职位推荐等。</p>

						<h3 class="privacy-h3">我们分享的信息</h3>

						<p>用户在如下情况下，E享课堂会遵照您的意愿或法律的规定披露您的个人信息，由此引发的问题将由您个人承担：</p>

						<p>（1）事先获得您的授权；</p>

						<p>（2）只有透露您的个人资料，才能使E享课堂或其合作商提供您所要求的产品和服务；</p>

						<p>（3）根据有关的法律法规要求；</p>

						<p>（4）按照相关政府主管部门的要求；</p>
						<p>（5）为维护E享课堂的合法权益；</p>

						<p>（6）您同意让第三方共享资料；</p>

						<p>（7）我们发现您违反了E享课堂公司服务条款或任何其他产品服务的使用规定。</p>

						<h3 class="privacy-h3">用户对个人信息的控制</h3>

						<p>E享课堂相信用户应该对他/她的个人信息拥有绝对的控制权，用户可以通过"修改个人信息"查看或修改个人信息。用户自愿注册个人信息，用户在注册时提供的所有信息，都是基于自愿，用户有权在任何时候拒绝提供这些信息。</p>

						<h3 class="privacy-h3">我们如何保护用户的个人信息</h3>

						<p>我们希望我们的用户放心的使用我们的产品和服务，所以我们承诺对您的个人信息予以保密，为此我们设置了安全程序保护您的信息不会被未经授权的访问所窃取。所有的个人信息被加密储存并放置于专业防火墙内，我们使用SSL加密技术对您所提供的个人信息传输通道进行保护，保证您的个人信息不会在传输途中被窃取。用户明确同意其使用网络服务所存在的风险将完全由其自己承担。</p>

						<h3 class="privacy-h3">Cookies和其他浏览器技术</h3>

						<p>当用户访问E享课堂的时候，我们可能会保存用户的用户登录状态并且为用户分配一个或多个"Cookie"（一个很小的文本文件），例如：当用户访问一个需要用户登录才可以提供的信息或服务，当用户登录时，我们会把该用户的登录名和密码加密存储在用户计算机的Cookie文件中，由于是不可逆转的加密存储，其他人即使可以使用该用户的计算机，也无法识别出用户的用户名和密码。用户并不需要额外做任何工作，所有的收集和保存都由系统自动完成。</p>

						<p>Cookie文件将永久的保存在您的计算机硬盘上，除非您使用浏览器或操作系统软件手工将其删除。您也可以选择"不使用Cookie"或"在使用Cookie是事先通知我"的选项禁止Cookie的产生，但是您将为此无法使用一些E享课堂的查询和服务。</p>

						<p>Cookie文件也可能会由E享课堂的第三方广告合作伙伴放置到您的计算机上。这些公司可能会根据您访问相关网站的统计信息为您显示您可能感兴趣的实验产品或广告信息。这些统计信息并不包括您的个人信息。他们也可能通过这种方式来评估广告的有效度，通常这是通过一种叫做Web
							beacon的技术来实现的，他们可能通过这种技术来统计匿名访问的数据，并根据统计结果显示您可能感兴趣的实验产品或广告信息，同样，这些统计信息并不包括您的个人信息。</p>


						<h3 class="privacy-h3">清除Cookie</h3>

						<p>您可以将自己的浏览器设置为拒绝所有 Cookie（包括与我们的服务相关联的 Cookie），或者在我们设置
							Cookie 时予以提示。但是请务必注意，如果您停用 Cookie，可能就无法正常使用我们的很多服务了。</p>


						<h3 class="privacy-h3">关于隐私条款的变更</h3>

						<p>本隐私条款自2014年5月1日起生效。E享课堂将根据法律、法规或政策的变更和修改，或E享课堂网站内容的变化和技术的更新，或其他E享课堂认为合理的原因，对本隐私政策进修改并以网站公告、用户通知等合适的形式告知用户，若您不接受修订后的条款的，应立即停止使用本服务，若您继续使用本服务的，视为接受修订后的所有条款。</p>
					</div>
				</div>

			</div>
		</div>
	</div>



	<%@include file="footer.jsp"%>
</body>
</html>