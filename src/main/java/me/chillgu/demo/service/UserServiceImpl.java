package me.chillgu.demo.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.chillgu.demo.entity.User;
import me.chillgu.demo.repository.UserRepository;

/*
 *  @Service -> 빈 등록
 *  @RequiredArgsConstructor -> final 맴버변수만을 파라미터로 하는 생성자 매서드를 만들어준다!
 *   
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	/*
	 *  트랜잭션 처리는 Service 계층에서 해주자.
	 */
	@Transactional
	@Override
	public void save(User user) {
		
		userRepository.save(user);
	}
}
