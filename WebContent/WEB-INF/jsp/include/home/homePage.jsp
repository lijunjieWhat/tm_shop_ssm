<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--标签标签库  -->
<!--函数标签  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>模仿天猫官网</title>

<div class="homepageDiv">
	<script>
		function showProductsAsideCategorys(cid) {
			$("div.eachCategory[cid=" + cid + "]").css("background-color",
					"white");
			$("div.eachCategory[cid=" + cid + "] a").css("color", "#87CEFA");
			$("div.productsAsideCategorys[cid=" + cid + "]").show();
		}

		function hideProductsAsideCategorys(cid) {
			$("div.eachCategory[cid=" + cid + "]").css("background-color",
					"#e2e2e3");
			$("div.eachCategory[cid=" + cid + "] a").css("color", "#000");
			$("div.productsAsideCategorys[cid=" + cid + "]").hide();
		}

		$(function() {
			$("div.eachCategory").mouseenter(function() {
				var cid = $(this).attr("cid");
				showProductsAsideCategorys(cid);
			});
			$("div.eachCategory").mouseleave(function() {
				var cid = $(this).attr("cid");
				hideProductsAsideCategorys(cid);
			});
			$("div.productsAsideCategorys").mouseenter(function() {
				var cid = $(this).attr("cid");
				showProductsAsideCategorys(cid);
			});
			$("div.productsAsideCategorys").mouseleave(function() {
				var cid = $(this).attr("cid");
				hideProductsAsideCategorys(cid);
			});

			$("div.rightMenu span").mouseenter(function() {
				var left = $(this).position().left;
				var top = $(this).position().top;
				var width = $(this).css("width");
				var destLeft = parseInt(left) + parseInt(width) / 2;
				$("img#catear").css("left", destLeft);
				$("img#catear").css("top", top - 20);
				$("img#catear").fadeIn(500);

			});
			$("div.rightMenu span").mouseleave(function() {
				$("img#catear").hide();
			});

			var left = $("div#carousel-of-product").offset().left;
			$("div.categoryMenu").css("left", left - 20);
			$("div.categoryWithCarousel div.head").css("margin-left", left);
			$("div.productsAsideCategorys").css("left", left - 20);

		});
	</script>

	<img src="/img/site/catear.png" id="catear" class="catear" />

	<div class="categoryWithCarousel">

		<div class="headbar show1">
			<div class="head ">

				<span style="margin-left: 10px" class="glyphicon glyphicon-th-list"></span>
				<span style="margin-left: 10px">商品分类</span>

			</div>

			<div class="rightMenu">
				<span><a href=""><img src="/img/site/chaoshi.png" /></a></span> <span><a
					href=""><img src="/img/site/guoji1.png" /></a></span>

				<c:forEach items="${categories}" var="category" varStatus="st">
					<c:if test="${st.count<=4}">
						<span> <a href="/fore/category.action?cid=${category.id}">
								${category.name} </a></span>
					</c:if>
				</c:forEach>
			</div>

		</div>

		<div style="position: relative">
			<div class="categoryMenu">
				<c:forEach items="${categories}" var="category">
					<div cid="${category.id}" class="eachCategory">
						<span class="glyphicon glyphicon-link"></span> <a
							href="/fore/category.action?cid=${category.id}"> ${category.name} </a>
					</div>
				</c:forEach>
			</div>
		</div>

		<div style="position: relative; left: 0; top: 0;">
			<script>
				$(function() {
					$("div.productsAsideCategorys div img").each(function() {
						var v = Math.round(Math.random() * 6);
						if (v == 1)
							$(this).css("display", "");
					});
				});
			</script>

			<c:forEach items="${categories}" var="category">
				<div cid="${category.id}" class="productsAsideCategorys">

					<c:forEach items="${category.products}" var="p">
						<div class="row show1">
							<c:if test="${!empty p.subTitle}">
								<a href="/fore/product.action?pid=${p.id}"> <c:forEach
										items="${fn:split(p.subTitle, ' ')}" var="title"
										varStatus="st">
										<c:if test="${st.index==0}">
                                    ${title}<img style="display: none;"
												alt="" src="/img/lunbo/huo.jpg">
										</c:if>
									</c:forEach>
								</a>
							</c:if>
							<div class="seperator"></div>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>

		<div id="carousel-of-product"
			class="carousel-of-product carousel slide1" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-of-product" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-of-product" data-slide-to="1"></li>
				<li data-target="#carousel-of-product" data-slide-to="2"></li>
				<li data-target="#carousel-of-product" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="carousel carouselImage" src="/img/lunbo/1.jpg">
				</div>

				<div class="item">

					<img class="carouselImage" src="/img/lunbo/2.jpg">
				</div>
				<div class="item">
					<img class="carouselImage" src="/img/lunbo/3.jpg">
				</div>

				<div class="item">
					<img class="carouselImage" src="/img/lunbo/4.jpg">
				</div>

			</div>



		</div>

		<div class="carouselBackgroundDiv"></div>

	</div>




	<%-- <c:if test="${empty param.categorycount}">
		<c:set var="categorycount" scope="page" value="100" />
	</c:if>

	<c:if test="${!empty param.categorycount}">
		<c:set var="categorycount" scope="page" value="${param.categorycount}" />
	</c:if> --%>

	<div class="homepageCategoryProducts">
		<c:forEach items="${categories}" var="category" varStatus="stc">

			<div class="eachHomepageCategoryProducts">
				<div class="left-mark"></div>
				<span class="categoryTitle">${category.name}</span> <br>
				<c:forEach items="${category.products}" var="p" varStatus="st">
					<c:if test="${st.count<=5}">
						<div class="productItem">
							<a href="/fore/product.action?pid=${p.id}"><img width="100px"
								src="/img/productSingle_middle/${p.firstProductImage.id}.jpg"></a>
							<a class="productItemDescLink"
								href="/fore/product.action?pid=${p.id}"> <span
								class="productItemDesc">[热销] ${fn:substring(p.name, 0, 20)}
							</span>
							</a> <span class="productPrice"> <fmt:formatNumber
									type="number" value="${p.promotePrice}" minFractionDigits="2" />
							</span>
						</div>
					</c:if>
				</c:forEach>
				<div style="clear: both"></div>
			</div>

		</c:forEach>

		<img id="endpng" class="endpng" src="/img/site/end.png">

	</div>
</div>