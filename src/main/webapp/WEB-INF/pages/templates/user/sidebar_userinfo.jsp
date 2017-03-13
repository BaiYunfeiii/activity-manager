<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/3
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="uk-width-1-4">
    <div class="uk-panel uk-panel-box uk-panel-box-secondary info-panel">
        <c:if test="${ not empty user }">
            <h3><strong>${user.name}</strong></h3>
            <hr>
            <ul class="uk-nav uk-nav-side">
                <li><a href="<%=request.getContextPath()%>/user/myActivity?type=1">我参加的</a></li>
                <li class="uk-nav-divider"></li>
                <li><a href="<%=request.getContextPath()%>/user/myActivity?type=2">我发起的</a></li>
                <li class="uk-nav-divider"></li>
                <li><a href="<%=request.getContextPath()%>/user/info">我的资料</a></li>
            </ul>
        </c:if>
        <c:if test="${ empty user }">
            <div style="text-align: center">
                <a href="/login" class="uk-button uk-button-primary">立即登录</a>
            </div>
        </c:if>
    </div>
</div>
