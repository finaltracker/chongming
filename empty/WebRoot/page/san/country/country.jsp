<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">乡镇列表</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/add" class="btn btn-danger pull-right">增加乡镇</a>
            <strong>当前位置：</strong>乡镇&nbsp;>&nbsp;乡镇列表
        </p>
    </div>
<!-- Dashboard Container starts -->
<div class="dashboard-container">

    <!-- Container starts -->
    <div class="container">
        <!-- Row Starts -->

        <!-- Row Ends -->

        <div class="row">
            <div class="col-xs-12">
                <div class="widget">
                    <div class="widget-body">
                        <form action="" method="get" class="form-inline">

                                <div class="form-group">
                                    <label class="control-label"> 名称 </label>
                                    <input type="text" class="form-control" name="name" value="{$condition.name}"/>
                                    <label class="control-label"> 所属 </label>
                                    <select class="select2 form-control" name="country_id">
                                        <option value="">请选择</option>
                                        {$countrySelect}
                                    </select>&nbsp;&nbsp;
                                    <button type="submit" class="btn btn-primary"> 搜索</button>
                                </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="widget widget-info">
                    <div class="widget-header">
                        <h4><i class="fa fa-file-text-o"></i> 乡镇列表</h4>
                    </div>

                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped no-margin">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>名称</th>
                                    <th>上级单位</th>
                                   <!-- <th>联系方式</th>
                                    <th>录入人</th>
                                    <th>录入时间</th>-->
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <foreach name="list" item="item" key="k" >
                                <tr>
                                    <td>{$k+1}</td>
                                    <td>{$item.name}</td>
                                    <td>{$item.parentName}</td>

                                    <td><a href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/edit?id={$item.id}"><i class="fa fa-edit"></i> 修改</a>
                                        <a href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/del?id={$item.id}" class="item-remove"><i class="fa fa-remove"></i> 删除</a>
                                    </td>
                                </tr>
                                </foreach>
                                </tbody>
                            </table>
                        </div>
                        {$pageShow}
                        <div class="clearfix"></div>
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