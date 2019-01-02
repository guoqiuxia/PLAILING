<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<title>coursecomment</title>

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet"
	href="${ctx}/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx}/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/dest/styles.css?=2016121272249">
<link rel="stylesheet"
	href="${ctx}/restatic/js/libs/marked/katex/katex.min.css">
<link rel="stylesheet" href="${ctx}/css/style.css">
<link rel="stylesheet" href="${ctx}/css/comment.css">

<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flexText.js"></script>

<script type="text/javascript"
	src="${ctx}/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function isJoin(email1,courseId,uploadId){
	if(email1==''){
		alert("请您登录后再加入课程！")
	}else{
		var con=confirm("您加入此课程需扣除您账户余额，是否确定加入此课程？");
		if(con==true){			
			var xmlhttp;
			if(window.XMLHttpRequest){
				xmlhttp=new XMLHttpRequest();
			}else{
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.open("GET","detailJoin?courseId="+courseId+"&uploadUser="+uploadId,true);
			xmlhttp.send();
			xmlhttp.onreadystatechange=function(){
				if(xmlhttp.readyState==4 && xmlhttp.status==200){
					var res=xmlhttp.responseText;
					if(res=="fail"){
						alert("您已加入过此课程，不能重复加入！");
					}else if(res=="checkfail"){
						alert("您的余额不足，请先去个人中心充值后在进行购买！");
					}else if(res=="buy"){
						document.getElementById("joinflag").value=1;
						alert("购买成功，钱数已从余额中扣除！");
					}else if(res=="emailempty"){
						alert("请您先进行登录，如果没有登录不能收藏此课程!");
					}
				}
			}
		}
	}

}


function insertc(btn2,textbox,courseId,courseCommentId){
		var allcontent=document.getElementsByName("courseCommentText");
			for(var i=0;i<allcontent.length;i++){
			if(allcontent[i].value!=''){
				textbox.style.display = "none";
				btn2.style.display = "none";
				var content=allcontent[i].value;
				var xmlhttp;
				if(window.XMLHttpRequest){
					xmlhttp=new XMLHttpRequest();
				}else{
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.open("GET","insertAnswerCourseComment?courseId="+courseId+"&content="+content+"&courseCommentId="+courseCommentId,true);
				xmlhttp.send();
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4 && xmlhttp.status==200){
						var res=xmlhttp.responseText;
						if(res=="ok"){
							alert("您的评论发表成功,请去查看回复进行查看！");
						}else if(res=="false"){
							alert("您的评论发表失败!");
						}else if(res="emailempty"){
							alert("请您先登录，然后在回复其他人的评论");
						}
					}	
				}
				allcontent[i].value='';
				break;
			}
			}
	
}

function checklogin(emai){
	if(emai==''){
		alert("请您先进行登录,如果没有登录将不能发表评论！")
	}
}

function stare(stare,starf,courseId){
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET","insertdetailCollection?courseId="+courseId,true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			var res=xmlhttp.responseText;
			if(res=="ok"){
				stare.style.display = "none";
				starf.style.display = "block";
				alert("您以收藏成功！");
			}else if(res=="false"){
				alert("您收藏失败!");
			}else if(res=="emailempty"){
				alert("请您先进行登录，如果没有登录不能收藏此课程");
			}
		}	
	}
}

function starf(stare,starf,courseId){	
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET","canceldetailCollection?courseId="+courseId,true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			var res=xmlhttp.responseText;
			if(res=="ok"){
				starf.style.display = "none";
				stare.style.display = "block";
				alert("您以取消收藏！");
			}else if(res=="false"){
				alert("您取消收藏失败!");
			}else if(res=="emailempty"){
				alert("请您先进行登录，如果没有登录不能收藏此课程");
			}
		}	
	}
}
</script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

body {
	color: #666;
	font: 12px/1.5 Arial;
}
/* star */
#star {
	position: relative;
	width: 300px;
	margin: 20px auto;
	height: 24px;
}

#star ul, #star span {
	height: 5px;
	line-height: 19px;
}

#star ul {
	margin: 15px 0px;
}

#star li {
	float: left;
	width: 24px;
	cursor: pointer;
	text-indent: -9999px;
	background: url(img/star.png) no-repeat;
}

#star strong {
	color: #f60;
	padding-left: 10px;
}

#star li.on {
	background-position: 0 -28px;
}

#star p {
	position: absolute;
	top: 50px;
	width: 159px;
	height: 60px;
	display: none;
	background: url(img/icon.gif) no-repeat;
	padding: 7px 10px 0;
}

#star p em {
	color: #f60;
	display: block;
	font-style: normal;
}

#title {
	font-size: 20px;
	color: #03a57cd9;
}

#title1 {
	font-size: 15px;
	color: #03a57cd9;
}
</style>

<script type="text/javascript">
window.onload = function (){
	var temp = $('#grade').val();
	
	var oStar = document.getElementById("star");
	var aLi = oStar.getElementsByTagName("li");
	var oUl = oStar.getElementsByTagName("ul")[0];
	var oSpan = oStar.getElementsByTagName("span")[1];
	var oP = oStar.getElementsByTagName("p")[0];
	var i = iScore = iStar = 0;
	var aMsg = [
				"很不满意|差得太离谱，与课程描述严重不符",
				"不满意|部分讲解不清楚，与课程描述的不符",
				"一般|讲解一般，没有课程描述的那么好",
				"满意|讲解不错，与课程描述的基本一致",
				"非常满意|讲课质量非常好，与课程描述的完全一致"
				]
	
	for (i = 1; i <= aLi.length; i++){
		aLi[i - 1].index = i;
		//鼠标移过显示分数
		aLi[i - 1].onmouseover = function (){
			fnPoint(this.index);
			//浮动层显示
			oP.style.display = "block";
			//计算浮动层位置
			oP.style.left = oUl.offsetLeft + this.index * this.offsetWidth - 104 + "px";
			//匹配浮动层文字内容
			oP.innerHTML = "<em><b>" + this.index + "</b> 分 " + aMsg[this.index - 1].match(/(.+)\|/)[1] + "</em>" + aMsg[this.index - 1].match(/\|(.+)/)[1]
		};
		aLi[i - 1].onmouseout = function(){
			for (j = 0; j < aLi.length; j++) {
				aLi[j].className = "";	
			}
			oP.style.display = "none";
		}
		//如果评过分显示评分结果,并且取消移动效果
		if(temp!=0&&temp!=11){
			aLi[i-1].onmouseover=null;
			aLi[i-1].className = (i-1) < temp ? "on" : "";
			oSpan.innerHTML = "<br/><strong>" + (temp) + " 分</strong>(" + aMsg[temp - 1].match(/\|(.+)/)[1] + ")"
			aLi[i-1].onmouseout=null;
		}
		//点击后进行评分处理
		aLi[i - 1].onclick = function (){
			var joinflag = $('#joinflag').val();
			var temp1 = $('#grade').val();
			oSpan.style.display = "block";
			iStar = this.index;
			oP.style.display = "none";
			//如果没有登录
			if(temp1==11){
				alert("请登录后再评分");
				for (j = 0; j < aLi.length; j++) 
					aLi[j].className = "";	
			}else{
				if(joinflag==0){
					alert("请先加入课程再评分");
					for (j = 0; j < aLi.length; j++) 
						aLi[j].className = "";	
				}else{
					//如果评过分点击
					if(temp1!=0&&temp1!=11){
						alert("不能重复评分");
						oSpan.innerHTML = "<br/><strong>" + (temp1) + " 分</strong>(" + aMsg[temp1 - 1].match(/\|(.+)/)[1] + ")"
					}
					//如果没有评过分时点击
					if(temp1==0){
						var courseId = $('#courseId').val(); 
						var grade = this.index;
						var con = confirm("一个课程只能评分一次，确认评分");
						if(con==true){
							for (j = 1; j <= aLi.length; j++){
								aLi[j - 1].onmouseout=null;
							}
							$.ajax({
								url:'makeScore',
								data:{
									'courseId':courseId,
									'grade':grade
								},
								type:'post',
								asyn:false,
								success:function(result){
									document.getElementById("grade").value = result;
									for (j = 1; j <= aLi.length; j++){
										aLi[j - 1].onmouseover=null;
									}
									oSpan.style.display = "block";
									oSpan.innerHTML = "<br/><strong>" + (result) + " 分</strong>(" + aMsg[result - 1].match(/\|(.+)/)[1] + ")"
									window.location.href='${ctx}/courseDetail?courseId='+courseId;
								}
							})	
						}else{
							for (j = 0; j < aLi.length; j++) 
								aLi[j].className = "";	
						}
					}
				}

			}

		}
	}
	//评分处理
	function fnPoint(iArg){
		//分数赋值
		iScore = iArg || iStar;
		for (i = 0; i < aLi.length; i++) aLi[i].className = i < iScore ? "on" : "";	
	}
	
};
</script>

</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container layout layout-margin-top">


		<div class="row">
			<div class="col-md-9 layout-body">


				<div class="content course-infobox">
					<div class="clearfix course-infobox-header">
						<h4 class="pull-left course-infobox-title">

							<span>${course.name}</span>

						</h4>
						<div class="pull-right course-infobox-follow">
							<span>收藏</span>&nbsp;&nbsp; <a> <c:if
									test="${isCollection=='fail'}">
									<span style="display: block; float: right; clear: right"
										id="star1" onclick="stare(star1,star2,${courseId})">☆</span>
									<span style="display: none; float: right; clear: right"
										id="star2" onclick="starf(star1,star2,${courseId})">★</span>
								</c:if> <c:if test="${isCollection=='ok'}">
									<span style="display: block; float: right; clear: right"
										id="star3" onclick="starf(star4,star3,${courseId})">★</span>
									<span style="display: none; float: right; clear: right"
										id="star4" onclick="stare(star4,star3,${courseId})">☆</span>
								</c:if>
							</a>

						</div>
					</div>
					<div class="clearfix course-infobox-body">
						<div class="sidebox1 mooc-teacher" border="0">
							<div class="sidebox-body mooc-content">
								<a href="/user/20406" target="_blank"> <img
									src="${course.photo }">
								</a>
								<div class="mooc-info">
									<div class="name">
										综合评分：<strong>${course.grade}</strong>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学习人数：<strong>${studypeople }</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										课程价格：<strong>￥${course.price}</strong><input type="submit"
											id="fl" class="input8" value="加入课程"
											onclick="javascript:isJoin('${uemail }',${courseId},${uploaduser})" />
									</div>
								</div>
								<div class="mooc-extra-info">
									<div class="word long-paragraph">
										<p>课程简介：</p>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${course.courseInfo }</p>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="content">
					<ul class="nav nav-tabs" role="tablist">

						<li role="presentation"><a
							href="courseDetail?courseId=${courseId}">课程章节</a></li>

						<li role="presentation"><a
							href="coursecomment?courseId=${courseId}">课程评论</a></li>
					</ul>
					<div class="tab-content">

						<div role="tabpanel" class="tab-pane active" id="labs">
							<input type="hidden" id="getjoin" value="${isj}" />
							<input type="hidden" id="getEmail" value="${uemail}" />
							<input type="hidden" id="getcourseId" value="${courseId}" />
							<div class="commentAll1">
								<!--评论区域 begin-->
								<div class="reviewArea clearfix">
									<textarea class="content comment-input"
										placeholder="Please enter a comment&hellip;"
										onkeyup="keyUP(this)"></textarea>
									<a href="javascript:;" class="plBtn">评论</a>
								</div>
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
								<span class="wordstyle">共${pageCommentList.totalPageNum}页</span>&nbsp;&nbsp;&nbsp; 
								<a class="wordstyle"
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
								    $(function () {
								        $('.content').flexText();
								    });
							</script>
							<!--textarea限制字数-->
							<script type="text/javascript">
								    function keyUP(t){
								        var len = $(t).val().length;
								        if(len > 139){
								            $(t).val($(t).val().substring(0,140));
								        }
								    }
								</script>
							<!--点击评论创建评论条-->
							<script type="text/javascript">

								    $('.commentAll1').on('click','.plBtn',function(){
								    	var photo;
								    	var name;
								    	var courseCommentId;
								    	var commentTime;
								    	var state;
								    	var oHtml;
								    	var courseId=document.getElementById("getcourseId").value;
								    	var uemail = document.getElementById("getEmail").value;
								        var myDate = new Date();
								        //获取当前年
								        var year=myDate.getFullYear();
								        //获取当前月
								        var month=myDate.getMonth()+1;
								        //获取当前日
								        var date=myDate.getDate();
								        var h=myDate.getHours();       //获取当前小时数(0-23)
								        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
								        if(m<10) m = '0' + m;
								        var s=myDate.getSeconds();
								        if(s<10) s = '0' + s;
								        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
								        //获取输入内容
								        var oSize = $(this).parents('.reviewArea ').find('.comment-input').val();
								        if(uemail!=""){
								        	if(oSize!=""){

								        $.post("insertCourseComment",{'text':oSize,'courseId':courseId},function(data){
								        	
								        		console.log(2)
								        		console.log(data)
								        		var res = $.parseJSON(data);
									        	console.log(res);
									        	$.each(res,function(i,n){
									        		state=parseInt(n[4]);
											        console.log(state);
									        		if(state==1){
										        		photo=n[0];
										        		name=n[1];
										        		courseCommentId=n[2];
										        		var commentTime1=n[3];
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
												        
										        		/* var RexStr = /\<|\>/g;
										        		oSize = oSize.replace(RexStr, function(MatchStr) {  
										        		      switch (MatchStr) {  
										        		      case "<":  
										        		        return "< ";  
										        		        break;  
										        		      case ">":  
										        		        return " >";  
										        		        break;
										        		      default:  
										        		        break;  
										        		      }  
										        		    });*/
									        		
									        			alert("您的评论以发表成功！");
											        	
												        
												        //动态创建评论模块
												        oHtml = '<div class="comment-show-con clearfix" value="'+courseCommentId+'" id="'+courseCommentId+'"><div class="comment-show-con-img pull-left"><img src="'+photo+'" alt="user photo" style="width:50px;height:50px;"></div> <div class="comment-show-con-list1 pull-left clearfix">'+
												        '<div class="pl-text clearfix"><a href="#" class="comment-size-name1">'+name+': </a> <span class="my-pl-con1" value="'+courseCommentId+'">&nbsp;'+oSize+'</span></div> <div class="date-dz">'+
												        '<span class="date-dz-left pull-left comment-time">'+commentTime+'</span><div class="date-dz-right pull-right comment-pl-block">'+
												        ' <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span><a href="javascript:;" class="date-dz-z pull-left hf-con-block-can"><i class="date-dz-z-click-red"></i>查看回复</a></div> </div><div class="hf-list-con"></div></div></div>';
												        
												        console.log(oHtml);
												        if(oSize.replace(/(^\s*)|(\s*$)/g, "") != ''){
												            $('.plBtn').parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
												            $('.plBtn').parents('.reviewArea ').find('.comment-input').prop('value','').siblings('pre').find('span').text('');
												        }
									        		}else if(state==0){
									        			alert("请加入课程后在发表评论！");
									        			 if(oSize.replace(/(^\s*)|(\s*$)/g, "") != ''){    
													            $('.plBtn').parents('.reviewArea ').find('.comment-input').prop('value','').siblings('pre').find('span').text('');
													       }
									        		}
									        	});
								        });
								        	}else{
									        	alert("评论的内容不能为空！");
									        }}else{
									        	alert("请您登录后在发表评论！");
									        }
								    });
								</script>
							<!--点击回复动态创建回复块-->
							<script type="text/javascript">
								    $('.comment-show').on('click','.pl-hf',function(){
								        //获取回复人的名字
								        var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name1').html();
								        //回复@
								        var fhN = '回复@'+fhName;
								        //var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
								        var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
								        //显示回复
								        if($(this).is('.hf-con-block')){
								            $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
								            $(this).removeClass('hf-con-block');
								            //$('.content').flexText();
								            $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding','6px 15px');
								            //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
								            //input框自动聚焦
								            //$(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
								        }else {
								            $(this).addClass('hf-con-block');
								            $(this).parents('.date-dz-right').siblings('.hf-con').remove();
								        }
								    });
								</script>
							<!--评论回复块创建-->
							<script type="text/javascript">
								    $('.comment-show').on('click','.hf-pl',function(){
								    	 var courseId=document.getElementById("getcourseId").value;
								    	 var oThis = $(this);
								    	 var myDate = new Date();
								        //获取当前年
								        var year=myDate.getFullYear();
								        //获取当前月
								        var month=myDate.getMonth()+1;
								        //获取当前日
								        var date=myDate.getDate();
								        var h=myDate.getHours();       //获取当前小时数(0-23)
								        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
								        if(m<10) m = '0' + m;
								        var s=myDate.getSeconds();
								        if(s<10) s = '0' + s;
								        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
								        var oAt ='';
									     var th=$(this).parents('.hf-con').parents('.all-pl-con').css('display','block')
								        //获取输入内容
								        var oHfVal = $(this).parents('.hf-con').find('.hf-input').val();
								        var oHfTop =$(this).parents('.hf-con').parents('.comment-show-con').attr("value");
								        console.log("sssssssss")
								        console.log(oHfVal)
								        console.log("sssssssss")
								        var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
								        var oHfId = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.my-pl-con1').attr("value");
								        var username=$(this).parents('.hf-con').parents('.date-dz').parents('.comment-show').attr("value");
								        console.log(oHfId)
								        console.log(username)
								        var oAllVal = '回复@'+oHfName;
								        if(now == ''){
					                        oAt = res.hfContent;
					                    }else {
					                        oAt = '回复<a href="#" class="atName" >@'+oHfName+'</a> '+oHfVal;
					                    }
								        // || oHfVal == oAllVal
								        if(oHfVal.replace(/^ +| +$/g,'') == '' ){
								
								        }else {
								            $.post("insertAnswerCourseComment",{'text':oHfVal,'commentPid':oHfId,'courseId':courseId,oHfTop:oHfTop},function(result){
								            	if(result=="emailempty"){
								            		alert("请您登陆后在回复评论！");
								            	}else if(result="ok"){
								            		if($("#"+oHfTop+"").find('.comment-show-con-list').find('.date-dz-z').is('.hf-con-block-can')){
										            	console.log(1547)
										            }else{
										            	console.log(2222)
										                var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">'+username+':</a><span class="my-pl-con" value="">'+oAt+'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a></div> </div></div>';
										                th.after(oHtml) && $("#"+oHfTop+"").find('.pl-hf').addClass('hf-con-block');
										            }
								            		alert("您的评论发表成功！");
								            	}else if(result=="false"){
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
									$('.comment-show').on('click','.date-dz-z',function(){
										if($(this).is('.hf-con-block-can')){
									        var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
									        var oHfId = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.my-pl-con').attr("value");
									        var oHfTop =$(this).parents('.comment-show-con').attr("value");
									        console.log(oHfId)
									        console.log(oHfTop)
									        var oAllVal = '回复@'+oHfName;
									        $(this).removeClass('hf-con-block-can');
								            $.post("${ctx}/findsoncomment",{oHfTop:oHfTop},function(data){
								            	var res = $.parseJSON(data);
								                var oAt = '';
								                var oHf = '';
								                var id;
								                $.each(res,function(n,v){
								                	console.log(res)
								    
								                    var arr;
								                    var ohfNameArr;
								                    var myDate = new Date(v[1]);
											        //获取当前年
											        var year=myDate.getFullYear();
											        //获取当前月
											        var month=myDate.getMonth()+1;
											        //获取当前日
											        var date=myDate.getDate();
											        var h=myDate.getHours();       //获取当前小时数(0-23)
											        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
											        if(m<10) m = '0' + m;
											        var s=myDate.getSeconds();
											        if(s<10) s = '0' + s;
											        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
								                    if(v[1] == ''){
								                        oAt = res.hfContent;
								                    }else {
								                        oAt = '回复<a href="#" class="atName" >@'+v[3]+'</a>  '+v[2];
								                    }
								                    oHf = oHfName;
								                
								
								                var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">'+v[4]+' : </a><span class="my-pl-con1" value="'+v[0] +'">'+oAt+'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a></div> </div></div>';
								                
								                $("#"+oHfTop+"").find('.hf-list-con').css('display','block').prepend(oHtml) && $("#"+oHfTop+"").find('.pl-hf').addClass('hf-con-block');
								                });
								            });
										}else {
								            $(this).addClass('hf-con-block-can');
								            $(this).parents('.date-dz').siblings('.hf-list-con').find('.all-pl-con').remove();
								        }									
										
									})
								</script>
						</div>

					</div>
				</div>


			</div>
			<div class="col-md-3 layout-side">

				<div class="side-image-pc">
					<div id="star">
						<span id="title">给课程打个分吧！</span>
						<ul>
							<li><a href="javascript:;">1</a></li>
							<li><a href="javascript:;">2</a></li>
							<li><a href="javascript:;">3</a></li>
							<li><a href="javascript:;">4</a></li>
							<li><a href="javascript:;">5</a></li>
						</ul>
						<span id="title1"></span> <input type="hidden"
							value="<%=request.getParameter("courseId")%>" id="courseId"
							name="courseId" /> <input type="hidden" value="${myGrade}"
							id="grade" name="grade" /> <input type="hidden"
							value="${joinflag}" id="joinflag" name="joinflag" />
						<p></p>
					</div>
				</div>

				<div class="sidebox mooc-teacher" style="margin-top: 100px;">
					<div class="sidebox-header mooc-header">
						<h4 class="sidebox-title">课程教师</h4>
					</div>
					<div class="sidebox-body mooc-content">
						<a href="information.jsp" target="_blank"> <img
							src="img/Linux&c.png">
						</a>
						<div class="mooc-info">
							<div class="name">
								<strong>${uploadCourseUser.nickName}</strong>
							</div>

							<div class="courses">
								共发布过<strong>${uploadCourseCount}</strong>门课程
							</div>
						</div>
						<div class="mooc-extra-info">
							<div class="word long-paragraph">
								${uploadCourseUser.introduction}</div>
						</div>
					</div>
					<div class="sidebox-footer mooc-footer">
						<a href="information.jsp" target="_blank">查看老师的所有课程 ></a>
					</div>
				</div>


				<!-- 此处展示老师的另外一些课程 -->
				<div class="wordstyle">
					<strong>类似课程</strong>
				</div>
				<c:forEach items="${mpc}" var="lc">
					<div class="col-md-14 col-sm-16  course">
						<a class="course-box"
							href="courseDetail?courseId=${lc.key.courseId}">
							<div class="course-img">

								<img alt="${lc.key.name}" src="${lc.key.photo}">

							</div>

							<div class="course-body">
								<span class="course-title">${lc.key.name}</span>
							</div>
							<div class="course-footer">
								<span class="course-per-num pull-left">${lc.value}</span>

							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>

	<script type="text/javascript">
	function textframe(btn1,btn2,textbox){
		var oBtn1 = btn1;
		var oBtn2 = btn2;
		var oText = textbox;
		oBtn1.onclick = function() {
			oText.style.display = "block";
			oBtn2.style.display = "block";
		}	
	}
	</script>

</body>
</html>