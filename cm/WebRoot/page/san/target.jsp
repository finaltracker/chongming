<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<jsp:include page="Common/base.jsp" flush="true"/>
<block name="title">指标管理</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/add" class="btn btn-danger pull-right">增加指标</a>
            <strong>当前位置：</strong>指标管理&nbsp;>&nbsp;指标列表
        </p>
    </div>
<!-- Dashboard Container starts -->
<div class="dashboard-container">
    <!-- Container starts -->
    <div class="container">

        <div class="row">
            <div class="col-xs-12">
                <div class="widget">
                    <div class="widget-body">
                        <form action="" method="get" class="form-inline">
                            <div class="form-group">
                                <label class="control-label"> 名称 </label>
                                <input type="text" class="form-control" name="target_name" value="{$searchMap.target_name}"/>
                                <label class="control-label"> 所属部门 </label>
                                <select class="select2 form-control" name="part_id">
                                    <option value="0">所有可见</option>
                                    "${partListSel}"
                                </select>&nbsp;&nbsp;
                                <button type="submit" class="btn btn-primary">搜索</button>
                                <button class="btn btn-default back" data-url="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}">查看所有</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="widget widget-info">
                    <div class="widget-header">
                        <h4><i class="fa fa-file-text-o"></i> 目标信息</h4>
                    </div>
                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped no-margin">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>名称</th>
                                    <th>考核分数</th>
                                    <th>考核部门</th>
                                    <th>录入人</th>
                                    <th>录入时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <foreach name="list" item="item" key="k" >
                                    <tr>
                                        <td>{$k+1}</td>
                                        <td>{$item.target_name}</td>
                                        <td>{$item.target_score}</td>
                                        <td>{$item.part_name}</td>
                                        <td>{$item.author}</td>
                                        <td>{$item.pubdate|date="Y-m-d H:i:s",###}</td>
                                        <td><a href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/edit?id={$item.id}"><i class="fa fa-edit"></i> 修改</a>
                                            <a href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/del?id={$item.id}" class="item-remove"><i class="fa fa-remove"></i> 删除</a>
                                        </td>
                                    </tr>
                                </foreach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Row Ends -->
    </div>
    <!-- Container ends -->

</div>
</block>
<block name="bottom">
</block>
