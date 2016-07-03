<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">部门列表</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/part/add.do?method=1" class="btn btn-danger pull-right">增加部门</a>
            <strong>当前位置：</strong>部门管理&nbsp;>&nbsp;部门列表
        </p>
    </div>
<!-- Dashboard Container starts -->
<div class="dashboard-container">
    <!-- Container starts -->
    <div class="container">
        <!-- Row Ends -->

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="widget widget-info">
                    <div class="widget-header">
                        <h4><i class="fa fa-file-text-o"></i> 部门列表</h4>
                    </div>
                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped no-margin">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>部门</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
								<c:set var="index" value="0" />
                                <c:forEach var="citem" items="${list}">
                                    <c:set var="index" value="${index+1}" />
                                    <tr>
                                        
                                 	<td>${index}</td>
                                 	<td>${citem.partName}</td>
                                        <td>
                                            <if condition="$item.id gt 2 ">
	                                    	<a href="${pageContext.request.contextPath}/home/part/add.do?method=3&id=${citem.id}"><i class="fa fa-edit"></i> 修改</a>
	                                    	<a href="${pageContext.request.contextPath}/home/part.do?id=${citem.id}" class="item-remove"><i class="fa fa-remove"></i> 删除</a>
                                            <else/>
                                                		<!--不可操作-->

                                            </if>
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
