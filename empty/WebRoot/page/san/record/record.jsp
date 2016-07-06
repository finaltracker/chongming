<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../Common/base.jsp" flush="true" />
<block name="title">考核管理</block>
<block name="body">
<div class="title_1">
	<p class="position">
		<a role="button"
			href="${pageContext.request.contextPath}/home/record/add.do?method=1"
			class="btn btn-danger pull-right">增加考核</a> <strong>当前位置：</strong>考核管理&nbsp;>&nbsp;考核列表
	</p>
</div>
<!-- Dashboard Container starts -->
<div class="dashboard-container">
	<div class="container">

		<div class="row">
			<div class="col-xs-12">
				<div class="widget">

					<div class="widget-body">
						<form action="${pageContext.request.contextPath}/home/record.do"
							method="post" class="form-inline">
							<button type="button"
								class="btn btn-primary pull-right form-action"
								data-action="form"
								data-url="${pageContext.request.contextPath}/home/record.do?opt=21">导出</button>
							<div class="form-group">
								<label class="control-label"> 姓名 </label> <input type="text"
									class="form-control" name="truename"
									value="${searchMap.truename}" /> <label class="control-label">
									身份证号 </label> <input type="text" class="form-control" name="ssid"
									value="${searchMap.ssid}" />
								<if condition="$userInfo.role_id neq 3"> <label
									class="control-label"> 所属乡镇 </label> <select
									class="select2 form-control" name="country_id">
									<option value="">请选择</option> ${countrySelect}
								</select> 
								</if>
								<label class="control-label"> 考核指标 </label> <select
									class="select2 form-control" name="target_id">
									<option value="">请选择</option> ${targetSelect}
								</select>&nbsp;&nbsp;
								<button type="submit" class="btn btn-primary">搜索</button>
								<button class="btn btn-default back"
									data-url="${pageContext.request.contextPath}/home/record.do">查看所有</button>
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
						<h4>
							<i class="fa fa-file-text-o"></i> 考核信息
						</h4>
					</div>
					<div class="widget-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped no-margin">
								<thead>
									<tr>
										<th>姓名</th>
										<th>身份证号</th>
										<th>所属乡镇</th>
										<th>考核指标</th>
										<th>分数</th>
										<th>考核人</th>
										<th>考核单位</th>
										<th>考核时间</th>
										<th>有效期</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="index" value="0" />
									<c:forEach var="item" items="${list}">
										<tr>
											<td>${item.truename}</td>
											<td>${item.ssid}</td>
											<td>${item.countryName}</td>
											<td>${item.target_name}</td>
											<td>${item.score}</td>
											<td>${item.author}</td>
											<td>${item.part_name}</td>
											<td>${item.pubdate}</td>
											<td>${item.dateline}</td>
											<td><if condition="$isadmin eq 1 or $item.stat eq 0">
												<!-- <a href="/{$Think.MODULE_NAME}/{$Think.CONTROLLER_NAME}/edit?id={$item.id}"><i class="fa fa-edit"></i> 修改</a>-->
												<a
													href="${pageContext.request.contextPath}/home/record.do?id=${item.id}"
													class="item-remove"><i class="fa fa-remove"></i> 删除</a> <if
													condition="$isadmin eq 0">
												<a
													href="${pageContext.request.contextPath}/home/record/save2?id=${item.id}"
													class="item-submit"><i class="fa fa-level-up"></i> 提交</a> </if>
												<else /> 已提交 </if></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
						${pageShow}
					</div>
				</div>
			</div>
		</div>
		<!-- Row Ends -->
	</div>
	<!-- Container ends -->

</div>
</block>
<block name="bottom"> <script>
	$(function() {
		$(".btn[data-action='form']").on(
				"click",
				function() {
					$(this).closest("form").attr("action",
							$(this).attr("data-url")).submit();
				})
	})
</script> </block>
