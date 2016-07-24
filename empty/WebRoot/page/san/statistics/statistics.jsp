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
                        <form action="" method="post" class="form-inline">
                            <button type="button" class="btn btn-primary pull-right form-action" data-action="form" data-url="${pageContext.request.contextPath}/home/statistics.do?opt=21">导出</button>
                            <div class="form-group">
                                <label class="control-label"> 考核对象</label>
                                <select class="select2 form-control" name="performance_cat">
                                    <option value="">请选择</option>
                                    ${countrySelect}
                                </select>
                                <label class="control-label"> 所属等级 </label>
                                <select class="select2 form-control" name="level_id">
                                    <option value="">请选择</option>
                                    ${levelSelect}
                                </select>&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" data-action="form" data-url="${pageContext.request.contextPath}/home/statistics.do">搜索</button>
                                <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/statistics.do">查看所有</button>
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
                                    <th>名称</th>
                                    <th>基础分</th>
                                    <th>诚信积累(加分)</th>
                                    <th>诚信流失(减分)</th>
                                    <th>诚信总分</th>
                                    <th>等级</th>
                                </tr>
                                </thead>
                                <tbody>
								<c:set var="index" value="0" />
                                <c:forEach var="obj" items="${list}">
								<c:set var="index" value="${index+1}" />
                                  <tr>
                                        <td>${index}</td>
                                        <td>${obj.name}</td>
                                        <td>${obj.baseScore}</td>
                                        <td>${obj.addScore}</td>
										<td>${obj.subScore}</td>
										<td>${obj.totalScore}</td>
										<td>${obj.rank}</td>
                                  </tr>
                                </c:forEach>	
                                </tbody>
                            </table>
                        </div>
						<span class="pull-right" style="margin-top:20px">共 ${noOfRecords} 条记录</span>
						<ul class="pagination">
							<c:if test="${currentPage != 1}">
								<li><a href="${pageContext.request.contextPath}/home/statistics.do?page=${currentPage - 1}" class="prev"><<</a></li>
							</c:if>

							<c:forEach begin="1" end="${noOfPages}" var="i">
								<c:choose>
									<c:when test="${currentPage eq i}">
										<li class="active"><span class="current">${i}</span></li>
									</c:when>
									<c:otherwise>
										<c:if test="${i eq 10 }" >
											<li><a>...</a></li>
										</c:if>
										<c:if test="${i lt 10 }" >
											<li><a href="${pageContext.request.contextPath}/home/statistics.do?page=${i}" class="num">${i}</a></li>
										</c:if>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${currentPage lt noOfPages}">
								<li><a href="${pageContext.request.contextPath}/home/statistics.do?page=${currentPage +1}" class="next">>></a></li>
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
