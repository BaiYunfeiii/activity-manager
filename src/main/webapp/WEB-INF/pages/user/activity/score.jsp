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
    <title>成绩管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/WEB-INF/pages/templates/bootstrap.jsp"%>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container" style="margin-top: 51px">
    <div>
        <h1>成绩管理</h1>
        <hr>
    </div>
    <div>
        <div>
            <table id="category_table" class="table table-hover">
                <thead>
                <tr>
                    <td>姓名</td>
                    <td>联系电话</td>
                    <td>电子邮箱</td>
                    <td>活动阶段</td>
                    <td>成绩</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="score" items="${scorePager.recordList}">
                    <tr>
                        <input type="hidden" value="${score.id}" class="score-id" />
                        <td class="score-name">${score.user.name}</td>
                        <td>${score.user.phone}</td>
                        <td>${score.user.email}</td>
                        <td>${score.round}</td>
                        <td class="score-value"><input type="text" value="${score.score}" disabled style="border: none;background: none;"/></td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs edit_btn" onclick="tranform(this)">编辑</button>
                            <button type="button" class="btn btn-primary btn-xs save_btn" onclick="update(this)" style="display: none">保存</button>
                            <button type="button" class="btn btn-danger btn-xs" onclick="delete_score(this)">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="float: left">
            <form class="form-inline" action="/user/activity/${activity.id}/scores">
                <div class="form-group">
                    <input class="form-control" type="text" name="query" placeholder="关键字：姓名、电话、邮箱">
                    <button type="submit" class="btn btn-default">搜索</button>
                </div>
            </form>
        </div>
        <div>
            <button class="btn btn-primary" type="button" data-toggle="modal" data-target=".bs-example-modal-sm" style="float: right"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加成绩</button>
            <div class="modal fade bs-example-modal-sm" tabindex="-1" type="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                            <h4 class="modal-title">添加成绩</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form" type="form" id="score-form">
                                <input type="hidden" name="activityId" value="${activity.id}">
                                <div class="form-group">
                                    <label>用户编号</label>
                                    <input type="text" name="userId" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>阶段</label>
                                    <input type="number" min="1" max="${activity.round}" name="round" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>成绩</label>
                                    <input type="text" name="scoreValue" class="form-control">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="saveScore()">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="clear: both">
            <nav>
                <ul class="pagination">
                    <li class="${scorePager.currentPage <=1 ? 'disabled' : ''}"><a href="?pageNum=${scorePager.currentPage - 1}">&laquo;</a></li>
                    <c:forEach var="i" begin="${scorePager.currentPage}" end="${scorePager.pageCount}">
                        <li class="${i eq scorePager.currentPage ? 'active' : ''}"><a href="?pageNum=${i}">${i}</a></li>
                    </c:forEach>
                    <li class="${scorePager.currentPage <=1 ? 'disabled' : ''}"><a href="?pageNum=${scorePager.currentPage + 1}">&raquo;</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
<script>

    //改变按钮
    function tranform(btn){
        var edit_btn = $(btn);
        var row = edit_btn.parents("tr");
        var name_field = row.find(".score-value").children();
        name_field.attr("disabled",false);
        name_field.focus().select();

        var save_btn = row.find(".save_btn");
        edit_btn.hide();
        save_btn.toggle();
    }

    function update(btn){
        //修改
        //alert("修改为"+new_name);
        $.post("<%=request.getContextPath()%>/user/score/update",
                {
                    scoreId:$(btn).parents("tr").find(".score-id").val(),
                    scoreValue:$(btn).parents("tr").find(".score-value").children().val()
                },
                function (data, status) {
                    if(status == "success"){
                        if(data.status == true) {
                            alert("修改成功");
                            location.replace(location.href); //刷新
                        }else{
                            alert("修改失败："+data.code);
                        }
                    }else{
                        alert("修改失败");
                    }
                }
        );

        $(btn).hide();
        $(btn).parents("td").find(".edit_btn").toggle();
    }

    function delete_score(btn){
        var name = $(btn).parents("tr").find(".score-name").text();
        var scoreValue = $(btn).parents("tr").find(".score-value").children().val();
        if(!window.confirm('确认删除 '+ name +' 的成绩:'+scoreValue+'?')){
            console.log(name);
            return false;
        }
        //发送请求，删除
        //alert("删除id:"+id+",name:"+name);
        $.post("<%=request.getContextPath()%>/user/score/delete",
                {scoreId:$(btn).parents("tr").find(".score-id").val()},
                function (data, status) {
                    if(status == "success"){
                        if(data.status == true) {
                            alert("删除成功");
                            location.replace(location.href); //刷新
                        }else{
                            alert("删除失败："+data.code);
                        }
                    }else{
                        alert("删除失败");
                    }
                }
        );
    }

    function saveScore(){
        $.post("<%=request.getContextPath()%>/user/score/save",
                $("#score-form").serialize(),
                function (data, status) {
                    if(status == "success"){
                        if(data.status == true) {
                            alert("添加成功");
                            location.replace(location.href); //刷新
                        }else{
                            alert("添加失败："+data.msg);
                        }
                    }else{
                        alert("添加失败");
                    }
                }
        );
    }
</script>
</html>
