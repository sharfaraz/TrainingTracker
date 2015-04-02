package com.att.ttt.action;

import com.opensymphony.xwork2.ActionSupport;

public class InitLoginAction  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg="";
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String execute() {
		
		return "success";
	}

}
