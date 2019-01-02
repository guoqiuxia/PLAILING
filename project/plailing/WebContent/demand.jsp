<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>demand</title>

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
function addDemand(emai,pageNum,count){
	var text=document.getElementById("searchw").value;
	var content='';
	if(emai!=""){
		if(text!=""){
			$.ajax({
				url:'addDemand',
				data:{
					'search':text,
					'pageNum':pageNum
				},
				type:'get',
				asyn : false,
				success:function(result){
					if(result=='ok'){
	               		document.getElementById("adddemand").href='demand';
	               		window.location.href='demand';
	               		alert("您的需求已发布成功！");
					}else{
						alert("您的需求发表失败！");
					}
	            }
 			 });
 			document.getElementById("searchw").value="";
		}else{
			alert("需求内容不能为空！")
		}
	}else{
		alert("请您先登录然后在发表需求！");
	}
}

function searchWord(){
	if(event.which!=16){
		//1、获得输入框的输入的内容
		var word = $("#searchw").val();
		console.log(word+"ccc");
		document.getElementById("searchMsg").innerHTML="";
		$("#searchMsg").hide();
		//2、根据输入框的内容去数据库中模糊查询---List<Product>
		$.ajax({
			url:'search',
			data:{
				'searchWord':word
			},
			type:'post',
			asyn:false,
			success:function(listDemand){
				var msg = $.parseJSON(listDemand);
				console.log(msg+"aaa");
				var res="";
				for(var i in msg){
					console.log(msg[i]+"bbb");
					res=res+"<p onmousedown='getText(div"+i+")' id='div"+i+"'>"+msg[i]+"</p>";
				}
				if(msg.length!=0){
					document.getElementById("searchMsg").innerHTML=res;
					$("#searchMsg").show();
				}
			}
		});
	}
}

function getText(divi){
	var text=divi.innerHTML;
	document.getElementById("searchw").value=text;
	$("#searchMsg").hide();
}

 function hidei(){
	$("#searchMsg").hide();
}  



</script>

</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container layout layout-margin-top"  style="width:1000px;">
		<div class="content">
			<form AUTOCOMPLETE="OFF">
				<input type="text" class="demandform" name="search" id="searchw"
					placeholder="一句话简述您的需求" onkeyup="searchWord()" onblur="hidei()">
					<a href="#" onclick="addDemand('${email}',${pageNum},${count})" id="adddemand"><input type="button" class="btn btn-primary" value="发布"></a>
				 	<div id="searchMsg" class="demandform" style="width:400px;height:auto;position:absolute; z-index:2;margin-top:-30px;display:none;"></div><!-- -->
			</form>
		<div style="position:relative; z-index:1;">
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation"><a href="#">需求热搜</a></li>
			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="labs">
				<c:forEach items="${listDemand}" var="ld">
					<div class="lab-item ">
						<div>
							<h4>${count=count+1}</h4>
						</div>
						<div>${ld.text}</div>
						<div class="pull-right lab-item-ctrl">
							<a class="btn btn-primary" href="${ctx}/left1">我要开课</a>
						</div>
					</div>
				</c:forEach>
					<div class="pagination-container pagemiddle">
						<span class="wordstyle">共${pageDemand.totalPageNum}页</span>&nbsp;&nbsp;&nbsp;
						<a class="wordstyle" href="${ctx}/demand?pageNum=1"> 首页 </a> &nbsp;&nbsp;&nbsp; <a
							class="wordstyle" href="${ctx}/demand?pageNum=${pageDemand.prePageNum}"> 上一页 </a>&nbsp;&nbsp;&nbsp; <a
							class="wordstyle" href="${ctx}/demand?pageNum=${pageDemand.nextPageNum}"> 下一页 </a>&nbsp;&nbsp;&nbsp; <a
							class="wordstyle" href="${ctx}/demand?pageNum=${pageDemand.totalPageNum}"> 末页 </a>&nbsp;&nbsp;&nbsp;
					</div>
				</div>


			</div>
		</div>
		</div>
	</div>
	<%@include file="login.jsp"%>
	<%@include file="footer.jsp"%>

</body>
</html>