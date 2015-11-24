
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">
    <meta charset="UTF-8">
    <title>测量大数据分析管理平台</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="js/themes/black/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jQuery.easyui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <script type="text/javascript" src='js/outlook2.js'> </script>
    
    <script type="text/javascript" charset="utf-8">
    
  //设置菜单列表
  
    var _menus = {"menus":[
   						{"menuid":"1","menuname":"首页",
   							"menus":[{"menuname":"首页","url":"demo1.jsp"}]
   						},{"menuid":"2","menuname":"数据集",
   							"menus":[{"menuname":"数据集","url":"demo.jsp"}]
   						},{"menuid":"3","menuname":"采集申请",
   							"menus":[{"menuname":"采集申请","url":"demo.jsp"}]
   						},{"menuid":"4","menuname":"应用",
   							"menus":[{"menuname":"应用","url":"demo.jsp"}]
   						},{"menuid":"5","menuname":"设置",
   							"menus":[{"menuname":"设置","url":"demo.jsp"}]
   						}
   				  ]}; 
           
    </script>

</head>

<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div>
</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 50px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 50px;color: #fff; font-family: Verdana,微软雅黑,黑体">
        <span style="float:right; padding-right:50px; font-size: 15px;" class="head">  
               ${userName }             
               <a href="change.action" >修改密码   </a> 
               <a href="quit.action">安全退出</a>
        </span>
        <span style="padding-left:10px; font-size: 20px; "> 测量大数据分析管理平台  </span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By 测量大数据小组</div>
    </div>
    <div region="west" split="true" style="width:150px;" id="west">  
	<!-- 导航内容 -->
        <div class="easyui-accordion" fit="true" border="true"> </div>
    </div>

    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="home" style="padding:20px;overflow:hidden;" id="home">
				
			<h1>欢迎进入测量大数据分析管理平台!</h1>

			</div>
		</div>
    </div>


</body>
</html>