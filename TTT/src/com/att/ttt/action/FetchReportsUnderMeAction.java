package com.att.ttt.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.entity.TrainingReportBean;
import com.att.ttt.dao.TrainingTrackerDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

import javax.servlet.ServletContext;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FetchReportsUnderMeAction extends ActionSupport  implements SessionAware{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  InputStream excelStream;
	private SessionMap<String, Object> sessionMap;

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;

	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	

	public ServletContext getCtx() {
		return ctx;
	}

	public void setCtx(ServletContext ctx) {
		this.ctx = ctx;
	}

	public WebApplicationContext getContext() {
		return context;
	}

	public void setContext(WebApplicationContext context) {
		this.context = context;
	}

	public TrainingTrackerDao getTrDao() {
		return trDao;
	}

	public void setTrDao(TrainingTrackerDao trDao) {
		this.trDao = trDao;
	}

	
	
	ServletContext ctx = ServletActionContext.getServletContext();
	WebApplicationContext context = WebApplicationContextUtils
			.getWebApplicationContext(ctx);

	TrainingTrackerDao trDao=(TrainingTrackerDao)context.getBean("TrainingTrackerDao");

	public String execute() {

		List<TrainingReportBean> reportundermeList = trDao.generateTrainingReportUnderMe(sessionMap.get("email").toString());
		System.out.println("after fetching dATA. size: "+reportundermeList.size());
		
		
		System.out.println("Enter into generate excel");
		WorkbookSettings wbSettings = new WorkbookSettings();
		File file = new File("c:/Training_Tracker.xls");
		
		            


		try{	
			wbSettings.setLocale(new Locale("en", "EN"));
			WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
			workbook.createSheet("Report", 0);
			
			WritableSheet excelSheet = workbook.getSheet(0);
			excelSheet.getSettings().setDefaultColumnWidth(18);
			Label label;
			TrainingReportBean reportBean;
			System.out.println("reportundermeList.size() :"+reportundermeList.size());
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
		    cellFont.setBoldStyle(WritableFont.BOLD);
		    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		    cellFormat.setWrap(true);
			label = new Label(0, 0, "Employee Name", cellFormat);
			//label= new Label(0, 0, "Employee Name",cellFont);
			excelSheet.addCell(label);
				
			
			label= new Label(1, 0, "Employee Id",cellFormat);
			excelSheet.addCell(label);
			
			
			label= new Label(2, 0, "Delivery Manager",cellFormat);
			excelSheet.addCell(label);
			
			
			label= new Label(3, 0, "Senior Delivery Manager",cellFormat);
			excelSheet.addCell(label);
			
			label= new Label(4, 0, "Tower Name",cellFormat);
			excelSheet.addCell(label);
			
			label= new Label(5, 0, "Training Name",cellFormat);
			excelSheet.addCell(label);
			
			label= new Label(6, 0, "Training Type",cellFormat);
			excelSheet.addCell(label);
			
			label= new Label(7, 0, "Training Status",cellFormat);
			excelSheet.addCell(label);
			
			label= new Label(8, 0, "Training Start Date",cellFormat);
			excelSheet.addCell(label);
			
			label= new Label(9, 0, "Training End Date",cellFormat);
			excelSheet.addCell(label);
			
			System.out.println("Printed headers");
			
			
			for (int i = 1; i <= reportundermeList.size(); i++) {

				reportBean=reportundermeList.get(i-1);

				label=new Label(0, i, reportBean.getEmpName());
				excelSheet.addCell(label);

				label=new Label(1, i, reportBean.getEmpId());
				excelSheet.addCell(label);

				label=new Label(2, i, reportBean.getDmName());
				excelSheet.addCell(label);


				label=new Label(3, i, reportBean.getSdmName());
				excelSheet.addCell(label);

				label=new Label(4, i, reportBean.getTowerName());
				excelSheet.addCell(label);

				label=new Label(5, i, reportBean.getTrainingName());
				excelSheet.addCell(label);


				label=new Label(6, i, reportBean.getTrainingType());
				excelSheet.addCell(label);

				label=new Label(7, i, reportBean.getTrainingStatus());
				excelSheet.addCell(label);
				
				label=new Label(8,i, reportBean.getStartDate().toString());
				excelSheet.addCell(label);
				
				label=new Label(9,i, reportBean.getEndDate().toString());
				excelSheet.addCell(label);

			}
			
			System.out.println("after for loop");

			workbook.write();
			workbook.close();

			excelStream=new FileInputStream(file);
			
			System.out.println("after excel download");

		}catch(Exception e){
			e.printStackTrace();

		}
		return "success";
	}



	public Date StringtoDate(String inputDate) {
		SimpleDateFormat dateType = new SimpleDateFormat("MM/dd/yy");
		Date convertDate = new Date();

		try {
			convertDate = dateType.parse(inputDate);

		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return convertDate;

	}

}
