package com;

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

//import java.io.BufferedInputStream;  
//import java.io.FileReader;

//import java.util.HashMap;
//import java.util.Map;

import net.sf.json.*;

//import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.stringLiteralSequence_return;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
//import com.sun.corba.se.spi.orbutil.fsm.Action;
//import com.sun.org.apache.xml.internal.serialize.Printer;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//import java.util.Iterator;
//import java.util.Set;
 
import redis.clients.jedis.Jedis;

public class echart1 extends ActionSupport implements ServletRequestAware{
	       
	public String execute() throws IOException {
		
		//private HttpServletRequest request;
		HttpServletResponse response=ServletActionContext.getResponse();
		
		String host = "166.111.143.245";
		int port = 6379;
		Jedis jedis = new Jedis(host, port);
        
        String value1 = jedis.get("httplength");
        String value2 = jedis.get("ftplength");
        String value3 = jedis.get("httpslength");
        String value4 = jedis.get("dnslength");
        String value5 = jedis.get("ntplength");
        String value6 = jedis.get("sockslength");
        
        String[] data1 = value1.split("/");String[] data2 = value2.split("/");
        String[] data3 = value3.split("/");String[] data4 = value4.split("/");
        String[] data5 = value5.split("/");String[] data6 = value6.split("/");
        
        ArrayList httplength = new ArrayList();
        ArrayList ftplength = new ArrayList();
        ArrayList httpslength = new ArrayList();
        ArrayList dnslength = new ArrayList();
        ArrayList ntplength = new ArrayList();
        ArrayList sockslength = new ArrayList();
        
        for(int x=1;x<data1.length;x++){
        	httplength.add(data1[x]);
        }
        for(int x=1;x<data2.length;x++){
        	ftplength.add(data2[x]);
        }
        for(int x=1;x<data3.length;x++){
        	httpslength.add(data3[x]);
        }
        for(int x=1;x<data4.length;x++){
        	dnslength.add(data4[x]);
        }
        for(int x=1;x<data5.length;x++){
        	ntplength.add(data5[x]);
        }
        for(int x=1;x<data6.length;x++){
        	sockslength.add(data6[x]);
        }
        
        ArrayList merge = new ArrayList();  
        merge.add(httplength);  
        merge.add(ftplength);
        merge.add(httpslength);
        merge.add(dnslength);
        merge.add(ntplength);
        merge.add(sockslength);
      
		JSONArray jsonArray = JSONArray.fromObject(merge);		       
		//System.out.println(jsonArray);
		PrintWriter pw=response.getWriter();
		pw.print(jsonArray);
		pw.flush();
		pw.close();
			
		return "success";
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
