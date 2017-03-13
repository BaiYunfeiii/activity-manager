<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/4
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>
</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center">
    <div class=" uk-grid" style="margin-top: 30px">
        <div class="uk-width-3-4">
            <h1>登录</h1>
            <hr>
            <div>
                <form class="uk-form uk-form-horizontal" action="/login" method="post">
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="username-field">用户名</label>
                        <div class="uk-form-controls"><input type="text" class="" id="username-field" name="username" value=""></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="password-field">密码</label>
                        <div class="uk-form-controls"><input type="password" class="" id="password-field" name="password" value=""></div>
                    </div>
                    <div class="uk-form-row">
                        <button type="submit" class="uk-button uk-button-primary">登录</button>
                    </div>
                </form>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>
</body>
</html>
