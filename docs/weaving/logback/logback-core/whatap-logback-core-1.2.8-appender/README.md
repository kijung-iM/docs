WhaTap 'logback-core' Plugin
==================================

Welcome to the WhaTap 'logback-core' plugin of the WhaTap APM project.

와탭랩스의 자바 어플리케이션 모니터링을 위한 'logback-core' 플러그인 입니다.


Current Version
---------------

Current Release as of 18-January-2022 is v1.

현재 버전 v1 은 2022년 1월 18일 배포된 버전 입니다.

whatap-logback-core-1.2.8-v1.jar (18-January-2022) [v1]


Note
----

compatible with whatap java agent version v2.1.1-20220112d. ``whatap.agent-2.1.1.jar``

covers from `logback-core-1.2.8` to `logback-core-1.2.10`.

와탭 자바 에이전트 2.1.1-20220112d 이후의 버전에서 사용할 수 있습니다.

`logback-core-1.2.8` 버전부터 `logback-core-1.2.10` 까지 추적합니다.


How to
------

add .jar file to instrument folder

Search for a matching version [here](#logback-core-and-whatap-logback-core-plugin-compatibility).

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

logback-core 버전과 와탭의 whatap-logback-core 플러그인 버전 관계를 [아래](#logback-core-and-whatap-logback-core-plugin-compatibility)에서 확인할 수 있습니다.

Enable plugin by adding configurations in whatap.conf file. Look at configuration example [here](#whatapconf-eng).

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf-kor)에서 확인할 수 있습니다.


Plugin Configuration
--------------------

### whatap.conf (eng)

| configuration        | default | explanation                      |
| -------------------- | :-----: | :------------------------------- |
| logsink_enabled      | false   | enable or disable log monitoring |
| logback_stack_depth  | 50      | depth of error stack             |


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


## logback-core and whatap-logback-core-plugin Compatibility

Compatibility between logback-core and whatap-logback-core plugin.

각 logback-core 버전과 whatap-logback-core 플러그인의 의존 관계를 확인할 수 있습니다.


### logback-core-1.2.8 ~

---
    log4j-core-1.2.8 ~
        whatap-logback-core-1.2.8-v1.jar
---

