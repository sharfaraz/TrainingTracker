package com.att.ttt.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.TrainingReportBean;
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionContext;


public class TrainingTrackerDaoImpl implements TrainingTrackerDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public ArrayList<Employee> getUserPresenceList(String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "from Employee e where e.emailId = '"+emailId+"'";
		Query qry=currentSession.createQuery(query);
		List<Employee> userPresentList =   qry.list();
		return (ArrayList<Employee>) userPresentList;
	}
	
	@Override
	@Transactional
	public String getUserRoles (String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "select userRole from UserRoles u where u.email = '"+emailId+"'";
		Query qry = currentSession.createQuery(query);
		List<String> userRolesList = qry.list();
		return userRolesList.get(0);
	}
	
	@Override
	@Transactional
	public List<Emp_Trng> myTrainingsList(String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String empId = (String) currentSession.createQuery("select empId from Employee where emailId = '"+emailId+"'").list().get(0);
		System.out.println("fetched empId: "+empId);
		String query = "from Emp_Trng where empId = '"+empId+"'";
		Query qry=currentSession.createQuery(query);
		List<Emp_Trng> myTrainingsList =   qry.list();
		return myTrainingsList;
	}
	@Override
	@Transactional
	public List<Employee> getDeliveryManagersList() {
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "select delmgr, delmgrid from employee group by 1, 2";
		Query qry = currentSession.createQuery(query);
		List<Employee> deliveryManagersList = qry.list();
		return deliveryManagersList;
	}
	@Override
	@Transactional
	public List<String> getAccountvalues() {
		List<String> accountList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct a.accountName from Account a");
		accountList = qry.list();
		return accountList;
	}
	@Override
	@Transactional
	public List<String> getTowervalues() {
		List<String> towerList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct t.towerName from Tower t");
		towerList = qry.list();
		return towerList;
	}
	@Override
	@Transactional
	public List<String> getClustervalues() {
		List<String> clusterList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct c.clusterName from Cluster c");
		clusterList = qry.list();
		return clusterList;
	}
	@Override
	@Transactional
	public List<String> getApplicationvalues() {
		List<String> appList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct ap.applnName from Application ap");
		appList = qry.list();
		return appList;
	}
	
	@Override
	@Transactional
	public void addTraining(Trainings training) {
		// TODO Auto-generated method stub
		Session currentSession=this.getSessionFactory().getCurrentSession();
		currentSession.save(training);
	}
	
	@Override
	@Transactional
	public List<String> getSdmForReportDisplay(String tower) {
		List<String> sdmList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct e.srDelMgr from Employee e where tower='"+tower+"'");
		sdmList = qry.list();
		return sdmList;
	}
	@Override
	@Transactional
	public List<String> getDmForReportDisplay(String sdm) {
		List<String> dmList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct e.delMgr from Employee e where srDelMgr='"+sdm+"'");
		dmList = qry.list();
		return dmList;
	}
	@Override
	@Transactional
	public List<String> getAppForReportDisplay(String tower) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public void updateEmpTrng(Emp_Trng empTrng) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		System.out.println("Updating EmpTrng");
		System.out.println("values"+empTrng.getEtId()+"|"+empTrng.getEmpId()+"|"+empTrng.getStatus()+"|"+empTrng.getTrainingName()+"|"+empTrng.getTrainingType()
				+"|"+empTrng.getTrainingId()+"|"+empTrng.getEndDate()+"|"+empTrng.getStartDate());
		currentSession.update(empTrng);
	}
	
	
	@Override
	@Transactional
	public void assignTrainings(Emp_Trng empTrng) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		System.out.println("Saving training : " +empTrng.getTrainingId()+" for employee: "+empTrng.getEmpId());
		currentSession.save(empTrng);
		System.out.println("Saved");
	}
	@Override
	@Transactional
	public List<String> getEmployees(String levelName, String levelId) {
		// TODO Auto-generated method stub
		
		List<String> employeeList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		
		System.out.println("levelname: "+levelName+" LevelId: "+levelId);

		if (levelId.equalsIgnoreCase("tower") || levelId.equalsIgnoreCase("account")) {
			String query = "select empId from Employee where "+levelId+" = '"+levelName+"'";
			Query qry = currentSession
					.createQuery(query);
			employeeList = qry.list();			
		}
		
		if (levelId.equalsIgnoreCase("sdm/cluster")) {
			Map aSession = (Map) ActionContext.getContext().get("session");
			String a = (String) aSession.get("email");
			
			Query qry = currentSession
						.createQuery("select empId from Employee where srDelMgrId = "+
			"(select srDelMgrId from Employee where emailId = '"+a+"')");
			employeeList = qry.list();

		}
		
		
		
		return employeeList;
	}
	
	@Override
	@Transactional
	public List<TrainingReportBean> gererateTrainingReport(
			Date trainingStartDate, Date trainingEndDate,
			String trainingType, String trainingStatus, String reportLevel,
			String reportLevelValue) {
		
		List<TrainingReportBean> reportBeanList=new ArrayList<TrainingReportBean>();
		try{
			
			Session currentSession = this.getSessionFactory().getCurrentSession();
			
			if (reportLevel.equals(TTConstants.TOWER)){
			List<Employee> empList = new ArrayList<Employee>();
			Query qry = currentSession
					.createQuery(" from Employee e where tower='"+reportLevelValue+"'");
			empList = qry.list();
			
			for (Employee employee : empList) {
				Query qry1=null;
					 qry1=currentSession.createQuery("from Emp_Trng where empId = ? and startDate >= ? AND endDate <= ? and status=? and trainingType=?");
					 
					 					 
					 qry1.setString(0, employee.getEmpId());
					 qry1.setDate(1, trainingStartDate);
					 qry1.setDate(2, trainingEndDate);
					 qry1.setString(3, trainingStatus);
					 qry1.setString(4, trainingType);
					 
					if(qry1.list().size()!= 0){
						
						List<Emp_Trng> emptrng = qry1.list();
						
						for (Emp_Trng empTrng: emptrng) {
							TrainingReportBean trRepBean = new TrainingReportBean();
							trRepBean.setEmpId(employee.getEmpId());
							trRepBean.setEmpName(employee.getLname()+","+employee.getFname() );
							trRepBean.setDmName(employee.getDelMgr());
							trRepBean.setSdmName(employee.getSrDelMgr());
							trRepBean.setTowerName(employee.getTower());
							trRepBean.setTrainingType(empTrng.getTrainingType());
							trRepBean.setTrainingName(empTrng.getTrainingName());
							trRepBean.setStartDate(empTrng.getStartDate());
							trRepBean.setEndDate(empTrng.getEndDate());
							trRepBean.setTrainingStatus(empTrng.getStatus());
							
							reportBeanList.add(trRepBean);
						}
					}
			}
			
			}
			else if (reportLevel.equals(TTConstants.CLUSTER)){
				List<Employee> empList = new ArrayList<Employee>();
				Query qry = currentSession
						.createQuery("from Employee e where srDelMgr='"+reportLevelValue+"'");
				empList = qry.list();
				for (Employee employee : empList) {
					Query qry1=null;
						 qry1=currentSession.createQuery("from Emp_Trng where empId = ? and startDate >= ? AND endDate <= ? and status=? and trainingType=?");
						 
						 
						 qry1.setString(0, employee.getEmpId());
						 qry1.setDate(1, trainingStartDate);
						 qry1.setDate(2, trainingEndDate);
						 qry1.setString(3, trainingStatus);
						 qry1.setString(4, trainingType);
						 
						 Emp_Trng emp = (Emp_Trng) qry1.list().get(0);
						 
							if(qry1.list().size()!= 0){
								
								List<Emp_Trng> emptrng = qry1.list();
								
								for (Emp_Trng empTrng: emptrng) {
									TrainingReportBean trRepBean = new TrainingReportBean();
									trRepBean.setEmpId(employee.getEmpId());
									trRepBean.setEmpName(employee.getLname()+","+employee.getFname() );
									trRepBean.setDmName(employee.getDelMgr());
									trRepBean.setSdmName(employee.getSrDelMgr());
									trRepBean.setTowerName(employee.getTower());
									trRepBean.setTrainingType(empTrng.getTrainingType());
									trRepBean.setTrainingName(empTrng.getTrainingName());
									trRepBean.setStartDate(empTrng.getStartDate());
									trRepBean.setEndDate(empTrng.getEndDate());
									trRepBean.setTrainingStatus(empTrng.getStatus());
									
									reportBeanList.add(trRepBean);
								}
							}
				}
				}
			else if (reportLevel.equals(TTConstants.dmLevel)){
				List<Employee> empList = new ArrayList<Employee>();
				Query qry = currentSession
						.createQuery("from Employee e where delMgr='"+reportLevelValue+"'");
				empList = qry.list();
				System.out.println(empList);
				for (Employee employee : empList) {
					Query qry1=null;
						 qry1=currentSession.createQuery("from Emp_Trng where empId = ? and startDate >= ? AND endDate <= ? and status=? and trainingType=?");
						 
						// Employee emp = (Employee) qry.list().get(0);
						 
						 qry1.setString(0, employee.getEmpId());
						 qry1.setDate(1, trainingStartDate);
						 qry1.setDate(2, trainingEndDate);
						 qry1.setString(3, trainingStatus);
						 qry1.setString(4, trainingType);
						 
							if(qry1.list().size()!= 0){
								
								List<Emp_Trng> emptrng = qry1.list();
								
								for (Emp_Trng empTrng: emptrng) {
									TrainingReportBean trRepBean = new TrainingReportBean();
									trRepBean.setEmpId(employee.getEmpId());
									trRepBean.setEmpName(employee.getLname()+","+employee.getFname() );
									trRepBean.setDmName(employee.getDelMgr());
									trRepBean.setTowerName(employee.getTower());
									trRepBean.setTrainingType(empTrng.getTrainingType());
									trRepBean.setSdmName(employee.getSrDelMgr());
									trRepBean.setTrainingName(empTrng.getTrainingName());
									trRepBean.setStartDate(empTrng.getStartDate());
									trRepBean.setEndDate(empTrng.getEndDate());
									trRepBean.setTrainingStatus(empTrng.getStatus());
									
									reportBeanList.add(trRepBean);
								}
								
							}
				}
				}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return reportBeanList;
	}
		
		
		
}

