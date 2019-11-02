<%--
  Created by IntelliJ IDEA.
  User: 13779
  Date: 2019/10/31
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/main.css">
    <link rel="stylesheet" href="${APP_PATH}/static/ztree/zTreeStyle.css">

    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }

        table tbody tr:nth-child(odd) {
            background: #F4F4F4;
        }

        table tbody td:nth-child(even) {
            color: #C00;
        }
    </style>
</head>

<body>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <%@include file="/WEB-INF/jsp/common/menu.jsp"%>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <button class="btn btn-success" onclick="doAssign()">分配许可</button>
                    <ul id="permissionTree" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/static/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/script/docs.min.js"></script>
<script src="${APP_PATH}/static/layer/layer/layer.js"></script>
<script src="${APP_PATH}/static/ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
    var likeflg = false;
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
        var setting = {
            async: {
                enable: true,
                url: "${APP_PATH}/permission/loadAssignData?roleid=${param.id}",
                autoParam: ["id", "name=n", "level=lv"]
            },
            view: {
                selectedMulti: false,
                addDiyDom: function (treeId, treeNode) {
                    var icoObj = $("#" + treeNode.tId + "_ico"); // tId = permissionTree_1, $("#permissionTree_1_ico")
                    if (treeNode.icon) {
                        icoObj.removeClass("button ico_docu ico_open").addClass(treeNode.icon).css("background", "");
                    }
                }
            },
            check: {
                enable: true
            }
        };

        //异步获取zTree的数据
        $.fn.zTree.init($("#permissionTree"), setting);
    });

    //执行分配
    function doAssign() {
        var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
        var nodes = treeObj.getCheckedNodes(true);
        if (nodes.length == 0) {
            layer.msg("请选择需要分配的许可信息", {time: 2000, icon: 5, shift: 6}, function () {
            });
        } else {
            var d = "roleid=${param.id}";
            $.each(nodes, function (i, node) {
                d += "&permissionids=" + node.id;
            });
            $.ajax({
                type: "POST",
                url: "${APP_PATH}/role/doAssign",
                data: d ,
                success: function (result) {
                    if (result) {
                        layer.msg("分配许可信息成功", {time: 2000, icon: 6}, function () {});
                    } else {
                        layer.msg("分配许可信息失败", {time: 2000, icon: 5, shift: 6}, function () {});
                    }
                }
            });
        }
    }
</script>
</body>
</html>