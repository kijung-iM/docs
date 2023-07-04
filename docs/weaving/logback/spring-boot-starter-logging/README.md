WhaTap 'spring boot starter logging' Plugin
==================================

Welcome to the WhaTap 'spring boot starter logging' plugin of the WhaTap APM project.

와탭랩스의 자바 어플리케이션 모니터링을 위한 'spring boot starter logging' 플러그인 입니다.


Current Version
---------------

Current Release as of 18-January-2022 is v1.

현재 버전 v1 은 2022년 1월 18일 배포된 버전 입니다.

whatap-spring-boot-starter-logging-2.6.2-v1.jar (18-January-2022) [v1]


Note
----

compatible with whatap java agent version v2.1.1-20220112d. ``whatap.agent-2.1.1.jar``

covers spring-boot versions which includes logback-core-1.2.9 or later.

covers from `spring-boot-2.5.8` to `spring-boot-2.6.3`.

와탭 자바 에이전트 2.1.1-20220112d 이상의 버전에서 사용할 수 있습니다.

logback-core-1.2.9 또는 그 이후의 버전을 포함한 spring-boot 를 추적합니다.

`spring-boot-2.5.8` 버전부터 `spring-boot-2.6.3` 까지 추적합니다.


How to
------

add .jar file to instrument folder

Search for a matching version [here](#spring-boot-and-whatap-spring-boot-starter-logging-plugin-compatibility).

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot 버전과 와탭의 whatap-spring-boot-starter-logging 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-spring-boot-starter-logging-plugin-compatibility)에서 확인할 수 있습니다.

Enable plugin by adding configurations in whatap.conf file. Look at configuration example [here](#whatapconf-eng).

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf-kor)에서 확인할 수 있습니다.


Plugin Configuration
--------------------

### whatap.conf (eng)

| configuration        | default | explanation                      |
| -------------------- | :-----: | :------------------------------- |
| logsink_enabled      | false   | enable or disable log monitoring |
| logback_stack_depth  | 50      | depth of error stack |


### whatap.conf (kor)

| 에이전트 설정             | 초기값    | 설명                                               |
| ---------------------- | :-----: | :------------------------------------------------ |
| logsink_enabled        | false   | 로그 모니터링 기능 사용 여부                             |
| logback_stack_depth    | 50      | 에러 발생시 수집하는 기본 stack 길이 <br/> 0 이상의 숫자 입력 |


[ whatap.conf ]
```
###### whatap log monitoring - logback ####
logsink_enabled=true
logback_stack_depth=50
###########################################
```

## Spring Boot and whatap-spring-boot-starter-logging-plugin Compatibility

Compatibility between Spring Boot and whatap-spring-boot-starter-logging plugin. ([compatibility table](#spring-boot-dependency))

각 spring boot 버전과 whatap-spring-boot-starter-logging 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))


### spring-boot-starter-parent-2.6.2 ~

---
    spring-boot-starter-parent-2.6.2
        whatap-spring-boot-starter-logging-2.6.2-v1.jar
---


### spring-boot-starter-parent-2.5.8 ~ 

---
    spring-boot-starter-parent-2.5.8
        whatap-spring-boot-starter-logging-2.6.2-v1.jar
---


## Spring Boot and spring-boot-starter-logging Compatibility

Compatibility between spring-boot-starter-logging and logback-core, logback-classic compatibility

각 spring boot 버전과 spring-boot-starter-logging 의 의존관계를 확인할 수 있습니다.


## spring-boot-dependency
### spring-boot-2.6.x
#### spring-boot-starter-parent-2.6.3
> whatap-spring-boot-starter-logging-2.6.2-v1.jar
* spring-boot-starter-logging-2.6.3
  * logback-classic-1.2.10
  * logback-core-1.2.10


#### spring-boot-starter-parent-2.6.2
> whatap-spring-boot-starter-logging-2.6.2-v1.jar
* spring-boot-starter-logging-2.6.2
  * logback-classic-1.2.9
  * logback-core-1.2.9
  

### spring-boot-2.5.x
#### spring-boot-starter-parent-2.5.9
> whatap-spring-boot-starter-logging-2.6.2-v1.jar
* spring-boot-starter-logging-2.6.9
  * logback-classic-1.2.10
  * logback-core-1.2.10


#### spring-boot-starter-parent-2.5.8
> whatap-spring-boot-starter-logging-2.6.2-v1.jar
* spring-boot-starter-logging-2.6.2
  * logback-classic-1.2.9
  * logback-core-1.2.9

