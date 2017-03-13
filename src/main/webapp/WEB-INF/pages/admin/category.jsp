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
    <title>分类管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/WEB-INF/pages/templates/bootstrap.jsp"%>
</head>
<body>
<jsp:include page="/WEB-INF/pages/templates/admin/nav.jsp"/>
<div class="container" style="margin-top: 51px">
    <div>
        <h1>分类管理</h1>
        <hr>
    </div>
    <div>
        <div>
            <table id="category_table" class="table table-hover">
                <thead>
                <tr>
                    <td>id</td>
                    <td>分类</td>
                    <td>添加时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="category" items="${categoryList}">
                    <tr>
                        <td class="category_id">${category.id}</td>
                        <td class="category_name"><input disabled name="name" value="${category.name}" style="border: none;background: none;"></td>
                        <td>${category.publishTime}</td>
                        <td>
                            <button role="button" class="btn btn-primary btn-xs edit_btn" onclick="tranform(this)">编辑</button>
                            <button role="button" class="btn btn-primary btn-xs save_btn" onclick="update(this)" style="display: none">保存</button>
                            <button role="button" class="btn btn-danger btn-xs" onclick="delete_category(this)">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <form class="form-inline" id="add_form">
                <div class="form-group">
                    <input class="form-control" role="text" id="new_category_name" placeholder="名称">
                    <button role="button" id="add_btn" class="btn btn-primary">添加</button>
                    <label for="new_category_name" class="control-label" style="display: none;">名称不能为空</label>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    function getNameFiledByBtn(btn){
        return $(btn).parents("tr").find(".category_name").children();
    }

    //改变按钮
    function tranform(btn){
        var edit_btn = $(btn);
        var row = edit_btn.parents("tr");
        var name_field = row.find(".category_name").children();
        name_field.attr("disabled",false);
        name_field.focus().select();

        var save_btn = row.find(".save_btn");
        edit_btn.hide();
        save_btn.toggle();
    }

    function update(btn){
        var name_field = getNameFiledByBtn(btn);
        var new_name = name_field.val();

        //修改
        //alert("修改为"+new_name);
        $.post("<%=request.getContextPath()%>/admin/category/update",
                {
                    categoryId:$(btn).parents("tr").find(".category_id").text(),
                    categoryName:$(btn).parents("tr").find(".category_name").children().val()
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

    function delete_category(btn){
        var name = $(btn).parents("tr").find(".category_name").children().val();
        if(!window.confirm('确认删除分类：'+ name +'?')){
            console.log(name);
            return false;
        }
        //发送请求，删除
        //alert("删除id:"+id+",name:"+name);
        $.post("<%=request.getContextPath()%>/admin/category/delete",
                {categoryId:$(btn).parents("tr").find(".category_id").text()},
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

    $(function(){
        $("#add_btn").click(function () {
            var new_name = $("#new_category_name").val();

            var add_form = $("#new_category_name").parents("div");
            var error_label = add_form.find(".control-label");
            if(new_name == ""){
                add_form.addClass("has-error");
                error_label.toggle();
            }else{
                add_form.removeClass("has-error");
                error_label.hide();
                console.log(new_name);
                //发送请求添加新分类
                //alert("添加新分类："+new_name);
                $.post("<%=request.getContextPath()%>/admin/category/save",
                        {categoryName:new_name},
                        function (data,status) {
                            if(status == "success"){
                                if(data.status == true) {
                                    alert("添加成功");
                                    location.replace(location.href); //刷新
                                }else{
                                    alert("添加失败："+data.code);
                                }
                            }else{
                                alert("添加失败");
                            }
                        }
                );
            }
        })})
</script>
</html>
