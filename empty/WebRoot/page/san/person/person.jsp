<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">人员信息</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/person/add.do?method=1" class="btn btn-danger pull-right">增加人员</a>
            <strong>当前位置：</strong>人员&nbsp;>&nbsp;人员列表
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
                            <!-- button type="button" class="btn btn-primary pull-right form-action" data-action="form" data-url="${pageContext.request.contextPath}/home/person.do?opt=21">导出</button-->
                            <div class="form-group">
                                <label class="control-label"> 姓名 </label>
                                <input type="text" class="form-control input-sm" name="person_truename" value="${person_truename}"/>
                                <label class="control-label"> 身份证号 </label>
                                <input type="text" class="form-control input-sm" name="person_ssid" value="${person_ssid}"/>
								<if condition="$userInfo.role_id neq 3">
                                <label class="control-label"> 所属乡镇 </label>
                                <select class="select2 form-control" name="country_id">
                                    <option value="">请选择</option>
                                    "${countrySelect}"
                                </select>
								</if>&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" data-action="form" data-url="${pageContext.request.contextPath}/home/person.do?search=1">搜索</button>
                                <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/person.do?showAll=1"">查看所有</button>
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
                        <h4><i class="fa fa-file-text-o"></i> 人员列表</h4>
                    </div>
                    <div class="widget-body">
                        <div class="table-responsive">
                            <table class="table table2 table-bordered table-striped no-margin">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>姓名</th>
                                    <th>身份证号</th>
                                    <th>所属村镇</th>
                                    <th>手机号</th>                                   
                                    <th>录入人</th>
                                    <th>录入时间</th>
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
                                        <td>${targetEnhance.countryName}</td>
										<td>${targetEnhance.phone}</td>
                                        <td>${targetEnhance.author}</td>
                                        <td>${targetEnhance.stringPubData}</td>
                                        <td>
                                            <c:if test="${isadmin eq true || targetEnhance.stat eq false}">
												<a href="${pageContext.request.contextPath}/home/person/add.do?method=3&id=${targetEnhance.id}"><i class="fa fa-edit"></i> 修改</a>
												<a href="${pageContext.request.contextPath}/home/person.do?id=${targetEnhance.id}" class="item-remove"><i class="fa fa-remove"></i> 删除</a>
                                            </c:if>
											<c:if test="${isadmin ne true && targetEnhance.stat ne false}">
												<a href="${pageContext.request.contextPath}/home/person/add.do?method=4&id=${targetEnhance.id}"><i class="fa fa-file-text-o"></i> 查看 </a>
                                            </c:if>
                                            
                                            <c:if test="${targetEnhance.stat ne false}">
												已提交 
                                            </c:if>
                                        </td>                       
                                  
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
										<c:if test="${i eq 10 }" >
											<li><a>...</a></li>
										</c:if>
										<c:if test="${i lt 10 }" >
											<li><a href="${pageContext.request.contextPath}/home/person.do?page=${i}" class="num">${i}</a></li>
										</c:if>
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
            $(".item-remove").on("click",function(){
                var that=this;
                layer.confirm("确认删除吗？该操作将会删除该人员下的考核信息且不可逆?",function(){
                    window.location.href=$(that).attr("href");
                },function(){
                    layer.closeAll();
                })
                return false;
            });
            $(".btn[data-action='form']").on("click",function(){

                $(this).closest("form").attr("action",$(this).attr("data-url")).submit();

            })
        })
    </script>
</block>
