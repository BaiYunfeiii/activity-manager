<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>活动 - 首页</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>

</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center uk-grid uk-grid-margin">
    <div class="uk-width-3-4">
        <div>
            <h1>${ empty category ? '最新活动' : category.name}</h1>
            <c:import url="/template/activityList">
                <c:param name="categoryId" value="${categoryId}"></c:param>
            </c:import>
        </div>
    </div>
    <c:import url="/template/sideBar"></c:import>
</div>
</body>
</html>