package com.att.ttt.utility;

import java.util.Map;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside auth interceptor");		
		
		Map<String, Object> sessionMap = actionInvocation.getInvocationContext().getSession();
		
		String user = (String) sessionMap.get("email");
		System.out.println("user is:"+user);
		if(user == null || user.equals("")){
			return Action.LOGIN;
		}else{
			//Action action = (Action) actionInvocation.getAction();			
			return actionInvocation.invoke();
		}
	}

}
