package kz.vacancy.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kz.vacancy.app.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
	@Query("SELECT n from Notification n where n.user.id = ?1 ORDER BY n.dateTime DESC")
	List<Notification> findByUserId(Long userId);
	
}
