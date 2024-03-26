# Spring Cloud Gateway

### 요약
* Spring Cloud Gateway 와 Webflux를 활용하여 예제코드를 작성하였습니다.

### 게이트웨이 요구사항
1. 특정 Path로 요청이 왔을때는 redirect 하기
   - localhost:8888/google/{argument1}/{argument2} 호출 시, https://www.google.com/{argument2} 리다이렉트
2. Filter를 활용한 인증, 인가 처리
   - AuthGatewayFilterFactory
   - CustomGlobalFilter
3. 프록시 역할의 webflux를 활용한 controller
   - PATH : localhost:8888/content
   - https://dummyjson.com 와 https://jsonplaceholder.typicode.com 응답 맵핑
   - @ReactiveFeignClient 사용
4. Swagger UI 제공
   - http://localhost:8888/webjars/swagger-ui/index.html#/
   - Open API Spec 파일로 Docs 작성