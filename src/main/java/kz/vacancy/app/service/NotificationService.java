package kz.vacancy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kz.vacancy.app.entity.Notification;
import kz.vacancy.app.entity.User;
import kz.vacancy.app.repository.NotificationRepository;
import kz.vacancy.app.repository.UserRepository;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	
	public List<Notification> getByUserEmail(String userEmail) {
		User user = userRepository.findByEmail(userEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));	
		return notificationRepository.findByUserId(user.getId());	
	}
	
	@Async
	public void sendNewNotification(final String userEmail) {		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		messagingTemplate.convertAndSendToUser(userEmail,"/topic/private-notify", 
				"Вас готовы пригласить на собеседование");		
	}
}
