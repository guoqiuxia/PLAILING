<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<!--左侧部分-->
		<div class="left180">
			<div class="grtx">
				<div class="grimg">
					<img src="${ctx }/${leftUser.photo}" style="margin-left:4px;margin-top:5px;"/>
				</div>
				<div class="grname">
					<span style="font-size:14px;color:#03ab81;font-weight:bold;">${leftUser.nickName}</span>
				</div>
			</div>
			<br>
			<ul class="menu1">
				<li><a href="${ctx }/user/findInfo"><em>信息设置</em></a></li>

			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/user/join"><em>学习课程</em></a></li>
			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/upload"><em>上传课程</em></a></li>

			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/relatecomment/find"><em>与我相关</em></a></li>

			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/relate"><em>系统通知</em></a></li>

			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/user/finance"><em>零钱明细</em></a></li>

			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/collection"><em>我的收藏</em></a></li>

			</ul>
			<ul class="menu1">
				<li><a href="${ctx }/follow"><em>关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</em></a></li>

			</ul>
			
		</div>