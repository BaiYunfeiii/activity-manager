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
    <title>注册</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>
</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center">
    <div class=" uk-grid" style="margin-top: 30px">
        <div class="uk-width-3-4">
            <h1>注册</h1>
            <hr>
            <div>
                <form class="uk-form uk-form-horizontal" action="/register" method="post">
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="username-field">用户名</label>
                        <div class="uk-form-controls"><input type="text" class="" id="username-field" name="username" value="" required></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="password-field">密码</label>
                        <div class="uk-form-controls"><input type="password" class="" id="password-field" name="password" value="" required></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="repassword-field">再次输入密码</label>
                        <div class="uk-form-controls"><input type="password" class="" id="repassword-field" name="repassword" value="" required></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="name-field">真实姓名</label>
                        <div class="uk-form-controls"><input type="text" class="" id="name-field" name="name" value="" required></div>
                    </div>
                    <div class="uk-form-row">
                        <span class="uk-form-label">性别</span>
                        <div class="uk-form-controls uk-form-controls-text">
                            <input type="radio" value="1" name="sex" id="sex-field1" checked="checked">
                            <label for="sex-field1">男</label>
                            <input type="radio" value="2" name="sex" id="sex-field2">
                            <label for="sex-field2">女</label>
                        </div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="phone-field">联系电话</label>
                        <div class="uk-form-controls"><input type="text" class="" id="phone-field" name="phone" value="" required></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="email-field">邮箱</label>
                        <div class="uk-form-controls"><input type="email" class="" id="email-field" name="email" value="" required></div>
                    </div>
                    <div class="uk-form-row">
                        <button type="submit" class="uk-button uk-button-primary">注册</button>
                    </div>
                </form>
                <c:if test="${not empty error}">
                    <div class="uk-alert uk-alert-danger" data-uk-alert>
                        <a href="" class="uk-alert-close uk-close"></a>
                        <p>${error}</p>
                    </div>
                </c:if>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>
</body>
</html>
