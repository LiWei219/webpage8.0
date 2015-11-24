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
    
    //设置修改密码窗口
    function openChange() {
           $('#c').window({
               title: '修改密码',
               width: 300,
               modal: true,
               shadow: true,
               closed: true,
               height: 235,
               resizable:false
           });
    }   
    </script>
</head>

<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div>
</noscript>
     <div region="center" split="true" border="false" class ="p-right" style="background:#fff;">
       <img alt="" src="images/bk1blue.jpg"/>
    </div>
    
    <!--用户修改密码界面设定-->
    <div id="r" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false"  style="width: 300px; height: 235px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <form action="changepsw.action" method="post">
                  <table cellpadding=3>                  
                    <tr>
                        <td>用户名：</td>    
                        <td><input id="txtUserName" type="text" name="userName" /></td>                 
                    </tr>                   
                    <tr>
                        <td>旧密码：</td>  
                        <td><input id="txtPass" type="Password" name="userPsw" /></td>                      
                    </tr> 
                    <tr>
                        <td>新密码：</td>  
                        <td><input id="txtnewPass" type="Password" name="newPsw" /></td>                      
                    </tr> 
                     <tr>
                        <td>确认密码：</td>  
                        <td><input id="txtrePass" type="Password" name="rePsw" /></td> 
                    </tr>     
                    <tr>                                      
                        <td> <input type="submit" value="确认"/></td> 
                    </tr>                     
                  </table>                                                                                                   
               </form>  
            </div> 
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
               <center><a  href="success.action" >返回主页</a> </center> 
            </div>           
        </div>
    </div>

</body>
</html>