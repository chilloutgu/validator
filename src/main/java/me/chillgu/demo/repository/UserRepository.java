package me.chillgu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.chillgu.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
