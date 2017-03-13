<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${activity.name}|活动详情</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>
</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center ">
    <div class="uk-grid" style="margin-top: 30px">
        <div class="uk-width-3-4">
            <article class="uk-article">
                <h1 class="uk-article-title">${activity.name}</h1>
                <p class="uk-article-meta">时间：<fmt:formatDate value="${activity.startTime}" type="date" dateStyle="full" /></p>
                <p class="uk-article-meta">主办方：${activity.organizer}</p>
                <p class="uk-article-meta">地址：${activity.location}</p>
                <hr class="uk-article-divider">
                <div>
                    ${activity.description}
                </div>
            </article>
        </div>
        <div class="uk-width-1-4">
            <div style="text-align: center">
                <c:choose>
                    <c:when test="${activity.author.id eq sessionScope.userId}">
                        <a href="<%=request.getContextPath()%>/user/activity/${activity.id}/enroll/info" role="button" class="uk-button uk-button-info">查看报名情况</a>
                    </c:when>
                    <c:when test="${hasEnrolled}">
                        <span role="button" class="uk-button uk-button-info uk-disabled">已报名</span>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=request.getContextPath()%>/user/enrollPage/${activity.id}" role="button" class="uk-button uk-button-primary">立即报名</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</body>
</html>