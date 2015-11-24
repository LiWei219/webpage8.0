<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My !!!!!!</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jQuery.easyui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	
	
	
	<script type="text/javascript" src="js/js-highcharts/highcharts.js"></script>
  	<script type="text/javascript" src="js/js-highcharts/modules/exporting.js"></script>
  	<script type="text/javascript" src="js/js-highcharts/themes/grid.js"></script>
	
	<script type="text/javascript">
	
	$.ajax({
  url: "data5.action",
  dataType: "json",
  success: function (jsonArray){
 	var i = 0;
 	//var time_stamp=[];
	var pcd=[];
var bcd=[];
var flowd=[];
   		while(i!=8)
   		{
   			pcd[i] = parseInt(jsonArray[0][i]);
		bcd[i] = parseInt(jsonArray[1][i]);
		flowd[i] = parseInt(jsonArray[2][i]);
i++;
		}

			
   		//	i++;
   		//}
   	
    var chart;	
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'area'
            },
            title: {
                text: 'example'
            },
            subtitle: {
                text: 'Source: ><'
            },
            xAxis: {
                categories: [
                    'CHINA',
                    'USA',
                    'UK',
                    'JAPAN',
                    'INDIA',
                    'FRANCE',
                    'GERMAN',
		'CANADA',
		'RUSSIA',
		'OTHER'
                ],
                tickmarkPlacement: 'on',
                title: {
                    enabled: false
                }
            },
            yAxis: {
                title: {
                    text: 'G'
                },
                labels: {
                    formatter: function() {
                        return this.value;
                    }
                }
            },
            tooltip: {
                formatter: function() {
                    return ''+
                        this.x +': '+ Highcharts.numberFormat(this.y, 0, ',') +' G';
                }
            },
            plotOptions: {
                area: {
                    stacking: 'normal',
                    lineColor: '#666666',
                    lineWidth: 1,
                    marker: {
                        lineWidth: 1,
                        lineColor: '#666666'
                    }
                }
            },
            series: [{
                name: 'PC',
                data: pcd
            }, {
                name: 'BC',
                data: bcd
            }, {
                name: 'FLOW',
                data: flowd
            }]
        });
    
});
},
    error: function(e){    //失败后回调
            alert(e);
        },

});
	
	
	
/*$.get("data.action",function(jsonArray){
/*   $.ajax({
		url:"data.action",//"data.action",
		dataType:"json",
		success:function(jsonArray){*/
 /*	var i = 0;
 	var check=0;
   	while(i!=jsonArray.length)
   	{
   		check=0;
   		times_stamp = jsonArray[i][0];
   		while(check!=1)
   		{
   			if(i%7==0)
   				dn = jsonArray[i][1];
   			else if(i%7==1)
   			{
   				ht=jsonArray[i][1];
   			}
   			else if(i%7==2)
   			{
   				ll=jsonArray[i][1];
   			}
   			else if(i%7==3)
   			{
   				nb=jsonArray[i][1];
   			}
   			else if(i%7==4)
   			{
   				sn=jsonArray[i][1];
   			}
   			else if(i%7==5)
   			{
   				ss=jsonArray[i][1];
   			}
   			else if(i%7==6)
   			{
   				un=jsonArray[i][1];
   				check=1;
   			}	
   		}
   	}
    var chart;	
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'area'
            },
            title: {
                text: 'example'
            },
            subtitle: {
                text: 'Source: ><'
            },
            xAxis: {
                categories: time_stamp,
                tickmarkPlacement: 'on',
                title: {
                    enabled: false
                }
            },
            yAxis: {
                title: {
                    text: 'G'
                },
                labels: {
                    formatter: function() {
                        return this.value;
                    }
                }
            },
            tooltip: {
                formatter: function() {
                    return ''+
                        this.x +': '+ Highcharts.numberFormat(this.y, 0, ',') +' G';
                }
            },
            plotOptions: {
                area: {
                    stacking: 'normal',
                    lineColor: '#666666',
                    lineWidth: 1,
                    marker: {
                        lineWidth: 1,
                        lineColor: '#666666'
                    }
                }
            },
            series: [{
                name: 'alld',
                data: alld
            }]
        });
    
});
/*},
    error: function(e){    //失败后回调
            alert(e);
        },*/
//});



	
	  </script>
  </head>
  
  <body>

    
    
    <div id='test'> </div>
<script>

</script>
    <div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
    
  </body>
</html>
