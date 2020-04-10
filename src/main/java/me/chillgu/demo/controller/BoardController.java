package me.chillgu.demo.controller;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *  클래스 레벨에서 Validated를 선언함.
 */
@RestController
@Validated
public class BoardController {
	
	/*
	 *  @PathVariable -> 원하는 타입으로 converting 해줌!
	 *  분명 urlpath로 오는 데이터는 String -> Long
	 *  
	 */
	@GetMapping("/boards/{idx}")
	public String getBoardByPathVariable(@PathVariable("idx") @NotNull Long idx) {
		
		return "book";
	}
	
	/*
	 *  @NotNull vs final
	 *  final로 파라미터 변수를 선언해도 되지 않는가? 둘의 차이점은?
	 *  뭔가 @Validated + @NotNull 조합은 요청으로부터 넘어오는 값에 대한 유효성 검사가 가능하다는 측면!
	 *  근데 final도 마찬가지일텐데...
	 *  
	 */
	@GetMapping("/boards")
	public String getBoardByRequestParam(@RequestParam("idx") final Long idx) {
		
		return "book";
	}
}
