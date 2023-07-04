---
title: whatap-spring-boot-websocket-stomp-messaging-1.5.6 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-spring-boot-websocket-stomp-messaging-1.5.6 플러그인 입니다

## Current Version

---

현재 버전은 2022년 11월 15일 배포된 버전 입니다. [v1.1]

whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1 (15-Nov-2022) [v1.1]

## Release Note

---

## v1.1

Release on: 2022-11-15

### Update

응답시간을 System.nanoTime()으로 측정할 수 있도록 수정하였습니다.

whatap-weaving-api 의존성을 2.1.0에서 2.1.1로 수정하였습니다.

## v1

Release on: 2021-10-29

Init release

:::note

와탭 자바 에이전트 2.1.x 이상의 버전에서 사용할 수 있습니다.

spring-boot-1.5.6.RELEASE 버전부터 spring-boot-2.5.6 까지 추적합니다.

:::

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot 버전과 와탭의 whatap-spring-boot-websocket-stomp-messaging 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-spring-boot-websocket-stomp-messaging-plugin-compatibility)에서 확인할 수 있습니다.

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf)에서 확인할 수 있습니다.

## Configuration

---

| 에이전트 설정                | 초기값              | 설명                                          |
| ------------------------- | :---------------: | :------------------------------------------- |
| websocket_trace_enabled   | false             |  추적 활성화                                    |
| websocket_profile_enabled | false             |  트랜잭션 데이터 수집 활성화                        |
| websocket_basetime        | 100               |  소요시간이 websocket_basetime 을 넘는 경우에 트랜잭션 데이터 수집 |
| websocket_step_title      | websocket_stomp   |  수집한 데이터의 메세지 이름 설정                    |
| websocket_trace_exception | true              |  플러그인의 예외 상황에 대한 데이터 수집               |

### whatap.conf

```ini title='whatap.conf'
########## websocket options ##########
websocket_trace_enabled=true
websocket_profile_enabled=true
websocket_basetime=50
websocket_step_title=[websocket]
websocket_trace_exception=true
#######################################
```

## Spring Boot and whatap-spring-boot-websocket-stomp-messaging-plugin Compatibility

---

각 spring boot 버전과 whatap-spring-boot-websocket-stomp-messaging 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))

### spring-boot-starter-parent-2.5.x

---
    spring-boot-starter-parent-2.5.x
        whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar
---

### spring-boot-starter-parent-2.4.x

---
    spring-boot-starter-parent-2.4.x
        whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar
---

### spring-boot-starter-parent-2.3.x.RELEASE

---
    spring-boot-starter-parent-2.3.x.RELEASE
        whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar
---

### spring-boot-starter-parent-2.2.x.RELEASE

---
    spring-boot-starter-parent-2.2.x.RELEASE
        whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar
---

...

### spring-boot-starter-parent-1.5.x.RELEASE

---
    spring-boot-starter-parent-1.5.x.RELEASE
        whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar
---

## Spring Boot and spring-websocket, spring-messaging Compatibility

---

각 spring boot 버전과 spring-websocket, spring-messaging 의 의존관계를 확인할 수 있습니다.

## spring-boot-dependency

---

### spring-boot-2.5.x

---

#### spring-boot-starter-parent-2.5.6

* spring-boot-starter-websocket-2.5.6

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.12.jar
* spring-messaging-5.3.12.jar

#### spring-boot-starter-parent-2.5.5

* spring-boot-starter-websocket-2.5.5

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.10.jar
* spring-messaging-5.3.10.jar

#### spring-boot-starter-parent-2.5.4

* spring-boot-starter-websocket-2.5.4

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.9.jar
* spring-messaging-5.3.9.jar

#### spring-boot-starter-parent-2.5.3

* spring-boot-starter-websocket-2.5.3

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.9.jar
* spring-messaging-5.3.9.jar

#### spring-boot-starter-parent-2.5.2

* spring-boot-starter-websocket-2.5.2

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.8.jar
* spring-messaging-5.3.8.jar

#### spring-boot-starter-parent-2.5.1

* spring-boot-starter-websocket-2.5.1

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.8.jar
* spring-messaging-5.3.8.jar

#### spring-boot-starter-parent-2.5.0

* spring-boot-starter-websocket-2.5.0

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.7.jar
* spring-messaging-5.3.7.jar

### spring-boot-2.4.x

---

#### spring-boot-starter-parent-2.4.12

* spring-boot-starter-websocket-2.4.12

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.12.jar
* spring-messaging-5.3.12.jar

#### spring-boot-starter-parent-2.4.11

* spring-boot-starter-websocket-2.4.11

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.10.jar
* spring-messaging-5.3.10.jar

#### spring-boot-starter-parent-2.4.10

* spring-boot-starter-websocket-2.4.10

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.9.jar
* spring-messaging-5.3.9.jar

#### spring-boot-starter-parent-2.4.9

* spring-boot-starter-websocket-2.4.9

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.9.jar
* spring-messaging-5.3.9.jar

#### spring-boot-starter-parent-2.4.8

* spring-boot-starter-websocket-2.4.8

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.8.jar
* spring-messaging-5.3.8.jar

#### spring-boot-starter-parent-2.4.7

* spring-boot-starter-websocket-2.4.7

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.8.jar
* spring-messaging-5.3.8.jar

#### spring-boot-starter-parent-2.4.6

* spring-boot-starter-websocket-2.4.6

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.7.jar
* spring-messaging-5.3.7.jar

#### spring-boot-starter-parent-2.4.5

* spring-boot-starter-websocket-2.4.5

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.6.jar
* spring-messaging-5.3.6.jar

#### spring-boot-starter-parent-2.4.4

* spring-boot-starter-websocket-2.4.4

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.5.jar
* spring-messaging-5.3.5.jar

#### spring-boot-starter-parent-2.4.3

* spring-boot-starter-websocket-2.4.3

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.4.jar
* spring-messaging-5.3.4.jar

#### spring-boot-starter-parent-2.4.2

* spring-boot-starter-websocket-2.4.2

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.3.jar
* spring-messaging-5.3.3.jar

#### spring-boot-starter-parent-2.4.1

* spring-boot-starter-websocket-2.4.1

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.2.jar
* spring-messaging-5.3.2.jar

#### spring-boot-starter-parent-2.4.0

* spring-boot-starter-websocket-2.4.0

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.3.1.jar
* spring-messaging-5.3.1.jar

### spring-boot-2.3.x.RELEASE

---

#### spring-boot-starter-parent-2.3.12.RELEASE

* spring-boot-starter-websocket-2.3.12.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.15.RELEASE.jar
* spring-messaging-5.2.15.RELEASE.jar

#### spring-boot-starter-parent-2.3.11.RELEASE

* spring-boot-starter-websocket-2.3.11.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.15.RELEASE.jar
* spring-messaging-5.2.15.RELEASE.jar

#### spring-boot-starter-parent-2.3.10.RELEASE

* spring-boot-starter-websocket-2.3.10.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.14.RELEASE.jar
* spring-messaging-5.2.14.RELEASE.jar

#### spring-boot-starter-parent-2.3.9.RELEASE

* spring-boot-starter-websocket-2.3.9.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.13.RELEASE.jar
* spring-messaging-5.2.13.RELEASE.jar

#### spring-boot-starter-parent-2.3.8.RELEASE

* spring-boot-starter-websocket-2.3.8.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.12.RELEASE.jar
* spring-messaging-5.2.12.RELEASE.jar

#### spring-boot-starter-parent-2.3.7.RELEASE

* spring-boot-starter-websocket-2.3.7.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.12.RELEASE.jar
* spring-messaging-5.2.12.RELEASE.jar

#### spring-boot-starter-parent-2.3.6.RELEASE

* spring-boot-starter-websocket-2.3.6.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.11.RELEASE.jar
* spring-messaging-5.2.11.RELEASE.jar

#### spring-boot-starter-parent-2.3.5.RELEASE

* spring-boot-starter-websocket-2.3.5.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.10.RELEASE.jar
* spring-messaging-5.2.10.RELEASE.jar

#### spring-boot-starter-parent-2.3.4.RELEASE

* spring-boot-starter-websocket-2.3.4.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.9.RELEASE.jar
* spring-messaging-5.2.9.RELEASE.jar

#### spring-boot-starter-parent-2.3.3.RELEASE

* spring-boot-starter-websocket-2.3.3.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.8.RELEASE.jar
* spring-messaging-5.2.8.RELEASE.jar

#### spring-boot-starter-parent-2.3.2.RELEASE

* spring-boot-starter-websocket-2.3.2.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.8.RELEASE.jar
* spring-messaging-5.2.8.RELEASE.jar

#### spring-boot-starter-parent-2.3.1.RELEASE

* spring-boot-starter-websocket-2.3.1.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.7.RELEASE.jar
* spring-messaging-5.2.7.RELEASE.jar

#### spring-boot-starter-parent-2.3.0.RELEASE

* spring-boot-starter-websocket-2.3.0.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.6.RELEASE.jar
* spring-messaging-5.2.6.RELEASE.jar

### spring-boot-2.2.x.RELEASE

---

#### spring-boot-starter-parent-2.2.13.RELEASE

* spring-boot-starter-websocket-2.2.13.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.12.RELEASE.jar
* spring-messaging-5.2.12.RELEASE.jar

#### spring-boot-starter-parent-2.2.12.RELEASE

* spring-boot-starter-websocket-2.2.12.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.12.RELEASE.jar
* spring-messaging-5.2.12.RELEASE.jar

#### spring-boot-starter-parent-2.2.11.RELEASE

* spring-boot-starter-websocket-2.2.11.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.10.RELEASE.jar
* spring-messaging-5.2.10.RELEASE.jar

#### spring-boot-starter-parent-2.2.10.RELEASE

* spring-boot-starter-websocket-2.2.10.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.9.RELEASE.jar
* spring-messaging-5.2.9.RELEASE.jar

#### spring-boot-starter-parent-2.2.9.RELEASE

* spring-boot-starter-websocket-2.2.9.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.8.RELEASE.jar
* spring-messaging-5.2.8.RELEASE.jar

#### spring-boot-starter-parent-2.2.8.RELEASE

* spring-boot-starter-websocket-2.2.8.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.7.RELEASE.jar
* spring-messaging-5.2.7.RELEASE.jar

#### spring-boot-starter-parent-2.2.7.RELEASE

* spring-boot-starter-websocket-2.2.7.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.6.RELEASE.jar
* spring-messaging-5.2.6.RELEASE.jar

#### spring-boot-starter-parent-2.2.6.RELEASE

* spring-boot-starter-websocket-2.2.6.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.5.RELEASE.jar
* spring-messaging-5.2.5.RELEASE.jar

#### spring-boot-starter-parent-2.2.5.RELEASE

* spring-boot-starter-websocket-2.2.5.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.4.RELEASE.jar
* spring-messaging-5.2.4.RELEASE.jar

#### spring-boot-starter-parent-2.2.4.RELEASE

* spring-boot-starter-websocket-2.2.4.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.3.RELEASE.jar
* spring-messaging-5.2.3.RELEASE.jar

#### spring-boot-starter-parent-2.2.3.RELEASE

* spring-boot-starter-websocket-2.2.3.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.3.RELEASE.jar
* spring-messaging-5.2.3.RELEASE.jar

#### spring-boot-starter-parent-2.2.2.RELEASE

* spring-boot-starter-websocket-2.2.2.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.2.RELEASE.jar
* spring-messaging-5.2.2.RELEASE.jar

#### spring-boot-starter-parent-2.2.1.RELEASE

* spring-boot-starter-websocket-2.2.1.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.1.RELEASE.jar
* spring-messaging-5.2.1.RELEASE.jar

#### spring-boot-starter-parent-2.2.0.RELEASE

* spring-boot-starter-websocket-2.2.0.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-5.2.0.RELEASE.jar
* spring-messaging-5.2.0.RELEASE.jar

### spring-boot-1.5.x.RELEASE

---

#### spring-boot-starter-parent-1.5.12.RELEASE

* spring-boot-starter-websocket-1.5.12.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-4.3.16.RELEASE.jar
* spring-messaging-4.3.16.RELEASE.jar

#### spring-boot-starter-parent-1.5.6.RELEASE

* spring-boot-starter-websocket-1.5.6.RELEASE

> whatap-spring-boot-websocket-stomp-messaging-1.5.6-v1.1.jar

* spring-websocket-4.3.10.RELEASE.jar
* spring-messaging-4.3.10.RELEASE.jar
