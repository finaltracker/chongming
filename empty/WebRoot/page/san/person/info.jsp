<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">人员查看</block>
<block name="body">
	<style>
	.col-lg-7{margin-top:7px}
	</style>
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/person/add" class="btn btn-danger pull-right">增加人员</a>
            <strong>当前位置：</strong>人员&nbsp;>&nbsp;${pageInfo_actionTitle}人员
        </p>
    </div>
    <div class="dashboard-container">
        <!-- Container starts -->
        <div class="container">


            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="widget widget-info">

                        <div class="widget-body">
                           <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/person/add.do?method=${pageInfo_action}" class="form-horizontal">
                                <fieldset>
                                    <legend>${pageInfo_actionTitle}人员</legend>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">姓名</label>
                                        <div class="col-lg-7">${person_truename}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">身份证号</label>
                                        <div class="col-lg-7">${person_ssid}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">性别</label>
                                        <div class="col-lg-7">
											${sex}                                         
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">政治面貌</label>
                                        <div class="col-lg-7">
                                            ${person_zzmm}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">文化程度</label>
                                        <div class="col-lg-7">
                                            ${person_whcd}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">所属村镇</label>
                                        <div class="col-lg-7">                                            
                                                ${countryName}                                           
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">手机号码</label>
                                        <div class="col-lg-7">
                                            ${person_phone}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="birthday">出生日期</label>
                                        <div class="col-lg-7">
                                            ${person_birthday}
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">户籍地址</label>

                                        <div class="col-lg-7">
                                           ${person_address}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">其它信息</label>

                                        <div class="col-lg-7">
                                            ${person_remark}
                                        </div>
                                    </div>
                                  
                                    <div class="form-group">
                                        <div class="col-lg-7 col-lg-offset-3">
                                            <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/person.do">返回</button>
                                        </div>
                                    </div>

                                </fieldset>
							</form>                          
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</block>

