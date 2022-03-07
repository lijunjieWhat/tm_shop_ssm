<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<div class="navitagorDiv">
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<img style="margin-left: 10px; margin-right: 0px" class="pull-left"
			src="/img/site/tmallbuy.png" height="45px"> <a
			class="navbar-brand" href="#nowhere">天猫后台</a>
		<c:if test="${!empty admin}">
			<a class="navbar-brand" href="admin_category_list.action">分类管理</a>
			<a class="navbar-brand" href="admin_user_list.action">用户管理</a>
			<a class="navbar-brand" href="admin_order_list.action">订单管理</a>
		</c:if>
		<c:if test="${empty admin}">
	请登录
		</c:if>
	</nav>
</div>