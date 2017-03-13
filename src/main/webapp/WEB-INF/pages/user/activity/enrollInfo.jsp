<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/5
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报名情况</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>
</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center">
    <div class=" uk-grid" style="margin-top: 30px">
        <div class="uk-width-3-4">
            <h1>${activity.name}</h1>
            <hr>
            <p><strong>时间：</strong>${activity.startTime}</p>
            <p><strong>地点：</strong>${activity.location}</p>
            <p><strong>主办方：</strong>${activity.organizer}</p>
            <hr>
            <div>
                <h4><strong>报名情况</strong></h4>
                <table class="uk-table uk-table-hover uk-table-striped">
                    <thead>
                    <tr>
                        <td>姓名</td>
                        <td>性别</td>
                        <td>联系电话</td>
                        <td>电子邮件</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${enrollPager.recordList}" var="enroll">
                        <tr>
                            <td>${enroll.user.name}</td>
                            <td>${enroll.user.sex==1?'男':'女'}</td>
                            <td>${enroll.user.phone}</td>
                            <td>${enroll.user.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>
<script>
</script>
</body>
</html>
