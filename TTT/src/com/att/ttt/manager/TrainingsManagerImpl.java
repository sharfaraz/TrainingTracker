package com.att.ttt.manager;

import java.io.File;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.TrainingsDao;
import com.att.ttt.entity.Trainings;

public class TrainingsManagerImpl implements TrainingsManager {

	private TrainingsDao dao;

	public TrainingsDao getTrainigsDao() {
		return dao;
	}
	@Autowired
	public void setTrainingsDao(TrainingsDao dao) {
		this.dao = dao;
	}




	@Override
	public void uploadTrainings(File file) {
		// TODO Auto-generated method stub
		try{
            // Creating Input Stream 
        	//InputStream file1 = new FileInputStream(file);
       
        	
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
            	Trainings training = new Trainings();
            	 row = sheet1.getRow(i);
            	 
            	 training.setDelMgr(String.valueOf(row.getCell(0)));
            	 training.setTraining_name(String.valueOf(row.getCell(1)));
            	 training.setLevel_id(String.valueOf(row.getCell(5)));
            	 training.setNumOfdays(String.valueOf(row.getCell(4)));
            	 training.setEndDate(row.getCell(3).getDateCellValue());
            	 training.setStartDate(row.getCell(2).getDateCellValue());
            	 

            	System.out.println (String.valueOf(row.getCell(1).getRichStringCellValue()));  

            	dao.updateTraining(training);
            	
            }
            pkg.close();
            System.out.println ("Uploaded Successfully");
		}
        catch (Exception e){
            e.printStackTrace(); 
        }
		
	}

}
