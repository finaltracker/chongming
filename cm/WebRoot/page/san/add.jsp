<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Common/base.jsp" flush="true"/>
<% 
	String actionTitle = "增加";
	//actionTitle = new String(request.getParameter("actionTitle").getBytes("ISO8859_1")); 
%> 
<block name="title"><%=actionTitle %>指标</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="/home/target/add" class="btn btn-danger pull-right">增加指标</a>
            <strong>当前位置：</strong>指标管理&nbsp;>&nbsp;<%=actionTitle %>指标
        </p>
    </div>
    <div class="dashboard-container">
        <!-- Container starts -->
        <div class="container">


            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="widget widget-info">

                        <div class="widget-body">
                            <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/target/add.do" class="form-horizontal bv-form">
                                <fieldset>
                                    <legend><%=actionTitle %>指标</legend><input type="hidden" name="action" value="{$pageInfo.action}"/><input type="hidden" name="id" value="{$target.id}"/>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">名称</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="target_name" value="${target_name}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">考核分数</label>

                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="target_score" value="${target_score}" required  pattern="^[\-0-9]+$"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">考核部门</label>
                                        <div class="col-lg-7">
                                            <select class="select2 form-control" name="part_id">
                                                "${partListSel}"
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">有效期(天)</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="dateline" value="${dateline}"  required pattern="^[0-9]+$"/>
                                        </div>
                                    </div>
                                </fieldset>

                                <div class="form-group">
                                    <div class="col-lg-7 col-lg-offset-3">
                                        <button type="submit" class="btn btn-success">提交</button> <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/target.do">返回</button>
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
                        success:function(data){
                            //console.log(data);
                            layer.confirm('<%=actionTitle %>成功', {
                                btn: ['继续录入','返回列表'] //按钮
                            }, function(){
                                window.location.href='${pageContext.request.contextPath}/home/target/add.do';
                            }, function(){
                                window.location.href='${pageContext.request.contextPath}/home/target.do';
                            });
                            //$(e.currentTarget).get(0).reset();//resetForm();
                        }
                    });
                }
            })
        });
    </script>
</block>
