---
title: WhaTap 'apache logging log4j' Plugin
---

Welcome to the WhaTap 'apache logging log4j' plugin of the WhaTap APM project.

와탭랩스의 자바 어플리케이션 모니터링을 위한 'apache logging log4j' 플러그인 입니다.

Current Version
---------------

Current Release as of 12-January-2022 is v1.

현재 버전 v1 은 2022년 1월 12일 배포된 버전 입니다.

whatap-apache-logging-log4j-2.17.1-v1.jar (11-January-2022) [v1]

:::note

compatible with whatap java agent version v2.1.1-20220112d ``whatap.agent-2.1.1.jar``

와탭 자바 에이전트 v2.1.1-20220112d 이후의 버전에서 사용할 수 있습니다.

:::

How to
------

add .jar file to instrument folder

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

Enable plugin by adding configurations in whatap.conf file. Look at configuration example [here](#whatapconf-eng).

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf-kor)에서 확인할 수 있습니다.

Plugin Configuration
--------------------

### whatap.conf{#whatapconf-eng}

| configuration       | default | explanation                      |
| ------------------- | :-----: | :------------------------------- |
| logsink_enabled     | false   | enable or disable log monitoring |
| log4j2_stack_depth  | 50      | decide depth of stack to print   |

### whatap.conf{#whatapconf-kor}

| 에이전트 설정          | 초기값    | 설명                     |
| ------------------- | :-----: | :---------------------- |
| logsink_enabled     | false   | 로그 모니터링 기능 사용 여부   |
| log4j2_stack_depth  | 50      | 로그 스택 길이 지정          |

```ini title='whatap.conf'
###### whatap log monitoring - log4j ######
logsink_enabled=true
log4j2_stack_depth=24
###########################################
```

## apache-logging-log4j and whatap-apache-logging-log4j-plugin Compatibility

Compatibility between apache-logging-log4j and whatap-apache-logging-log4j plugin.

각 apache-logging-log4j 버전과 whatap-apache-logging-log4j 플러그인의 의존 관계 확인할 수 있습니다.

### apache-logging-log4j-2.14.2 ~

---
    log4j-core-2.14.2 ~
    log4j-api-2.14.2 ~
        whatap-apache-logging-log4j-2.17.1-v1.jar
---

### apache-logging-log4j-2.11.2 ~

---
    log4j-core-2.11.2 ~
    log4j-api-2.11.2 ~
        whatap-apache-logging-log4j-2.11.2-v1.jar
---

### apache-logging-log4j-2.7 ~ 2.11.1

---
    log4j-core-2.7 ~ 2.11.1
    log4j-api-2.7 ~ 2.11.1
        whatap-apache-logging-log4j-2.7-v1.jar
---
