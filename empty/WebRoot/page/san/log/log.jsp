<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">首页</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <strong>当前位置：</strong>首页&nbsp;>&nbsp;日志记录
        </p>
    </div>
<!-- Dashboard Container starts -->
<div class="dashboard-container">
    <!-- Container starts -->
    <div class="container">


        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="widget widget-info">
                    <div class="widget-header">
                        <h4><i class="fa fa-file-text-o"></i> 日志记录</h4>
                    </div>
                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped no-margin">
                                <thead>
                                <tr>
									<th>顺序</th>
                                    <th>描述</th>
                                    <th>操作者</th>
                                    <th>IP</th>
                                    <th>时间</th>
                                </tr>
                                </thead>
                                <tbody>
								<c:set var="index" value="0" />
                                <c:forEach var="item" items="${list}">
                                    <c:set var="index" value="${index+1}" />
                                <tr>
                                 	<td>${index}</td>
                                    <td>${item.info}</td>
                                    <td>${item.author}</td>
                                    <td>${item.ip}</td>
                                    <td>${item.pubdateStr}</td>
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
