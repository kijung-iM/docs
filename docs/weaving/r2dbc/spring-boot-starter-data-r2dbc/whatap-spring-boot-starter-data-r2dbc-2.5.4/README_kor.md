와탭랩스 'Spring Boot Starter Data R2dbc' 플러그인
==============================================

와탭 APM을 위한 와탭랩스 spring boot starter data r2dbc 플러그인 입니다


플러그인 현재 버전
--------------

현재 버전 v1 은 2021년 8월 31일 배포된 버전 입니다.

whatap-spring-boot-starter-data-r2dbc-2.5.4-v1 (31-August-2021)


주의사항
------

> 다음 플러그인과 같이 사용해야 합니다.
> 
> - whatap-spring-boot-starter-webflux-2.2.0-v1.jar 


적용방법
------

whatap.conf 파일이 있는 폴더의 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot-starter-data-r2dbc 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-java-plugin-compatibility)에서 확인할 수 있습니다.


## spring-boot-and-whatap-java-plugin-compatibility

각 ``spring-boot`` 버전과 ``whatap-spring-boot-starter-data-r2dbc`` 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))


### spring-boot-starter-parent-2.5.x

---
    spring-boot-starter-parent-2.5.4
        whatap-spring-boot-starter-data-r2dbc-2.5.4-v1.jar
---

## spring-boot-dependency

스프링부트 의존성 관계 정리 (spring-boot 버전 : 매핑된 spring-boot-starter-data-r2dbc 버전)

### spring-boot-starter-parent-2.5.x

---
spring-boot-starter-parent-2.5.4
> whatap-spring-boot-starter-data-r2dbc-2.5.4-v1.jar
* spring-boot-starter-parent-2.5.4
  * spring-data-r2dbc-1.3.4.jar
---

