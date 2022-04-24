package kz.vacancy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.vacancy.app.entity.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
	
}
