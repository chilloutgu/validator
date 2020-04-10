package me.chillgu.demo.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import me.chillgu.demo.entity.User;
import me.chillgu.demo.form.SignUpForm;
import me.chillgu.demo.service.UserService;

@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	/*
	 *  Jackson2HttpMessageConverter에 의해 요청본문 ( RequestBody ) 에 담겨있는
	 *  json 데이터가 signUpForm 객체에 바인딩 될 수 있음.
	 *  
	 */
	@PostMapping("/signup")
	public void singUp(@RequestBody @Valid SignUpForm signUpForm, BindingResult bindingResult) {
			
		/*
		 *  error가 발생해 bindingResult에 담기게 되면,
		 *  모든 error를 가져온 뒤 각각의 에러를 출력하라!
		 *  
		 */
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> {
				
				System.out.println("error code :: " + error.getCode());
				System.out.println("error message :: " + error.getDefaultMessage());
				System.out.println("error objectName :: " + error.getObjectName());
				
			});
		}
		
		/*
		 *  error가 발생하지 않을 시,
		 *  signUpForm -> User 로 변환하고 회원가입 서비스를 진행한다.
		 */
		User user = signUpForm.toEntity();
		
		userService.save(user);
	}
}
