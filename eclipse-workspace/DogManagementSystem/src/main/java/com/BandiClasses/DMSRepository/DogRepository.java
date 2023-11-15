/**
 * 
 */
package com.BandiClasses.DMSRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BandiClasses.DMSModels.Dog;

/**
 * @author Raviteja Errepally(S563056)
 * Nov 12, 2023
 */
public interface DogRepository extends CrudRepository<Dog, Integer>{
	List<Dog> findByName(String name);
}
