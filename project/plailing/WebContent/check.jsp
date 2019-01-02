<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>


<title>check</title>
<link href="${ctx }/css/whir_common.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx }/css/whir_grzx.css" rel="stylesheet" type="text/css" />


<link rel="stylesheet"
	href="${ctx }/static/font-awesome//4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="${ctx }/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">


<link rel="stylesheet"
	href="${ctx }/app/css/dest/styles.css?=2016121272249">
<script type="text/javascript" src="${ctx}/static/jquery/2.2.4/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function isJoin() {
		console.log("1")
		var file1 = $('#file1').get(0).files[0];	
		var file2 = $('#file2').get(0).files[0];		
		var textarea1 = $('#textarea1').val();		
		var name = $('#name').val();	
		var textarea = $('#textarea').val();		
		var secondType = $('#second').val();	
		var price = $('#price').val();		
		var image = $('#image').get(0).files[0];		
		
		if(file1 == null || file1 == "" || file1 == undefined){
	    	alert("实名制不可为空！");
	    }else if(file2 == null || file2 == "" || file2 == undefined){
	    	alert("有效证书和视频至少上传一个！");
	    }else if(textarea1== null || textarea1 == "" || textarea1 == undefined){
	    	alert("相关经历介绍不可为空！");
	    }else if(name == null || name == "" || name == undefined){
	    	alert("课程名称不可为空！");
	    }else if(textarea == null || textarea == "" || textarea == undefined){
	    	alert("课程简介不可为空！");
	    }else if(secondType == null || secondType == "" || secondType == undefined){
	    	alert("请完整选择课程分类！");
	    }else if(price == null || price == "" || price == undefined || price<0){
	    	alert("课程价格需为大于等于0的数!");
	    }else if(image == null || image == "" || image == undefined){
	    	alert("课程封面不可为空");
	    }else{
	    	formData = new FormData();
			formData.append("file1", file1);
			formData.append("file2", file2);
			formData.append("textarea1", textarea1);
			formData.append("name", name);
			formData.append("textarea", textarea);
			formData.append("secondType", secondType);
			formData.append("price", price);
			formData.append("image", image);
			$.ajax({
				url:'${ctx}/userSubmit',
				data:formData,
				type:'POST',
				cache: false, // 是否缓存
		        async: true, // 是否异步执行
		        processData: false, // 是否处理发送的数据  (必须false才会避开jQuery对 formdata 的默认处理)
		        contentType: false, 
				success:function(result){
					if(result=="ok"){
						alert("提交成功，请耐心等待管理员的审核！");
						window.location.href='${ctx}/findFirstType';
					}else if(result=="pricefail"){
						alert("课程价格需为大于等于0的数字");
					}
				}
			})		
	    }
	}
</script>

	<script type="text/javascript">
		function firstSel() {//如果第一个下拉列表的值改变则调用此方法
			var TypeId = $("#first option:selected").val();//得到第一个下拉列表的值
			if (TypeId != null && "" != TypeId && -1 != TypeId) {
				//通过ajax传入后台，把orderTypeName数据传到后端
				$.post("${ctx}/upload1/findSecondType", {
					TypeId : TypeId
				}, function(data) {
					var res = $.parseJSON(data);//把后台传回的json数据解析
					var option;
					console.log(res);
					$.each(res, function(i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
						option += "<option value='"+n[0]+"'>" + n[1]
								+ "</option>"
					});
					$("#second").html(option);//将循环拼接的字符串插入第二个下拉列表
					$("#second").show();//把第二个下拉列表展示
				});

			} else {
				$("#second").hide();
			}
		};
		window.onload = function() {

			$('#textarea').keyup(function() {
				//    var val=$('#note2').val();
				//    var len=val.length;
				var len = this.value.length
				$('#text-count2').text(len);

			})
		}
	</script>
	<script type="text/javascript">
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    function imgChange(target,id) {
        var fileSize = 0;
        var filetypes =[".jpg",".png"];
        var filepath = target.value;
        var filemaxsize = 1024*5;//5M
        if(filepath){
            var isnext = false;
            var fileend = filepath.substring(filepath.lastIndexOf("."));
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
                target.value ="";
                return false;
            }
        }else{
            return false;
        }
        if (isIE && !target.files) {
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
            alert("附件大小不能大于"+filemaxsize/1024+"M！");
            target.value ="";
            return false;
        }
        if(size<=0){
            alert("附件大小不能为0M！");
            target.value ="";
            return false;
        }
    }
</script>
	<script type="text/javascript">
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    function fileChange(target,id) {
        var fileSize = 0;
        var filetypes =[".jpg",".png",".mp4",".flv"];
        var filepath = target.value;
        var filemaxsize = 1024*5;//5M
        var fileend = filepath.substring(filepath.lastIndexOf("."));
        if(filepath){
            var isnext = false;
            
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
                target.value ="";
                return false;
            }
        }else{
            return false;
        }
        if (isIE && !target.files) {
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
        if(size>filemaxsize&&(filetypes[0]==fileend||filetypes[1]==fileend)){
            alert("附件大小不能大于"+filemaxsize/1024+"M！");
            target.value ="";
            return false;
        }
        if(size>(filemaxsize*100)&&(filetypes[2]==fileend||filetypes[3]==fileend)){
            alert("附件大小不能大于"+filemaxsize*100/1024+"M！");
            target.value ="";
            return false;
        }
        if(size<=0){
            alert("附件大小不能为0M！");
            target.value ="";
            return false;
        }
    }
</script>
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
					<a href="#" class="on">审核信息</a>
				</h1>
			</div>
			<div>
				<div class="videoinfo2">
					<form class="wordstyle" enctype="multipart/form-data">
						<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>实名制:</b><br>
						<input type="file" name="file1" id="file1" onchange="imgChange(this);" accept="image/jpeg ,image/png"/><span style="font-size:16px;color:red;">${file1Fail }</span> <br>
						<span style="font-size: 5px;">点击此上传身份证照和正面照</span></br> </br> 
						<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>有效证书或视频:</b><br>
						<input type="file" name="file2" id="file2" onchange="fileChange(this);"><br>
						<span style="font-size: 5px;">上传能够证明自己相关技能的证书或相关视频</span></br> </br> 
						<%-- <font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>视频:</b> <br>
						<input type="file" name="file3" id="file3"><span style="font-size:16px;color:red;">${file23Fail }</span> <br>
						<span style="font-size: 5px;">上传露正脸的视频（与有效证书，可选其一）</span></br> </br>  --%>
						<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>相关经历介绍:</b><br>
						<textarea name="textarea1" id="textarea1"
									style="width: 425px; height: 119px;" placeholder="请输入150字以内"
									maxlength="150"
									onkeyup="this.value=this.value.substring(0, 150)"></textarea><br>
								<span id="text-count3" value="">0</span>/150字 <br><br>
								<span style="font-size:16px;color:red;">${textarea1Fail }</span>
						<div class="title6">
							<h1>
								<a href="#" class="on">课程信息</a>
							</h1>
						</div>
						<div>					
							<div>
								<br><br>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>课程名称:</b> <input
									type="text" class="input4" name="name" id="name"
									style="width: 425px; height: 25px;" /><span style="font-size:16px;color:red;">${nameFail }</span> <br><br>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>课程简介:</b><br><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<textarea name="textarea" id="textarea"
									style="width: 425px; height: 119px;" placeholder="请输入100字以内"
									maxlength="100"
									onkeyup="this.value=this.value.substring(0, 100)"></textarea><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
								<span id="text-count2" value="">0</span>/100字 <br><br>
								<span style="font-size:16px;color:red;">${textareaFail }</span>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>课程分类:</b>
								<select class="input7" style="color: #686868;width: 125px; height: 25px;" id="first" onchange="firstSel()" name="first">
									<option value="">请选择父类型</option>
									<c:forEach items="${courseType }" var="a">
										<c:if test="${a.getCourseType()==null }">
											<option value="${a.getTypeId() }">${a.getTypeName() }</option>
										</c:if>
									</c:forEach>
								</select> 
								<select class="input7" style="color: #686868;width: 125px; height: 25px;" id="second" name="second">
									<option value="" name="secondType" id="secondType">请选择子类型</option>
								</select> 
								<span style="font-size:16px;color:red;">${secondTypeFail }</span>
								<br><br>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>课程价格:</b>
								<input type="text" class="input4" name="price" id="price" style="width: 125px; height: 25px;"/>
								<span style="font-size:16px;color:red;">${priceFail }</span>
								<br><br>
								<font class="f_red">*</font>&nbsp;&nbsp;&nbsp;<b>课程封面:</b>
								<input type="file" value="上传" name="image" id="image"  onchange="imgChange(this);" accept="image/jpeg,image/png"/> <span style="font-size:16px;color:red;">${file23Fail }</span>
								<br>&nbsp;&nbsp;&nbsp;&nbsp;
								<span style="font-size: 5px;">请上传格式为.jpg .png 小于5M的图片</span>
								<span style="font-size:16px;color:red;">${priceFail }</span><br><br><br>
								<input type="button" class="input8" value="提交" onclick="isJoin()"/>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<%@include file="footer.jsp"%>
	<script type="text/javascript">
		function firstSel() {//如果第一个下拉列表的值改变则调用此方法
			console.log($("#first option:selected").val());
			var TypeId = $("#first option:selected").val();//得到第一个下拉列表的值
			if (TypeId != null && "" != TypeId && -1 != TypeId) {
				//通过ajax传入后台，把orderTypeName数据传到后端
				$.post("${ctx}/findSecondType", {
					TypeId : TypeId
				}, function(data) {
					var res = $.parseJSON(data);//把后台传回的json数据解析
					var option;
					console.log(res);
					$.each(res, function(i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
						option += "<option value='"+n[0]+"'>" + n[1]
								+ "</option>"
					});
					$("#second").html(option);//将循环拼接的字符串插入第二个下拉列表
					$("#second").show();//把第二个下拉列表展示
				});

			} else {
				$("#second").hide();
			}
		};
		window.onload = function() {

			$('#textarea').keyup(function() {
				//    var val=$('#note2').val();
				//    var len=val.length;
				var len = this.value.length
				$('#text-count2').text(len);
			})
			
			$('#textarea1').keyup(function() {
				var len = this.value.length
				$('#text-count3').text(len);
			})
		}
	</script>
</body>
</html>