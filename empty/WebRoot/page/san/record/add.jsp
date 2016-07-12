<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../Common/base.jsp" flush="true"/>
<block name="title">考核${pageInfo_action}</block>
<block name="body">
    <div class="title_1">
        <p class="position">
            <a role="button" href="${pageContext.request.contextPath}/home/record/add.do" class="btn btn-danger pull-right">增加考核</a>
            <strong>当前位置：</strong>考核管理&nbsp;>&nbsp;${pageInfo_action}考核
        </p>
    </div>
    <div class="dashboard-container">
        <div class="container">

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="widget widget-info">

                        <div class="widget-body">
                            <form id="defaultForm" method="post" action="${pageContext.request.contextPath}/home/record/add.do?opt=save" class="form-horizontal bv-form">
                                <fieldset>
                                    <legend>考核对象${pageInfo_action}</legend>
                                    <input type="hidden" name="action" value="${pageInfo_action}"/><input type="hidden" name="id" value="${record.id}"/>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">姓名/身份证号</label>

                                        <div class="col-lg-7">
                                            <select type="text" class="form-control" id="ssid" name="person_id" value="${record.person_id}" required></select>
                                        </div>
                                    </div>
                                    <div class="form-group" style="display:none">
                                        <label class="col-lg-3 control-label">人员基本信息</label>

                                        <div class="col-lg-7">
                                            <div id="person-info">加载中...</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">考核指标</label>

                                        <div class="col-lg-7">
                                            <select class="select2 form-control" id="target-id" name="target_id" required>
                                                <option value="">请选择</option>
                                                ${targetSelect}
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">考核分数</label>

                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="score" id="target-score" value="${record.score}" required pattern="^[\-0-9]+$"/>
                                        </div>
                                    </div>

                                </fieldset>

                                <div class="form-group">
                                    <div class="col-lg-7 col-lg-offset-3">
                                        <button type="submit" class="btn btn-success">提交</button>
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
        function formatRepo(repo) {
            if (repo.loading) return repo.text;
            var markup = "<div class='select2-result-repository clearfix'><b>" + repo.truename + "</b> " + "<i>身份证:  " + repo.ssid + " " + repo.countryName + "</i> </div>";
            return markup;
        }

        function formatRepoSelection(repo) {
            return repo.truename;
        }

        $("#ssid").select2({
            ajax: {
                placeholder: "输入身份证或名字查询",
                url: "${pageContext.request.contextPath}/home/record/add.do?opt=ajaxList",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        q: encodeURI( params.term), // search term
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    // parse the results into the format expected by Select2
                    // since we are using custom formatting functions we do not need to
                    // alter the remote JSON data, except to indicate that infinite
                    // scrolling can be used
                    params.page = params.page || 1;
                    return {
                        results: data,
                        /* pagination: {
                         more: (params.page * 30) < data.total_count
                         }*/
                    };
                },
                cache: true
            },
            language: "zh-CN",
            escapeMarkup: function (markup) {
                return markup;
            }, // let our custom formatter work
            // minimumInputLength: 1,
            templateResult: formatRepo, // omitted for brevity, see the source of this page
            templateSelection: formatRepoSelection // omitted for brevity, see the source of this page
        }).on("change", function () {
            //console.log($(this).val())
            $("#person-info").load("${pageContext.request.contextPath}/home/record/add.do?opt=infoAjax&id=" + $(this).val()).closest(".form-group").show();
        });

       
        
        $("#target-id").on("change", function () {
            var ss = $(this).find("option:selected").attr("target_score");
            if (!ss) {
                ss = "";
            }
            $("#target-score").val(ss);
        })
        
        $('.bv-form').bootstrapValidator({
            submitHandler: function (validator, form, submitButton) {
                $form=$(form);
                $.ajax({
                    url:$form.attr("action"),
                    type:$form.attr("method"),
                    dataType:"json",
                    data:$form.serialize(),
                    success: function (data) {
                        if (data.stat == 0) {
                            layer.confirm('${pageInfo_actionTitle}成功 是否继续提交', {
                                btn: ['提交', '返回'] //按钮
                            }, function () {
                                $.ajax({
                                    url: '${pageContext.request.contextPath}/home/record/save2',
                                    type: "get",
                                    cache: false,
                                    data: {id: data.id},
                                    success: function () {
                                        layer.confirm('提交成功', {
                                            btn: ['继续录入', '返回列表'] //按钮
                                        }, function () {
                                            window.location.href = '${pageContext.request.contextPath}/home/record/add.do';
                                        }, function () {
                                            window.location.href = '${pageContext.request.contextPath}/home/record.do';
                                        });
                                    }
                                })
                            }, function () {
                                window.location.href = '${pageContext.request.contextPath}/home/record/';
                                layer.closeAll();
                            });
                        } else {
                            layer.confirm('{$pageInfo_actionTitle}成功', {
                                btn: ['继续录入', '返回列表'] //按钮
                            }, function () {
                                window.location.href = '/${pageContext.request.contextPath}/home/record/add.do';
                            }, function () {
                                window.location.href = '/${pageContext.request.contextPath}/home/record.do';
                            });
                        }
                        return false;
                        //$(e.currentTarget).get(0).reset();//resetForm();
                    }
                });
            }
        })
    </script>
</block>
