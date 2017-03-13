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
            <h1>${pageTitle}</h1>
            <hr>
            <div>
                <c:forEach items="${activityPager.recordList}" var="activity">
                    <div class="uk-grid uk-grid-medium">
                        <div class="uk-width-1-1">
                            <c:choose>
                                <c:when test="${pageTitle eq '我发起的'}">
                                    <h3><a href="<%=request.getContextPath()%>/user/activity/${activity.id}/info" >${activity.name}<span class="uk-badge">${!activity.activityCheck.processed?'待审核':!activity.activityCheck.pass?'未通过':'已通过'}</span></a></h3>
                                </c:when>
                                <c:otherwise>
                                    <h3><a href="<%=request.getContextPath()%>/activity/${activity.id}" >${activity.name}</a></h3>
                                </c:otherwise>
                            </c:choose>
                            <p>${activity.startTime}</p>
                            <p>主办方：${activity.organizer}</p>
                            <p>地点：${activity.location}</p>
                        </div>
                    </div>
                    <hr>
                </c:forEach>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>

</body>
</html>