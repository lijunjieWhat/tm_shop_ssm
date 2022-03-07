<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="top ">
	<a href="/fore/home.action"> <span
		style="color: #C40000; margin: 0px"
		class=" glyphicon glyphicon-home redColor"></span> 天猫首页
	</a> <span>喵，欢迎来天猫</span>

	<c:if test="${!empty user}">
		<a href="#">${user.username}</a>
		<a href="/fore/loginOut.action">退出</a>
	</c:if>

	<c:if test="${empty user}">
		<a href="/fore/loginPage.action">请登录</a>
		<a href="/fore/registerPage.action">免费注册</a>
	</c:if>

	<span class="pull-right"> <a href="/fore/bought.action">我的订单</a>
		<c:if test="${empty user}">
			<a href="/fore/loginPage.action"> <span
				style="color: #C40000; margin: 0px"
				class=" glyphicon glyphicon-shopping-cart redColor"></span> 购物车<strong
				id="cartTotalItemNumber">0</strong>件
			</a>
		</c:if> <c:if test="${!empty user}">
			<a href="/fore/cart.action"> <span
				style="color: #C40000; margin: 0px"
				class=" glyphicon glyphicon-shopping-cart redColor"></span> 购物车<strong
				id="cartTotalItemNumber"> <c:choose>
						<c:when test="${!empty cartTotalItemNumber}">${cartTotalItemNumber}</c:when>
						<c:otherwise>0</c:otherwise>
					</c:choose> 
			</strong>件
			</a>
		</c:if>

	</span>

</nav>