/**
 * 
 */
package com.BandiClasses.DMSModels;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;



/**
 * @author Raviteja Errepally(S563056)
 * Nov 12, 2023
 */

@Entity
public class Dog {
	@Id
	private int id;
	private String name;
	private String breed;
	@ManyToOne
	private Trainer trainer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", trainer=" + trainer + "]";
	}
	
	

}
