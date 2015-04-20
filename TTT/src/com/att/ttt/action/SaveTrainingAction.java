package com.att.ttt.action;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.att.ttt.entity.Trainings;
import com.att.ttt.manager.AccountManager;
import com.att.ttt.manager.ApplicationManager;
import com.att.ttt.manager.ClusterManager;
import com.att.ttt.manager.TowerManager;
import com.att.ttt.manager.TrainingsManager;


public class SaveTrainingAction {
	private Integer trainingId;
	private String trainingName;	
	private String numOfDays;
	private String levelId;
	private String levelName;
	private String accounts;
	private String towers;
	private String clusters;
	private String applications;
	private Date startDate;
	private Date endDate;
	private String delMgr;
	
	private Trainings training;
	
	private ApplicationManager applicationManager;
	private TrainingsManager manager;
	private TowerManager towerManager;
	private ClusterManager clusterManager;
	private AccountManager accountManager;
	
	
	public TowerManager getTowerManager() {
		return towerManager;
	}

	@Autowired
	public void setTowerManager(TowerManager towerManager) {
		this.towerManager = towerManager;
	}

	public ClusterManager getClusterManager() {
		return clusterManager;
	}

	@Autowired
	public void setClusterManager(ClusterManager clusterManager) {
		this.clusterManager = clusterManager;
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}

	@Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public ApplicationManager getApplicationManager() {
		return applicationManager;
	}

	@Autowired
	public void setApplicationManager(ApplicationManager applicationManager) {
		this.applicationManager = applicationManager;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getTowers() {
		return towers;
	}

	public void setTowers(String towers) {
		this.towers = towers;
	}

	public String getClusters() {
		return clusters;
	}

	public void setClusters(String clusters) {
		this.clusters = clusters;
	}

	public String getApplications() {
		return applications;
	}

	public void setApplications(String applications) {
		this.applications = applications;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


	
	public Integer getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(String numOfDays) {
		this.numOfDays = numOfDays;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDelMgr() {
		return delMgr;
	}

	public void setDelMgr(String delMgr) {
		this.delMgr = delMgr;
	}

	public Trainings getTraining() {
		return training;
	}

	public void setTraining(Trainings training) {
		this.training = training;
	}
	
	public TrainingsManager getManager() {
		return manager;
	}
	
	@Autowired
	public void setManager(TrainingsManager manager) {
		this.manager = manager;
	}

	public String execute() {
		
		try {
			training = new Trainings();
			training.setTrainingName(trainingName);
			training.setEndDate(endDate);
			training.setLevelId(levelId);
			training.setStartDate(startDate);
			
			if (!getApplications().isEmpty()) {
				training.setLevelName("application");
				System.out.println("application: " +getApplications()+ "\n");
				String id = applicationManager.fetchApplication(getApplications()).getApplnId();
				System.out.println("id: " +id+ "\n");
				training.setLevelId(applicationManager.fetchApplication(getApplications()).getApplnId());
			}
			else if (!getClusters().isEmpty()) {
				training.setLevelName("cluster");
				training.setLevelId(clusterManager.fetchCluster(getClusters()).getClusterId());
			}
			else if (!getTowers().isEmpty()) {
				training.setLevelName("tower");
				training.setLevelId(towerManager.fetchTower(getTowers()).getTowerId());
			}
			else if (!getAccounts().isEmpty()) {
				training.setLevelName("account");
				training.setLevelId(accountManager.fetchAccount(getAccounts()).getAccountId());
			}

			
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();	
		}
		return "success";
	}
	
	public String display() {
		return "none";
	}

}
