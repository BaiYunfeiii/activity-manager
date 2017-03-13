<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发起活动</title>
    <%@include file="/WEB-INF/pages/templates/uikit.jsp"%>

    <link href="<%=request.getContextPath() %>/resources/uikit/css/components/htmleditor.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath() %>/resources/uikit/js/components/htmleditor.min.js" ></script>

    <link href="<%=request.getContextPath()%>/resources/uikit/css/components/datepicker.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/resources/uikit/js/components/datepicker.min.js"></script>

    <link href="<%=request.getContextPath() %>/resources/codemirror/lib/codemirror.css" rel="stylesheet">
    <script src="<%=request.getContextPath() %>/resources/codemirror/lib/codemirror.js"></script>
    <script src="<%=request.getContextPath() %>/resources/codemirror/mode/markdown/markdown.js"></script>
    <script src="<%=request.getContextPath() %>/resources/codemirror/addon/mode/overlay.js"></script>
    <script src="<%=request.getContextPath() %>/resources/codemirror/mode/xml/xml.js"></script>
    <script src="<%=request.getContextPath() %>/resources/codemirror/mode/gfm/gfm.js"></script>
    <script src="<%=request.getContextPath() %>/resources/marked/marked.min.js"></script>
</head>
<body>
<c:import url="/template/nav"></c:import>
<div class="uk-container uk-container-center">
    <div class=" uk-grid" style="margin-top: 30px">
        <div class="uk-width-3-4">
            <h1>发起活动</h1>
            <hr>
            <div>
                <form class="uk-form uk-form-horizontal" method="post" action="<%=request.getContextPath()%>/user/activity/publish">
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="username-field">活动名称</label>
                        <div class="uk-form-controls"><input type="text" class="" name="name" id="username-field" value=""></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="username-field">分类</label>
                        <div class="uk-form-controls">
                            <select name="categoryId">
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="startTime-field">开始时间</label>
                        <div class="uk-form-controls"><input type="text" class="" name="startTime" id="startTime-field" value="" data-uk-datepicker="{format:'YYYY-MM-DD'}"></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="location-field">地点</label>
                        <div class="uk-form-controls"><input type="text" class="" name="location" id="location-field" value=""></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="publish-field">主办方</label>
                        <div class="uk-form-controls"><input type="text" class="" name="organizer" id="publish-field" value=""></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label" for="round-field">阶段数量</label>
                        <div class="uk-form-controls"><input type="number" min="1" class="" name="round" id="round-field" value=""></div>
                    </div>
                    <div class="uk-form-row">
                        <label class="uk-form-label">活动简介</label>
                    </div>
                    <div class="uk-form-row">
                        <div class=""><textarea name="description" data-uk-htmleditor></textarea></div>
                    </div>
                    <div class="uk-form-row">
                        <button type="submit" class="uk-button uk-button-primary uk-width-1-1">发起</button>
                    </div>
                </form>
            </div>
        </div>
        <c:import url="/template/sideBar" />
    </div>
</div>
</body>
</html>