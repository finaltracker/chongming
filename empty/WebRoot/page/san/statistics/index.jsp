<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">统计信息</block>
<block name="body">
    <div class="title_1">
        <p class="position">

            <strong>当前位置：</strong>统计信息
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
                            <button type="button" class="btn btn-primary pull-right form-action" data-action="form" data-url="${pageContext.request.contextPath}/home/statistics/export">导出</button>
                            <div class="form-group">
                                <label class="control-label"> 姓名 </label>
                                <input type="text" class="form-control" name="truename"  value="${searchMap_truename}"/>
                                <label class="control-label"> 身份证号 </label>
                                <input type="text" class="form-control" name="ssid"  value="${searchMap_ssid}"/>
                                <label class="control-label"> 所属乡镇 </label>
                                <select class="select2 form-control" name="country_id">
                                    <option value="">请选择</option>
                                    ${countrySelect}
                                </select>
                                <label class="control-label"> 所属等级 </label>
                                <select class="select2 form-control" name="level_id">
                                    <option value="">请选择</option>
                                    ${levelSelect}
                                </select>&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" data-action="form" data-url="${pageContext.request.contextPath}/home/statistics">搜索</button>
                                <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/statistics">查看所有</button>
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
                        <h4><i class="fa fa-file-text-o"></i> 统计信息</h4>
                    </div>
                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped no-margin">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>姓名</th>
                                    <th>身份证号</th>
                                    <th>诚信得分</th>
                                    <th>所属等级</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
								<c:set var="index" value="0" />
                                <c:forEach var="targetEnhance" items="${plist}">
								<c:set var="index" value="${index+1}" />
                                  <tr>
                                        <td>${index}</td>
                                        <td>${targetEnhance.truename}</td>
                                        <td>${targetEnhance.ssid}</td>
                                        <td>${targetEnhance.score}</td>
										<td>${targetEnhance.level}</td>
      
                                       <td><a href="/{$Think.MODULE_NAME}/Record?ssid={$item.ssid}">查看详情</a></td>                      
                                  
                                  </tr>
                                </c:forEach>	
                                </tbody>
                            </table>
                        </div>
						<span class="pull-right" style="margin-top:20px">共 ${noOfRecords} 条记录</span>
						<ul class="pagination">
							<c:if test="${currentPage != 1}">
								<li><a href="${pageContext.request.contextPath}/home/person.do?page=${currentPage - 1}" class="prev"><<</a></li>
							</c:if>

							<c:forEach begin="1" end="${noOfPages}" var="i">
								<c:choose>
									<c:when test="${currentPage eq i}">
										<li class="active"><span class="current">${i}</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/home/person.do?page=${i}" class="num">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${currentPage lt noOfPages}">
								<li><a href="${pageContext.request.contextPath}/home/person.do?page=${currentPage +1}" class="next">>></a></li>
							</c:if>
						</ul>
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
    <script>
        $(function(){
            $(".btn[data-action='form']").on("click",function(){
                $(this).closest("form").attr("action",$(this).attr("data-url")).submit();
            })
        })
    </script>
</block>
