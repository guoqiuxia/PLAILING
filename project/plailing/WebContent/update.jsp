<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Lei Shi">
<meta http-equiv="Cache-Control" content="o-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="csrf-token"
	content="1483758872##fd2cac389b2b7c009a744bcaecaa41d71592cfe8">
<title>update</title>
<link href="${ctx }/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/whir_grzx.css" rel="stylesheet" type="text/css" />


<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet"
	href="${ctx }/app/css/libs/videojs/5.11.7/video-js.min.css">
<script type="text/javascript" src="${ctx }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function checkNickName(){
	var Name = $("#nickName").val();
	if(Name == ""){
		document.getElementById("nickNameSpan").innerHTML = "昵称不可为空哦";
	}else if(Name.length<2 ){
		document.getElementById("nickNameSpan").innerHTML = "昵称长度最少2字符";
	}else{
		document.getElementById("nickNameSpan").innerHTML = "";
	}

}
function checkPWD(){
	var password = $("#password").val();
	if(password.length<6 || password.length>19){
		document.getElementById("pwdSpan").innerHTML = "密码长度范围为6-19";
	}
	$.ajax({
		url:'${ctx}/user/checkPWD',
		data:{
			'password':password
		},
		type:'post',
		asyn:false,
		success:function(result){
			if(result!="pass"){
				document.getElementById("pwdSpan").innerHTML = "密码为6-19位的数字、字母、下划线";
			}else{
				document.getElementById("pwdSpan").innerHTML = "";
			}
		}
	})
	if(identity==""){
		document.getElementById("pwdSpan").innerHTML = "";
	}
}
function checkPWD1(){
	var confirm_password = $("#confirm_password").val();
	var password = $("#password").val();
	if(password!=confirm_password){
		document.getElementById("pwd1Span").innerHTML = "前后密码不一致哦";
	}
	if(password == confirm_password){
		document.getElementById("pwd1Span").innerHTML = "";
	}
}
function checkPhone(){
	var phone = $("#phone").val();
	if(phone == ""){
		document.getElementById("phoneSpan").innerHTML = "手机号码不可为空哦";
	}
	if(phone.length<11 || phone.length>11){
		document.getElementById("phoneSpan").innerHTML = "手机号码长度错误";
	}
	$.ajax({
		url:'${ctx}/user/checkPhone',
		data:{
			'phone':phone
		},
		type:'post',
		asyn:false,
		success:function(result){
			if(result!="pass"){
				document.getElementById("phoneSpan").innerHTML = "手机号码只能为数字哦";
			}
		}
	})
	if(phone.length==11){
		document.getElementById("phoneSpan").innerHTML = "";
	}
}
function checkID(){
	var identity = $("#identity").val();
	if(identity.length!=18){
		document.getElementById("identitySpan").innerHTML = "身份证号码长度错误";
	}
	$.ajax({
		url:'${ctx}/user/checkID',
		data:{
			'identity':identity
		},
		type:'post',
		asyn:false,
		success:function(result){
			if(result!="pass"){
				document.getElementById("identitySpan").innerHTML = "请输入合法身份证号";
			}
		}
	})
	if(identity==""){
		document.getElementById("identitySpan").innerHTML = "";
	}
	if(identity.length == 18){
		document.getElementById("identitySpan").innerHTML = "";
	}
}
$(function(){   //设置input date最大为当前时间
    //得到当前时间
	var date_now = new Date();
	//得到当前年份
	var year = date_now.getFullYear();
	//得到当前月份
	//注：
	//  1：js中获取Date中的month时，会比当前月份少一个月，所以这里需要先加一
	//  2: 判断当前月份是否小于10，如果小于，那么就在月份的前面加一个 '0' ， 如果大于，就显示当前月份
	var month = date_now.getMonth()+1 < 10 ? "0"+(date_now.getMonth()+1) : (date_now.getMonth()+1);
	//得到当前日子（多少号）
	var date = date_now.getDate() < 10 ? "0"+date_now.getDate() : date_now.getDate();
	//设置input标签的max属性
	$("#birthday").attr("max",year+"-"+month+"-"+date);
})
$(document).ready(function(){  //获取省+市并添加到后面的隐藏域
	$("#province").click(function(){
		var provinceText = $("#province").find("option:selected").text(); //获取Select选择的Text 
		console.log(provinceText);//控制台输出当前所选字符串
		$("#province_selected").attr("value",provinceText);//将所选添加为隐藏域value值
		var province = $("#province_selected").value;
	});
	$("#city").click(function(){
		var cityText = $("#city").find("option:selected").text(); //获取Select选择的Text 
		console.log(cityText);//控制台输出当前所选字符串
		$("#city_selected").attr("value",cityText);//将所选添加为隐藏域value值
		var city = $("#city_selected").value;
	});
	
});
function checkInfo(){
	var nickName = document.getElementById("nickNameSpan").innerHTML;
	var password = document.getElementById("pwdSpan").innerHTML;
	var Cpassword = document.getElementById("pwd1Span").innerHTML;
	var phone = document.getElementById("phoneSpan").innerHTML;
	var ID = document.getElementById("identitySpan").innerHTML;
	if(nickName=="" && password=="" && Cpassword=="" && phone=="" && ID==""){
		var sure=confirm("确认修改个人信息？");
		if(sure==true){
			return true;
		}else{
			return false;
		}
		
	}else{
		document.getElementById("checkInfoSpan").innerHTML = "请再次检查个人信息是否符合要求";
		return false;
	}
}
</script>
</head>
<body>
<script type="text/javascript">
var isIE = /msie/i.test(navigator.userAgent) && !window.opera; 
function fileChange(target,id) { 
	var fileSize = 0; 
	var filetypes =[".jpg",".png",".gif",".jpeg"]; 
	var filepath = target.value; //图片文件路径
	var filemaxsize = 1024*2;//2M 
	if(filepath){ 
		var isnext = false; 
		var fileend = filepath.substring(filepath.indexOf(".")); //截取字符串
		if(filetypes && filetypes.length>0){ //检索有无文件格式要求
			for(var i =0; i<filetypes.length;i++){ //挨个比对文件格式
				if(filetypes[i]==fileend){ 
					isnext = true; 
					document.getElementById("uploadSpan").innerHTML = ""; 
					break; 
				} 
			} 
		} 
		if(!isnext){ 
			document.getElementById("uploadSpan").innerHTML = "请上传jpg/png/gif/jpeg类型图片"; 
			target.value =""; 
			return false; 
		} 
	}else{ 
		document.getElementById("uploadSpan").innerHTML = "";
		return false; 
	} 
	if (isIE && !target.files) {    //获取当前文件大小
		var filePath = target.value; 
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject"); 
		if(!fileSystem.FileExists(filePath)){ 
			alert("附件不存在，请重新输入！"); 
			return false; 
		} 
		var file = fileSystem.GetFile (filePath); 
		fileSize = file.Size; 
	} else { 
		fileSize = target.files[0].size; 
	} 
	var size = fileSize / 1024; 
	if(size>filemaxsize){ 
		document.getElementById("uploadSpan").innerHTML = "图片大小不能大于"+filemaxsize/1024+"M"; 
		target.value =""; 
		return false; 
	} else{
		document.getElementById("uploadSpan").innerHTML = "";
		return true;
	}
}  
</script>
	<div id="header">
		<%@include file="header.jsp"%>
	</div>
	<div class="clear"></div>
	<!--container-->
	<div class="subbox">
		<!-- 左侧部分 -->
		<%@include file="left.jsp"%>
		<!-- 右侧部分 -->
		<div class="right840">
			<div class="title6">
				<h1>
					<a href="${ctx }/information?userId=${leftUser.userId}">个人信息</a>
				</h1>
				<h1>
					<a href="${ctx }/user/findInfo" class="on">修改信息</a>
				</h1>
			</div>
			<div class="display">
				<form class="cmxform" id="signupForm" action="${ctx }/user/update" method="post" enctype="multipart/form-data" onsubmit="return checkInfo()">
					<table width="840" height="900" align="center" cellspacing="0"
						cellpadding="0" class="tab">
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>昵称:</b></td>
							<td>&nbsp;&nbsp;&nbsp;
								<input id="nickName" class="input1" type="text" name="nickName" value="${userInfo.nickName }" 
								onblur="checkNickName()" />
								&nbsp;&nbsp;&nbsp;
								<span id="nickNameSpan" style="font-size:12px;color:red"></span>
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>邮箱:</b></td>
							<td>&nbsp;&nbsp;&nbsp;
								<input id="cemail" type="email" class="input1" 
								name="email" value=" ${userInfo.email }" readonly>&nbsp;&nbsp;&nbsp; <%--暂定邮箱不让更改 --%>
								<span id="email" style="font-size:12px;color:red">注册邮箱不可修改哦</span>
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>新密码:</b></td>
							<td>&nbsp;&nbsp;&nbsp;
								<input id="password" class="input1" type="password" name="password" 
								value="${userInfo.password}" onblur="checkPWD()">
								<span id="pwdSpan" style="font-size:12px;color:red" ></span>
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>确认密码:</b></td>
							<td>&nbsp;&nbsp;&nbsp;
								<input id="confirm_password" class="input1" type="password" name="confirm_password" 
								value="${userInfo.password}" onblur="checkPWD1()">
								<span id="pwd1Span" style="font-size:12px;color:red"></span>
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>头像:</b></td>
							<td>&nbsp;&nbsp;&nbsp;
								<input id="up_file" type="file" name="up_file" onchange="fileChange(this);" 
								accept="image/gif,image/jpg,image/jpeg,image/png">
								<span id="uploadSpan" style="font-size:12px;color:red"></span>
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>性别:</b></td>
							<td>&nbsp;&nbsp;&nbsp;
								<input id="r1" type="radio" value="0" name="gender" /> 男 
								<input id="r2" type="radio" value="1" name="gender" /> 女
								<input id="r3" type="hidden" value="${userInfo.sex }" name="gender" />
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>所在地:</b></td>
							<td id="nativePlace">&nbsp;&nbsp;&nbsp; 
								<input id="province_selected" name="province_selected" value="${userInfo.nativeProvince }" type="hidden">
								<input id="city_selected" name="city_selected" value="${userInfo.nativeCity }" type="hidden">
								<select id="province" name="province" class="input1" >
									<option value="-1">${userInfo.nativeProvince }</option>
									<option value="0">北京</option>
        							<option value="1">天津</option>
        							<option value="2">河北</option>
        							<option value="3">山西</option>
        							<option value="4">内蒙古</option>
        							<option value="5">辽宁</option>
        							<option value="6">吉林</option>
        							<option value="7">黑龙江</option>
        							<option value="8">上海</option>
									<option value="9">江苏</option>
        							<option value="10">浙江</option>
        							<option value="11">安徽</option>
        							<option value="12" >福建</option>
        							<option value="13" >江西</option>
        							<option value="14" >山东</option>
        							<option value="15" >河南</option>
        							<option value="16" >湖北</option>
        							<option value="17" >湖南</option>
        							<option value="18" >广东</option>
        							<option value="19" >广西</option>
        							<option value="20" >海南</option>
        							<option value="21" >重庆</option>
        							<option value="22" >四川</option>
        							<option value="23" >贵州</option>
        							<option value="24" >云南</option>
        							<option value="25" >陕西</option>
        							<option value="26" >甘肃</option>
        							<option value="27" >青海</option>
        							<option value="28" >宁夏</option>
        							<option value="29" >新疆</option>
        							<option value="30" >台湾</option>
        							<option value="31" >香港特别行政区</option>
        							<option value="32" >澳门特备别行政区</option>
								</select> &nbsp; 
								<select id="city" name="city" class="input1" >
									<option>${userInfo.nativeCity }</option>
								</select> &nbsp; 
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>出生日期:</b></td>
							<td>&nbsp;&nbsp;&nbsp; 
								<input id="birthday" class="input1" value="${userInfo.birthday }" type="date" name="birthday" max=nowDate />
								<span id="" style="font-size:12px;color:red"></span>
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>手机:</b></td>
							<td>&nbsp;&nbsp;&nbsp; 
								<input id="phone" type="text" class="input1" name="phone" 
								value="${userInfo.phoneNumber }" onblur="checkPhone()"
								onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" />
								&nbsp;&nbsp;&nbsp;
								<span id="phoneSpan" style="font-size:12px;color:red"></span>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>身份证号:</b></td>
							<td>&nbsp;&nbsp;&nbsp; 
								<input id="identity" type="text" class="input1" name="identityNumber" 
								value="${userInfo.identityNumber }" onblur="checkID()"
								onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" /> &nbsp;&nbsp;&nbsp;<%--可以设置点击查看 --%>
								<span id="identitySpan" style="font-size:12px;color:red"></span>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>学校:</b></td>
							<td>&nbsp;&nbsp;&nbsp; 
								<input type="text" class="input1" name="school" value="${userInfo.school }" /> &nbsp;&nbsp;&nbsp;
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td><font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>专业:</b></td>
							<td>&nbsp;&nbsp;&nbsp; 
								<input type="text" class="input1" name="major" value="${userInfo.major }" /> &nbsp;&nbsp;&nbsp;
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<%--<tr>兴趣爱好在数据库中没有这个列，这里暂时注释
							<td>&nbsp;&nbsp;&nbsp;<b>兴趣爱好:</b></td>
							<td>&nbsp;&nbsp;&nbsp; <textarea name="textarea"
									class="input4" style="width: 430px; height: 130px;"></textarea></td>
						</tr> --%>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;<b>个人介绍:</b></td>
							<td>&nbsp;&nbsp;&nbsp; 
								<textarea class="input1"  name="introduction" value="${userInfo.introduction }" style="width: 430px; height: 130px; resize: none;">${userInfo.introduction }</textarea>
							</td>
						</tr>

						<tr>
							<td></td>
							<td colspan="2">&nbsp;&nbsp;&nbsp; 
								<input type="submit" value="保存信息" class="btn1" /> &nbsp;&nbsp;&nbsp; 
								<input type="reset" value="取消" class="btn4" />
								<span id="checkInfoSpan" style="font-size:12px;color:red"></span>
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>
	</div>
	<div class="clear"></div>


	</div>

	<%@include file="footer.jsp"%>
</body>
<script src="${ctx }/js/province_city.js" ></script>

</html>