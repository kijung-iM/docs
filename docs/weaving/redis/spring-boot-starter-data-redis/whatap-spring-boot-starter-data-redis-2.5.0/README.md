---
title: whatap-spring-boot-starter-data-redis-2.5.0 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-spring-boot-starter-data-redis-2.5.0 플러그인 입니다.

## Current Version

---

현재 버전은 2023년 1월 4일 배포된 버전 입니다. [v1.2]

whatap-spring-boot-starter-data-redis-2.5.0-v1.2 (4-Jan-2023)

:::note

다음 와탭 자바 에이전트 이후의 버전이 필요합니다.

```
whatap.agent-2.0_56.jar
```

:::

## Release Note

---

## v1.2

Release on: 2023-01-04

### Update

Remove config option.

불필요한 설정 제거.

## v1.1

Release on: 2022-11-15

### Update

응답시간을 System.nanoTime()으로 측정할 수 있도록 수정.

whatap-weaving-api 의존성을 2.0.5에서 2.1.1로 수정.

## v1

Release on: 2021-09-17

Init release

## How to use

---

whatap.conf 파일이 있는 폴더의 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring-boot-starter-data-redis 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-java-plugin-compatibility)에서 확인할 수 있습니다.

## spring-boot-and-whatap-java-plugin-compatibility

---

spring boot 버전과 whatap spring boot starter data redis 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))

### spring-boot-starter-parent-2.5.x

---
    spring-boot-starter-parent-2.5.x
        whatap-spring-boot-starter-data-redis-2.5.0-v1.2.jar
---

### spring-boot-starter-parent-2.4.x

---
    spring-boot-starter-parent-2.4.x
        whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar
---

### spring-boot-starter-parent-2.3.x.RELEASE

---
    spring-boot-starter-parent-2.3.x.RELEASE
        whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar
---

### spring-boot-starter-parent-2.2.x.RELEASE

---
    spring-boot-starter-parent-2.2.x.RELEASE
        whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar
---

## spring-boot-dependency

---

스프링부트 의존성 관계 정리 (spring-boot 버전 : 매핑된 spring-boot-starter-data-redis 버전)

### spring-boot-2.5.x

---
spring-boot-starter-parent-2.5.4
> whatap-spring-boot-starter-data-redis-2.5.0-v1.2.jar

* spring-boot-2.5.4.jar
  * spring-data-redis-2.5.4.jar
  * lettuce-core-6.1.4.RELEASE.jar

---
spring-boot-starter-parent-2.5.3
> whatap-spring-boot-starter-data-redis-2.5.0-v1.2.jar

* spring-boot-2.5.3.jar
  * spring-data-redis-2.5.3.jar
  * lettuce-core-6.1.4.RELEASE.jar

---
spring-boot-starter-parent-2.5.2
> whatap-spring-boot-starter-data-redis-2.5.0-v1.2.jar

* spring-boot-2.5.2.jar
  * spring-data-redis-2.5.2.jar
  * lettuce-core-6.1.3.RELEASE.jar

---
spring-boot-starter-parent-2.5.1
> whatap-spring-boot-starter-data-redis-2.5.0-v1.2.jar

* spring-boot-2.5.1.jar
  * spring-data-redis-2.5.1.jar
  * lettuce-core-6.1.2.RELEASE.jar

---
spring-boot-starter-parent-2.5.0
> whatap-spring-boot-starter-data-redis-2.5.0-v1.2.jar

* spring-boot-2.5.0.jar
  * spring-data-redis-2.5.0.jar
  * lettuce-core-6.1.2.RELEASE.jar

---

### spring-boot-2.4.x

---
spring-boot-starter-parent-2.4.10
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.10.jar
  * spring-data-redis-2.4.10.jar
  * lettuce-core-6.0.7.RELEASE.jar

---
spring-boot-starter-parent-2.4.9
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.9.jar
  * spring-data-redis-2.4.9.jar
  * lettuce-core-6.0.7.RELEASE.jar

---
spring-boot-starter-parent-2.4.8
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.8.jar
  * spring-data-redis-2.4.8.jar
  * lettuce-core-6.0.6.RELEASE.jar

---
spring-boot-starter-parent-2.4.7
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.7.jar
  * spring-data-redis-2.4.7.jar
  * lettuce-core-6.0.5.RELEASE.jar

---
spring-boot-starter-parent-2.4.6
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.6.jar
  * spring-data-redis-2.4.6.jar
  * lettuce-core-6.0.5.RELEASE.jar

---
spring-boot-starter-parent-2.4.5
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.5.jar
  * spring-data-redis-2.4.5.jar
  * lettuce-core-6.0.4.RELEASE.jar

---
spring-boot-starter-parent-2.4.4
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.4.jar
  * spring-data-redis-2.4.4.jar
  * lettuce-core-6.0.3.RELEASE.jar

---
spring-boot-starter-parent-2.4.3
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.3.jar
  * spring-data-redis-2.4.3.jar
  * lettuce-core-6.0.2.RELEASE.jar

---
spring-boot-starter-parent-2.4.2
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.2.jar
  * spring-data-redis-2.4.2.jar
  * lettuce-core-6.0.2.RELEASE.jar

---
spring-boot-starter-parent-2.4.1
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.1.jar
  * spring-data-redis-2.4.1.jar
  * lettuce-core-6.0.1.RELEASE.jar

---
spring-boot-starter-parent-2.4.0
> whatap-spring-boot-starter-data-redis-2.4.0-v1.2.jar

* spring-boot-2.4.0.jar
  * spring-data-redis-2.4.0.jar
  * lettuce-core-6.0.1.RELEASE.jar

---

### spring-boot-2.3.x.RELEASE

---
spring-boot-starter-parent-2.3.12.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.12.RELEASE.jar
  * spring-data-redis-2.3.12.RELEASE.jar
  * lettuce-core-5.3.7.RELEASE.jar

---
spring-boot-starter-parent-2.3.11.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.11.RELEASE.jar
  * spring-data-redis-2.3.11.RELEASE.jar
  * lettuce-core-5.3.7.RELEASE.jar

---
spring-boot-starter-parent-2.3.10.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.10.RELEASE.jar
  * spring-data-redis-2.3.10.RELEASE.jar
  * lettuce-core-5.3.7.RELEASE.jar

---
spring-boot-starter-parent-2.3.9.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.9.RELEASE.jar
  * spring-data-redis-2.3.9.RELEASE.jar
  * lettuce-core-5.3.6.RELEASE.jar

---
spring-boot-starter-parent-2.3.8.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.8.RELEASE.jar
  * spring-data-redis-2.3.8.RELEASE.jar
  * lettuce-core-5.3.6.RELEASE.jar

---
spring-boot-starter-parent-2.3.7.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.7.RELEASE.jar
  * spring-data-redis-2.3.7.RELEASE.jar
  * lettuce-core-5.3.5.RELEASE.jar

---
spring-boot-starter-parent-2.3.6.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.6.RELEASE.jar
  * spring-data-redis-2.3.6.RELEASE.jar
  * lettuce-core-5.3.5.RELEASE.jar

---
spring-boot-starter-parent-2.3.5.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.5.RELEASE.jar
  * spring-data-redis-2.3.5.RELEASE.jar
  * lettuce-core-5.3.5.RELEASE.jar

---
spring-boot-starter-parent-2.3.4.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.4.RELEASE.jar
  * spring-data-redis-2.3.4.RELEASE.jar
  * lettuce-core-5.3.4.RELEASE.jar

---
spring-boot-starter-parent-2.3.3.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.3.RELEASE.jar
  * spring-data-redis-2.3.3.RELEASE.jar
  * lettuce-core-5.3.3.RELEASE.jar

---
spring-boot-starter-parent-2.3.2.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.2.RELEASE.jar
  * spring-data-redis-2.3.2.RELEASE.jar
  * lettuce-core-5.3.2.RELEASE.jar

---
spring-boot-starter-parent-2.3.1.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.1.RELEASE.jar
  * spring-data-redis-2.3.1.RELEASE.jar
  * lettuce-core-5.3.1.RELEASE.jar

---
spring-boot-starter-parent-2.3.0.RELEASE
> whatap-spring-boot-starter-data-redis-2.3.0-v1.2.jar

* spring-boot-2.3.0.RELEASE.jar
  * spring-data-redis-2.3.0.RELEASE.jar
  * lettuce-core-5.3.0.RELEASE.jar

---

### spring-boot-2.2.x.RELEASE

---
spring-boot-starter-parent-2.2.13.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.13.RELEASE.jar
  * spring-data-redis-2.2.13.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.12.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.12.RELEASE.jar
  * spring-data-redis-2.2.12.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.11.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.11.RELEASE.jar
  * spring-data-redis-2.2.11.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.10.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.10.RELEASE.jar
  * spring-data-redis-2.2.10.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.9.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.9.RELEASE.jar
  * spring-data-redis-2.2.9.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.8.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.8.RELEASE.jar
  * spring-data-redis-2.2.8.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.7.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.7.RELEASE.jar
  * spring-data-redis-2.2.7.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.6.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.6.RELEASE.jar
  * spring-data-redis-2.2.6.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.5.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.5.RELEASE.jar
  * spring-data-redis-2.2.5.RELEASE.jar
  * lettuce-core-5.2.2.RELEASE.jar

---
spring-boot-starter-parent-2.2.4.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.4.RELEASE.jar
  * spring-data-redis-2.2.4.RELEASE.jar
  * lettuce-core-5.2.1.RELEASE.jar

---
spring-boot-starter-parent-2.2.3.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.3.RELEASE.jar
  * spring-data-redis-2.2.3.RELEASE.jar
  * lettuce-core-5.2.1.RELEASE.jar

---
spring-boot-starter-parent-2.2.2.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.2.RELEASE.jar
  * spring-data-redis-2.2.2.RELEASE.jar
  * lettuce-core-5.2.1.RELEASE.jar

---
spring-boot-starter-parent-2.2.1.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.1.RELEASE.jar
  * spring-data-redis-2.2.1.RELEASE.jar
  * lettuce-core-5.2.1.RELEASE.jar

---
spring-boot-starter-parent-2.2.0.RELEASE
> whatap-spring-boot-starter-data-redis-2.2.0-v1.2.jar

* spring-boot-2.2.0.RELEASE.jar
  * spring-data-redis-2.2.0.RELEASE.jar
  * lettuce-core-5.2.0.RELEASE.jar

---
