---
title: whatap-spring-cloud-stream-rabbit-3.0.0 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-spring-cloud-stream-rabbit-3.0.0 플러그인 입니다.

## Current Version

---

현재 버전은 2023년 1월 16일 배포된 버전 입니다. [v1.0]

whatap-spring-r2dbc-mysql-miku-0.8.2-v1.0 (16-Jan-2023)

:::note

다음 와탭 자바 에이전트 이후의 버전이 필요합니다.

```
whatap.agent-2.2.3.jar
```

다음 플러그인과 같이 사용해야 합니다.

```
whatap-spring-boot-starter-webflux-2.2.0-v1.5.jar 
```

:::

## Release Note

---

## v1.0

Release on: 2023-01-16

Init release

## How to use

---

whatap.conf 파일이 있는 폴더의 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-cloud-stream-rabbit 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-spring-cloud-stream-rabbit-compatibility)에서 확인할 수 있습니다.

## spring-boot-and-whatap-spring-cloud-stream-rabbit-compatibility

---

spring-boot 버전과 whatap-spring-cloud-stream-rabbit 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))

### spring-boot-starter-parent-3.0.x

---
    spring-boot-starter-parent-3.0.x
        whatap-spring-cloud-stream-rabbit-3.0.0-v1.0.jar
---

## spring-boot-dependency

스프링부트 의존성 관계 정리 (spring-boot 버전 : 매핑된 spring-cloud-stream-rabbit 버전)

### spring-boot-starter-parent-3.0.x

---

spring-boot-starter-parent-3.0.0
> whatap-spring-cloud-stream-rabbit-3.0.0-v1.0.jar

* spring-boot-starter-parent-3.0.0
  * spring-cloud-starter-stream-rabbit-4.0.0.jar
  * spring-rabbit-3.0.0.jar
  * amqp-client-5.16.0.jar
  
----
