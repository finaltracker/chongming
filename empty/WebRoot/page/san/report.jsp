<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Common/base.jsp" flush="true"/>
  
<block name="title">首页</block>
<block name="body">
    <!-- Dashboard Container starts -->
    <div class="dashboard-container">
        <!-- Container starts -->
        <div class="container">
           
            <!-- Row Starts -->
            <div class="row">
                <div class="col-lg-4">
                    <div class="widget widget-info">
                        <div class="widget-header">
                            <h4><i class="fa fa-square-o"></i> ${part_name}诚信等级统计图表</h4>
                        </div>
                        <div class="widget-body" style="position: relative">
                            <div id="donut-chart" class="chart-height"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="widget widget-info widget-stack">
                        <div class="widget-header">
                            <h4><i class="fa fa-calendar"></i> ${part_name}诚信人数波动图</h4>
                        </div>
                        <div class="widget-body">
                            <div id="line-chart" class="chart-height"></div>
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
    <!-- Sparkline graphs -->

    <script src="${pageContext.request.contextPath}/page/san/new/js/echarts.js"></script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var donut_chart = echarts.init(document.getElementById('donut-chart'));
        option = {
                    title : {
                        // text: '崇明县诚信等级统计图表',
                        subtext: '',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{b}<br/> {c} ({d}%)"
                    },
                    /*legend: {
                     orient : 'vertical',
                     x : 'left',
                     data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
                     },*/
                    calculable : false,
                    series : [
                        {
                            name:'',
                            type:'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                            <c:forEach var="item" items="${Level_List}">
                            
                             { name: '${item.levelName }' ,  value: ${item.howmanyPeople} ,keyId:${item.levelId}  },
                            </c:forEach>
                                
                            
        					]
        				}
        			]
        		};
        donut_chart.setOption(option);
        donut_chart.on("click", function(e){
            window.location.href='${pageContext.request.contextPath}/home/statistics.do?level_id='+e.data.keyId;
        });


        var line_chart = echarts.init(document.getElementById('line-chart'));
        option = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['人数']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false},
                    dataView : {show: false, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: false},
                    saveAsImage : {show: false}
                }
            },
            calculable : false,
            xAxis : [
                {
                    type : 'category',
                    data : [
                    
                    	<c:forEach var="item" items="${Level_List}">       
                    	'${item.levelName }', 
                   		</c:forEach>
                    ]
                }         
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'级以上人数',
                    type:'bar',
                    data:[
                    
                    	<c:forEach var="item" items="${Level_List}">       
                    		${item.howmanyPeople}, 
                   		</c:forEach>
                   	],
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };



        // 为echarts对象加载数据
        line_chart.setOption(option);
        line_chart.on("click", function(e){
            // console.log('test');

        });
    </script>



</block>
