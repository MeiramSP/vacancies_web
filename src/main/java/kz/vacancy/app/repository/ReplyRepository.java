package kz.vacancy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.vacancy.app.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
