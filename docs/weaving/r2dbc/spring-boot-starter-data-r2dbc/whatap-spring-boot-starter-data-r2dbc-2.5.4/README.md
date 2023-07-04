WhaTap 'Spring Boot Starter Data R2dbc' Plugin
==============================================

Welcome to the WhaTap 'Spring Boot Starter Data R2dbc' Plugin of the WhaTap APM project.

와탭 APM을 위한 와탭랩스 Spring Boot Starter Data R2dbc 플러그인 입니다


Current Version
---------------

Current Release as of 15-Nov-2022 is v1.1.

현재 버전 v1.1 은 2022년 11월 15일 배포된 버전 입니다.

whatap-spring-boot-starter-data-r2dbc-2.5.4-v1.1 (15-Nov-2022)


Release Note
------------

## v1.1

Release on: 2022-11-15

### Update

Updated to use System.nanoTime() when measuring elapsed time.

응답시간을 System.nanoTime()으로 측정할 수 있도록 수정하였습니다.

Updated whatap-weaving-api dependencies from 2.0.4 to 2.1.1.

whatap-weaving-api 의존성을 2.0.4에서 2.1.1로 수정하였습니다.

## v1

Release on: 2021-08-31

Init release


Note
----

> Requires following plugins
> 
> - whatap-spring-boot-starter-webflux-2.2.0-v1.4.jar 

> 다음 플러그인과 같이 사용해야 합니다.
> 
> - whatap-spring-boot-starter-webflux-2.2.0-v1.4.jar 


How to
------

add whatap-xxx.jar file to instrument folder

Search for a matching version [here](#spring-boot-and-whatap-java-plugin-compatibility).

whatap.conf 파일이 있는 폴더의 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot-starter-data-r2dbc 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-java-plugin-compatibility)에서 확인할 수 있습니다.


## spring-boot-and-whatap-java-plugin-compatibility

Compatibility between ``spring boot`` and ``whatap spring boot starter data r2dbc`` Plugin. ([compatibility table](#spring-boot-dependency))

각 spring boot 버전과 whatap spring boot starter data r2dbc 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))


### spring-boot-starter-parent-2.5.x

---
    spring-boot-starter-parent-2.5.4
        whatap-spring-boot-starter-data-r2dbc-2.5.4-v1.1.jar
---


## spring-boot-dependency

Spring-Boot dependency relations (Spring-Boot version : spring data r2dbc)

스프링부트 의존성 관계 정리 (spring-boot 버전 : 매핑된 spring-boot-starter-data-r2dbc 버전)


### spring-boot-starter-parent-2.5.x

---
spring-boot-starter-parent-2.5.4
> whatap-spring-boot-starter-data-r2dbc-2.5.4-v1.1.jar
* spring-boot-starter-parent-2.5.4
  * spring-data-r2dbc-1.3.4.jar
---
        