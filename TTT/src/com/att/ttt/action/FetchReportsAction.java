package com.att.ttt.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.views.velocity.components.SetDirective;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.entity.TrainingReportBean;
import com.att.ttt.utility.WebApp;
import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import jxl.SheetSettings;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FetchReportsAction extends ActionSupport  implements SessionAware{


	private SessionMap<String,Object> sessionMap; 
	private  InputStream excelStream;


	private ArrayList<String>  NewTrainingType=new ArrayList<String>();
	private ArrayList<String>  NewTowerData =new ArrayList<String>();
	private ArrayList<String>  NewStatus =new ArrayList<String>();
	private List<String> NewSDMdata =new ArrayList<String>();
	private List<String> newDmData=new ArrayList<String>();
	private List<String> towerData=new ArrayList<String>();
	private List<String>   newAppData =new ArrayList<String>();
	private List<String> repByTower = new ArrayList<String>();
	private String NewTrainingStDate;
	private String NewTrainingEndDate;
	private String Clusterdata;
	private String Statusdata="Completed,Pending";
	private String TrainingTypeData="Mandatory,Optional";

	private String assignedKeyFortower = null;
	private Date todayDate;
	

	private String clusterId ;
	private String tower;
	private String MGR_ID;
	private String appId;
	private String towerName;//for tower
	

	private String trainingType;
	private String trainingStatus;
	
	

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

	public ArrayList<String> getNewTowerData() {
		return NewTowerData;
	}

	public void setNewTowerData(ArrayList<String> newTowerData) {
		NewTowerData = newTowerData;
	}

	public List<String> getNewSDMdata() {
		return NewSDMdata;
	}

	public void setNewSDMdata(List<String> newSDMdata) {
		NewSDMdata = newSDMdata;
	}

	public List<String> getNewDmData() {
		return newDmData;
	}

	public void setNewDmData(List<String> newDmData) {
		this.newDmData = newDmData;
	}

	public List<String> getTowerData() {
		return towerData;
	}

	public void setTowerData(List<String> towerData) {
		this.towerData = towerData;
	}

	public List<String> getNewAppData() {
		return newAppData;
	}

	public void setNewAppData(List<String> newAppData) {
		this.newAppData = newAppData;
	}

	public List<String> getRepByTower() {
		return repByTower;
	}

	public void setRepByTower(List<String> repByTower) {
		this.repByTower = repByTower;
	}

	

	public String getNewTrainingStDate() {
		return NewTrainingStDate;
	}

	public void setNewTrainingStDate(String newTrainingStDate) {
		NewTrainingStDate = newTrainingStDate;
	}

	public String getNewTrainingEndDate() {
		return NewTrainingEndDate;
	}

	public void setNewTrainingEndDate(String newTrainingEndDate) {
		NewTrainingEndDate = newTrainingEndDate;
	}

	public String getClusterdata() {
		return Clusterdata;
	}

	public void setClusterdata(String clusterdata) {
		Clusterdata = clusterdata;
	}

	public String getStatusdata() {
		return Statusdata;
	}

	public void setStatusdata(String statusdata) {
		Statusdata = statusdata;
	}

	public String getTrainingTypeData() {
		return TrainingTypeData;
	}

	public void setTrainingTypeData(String trainingTypeData) {
		TrainingTypeData = trainingTypeData;
	}

	public String getAssignedKeyFortower() {
		return assignedKeyFortower;
	}

	public void setAssignedKeyFortower(String assignedKeyFortower) {
		this.assignedKeyFortower = assignedKeyFortower;
	}

	public Date getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getTower() {
		return tower;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}

	public String getMGR_ID() {
		return MGR_ID;
	}

	public void setMGR_ID(String mGR_ID) {
		MGR_ID = mGR_ID;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTowerName() {
		return towerName;
	}

	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
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

		
		towerData = trDao.getTowervalues();
		
		NewTrainingType.add("Mandatory");
		NewTrainingType.add("Optional");
		
		NewStatus.add("Completed");
		NewStatus.add("Pending");
		
		System.out.println("tower size inside execute() :"+towerData.size());
		return "populate";


	}

	public String getSdmListForReport(){

		NewSDMdata = trDao.getSdmForReportDisplay(tower);
		setNewSDMdata(NewSDMdata);
		return "success";

	}

	public String getDmListForReport(){

		newDmData = trDao.getDmForReportDisplay(clusterId);
		setNewDmData(newDmData);
		return "success";

	}

/*

	public String getAppListForReport(){

		System.out.println("enter into getAppListForReport: ");
		WebApplicationContext context=WebApp.getContext();
		InitAddAssignTrainingImpl initTrainings=(InitAddAssignTrainingImpl)context.getBean("InitAddAssignTrainingBean");
		System.out.println("after initTrainings for app");
		System.out.println("MGR_ID"+MGR_ID);
		newAppData = initTrainings.getAppForReportDisplay(MGR_ID);
		setNewAppData(newAppData);
		System.out.println("newAppData"+newAppData.size());
		return "success";

	}*/
	
	public String generateExcel(List<TrainingReportBean> reportBeanList) {
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
			System.out.println("reportBeanList.size() :"+reportBeanList.size());
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
			
			for (int i = 1; i <= reportBeanList.size(); i++) {

				reportBean=reportBeanList.get(i-1);

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

			}

			workbook.write();
			workbook.close();

			excelStream=new FileInputStream(file);

		}catch(Exception e){
			e.printStackTrace();

		}
		return "success";
	}



	public String fetchReportInExcel()
	{
		String reportLevel = "";
		String reportLevelValue="";
		
		
		System.out.println("Enter into fetchReportInExcel");
		System.out.println("tower ID :"+towerName);
		System.out.println("sdmName ID :"+clusterId);
		System.out.println("dm ID :"+MGR_ID);
		System.out.println("a ID :"+appId);
		
		
		
		List<TrainingReportBean> reportBeanList=new ArrayList<TrainingReportBean>();
		if (towerName != null && (clusterId.equals("-1") || clusterId == null) ){
		
			//System.out.println("tower ID :"+towerName);
			reportLevel=TTConstants.TOWER;
			reportLevelValue = towerName;
			//System.out.println("reportLevel :"+reportLevel);
			//System.out.println("reportLevelValue"+reportLevelValue);
		}
		else if (towerName != null && clusterId!= null && (MGR_ID.equals("-1") || MGR_ID== null)){
			//System.out.println("sdm ID :"+clusterId);
			reportLevel=TTConstants.CLUSTER;
			reportLevelValue = clusterId;
			/*System.out.println("reportLevel :"+reportLevel);
			System.out.println("reportLevelValue"+reportLevelValue);*/
		}
		else if (towerName != null && clusterId!= null && MGR_ID != null && (appId== null || appId.equals("-1"))){
			//System.out.println("dm ID :"+MGR_ID);
			reportLevel=TTConstants.dmLevel;
			reportLevelValue = MGR_ID;
			//System.out.println("reportLevel :"+reportLevel);
			//System.out.println("reportLevelValue"+reportLevelValue);
		}
	/*	else {
			//System.out.println("app ID :"+appId);
			reportLevel=TTConstants.APPLICATION;
			reportLevelValue = appId;
			//System.out.println("reportLevel :"+reportLevel);
			//System.out.println("reportLevelValue"+reportLevelValue);
		}*/
		
		
		
		System.out.println("report level :"+reportLevel);
		System.out.println("reportLevelValue :"+reportLevelValue);
		
				
		System.out.println("Going to fetCh report dATA");
		
		Date startDate = StringtoDate(NewTrainingStDate);
		Date endDate = StringtoDate(NewTrainingEndDate);
		
		reportBeanList = trDao.gererateTrainingReport(startDate,endDate , trainingType, trainingStatus, reportLevel, reportLevelValue);
		System.out.println("after fetching dATA");
		
		generateExcel(reportBeanList);

		return "success";
	}

	
	

	public ArrayList<String> getNewTrainingType() {
		return NewTrainingType;
	}

	public void setNewTrainingType(ArrayList<String> newTrainingType) {
		NewTrainingType = newTrainingType;
	}
	public ArrayList<String> getNewStatus() {
		return NewStatus;
	}

	public void setNewStatus(ArrayList<String> newStatus) {
		NewStatus = newStatus;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

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
