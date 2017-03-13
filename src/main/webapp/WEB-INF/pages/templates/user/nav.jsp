<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/3
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="uk-navbar">
    <div class="uk-container uk-container-center">
        <a class="uk-navbar-brand" href="<%=request.getContextPath()%>/index">Activity</a>
        <ul class="uk-navbar-nav">
            <li><a href="<%=request.getContextPath()%>/index">最新活动</a></li>
            <li class="uk-parent" data-uk-dropdown>
                <a href="<%=request.getContextPath()%>/index">活动列表<i class="uk-icon-caret-down"></i> </a>
                <div class="uk-dropdown uk-dropdown-navbar uk-dropdown-bottom">
                    <ul class="uk-nav uk-nav-navbar">
                        <c:forEach items="${categoryList}" var="category">
                            <li><a href="<%=request.getContextPath()%>/activity/category/${category.id}">${category.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </li>
            <li class="uk-parent" data-uk-dropdown>
                <a href="<%=request.getContextPath()%>/user/myActivity">我的活动<i class="uk-icon-caret-down"></i> </a>
                <div class="uk-dropdown uk-dropdown-navbar uk-dropdown-bottom">
                    <ul class="uk-nav uk-nav-navbar">
                        <li>
                            <a href="#">我参加的</a>
                            <hr>
                        </li>
                        <li><a href="#">我发起的</a></li>
                        <li><a href="#">我的团队</a></li>
                    </ul>
                </div>
            </li>
            <li><a href="<%=request.getContextPath()%>/user/publishPage">发起活动</a></li>
        </ul>
        <div class="uk-navbar-flip">
            <ul class="uk-navbar-nav">
                <c:if test="${ not empty user}">
                    <li><a href="/user/info">${user.name}</a></li>
                    <li><a href="/logout">退出</a></li>
                </c:if>
                <c:if test="${empty user}">
                    <li><a href="/login">登录</a></li>
                    <li><a href="/registerPage">注册</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>