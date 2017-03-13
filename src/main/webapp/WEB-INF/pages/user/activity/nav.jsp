<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/8
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<%=request.getContextPath()%>/index" class="navbar-brand">Activity·${activity.name }</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="<%=request.getContextPath()%>/user/activity/${activity.id}/info">活动详情</a> </li>
                <li><a href="<%=request.getContextPath()%>/user/activity/${activity.id}/enroll/info" >报名情况</a></li>
                <li><a href="<%=request.getContextPath()%>/user/activity/${activity.id}/scores">成绩管理</a></li>
            </ul>
        </div>
    </div>
</nav>