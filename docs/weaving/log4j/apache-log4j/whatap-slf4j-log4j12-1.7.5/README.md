---
title: WhaTap 'slf4j-log4j12' Plugin
---

Welcome to the WhaTap 'slf4j-log4j12' plugin of the WhaTap APM project.

와탭랩스의 자바 어플리케이션 모니터링을 위한 'slf4j-log4j12' 플러그인 입니다.

Current Version
---------------

Current Release as of 1-December-2021 is v1.

현재 버전 v1 은 2021년 12월 1일 배포된 버전 입니다.

whatap-slf4j-log4j12-1.7.5-v1.jar (1-December-2021) [v1]

:::note

compatible with whatap java agent version 2.1.x. ``whatap.agent-2.1.x.jar``

와탭 자바 에이전트 2.1.x 이상의 버전에서 사용할 수 있습니다.

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

| configuration          | default | explanation                                                                      |
| ---------------------- | :-----: | :------------------------------------------------------------------------------- |
| logsink_enabled        | false   | enable or disable log monitoring                                                 |
| hooklog_log4j_enabled  | false   | enable or disable log4j monitoring <br/> 'false' if you intend to use this plugin |

### whatap.conf{#whatapconf-kor}

| 에이전트 설정             | 초기값    | 설명                                                                                    |
| ---------------------- | :---- : | :------------------------------------------------------------------------------------- |
| logsink_enabled        | false   | 로그 모니터링 기능 사용 여부                                                                  |
| hooklog_log4j_enabled  | false   | log4j 라이브러리를 사용하는 로그 모니터링 기능 사용 여부 <br/> 해당 플러그인을 사용하기 위해서는 'false' 입력 |

```ini title='whatap.conf'
###### whatap log monitoring - log4j ######
logsink_enabled=true
hooklog_log4j_enabled=false
###########################################
```

## slf4j-log4j12 and whatap-slf4j-log4j12-plugin Compatibility

Compatibility between slf4j-log4j12 and whatap-slf4j-log4j12 plugin.

각 slf4j-log4j12 버전과 whatap-slf4j-log4j12 플러그인의 의존 관계 확인할 수 있습니다.

### slf4j-log4j12-1.7.5
>
> whatap-slf4j-log4j12-1.7.5-v1.jar

* slf4j-log4j12-1.7.5
* slf4j-api-1.7.5
