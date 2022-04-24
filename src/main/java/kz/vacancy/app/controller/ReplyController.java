package kz.vacancy.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import kz.vacancy.app.entity.Reply;
import kz.vacancy.app.service.NotificationService;
import kz.vacancy.app.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/replyes/save")
	public String saveReply(Reply reply, Principal principal) {		
		replyService.saveReply(reply, principal.getName());	
		
		// метод асинхронный - через минуту клиенту придет уведомление о новом сообщении
		notificationService.sendNewNotification(principal.getName());	
		
		return "redirect:/vacancies";
	}
}
