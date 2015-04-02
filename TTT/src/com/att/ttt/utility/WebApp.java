package com.att.ttt.utility;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebApp {

	
	private static WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());

	public static WebApplicationContext getContext() {
		return context;
	}

	public static void setContext(WebApplicationContext context) {
		WebApp.context = context;
	}

	

	
}
