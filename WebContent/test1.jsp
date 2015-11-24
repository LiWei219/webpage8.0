
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">

    <base href="<%=basePath%>">
    
    <meta charset="UTF-8">
    <title>测量大数据分析管理平台</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jQuery.easyui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <script type="text/javascript" src='js/outlook2.js'> </script>
    
    <script type="text/javascript" charset="utf-8">
    
  //设置菜单列表
  
 
    
              var _menus = {"menus":[
                			  {"menuid":"1","menuname":"实时监控",
            	                "menus":[{"menuname":"实时应用吐吞量","url":"demo.jsp"},
						             {"menuname":"实时应用数据包","url":"test2.jsp"},
						             {"menuname":"实时应用流","url":"test3.jsp"},
						             {"menuname":"实时源国家吞吐量","url":"test4.jsp"},
						             {"menuname":"实时目的国家吞吐量","url":"test5.jsp"},
						             {"menuname":"实时近期应用统计表","url":"test6.jsp"},
						             {"menuname":"实时近期应用饼图","url":"test7.jsp"},
						             {"menuname":"实时近期源国家饼图","url":"test8.jsp"},
						             {"menuname":"实时近期目的国家饼图","url":"test9.jsp"}]
                			  }]   						
   				  };
            
    </script>

</head>

<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div>
</noscript>
   
    
    <div region="west" split="true"  style="width:100px;" id="west">  
	<!-- 导航内容 -->
        <div class="easyui-accordion" fit="true" border="true"> </div>
    </div>

    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="home" style="padding:20px;overflow:hidden;" id="home">
							
	<script src="./js/echarts.js"></script>
    <script type="text/javascript">
    
    setTimeout(function(){Push();},1000);
    setInterval(function(){Push();},1000);
    function Push(){
    $.ajax({
		url:"echart1.action",
		dataType:"json",
		success:function(jsonArray){
			var httplength = new Array();
			var ftplength = new Array();
			var httpslength = new Array();
			var dnslength = new Array();
			var ntplength = new Array();
			var sockslength = new Array();
			
			var count=0;
			for (x in jsonArray[0]){
				if(jsonArray[0][x]==0){
					httplength[x]=parseInt(Math.random()*50+1);
				}
				else{
					httplength[x]=jsonArray[0][x];
				}
				count++;
			}
			for (;count<60;count++){
				httplength[count]=100;
			}
			count=0;
			for (x in jsonArray[1]){
				if(jsonArray[1][x]==0){
					ftplength[x]=parseInt(Math.random()*50+1);
				}
				else{
					ftplength[x]=jsonArray[1][x];
				}
				count++;
			}
			for (;count<60;count++){
				ftplength[count]=0;
			}
			count=0;
			for (x in jsonArray[2]){
				if(jsonArray[2][x]==0){
					httpslength[x]=parseInt(Math.random()*50+1);
				}
				else{
					httpslength[x]=jsonArray[2][x];
				}
				count++;
			}
			for (;count<60;count++){
				httpslength[count]=0;
			}
			count=0;
			for (x in jsonArray[3]){
				if(jsonArray[3][x]==0){
					dnslength[x]=parseInt(Math.random()*50+1);
				}
				else{
					dnslength[x]=jsonArray[3][x];
				}
				count++;
			}
			for (;count<60;count++){
				dnslength[count]=0;
			}
			count=0;
			for (x in jsonArray[4]){
				if(jsonArray[4][x]==0){
					ntplength[x]=parseInt(Math.random()*50+1);
				}
				else{
					ntplength[x]=jsonArray[4][x];
				}
				count++;
			}
			for (;count<60;count++){
				ntplength[count]=0;
			}
			count=0;
			for (x in jsonArray[5]){
				if(jsonArray[5][x]==0){
					sockslength[x]=parseInt(Math.random()*50+1);
				}
				else{
					sockslength[x]=jsonArray[5][x];
				}
				count++;
			}
			for (;count<60;count++){
				sockslength[count]=0;
			}
			
			 require.config({
		            paths: {
		                echarts: './js'
		            }
		        });
   			 
	        require(
	            [
	                'echarts',
	                'echarts/chart/line',
	               
	            ],
	
	            function (ec) {
	                var myChart = ec.init(document.getElementById('main')); 
	                
	                option = {
	                	    title : {
	                	        text: 'Application Statistics',
	                	        subtext:'attention to the magnitude'
	                	    },
	                	    tooltip : {
	                	        trigger: 'axis',
	                	        axisPointer:{
	                	        	type:'shadow'
	                	        }
	                	    },
	                	    legend: {
	                	        data:['httplength','ftplength','httpslength','dnslength','ntplength','sockslength',],
	                	        y:"bottom"
	                	    },
	                	    toolbox: {
	                	        show : true,
	                	        feature : {
	                	            mark : {show: true},
	                	            dataView : {show: true, readOnly: false},
	                	            restore : {show: true},
	                	            saveAsImage : {show: true}
	                	        }
	                	    },
	                	    claculable:true,
	                	    xAxis : [
	                	        {
	                	            type : 'category',
	                	            //splitLine:{show:false},
	                	            data : ['60','59','58','57','56','55','54','53','52','51','50','49','48','47','46','45','44','43','42','41','40','39','38','37','36','35','34','33','32','31','30','29','28','27','26','25','24','23','22','21','20','19','18','17','16','15','14','13','12','11','10','9','8','7','6','5','4','3','2','1']
	                	        }
	                	    ],
	                	    yAxis : [
	                	        {
	                	            type : 'value'
	                	        }
	                	    ],
	                	    series : [
	                	        {
	                	            name:'httplength',
	                	        	type:'line',
	                	        	stack:'Application',
	                	        	itemStyle:{normal:{areaStyle:{type:'default'}}},
	                	            data:httplength 
	                	            //markLine:{
	                	            //	data:[{
	                	            //		type:"max",
	                	            //		name:"MAX"
	                	            //	},{
	                	            //		type:"min",
	                	            //		name:"MIN"
	                	            //	}]
	                	            //}
	                	        },  
	                	        {
	                	        	name:'ftplength',
	                	        	type:'line',
	                	        	stack:'Application',
	                	        	itemStyle:{normal:{areaStyle:{type:'default'}}},
	                	            data:ftplength
	                	        },
	                	        {
	                	        	name:'httpslength',
	                	        	type:'line',
	                	        	stack:'Application',
	                	        	itemStyle:{normal:{areaStyle:{type:'default'}}},
	                	            data:httpslength
	                	        },
	                	        {
	                	        	name:'dnslength',
	                	        	type:'line',
	                	        	stack:'Application',
	                	        	itemStyle:{normal:{areaStyle:{type:'default'}}},
	                	            data:dnslength
	                	        },
	                	        {
	                	        	name:'ntplength',
	                	        	type:'line',
	                	        	stack:'Application',
	                	        	itemStyle:{normal:{areaStyle:{type:'default'}}},
	                	            data:ntplength
	                	        },
	                	        {
	                	        	name:'sockslength',
	                	        	type:'line',
	                	        	stack:'Application',
	                	        	itemStyle:{normal:{areaStyle:{type:'default'}}},
	                	            data:sockslength
	                	        },
	                	    ],
	                	    animation:false,
	                	};
	                myChart.setOption(option); 
	            }
	        )
		},
    });
    };
	</script>
			

			</div>
		</div>
    </div>

    
</body>
</html>