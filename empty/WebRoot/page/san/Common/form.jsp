<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <block name="title"><title>红海螺 - 后台管理中心</title></block>
    <link href="{:asset('../css/admin/reset.css')}" rel="stylesheet" type="text/css">
    <link href="{:asset('../css/admin/zh-cn-system.css')}" rel="stylesheet" type="text/css">
    <link href="{:asset('../css/admin/table_form.css')}" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="{:asset('js/jquery.min.js')}"></script>
    <script type="text/javascript" src="{:asset('js/jquery.cookie.js')}"></script>
    <script type="text/javascript" src="{:asset('js/admin/admin_common.js')}"></script>
    <script type="text/javascript" src="{:asset('js/admin/formvalidator.js')}"></script>
    <script type="text/javascript" src="{:asset('js/admin/formvalidatorregex.js')}"></script>
    <script src="{:asset('js/artdialog/jquery.artDialog.source.js')}&skin=default"></script>
    <script src="{:asset('js/artdialog/plugins/iframeTools.source.js')}"></script>
    <block name="subheader"></block>
</head>
<body>
    <div class="subnav">
        <div class="content-menu ib-a blue line-x">
            <block name="subnav"></block>
        </div>
    </div>
    <div class="pad-lr-10">
        <block name="search"></block>
        <block name="main">
        </block>
    </div>
    <block name="footer">
        <script type="text/javascript">
            window.top.$('#display_center_id').css('display','none');
        </script>
    </block>
</body>
</html>