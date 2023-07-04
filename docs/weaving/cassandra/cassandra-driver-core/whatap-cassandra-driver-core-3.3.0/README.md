---
title: whatap-cassandra-driver-core-3.3.0 plugin
# displayed_sidebar: ospSidebar
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-cassandra-driver-core-3.3.0 플러그인 입니다.

## Current Version

---

현재 버전은 2022년 11월 14일 배포된 버전 입니다. [v1.1]

whatap-cassandra-driver-core-3.3.0-v1.1 (14-Nov-2022) [v1.1]

:::note

* 와탭 자바 에이전트 2.0_40 이상의 버전에서 사용할 수 있습니다.

:::

## Release Note

---

## v1.1

Release on: 2022-11-14

### Update

응답시간을 System.nanoTime()으로 측정하도록 수정.

와탭자바에이전트 버전을 v2.0_40에서 v2.2.0으로 수정.

## v1

Release on: 2021-06-24

Init release

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 'instrument' 폴더 생성)에 해당 jar 파일 추가

## cassandra-driver-core and whatap-cassandra-driver-core-plugin Compatibility

각 cassandra-driver-core 버전과 whatap-cassandra-driver-core 플러그인의 의존 관계를 확인할 수 있습니다.

### cassandra-driver-core-3.3.0 ~

---
    cassandra-driver-core-3.3.0 ~
        whatap-cassandra-driver-core-3.3.0-v1.1.jar
---

## cassandra-driver-core dependency

---

    cassandra-driver 3.3.0
        cassandra-driver-core-3.3.0.jar
        cassandra-driver-extras-3.3.0.jar
        cassandra-driver-mapping-3.3.0.jar

---
