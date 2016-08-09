<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">人员${pageInfo_actionTitle}</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/person/add.do" class="btn btn-danger pull-right">增加人员</a>
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
                            <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/person/add.do?opt=save&method=${method}" class="form-horizontal bv-form">
                                <fieldset>
                                    <legend>人员${pageInfo_actionTitle}</legend>
                    
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">姓名</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="truename" value="${person_truename}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">身份证号</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="ssid" value="${person_ssid}" required pattern="(^[1-9]\d{16}[0-9xX]$)|(^[1-9]\d{14}$)"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">性别</label>
                                        <div class="col-lg-7">
                                            <select class="select2 form-control" name="sex" required>
                                                <option value="">请选择</option>
                                                	<c:if test="${sex == '男'}">
														<option value="男" selected="selected"}>男</option>
													</c:if>
													<c:if test="${sex != '男'}">
														<option value="男" }>男</option>
													</c:if>
													<c:if test="${sex == '女'}">
														<option value="女" selected="selected"}>女</option>
													</c:if>
													<c:if test="${sex != '女'}">
														<option value="女" }>女</option>
													</c:if>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">政治面貌</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="zzmm" value="${person_zzmm}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">文化程度</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="whcd" value="${person_whcd}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">所属村镇</label>
                                        <div class="col-lg-7">
                                            <select class="select2 form-control" name="country_id" required>
                                                <option value="">请选择</option>
                                                "${countrySelect}"
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">手机号码</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="phone" required value="${person_phone}" pattern="^1[0-9]{10}$"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="birthday">出生日期</label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control date" name="birthday" value="${person_birthday}" id="birthday"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">户籍地址</label>

                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="address" value="${person_address}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">其它信息</label>

                                        <div class="col-lg-7">
                                            <textarea class="form-control" name="remark" row="10">${person_remark}</textarea>
                                        </div>
                                    </div>

                                   <!-- <div class="form-group">
                                        <label class="col-lg-3 control-label">诚信记录 <div><a role="button" class="btn btn-primary btn-sm">增加</a></div></label>

                                        <div class="col-lg-7">
                                            <ul>
                                                <table class="table table-bordered table-striped">
                                                    <tr>
                                                        <th>名称</th>
                                                        <th>时间</th>
                                                        <th>得分</th>
                                                    </tr>
                                                    <tr>
                                                        <td>义务献血</td>
                                                        <td>2015-06-15</td>
                                                        <td>加10分</td>
                                                    </tr>
                                                    <tr>
                                                        <td>义务献血</td>
                                                        <td>2015-06-15</td>
                                                        <td>加10分</td>
                                                    </tr>
                                                    <tr>
                                                        <td>义务献血</td>
                                                        <td>2015-06-15</td>
                                                        <td>加10分</td>
                                                    </tr>
                                                </table>
                                            </ul>
                                        </div>
                                    </div>-->
                                    <div class="form-group">
                                        <div class="col-lg-7 col-lg-offset-3">
                                            <button type="submit" class="btn btn-success">提交</button> <button class="btn btn-default back" data-url="${pageContext.request.contextPath}/home/person.do">返回</button>
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
<block name="bottom">
    <script>
        $(function(){
            $('.bv-form').bootstrapValidator({
                submitHandler: function(validator, form, submitButton) {
                    $form=$(form);
                    $.ajax({
                        url:$form.attr("action"),
                        type:$form.attr("method"),
                        dataType:"json",
                        data:$form.serialize(),
                        success:function(data){
                        if (data[0].stat == false ) {
                                layer.confirm('${pageInfo_actionTitle}成功 是否继续提交', {
                                btn: ['提交', '返回'] //按钮
                                }, function(){
                                    $.ajax({
                                     url:'${pageContext.request.contextPath}/home/person/add.do?opt=save2',
                                        type:"post",
                                        cache:false,
                                    data: {id: data[0].id},
                                        success:function(){
                                            layer.confirm('提交成功', {
                                                btn: ['继续录入','返回列表'] //按钮
                                            }, function(){
                                                window.location.href='${pageContext.request.contextPath}/home/person/add.do?method=1';
                                            }, function(){
                                                window.location.href='${pageContext.request.contextPath}/home/person.do';
                                            });
                                        }
                                    })
                                }, function(){
                                    window.location.href='${pageContext.request.contextPath}/home/person.do';
                                    layer.closeAll();
                                });
                            }else{
                                layer.confirm('${pageInfo_actionTitle}成功', {
                                    btn: ['继续录入','返回列表'] //按钮
                                }, function(){
                                    window.location.href='${pageContext.request.contextPath}/home/person/add.do?method=1';
                                }, function(){
                                    window.location.href='${pageContext.request.contextPath}/home/person.do';
                                });
                            }
                        }
                    });
                    return false;
                }
            })
        });
    </script>
</block>
