package com.att.ttt.action;

import java.io.File;



import java.util.ArrayList;
import java.util.List;

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
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionSupport;

public class TrainingsUpload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	public String uploadTrainings(File file) {
		// TODO Auto-generated method stub
		try{
            // Creating Input Stream 
        	//InputStream file1 = new FileInputStream(file);
			ServletContext ctx = ServletActionContext.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils
					.getWebApplicationContext(ctx);
			
			TrainingTrackerDao trainingOperation=(TrainingTrackerDao)context.getBean("TrainingTrackerDao"); 
			Trainings training=(Trainings)context.getBean("Trainings");
			Emp_Trng empTrng = (Emp_Trng) context.getBean("Emp_Trng");
			List<String> levels = new ArrayList<String>();
			levels.add(TTConstants.ACCOUNT);
			levels.add(TTConstants.APPLICATION);
			levels.add(TTConstants.CLUSTER);
			levels.add(TTConstants.TOWER);
	
			//InputStream file1 = new FileInputStream(file);
			
			System.out.println("File: " + file);

			 
            // Create a workbook using the File System 
            //XSSFWorkbook wb = new XSSFWorkbook(file1);
            
         	OPCPackage pkg = OPCPackage.open(file);
        	XSSFWorkbook wb = new XSSFWorkbook(pkg);
        	
            //XSSFWorkbook wb = new XSSFWorkbook(file1);
            
            System.out.println ("workbook");
 
            // Get the first sheet from workbook 
            XSSFSheet sheet1 = (XSSFSheet) wb.getSheetAt(0);
 
            XSSFRow row;
            
            for(int i=1; i<=sheet1.getLastRowNum(); i++) {
            	String isMandatory;
            	 row = sheet1.getRow(i);
            	 
            	 training.setTrainingName(String.valueOf(row.getCell(0)));
            	 training.setStartDate(row.getCell(1).getDateCellValue());
            	 training.setEndDate(row.getCell(2).getDateCellValue());
             	// training.setNumOfDays(String.valueOf(row.getCell(3)));
            	 training.setLevelId(String.valueOf(row.getCell(4)));
            	 if (!levels.contains(training.getLevelId())) {
            		 System.out.println("Level: "+training.getLevelId()+" not allowed. Should be one of the following");
            		 for (int a=0; a<levels.size(); a++){
            			 System.out.println(levels.get(a));
            		 }
            		 return "failure";
            	 }
            	 training.setLevelName(String.valueOf(row.getCell(5)));
            	 isMandatory = String.valueOf(row.getCell(6));
            	 if (isMandatory.equalsIgnoreCase("Y")) {
            		 training.setTrainingType("Mandatory");
            	 } else {
            		 training.setTrainingType("Optional");
            	 }
            	 training.setCategoryType(String.valueOf(row.getCell(7)));

            	//System.out.println (String.valueOf(row.getCell(1).getRichStringCellValue()));  

            	trainingOperation.addTraining(training);
            	
            	if (training.getTrainingType().equals("Mandatory")) {

        		    //empTrng.setEmpId("05487M");
        			empTrng.setTrainingId(training.getTrainingId());
        			empTrng.setStartDate(training.getStartDate());
        			empTrng.setEndDate(training.getEndDate());
        			empTrng.setStatus(TTConstants.PENDING);
        			empTrng.setTrainingName(training.getTrainingName());
        			empTrng.setTrainingType(training.getTrainingType());
        			//empTrng.setEtId("2");
        			
        			List<String> employeeList = trainingOperation.getEmployees(training.getLevelName(), training.getLevelId());
        	    	for (int j=0; j<employeeList.size(); j++){
        	    	empTrng.setEmpId(employeeList.get(j));
        	    	trainingOperation.assignTrainings(empTrng);    	
        	    	}
        		  
        	  }
            	
            }
            pkg.close();
            System.out.println ("Uploaded Successfully");
            return "success";
		}
        catch (Exception e){
            e.printStackTrace(); 
            return "failure";
        }
		
	}
	
	public String execute() {
		String res;
		System.out.println("File received: "+ uploadFile);
		System.out.println("File name: "+ uploadFileFileName);	
		res = uploadTrainings(uploadFile);
		return res;
	}
}
