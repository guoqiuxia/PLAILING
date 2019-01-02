<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
}

#container {
	width: 100%;
	height: 100%;
	position: relative;
}
input{
	padding-top:10px;
	padding-bottom:10px;
	padding-left:40px;
	padding-right:40px;
	font-size:20px;
	color:#fff;
	background-color:#11aa8c;
	border-color:#11aa8c;
	border-radius: 10px;
}
</style>
</head>
<body style="background:url(img/500.gif);background-position:center;background-repeat:no-repeat;">

	<div id="container"></div>
	<div style="position:relative;bottom:200px;padding-left:572px;">
		<a href="${ctx}/index">
		<input type="button" value="返回首页" />
		</a>
	</div>
	<script src="js/collision.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
function rand(m,n){return m+parseInt((n-m)*Math.random());}
var says=['怎么回事？','谁撞我','网页找不到！','哎呀！哎呀！','你点返回首页','看到按钮不？','点一下试试','试试就试试','窗前明月光','撞的心发慌','举头天花板','低头一肥皂'];
var saysLength=says.length;
var oC=document.getElementById('container');
var mxwidth=oC.offsetWidth;
var mxheight=oC.offsetHeight;


var oB=new BallBox('container');
oB.ballRun();
for(var i=0;i<15;i++){
	var b=rand(40,60);
	var x=rand(b,mxwidth-b);
	var y=rand(b,mxheight-b);
	var ball=new Ball({
		'b':b,
		'x':x,
		'y':y,
		'sx':rand(1,4),
		'sy':rand(1,4),
		'c':'url(img/paopao'+rand(1,6)+'.png)',
		'opa':rand(60,100)/100,
		'callBack':function(n){
			//this.setB(rand(30,50));
			//this.setM();
			this.setOpa(rand(60,100)/100);
			if(n%3==0){this.setC('url(img/paopao'+rand(1,6)+'.png)')};//撞三次改变下图片
			if(n%50==0){
				this.setB(rand(40+parseInt((n>1000?1000:n)/50),60+parseInt((n>1000?1000:n)/50)));
			}//撞50次改大小
			this.setHTML(says[rand(0,saysLength)]);
		}
	});
	oB.addBall(ball);
}
</script>

</body>
</html>