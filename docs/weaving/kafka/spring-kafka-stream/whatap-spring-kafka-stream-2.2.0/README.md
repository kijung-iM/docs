---
title: WhaTap 'spring kafka stream' Plugin
---

Welcome to the WhaTap 'spring kafka stream' plugin of the WhaTap APM project.

와탭랩스의 자바 어플리케이션 모니터링을 위한 'spring kafka stream' 플러그인 입니다

Current Version
---------------

Current Release as of 16-Nov-2022 is v1.3.

현재 버전 v1.3 은 2022년 11월 16일 배포된 버전 입니다.

whatap-spring-kafka-stream-2.2.0-v1.3.jar (16-Nov-2022) [v1.3]

Release Note
------------

## v1.3

Release on: 2022-11-16

### Update

Add agent logs when header update failed.

Updated whatap-weaving-api dependencies from 2.1.0 to 2.1.1.

헤더 업데이트 실패할 경우 자바에이전트 로그 추가.

whatap-weaving-api 의존성을 2.1.0에서 2.1.1로 수정하였습니다.

## v1.2

Release on: 2022-06-28

### Update

Switched tracing from Transaction trace to HttpCall trace for multi trace.

Move transaction naming to display transaction name on error situation.

연계추적을 위하여 데이터 수집 방식을 트랜잭션에서 HttpCall 추적 방식으로 변경.

에러가 발생하더라도 트랜잭션 이름을 표시하기 위하여 이름 결정 위치를 수정.

## v1.1

Release on: 2022-06-03

### Update

Switched tracing from HttpCall trace to Transaction trace.

추적 방식 및 데이터 수집 방식을 HttpCall에서 트랜잭션 추적 방식으로 변경.

## v1

Release on: 2021-11-04

Initial release

:::note

* compatible with whatap java agent version 2.1.x. ``whatap.agent-2.1.x.jar``

* covers from `spring-boot-2.2.0.RELEASE` to `spring-boot-2.5.6`

* 와탭 자바 에이전트 2.1.x 이상의 버전에서 사용할 수 있습니다.

* `spring-boot-2.2.0.RELEASE` 버전부터 `spring-boot-2.5.6` 까지 추적합니다.

:::

How to
------

add .jar file to instrument folder

Search for a matching version [here](#spring-boot-and-whatap-spring-kafka-stream-plugin-compatibility).

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot 버전과 와탭의 whatap-spring-kafka-stream 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-spring-kafka-stream-plugin-compatibility)에서 확인할 수 있습니다.

Enable plugin by adding configurations in whatap.conf file. Look at configuration example [here](#whatapconf-eng).

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf-kor)에서 확인할 수 있습니다.

Plugin Configuration
--------------------

### whatap.conf{#whatapconf-eng}

| configuration                      | default           | explanation                                           |
| ---------------------------------- | :---------------: | :---------------------------------------------------- |
| kafka_stream_source_host           | kafka-stream      |  determine host of kafka stream Source or Publisher   |
| kafka_stream_source_port           | 0                 |  determine port of kafka stream Source or Publisher   |
| kafka_stream_source_channel_prefix | [kafka-channel]   |  determine prefix of kafka stream Source or Publisher |
| kafka_stream_sink_topic_prefix     | [topic]           |  determine topic of kafka stream sink or Consumer     |

### whatap.conf{#whatapconf-kor}

| 에이전트 설정                         | 초기값              | 설명                                                 |
| ---------------------------------- | :---------------: | :-------------------------------------------------- |
| kafka_stream_source_host           | kafka-stream      |  kafka stream 의 Source 나 Publisher 의 host 값 설정   |
| kafka_stream_source_port           | 0                 |  kafka stream 의 Source 나 Publisher 의 port 값 설정   |
| kafka_stream_source_channel_prefix | [kafka-channel]   |  kafka stream 의 Source 나 Publisher 의 prefix 값 설정 |
| kafka_stream_sink_topic_prefix     | [topic]           |  kafka stream 의 Sink 나 Consumer 의 topic 값 설정     |

```ini title='whatap.conf'
########## spring kafka stream options ##########
kafka_stream_source_host=[kafka-source]
kafka_stream_source_port=880
kafka_stream_source_channel_prefix=[channel]
kafka_stream_sink_topic_prefix=[topic]
#################################################
```

## Spring Boot and whatap-spring-kafka-stream-plugin Compatibility

Compatibility between Spring Boot and whatap-spring-kafka-stream plugin. ([compatibility table](#spring-boot-dependency))

각 spring boot 버전과 whatap-spring-kafka-stream 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))

### spring-boot-starter-parent-2.5.x

---
    spring-boot-starter-parent-2.5.x
        whatap-spring-kafka-stream-2.2.0-v1.3.jar
---

### spring-boot-starter-parent-2.4.x

---
    spring-boot-starter-parent-2.4.x
        whatap-spring-kafka-stream-2.2.0-v1.3.jar
---

### spring-boot-starter-parent-2.3.x.RELEASE

---
    spring-boot-starter-parent-2.3.x.RELEASE
        whatap-spring-kafka-stream-2.2.0-v1.3.jar
---

### spring-boot-starter-parent-2.2.x.RELEASE

---
    spring-boot-starter-parent-2.2.x.RELEASE
        whatap-spring-kafka-stream-2.2.0-v1.3.jar
---

### spring-boot-starter-parent-1.5.x.RELEASE

---
    spring-boot-starter-parent-1.5.x.RELEASE
        whatap-spring-kafka-stream-2.2.0-v1.3.jar
---

## Spring Boot and spring-websocket, spring-messaging Compatibility

Compatibility between spring-integration-core, spring-messaging compatibility

각 spring boot 버전과 spring-integration-core, spring-messaging 의 의존관계를 확인할 수 있습니다.

## spring-boot-dependency

### spring-boot-2.5.x

#### spring-boot-starter-parent-2.5.6
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.8
* spring-integration-core-5.5.5
* spring-messaging-5.3.12

#### spring-boot-starter-parent-2.5.5
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.7
* spring-integration-core-5.5.4
* spring-messaging-5.3.10

#### spring-boot-starter-parent-2.5.4
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.6
* spring-integration-core-5.5.3
* spring-messaging-5.3.9

#### spring-boot-starter-parent-2.5.3
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.4
* spring-integration-core-5.5.2
* spring-messaging-5.3.9

#### spring-boot-starter-parent-2.5.2
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.3
* spring-integration-core-5.5.1
* spring-messaging-5.3.8

#### spring-boot-starter-parent-2.5.1
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.2
* spring-integration-core-5.5.0
* spring-messaging-5.3.8

#### spring-boot-starter-parent-2.5.0
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.7.1
* spring-integration-core-5.5.0
* spring-messaging-5.3.7

### spring-boot-2.4.x

#### spring-boot-starter-parent-2.4.12
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.11
* spring-integration-core-5.4.11
* spring-messaging-5.3.12

#### spring-boot-starter-parent-2.4.11
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.10
* spring-integration-core-5.4.11
* spring-messaging-5.3.10

#### spring-boot-starter-parent-2.4.10
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.10
* spring-integration-core-5.4.10
* spring-messaging-5.3.9

#### spring-boot-starter-parent-2.4.9
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.9
* spring-integration-core-5.4.8
* spring-messaging-5.3.9

#### spring-boot-starter-parent-2.4.8
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.9
* spring-integration-core-5.4.8
* spring-messaging-5.3.8

#### spring-boot-starter-parent-2.4.7
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.9
* spring-integration-core-5.4.7
* spring-messaging-5.3.8

#### spring-boot-starter-parent-2.4.6
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.8
* spring-integration-core-5.4.7
* spring-messaging-5.3.7

#### spring-boot-starter-parent-2.4.5
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.7
* spring-integration-core-5.4.6
* spring-messaging-5.3.6

#### spring-boot-starter-parent-2.4.4
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.7
* spring-integration-core-5.4.5
* spring-messaging-5.3.5

#### spring-boot-starter-parent-2.4.3
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.6
* spring-integration-core-5.4.4
* spring-messaging-5.3.4

#### spring-boot-starter-parent-2.4.2
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.5
* spring-integration-core-5.4.3
* spring-messaging-5.3.3

#### spring-boot-starter-parent-2.4.1
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.4
* spring-integration-core-5.4.2
* spring-messaging-5.3.2

#### spring-boot-starter-parent-2.4.0
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.6.3
* spring-integration-core-5.4.1
* spring-messaging-5.3.1

### spring-boot-2.3.x.RELEASE

#### spring-boot-starter-parent-2.3.12.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.14.RELEASE
* spring-integration-core-5.3.8.RELEASE
* spring-messaging-5.2.15.RELEASE

#### spring-boot-starter-parent-2.3.11.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.13.RELEASE
* spring-integration-core-5.3.7.RELEASE
* spring-messaging-5.2.15.RELEASE

#### spring-boot-starter-parent-2.3.10.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.12.RELEASE
* spring-integration-core-5.3.7.RELEASE
* spring-messaging-5.2.14.RELEASE

#### spring-boot-starter-parent-2.3.9.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.11.RELEASE
* spring-integration-core-5.3.6.RELEASE
* spring-messaging-5.2.13.RELEASE

#### spring-boot-starter-parent-2.3.8.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.11.RELEASE
* spring-integration-core-5.3.5.RELEASE
* spring-messaging-5.2.12.RELEASE

#### spring-boot-starter-parent-2.3.7.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.10.RELEASE
* spring-integration-core-5.3.4.RELEASE
* spring-messaging-5.2.12.RELEASE

#### spring-boot-starter-parent-2.3.6.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.8.RELEASE
* spring-integration-core-5.3.4.RELEASE
* spring-messaging-5.2.11.RELEASE

#### spring-boot-starter-parent-2.3.5.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.7.RELEASE
* spring-integration-core-5.3.3.RELEASE
* spring-messaging-5.2.10.RELEASE

#### spring-boot-starter-parent-2.3.4.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.6.RELEASE
* spring-integration-core-5.3.2.RELEASE
* spring-messaging-5.2.9.RELEASE

#### spring-boot-starter-parent-2.3.3.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.5.RELEASE
* spring-integration-core-5.3.2.RELEASE
* spring-messaging-5.2.8.RELEASE

#### spring-boot-starter-parent-2.3.2.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.4.RELEASE
* spring-integration-core-5.3.2.RELEASE
* spring-messaging-5.2.8.RELEASE

#### spring-boot-starter-parent-2.3.1.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.2.RELEASE
* spring-integration-core-5.3.1.RELEASE
* spring-messaging-5.2.7.RELEASE

#### spring-boot-starter-parent-2.3.0.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.5.0.RELEASE
* spring-integration-core-5.3.0.RELEASE
* spring-messaging-5.2.6.RELEASE

### spring-boot-2.2.x.RELEASE

#### spring-boot-starter-parent-2.2.13.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.13.RELEASE
* spring-integration-core-5.2.11.RELEASE
* spring-messaging-5.2.12.RELEASE

#### spring-boot-starter-parent-2.2.12.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.13.RELEASE
* spring-integration-core-5.2.10.RELEASE
* spring-messaging-5.2.12.RELEASE

#### spring-boot-starter-parent-2.2.11.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.12.RELEASE
* spring-integration-core-5.2.9.RELEASE
* spring-messaging-5.2.10.RELEASE

#### spring-boot-starter-parent-2.2.10.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.11.RELEASE
* spring-integration-core-5.2.8.RELEASE
* spring-messaging-5.2.9.RELEASE

#### spring-boot-starter-parent-2.2.9.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.10.RELEASE
* spring-integration-core-5.2.8.RELEASE
* spring-messaging-5.2.8.RELEASE

#### spring-boot-starter-parent-2.2.8.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.9.RELEASE
* spring-integration-core-5.2.7.RELEASE
* spring-messaging-5.2.7.RELEASE

#### spring-boot-starter-parent-2.2.7.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.8.RELEASE
* spring-integration-core-5.2.6.RELEASE
* spring-messaging-5.2.6.RELEASE

#### spring-boot-starter-parent-2.2.6.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.7.RELEASE
* spring-integration-core-5.2.5.RELEASE
* spring-messaging-5.2.5.RELEASE

#### spring-boot-starter-parent-2.2.5.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.6.RELEASE
* spring-integration-core-5.2.4.RELEASE
* spring-messaging-5.2.4.RELEASE

#### spring-boot-starter-parent-2.2.4.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.5.RELEASE
* spring-integration-core-5.2.3.RELEASE
* spring-messaging-5.2.3.RELEASE

#### spring-boot-starter-parent-2.2.3.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.5.RELEASE
* spring-integration-core-5.2.3.RELEASE
* spring-messaging-5.2.3.RELEASE

#### spring-boot-starter-parent-2.2.2.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.4.RELEASE
* spring-integration-core-5.2.2.RELEASE
* spring-messaging-5.2.2.RELEASE

#### spring-boot-starter-parent-2.2.1.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.3.RELEASE
* spring-integration-core-5.2.1.RELEASE
* spring-messaging-5.2.1.RELEASE

#### spring-boot-starter-parent-2.2.0.RELEASE
>
> whatap-spring-kafka-stream-2.2.0-v1.3.jar

* spring-kafka-2.3.1.RELEASE
* spring-integration-core-5.2.0.RELEASE
* spring-messaging-5.2.0.RELEASE
