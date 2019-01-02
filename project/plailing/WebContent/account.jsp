<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>account</title>
<link href="${ctx}/css/whir_common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/whir_grzx.css" rel="stylesheet" type="text/css" />

<link rel="shortcut icon" href="favicon.ico">
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <title>打赏</title>
    <style type="text/css">
        .content{width:80%;margin:200px auto;}
                .hide_box{z-index:999;filter:alpha(opacity=50);background:#666;opacity: 0.5;-moz-opacity: 0.5;left:0;top:0;height:99%;width:100%;position:fixed;display:none;}
        .shang_box{width:540px;height:540px;padding:10px;background-color:#fff;border-radius:10px;position:fixed;z-index:1000;left:50%;top:50%;margin-left:-280px;margin-top:-280px;border:1px dotted #dedede;display:none;}
        .shang_box img{border:none;border-width:0;}
        .dashang{display:block;width:100px;margin:5px auto;height:25px;line-height:25px;padding:10px;background-color:#E74851;color:#fff;text-align:center;text-decoration:none;border-radius:10px;font-weight:bold;font-size:16px;transition: all 0.3s;}
        .dashang:hover{opacity:0.8;padding:15px;font-size:18px;}
        .shang_close{float:right;display:inline-block;}
                .shang_logo{display:block;text-align:center;margin:20px auto;}
        .shang_tit{width: 100%;height: 75px;text-align: center;line-height: 66px;color: #a3a3a3;font-size: 16px;background: url('img/cy-reward-title-bg.jpg');font-family: 'Microsoft YaHei';margin-top: 7px;margin-right:2px;}
        .shang_tit p{color:#a3a3a3;text-align:center;font-size:16px;}
        .shang_payimg{width:140px;padding:0px;border:6px solid #11aa8cb5;margin:0 auto;border-radius:3px;height:140px;}
        .shang_payimg img{display:block;text-align:center;width:129px;height:130px; }
        .pay_explain{text-align:center;margin:10px auto;font-size:12px;color:#545454;}
        .radiobox{width: 16px;height: 16px;background: url('img/radio2.jpg');display: block;float: left;margin-top: 5px;margin-right: 14px;}
        .checked .radiobox{background:url('img/radio1.jpg');}
        .shang_payselect{text-align:center;margin:0 auto;margin-top:40px;cursor:pointer;height:60px;width:280px;}
        .shang_payselect .pay_item{display:inline-block;margin-right:10px;float:left;}
        .shang_info{clear:both;}
		.shang_info p,.shang_info a{color:#C3C3C3;text-align:center;font-size:12px;text-decoration:none;line-height:2em;}
		span{width:130px;height:40px}
    </style>
</style>
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
					<a href="${ctx }/user/finance" class="on" id="showBalance">交易记录</a>
				</h1>
				<h1>
					<a href="${ctx }/user/money" class="" id="showMoney">我的收益</a>
				</h1>
			</div>

			<div class="display" id="balanceDiv">
				<div class="dqjf">
					当前余额：<font class="f_orange">${nowTotleBalance}</font> 元
				</div>
				<div class="jflist">
					<div class="titlei">
						<div class="jfjl">
							充值消费
						</div>
					</div>
					<ul class="jfinfo">
						<c:forEach items="${userBalanceListPage.getList() }" var="bl">
						<li>
							<span class="jfdate" style="width:200px">${bl.balanceTime}</span> 
							<c:if test="${bl.balanceState==0 }">
							<span class="jfyt" style="width:130px">+充值</span>
							<span class="jfnum" style="width:130px"><font class="f_green">+${bl.money }</font></span>
							</c:if>
							<c:if test="${bl.balanceState==1 }">
							<span class="jfyt" style="width:130px">-消费</span>
							<span class="jfnum" style="width:130px"><font class="f_green">-${bl.money }</font></span>
							</c:if>
							<span class="jfjg" style="width:130px">交易成功</span> 
							<span class="jfxx" style="width:130px"><a href="#" title="交易对应课程">${bl.course.name }</a></span>
						</li>
						</c:forEach>
					</ul>
					
					<div class="pagination-container pagemiddle">
						<span>
							共${userBalanceListPage.totalPageNum}页
						</span>
						<a class="wordstyle" href="${ctx }/user/finance?balancePageNum=1"><font size="2px"> 首页 </font></a>&nbsp;&nbsp;&nbsp; 
						<a class="wordstyle" href="${ctx }/user/finance?balancePageNum=${userBalanceListPage.prePageNum }"><font size="2px"> 上一页 </font></a>&nbsp;&nbsp;&nbsp; 
						<a class="wordstyle" href="${ctx }/user/finance?balancePageNum=${userBalanceListPage.nextPageNum }"><font size="2px"> 下一页 </font></a>&nbsp;&nbsp;&nbsp; 
						<a class="wordstyle" href="${ctx }/user/finance?balancePageNum=${userBalanceListPage.totalPageNum }"><font size="2px"> 末页 </font></a>&nbsp;&nbsp;&nbsp;
					</div>
					
					<a href="javascript:void(0)" onClick="dashangToggle()"  title="为您的账号充值"><input type="submit" value="充值" class="input8"/></a>
					<a href="" onClick=""  title="如见到理想课程需要再次充值哦"><input type="submit" value="退款" class="input8"/></a>
					<br><br>
				</div>
			</div>
		
		</div>


	</div>
	<div class="clear" style="height: 53px;"></div>

	</div>
		<div class="hide_box"></div>
		<div class="shang_box">
			<a class="shang_close" href="javascript:void(0)" onClick="dashangToggle()" title="关闭">
				<img src="${ctx}/img/close.jpg" alt="取消" /></a>
			<div class="shang_tit">
				<p>开启e享课堂旅程吧</p>
			</div>
			<div class="shang_payimg">
				<img src="${ctx}/img/alipayimg.jpg" alt="扫码支持" title="扫一扫" />
			</div>
			<div class="shang_payselect">
				<div class="pay_item checked" data-id="alipay">
					<span class="radiobox"></span> <span class="pay_logo"><img
						src="${ctx}/img/alipay.jpg" alt="支付宝" /></span>
				</div>
				<div class="pay_item" data-id="weipay">
					<span class="radiobox"></span> <span class="pay_logo"><img
						src="${ctx}/img/wechat.jpg" alt="微信" /></span>
				</div>
			</div>
			<div class="shang_info">
				<p>
					打开<span id="shang_pay_txt">支付宝</span>扫一扫，进行支付
				</p>
				<p>欢迎使用e享课堂</p>
			</div>
		</div>
	<script type="text/javascript">
		$(function() {
			$(".pay_item").click(
					function() {
						$(this).addClass('checked').siblings('.pay_item')
								.removeClass('checked');
						var dataid = $(this).attr('data-id');
						$(".shang_payimg img").attr("src",
								"img/" + dataid + "img.jpg");
						$("#shang_pay_txt").text(
								dataid == "alipay" ? "支付宝" : "微信");
					});
		});
		function dashangToggle() {
			$(".hide_box").fadeToggle();
			$(".shang_box").fadeToggle();
		}
	</script>

	<%@include file="footer.jsp"%>


</body>
</html>