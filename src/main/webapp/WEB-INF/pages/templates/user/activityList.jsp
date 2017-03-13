<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/4
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div>
        <c:forEach items="${activityPager.recordList}" var="activity">
            <div class="uk-grid uk-grid-medium">
                <div class="uk-width-1-3">
                    <a class="uk-thumbnail" href="#"><img src="<%=request.getContextPath() %>/resources/images/potatoBattery.jpg" alt=""></a>
                </div>
                <div class="uk-width-2-3">
                    <h3><a href="<%=request.getContextPath()%>/activity/${activity.id}" >${activity.name}</a></h3>
                    <p>时间：<fmt:formatDate value="${activity.startTime}" type="date" dateStyle="full" /></p>
                    <p>主办方：${activity.organizer}</p>
                    <p>地点：${activity.location}</p>
                </div>
            </div>
            <hr>
        </c:forEach>
        <ul class="uk-pagination">
            <c:choose>
                <c:when test="${activityPager.currentPage <= 1}">
                    <li class="uk-pagination-previous uk-disabled"><span><i class="uk-icon-angle-double-left"></i>上一页</span></li>
                </c:when>
                <c:otherwise>
                    <li class="uk-pagination-previous"><a href="?pageNum=${activityPager.currentPage-1}"><i class="uk-icon-angle-double-left"></i><span>上一页</span></a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${activityPager.currentPage < activityPager.pageCount}">
                    <li class="uk-pagination-next"><a href="?pageNum=${activityPager.currentPage+1}"><span>下一页</span><i class="uk-icon-angle-double-right"></i></a></li>
                </c:when>
                <c:otherwise>
                    <li class="uk-pagination-next uk-disabled"><span>下一页<i class="uk-icon-angle-double-right"></i></span></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
