<%--
  Created by IntelliJ IDEA.
  User: BaiYunfei
  Date: 2017/1/5
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>活动审核</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/WEB-INF/pages/templates/bootstrap.jsp"%>
</head>
<body>
<jsp:include page="/WEB-INF/pages/templates/admin/nav.jsp"/>
<div class="container" style="margin-top: 51px">
    <div>
        <h1>活动审核</h1>
        <hr>
    </div>
    <div>
        <div>
            <table id="category_table" class="table table-hover">
                <thead>
                <tr>
                    <td>id</td>
                    <td>活动名称</td>
                    <td>主办方</td>
                    <td>活动时间</td>
                    <td>活动地点</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="check" items="${activityCheckPager.recordList}">
                    <tr>
                        <td class="check_id">${check.id}</td>
                        <td class="check_name"><a href="/activity/${check.activity.id}">${check.activity.name}</a>  </td>
                        <td>${check.activity.organizer}</td>
                        <td><fmt:formatDate value="${check.activity.startTime}" type="date" dateStyle="full" /></td>
                        <td>${check.activity.location}</td>
                        <td>
                            <c:if test="${check.processed}">
                                <span>${check.pass?'已同意':'已拒绝'}</span>
                            </c:if>
                            <c:if test="${!check.processed}">
                                <button role="button" class="btn btn-primary btn-xs save_btn" onclick="agree(this)">同意</button>
                                <button role="button" class="btn btn-danger btn-xs" onclick="disagree(this)">拒绝</button>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <nav>
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${activityCheckPager.currentPage <= 1}">
                            <li class="disabled"><span><i class="uk-icon-angle-double-left"></i>上一页</span></li>
                        </c:when>
                        <c:otherwise>
                            <li class=""><a href="?pageNum=${activityCheckPager.currentPage-1}"><i class="uk-icon-angle-double-left"></i><span>上一页</span></a></li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${activityCheckPager.currentPage < activityCheckPager.pageCount}">
                            <li class=""><a href="?pageNum=${activityCheckPager.currentPage+1}"><span>下一页</span><i class="uk-icon-angle-double-right"></i></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled"><span>下一页<i class="uk-icon-angle-double-right"></i></span></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
<script>

    function agree(btn){
        var name = $(btn).parents("tr").find(".check_name").children().val();

        //修改
        //alert("修改为"+new_name);
        $.post("<%=request.getContextPath()%>/admin/check/handle",
                {
                    id:$(btn).parents("tr").find(".check_id").text(),
                    process:true
                },
                function (data, status) {
                    if(status == "success"){
                        if(data.status == true) {
                            alert("已同意活动："+name);
                            location.replace(location.href); //刷新
                        }else{
                            alert("操作失败："+data.msg);
                        }
                    }else{
                        alert("操作失败");
                    }
                }
        );

    }

    function disagree(btn){
        var name = $(btn).parents("tr").find(".check_name").children().val();

        //修改
        //alert("修改为"+new_name);
        $.post("<%=request.getContextPath()%>/admin/check/handle",
                {
                    id:$(btn).parents("tr").find(".check_id").text(),
                    process:false
                },
                function (data, status) {
                    if(status == "success"){
                        if(data.status == true) {
                            alert("已拒绝活动："+name);
                            location.replace(location.href); //刷新
                        }else{
                            alert("操作失败："+data.msg);
                        }
                    }else{
                        alert("操作失败");
                    }
                }
        );

    }

</script>
</html>
