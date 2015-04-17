package com.att.ttt.manager;

import com.att.ttt.entity.Application;

public interface ApplicationManager {
	
	Application fetchApplication(String appName);

}
