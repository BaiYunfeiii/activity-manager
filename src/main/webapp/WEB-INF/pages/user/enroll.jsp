<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${activity.name}|报名</title>
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
                <form class="uk-form uk-form-horizontal">
                    <input type="hidden" value="${activity.id}" name="id" id="activity-id">
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="name-field">真实姓名</label>
                        <div class="uk-form-controls"><input type="text" name="enroll.name" id="name-field" value="${user.name}" disabled></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="phone-field">联系电话</label>
                        <div class="uk-form-controls"><input type="text" name="enroll.phone" id="phone-field" value="${user.phone}" disabled></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="email-field">邮箱</label>
                        <div class="uk-form-controls"><input type="text" name="enroll.email" id="email-field" value="${user.email}" disabled></div>
                    </div>
                    <div class="uk-form-row">
                        <button type="button" onclick="enroll()" class="uk-button uk-button-primary uk-width-1-6">报名</button>
                    </div>
                </form>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>
<script>

    function enroll() {
        $.post("<%=request.getContextPath()%>/user/activity/enroll",
                {id:$("#activity-id").val()},
                function (data, status) {
                    if(status == "success"){
                        if(data.status == true) {
                            alert("报名成功");
                            window.location.href='<%=request.getContextPath()%>/index'; //跳转
                        }else{
                            alert("报名失败："+data.msg);
                        }
                    }else{
                        alert("报名失败");
                    }
                }
        );
    }

</script>
</body>
</html>