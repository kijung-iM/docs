---
title: lettuce-core-6.1.0
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-lettuce-core-6.1.0 플러그인 입니다.

## Current Version

---

현재 버전은 2023년 1월 3일 배포된 버전 입니다. [v1.2]

whatap-lettuce-core-6.1.0-v1.2 (03-Jan-2023)

:::note

다음 와탭 자바 에이전트 이후의 버전이 필요합니다.

```
whatap.agent-2.0_56.jar
```

:::

## Release Note  

---

### v1.2

Release on: 2023-01-03

#### Update

불필요한 설정 제거.

### v1.1

Release on: 2022-11-15

#### Update

응답시간을 System.nanoTime()으로 측정할 수 있도록 수정.

whatap-weaving-api 의존성을 2.0.5에서 2.1.1로 수정.

### v1

Release on: 2021-09-27

Init release

## How to use

---

whatap.conf 파일이 있는 폴더의 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

lettuce-core 버전과 와탭의 플러그인 버전 관계를 [아래](#lettuce-core-and-whatap-lettuce-core-plugin-compatibility)에서 확인할 수 있습니다.

## lettuce-core-and-whatap-lettuce-core-plugin-compatibility

---

``lettuce-core`` 버전과 ``whatap-lettuce-core`` 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#lettuce-core-compatibility))

### lettuce-core-compatibility

---

lettuce-core 와 whatap-lettuce-core 플러그인의 연관 관계 정리 (lettuce-core 버전 : 매핑된 whatap-lettuce-core 버전)

* lettuce-core-6.1.2.RELEASE ~  
  whatap-lettuce-core-6.1.0-v1.2.jar

* lettuce-core-6.0.1.RELEASE ~ 6.0.7.RELEASE  
  whatap-lettuce-core-6.0.0-v1.2.jar

* lettuce-core-5.3.0.RELEASE ~ 5.3.7.RELEASE  
  whatap-lettuce-core-5.3.0-v1.2.jar

* lettuce-core-5.2.0.RELEASE ~ 5.2.2.RELEASE  
  whatap-lettuce-core-5.2.0-v1.2.jar

### lettuce-core-6.1.2.RELEASE ~

---

lettuce-core-6.1.4.RELEASE.jar
> whatap-lettuce-core-6.1.0-v1.2.jar

---

lettuce-core-6.1.3.RELEASE.jar
> whatap-lettuce-core-6.1.0-v1.2.jar

---

lettuce-core-6.1.2.RELEASE.jar
> whatap-lettuce-core-6.1.0-v1.2.jar

---

### lettuce-core-6.0.1.RELEASE ~ 6.0.7.RELEASE

---

lettuce-core-6.0.7.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

lettuce-core-6.0.6.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

lettuce-core-6.0.5.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

lettuce-core-6.0.4.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

lettuce-core-6.0.3.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

lettuce-core-6.0.2.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

lettuce-core-6.0.1.RELEASE.jar
> whatap-lettuce-core-6.0.0-v1.2.jar

---

### lettuce-core-5.3.0.RELEASE ~ 5.3.7.RELEASE

---

lettuce-core-5.3.7.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.6.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.5.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.4.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.3.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.2.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.1.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

lettuce-core-5.3.0.RELEASE.jar
> whatap-lettuce-core-5.3.0-v1.2.jar

---

### lettuce-core-5.2.0.RELEASE ~ 5.2.2.RELEASE

---

lettuce-core-5.2.2.RELEASE.jar
> whatap-lettuce-core-5.2.0-v1.2.jar

---

lettuce-core-5.2.1.RELEASE.jar
> whatap-lettuce-core-5.2.0-v1.2.jar

---

lettuce-core-5.2.0.RELEASE.jar
> whatap-lettuce-core-5.2.0-v1.2.jar

---
