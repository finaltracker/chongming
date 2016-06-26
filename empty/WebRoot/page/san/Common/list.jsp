<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <block name="title"><title>后台管理中心</title></block>
    <link href="{:asset('../css/admin/reset.css')}" rel="stylesheet" type="text/css">
    <link href="{:asset('../css/admin/zh-cn-system.css')}" rel="stylesheet" type="text/css">
    <link href="{:asset('../css/admin/table_form.css')}" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="{:asset('js/jquery.min.js')}"></script>
    <script type="text/javascript" src="{:asset('js/jquery.cookie.js')}"></script>
    <script type="text/javascript" src="{:asset('js/admin/admin_common.js')}"></script>
    <script src="{:asset('js/artdialog/jquery.artDialog.source.js')}&skin=default"></script>
    <script src="{:asset('js/artdialog/plugins/iframeTools.source.js')}"></script>
    <block name="subheader"></block>
</head>
<body>
    <div class="subnav">
        <div class="content-menu ib-a blue line-x">
            <block name="subnav">
                <a class="add fb" href="__CONTROLLER__/add"><em>添加</em></a>　    <a class="on" href="__CONTROLLER__/index"><em>列表</em></a>
            </block>
        </div>
    </div>
    <div class="pad-lr-10">
        <block name="search"></block>
        <block name="main">
            <form name="myform" action="__CONTROLLER__/listorder" method="post">
                <div class="table-list">
                    <table width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th width="16"><input type="checkbox" value="" id="check_box" onclick="selectall('ids[]');"></th>
                                <th width="37">排序</th>
                                <th width="40">ID</th>
                                <?php foreach ($list_fields as $key => $field) { ?>
                                  <th><?php echo $field['name']; ?></th>
                                <?php } ?>
                                <th width="118">更新时间</th>
                                <th width="102">管理操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php foreach ($contents as $key => $content) { ?>
                            <tr>
                                <td align="center"><input class="inputcheckbox " name="ids[]" value="<?php echo $content['id']; ?>" type="checkbox"></td>
                                <td align="center"><input name="listorders[<?php echo $content['id']; ?>]" type="text" size="3" value="<?php echo $content['listorder']; ?>" class="input-text-c input-text"></td>
                                <td align="center"><?php echo $content['id']; ?></td>
                                <?php foreach ($list_fields as $key => $field) { ?>
                                <td><?php echo $content[$field['field']]; ?></td>
                                <?php } ?>
                                <td align="center"><?php echo $content['updatetime']; ?></td>
                                <td align="center">
                                    <a href="__CONTROLLER__/edit?id=<?php echo $content['id'] ?>">修改</a> | <a href="__CONTROLLER__/delete?id=<?php echo $content['id']; ?>" onClick="return confirm('确认删除『 <?php echo $content['title']; ?> 』 吗？')">删除</a>
                                </td>
                            </tr>
                            <?php } ?>
                        </tbody>
                    </table>
                    <div class="btn"><label for="check_box">全选/取消</label>
                        <input name="submit" type="submit" class="button" value="排序">&nbsp;
                        <input name="deletesubmit" type="submit" class="button" value="删除" onclick="document.myform.action='<?php echo U('Content/delete'). "?catid=" .$catid; ?>';return confirm('确认要删除 『 选中 』 吗？')">
                    </div>
                    <?php if (isset($pages)) { ?>
                    <div id="pages">
                        <?php echo $pages; ?>
                    </div>
                    <?php } ?>
                </div>
            </form>
        </block>
    </div>
    <block name="footer">
        <script type="text/javascript">
            window.top.$('#display_center_id').css('display','none');
        </script>
    </block>
</body>
</html>