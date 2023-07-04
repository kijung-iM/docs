---
title: WhaTap MongoDB Weaving Component
---

Welcome to the WhaTap Weaving component of the WhaTap APM project.

APM을 위한 와탭랩스 MongoDB Weaving 라이브러리 입니다

Current Version
---------------

Current Release as of 14-Nov-2022 is [v1.1]

현재 버전은 2022년 11월 14일 배포된 버전 입니다 [v1.1]

Release Note
------------

## v1.1

Release on: 2022-11-14

### Update

Updated to use System.nanoTime() when measuring elapsed time.

Updated Java Agent dependencies from v2.0_38 to v2.2.0.

응답시간을 System.nanoTime()으로 측정할 수 있도록 수정하였습니다.

와탭자바에이전트 버전을 v2.0_38에서 v2.2.0으로 업데이트 하였습니다.

## v1

Release on: 2021-06-11

Init release

:::note

whatap-spring-boot-starter-data-mongodb-2.4.4-v1.1 (14-Nov-2022) [v1.1]

Tracking MongoTemplate methods

MongoTemplate 메소드 추적 확인

:::

How to
------

add .jar file to instrument folder

whatap.conf 파일이 있는 디렉토리(폴더)의 instrument 폴더(없는 경우 폴더 생성)에 해당 jar 파일 추가

Spring-Boot dependency
----------------------

Spring-Boot dependency relations (Spring-Boot version : MongoDB driver version)

스프링부트 의존성 관계 정리 (Spring-Boot 버전 : 매핑된 mongodb 드라이버 버전)

    spring-boot-starter-parent-2.4.4
        bson-4.1.2.jar
        mongodb-driver-core-4.1.2.jar
        mongodb-driver-sync-4.1.2.jar
        spring-boot-starter-data-mongodb-2.4.4.jar
        spring-data-mongodb-3.1.6.jar
