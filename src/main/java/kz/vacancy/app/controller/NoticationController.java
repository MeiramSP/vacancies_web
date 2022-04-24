package kz.vacancy.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kz.vacancy.app.service.NotificationService;

@Controller
public class NoticationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/notifications")
	public String showAll(Model model, Principal principal) {
		model.addAttribute("notifications", notificationService.getByUserEmail(principal.getName()));
		return "notifications";
	}
}
