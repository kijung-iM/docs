---
title: spring-boot-starter-webflux-3.0.0
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 'spring-boot-starter-webflux-3.0.0' 플러그인 입니다.

## Current Version

---

현재 버전은 2023년 3월 10일 배포된 버전 입니다 [v1.1]


:::note

* 와탭 자바 에이전트 v2.1.0 (whatap.agent-2.1.0.jar) 또는 그 이후의 버전에서 사용할 수 있습니다.

* `spring-boot-6.0.2` 또는 그 이후의 버전을 추적합니다.

* spring-boot 버전과 와탭의 whatap-spring-boot-starter-webflux 플러그인 버전 관계를 [아래](#compatibility)에서 확인할 수 있습니다.

:::



## Release Note

---

### v1.1

Release on: 2023-03-10

### Update

update to start transaction


### v1.0

Release on: 2022-12-21

Init release



## How to use

---

*whatap.conf* 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 *whatap-xxx.jar* 파일 추가합니다.



## Compatibility

---

spring boot 버전과 whatap-spring-boot-starter-weblfux 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))



### spring-boot-starter-parent-3.0.0 ~

**whatap-spring-boot-starter-webflux-3.0.0-v1.2.jar** (10-March-2023)



## spring-boot-dependency

spring-boot 버전과 spring-webflux 의존관계는 다음과 같습니다.




### spring-boot-3.0.x

---

#### spring-boot-starter-parent-3.0.0

> whatap-spring-boot-starter-webflux-3.0.0-v1.1.jar
* spring-boot-starter-webflux-3.0.0
  * spring-web-6.0.2
  * spring-webflux-6.0.2



### spring-boot-2.7.x

---

#### spring-boot-starter-parent-2.7.x

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar



### spring-boot-2.6.x

---

#### spring-boot-starter-parent-2.6.7

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.7
    * spring-web-5.3.19
    * spring-webflux-5.3.19


#### spring-boot-starter-parent-2.6.6

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.6
    * spring-web-5.3.18
    * spring-webflux-5.3.18


#### spring-boot-starter-parent-2.6.5

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.5
    * spring-web-5.3.17
    * spring-webflux-5.3.17


#### spring-boot-starter-parent-2.6.4

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.4
    * spring-web-5.3.16
    * spring-webflux-5.3.16


#### spring-boot-starter-parent-2.6.3
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.3
    * spring-web-5.3.15
    * spring-webflux-5.3.15


#### spring-boot-starter-parent-2.6.2
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.2
    * spring-web-5.3.14
    * spring-webflux-5.3.14


#### spring-boot-starter-parent-2.6.1
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.1
    * spring-web-5.3.13
    * spring-webflux-5.3.13


#### spring-boot-starter-parent-2.6.0
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.6.0
    * spring-web-5.3.13
    * spring-webflux-5.3.13



### spring-boot-2.5.x

---

#### spring-boot-starter-parent-2.5.13

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-web-2.5.13
    * spring-web-5.3.19
* spring-boot-starter-webflux-2.5.13
    * spring-webflux-5.3.19


#### spring-boot-starter-parent-2.5.12

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.12
    * spring-web-5.3.18
    * spring-webflux-5.3.18


#### spring-boot-starter-parent-2.5.11

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.11
    * spring-web-5.3.17
    * spring-webflux-5.3.17


#### spring-boot-starter-parent-2.5.10

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.10
    * spring-web-5.3.16
    * spring-webflux-5.3.16


#### spring-boot-starter-parent-2.5.9

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.9
    * spring-web-5.3.15
    * spring-webflux-5.3.15


#### spring-boot-starter-parent-2.5.8

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.8
    * spring-web-5.3.14
    * spring-webflux-5.3.14


#### spring-boot-starter-parent-2.5.7

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.7
    * spring-web-5.3.13
    * spring-webflux-5.3.13


#### spring-boot-starter-parent-2.5.6

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.6
    * spring-web-5.3.12
    * spring-webflux-5.3.12


#### spring-boot-starter-parent-2.5.5

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.5
    * spring-web-5.3.10
    * spring-webflux-5.3.10


#### spring-boot-starter-parent-2.5.4

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.4
    * spring-web-5.3.9
    * spring-webflux-5.3.9


#### spring-boot-starter-parent-2.5.3

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.3
    * spring-web-5.3.9
    * spring-webflux-5.3.9


#### spring-boot-starter-parent-2.5.2

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.2
    * spring-web-5.3.8
    * spring-webflux-5.3.8


#### spring-boot-starter-parent-2.5.1

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.1
    * spring-web-5.3.8
    * spring-webflux-5.3.8


#### spring-boot-starter-parent-2.5.0
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.5.0
    * spring-web-5.3.7
    * spring-webflux-5.3.7



### spring-boot-2.4.x

---

#### spring-boot-starter-parent-2.4.13

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.13
    * spring-web-5.3.13
    * spring-webflux-5.3.13


#### spring-boot-starter-parent-2.4.12

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.12
    * spring-web-5.3.12
    * spring-webflux-5.3.12


#### spring-boot-starter-parent-2.4.11

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.11
    * spring-web-5.3.10
    * spring-webflux-5.3.10


#### spring-boot-starter-parent-2.4.10

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.10
    * spring-web-5.3.9
    * spring-webflux-5.3.9


#### spring-boot-starter-parent-2.4.9

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.9
    * spring-web-5.3.9
    * spring-webflux-5.3.9


#### spring-boot-starter-parent-2.4.8

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.8
    * spring-web-5.3.8
    * spring-webflux-5.3.8


#### spring-boot-starter-parent-2.4.7
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.7
    * spring-web-5.3.8
    * spring-webflux-5.3.8


#### spring-boot-starter-parent-2.4.6

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.6
    * spring-web-5.3.7
    * spring-webflux-5.3.7


#### spring-boot-starter-parent-2.4.5

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.5
    * spring-web-5.3.6
    * spring-webflux-5.3.6


#### spring-boot-starter-parent-2.4.4

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.4
    * spring-web-5.3.5
    * spring-webflux-5.3.5


#### spring-boot-starter-parent-2.4.

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.3
    * spring-web-5.3.4
    * spring-webflux-5.3.4


#### spring-boot-starter-parent-2.4.2

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.2
    * spring-web-5.3.3
    * spring-webflux-5.3.3


#### spring-boot-starter-parent-2.4.1

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.1
    * spring-web-5.3.2
    * spring-webflux-5.3.2


#### spring-boot-starter-parent-2.4.0

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.4.0
    * spring-web-5.3.1
    * spring-webflux-5.3.1



### spring-boot-2.3.x

---

#### spring-boot-starter-parent-2.3.12.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.12.RELEASE
    * spring-web-5.2.15.RELEASE
    * spring-webflux-5.2.15.RELEASE


#### spring-boot-starter-parent-2.3.11.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.11.RELEASE
    * spring-web-5.2.15.RELEASE
    * spring-webflux-5.2.15.RELEASE


#### spring-boot-starter-parent-2.3.10.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.10.RELEASE
    * spring-web-5.2.14.RELEASE
    * spring-webflux-5.2.14.RELEASE


#### spring-boot-starter-parent-2.3.9.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.9.RELEASE
    * spring-web-5.2.13.RELEASE
    * spring-webflux-5.2.13.RELEASE


#### spring-boot-starter-parent-2.3.8.RELEASE
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.8.RELEASE
    * spring-web-5.2.12.RELEASE
    * spring-webflux-5.2.12.RELEASE


#### spring-boot-starter-parent-2.3.7.RELEASE
> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.7.RELEASE
    * spring-web-5.2.12.RELEASE
    * spring-webflux-5.2.12.RELEASE


#### spring-boot-starter-parent-2.3.6.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.6.RELEASE
    * spring-web-5.2.11.RELEASE
    * spring-webflux-5.2.11.RELEASE


#### spring-boot-starter-parent-2.3.5.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.5.RELEASE
    * spring-web-5.2.10.RELEASE
    * spring-webflux-5.2.10.RELEASE


#### spring-boot-starter-parent-2.3.4.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.4.RELEASE
    * spring-web-5.2.9.RELEASE
    * spring-webflux-5.2.9.RELEASE


#### spring-boot-starter-parent-2.3.3.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.3.RELEASE
    * spring-web-5.2.8.RELEASE
    * spring-webflux-5.2.8.RELEASE


#### spring-boot-starter-parent-2.3.2.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.2.RELEASE
    * spring-web-5.2.8.RELEASE
    * spring-webflux-5.2.8.RELEASE


#### spring-boot-starter-parent-2.3.1.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.1.RELEASE
    * spring-web-5.2.7.RELEASE
    * spring-webflux-5.2.7.RELEASE


#### spring-boot-starter-parent-2.3.0.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.3.0.RELEASE
    * spring-web-5.2.7.RELEASE
    * spring-webflux-5.2.7.RELEASE



### spring-boot-2.2.x

#### spring-boot-starter-parent-2.2.13.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.13.RELEASE
    * spring-web-5.2.12.RELEASE
    * spring-webflux-5.2.12.RELEASE


#### spring-boot-starter-parent-2.2.12.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.12.RELEASE
    * spring-web-5.2.12.RELEASE
    * spring-webflux-5.2.12.RELEASE


#### spring-boot-starter-parent-2.2.11.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.11.RELEASE
    * spring-web-5.2.10.RELEASE
    * spring-webflux-5.2.10.RELEASE


#### spring-boot-starter-parent-2.2.10.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.10.RELEASE
    * spring-web-5.2.9.RELEASE
    * spring-webflux-5.2.9.RELEASE


#### spring-boot-starter-parent-2.2.9.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.9.RELEASE
    * spring-web-5.2.8.RELEASE
    * spring-webflux-5.2.8.RELEASE


#### spring-boot-starter-parent-2.2.8.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.8.RELEASE
    * spring-web-5.2.7.RELEASE
    * spring-webflux-5.2.7.RELEASE


#### spring-boot-starter-parent-2.2.7.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.7.RELEASE
    * spring-web-5.2.6.RELEASE
    * spring-webflux-5.2.6.RELEASE


#### spring-boot-starter-parent-2.2.6.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.6.RELEASE
    * spring-web-5.2.5.RELEASE
    * spring-webflux-5.2.5.RELEASE


#### spring-boot-starter-parent-2.2.5.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.5.RELEASE
    * spring-web-5.2.4.RELEASE
    * spring-webflux-5.2.4.RELEASE


#### spring-boot-starter-parent-2.2.4.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.4.RELEASE
    * spring-web-5.2.3.RELEASE
    * spring-webflux-5.2.3.RELEASE


#### spring-boot-starter-parent-2.2.3.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.3.RELEASE
    * spring-web-5.2.3.RELEASE
    * spring-webflux-5.2.3.RELEASE


#### spring-boot-starter-parent-2.2.2.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.2.RELEASE
    * spring-web-5.2.2.RELEASE
    * spring-webflux-5.2.2.RELEASE


#### spring-boot-starter-parent-2.2.1.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.1.RELEASE
    * spring-web-5.2.1.RELEASE
    * spring-webflux-5.2.1.RELEASE


#### spring-boot-starter-parent-2.2.0.RELEASE

> whatap-spring-boot-starter-webflux-2.2.0-v1.6.jar
* spring-boot-starter-webflux-2.2.0.RELEASE
    * spring-web-5.2.0.RELEASE
    * spring-webflux-5.2.0.RELEASE



### spring-boot-2.1.x

#### spring-boot-starter-parent-2.1.18.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.18.RELEASE
    * spring-web-5.1.19.RELEASE.jar
    * spring-webflux-5.1.19.RELEASE.jar


#### spring-boot-starter-parent-2.1.17.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.17.RELEASE
    * spring-web-5.1.18.RELEASE.jar
    * spring-webflux-5.1.18.RELEASE.jar


#### spring-boot-starter-parent-2.1.16.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.16.RELEASE
    * spring-web-5.1.17.RELEASE.jar
    * spring-webflux-5.1.17.RELEASE.jar


#### spring-boot-starter-parent-2.1.15.RELEASE
> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.15.RELEASE
    * spring-web-5.1.16.RELEASE.jar
    * spring-webflux-5.1.16.RELEASE.jar


#### spring-boot-starter-parent-2.1.14.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.14.RELEASE
    * spring-web-5.1.15.RELEASE.jar
    * spring-webflux-5.1.15.RELEASE.jar


#### spring-boot-starter-parent-2.1.13.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.13.RELEASE
    * spring-web-5.1.14.RELEASE.jar
    * spring-webflux-5.1.14.RELEASE.jar


#### spring-boot-starter-parent-2.1.12.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.12.RELEASE
    * spring-web-5.1.13.RELEASE.jar
    * spring-webflux-5.1.13.RELEASE.jar


#### spring-boot-starter-parent-2.1.11.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.11.RELEASE
    * spring-web-5.1.12.RELEASE.jar
    * spring-webflux-5.1.12.RELEASE.jar


#### spring-boot-starter-parent-2.1.10.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.10.RELEASE
    * spring-web-5.1.11.RELEASE.jar
    * spring-webflux-5.1.11.RELEASE.jar


#### spring-boot-starter-parent-2.1.9.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.9.RELEASE
    * spring-web-5.1.10.RELEASE.jar
    * spring-webflux-5.1.10.RELEASE.jar


#### spring-boot-starter-parent-2.1.8.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.8.RELEASE
    * spring-web-5.1.9.RELEASE.jar
    * spring-webflux-5.1.9.RELEASE.jar


#### spring-boot-starter-parent-2.1.7.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.7.RELEASE
    * spring-web-5.1.9.RELEASE.jar
    * spring-webflux-5.1.9.RELEASE.jar


#### spring-boot-starter-parent-2.1.6.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.6.RELEASE
    * spring-web-5.1.8.RELEASE.jar
    * spring-webflux-5.1.8.RELEASE.jar


#### spring-boot-starter-parent-2.1.5.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.5.RELEASE
    * spring-web-5.1.7.RELEASE.jar
    * spring-webflux-5.1.7.RELEASE.jar


#### spring-boot-starter-parent-2.1.4.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.4.RELEASE
    * spring-web-5.1.6.RELEASE.jar
    * spring-webflux-5.1.6.RELEASE.jar


#### spring-boot-starter-parent-2.1.3.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.3.RELEASE
    * spring-web-5.1.5.RELEASE.jar
    * spring-webflux-5.1.5.RELEASE.jar


#### spring-boot-starter-parent-2.1.2.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.2.RELEASE
    * spring-web-5.1.4.RELEASE.jar
    * spring-webflux-5.1.4.RELEASE.jar


#### spring-boot-starter-parent-2.1.1.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.1.RELEASE
    * spring-web-5.1.3.RELEASE.jar
    * spring-webflux-5.1.3.RELEASE.jar


#### spring-boot-starter-parent-2.1.0.RELEASE

> whatap-spring-boot-starter-webflux-2.1.0-v1.2.jar
* spring-boot-starter-webflux-2.1.0.RELEASE
    * spring-web-5.1.2.RELEASE.jar
    * spring-webflux-5.1.2.RELEASE.jar
