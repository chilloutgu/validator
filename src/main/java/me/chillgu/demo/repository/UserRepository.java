package me.chillgu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.chillgu.demo.entity.User;

// @Repository는 없어도 된다!
public interface UserRepository extends JpaRepository<User, Long>{

}
