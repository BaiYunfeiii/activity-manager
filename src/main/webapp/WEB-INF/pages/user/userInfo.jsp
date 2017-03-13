<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的活动</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>
</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center">
    <div class=" uk-grid" style="margin-top: 30px">
        <div class="uk-width-3-4">
            <h1>我的资料</h1>
            <hr>
            <div>
                <form class="uk-form uk-form-horizontal">
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="username-field">用户名</label>
                        <div class="uk-form-controls"><input role="text" disabled="disabled" class="uk-form-blank" id="username-field" value="${user.username}"></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="name-field">真实姓名</label>
                        <div class="uk-form-controls"><input role="text" disabled="disabled" class="uk-form-blank" id="name-field" value="${user.name}"></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="phone-field">联系电话</label>
                        <div class="uk-form-controls"><input role="text" disabled="disabled" class="uk-form-blank" id="phone-field" value="${user.phone}"></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="email-field">邮箱</label>
                        <div class="uk-form-controls"><input role="text" disabled="disabled" class="uk-form-blank" id="email-field" value="${user.email}"></div>
                    </div>
                </form>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>
</body>
</html>