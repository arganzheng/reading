<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.support.XmlWebApplicationContext"%>

<%
	XmlWebApplicationContext context = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(application);
	try{
		if(!context.isActive()){
			context.refresh();
		}
		out.write("ok");
	}catch(Exception e){
		out.write("failure");
		throw e;
	}
%>