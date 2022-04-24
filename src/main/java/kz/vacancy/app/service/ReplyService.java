package kz.vacancy.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kz.vacancy.app.entity.Notification;
import kz.vacancy.app.entity.Reply;
import kz.vacancy.app.entity.User;
import kz.vacancy.app.entity.Vacancy;
import kz.vacancy.app.repository.NotificationRepository;
import kz.vacancy.app.repository.ReplyRepository;
import kz.vacancy.app.repository.UserRepository;
import kz.vacancy.app.repository.VacancyRepository;

@Service
public class ReplyService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private VacancyRepository vacancyRepository;
	
	
	public void saveReply(Reply reply, String userEmail) {
		
		User user = userRepository.findByEmail(userEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		reply.setUser(user);
		replyRepository.save(reply);
		
		Vacancy vacancy = vacancyRepository.findById(reply.getVacancy().getId()).get();
		
		Notification notification = new Notification();
		notification.setUser(user);
		notification.setMessage("Вас готова пригласить компания " + vacancy.getCompany()
				+ ", на должность " + vacancy.getPosition()
				+ ", перезвоните в рабочее время по номеру " + vacancy.getPhone());	
		notification.setDateTime(LocalDateTime.now().plusMinutes(1));
		notificationRepository.save(notification);
	}

}
