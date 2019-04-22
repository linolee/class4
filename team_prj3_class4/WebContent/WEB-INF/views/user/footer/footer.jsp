<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
	String serverDomain = "http://211.63.89.152:8080";
	/* 바꿀 때 헤더도 바꿀 것 */
%>
			<div class="areaFix">
				<div id="footerTitle">copyright&copy; all right reserved class4</div>
				<div id="footerBtnDiv">
					<a href="<%= serverDomain %>/team_prj3_class4/user/terms.do">이용약관</a>
				</div>
			</div>
