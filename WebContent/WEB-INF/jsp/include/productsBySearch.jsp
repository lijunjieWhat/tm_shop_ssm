<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!--标签标签库  -->  
<!--函数标签  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="searchProducts">

    <c:forEach items="${ps}" var="p">
    <div class="productUnit" price="${p.promotePrice}">
        <a href="foreproduct?pid=${p.id}">
            <img class="productImage" src="/img/productSingle_middle/${p.firstProductImage.id}.jpg">
        </a>
        <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}"
                                                      minFractionDigits="2"/></span>
        <a class="productLink" href="/fore/product.action?pid=${p.id}">
                ${fn:substring(p.name, 0, 50)}
        </a>

        <a class="tmallLink" href="/fore/product.action?pid=${p.id}">天猫专卖</a>

        <div class="productInfo">
            <span class="monthDeal ">月成交 <span class="productDealNumber">5000笔</span></span>
            <span class="productReview">评价<span class="productReviewNumber">${fn:length(p.reviews)}</span></span>
            <span class="wangwang"><img src="/img/site/wangwang.png"></span>
        </div>

    </div>
    </c:forEach>
    <c:if test="${empty ps}">
    <div class="noMatch">没有满足条件的产品
        <div>
            </c:if>

            <div style="clear:both"></div>
        </div>