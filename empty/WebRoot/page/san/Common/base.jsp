<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<!DOCTYPE html><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,IE=11,IE=10,IE=9,IE=8,chrome=1" /> -->
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <title><block name="title">标题</block></title>
    <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/page/san/new/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/page/san/new/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/page/san/new/css/main.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/page/san/new/css/select2.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
        body {
            margin:0;
            padding:0;
        }
        .STYLE1 {
            color: #FFFFFF;
            font-weight: bold;
        }

        .STYLE3 {
            font-weight: bold;
        }


        .title_bm {
            width: 100%;
            height: 35px;
            font-size: 24px;
            margin: 30px 0 13px 0;
            padding: 0;
            text-align: center;
            font-family: "微软雅黑";
        }
        /*.row{margin:0;}*/
        .title_1{margin-bottom:10px}
        .title_1 .pull-right.btn{margin-right:10px;margin-top:7px}
        .form-inline .form-group{width:auto;display:inline}
        .form-control{width:auto;height:28px;display:inline}
        .btn.search{ background-image: url('${pageContext.request.contextPath}/img/chaxun.jpg');border:0px;width:62px;height:24px;margin-bottom:-6px}
        .container{width: 100%}
    </style>
	 <style>
.col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-10, .col-lg-11, .col-lg-12 {
    float: left;
  }
  .col-lg-12 {
    width: 100%;
  }
  .col-lg-11 {
    width: 91.66666667%;
  }
  .col-lg-10 {
    width: 83.33333333%;
  }
  .col-lg-9 {
    width: 75%;
  }
  .col-lg-8 {
    width: 66.66666667%;
  }
  .col-lg-7 {
    width: 58.33333333%;
  }
  .col-lg-6 {
    width: 50%;
  }
  .col-lg-5 {
    width: 41.66666667%;
  }
  .col-lg-4 {
    width: 33.33333333%;
  }
  .col-lg-3 {
    width: 25%;
  }
  .col-lg-2 {
    width: 16.66666667%;
  }
  .col-lg-1 {
    width: 8.33333333%;
  }
  .col-lg-offset-3{margin-left:25%}
   .form-horizontal .control-label {
    text-align: right;
    margin-bottom: 0;
    padding-top: 7px;
  }
    </style>
    <!-- HTML5 shiv and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
   
    <!--<script src="${pageContext.request.contextPath}/page/san/new/js/html5.min.js"></script>
    <script src="${pageContext.request.contextPath}/page/san/new/js/respond.min.js"></script>-->
    <![endif]-->
    <script src="${pageContext.request.contextPath}/page/san/new/js/jquery.js"></script>
    <script language="Javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath}/page/san/new/layer/layer.js"></script>
    <style>
        .table1 {
            width: 100%;
            border: 1px solid #B9CCD9;
            border-collapse: collapse;
        }

        .table1 tr td {
            border: 1px solid #B9CCD9;
        }

        .table1 tr th {
            border: 1px solid #B9CCD9;
            background-color: #F0F9FF;
            text-align: center;
        }

        .table1 tr {
            height: 35px;
            line-height: 35px;
        }
        .table2 {
        }
        .table2 tr td {
        	width: 10%;
        }
        .table2 tr th {
        	width: 10%;
        }
    </style>
</head>

<body>
<script type="text/javascript">
	function adjustHeight(iframeId, height) {
		if(navigator.userAgent.indexOf("Chrome") != -1) {
			return;
		}
		var iframes = window.parent.document.getElementsByTagName("iframe");
		var iframe;
		for(var i=0;i<iframes.length;i++) {
			if(iframes[i].name===iframeId) {
				iframe = iframes[i];
			}
		}
		
		try {
			var bHeight = iframe.contentWindow.document.body.scrollHeight;
			var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
			var xHeight = Math.max(bHeight, dHeight);
			iframe.height = xHeight;
		} catch(ex) {}
		
		//iframe.style.height = window.innerHeight + 70 + 'px';
		//iframe.style.height = height + "px";
	}
	adjustHeight('I2', 680);
</script>
<div class="hide"><iframe src="http://<?php echo $_SERVER["SERVER_NAME"]?>:{$JAVA_PORT}/web/checklogin.jsp"></iframe></div>
<block name="body">  </block>
<script src="${pageContext.request.contextPath}/page/san/new/js/bootstrap.min.js"></script>

<!-- Bootstrap Hover JS -->
<script src="${pageContext.request.contextPath}/page/san/new/js/bootstrap.hover.js"></script>
<script src="${pageContext.request.contextPath}/page/san/new/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/page/san/new/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/page/san/new/js/bsvalidator/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/page/san/new/js/jquery.form.js"></script>
<script>
    $(function(){
        $("input.date").datetimepicker({format: 'yyyy-mm-dd',minView:'month',autoclose:true,language: 'zh-CN'});
        $("select.select2").select2({language: "zh-CN"});
        $("button.back").on("click",function(){
            window.location.href=$(this).attr("data-url");
            return false;
        });
        $(".item-remove").on("click",function(){
            var that=this;
            layer.confirm("确认删除吗？该操作将不可逆操作?",function(){
                window.location.href=$(that).attr("href");
            },function(){
                layer.closeAll();
            })
            return false;
        });
        $(".item-submit").on("click",function(){
            var that=this;
            layer.confirm("确认提交吗？该操作将不可逆操作?",function(){
                window.location.href=$(that).attr("href");
                $.ajax({
                    url:$(that).attr("href"),
                    success:function(data){
                       window.location.reload();
                    }
                })
            },function(){
                layer.closeAll();
            })
            return false;
        });

    })
</script>
<block name="bottom">  </block>
</body>
</html>

