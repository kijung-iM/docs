WhaTap 'spring boot log4j2' Plugin
==================================

Welcome to the WhaTap 'spring log4j2' plugin of the WhaTap APM project.

와탭랩스의 자바 어플리케이션 모니터링을 위한 'spring log4j2' 플러그인 입니다.


Current Version
---------------

Current Release as of 24-November-2021 is v1.

현재 버전 v1 은 2021년 11월 24일 배포된 버전 입니다.

whatap-spring-boot-starter-log4j2-2.1.3-v1.jar (24-November-2021) [v1]


Note
----

compatible with whatap java agent version 2.1.x. ``whatap.agent-2.1.x.jar``

covers from `spring-boot-2.1.3.RELEASE` to `spring-boot-2.6.0`

와탭 자바 에이전트 2.1.x 이상의 버전에서 사용할 수 있습니다.

`spring-boot-2.1.3.RELEASE` 버전부터 `spring-boot-2.6.0` 까지 추적합니다.


How to
------

add .jar file to instrument folder

Search for a matching version [here](#spring-boot-and-whatap-spring-boot-starter-log4j2-plugin-compatibility).

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot 버전과 와탭의 whatap-spring-boot-starter-log4j2 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-spring-boot-starter-log4j2-plugin-compatibility)에서 확인할 수 있습니다.

Enable plugin by adding configurations in whatap.conf file. Look at configuration example [here](#whatapconf-eng).

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf-kor)에서 확인할 수 있습니다.


Plugin Configuration
--------------------

### whatap.conf

| configuration          | default | explanation                                                                      |
| ---------------------- | :-----: | :------------------------------------------------------------------------------- |
| logsink_enabled        | false   | enable or disable log monitoring                                                 |
| hooklog_log4j_enabled  | false   | enable or disable log4j monitoring <br/> 'false' if you intend to use this plugin |


### whatap.conf

| 에이전트 설정             | 초기값    | 설명                                                                                    |
| ---------------------- | :-----: | :------------------------------------------------------------------------------------- |
| logsink_enabled        | false   | 로그 모니터링 기능 사용 여부                                                                  |
| hooklog_log4j_enabled  | false   | log4j 라이브러리를 사용하는 로그 모니터링 기능 사용 여부 <br/> 해당 플러그인을 사용하기 위해서는 'false' 입력 |


[ whatap.conf ]
```
###### whatap log monitoring - log4j ######
logsink_enabled=true
hooklog_log4j_enabled=false
###########################################
```

## Spring Boot and whatap-spring-boot-starter-log4j2-plugin Compatibility

Compatibility between Spring Boot and whatap-spring-boot-starter-log4j2 plugin. ([compatibility table](#spring-boot-dependency))

각 spring boot 버전과 whatap-spring-boot-starter-log4j2 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))


### spring-boot-starter-parent-2.6.x

---
    spring-boot-starter-parent-2.6.x
        whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
---


### spring-boot-starter-parent-2.5.x

---
    spring-boot-starter-parent-2.5.x
        whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
---


### spring-boot-starter-parent-2.4.x

---
    spring-boot-starter-parent-2.4.x
        whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
---


### spring-boot-starter-parent-2.3.x.RELEASE

---
    spring-boot-starter-parent-2.3.x.RELEASE
        whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
---


### spring-boot-starter-parent-2.2.x.RELEASE

---
    spring-boot-starter-parent-2.2.x.RELEASE
        whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
---


### spring-boot-starter-parent-2.1.3.RELEASE ~ 2.1.18.RELEASE

---
    spring-boot-starter-parent-2.1.3.RELEASE ~ 2.1.18.RELEASE
        whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
---


### spring-boot-starter-parent-2.1.0.RELEASE ~ 2.1.2.RELEASE

---
    spring-boot-starter-parent-2.1.0.RELEASE ~ 2.1.2.RELEASE
        whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
---


### spring-boot-starter-parent-2.0.x.RELEASE

---
    spring-boot-starter-parent-2.0.x.RELEASE
        whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
---


### spring-boot-starter-parent-1.5.x.RELEASE

---
    spring-boot-starter-parent-1.5.x.RELEASE
        whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
---


## Spring Boot and spring-boot-starter-log4j2, log4j-core, log4j-api Compatibility

Compatibility between spring-boot-starter-log4j2, log4j-core, log4j-api compatibility

각 spring boot 버전과 spring-boot-starter-log4j2, log4j-core, log4j-api 의 의존관계를 확인할 수 있습니다.


## spring-boot-dependency
### spring-boot-2.6.x
#### spring-boot-starter-parent-2.6.3 (Log4JShell Situation - 2021. 12. 10)
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.6.3
  * log4j-api-2.17.1
  * log4j-core-2.17.1


#### spring-boot-starter-parent-2.6.2 (Log4JShell Situation - 2021. 12. 10)
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.6.2
  * log4j-api-2.17.0
  * log4j-core-2.17.0

  
#### spring-boot-starter-parent-2.6.1
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.6.1
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.6.0
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.6.0
  * log4j-api-2.14.1
  * log4j-core-2.14.1


### spring-boot-2.5.x
#### spring-boot-starter-parent-2.5.7
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.7
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.6
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.6
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.5
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.5
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.4
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.4
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.3
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.3
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.2
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.2
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.1
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.1
  * log4j-api-2.14.1
  * log4j-core-2.14.1


#### spring-boot-starter-parent-2.5.0
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.5.0
  * log4j-api-2.14.1
  * log4j-core-2.14.1


### spring-boot-2.4.x
#### spring-boot-starter-parent-2.4.13
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.13
  * log4j-api-2.13.3
  * log4j-core-2.13.3

  
#### spring-boot-starter-parent-2.4.12
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.12
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.11
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.11
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.10
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.10
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.9
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.9
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.8
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.8
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.7
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.7
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.6
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.6
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.5
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.5
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.4
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.4
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.3
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.3
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.2
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.2
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.1
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.1
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.4.0
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.4.0
  * log4j-api-2.13.3
  * log4j-core-2.13.3


### spring-boot-2.3.x.RELEASE
#### spring-boot-starter-parent-2.3.12.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.12.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.11.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.11.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.10.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.10.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.9.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.9.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.8.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.8.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.7.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.7.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.6.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.6.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.5.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.5.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.4.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.4.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.3.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.3.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.2.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.2.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.1.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.1.RELEASE
  * log4j-api-2.13.3
  * log4j-core-2.13.3


#### spring-boot-starter-parent-2.3.0.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.3.0.RELEASE
  * log4j-api-2.13.2
  * log4j-core-2.13.2


### spring-boot-2.2.x.RELEASE
#### spring-boot-starter-parent-2.2.13.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.13.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.12.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.12.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.11.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.11.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.10.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.10.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.9.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.9.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.8.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.8.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.7.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.7.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.6.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.6.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.5.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.5.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.4.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.4.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.3.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.3.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.2.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.2.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.1.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.1.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


#### spring-boot-starter-parent-2.2.0.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.2.0.RELEASE
  * log4j-api-2.12.1
  * log4j-core-2.12.1


### spring-boot-2.1.x.RELEASE
#### spring-boot-starter-parent-2.1.18.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.18.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.17.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.17.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.16.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.16.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.15.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.15.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.14.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.14.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.13.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.13.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.12.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.12.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.11.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.11.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.10.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.10.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.9.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.9.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.8.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.8.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.7.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.7.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.6.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.6.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.5.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.5.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.4.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.4.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.3.RELEASE
> whatap-spring-boot-starter-log4j2-2.1.3-v1.jar
* spring-boot-starter-log4j2-2.1.3.RELEASE
  * log4j-api-2.11.2
  * log4j-core-2.11.2


#### spring-boot-starter-parent-2.1.2.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.1.2.RELEASE
  * log4j-api-2.11.1
  * log4j-core-2.11.1


#### spring-boot-starter-parent-2.1.1.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.1.1.RELEASE
  * log4j-api-2.11.1
  * log4j-core-2.11.1


#### spring-boot-starter-parent-2.1.0.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.1.0.RELEASE
  * log4j-api-2.11.1
  * log4j-core-2.11.1


### spring-boot-2.0.x.RELEASE
#### spring-boot-starter-parent-2.0.9.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.9.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.8.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.8.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.7.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.7.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.6.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.6.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.5.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.5.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.4.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.4.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.3.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.3.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.2.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.2.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.1.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.1.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


#### spring-boot-starter-parent-2.0.0.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-2.0.0.RELEASE
  * log4j-api-2.10.0
  * log4j-core-2.10.0


### spring-boot-1.5.x.RELEASE
#### spring-boot-starter-parent-1.5.22.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.22.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.21.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.21.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.20.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.20.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.19.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.19.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.18.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.18.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.17.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.17.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.16.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.16.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.15.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.15.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.14.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.14.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.13.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.13.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.12.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.12.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.11.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.11.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.10.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.10.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.9.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.9.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.8.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.8.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.7.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.7.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.6.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.6.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.5.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.5.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.4.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.4.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.3.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.3.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.2.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.2.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.1.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.1.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


#### spring-boot-starter-parent-1.5.0.RELEASE
> whatap-spring-boot-starter-log4j2-1.5.0-v1.jar
* spring-boot-starter-log4j2-1.5.0.RELEASE
  * log4j-api-2.7
  * log4j-core-2.7


