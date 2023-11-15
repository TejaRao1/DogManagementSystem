/**
 * 
 */
package com.BandiClasses.DMSModels;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Raviteja Errepally(S563056)
 * Nov 13, 2023
 */

@Entity
public class Trainer {
	
	@Id
	private int TrainerId;
	private String TrainerName;
	private String TrainerAddress;
	public int getTrainerId() {
		return TrainerId;
	}
	public void setTrainerId(int trainerId) {
		TrainerId = trainerId;
	}
	public String getTrainerName() {
		return TrainerName;
	}
	public void setTrainerName(String trainerName) {
		TrainerName = trainerName;
	}
	public String getTrainerAddress() {
		return TrainerAddress;
	}
	public void setTrainerAddress(String trainerAddress) {
		TrainerAddress = trainerAddress;
	}
	@Override
	public String toString() {
		return "Trainer [TrainerId=" + TrainerId + ", TrainerName=" + TrainerName + ", TrainerAddress=" + TrainerAddress
				+ "]";
	}

	

}
