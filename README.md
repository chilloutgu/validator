# validator <br />

로그인 폼으로부터 넘어오는 로그인 정보를 검증해 보도록 하자. <br />
0. /login & POST 매서드로 서버에 요청한다. <br />
1. 로그인 정보( 파라미터 값 ) 는 LoginForm 객체가 받는다.  <br />
2. LoginForm 맴버변수에 다양한 어노테이션으로 제약조건을 설정한다. <br />
3. 넘어온 로그인 정보가 LoginFOrm 객체에 바인딩 될 때 validator를 통해 유효성 검사를 하도록 한다.<br />
4. 바인딩 시 에러가 날 경우, 에러는 BindingResult 객체에 바인딩되도록 한다. <br />
5. BindingResult 객체로부터 에러메세지를 출력한다. <br />
6. 로그인 폼 페이지로 redirect 시킨다. <br />
7. 유효한 값이 넘어와 바인딩이 정상적으로 진행된 경우, 해당 LoginForm 객체는 User 엔티티로 컨버팅해준다. <br />
8. User 엔티티는 JpaRepository에 의해 database에 저장된다. <br />
9. User 엔티티 또한 database에 저장될 때의 제약조건을 설정한다. <br />
10. 마지막으로 @PathVariable 또는 @RequestParam으로 넘어온 값에 대한 유효성 검사도 테스트해보도록 하자. ( @Validated 어노테이션으로 ) <br />
11. 커스텀어노테이션으로 유효성 검사도 가능하지만 그건 나중에...
