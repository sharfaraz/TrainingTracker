package com.att.ttt.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.EmployeeDao;
import com.att.ttt.entity.Employee;

public class EmployeeManagerImpl implements EmployeeManager {

	private EmployeeDao dao;

	public EmployeeDao getEmployeeDao() {
		return dao;
	}
	@Autowired
	public void setEmployeeDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void uploadEmployees(File file) {
		// TODO Auto-generated method stub
		try{
            // Creating Input Stream 
//        	InputStream file1 = new FileInputStream("C:/Training Tracker Tool/File1.xlsx");
//       	InputStream file1 = new FileInputStream(file);
 
            // Create a workbook using the File System 
            //XSSFWorkbook wb = new XSSFWorkbook();
           
            OPCPackage pkg = OPCPackage.open(file);
        	XSSFWorkbook wb = new XSSFWorkbook(pkg);
 
            // Get the first sheet from workbook 
            XSSFSheet sheet1 = wb.getSheetAt(0);
 
            XSSFRow row;
            
            for(int i=1; i<=sheet1.getLastRowNum(); i++) {
            	Employee employee = new Employee();
            	 row = sheet1.getRow(i);
            	 employee.setEmpId(String.valueOf(row.getCell(6).getRichStringCellValue()));
            	 employee.setAttuid(String.valueOf(row.getCell(9).getRichStringCellValue()));
            	 employee.setLname(String.valueOf(row.getCell(11).getRichStringCellValue()));
            	 employee.setFname(String.valueOf(row.getCell(12).getRichStringCellValue()));
            	 employee.setJobTitle(String.valueOf(row.getCell(14).getRichStringCellValue()));
            	 employee.setEmailId(String.valueOf(row.getCell(16).getRichStringCellValue()));
            	 employee.setDelMgr(String.valueOf(row.getCell(41).getRichStringCellValue()));
            	 employee.setDelMgrId(String.valueOf(row.getCell(42).getRichStringCellValue()));
            	 employee.setSrdelMgr(String.valueOf(row.getCell(45).getRichStringCellValue()));
            	 employee.setSrdelMgrId(String.valueOf(row.getCell(46).getRichStringCellValue()));
            	 employee.setStartDate(row.getCell(21).getDateCellValue());
            	 employee.setEndDate(row.getCell(23).getDateCellValue());
            	 employee.setCity(String.valueOf(row.getCell(36).getRichStringCellValue()));
            	 employee.setTower(String.valueOf(row.getCell(2).getRichStringCellValue()));
//            	dao.saveEmployee(employee);
            	dao.updateEmployee(employee);
            }
            pkg.close();
            System.out.println ("Uploaded Successfully");
		}
        catch (Exception e){
            e.printStackTrace(); 
        }
		
	}

}
