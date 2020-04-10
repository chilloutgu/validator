package me.chillgu.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *  builder패턴을 통해 객체 생성하겠다. -> 기본생성자를 protected로 설정해 다른 개발자들에게 builder패턴을 사용하도록 유도하자.
 * 	엔티티에 대해서는 setter를 가급적 닫아두는 것이 좋다. -> 필요할 경우에만 열어두도록! -> 참조로부터 자유롭게!
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString @EqualsAndHashCode(of = "id")
@Getter
public class User {
	
	/*
	 *  @Column을 통해 database에 저장되는 값들에 대한 제약조건을 설정할 수 있다.
	 *  length 속성의 길이에 대해 확인해 봐야함.
	 *  email에 대해서는 어떤 제약조건이 좋을까?
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 12)
	private String username;
	
	@Column(nullable = false, length = 12)
	private String password;
	
	@Column(nullable = false, length = 4)
	private String name;

	private String email;
	
	/*
	 *  @Builder -> 클래스 레벨에서 작성하는 것과 생성자 매서드에서 작성하는 것의 차이는?
	 *  @Builder를 사용할 경우 기본생성자 또는 임의로 만든 생성자와 같이 사용하지 못한다. -> AllArgsConstructor도 같이 생성하도록 하자.
	 *  근데 지금 상황에서 기본생성자와 @Builder를 같이 사용하고 있다. -> 하지만 Builder패턴에 사용될 맴버변수에 대해서는 따로 지정하고 있음 ( id를 제외하고는 )
	 *  클래스 레벨에서 @Builder를 선언했을 때, 롬복에서 어떻게 Builder패턴을 만들어 주는지 살펴볼 필요가 있다!
	 */
	@Builder
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
}
