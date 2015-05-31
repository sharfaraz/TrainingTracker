package com.att.ttt.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Application;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Manager_App;
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionContext;



public class ManagerApplicationMapAction {
	
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;	
	List<String> apps = new ArrayList<String>();
	
	public List<String> getApps() {
		return apps;
	}

	public void setApps(List<String> apps) {
		this.apps = apps;
	}

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

	public String mapManagerApp(File file){
		
		try{
			ServletContext ctx = ServletActionContext.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils
					.getWebApplicationContext(ctx);
			
			TrainingTrackerDao dao=(TrainingTrackerDao)context.getBean("TrainingTrackerDao"); 
			Application appln=(Application)context.getBean("Application");
			Manager_App manApp = (Manager_App) context.getBean("Manager_App");
			
			System.out.println("File: " + file);
			
			OPCPackage pkg = OPCPackage.open(file);
        	XSSFWorkbook wb = new XSSFWorkbook(pkg);
        	
            //XSSFWorkbook wb = new XSSFWorkbook(file1);
            
            System.out.println ("workbook");
 
            // Get the first sheet from workbook 
            XSSFSheet sheet1 = (XSSFSheet) wb.getSheetAt(0);
 
            XSSFRow row;
            
            for(int i=1; i<=sheet1.getLastRowNum(); i++) {
            	 row = sheet1.getRow(i);
            	 appln.setApplnName(String.valueOf(row.getCell(10)));
            	 System.out.println(appln.getApplnName());
            	 dao.saveApplication(appln);
            	 manApp.setApplnId(appln.getApplnId());
            	 manApp.setManagerId(String.valueOf(row.getCell(15)));
            	 System.out.println("manApp:"+manApp.getApplnId()+" "+manApp.getApplnId());
            	 dao.saveManagerApp(manApp);
            }

		}
		catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}

		return "success";
	}
	
	public String execute() {
		String res;
		System.out.println("File received: "+ uploadFile);
		System.out.println("File name: "+ uploadFileFileName);	
		res = mapManagerApp(uploadFile);
		return res;
	}
	
	public String applicationsManaged() {
		
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");
		
		List<Employee> emp = dao.getUserPresenceList(emailId);
		
		apps = dao.getAppsManaged(emp.get(0));
		
		return "success";
	}

}
