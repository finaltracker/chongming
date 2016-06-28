<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">${pageInfo_action}乡镇</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/country/add.do" class="btn btn-danger pull-right">增加乡镇</a>
            <strong>当前位置：</strong>乡镇&nbsp;>&nbsp;${pageInfo_action}乡镇
        </p>
    </div>
    <div class="dashboard-container">

            <!-- Row Ends -->
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="widget widget-info">
                        <div class="widget-body">
                            <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/country/add.do?method=${action_method}" class="form-horizontal bv-form">
                                <fieldset>
                                    <legend>${pageInfo_action}乡镇</legend><input type="hidden" name="action" value="${action_method}"/><input type="hidden" name="xid" value="${country_id}"/>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">名称</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="country_name" value="${country_name}"required/>
                                        </div>
                                    </div>

                                   <!-- <div class="form-group">
                                        <label class="col-lg-3 control-label">户数</label>

                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="email"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">人口</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="password"/>
                                        </div>
                                    </div>-->

                                    <!--<div class="form-group">
                                        <label class="col-lg-3 control-label">所属级别</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="password"/>
                                        </div>
                                    </div>-->
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">上级单位</label>
                                        <div class="col-lg-7">
                                            <select class="form-control" name="parentid" required>
                                                <option value="0">崇明县</option>
                                                <foreach name="parentList" item="item" key="k" >
                                                    <option value="{$item.id}" {$item["id"]==$country["parentid"]?"selected":""}>--{$item.name}</option>
                                                </foreach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">联系人</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="country_contact" value="${country_contact}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">联系方式</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="country_phone" value="${country_phone}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">显示顺序</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control"  pattern="\d+" name="country_display_order" value="${country_display_order}" required/>
                                        </div>
                                    </div>
                                </fieldset>

                                <div class="form-group">
                                    <div class="col-lg-7 col-lg-offset-3">
                                        <button type="submit" class="btn btn-success">提交</button> <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/country.do">返回</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</block>
<block name="bottom">
    <script>
        $(function(){
            $('.bv-form').bootstrapValidator({
                submitHandler: function(validator, form, submitButton) {
                    $form=$(form);
                    $.ajax({
                        url:$form.attr("action"),
                        type:$form.attr("method"),
                        data:$form.serialize(),
                        success:function(){
                            layer.confirm('${pageInfo_action}成功', {
                                btn: ['继续录入','返回列表'] //按钮
                            }, function(){
                                window.location.href='${pageContext.request.contextPath}/home/country/add.do?method=1';
                            }, function(){
                                window.location.href='${pageContext.request.contextPath}/home/country.do';
                            });
                        }
                    });
                }
            })
        });
    </script>
</block>
