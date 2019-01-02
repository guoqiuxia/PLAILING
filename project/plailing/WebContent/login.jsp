<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	/**
	 * 刷新验证码
	 */
	function changeImg() {
		var imgSrc = $("#codeImg");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	//加入时间戳，去缓存机制   
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		if ((url.indexOf("&") >= 0)) {
			url = url + "&timestamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}
	
 	 function checkVerify(){
		var email = $('#email').val();
		var password = $('#password').val();
		var captcha_v = $('#captcha_v').val();
		$.ajax({
			url:'verify',
			data:{
				'email':email,
				'password':password,
				'captcha_v':captcha_v
			},
			type:'post',
			asyn:false,
			success:function(result){
				console.log(134);
				if(result=="1"){
					window.location.href='register?email='+email+'&password='+password+'&captcha_v='+captcha_v;
					
				}else if(result=="2"){
					document.getElementById("point").innerHTML = "";
					
				}else if(result=="3"){
					document.getElementById("point").innerHTML = "";
				
				}else if(result=="4"){
					document.getElementById("point").innerHTML = "验证码错误";
				
				}else if(result=="5"){
					document.getElementById("point").innerHTML = "";
				
				}else if(result=="6"){
					document.getElementById("point").innerHTML = "验证码错误";
				
				}else if(result=="7"){
					document.getElementById("point").innerHTML = "验证码错误";
				
				}else if(result=="8"){
					document.getElementById("point").innerHTML = "邮箱、密码和验证码不能为空";
				}
			}
		})	
	} 
 	 
 	function checkVerifyE(){
 		var email = $('#email').val();
 		$.ajax({
 			url:'verifyEmail',
 			data:{
 				'email':email
 			},
 			type:'post',
 			asyn:false,
 			success:function(result){
 				if(result=="email pass"){
 					document.getElementById("emailPoint").innerHTML ="";
 				}else if(result =="email exist"){
 					document.getElementById("emailPoint").innerHTML ="邮箱已注册";
 				}else if(result=="email not pass"){
 					document.getElementById("emailPoint").innerHTML = "邮箱格式由字母、数字、下划线、中划线组成5-20位";
 				}
 			}
 		})	
 	}
 	 
 	 function checkVerifyP(){
		var password = $('#password').val();
		$.ajax({
			url:'verifyPassword',
			data:{
				'password':password
			},
			type:'post',
			asyn:false,
			success:function(result){
				if(result=="password pass"){
					document.getElementById("passwordPoint").innerHTML ="";
				}else{
					document.getElementById("passwordPoint").innerHTML = "密码格式数字、字母、下划线组成6-19位";
				}
			}
		})	
	}
 	 	 
 	function verifyUser(){
 		var lemail=$('#lemail').val();			
			$.ajax({
				url:'verifyUser',
				data:{
					'email':lemail
				},
				type:'post',
				asyn:false,				
				success:function(result){
			 		if(result=="email can use"){
			 			document.getElementById("notNull").innerHTML ="";
			 		}else if(result=="email not exist"){
						document.getElementById("notNull").innerHTML ="用户不存在";
					}else if(result="email error"){
						document.getElementById("notNull").innerHTML ="邮箱错误";
					}					
				}
			})	
 	}
 	
 	function toLogin(){
 		var lemail=$('#lemail').val();
 		var lpassword =$('#lpassword').val(); 		
			$.ajax({
				url:'login',
				data:{
					'email':lemail,
					'password':lpassword
				},
				type:'get',
				asyn:false,
				success:function(result){
					if(result=="false"){
					    document.getElementById("notNull").innerHTML ="邮箱或密码错误";  
					}else if(result=="true"){
						window.location.href='index';
					}
				}
			})	
 		
 	}


</script>
<div class="modal fade" id="sign-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<button type="button" class="close-modal" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<div class="modal-body">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#signin-form"
						aria-controls="signin-form" role="tab" data-toggle="tab">登录</a></li>
					<li role="presentation"><a href="#signup-form"
						aria-controls="signup-form" role="tab" data-toggle="tab">注册</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="signin-form">
						<form method="post" onkeydown="if(event.keyCode==13) return toLogin();">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope" style="margin: 0;"></i>
									</div>
									<input type="text" name="email" class="form-control"
										id="lemail" placeholder="请输入邮箱" 
										onblur="verifyUser()"/>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-lock" style="margin: 0;"></i>
									</div>
									<input type="password" name="password" class="form-control"
										placeholder="请输入密码" id="lpassword">
								</div>
							</div>
							<div><span id="notNull" style="color:red;font-size:12px;"></span></div>
							<div class="form-group remember-login">
								<input name="remember" type="checkbox" value="y"> 下次自动登录
								<a class="pull-right" href="${ctx }/forgetpwd1.jsp">忘记密码？</a>
							</div>
							<div class="form-group">
								<button class="btn btn-primary" type="button" onclick="toLogin()">登录</button>
							</div>
							<div class="form-group widget-signin">
								<span>快速登录</span> <a href="${ctx }//auth/qq?next="><i
									class="fa fa-qq"></i></a> <a href="/auth/weibo?next="><i
									class="fa fa-weibo"></i></a> <a href="/auth/weixin?next="><i
									class="fa fa-weixin"></i></a>
							</div>
							<div class="form-group error-msg">
								<span id="tip"></span>
							</div>
						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="signup-form">
						<c:set var="ctx" value="${pageContext.request.contextPath}" />
						<form method="post" onkeydown="if(event.keyCode==13) return checkVerify();">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope" style="margin: 0;"></i>
									</div>
									<input type="text" name="email" class="form-control"
										placeholder="请输入邮箱" id="email" onblur="checkVerifyE()">									
								</div>
								<span id="emailPoint" style="color:red;font-size:2px;"></span>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-lock" style="margin: 0;"></i>
									</div>
									<input type="password" name="password" class="form-control"
										placeholder="请输入密码" id="password" onblur="checkVerifyP()">
								</div>
								<span id="passwordPoint" style="color:red;font-size:2px;"></span>
								
							</div>													
							<div class="form-inline">
								<div class="form-group">
									<div class="input-group">
										<input type="text" name="captcha_v" class="form-control"
											placeholder="请输入验证码" id="captcha_v">
									</div>
								</div>
								<img id="codeImg" src="${ctx}/captcha" onclick="changeImg()">
							</div>
							<span id="point" style="color:red;font-size:2px;"></span>
							<div class="form-group">
								<input class="btn btn-primary" type="button"
									onclick="checkVerify()" value="注册">
							</div>
							<div class="form-group agree-privacy">
								注册表示您已经同意我们的<a href="${ctx }/privacy.jsp" target="_blank">隐私条款</a>
							</div>
							<div class="form-group widget-signup">
								<span>快速注册</span> <a href="/auth/qq?next="><i
									class="fa fa-qq"></i></a> <a href="/auth/weibo?next="><i
									class="fa fa-weibo"></i></a> <a href="/auth/weixin?next="><i
									class="fa fa-weixin"></i></a>
							</div>
							<div class="form-group error-msg">
								<div class="alert alert-danger" role="alert"></div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="app/dest/lib/lib.js?=2016121272249"></script>
<script src="static/jquery/2.2.4/jquery.min.js"></script>
<script src="static/ace/1.2.5/ace.js"></script>
<script src="static/aliyun/aliyun-oss-sdk-4.3.0.min.js"></script>
<script src="static/highlight.js/9.8.0/highlight.min.js"></script>
<script src="static/jspdf/1.2.61/jspdf.min.js"></script>
<script src="static/plupload/2.1.9/js/plupload.full.min.js"></script>
<script src="static/zeroclipboard/2.2.0/ZeroClipboard.min.js"></script>
<script src="static/videojs/video.min.js"></script>
<script src="static/bootstrap-tour/0.11.0/js/bootstrap-tour.min.js"></script>
<script src="static/bootstrap-table/1.11.0/bootstrap-table.min.js"></script>
<script
	src="static/bootstrap-table/1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script
	src="static/bootstrap-table/1.11.0/extensions/filter-control/bootstrap-table-filter-control.min.js"></script>

<script src="static/ravenjs/3.7.0/raven.min.js"></script>
<script>
	Raven.config(
			'https://bc3878b7ed0a4468a65390bd79e6e73f@sentry.shiyanlou.com/5',
			{
				release : '3.12.13'
			}).install();
</script>




<div id="jinja-data" data-post-url=""></div>

<script src="app/dest/frontend/index.js?=2016121272249"></script>