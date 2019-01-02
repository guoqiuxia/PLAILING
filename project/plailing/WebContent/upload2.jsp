<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<title>upload2</title>

<link href="${ctx}/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/whir_grzx.css" rel="stylesheet" type="text/css" />

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link rel="stylesheet"
	href="${ctx}/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${ctx}/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet"
	href="${ctx}/app/css/dest/styles.css?=2016121272249">

 <style type="text/css">
        h1 {
		    text-align:center;
		}
		form {
		    width:600px;
		    margin:auto;
		    padding:20px 50px;
		    border:1px solid #03a57c;
		    border-radius:10px;
		    display:block;
		}
		input {
		    font-size:24px;
		    margin:10px;
		}
		.clear {
		    clear:both;
		}
		.speed_box {
		    width:600px;
		    height:20px;
		    display:none;
		    border:1px solid #03a57c;
		    border-radius:10px;
		    overflow:hidden;
		}
		#file_box {
		    width:100%;
		    height:250px;
		    border:1px solid #03a57c;
		    border-radius:10px;
		    display:inline-block;
		    background:#EEE;
		    overflow:hidden;
		    z-index:999999;
		}
		#speed {
		    width:0;
		    height:100%;
		    background:#03a57c;
		    color:white;
		    text-align:center;
		    line-height:20px;
		    font-size:16px;
		}
		#file_size,#file_type,#file_time {
		    display:inline-block;
		    padding:5px 0px;
		    font-size:16px;
		    color:#03a57c;
		    font-weight:bold;
		}
		.opts_btn {
		    position:relative;
		    display:inline-block;
		    padding:8px 16px;
		    font-size:16px;
		    color:white;
		    text-decoration:none;
		    background:#03a57c;
		    border:2px solid #03a57c;
		    border-radius:3px;
		    cursor:pointer;
		    overflow:hidden;
		}
		.oFile {
		    position:absolute;
		    width:100%;
		    height:100%;
		    z-index:10;
		    top:0px;
		    left:0px;
		    opacity:0;
		}
		.send_btn {
		    display:inline-block;
		    display:none;
		    float:right;
		    margin-top:20px;
		    padding:8px 16px;
		    font-size:16px;
		    color:white;
		    background:#03a57c;
		    border:1px solid transparent;
		    border-radius:2px;
		    cursor:pointer;
		}

    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
 	<script type="text/javascript">
 		var ot;
 		var oloaded;
 		var filemaxsize = 1024*1024;
 		var isIE = /msie/i.test(navigator.userAgent) && !window.opera; 
		//文件选择完毕时
		function FileChangeFn(event) {
		    $('.opst_txt').text('重新选择文件');

		    var event = event || window.event,
		        dom = '',
		        ofile = $("#oFile").get(0).files[0],
		        otype = ofile.type || '获取失败',
		        osize = ofile.size / 1048576,

		        filetypes =["video/mp4","video/flv"];
		        ourl = window.URL.createObjectURL(ofile); //文件临时地址
		        dom = '<video id="video" width="100%" height="100%" controls="controls" autoplay="autoplay" src=' + ourl + '></video>';
	        if(ofile){
	            var isnext = false;
	            var fileend = otype;
	            if(filetypes && filetypes.length>0){
	                for(var i =0; i<filetypes.length;i++){
	                    if(filetypes[i]==fileend){
	                        isnext = true;
	                        break;
	                    }
	                }
	            }
	            if(!isnext){
	                alert("不接受此文件类型！");
	                event.value ="";
	                return false;
	            }else{
	    		    $('#file_type').text("文件类型：" + otype);
	    		    $('#file_size').text("文件大小:" + osize.toFixed(2) + "MB");
	    		    $('.send_btn').show();
	            }
	        }
		    console.log("文件类型：" + otype); //文件类型
		    console.log("文件大小：" + osize); //文件大小
			if (isIE && !event.files) {    //获取当前文件大小
				var filePath = event.value; 
				var fileSystem = new ActiveXObject("Scripting.FileSystemObject"); 
				if(!fileSystem.FileExists(filePath)){ 
					alert("附件不存在，请重新输入！"); 
					return false; 
				} 
				var file = fileSystem.GetFile (filePath); 
				fileSize = file.Size; 
			} else { 
				fileSize = ofile.size; 
			} 
			var size = fileSize / 1024; 
			if(size>filemaxsize){ 
				document.getElementById("uploadSpan").innerHTML = "文件大小不能大于"+filemaxsize/1024+"M"; 
				event.value =""; 
				return false; 
			} else{
				document.getElementById("uploadSpan").innerHTML = "";
			    $('#file_box').html(dom);
				return true;
			}



		};
		
		//侦查附件上传情况 ,这个方法大概0.05-0.1秒执行一次
		function OnProgRess(event) {
		    var event = event || window.event;
		    //console.log(event);  //事件对象
		    console.log("已经上传：" + event.loaded); //已经上传大小情况(已上传大小，上传完毕后就 等于 附件总大小)
		    //console.log(event.total);  //附件总大小(固定不变)
		    var loaded = Math.floor(100 * (event.loaded / event.total)); //已经上传的百分比  
		    $("#speed").html(loaded + "%").css("width", loaded + "%");
		    
		    var time = document.getElementById("file_time");
		    var nt = new Date().getTime(); //获取当前时间
		    var pertime = (nt - ot) / 1000; //计算出上次调用该方法时到现在的时间差，单位为s
		    ot = new Date().getTime(); //重新赋值时间，用于下次计算
		
		    var perload = event.loaded - oloaded; //计算该分段上传的文件大小，单位b 
		    oloaded = event.loaded; //重新赋值已上传文件大小，用以下次计算
		
		    //上传速度计算
		    var speed = perload / pertime; //单位b/s
		    var bspeed = speed;
		    var units = 'b/s'; //单位名称
		    if(speed / 1024 > 1) {
		        speed = speed / 1024;
		        units = 'k/s';
		    }
		    if(speed / 1024 > 1) {
		        speed = speed / 1024;
		        units = 'M/s';
		    }
		    speed = speed.toFixed(1);
		    //剩余时间
		    var resttime = ((event.total - event.loaded) / bspeed).toFixed(1);
		    time.innerHTML = '上传速度：' + speed + units + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;剩余时间：' + resttime + 's';
		    if(bspeed == 0)
		        time.innerHTML = '上传已取消';
		};
		
		//开始上传文件
		function UploadFileFn(courseId) {
		
		    $('.speed_box').show();
		    var oFile = $("#oFile").get(0).files[0]; //input file标签
		    var catalog=$("#catalog").val();
		    if(catalog == null || catalog == "" || catalog == undefined){
		    	alert("目录名不能为空!");
		    }else {
			    formData = new FormData(); //创建FormData对象
			    xhr = $.ajaxSettings.xhr(); //创建并返回XMLHttpRequest对象的回调函数(jQuery中$.ajax中的方法)
			    formData.append("file", oFile); //将上传name属性名(注意：一定要和 file元素中的name名相同)，和file元素追加到FormData对象中去
			    formData.append("catalog", catalog);
			    formData.append("courseId", courseId);
			    $.ajax({
			        type: "POST",
			        url: "${ctx }/upload1/upload1", // 后端服务器上传地址
			        data: formData, // formData数据
			        cache: false, // 是否缓存
			        async: true, // 是否异步执行
			        processData: false, // 是否处理发送的数据  (必须false才会避开jQuery对 formdata 的默认处理)
			        contentType: false, // 是否设置Content-Type请求头
			        xhr: function() {
			            if (OnProgRess && xhr.upload) {
			            	ot = new Date().getTime();
			            	oloaded=0;
			                xhr.upload.addEventListener("progress", OnProgRess, false);
			                return xhr;
			            }
			        },
			        success: function(returndata) {
			            $("#speed").html("上传成功");
			            window.location.href ="${ctx}/upload3.jsp";
			            //alert(returndata);  
			        },
			        error: function(returndata) {
			            $("#speed").html("上传失败");
			            console.log(returndata)
			            alert('请正确配置后台服务！');
			        }
			    });
		    }
		};
    </script>
<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js"></script>


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
						<a href="application.html" class="on">上传课程</a>
					</h1>
				</div>

				<div class="display" id="courseId" value="${param.courseId }">
					<div class="title12">
						<img src="${ctx}/img/scimg2.jpg" />
					</div>
					<form action="" method="post" enctype="multipart/form-data">
					    <a class="opts_btn" href="JavaScript:void(0)">
					        <label id="opst_txt">选择上传文件</label><input type="file" id="oFile" class="oFile"  name="file" onchange="FileChangeFn(event)" accept="video/mp4,video/flv">
					        
					    </a>
					    <span id="uploadSpan" style="font-size:12px;color:red"></span>
					     <!--上传速度显示-->
						<br>
					    <label id="file_size"></label>&nbsp;&nbsp;&nbsp;&nbsp;
					    <label id="file_type"></label>
					    <br>
					    <label id="file_time"></label>
					    <div id="file_box"></div>
					    <div class="speed_box" style="width: 500px;margin-top: 20px;">
					        <div id="speed">0%</div>
					    </div>
					 	<div class="videoinfo" style="font-size: 15px; height: 210px; margin-bottom: 0;width: 510px;">
							<div >
								<font>*</font>&nbsp;&nbsp;&nbsp;<b>文件目录:</b>
								<input type="text" name="catalog" id="catalog" style="width: 400px; height: 50px; " />
								
								<br>
								
							</div>
							<button type="button" class="send_btn" onclick="UploadFileFn(${courseId})" style="margin-right: 10px;">开始上传文件</button>
						</div>
					    <div class="clear"></div>
					</form>					
				</div>
			</div>	
	</div>
	<div class="clear" style="height: 30px;"></div>
	</div>
	<%@include file="footer.jsp"%>

</body>

</html>