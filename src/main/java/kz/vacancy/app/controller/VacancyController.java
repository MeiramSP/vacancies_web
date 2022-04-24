package kz.vacancy.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kz.vacancy.app.entity.Reply;
import kz.vacancy.app.entity.Vacancy;
import kz.vacancy.app.repository.VacancyRepository;

@Controller
public class VacancyController {
	
	@Autowired
	private VacancyRepository vacancyRepository;
	
	@GetMapping("/vacancies")
	public String listVacancies(Model model) {
		List<Vacancy> vacancies =  vacancyRepository.findAll();
		model.addAttribute("listVacancies", vacancies);
		model.addAttribute("reply", new Reply());
		return "vacancies";
	}

}
