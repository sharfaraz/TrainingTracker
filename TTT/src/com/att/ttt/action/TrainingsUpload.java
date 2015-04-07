package com.att.ttt.action;

import java.io.File;



import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.manager.TrainingsManager;
import com.opensymphony.xwork2.ActionSupport;

public class TrainingsUpload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  TrainingsManager manager;
	
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;	

	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
 
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
 
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	
	public TrainingsManager getTrainigsManager() {
		return manager;
	}
	
	@Autowired
	public void setTrainingsManager(TrainingsManager manager) {
		this.manager = manager;
	}
	public String execute() {
		String res;
		System.out.println("File received: "+ uploadFile);
		System.out.println("File name: "+ uploadFileFileName);
		manager.uploadTrainings(uploadFile);
		res = "success";
		return res;
	}
}
