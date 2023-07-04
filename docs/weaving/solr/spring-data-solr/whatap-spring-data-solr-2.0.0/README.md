---
title: whatap-spring-data-solr-2.0.0 Plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-spring-data-solr-2.0.0 플러그인 입니다.

## Current Version

---

현재 버전은 2022년 2월 23일 배포된 버전 입니다. [v1.0]

whatap-spring-data-solr-2.0.0-v1.0.jar (23-February-2022) [v1.0]

## Release Note  

---

### v1.0

Release on: 2022-02-23

Init release

---

와탭 자바 에이전트 2.1.2 이후의 버전에서 사용할 수 있습니다.

`solr-solrj-6.6.2` 버전부터 `solr-solrj-8.11.2` 까지 추적합니다.

`solr-core-6.6.2` 버전부터 `solr-core-8.11.2` 까지 추적합니다.

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

solr 버전과 와탭의 whatap-solr 플러그인 버전 관계를 [아래](#solr-and-whatap-solr-plugin-compatibility)에서 확인할 수 있습니다.

spring-data-solr 버전과 와탭의 플러그인 버전 관계를 [아래](#spring-boot-and-whatap-java-plugin-compatibility)에서 확인할 수 있습니다.

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf)에서 확인할 수 있습니다.

## Configuration

---

| 에이전트 설정                  | 초기값    | 설명                                           |
| --------------------------- | :-----: | :-------------------------------------------- |
| solr_profile_enabled        | false   | solr 프로파일 정보 수집 여부                        |
| solr_basetime               | 100     | solr 응답시간 <br/> 지정시간 이상일 때 프로파일 표시     |
| solr_params_limit           | 80      | 수집하는 파라미터의 길이 <br/> 0 이상의 숫자 입력        |
| hook_httpservlet_classes    |         | 후킹을 하기 위한 서블릿 필터 클래스를 지정              |

### whatap.conf

```ini title='whatap.conf'
###### whatap apm monitoring - solr ####
solr_profile_enabled=true
solr_basetime=0
solr_params_limit=80
hook_httpservlet_classes=org.apache.solr.servlet.SolrDispatchFilter
########################################
```

## solr and whatap-solr-plugin Compatibility

---

각 solr-solrj, solr-core 버전과 whatap-solr 플러그인의 의존 관계를 확인할 수 있습니다.

### solr-solrj-6.6.2 ~, solr-core-6.6.2 ~

---
    solr-solrj-6.6.2 ~, solr-core-6.6.2 ~
        whatap-solr-6.6.2-v1.jar

## spring-boot-and-whatap-java-plugin-compatibility

---

각 spring boot 버전과 whatap spring data solr 플러그인의 의존 관계 확인할 수 있습니다. ([의존관계 테이블](#spring-boot-dependency))

### spring-boot-starter-parent-2.4.x

---
    spring-boot-starter-parent-2.4.x
        whatap-spring-data-solr-2.0.0-v1.jar
---

### spring-boot-starter-parent-2.3.x.RELEASE

---
    spring-boot-starter-parent-2.3.x.RELEASE
        whatap-spring-data-solr-2.0.0-v1.jar
---

### spring-boot-starter-parent-2.2.x.RELEASE

---
    spring-boot-starter-parent-2.2.x.RELEASE
        whatap-spring-data-solr-2.0.0-v1.jar
---

## spring-boot-dependency

---

스프링부트 의존성 관계 정리 (spring-boot 버전 : 매핑된 spring-data-solr 버전)

### spring-boot-2.4.x

---
spring-boot-starter-parent-2.4.13
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.13.jar
  * spring-data-solr-4.3.15.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.12
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.12.jar
  * spring-data-solr-4.3.14.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.11
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.11.jar
  * spring-data-solr-4.3.13.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.10
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.10.jar
  * spring-data-solr-4.3.12.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.9
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.9.jar
  * spring-data-solr-4.3.11.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.8
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.8.jar
  * spring-data-solr-4.3.10.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.7
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.7.jar
  * spring-data-solr-4.3.9.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.6
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.6.jar
  * spring-data-solr-4.3.9.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.5
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.5.jar
  * spring-data-solr-4.3.8.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.4
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.4.jar
  * spring-data-solr-4.3.6.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.3
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.3.jar
  * spring-data-solr-4.3.5.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.2
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.2.jar
  * spring-data-solr-4.3.3.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.1
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.2.jar
  * spring-data-solr-4.3.2.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.4.0
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.4.2.jar
  * spring-data-solr-4.3.1.jar
  * solr-solrj-8.5.2.jar

---

### spring-boot-2.3.x.RELEASE

---
spring-boot-starter-parent-2.3.12.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.12.RELEASE.jar
  * spring-data-solr-4.2.9.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.11.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.11.RELEASE.jar
  * spring-data-solr-4.2.9.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.10.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.10.RELEASE.jar
  * spring-data-solr-4.2.9.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.9.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.9.RELEASE.jar
  * spring-data-solr-4.2.7.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.8.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.8.RELEASE.jar
  * spring-data-solr-4.2.6.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.7.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.7.RELEASE.jar
  * spring-data-solr-4.2.6.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.6.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.6.RELEASE.jar
  * spring-data-solr-4.2.5.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.6.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.6.RELEASE.jar
  * spring-data-solr-4.2.5.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.5.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.5.RELEASE.jar
  * spring-data-solr-4.2.5.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.4.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.4.RELEASE.jar
  * spring-data-solr-4.2.4.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.3.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.3.RELEASE.jar
  * spring-data-solr-4.2.3.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.2.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.2.RELEASE.jar
  * spring-data-solr-4.2.2.RELEASE.jar
  * solr-solrj-8.5.2.jar

---
spring-boot-starter-parent-2.3.1.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.1.RELEASE.jar
  * spring-data-solr-4.2.1.RELEASE.jar
  * solr-solrj-8.5.1.jar

---
spring-boot-starter-parent-2.3.0.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.3.0.RELEASE.jar
  * spring-data-solr-4.2.0.RELEASE.jar
  * solr-solrj-8.5.1.jar

---

### spring-boot-2.2.x.RELEASE

---
spring-boot-starter-parent-2.2.13.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.13.RELEASE.jar
  * spring-data-solr-4.1.12.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.12.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.12.RELEASE.jar
  * spring-data-solr-4.1.12.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.11.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.11.RELEASE.jar
  * spring-data-solr-4.1.11.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.10.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.10.RELEASE.jar
  * spring-data-solr-4.1.10.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.9.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.9.RELEASE.jar
  * spring-data-solr-4.1.9.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.8.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.8.RELEASE.jar
  * spring-data-solr-4.1.8.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.7.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.7.RELEASE.jar
  * spring-data-solr-4.1.7.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.6.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.6.RELEASE.jar
  * spring-data-solr-4.1.6.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.5.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.5.RELEASE.jar
  * spring-data-solr-4.1.5.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.4.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.4.RELEASE.jar
  * spring-data-solr-4.1.4.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.3.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.3.RELEASE.jar
  * spring-data-solr-4.1.4.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.2.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.2.RELEASE.jar
  * spring-data-solr-4.1.3.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.1.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.1.RELEASE.jar
  * spring-data-solr-4.1.1.RELEASE.jar
  * solr-solrj-8.2.0.jar

---
spring-boot-starter-parent-2.2.0.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.2.0.RELEASE.jar
  * spring-data-solr-4.1.0.RELEASE.jar
  * solr-solrj-8.2.0.jar

---

### spring-boot-2.1.x.RELEASE

---
spring-boot-starter-parent-2.1.18.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.18.RELEASE.jar
  * spring-data-solr-4.0.21.RELEASE.jar
  * solr-solrj-7.7.3.jar

---
spring-boot-starter-parent-2.1.17.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.17.RELEASE.jar
  * spring-data-solr-4.0.20.RELEASE.jar
  * solr-solrj-7.7.3.jar

---
spring-boot-starter-parent-2.1.16.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.16.RELEASE.jar
  * spring-data-solr-4.0.19.RELEASE.jar
  * solr-solrj-7.7.3.jar

---
spring-boot-starter-parent-2.1.15.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.15.RELEASE.jar
  * spring-data-solr-4.0.18.RELEASE.jar
  * solr-solrj-7.7.3.jar

---
spring-boot-starter-parent-2.1.14.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.14.RELEASE.jar
  * spring-data-solr-4.0.17.RELEASE.jar
  * solr-solrj-7.7.3.jar

---
spring-boot-starter-parent-2.1.13.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.13.RELEASE.jar
  * spring-data-solr-4.0.16.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.12.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.12.RELEASE.jar
  * spring-data-solr-4.0.15.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.11.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.11.RELEASE.jar
  * spring-data-solr-4.0.14.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.10.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.10.RELEASE.jar
  * spring-data-solr-4.0.12.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.9.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.9.RELEASE.jar
  * spring-data-solr-4.0.11.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.8.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.8.RELEASE.jar
  * spring-data-solr-4.0.10.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.7.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.7.RELEASE.jar
  * spring-data-solr-4.0.10.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.6.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.6.RELEASE.jar
  * spring-data-solr-4.0.9.RELEASE.jar
  * solr-solrj-7.7.2.jar

---
spring-boot-starter-parent-2.1.5.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.5.RELEASE.jar
  * spring-data-solr-4.0.8.RELEASE.jar
  * solr-solrj-7.7.1.jar

---
spring-boot-starter-parent-2.1.4.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.4.RELEASE.jar
  * spring-data-solr-4.0.6.RELEASE.jar
  * solr-solrj-7.7.1.jar

---
spring-boot-starter-parent-2.1.3.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.3.RELEASE.jar
  * spring-data-solr-4.0.5.RELEASE.jar
  * solr-solrj-7.4.0.jar

---
spring-boot-starter-parent-2.1.2.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.2.RELEASE.jar
  * spring-data-solr-4.0.4.RELEASE.jar
  * solr-solrj-7.4.0.jar

---
spring-boot-starter-parent-2.1.1.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.1.RELEASE.jar
  * spring-data-solr-4.0.3.RELEASE.jar
  * solr-solrj-7.4.0.jar

---
spring-boot-starter-parent-2.1.0.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.1.0.RELEASE.jar
  * spring-data-solr-4.0.2.RELEASE.jar
  * solr-solrj-7.4.0.jar

---

### spring-boot-2.0.x.RELEASE

---
spring-boot-starter-parent-2.0.8.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.8.RELEASE.jar
  * spring-data-solr-3.0.13.RELEASE.jar
  * solr-solrj-6.6.5.jar

---
spring-boot-starter-parent-2.0.7.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.7.RELEASE.jar
  * spring-data-solr-3.0.12.RELEASE.jar
  * solr-solrj-6.6.5.jar

---
spring-boot-starter-parent-2.0.6.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.6.RELEASE.jar
  * spring-data-solr-3.0.11.RELEASE.jar
  * solr-solrj-6.6.5.jar

---
spring-boot-starter-parent-2.0.5.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.5.RELEASE.jar
  * spring-data-solr-3.0.10.RELEASE.jar
  * solr-solrj-6.6.5.jar

---
spring-boot-starter-parent-2.0.4.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.4.RELEASE.jar
  * spring-data-solr-3.0.9.RELEASE.jar
  * solr-solrj-6.6.5.jar

---
spring-boot-starter-parent-2.0.3.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.3.RELEASE.jar
  * spring-data-solr-3.0.8.RELEASE.jar
  * solr-solrj-6.6.4.jar

---
spring-boot-starter-parent-2.0.2.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.2.RELEASE.jar
  * spring-data-solr-3.0.7.RELEASE.jar
  * solr-solrj-6.6.3.jar

---
spring-boot-starter-parent-2.0.1.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.1.RELEASE.jar
  * spring-data-solr-3.0.6.RELEASE.jar
  * solr-solrj-6.6.3.jar

---
spring-boot-starter-parent-2.0.0.RELEASE
> whatap-spring-data-solr-2.0.0-v1.jar

* spring-boot-2.0.0.RELEASE.jar
  * spring-data-solr-3.0.5.RELEASE.jar
  * solr-solrj-6.6.2.jar

---
