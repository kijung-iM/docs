---
title: whatap-retrofit2-2.5.0 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-retrofit2-2.5.0 플러그인 입니다.

## Current Version

---

현재 버전은 2022년 12월 7일 배포된 버전 입니다. [v1.0]

:::note

* 와탭 자바 에이전트 v2.2.0 이후의 버전에서 사용할 수 있습니다.

* com.squareup.retrofit2-2.5.0 또는 그 이후의 버전을 포함한 retrofit2 를 추적합니다.

* `com.squareup.retrofit2-2.5.0` 버전 이후부터 추적합니다.

* retrofit2 버전과 와탭의 whatap-retrofit2 플러그인 버전 관계를 [아래](#retrofit2-and-whatap-retrofit2-plugin-compatibility)에서 확인할 수 있습니다.

* retrofit2 버전과 okhttp3 버전 관계를 ([의존관계 테이블](#retrofit2-and-okhttp3-compatibility))에서 확인할 수 있습니다.

:::

## Release Note

---

### v1.0

Release on: 2022-12-07

Init release

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

## retrofit2 and whatap-retrofit2-plugin compatibility

retrofit2 버전과 whatap-retrofit2 플러그인의 의존 관계를 [아래](#retrofit2-and-okhttp3-compatibility)에서 확인할 수 있습니다.

### com.squareup.retrofit2-2.5.0 ~

---
    com.squareup.retrofit2-2.5.0.jar
        whatap-retrofit2-2.5.0-v1.0.jar (07-December-2022)
---

## retrofit2 and okhttp3 compatibility

---

retrofit2 버전과 okhttp3 의 의존관계를 확인할 수 있습니다.

### com.squareup.retrofit2-2.5.x

---

#### com.squareup.retrofit2-2.5.0
>
> whatap-retrofit2-2.5.0-v1.0.jar

* com.squareup.retrofit2-2.5.0
  * okhttp3-4.9.3
