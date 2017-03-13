<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/8
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${activity.name} | 报名详情</title>
    <%@include file="/WEB-INF/pages/templates/bootstrap.jsp"%>
</head>
<jsp:include page="nav.jsp"/>
<div class="container" style="margin-top: 51px">
    <div>
        <h1>报名详情</h1>
        <hr>
    </div>
    <div>
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <td>用户编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>联系电话</td>
                <td>电子邮件</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${enrollPager.recordList}" var="enroll">
                <tr>
                    <td>${enroll.user.id}</td>
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
</html>
