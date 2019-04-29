<%@page import="kr.co.sist.admin.service.BlackListService"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%
	String blackDetailName=request.getParameter("userID");
	
	JSONObject blackData=null;
	
		//if(!"".equals(blackDetailName)){
		BlackListService bls=new BlackListService();
		blackData= bls.detailBlack(blackDetailName);
		//blackData=new JSONObject();
		//blackData.put("result",false);
		//blackData.put("resultData",null);
		//out.println( blackData.toJSONString() );
		//out.println("ASd");
		//}
		out.println(blackData.toJSONString()+"234234234");
%>