<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">${pageInfo_action}部门</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/part/add.do" class="btn btn-danger pull-right">增加部门</a>
            <strong>当前位置：</strong>部门管理&nbsp;>&nbsp;${pageInfo_action}部门
        </p>
    </div>
    <div class="dashboard-container">
        <!-- Container starts -->
        <div class="container">


            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="widget widget-info">

                        <div class="widget-body">
                            <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/part/add.do?method=${action_method}" class="form-horizontal bv-form">
                                <fieldset>
                                    <legend>${pageInfo_action}部门</legend><input type="hidden" name="action" value="${action_method}"/><input type="hidden" name="xid" value="${part_id}"/>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">名称</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="part_name" value="${part_name}" required/>
                                        </div>
                                    </div>

                                </fieldset>

                                <div class="form-group">
                                    <div class="col-lg-7 col-lg-offset-3">
                                        <button type="submit" class="btn btn-success">提交</button> <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/part.do">返回</button>
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
                                window.location.href='${pageContext.request.contextPath}/home/part/add.do?method=1';
                            }, function(){
                                window.location.href='${pageContext.request.contextPath}/home/part.do';
                            });
						}
					});
                   /* $(form).ajaxSubmit({
                        success:function(data){
                            console.log(data);
                            layer.confirm('{$pageInfo.actionTitle}成功', {
                                btn: ['继续录入','返回列表'] //按钮
                            }, function(){
                                window.location.href='/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/add';
                            }, function(){
                                window.location.href='/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}';
                            });
                            //$(e.currentTarget).get(0).reset();//resetForm();
                        }
                    });*/
                }
            })
        });
    </script>
</block>
