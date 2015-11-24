<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">
    <meta charset="UTF-8">
    <title>测量大数据分析管理平台</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jQuery.easyui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    
    <script type="text/javascript" charset="utf-8">
    
    //设置菜单列表
    var _menus = {"menus":[
   						{"menuid":"1","icon":"icon-ok","menuname":"首页",
   							"menus":[]
   						},{"menuid":"8","icon":"icon-ok","menuname":"历史查询",
   							"menus":[]
   						},{"menuid":"56","icon":"icon-ok","menuname":"实时监控",
   							"menus":[]
   						},{"menuid":"28","icon":"icon-ok","menuname":"个性化",
   							"menus":[]
   						}
   				  ]};
  
   
        $(function()
        {
        	 $('#loginOut').window('open');   
        	
                $.messager.confirm('系统提示', '您确定要退出本次登陆吗？', function(r) 
                {
                    if (r)
                    {
                        location.href = '/webpage1.0/index.jsp';
                    }
                    else
                    {
                    	 location.href = '/webpage1.0/success.action';
                    }
                    	                  
                });		
        	
        	InitLeftMenu();
        })
       		
      //初始化左侧
        function InitLeftMenu() {

            $(".easyui-accordion").empty();
            var menulist = "";
           
            $.each(_menus.menus, function(i, n) {
                menulist += '<div title="'+n.menuname+'"  icon="'+n.icon+'" style="overflow:auto;">';
        		menulist += '<ul>';
                $.each(n.menus, function(j, o) {
        			menulist += '<li><div><a target="mainFrame" href="' + o.url + '" ><span class="icon '+o.icon+'" ></span>' + o.menuname + '</a></div></li> ';
                })
                menulist += '</ul></div>';
            })

        	$(".easyui-accordion").append(menulist);
        	
        	$('.easyui-accordion li a').click(function(){
        		var tabTitle = $(this).text();
        		var url = $(this).attr("href");
        		addTab(tabTitle,url);
        		$('.easyui-accordion li div').removeClass("selected");
        		$(this).parent().addClass("selected");
        	}).hover(function(){
        		$(this).parent().addClass("hover");
        	},function(){
        		$(this).parent().removeClass("hover");
        	});

        	$(".easyui-accordion").accordion();
        }

        function createFrame(url)
        {
        	var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
        	return s;
        }


        //弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
        function msgShow(title, msgString, msgType) {
        	$.messager.alert(title, msgString, msgType);
        }
             
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
    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">  
	<!-- 导航内容 -->
        <div class="easyui-accordion" fit="true" border="false"> </div>
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