<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>application</title>
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





<script type="text/javascript" src="${ctx}/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">


	function applicationsite(){
		var sitetype=document.getElementById("sitetype").value;
		var usetime=document.getElementById("usetime").value;
		var courseId=document.getElementById("courseId").value;
		var uselang=document.getElementById("uselang").value;
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET","insertApplicationSite?sitetype="+sitetype+"&usetime="+usetime+"&uselang="+uselang+"&courseId="+courseId,true);
		xmlhttp.send();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				var res=xmlhttp.responseText;
				if(res=="empty"){
					alert("请完善你的信息！");
				}else if(res=="ok"){
					alert("您的申请提交成功，请等候消息！");
					document.getElementById("sitetype").value="";
					document.getElementById("usetime").value="";
					document.getElementById("uselang").value="";
				}else if(res=="userTimefail"){
					alert("您的申请提交失败，请查看您的使用时间是否填写有误！");
				}else if(res=="warn"){
					alert("您的申请提交成功，由于天数小于两天，成功性较低，请耐心等候消息！");
					document.getElementById("sitetype").value="";
					document.getElementById("usetime").value="";
					document.getElementById("uselang").value="";
				}
				 else if(res=="userlangfail"){
					alert("您的申请提交失败，请查看您的使用时长是否填写有误！");
				}else if(res=="fail"){
					alert("后台出现错误，请重新填写！");
				}else if(res=="timefail"){
					alert("您输入的时长不符合要求！");
				}
			}
		}
	}
	
function checkType(){
	var type=document.getElementById("sitetype").value;
	if(type==""){
		document.getElementById("type").innerHTML="场地类型不能为空！";
	}else{
		document.getElementById("type").innerHTML="";
	}
}
function checkTime(){
	var utime=document.getElementById("usetime").value;
	if(utime==""){
		document.getElementById("uTime").innerHTML="时间不能为空！";
	}else{
		document.getElementById("uTime").innerHTML="";
	}
}
function checkLang(){
	var lang=document.getElementById("uselang").value;
	if(lang==""){
		document.getElementById("lang").innerHTML="申请时长不能为空！";
	}else{
		document.getElementById("lang").innerHTML="";
	}
}
</script>

</head>
<body>

	<div id="header">
		<%@include file="header.jsp"%>
	</div>
	<div class="clear"></div>
	<div class="subbox">
		<!--左侧部分-->
		<%@include file="left.jsp"%>
		<!--右侧部分-->
		<div class="right840">
			<div class="title6">
				<h1>
					<a href="${ctx}/applicationSite?courseId=${courseId}" class="on">申请场地</a>
				</h1>
			</div>

			<div class="display">
				<div class="videoinfo1">
					<div class="left502">
						<form class="wordstyle">
							<input type="hidden" id="courseId" value="${courseId}">
							<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>场地类型:</b> <select
							id="sitetype"	name="sitetype" style="width: 325px; height: 25px;" onblur="checkType()">
								<option value="公教楼">公教楼</option>
								<option value="四方广场">四方广场</option>
								<option value="风雨操场">风雨操场</option>
								<option value="图书馆报告厅">图书馆报告厅</option>
								<option value="美设报告厅">美设报告厅</option>
								<option value="篮球场">篮球场</option>
							</select><span id="type" style="color:red; font-size:2px;"></span></br>
							</br>
							</br> <font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>使用时间:</b> <input
								type="datetime-local" name="usetime" id="usetime" onblur="checkTime()">
								<span id="uTime" style="color:red; font-size:2px;"></span></br>
								<font size="2px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;填写的时间应该是当前时间的两天以后</font>
								</br>
							</br>
							</br> <font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>使用时长:</b> <input
								type="text" name="uselang" id="uselang" onblur="checkLang()">
								<span id="lang" style="color:red; font-size:2px;"></span></br>
								<font size="2px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用的时间应该在0-4小时之间</font>
								</br>
							</br>
							</br> <input type="button" value="申请场地" class="input8" onclick="applicationsite()"/>
						</form>
					</div>
					<script type="text/javascript" src="${ctx}/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	//敲击按键时触发
	$("#uselang").bind("keypress", function (event) {
	var event = event || window.event;
	var getValue = $(this).val();
	//控制第一个不能输入小数点"."
	if (getValue.length == 0 && (event.which == 46 || event.which==110)) { 
		console.log("1");
		document.getElementById("lang").innerHTML="第一个不能输入小数点！";
		event.preventDefault();
		return;
	}
	//控制只能输入一个小数点"."
	if (getValue.indexOf('.') != -1 && (event.which == 46 || event.which==110)) {
		console.log("3");
		document.getElementById("lang").innerHTML="只能输入一个小数点！";
		event.preventDefault();
		return;
	}
	//控制只能输入的值
	/* event.which<48 || (event.which>52 && event.which<96 ) || event.which>100*/
	if(event.which && (event.which < 48 || event.which > 53) && event.which!=8 && event.which!=46){
		console.log("2");
		document.getElementById("lang").innerHTML="输入的值有错误！";
		event.preventDefault();
		return;
	}else{
		document.getElementById("lang").innerHTML="";
	}
	});
})

//屏蔽粘贴  
document.onpaste = function (event){  
    if(window.event){  
        event = window.event;  
    }try{  
        var the = event.srcElement;  
        if (!(the.tagName == "INPUT" && the.type.toLowerCase() == "text")){  
            return false;  
        }  
        return true;  
    }catch (e){  
        return false;  
    }  
}  
</script>
				</div>
			</div>


		</div>
		<div class="clear" style="height: 38px;"></div>
		</div>
		<%@include file="footer.jsp"%>
</body>
</html>