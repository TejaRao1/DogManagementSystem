/**
 * 
 */
package com.BandiClasses.DMSControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.BandiClasses.DMSModels.Dog;
import com.BandiClasses.DMSModels.Trainer;
import com.BandiClasses.DMSRepository.DogRepository;
import com.BandiClasses.DMSRepository.TrainerRepository;

/**
 * @author Raviteja Errepally(S563056) Nov 12, 2023
 */

@Controller
public class DogController {

	ModelAndView mv = new ModelAndView();
	@Autowired
	DogRepository dogRepo;
	@Autowired
	TrainerRepository trainerRepo;

	/*
	 * @RequestMapping("DogHome") public String home() { return "home"; }
	 */
	@RequestMapping("DogHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewDog.html");
		Iterable<Trainer> trainerList = trainerRepo.findAll();
		mv.addObject("trainers", trainerRepo);
		return mv;
	}

	@RequestMapping("addNewDog")
	public ModelAndView addNewDog(Dog dog, @RequestParam("trainerId") int id) {
		Trainer trainer = trainerRepo.findById(id).orElse(new Trainer());
		dog.setTrainer(trainer);
		dogRepo.save(dog);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDogs() {
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = dogRepo.findAll();
		mv.addObject("dogs", dogList);
		return mv;
	}

	@RequestMapping("editDog")
	public ModelAndView editDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("editDog");
		return mv;
	}

	@RequestMapping("addTrainer")
	public ModelAndView addTrainer() {
		mv.setViewName("addNewTrainer");
		return mv;

	}

	@RequestMapping("trainerAdded")
	public ModelAndView addNewTrainer(Trainer trainer) {
		trainerRepo.save(trainer);
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping("deleteDog")
	public ModelAndView deleteDog(Dog dog) {
		// method 1-based on id
		/*
		 * Optional<Dog> dogFound = dogRepo.findById(dog.getId());
		 * if(dogFound.isPresent()) { dogRepo.delete(dog); } return home();
		 */
		// method 2-based on name
		/*
		 * List<Dog> dogsFound = dogRepo.findByName(dog.getName()); for(Dog d :
		 * dogsFound) { dogRepo.delete(d); } return home();
		 */
		// method 3-using id with orElse() method
		Dog d = dogRepo.findById(dog.getId()).orElse(new Dog());
		dogRepo.delete(d);
		return home();
	}

	@RequestMapping("search")
	public ModelAndView dearchById(int id) {
		Dog dogFound = dogRepo.findById(id).orElse(new Dog());
		mv.addObject(dogFound);
		mv.setViewName("searchResults");
		return mv;
	}

}
