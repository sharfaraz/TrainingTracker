package com.att.ttt.manager;

import java.io.File;
import com.att.ttt.entity.Trainings;

public interface TrainingsManager {

	void uploadTrainings(File file);
	void createTraining(Trainings training);
}
