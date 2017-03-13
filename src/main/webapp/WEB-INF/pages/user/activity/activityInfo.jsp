<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/5
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>活动详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/WEB-INF/pages/templates/bootstrap.jsp"%>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container" style="margin-top: 51px">
    <div>
        <h1>活动详情</h1>
        <hr>
    </div>
    <div>
        <form class="form-horizontal" role="form">
            <p><strong>主题：</strong>${activity.name}</p>
            <p><strong>时间：</strong>${activity.startTime}</p>
            <p><strong>地点：</strong>${activity.location}</p>
            <p><strong>主办方：</strong>${activity.organizer}</p>
            <hr>
            <div>
                ${activity.description}
            </div>
        </form>
    </div>
</div>
</body>
<script>

</script>
</html>
