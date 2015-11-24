/*package hadoop;

import net.sf.json.*;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;

//import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.stringLiteralSequence_return;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
//import com.sun.corba.se.spi.orbutil.fsm.Action;
//import com.sun.org.apache.xml.internal.serialize.Printer;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.opensymphony.xwork2.ActionSupport;

public class data extends ActionSupport implements ServletRequestAware{
	static JobConf conf = new JobConf();
	
	public String execute() throws IOException{
	//	private HttpServletRequest request;
		HttpServletResponse response=ServletActionContext.getResponse();
		 String srcFilename = "hdfs://localhost:9000/user/hduser/application_result/state1/1438905600000/1438905600000/pc-m-00000";
		 Path inputPath = new Path(srcFilename);
		 FileSystem fs = FileSystem.get(URI.create(srcFilename), conf);
		 InputStream in = fs.open(inputPath);
		// InputStream in = new FileInputStream("/home/hduser/bc-m-00000");
		 
		 OutputStream out = new FileOutputStream("hdfs.txt");
	     InputStreamReader reader = new InputStreamReader(in);
	     BufferedReader buf = new BufferedReader(reader);
		  String str;
		  String[] datas;
	        ArrayList<String> TIME = new ArrayList<String>();
	        ArrayList<String> DNS = new ArrayList<String>();
	        ArrayList<String> HTTP = new ArrayList<String>();
	        ArrayList<String> NBNS = new ArrayList<String>();
	        ArrayList<String> RPC = new ArrayList<String>();
	        ArrayList<String> SNMP = new ArrayList<String>();
	        ArrayList<String> SSDP = new ArrayList<String>();
	        ArrayList<String> TELNET = new ArrayList<String>();
	        ArrayList<String> UNKNOW_TCP = new ArrayList<String>();
		  while ((str = buf.readLine()) != null) {
			  datas = str.split("\t");
			  TIME.add(datas[1]);
			  if(datas[2].equals("DNS")){
				  DNS.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  DNS.add("0");
			  
			  if(datas[2].equals("HTTP")){
				  HTTP.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  HTTP.add("0");
			  
			  if(datas[2].equals("NBNS")){
				  NBNS.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  NBNS.add("0");
			  
			  if(datas[2].equals("RPC")){
				  RPC.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  RPC.add("0");
			  
			  if(datas[2].equals("SNMP")){
				  SNMP.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  SNMP.add("0");
			  
			  if(datas[2].equals("SSDP")){
				  SSDP.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  SSDP.add("0");
			  
			  if(datas[2].equals("TELNET")){
				  TELNET.add(datas[3]);
				  if((str = buf.readLine()) == null)
					  break;
				  else
					  datas = str.split("\t");
			  }else
				  TELNET.add("0");
			  
			  if(datas[2].equals("UNKNOW TCP")){
				  UNKNOW_TCP.add(datas[3]);
			  }else
				  UNKNOW_TCP.add("0");
		  }
		  ArrayList<ArrayList<String>> merge = new ArrayList<ArrayList<String>>();

		  merge.add(TIME);
		  merge.add(DNS);
		  merge.add(HTTP);
		  merge.add(NBNS);
		  merge.add(RPC);
		  merge.add(SNMP);
		  merge.add(SSDP);
		  merge.add(TELNET);
		  merge.add(UNKNOW_TCP);
		  
		  JSONArray jsonArray = JSONArray.fromObject(merge);		       
		  PrintWriter pw=response.getWriter();
		  pw.print(jsonArray);
		  pw.flush();
		  
		  pw.close();
		  out.close();
		  in.close();
		  fs.close();
		  return SUCCESS;
	 }

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
}*/

package hadoop;

import net.sf.json.*;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;

//import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.stringLiteralSequence_return;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
//import com.sun.corba.se.spi.orbutil.fsm.Action;
//import com.sun.org.apache.xml.internal.serialize.Printer;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.opensymphony.xwork2.ActionSupport;

public class data3 extends ActionSupport implements ServletRequestAware{
	static JobConf conf = new JobConf();
	public static final String rootDir = "hdfs://10.10.20.24:9000/user/root";
	public static final int minute = 60*1000;
	public static final long hour = 60*minute;
	public static final long day = 24*hour;
	private static String resultDir;
	private static String resultName;
	private static String filter;
	private static int interval = 60;
	private static JSONArray jsonArray;
	
	/*先别去除注释，将各个方法执行一边看看那有没有结果过出来，然后去除注释之后可将jsonArray中的值发出
	 * get_result()中传入参数：
	 * 1.获取Application bits/m。结果为一个9＊1440的数组（1440是一天的分钟数），
	 * 第一行为时间，第二行为DNS，然后依次是HTTP，NBNS，RPC，SNMP，SSDP，TELNET，UNKNOW_TCP
	 * 2.获取Application packets/m，同上
	 * 3.获取Application flows/second，同上
	 * 4.获取Source country bits/m，结果为一个11＊1440的数组
	 * 第一行为时间，第二行为CHINA，然后依次是US，UK，JAPAN，INDIA，FRANCE，GERMANY，CANADA，RUSSIA，OTHERS
	 * 5.获取Latest day application tables和Latest day application pie charts。结果为一个3＊8的数组，第一行为PC数量，第二行为BC数量，第三行为FLOW数量
	 * 第一列为DNS，第二列为HTTP，然后依次是NBNS，RPC，SNMP，SSDP，TELNET，UNKNOW_TCP
	 * 6.获取Latest day source country pie charts。结果为一个长度为10的数组，保存结果为各个国家当天总流量BC
	 * 第一列为CHINA，然后依次是US，UK，JAPAN，INDIA，FRANCE，GERMANY，CANADA，RUSSIA，OTHERS
	 * 7.获取Latest day destination country pie charts。同上。
	 * */
	
	public static void main(String[] args) throws IOException{
		
		get_result(3);

		System.out.println(jsonArray);
	}
	
	public String execute() throws IOException{
		HttpServletRequest request;
		HttpServletResponse response=ServletActionContext.getResponse();
		
		get_result(3);
		/*ArrayList<ArrayList<Long>> merge = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> a = new ArrayList<Long>();
		a.add((long) 1);a.add((long) 2);a.add((long) 3);a.add((long) 4);a.add((long) 5);a.add((long) 6);a.add((long) 7);a.add((long) 8);
		 merge.add(a);
		 merge.add(a);
		 merge.add(a);
		jsonArray = JSONArray.fromObject(merge);*/
		PrintWriter pw=response.getWriter();
		pw.print(jsonArray);
		pw.flush();
		pw.close();
		return "success";// SUCCESS;
	}
	public static void get_result(int dataSource) throws IOException{
		switch(dataSource){
		case 1:
			resultDir = rootDir + "/application_result/state1";
			resultName = "bc";
			get_application_data();
			break;
		case 2:
			resultDir = rootDir + "/application_result/state1";
			resultName = "pc";
			get_application_data();
			break;
		case 3:
			resultDir = rootDir + "/application_result/state2";
			resultName = "fl";
			get_application_data();
			break;
		case 4:
			resultDir = rootDir + "/network_result/country_period";
			resultName = "ds";
			get_country_data();
			break;
		case 5:
			resultDir = rootDir + "/network_result/country_period";
			resultName = "sr";
			get_country_data();
			break;
		case 6:
			resultDir = rootDir + "/application_result";
			resultName = "pa";
			get_application_total();
			break;
		case 7:
			resultDir = rootDir + "/network_result/country_total";
			resultName = "pa";
			filter = "src";
			get_country_total();
			break;
		case 8:
			resultDir = rootDir + "/network_result/country_total";
			resultName = "pa";
			filter = "dst";
			get_country_total();
			break;
		default:
				break;
		}
	}
	
	public static void get_application_data() throws IOException{
		Date date = new Date();
		long time = date.getTime();
		time =  time-(time+8*hour)%(24*hour)- 48*hour;
		//TODO 修改时间
		 String Date = Long.toString(time);
		 System.out.println(resultDir+"\n"+resultName);
		resultDir = resultDir + "/" + Date + "/";
		Path inputPath = new Path(resultDir);
		 FileSystem fs = FileSystem.get(URI.create(resultDir), conf);
		 FileStatus statu = fs.getFileStatus(inputPath);
		 FileStatus[] status = fs.listStatus(inputPath);
		 Long[] TIME = new Long[24*60/interval];
		 Long[] DNS = new Long[24*60/interval];
		 Long[] HTTP = new Long[24*60/interval];
		 Long[] NBNS = new Long[24*60/interval];
		 Long[] RPC = new Long[24*60/interval];
		 Long[] SNMP = new Long[24*60/interval];
		 Long[] SSDP = new Long[24*60/interval];
		 Long[] TELNET = new Long[24*60/interval];
		 Long[] UNKNOW_TCP = new Long[24*60/interval];
		 for(int i = 0; i < 24*60/interval; i ++){
			 TIME[i] = time + i*minute*interval;
			 DNS[i] = (long) 0;
			 HTTP[i] = (long) 0;
			 NBNS[i] = (long) 0;
			 RPC[i] = (long) 0;
			 SNMP[i] = (long) 0;
			 SSDP[i] = (long) 0;
			 TELNET[i] = (long) 0;
			 UNKNOW_TCP[i] = (long) 0;
		 }
		 for(FileStatus curfs:status){
			 System.out.println( curfs.getPath().getParent().getName()+resultName);
			 if( curfs.getPath().getName().substring(0, 2).equals(resultName)){
				 System.out.println("2");
				 InputStream in = fs.open(curfs.getPath());
				 InputStreamReader reader = new InputStreamReader(in);
			     BufferedReader buf = new BufferedReader(reader);
			     String str;
			     String[] datas;
			     int T;
			     
			     while ((str = buf.readLine()) != null) {
			    	 datas = str.split("\t");
			    	 T = (int)(Long.parseLong(datas[1])*1000-time)/minute/interval;
			    	 System.out.println(T);
			    	 if(datas[2].equals("DNS")){
			    		 DNS[T] =  DNS[T] + Long.parseLong(datas[3]);
			    	 }else if(datas[2].equals("HTTP")){
			    		 HTTP[T] = HTTP[T]+ Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("NBNS")){
			    		 NBNS[T] =NBNS[T] + Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("RPC")){
			    		 RPC[T] =RPC[T] + Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("SNMP")){
			    		 SNMP[T] =  SNMP[T]+Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("SSDP")){
			    		 SSDP[T] = SSDP[T] +Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("TELNET")){
			    		 TELNET[T] = TELNET[T] +Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("UNKNOW")){
			    		 UNKNOW_TCP[T] = UNKNOW_TCP[T] + Long.parseLong(datas[3]);
			    		 
			    	 }
			     }
			 }
		 }
		 ArrayList<ArrayList<Long>> merge = new ArrayList<ArrayList<Long>>();
		 merge.add(new ArrayList<Long>(Arrays.asList(TIME)));
		 merge.add(new ArrayList<Long>(Arrays.asList(DNS)));
		 merge.add(new ArrayList<Long>(Arrays.asList(HTTP)));
		  merge.add(new ArrayList<Long>(Arrays.asList(NBNS)));
		  merge.add(new ArrayList<Long>(Arrays.asList(RPC)));
		  merge.add(new ArrayList<Long>(Arrays.asList(SNMP)));
		  merge.add(new ArrayList<Long>(Arrays.asList(SSDP)));
		  merge.add(new ArrayList<Long>(Arrays.asList(TELNET)));
		  merge.add(new ArrayList<Long>(Arrays.asList(UNKNOW_TCP)));
		  
		  jsonArray = JSONArray.fromObject(merge);
		  
		  System.out.println(jsonArray);
	}
	
	public static void get_country_data() throws IOException{
		Date date = new Date();
		long time = date.getTime();
		time =  time-(time+8*hour)%(24*hour)-24*hour;
		//TODO 修改时间
		 String Date =Long.toString(time);
		 System.out.println(time);
		resultDir = resultDir + "/" + Date + "/";
		Path inputPath = new Path(resultDir);
		 FileSystem fs = FileSystem.get(URI.create(resultDir), conf);
		 FileStatus statu = fs.getFileStatus(inputPath);
		 FileStatus[] status = fs.listStatus(inputPath);

		 Long[] TIME = new Long[24*60/interval];
		 Long[] CHINA = new Long[24*60/interval];
		 Long[] RUSSIA = new Long[24*60/interval];
		 Long[] CANADA = new Long[24*60/interval];
		 Long[] INDIA = new Long[24*60/interval];
		 Long[] GERMANY = new Long[24*60/interval];
		 Long[] JAPAN = new Long[24*60/interval];
		 Long[] US = new Long[24*60/interval];
		 Long[] UK = new Long[24*60/interval];
		 Long[] FRANCE = new Long[24*60/interval];
		 Long[] OTHERS = new Long[24*60/interval];
		 for(int i = 0; i < 24*60/interval; i ++){
			 TIME[i] = time + i*minute*interval;
			 CHINA[i] = (long) 0;
			 RUSSIA[i] = (long) 0;
			 CANADA[i] = (long) 0;
			 INDIA[i] = (long) 0;
			 GERMANY[i] = (long) 0;
			 JAPAN[i] = (long) 0;
			 US[i] = (long) 0;
			 UK[i] = (long) 0;
			 FRANCE[i] = (long) 0;
			 OTHERS[i] = (long) 0;
		 }
		 for(FileStatus curfs:status){
			 System.out.println( curfs.getPath().getName()+resultName);
			 if( curfs.getPath().getName().substring(0, 2).equals(resultName)){
				 System.out.println("2");
				 InputStream in = fs.open(curfs.getPath());
				 InputStreamReader reader = new InputStreamReader(in);
			     BufferedReader buf = new BufferedReader(reader);
			     String str;
			     String[] datas;
			     int T;
			     while ((str = buf.readLine()) != null) {
			    	 datas = str.split("\t");
			    	 T = (int)(Long.parseLong(datas[1])*1000-time)/minute/interval;
			    	 System.out.println(T);
			    	 if(datas[2].equals("CHINA")){
			    		 CHINA[T] =  CHINA[T] + Long.parseLong(datas[3]);
			    	 }else if(datas[2].equals("RUSSIA")){
			    		 RUSSIA[T] = RUSSIA[T]+ Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("CANADA")){
			    		 CANADA[T] =CANADA[T] + Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("INDIA")){
			    		 INDIA[T] =INDIA[T] + Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("GERMANY")){
			    		 GERMANY[T] =  GERMANY[T]+Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("JAPAN")){
			    		 JAPAN[T] = JAPAN[T] +Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("US")){
			    		 US[T] = US[T] +Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("UK")){
			    		 UK[T] = UK[T] + Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("FRANCE")){
			    		 FRANCE[T] = FRANCE[T] + Long.parseLong(datas[3]);
			    		 
			    	 }else if(datas[2].equals("OTHERS")){
			    		 OTHERS[T] = OTHERS[T] + Long.parseLong(datas[3]);
			    		 
			    	 }
			     }
			 }
		 }
		 ArrayList<ArrayList<Long>> merge = new ArrayList<ArrayList<Long>>();
		 merge.add(new ArrayList<Long>(Arrays.asList(TIME)));
		 merge.add(new ArrayList<Long>(Arrays.asList(CHINA)));
		 merge.add(new ArrayList<Long>(Arrays.asList(US)));
		  merge.add(new ArrayList<Long>(Arrays.asList(UK)));
		  merge.add(new ArrayList<Long>(Arrays.asList(JAPAN)));
		  merge.add(new ArrayList<Long>(Arrays.asList(INDIA)));
		  merge.add(new ArrayList<Long>(Arrays.asList(FRANCE)));
		  merge.add(new ArrayList<Long>(Arrays.asList(GERMANY)));
		  merge.add(new ArrayList<Long>(Arrays.asList(CANADA)));
		  merge.add(new ArrayList<Long>(Arrays.asList(RUSSIA)));
		  merge.add(new ArrayList<Long>(Arrays.asList(OTHERS)));
		  
		  jsonArray = JSONArray.fromObject(merge);
		  System.out.println( JSONArray.fromObject(CHINA));
		  System.out.println( JSONArray.fromObject(US));
		  System.out.println( JSONArray.fromObject(UK));
		  System.out.println( JSONArray.fromObject(JAPAN));
		  System.out.println( JSONArray.fromObject(OTHERS));
	}	
	
	public static void get_application_total() throws IOException{
		Date date = new Date();
		long time = date.getTime();
		time =  time-(time+8*hour)%(24*hour)-24*hour;
		//TODO 修改时间
		 String Date =Long.toString(time);
		 System.out.println(time);
		
		 Long[] PC = new Long[8];
		 Long[] BC = new Long[8];
		 Long[] FLOW = new Long[8];
		 for(int i = 0; i < 8; i ++){
			 BC[i] = (long) 0;
			 FLOW[i] = (long) 0;
			 PC[i] = (long) 0;
		 }
		 
		Path inputPath = new Path(resultDir + "/state2/"+ Date + "/");
		 FileSystem fs = FileSystem.get(URI.create(resultDir +  "/state2/" + Date + "/"), conf);
		 FileStatus statu = fs.getFileStatus(inputPath);
		 FileStatus[] status = fs.listStatus(inputPath);
		 for(FileStatus curfs:status){
			 if( curfs.getPath().getName().substring(0, 2).equals("pc")){
				 InputStream in = fs.open(curfs.getPath());
				 InputStreamReader reader = new InputStreamReader(in);
			     BufferedReader buf = new BufferedReader(reader);
			     String str;
			     String[] datas;
			     int T;
			     while ((str = buf.readLine()) != null) {
			    	 datas = str.split("\t");
			    	 if(datas[1].equals("DNS")){
			    		 PC[0] =  PC[0] + Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("HTTP")){
			    		 PC[1] = PC[1]+ Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("NBNS")){
			    		 PC[2] =PC[2] + Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("RPC")){
			    		 PC[3] =PC[3] + Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("SNMP")){
			    		 PC[4] =  PC[4]+Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("SSDP")){
			    		 PC[5] = PC[5] +Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("TELNET")){
			    		 PC[6] = PC[6] +Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("UNKNOW_TCP")){
			    		 PC[7] = PC[7] + Long.parseLong(datas[2]);
			    		 
			    	 }
			     }
			 }
			 if( curfs.getPath().getName().substring(0, 2).equals("bc")){
				 InputStream in = fs.open(curfs.getPath());
				 InputStreamReader reader = new InputStreamReader(in);
			     BufferedReader buf = new BufferedReader(reader);
			     String str;
			     String[] datas;
			     int T;
			     while ((str = buf.readLine()) != null) {
			    	 datas = str.split("\t");
			    	 if(datas[1].equals("DNS")){
			    		 BC[0] =  BC[0] + Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("HTTP")){
			    		 BC[1] = BC[1]+ Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("NBNS")){
			    		 BC[2] =BC[2] + Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("RPC")){
			    		 BC[3] =BC[3] + Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("SNMP")){
			    		 BC[4] =  BC[4]+Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("SSDP")){
			    		 BC[5] = BC[5] +Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("TELNET")){
			    		 BC[6] = BC[6] +Long.parseLong(datas[2]);
			    		 
			    	 }else if(datas[1].equals("UNKNOW_TCP")){
			    		 BC[7] = BC[7] + Long.parseLong(datas[2]);
			    		 
			    	 }
			     }
			 }
		 }
		inputPath = new Path(resultDir + "/state3/"+ Date + "/");
		fs = FileSystem.get(URI.create(resultDir +  "/state3/" + Date + "/"), conf);
		statu = fs.getFileStatus(inputPath);
		status = fs.listStatus(inputPath);
		 for(FileStatus curfs:status){
				 if( curfs.getPath().getName().substring(0, 2).equals("pa")){
					 InputStream in = fs.open(curfs.getPath());
					 InputStreamReader reader = new InputStreamReader(in);
				     BufferedReader buf = new BufferedReader(reader);
				     String str;
				     String[] datas;
				     int T;
				     while ((str = buf.readLine()) != null) {
				    	 datas = str.split("\t");
				    	 if(datas[0].equals("DNS")){
				    		 FLOW[0] =  FLOW[0] + Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("HTTP")){
				    		 FLOW[1] = FLOW[1]+ Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("NBNS")){
				    		 FLOW[2] =FLOW[2] + Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("RPC")){
				    		 FLOW[3] =FLOW[3] + Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("SNMP")){
				    		 FLOW[4] =  FLOW[4]+Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("SSDP")){
				    		 FLOW[5] = FLOW[5] +Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("TELNET")){
				    		 FLOW[6] = FLOW[6] +Long.parseLong(datas[1]);
				    		 
				    	 }else if(datas[0].equals("UNKNOW_TCP")){
				    		 FLOW[7] = FLOW[7] + Long.parseLong(datas[1]);
				    		 
				    	 }
				     }
			   }
		 }
		 ArrayList<ArrayList<Long>> merge = new ArrayList<ArrayList<Long>>();
		 merge.add(new ArrayList<Long>(Arrays.asList(BC)));
		 merge.add(new ArrayList<Long>(Arrays.asList(PC)));
		 merge.add(new ArrayList<Long>(Arrays.asList(FLOW)));

		  jsonArray = JSONArray.fromObject(merge);
		
		  System.out.println( JSONArray.fromObject(BC));
		  System.out.println( JSONArray.fromObject(PC));
		  System.out.println( JSONArray.fromObject(FLOW));
	}	
	
	public static void get_country_total() throws IOException{
		Date date = new Date();
		long time = date.getTime();
		time =  time-(time+8*hour)%(24*hour)-24*hour;
		//TODO 修改时间
		 String Date =Long.toString(time);
		 System.out.println(time);

		 Long[] BC = new Long[10];
		 for(int i = 0; i < 10; i ++){
			 BC[i] = (long) 0;
		 }
		resultDir = resultDir + "/" + Date + "/";
		Path inputPath = new Path(resultDir);
		 FileSystem fs = FileSystem.get(URI.create(resultDir), conf);
		 FileStatus statu = fs.getFileStatus(inputPath);
		 FileStatus[] status = fs.listStatus(inputPath);
		 for(FileStatus curfs:status){
			 System.out.println( curfs.getPath().getName()+resultName);
			 if( curfs.getPath().getName().substring(0, 2).equals(resultName)){
				 System.out.println("2");
				 InputStream in = fs.open(curfs.getPath());
				 InputStreamReader reader = new InputStreamReader(in);
			     BufferedReader buf = new BufferedReader(reader);
			     String str;
			     String[] datas;
			     int T;
			     while ((str = buf.readLine()) != null) {
			    	 datas = str.split("\t");
			    	 if(datas[0].equals(filter)){
			    		 if(datas[1].equals("CHINA")){
				    		 BC[0] =  BC[0] + Long.parseLong(datas[2]);
				    	 }else if(datas[1].equals("US")){
				    		 BC[1] =  BC[1] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("UK")){
				    		 BC[2] =  BC[2] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("JAPAN")){
				    		 BC[3] =  BC[3] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("INDIA")){
				    		 BC[4] =  BC[4] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("FRANCE")){
				    		 BC[5] =  BC[5] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("GERMANY")){
				    		 BC[6] =  BC[6] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("CANADA")){
				    		 BC[7] =  BC[7] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("RUSSIA")){
				    		 BC[8] =  BC[8] + Long.parseLong(datas[2]);
				    		 
				    	 }else if(datas[1].equals("OTHERS")){
				    		 BC[9] =  BC[9] + Long.parseLong(datas[2]);
				    		 
				    	 }
			    	 }
			     }
			 }
		 }
		  
		  jsonArray = JSONArray.fromObject(BC);
		  System.out.println( JSONArray.fromObject(BC));
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
}

