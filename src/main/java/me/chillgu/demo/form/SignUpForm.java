package me.chillgu.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  dto 객체는 getter setter를 열어두자. 값이 변동될 가능성이 높다.
 */
@NoArgsConstructor
@Getter @Setter
public class SignUpForm {

	/*
	 *  @NotBlank -> null과 함께 빈 문자열도 체크해준다.
	 *  @Size -> min, max가 단순히 글자 갯수를 의미하는지 확인해 봐야함.
	 *  
	 */ 
	@NotBlank(message = "username is required.")
	@Size(min=8, max=12, message = "username must be 8 ~ 12")
	private String username;
	
	@NotBlank(message = "password is required.")
	@Size(min=8, max=12, message = "password must be 8 ~ 12")
	private String password;
	
	@NotBlank(message = "I wanna know your name.")
	@Size(min=2, max=5, message = "wrong name")
	private String name;
	
	@Email(message = "wrong email.")
	private String email;

}
