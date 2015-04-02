package com.att.ttt.dao;

import java.util.Collection;

import com.att.ttt.entity.Trainings;

public interface TrainingsDao {

	int loadTrainings(Collection<Trainings> trngCollection);
	void saveTraining (Trainings training);
	void updateTraining(Trainings training);
}
