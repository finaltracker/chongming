<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<style>
    .row-info-form .col-lg-4,.row-info-form .col-lg-10{padding-top:7px}
</style>
<div class="row row-info-form">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="widget widget-info">
            <div class="widget-body">
                <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/record/add.do" class="form-horizontal">
                    <fieldset>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">姓名</label>
								
                            <div class="col-lg-4">${person.truename}
                            </div>

                            <label class="col-lg-2 control-label">身份证号</label>

                            <div class="col-lg-4">${person.ssid}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">性别</label>

                            <div class="col-lg-4">
                                ${person.sex}
                            </div>

                            <label class="col-lg-2 control-label">政治面貌</label>

                            <div class="col-lg-4">
                                ${person.zzmm}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">文化程度</label>

                            <div class="col-lg-4">
                                ${person.whcd}
                            </div>

                            <label class="col-lg-2 control-label">所属村镇</label>

                            <div class="col-lg-4">
                                ${countryName}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">手机号码</label>

                            <div class="col-lg-4">
                                ${person.phone}
                            </div>

                            <label class="col-lg-2 control-label">出生日期</label>

                            <div class="col-lg-4">
                                ${person.birthday}
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">户籍地址</label>

                            <div class="col-lg-10">
                                ${person.address}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">其它信息</label>

                            <div class="col-lg-10">
                                ${person.remark}
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

