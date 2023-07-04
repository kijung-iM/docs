WhaTap 'spring-r2dbc-mysql-miku' Plugin
==============================================

Welcome to the WhaTap 'spring-r2dbc-mysql-miku' Plugin of the WhaTap APM project.

와탭 APM을 위한 와탭랩스 'spring-r2dbc-mysql-miku' 플러그인 입니다


Current Version
---------------

Current Release as of 3-May-2023 is v0.1.

현재 버전 v0.1 은 2023년 5월 3일 배포된 버전 입니다.

whatap-spring-r2dbc-mysql-miku-0.8.2-v0.1 (3-May-2023)


Release Note
------------

## v0.1

Release on: 2023-05-03

Init release


Note
----

> Requires following plugins
> 
> dev.miku-0.8.2.RELEASE, spring-boot-starter-data-r2dbc 

> 다음 플러그인과 같이 사용해야 합니다.
> 
> - whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar 


How to
------

add whatap-xxx.jar file to instrument folder

Search for a matching version [here](#spring-boot-and-whatap-java-plugin-compatibility).

whatap.conf 파일이 있는 폴더의 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot-starter-data-r2dbc 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-java-plugin-compatibility)에서 확인할 수 있습니다.


## spring-boot-and-whatap-java-plugin-compatibility

Compatibility between ``spring boot`` and ``whatap spring boot starter data r2dbc`` Plugin. ([compatibility table](#spring-boot-dependency))

각 spring boot 버전과 whatap spring boot starter data r2dbc 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))


### spring-boot-starter-parent-3.0.x

---
    spring-boot-starter-parent-3.0.x
        whatap-spring-r2dbc-mysql-miku-0.8.2-v0.1.jar
---


## spring-boot-dependency

Spring-Boot dependency relations (Spring-Boot version : spring data r2dbc)

스프링부트 의존성 관계 정리 (spring-boot 버전 : 매핑된 spring-boot-starter-data-r2dbc 버전)


### spring-boot-starter-parent-3.0.x

---
spring-boot-starter-parent-3.0.1
> whatap-spring-r2dbc-mysql-miku-0.8.2-v0.1.jar
* spring-boot-starter-parent-3.0.0
  * r2dbc-pool-1.0.0.RELEASE.jar
  * r2dbc-spi-1.0.0.RELEASE.jar
  * spring-data-r2dbc-3.0.0.jar
  * spring-r2dbc-6.0.3.jar
  
----

spring-boot-starter-parent-3.0.0
> whatap-spring-r2dbc-mysql-miku-0.8.2-v0.1.jar
* spring-boot-starter-parent-3.0.0
  * r2dbc-pool-1.0.0.RELEASE.jar
  * r2dbc-spi-1.0.0.RELEASE.jar
  * spring-data-r2dbc-3.0.0.jar
  * spring-r2dbc-6.0.2.jar
---



### spring-boot-starter-parent-2.7.x

---
spring-boot-starter-parent-2.7.7
> whatap-spring-r2dbc-mysql-miku-0.8.2-v0.1.jar
* spring-boot-starter-parent-2.7.7
  * r2dbc-pool-0.9.2.RELEASE.jar
  * r2dbc-spi-0.9.1.RELEASE.jar
  * spring-data-r2dbc-1.5.6.jar
  * spring-r2dbc-5.3.24.jar

----

spring-boot-starter-parent-2.7.6
> whatap-spring-r2dbc-mysql-miku-0.8.2-v0.1.jar
* spring-boot-starter-parent-2.7.6
  * r2dbc-pool-0.9.2.RELEASE.jar
  * r2dbc-spi-0.9.1.RELEASE.jar
  * spring-data-r2dbc-1.5.6.jar
  * spring-r2dbc-5.3.24.jar
---