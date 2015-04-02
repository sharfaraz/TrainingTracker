import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//C:\Training Tracker Tool
//		InputStream excelFile = new FileInputStream("C:\Training Tracker Tool\File1.xlsx");
		processExcelFile();
		
	}

	public void saveEmployee() {
		try{

            FileInputStream input = new FileInputStream("C:/Training Tracker Tool/File1.xlsx");  
                POIFSFileSystem fs = new POIFSFileSystem( input );  
                HSSFWorkbook wb = new HSSFWorkbook(fs);  
                HSSFSheet sheet = wb.getSheetAt(0);  
                HSSFRow row;  


                for(int i=1; i<=sheet.getLastRowNum(); i++)
                {  
//                    Employee employee=new Employee();
//                    row = sheet.getRow(i);  
//
//
//                    employee.setEmployeeName(String.valueOf(row.getCell(0).getRichStringCellValue()));  
//                    employee.setDesignation(String.valueOf(row.getCell(1).getRichStringCellValue()));
//                    employee.setSalary((long)row.getCell(2).getNumericCellValue());
//
//                    employeeService.insert(employee); // call to spring service layer

                }  
    } catch (FileNotFoundException ec) {
        ec.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
	
	public static int processExcelFile(){
		 
		 
        int count = 0;
 
        try{
            // Creating Input Stream 
//            FileInputStream myInput = new FileInputStream(file);
        	InputStream myInput = new FileInputStream("C:/Training Tracker Tool/File1.xlsx");
    		
 
            // Create a workbook using the File System 
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
 
            // Get the first sheet from workbook 
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
 
            XSSFRow row;
            
            for(int i=1; i<=mySheet.getLastRowNum(); i++) {
            	 row = mySheet.getRow(i);  
            	System.out.println (String.valueOf(row.getCell(9).getRichStringCellValue()));  
            }
            
            /** We now need something to iterate through the cells.**/
            /*Iterator<Row> rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
 
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator<Cell> cellIter = myRow.cellIterator();
                while(cellIter.hasNext()){
 
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    //get cell index
                    System.out.println("Cell column index: " + myCell.getColumnIndex());
                    //get cell type
                    System.out.println("Cell Type: " + myCell.getCellType());
 
                    //get cell value
                    switch (myCell.getCellType()) {
                    case XSSFCell.CELL_TYPE_NUMERIC :
                        System.out.println("Cell Value: " + myCell.getNumericCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_STRING:   
                        System.out.println("Cell Value: " + myCell.getStringCellValue());
                        break;
                    default:   
                        System.out.println("Cell Value: " + myCell.getRawValue());
                        break;   
                    }
                    System.out.println("---");
 
                    if(myCell.getColumnIndex() == 0 && 
                            !myCell.getStringCellValue().trim().equals("") &&
                            !myCell.getStringCellValue().trim().equals("Item Number")){
                        count++;
                    }
 
                }
 
            }*/
        }
        catch (Exception e){
            e.printStackTrace(); 
        }
 
        return count;
 
    }
/*
 * 
 * 
public static Session getSession() {
    Session session=sessionFactory.openSession();
    session.getTransaction().begin();
    return session;
}
public static void closeSession(Session session) {
    if(session!=null )
    {
        if(session.getTransaction().isActive())
        {
            session.getTransaction().commit();
        }
            session.close();
            getSessionfactory().close();
    }
}

 */
}
