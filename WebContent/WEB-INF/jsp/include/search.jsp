<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<a href="${contextPath}">
    <img id="logo" style="height: 120px" src="/img/site/logo.png" class="logo">
</a>

<form action="/fore/search.action" method="post">
    <div class="searchDiv">
        <input name="keyword" type="text" placeholder="华为Mate40 ">
        <button type="submit" class="searchButton">搜索</button>
        <!-- 简化项目 -->
       <%--  <div class="searchBelow">
            获取分类集合，取第5到第8一共四个类显示
            <c:forEach items="${categories}" var="category" varStatus="st">
                <c:if test="${st.count>=5 and st.count<=8}">
                        <span>
                            <a href="/fore/category?cid=${category.id}">
                                    ${category.name}
                            </a>
                            <c:if test="${st.count!=8}">
                                <span>|</span>
                            </c:if>
                        </span>
                </c:if>
            </c:forEach>
        </div> --%>
    </div>
</form>