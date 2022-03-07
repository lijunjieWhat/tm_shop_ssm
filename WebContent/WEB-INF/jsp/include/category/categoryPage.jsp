<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--标签标签库  -->
<!--函数标签  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>模仿天猫官网-${category.name}</title>
<div id="category">
	<div class="categoryPageDiv">
		<img src="/img/category/${category.id}.jpg">
		<script>
    $(function () {
        $("input.sortBarPrice").keyup(function () {
            var num = $(this).val();
            if (num.length == 0) {
                $("div.productUnit").show();
                return;
            }

            num = parseInt(num);
            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            $(this).val(num);

            var begin = $("input.beginPrice").val();
            var end = $("input.endPrice").val();
            if (!isNaN(begin) && !isNaN(end)) {
                console.log(begin);
                console.log(end);
                $("div.productUnit").hide();
                $("div.productUnit").each(function () {
                    var price = $(this).attr("price");
                    price = Number(price);

                    if (price <= end && price >= begin)
                        $(this).show();
                });
            }

        });
    });
</script>

	<div style="width: 100%;height: 100%" >
	<c:if test="${empty param.categorycount}">
		<c:set var="categorycount" scope="page" value="100" />
	</c:if>

	<c:if test="${!empty param.categorycount}">
		<c:set var="categorycount" scope="page" value="${param.categorycount}" />
	</c:if>

	<div style="margin:0 auto;" class="categoryProducts">
		<c:forEach items="${category.products}" var="p" varStatus="stc">
			<c:if test="${stc.count<=categorycount}">
				<div class="productUnit" price="${p.promotePrice}">
					<div class="productUnitFrame">
						<a href="foreproduct?pid=${p.id}"> <img class="productImage"
							src="/img/productSingle_middle/${p.firstProductImage.id}.jpg">
						</a> <span class="productPrice">¥<fmt:formatNumber
								type="number" value="${p.promotePrice}" minFractionDigits="2" /></span>
						<a class="productLink" href="/fore/product.action?pid=${p.id}">
							${fn:substring(p.name, 0, 50)} </a> <a class="tmallLink"
							href="foreproduct?pid=${p.id}">天猫专卖</a>

						<div class="show1 productInfo">
							<span class="monthDeal ">月成交 <span
								class="productDealNumber">10万+</span></span> <span
								class="productReview">评价<span class="productReviewNumber">${fn:length(p.reviews)}</span></span>
							<span class="wangwang"> <a class="wangwanglink"
								href="#nowhere"> <img src="/img/site/wangwang.png">
							</a>

							</span>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
		<div style="clear: both"></div>
	</div>
</div>

</div>