---
title: whatap-spring-cloud-starter-gateway-2.2.1 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-spring-cloud-starter-gateway-2.2.1 플러그인

## Current Version

---
현재 버전은 2021년 7월 29일 배포된 버전 입니다. [v1.0]

:::note

와탭 자바 에이전트 2.1.0 (whatap.agent-2.1.0.jar) 이상의 버전에서 동작합니다.

다음 플러그인과 같이 사용해야 합니다.

- whatap-spring-boot-starter-webflux-2.2.0-v1.5.jar

:::

## Release Note

------------

### v1.0

Release on: 2021-07-29

Init release

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

spring cloud gateway 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-cloud-gateway-and-whatap-plugin-compatibility)에서 확인할 수 있습니다.

## Spring Cloud Gateway and Whatap Plugin Compatibility

각 spring cloud 버전과 와탭 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-cloud-dependency))

### 2020.0.x

---
    2020.0.3
        whatap-spring-cloud-starter-gateway-3.0.3-v1.0.jar

    2020.0.2
        whatap-spring-cloud-starter-gateway-3.0.2-v1.0.jar

    2020.0.0, 2020.0.1
        whatap-spring-cloud-starter-gateway-3.0.0-v1.0.jar

### Hoxton.x

---
    Hoxton.SR12
        whatap-spring-cloud-starter-gateway-2.2.9-v1.0.jar

    Hoxton.SR3 ~ Hoxton.SR11
        whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

    Hoxton.SR2, Hoxton.SR1
        whatap-spring-cloud-starter-gateway-2.2.1-v1.0.jar

    Hoxton.RELEASE
        whatap-spring-cloud-starter-gateway-2.2.0-v1.0.jar

### Greenwich.x

---
    Greenwich.SR6, Greenwich.SR5
        whatap-spring-cloud-starter-gateway-2.1.5-v1.0.jar

    Greenwich.SR4
        whatap-spring-cloud-starter-gateway-2.1.4-v1.0.jar

    Greenwich.SR3
        whatap-spring-cloud-starter-gateway-2.1.3-v1.0.jar

    Greenwich.SR2
        whatap-spring-cloud-starter-gateway-2.1.2-v1.0.jar

    Greenwich.SR1
        whatap-spring-cloud-starter-gateway-2.1.1-v1.0.jar

    Greenwich.RELEASE
        whatap-spring-cloud-starter-gateway-2.1.0-v1.0.jar

## Spring Cloud dependency

---

스프링 클라우드 의존성 관계 정리 (spring-cloud 버전 : spring-cloud-starter-gateway 버전)

### 2020.0.x

---

2020.0.3
> whatap-spring-cloud-starter-gateway-3.0.3-v1.0.jar

- Spring Cloud Gateway 3.0.3
  - spring-cloud-gateway-server-3.0.3.jar

---

2020.0.2
> whatap-spring-cloud-starter-gateway-3.0.2-v1.0.jar

- Spring Cloud Gateway 3.0.2
  - spring-cloud-gateway-server-3.0.2.jar

---

2020.0.1
> whatap-spring-cloud-starter-gateway-3.0.0-v1.0.jar

- Spring Cloud Gateway 3.0.1
  - spring-cloud-gateway-server-3.0.1.jar

---

2020.0.0
> whatap-spring-cloud-starter-gateway-3.0.0-v1.0.jar

- Spring Cloud Gateway 3.0.0
  - spring-cloud-gateway-server-3.0.0.jar

---

### Hoxton.x

---

Hoxton.SR12
> whatap-spring-cloud-starter-gateway-2.2.9-v1.0.jar

- Spring Cloud Gateway 2.2.9.RELEASE
  - spring-cloud-starter-gateway-2.2.9.jar

---

Hoxton.SR11
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.8.RELEASE
  - spring-cloud-starter-gateway-2.2.8.jar

---

Hoxton.SR10
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.7.RELEASE
  - spring-cloud-starter-gateway-2.2.7.jar

---

Hoxton.SR9
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.6.RELEASE
  - spring-cloud-starter-gateway-2.2.6.jar

---

Hoxton.SR8
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.5.RELEASE
  - spring-cloud-starter-gateway-2.2.5.jar

---

Hoxton.SR7
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.4.RELEASE
  - spring-cloud-starter-gateway-2.2.4.jar

---

Hoxton.SR6
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.3.RELEASE
  - spring-cloud-starter-gateway-2.2.3.jar

---

Hoxton.SR5
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.3.RELEASE
  - spring-cloud-starter-gateway-2.2.3.jar

---

Hoxton.SR4
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.2.RELEASE
  - spring-cloud-starter-gateway-2.2.2.jar

---

Hoxton.SR3
> whatap-spring-cloud-starter-gateway-2.2.2-v1.0.jar

- Spring Cloud Gateway 2.2.2.RELEASE
  - spring-cloud-starter-gateway-2.2.2.jar

---

Hoxton.SR2
> whatap-spring-cloud-starter-gateway-2.2.1-v1.0.jar

- Spring Cloud Gateway 2.2.1.RELEASE
  - spring-cloud-starter-gateway-2.2.1.jar

---

Hoxton.SR1
> whatap-spring-cloud-starter-gateway-2.2.1-v1.0.jar

- Spring Cloud Gateway 2.2.1.RELEASE
  - spring-cloud-starter-gateway-2.2.1.jar

---

Hoxton.RELEASE
> whatap-spring-cloud-starter-gateway-2.2.0-v1.0.jar

- Spring Cloud Gateway 2.2.0.RELEASE
  - spring-cloud-starter-gateway-2.2.0.jar

---

### Greenwich.x

---

Greenwich.SR6
> whatap-spring-cloud-starter-gateway-2.1.5-v1.0.jar

- Spring Cloud Gateway 2.1.5.RELEASE
  - spring-cloud-starter-gateway-2.1.5.jar

---

Greenwich.SR5
> whatap-spring-cloud-starter-gateway-2.1.5-v1.0.jar

- Spring Cloud Gateway 2.1.5.RELEASE
  - spring-cloud-starter-gateway-2.1.5.jar

---

Greenwich.SR4
> whatap-spring-cloud-starter-gateway-2.1.4-v1.0.jar

- Spring Cloud Gateway 2.1.4.RELEASE
  - spring-cloud-starter-gateway-2.1.4.jar

---

Greenwich.SR3
> whatap-spring-cloud-starter-gateway-2.1.3-v1.0.jar

- Spring Cloud Gateway 2.1.3.RELEASE
  - spring-cloud-starter-gateway-2.1.3.jar

---

Greenwich.SR2
> whatap-spring-cloud-starter-gateway-2.1.2-v1.0.jar

- Spring Cloud Gateway 2.1.2.RELEASE
  - spring-cloud-starter-gateway-2.1.2.jar

---

Greenwich.SR1
> whatap-spring-cloud-starter-gateway-2.1.1-v1.0.jar

- Spring Cloud Gateway 2.1.1.RELEASE
  - spring-cloud-starter-gateway-2.1.1.jar

---

Greenwich.RELEASE
> whatap-spring-cloud-starter-gateway-2.1.0-v1.0.jar

- Spring Cloud Gateway 2.1.0.RELEASE
  - spring-cloud-starter-gateway-2.1.0.jar

---
