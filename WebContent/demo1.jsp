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
    <script type="text/javascript" src='js/outlook2.js'> </script>
    
    <script type="text/javascript" charset="utf-8"> </script>

</head>

<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div>
</noscript>
   
      
  <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    
   <div style="padding:20px;overflow:hidden;" id="home">
	
	<h1>已有数据集信息</h1>		
			
	<table id="dg" class="easyui-datagrid"  title="My Users" style="width:500px;height:150px"
		   toolbar="#toolbar" idField="id"
		   rownumbers="true" fitColumns="true" singleSelect="true">
	     <thead>
		   <tr>
			<th field="name" width="50" editor="{type:'validatebox',options:{required:true}}">名称</th>
			<th field="state" width="50" editor="{type:'validatebox',options:{required:true}}">状态</th>
			<th field="get" width="50" editor="text">获取</th>
			<th field="type" width="50" editor="{type:'validatebox',options:{validType:'email'}}">类别</th>
			<th field="source" width="50" editor="{type:'validatebox',options:{required:true}}">来源</th>
			<th field="niminghua" width="50" editor="{type:'validatebox',options:{required:true}}">匿名化</th>
			<th field="time" width="200" editor="{type:'validatebox',options:{required:true}}">发布时间</th>
		  </tr>
	    </thead>
	    <tbody>
		<tr>
			<td>TCP</td><td>end</td><td>master1</td><td>netflow</td><td>Tsinghua</td><td> </td><td>2015.11.10</td>
		</tr>
		<tr>
			<td>UDP</td><td>end</td><td>master2</td><td>netflow</td><td>Tsinghua</td><td> </td><td>2015.11.15</td>
		</tr>
		<tr>
			<td>ICMP</td><td>end</td><td>master3</td><td>netflow</td><td>Tsinghua</td><td> </td><td>2015.11.10</td>
		</tr>
		<tr>
			<td>Others</td><td>end</td><td>master4</td><td>netflow</td><td>Tsinghua</td><td> </td><td>2015.11.10</td>
		</tr>
	</tbody>
   </table>

   	<h1>Select Monitor Parametera</h1>		
			
	<table id="dg1" class="easyui-datagrid"  title="My Users" style="width:500px;height:150px"
		   toolbar="#toolbar" idField="id"
		   rownumbers="true" fitColumns="true" singleSelect="true">
	     <thead>
		   <tr>
			<th field="Type" width="60" editor="{type:'validatebox',options:{required:true}}">Type</th>
			<th field="ICMP" width="60" editor="{type:'validatebox',options:{required:true}}">ICMP</th>
			<th field="TCP" width="60" editor="text">TCP</th>
			<th field="UDP" width="60" editor="{type:'validatebox',options:{validType:'email'}}">UDP</th>
			<th field="Others" width="60" editor="{type:'validatebox',options:{required:true}}">Others</th>
			<th field="Total" width="60" editor="{type:'validatebox',options:{required:true}}">Total</th>
			<th field="Missed Flow" width="100" editor="{type:'validatebox',options:{required:true}}">Missed Flow</th>
		  </tr>
	    </thead>
	    <tbody>
		<tr>
			<td>Flows</td>
		</tr>
		<tr>
			<td>Packets</td>
		</tr>
		<tr>
			<td>Bytes</td>
		</tr>
	</tbody>
   </table>
    
    </div>
   </div>
   
</body>
</html>