<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">等级列表</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/level/add.do?method=1" class="btn btn-danger pull-right">增加等级</a>
            <strong>当前位置：</strong>等级&nbsp;>&nbsp;等级列表
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
                                <input type="text" class="form-control" name="level_name" value="${level_name}"/>
                                <button type="submit" class="btn btn-primary">搜索</button>
                                <a class="btn btn-default back" href="${pageContext.request.contextPath}/home/level.do">查看所有</a>
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
                        <h4><i class="fa fa-file-text-o"></i> 等级列表</h4>
                    </div>
                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped no-margin">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>名称</th>
                                    <th>分数</th>
                                    <th>录入人</th>
                                    <th>录入时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="index" value="0" />
                                <c:forEach var="item" items="${list}">
                               
                                  <c:set var="index" value="${index+1}" />
	                                <tr>
	                                    <td>${index}</td>
	                                    <td>${item.levelName}</td>
	                                    <td>${item.levelScore}</td>
	                                    <td>${item.author}</td>
	                                    <td>${item.stringPubData}</td>
	                                    <td><a href="${pageContext.request.contextPath}/home/level/add.do?method=3&id=${item.id}"><i class="fa fa-edit"></i> 修改</a>
                                          <a href="${pageContext.request.contextPath}/home/level.do?id=${item.id}" class="item-remove"><i class="fa fa-remove"></i> 删除</a>
                                      </td> 
	                                    
	                                </tr>
                                </c:forEach>
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
