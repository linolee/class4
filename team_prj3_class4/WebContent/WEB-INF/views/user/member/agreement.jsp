<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>약관동의</h3>
<div class="areaFix">
	<div id="agreementDiv">
		<ul id="agreementList">
			<li class="agreementSubject">약관1<br>
			<textarea rows="20" readonly="readonly">
						</textarea></li>
			<li><input type="checkbox">약관에 동의합니다.</li>
			<li class="agreementSubject">약관2<br>
			<textarea rows="20" cols="200" readonly="readonly">
							약관내용 어쩌고저쩌고
						</textarea>
			</li>
			<li><input type="checkbox">약관에 동의합니다.</li>

		</ul>
		<input type="button" id="agreementBtn" value="다음단계">

	</div>
</div>