---
title: whatap-spring-boot-starter-data-cassandra-2.4.0 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-spring-boot-starter-data-cassandra-2.4.0 플러그인 입니다.

## Current Version

---

현재 버전은 2022년 11월 14일 배포된 버전 입니다 [v1.1]

whatap-spring-boot-starter-data-cassandra-2.4.0-v1.1 (14-Nov-2022) [v1.1]

## Release Note

---

### v1.1

Release on: 2022-11-14

#### Update

응답시간을 System.nanoTime()으로 측정하도록 수정.

와탭자바에이전트 버전을 v2.0_40에서 v2.2.0으로 수정.

### v1

Release on: 2021-06-24

Init release

:::note

다음 와탭 자바 에이전트 이후의 버전이 필요합니다.

```
whatap.agent-2.0_40.jar
```

:::

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 'instrument' 폴더 생성)에 해당 jar 파일 추가

## spring-boot-and-cassandra-dependency

---

spring-boot, cassandra 의존성 관계 정리 (Spring-Boot 버전 : 매핑된 cassandra 라이브러리 버전)

### spring-boot-starter-parent-2.5.x

---

spring-boot-starter-parent-2.5.0
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.5.0
  * spring-boot-starter-data-cassandra-2.5.0.jar
  * spring-data-cassandra-3.2.1.jar (jdk 1.8)

### spring-boot-starter-parent-2.4.x

---

spring-boot-starter-parent-2.4.7
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.7
  * spring-boot-starter-data-cassandra-2.4.7.jar
  * spring-data-cassandra-3.1.9.jar (jdk 1.8)

---

spring-boot-starter-parent-2.4.6
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.6
  * spring-boot-starter-data-cassandra-2.4.6.jar
  * spring-data-cassandra-3.1.9.jar (jdk 1.8)
  
---

spring-boot-starter-parent-2.4.5
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.5
  * spring-boot-starter-data-cassandra-2.4.5.jar
  * spring-data-cassandra-3.1.8.jar (jdk 1.8)
  
---

spring-boot-starter-parent-2.4.4
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.4
  * spring-boot-starter-data-cassandra-2.4.4.jar
  * spring-data-cassandra-3.1.6.jar (jdk 1.8)
  
---

spring-boot-starter-parent-2.4.3
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.3
  * spring-boot-starter-data-cassandra-2.4.3.jar
  * spring-data-cassandra-3.1.5.jar (jdk 1.8)
  
---

spring-boot-starter-parent-2.4.2
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.2
  * spring-boot-starter-data-cassandra-2.4.2.jar
  * spring-data-cassandra-3.1.3.jar (jdk 1.8)
  
---

spring-boot-starter-parent-2.4.1
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.1
  * spring-boot-starter-data-cassandra-2.4.1.jar
  * spring-data-cassandra-3.1.2.jar (jdk 1.8)
  
---

spring-boot-starter-parent-2.4.0
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.4.0
  * spring-boot-starter-data-cassandra-2.4.0.jar
  * spring-data-cassandra-3.1.1.jar (jdk 1.8)

### spring-boot-starter-parent-2.3.x

---

spring-boot-starter-parent-2.3.12.RELEASE
> whatap-spring-boot-starter-data-cassandra-2.4.0

* spring-boot-starter-parent-2.3.12.RELEASE
  * spring-boot-starter-data-cassandra-2.3.12.RELEASE.jar
  * spring-data-cassandra-3.0.9.RELEASE.jar (jdk 1.8)
