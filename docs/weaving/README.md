---
title: 오픈 소스 플러그인
description: 와탭 Java 에이전트의 비동기 라이브러리를 포함한 오픈 소스 라이브러리를 소개합니다.
tags: [ 오픈 소스 플러그인, Java ]
---

와탭 Java 에이전트는 비동기 라이브러리를 포함한 오픈 소스 라이브러리를 추적하고 있습니다. 추적의 범위는 소요시간, sql문, http call 관련 데이터 등을 포함합니다.

## Java 에이전트 지원 범위

Java 에이전트 2.1.0 이후의 버전부터 오픈 소스 라이브러리 추적 기능을 제공하고 있습니다. 각 오픈 소스 플러그인에 따라 지원하는 Java 에이전트의 버전은 다를 수 있습니다. 오픈 소스 플러그인 상세 문서에서 Java 에이전트의 지원 범위를 확인할 수 있습니다.

:::note

SaaS를 사용하는 경우 [와탭 모니터링 서비스](https://service.whatap.io) 화면의 오른쪽 위에 ![채널톡 아이콘](/img/ico-help.svg) **채널톡**을 통해서 요청할 수 있습니다. 설치형을 사용하는 경우 솔루션 컨설팅팀(<tech@whatap.io>)을 통해 오픈 소스 플러그인을 요청할 수 있습니다.

:::

## 적용하기

*`${WHATAP_AGENT}`/instrument* 경로에 요청한 jar 파일을 복사하고 상세 문서에서 제공하는 설정을 *whatap.conf* 파일에 추가하세요. 에이전트를 재시작해 적용할 수 있습니다.

### 적용 예시

* 적용 전

  ![위빙 플러그인 적용 전](/img/java-plugin-weaving-01.png)

* 적용 후

  ![위빙 플러그인 적용 후](/img/java-plugin-weaving-02.png)

## 오픈 소스 지원 목록

| 오픈소스 | 오픈소스 드라이버 | 버전 | 와탭 플러그인 |
| -- | -- | -- | -- |
| cassandra | cassandra-driver-core | cassandra-driver-core-3.3.0 이상 | [whatap-cassandra-driver-core-3.3.0](weaving/cassandra/cassandra-driver-core/whatap-cassandra-driver-core-3.3.0) |
| log4j     | apache-log4j | log4j-1.2.17 이상        | [whatap-log4j-1.2.17](weaving/log4j/apache-log4j/whatap-log4j-1.2.17) |
| ^         | ^            | slf4j-log4j12-1.7.5 이상 | [whatap-slf4j-log4j12-1.7.5](weaving/log4j/apache-log4j/whatap-slf4j-log4j12-1.7.5) |
| ^         | apache-logging-log4j | apache-logging-log4j-2.7 이상    | [whatap-apache-logging-log4j-2.7](weaving/log4j/apache-logging-log4j/whatap-apache-logging-log4j-2.7) |
| ^         | ^                    | apache-logging-log4j-2.11.2 이상 | [whatap-apache-logging-log4j-2.11.2](weaving/log4j/apache-logging-log4j/whatap-apache-logging-log4j-2.11.2) |
| ^         | ^                    | apache-logging-log4j-2.17.1 이상 | [whatap-apache-logging-log4j-2.17.1](weaving/log4j/apache-logging-log4j/whatap-apache-logging-log4j-2.17.1) |
| logback   | logback-core | logback-core-1.2.8 이상 | [whatap-logback-core-1.2.8](weaving/logback/logback-core/whatap-logback-core-1.2.8) |
| mongodb   | mongodb-reactive | - | - | <!-- [whatap-mongodb-...](weaving/...) TODO mongodb-reactive 내부 버전정리 -->
| okhttp    | okhttp       | okhttp-2.7.5 이상   | [whatap-okhttp-2.7.5](weaving/okhttp/whatap-okhttp-2.7.5) |
| ^         | okhttp3      | okhttp3-3.14.0 이상 | [whatap-okhttp3-3.14.0](weaving/okhttp3/whatap-okhttp3-3.14.0) |
| ^         | ^            | okhttp3-4.0.0 이상  | [whatap-okhttp3-4.0.0](weaving/okhttp3/whatap-okhttp3-4.0.0) |
| ^         | ^            | okhttp3-4.4.0 이상  | [whatap-okhttp3-4.4.0](weaving/okhttp3/whatap-okhttp3-4.4.0) |
| redis     | jedis        | jedis-3.3.0 이상        | [whatap-jedis-3.3.0](weaving/redis/jedis/whatap-jedis-3.3.0) |
| ^         | lettuce-core | lettuce-core-6.1.0 이상 | [whatap-lettuce-core-6.1.0](weaving/redis/lettuce-core/whatap-lettuce-core-6.1.0) |
| ^         | ^            | lettuce-core-6.0.0 이상 | [whatap-lettuce-core-6.0.0](weaving/redis/lettuce-core/whatap-lettuce-core-6.0.0) |
| ^         | ^            | lettuce-core-5.3.0 이상 | [whatap-lettuce-core-5.3.0](weaving/redis/lettuce-core/whatap-lettuce-core-5.3.0) |
| ^         | ^            | lettuce-core-5.2.0 이상 | [whatap-lettuce-core-5.2.0](weaving/redis/lettuce-core/whatap-lettuce-core-5.2.0) |
| retrofit  | retrofit2    | retrofit2-2.5.0 이상    | [whatap-retrofit2-2.5.0](weaving/retrofit2/whatap-retrofit2-2.5.0) |
| solr      | solr-solrj   | solr-6.6.2 이상 | [whatap-solr-6.6.2](weaving/solr/solr-solrj/whatap-solr-6.6.2) |

## spring-boot 라이브러리 지원 목록

| spring 라이브러리 | spring 드라이버 | 버전 | 와탭 플러그인 |
| -- | -- | -- | -- |
| cassandra | spring-boot-starter-data-cassandra | spring-boot-starter-data-cassandra-2.4.0 이상 | [whatap-spring-boot-starter-data-cassandra-2.4.0](weaving/cassandra/spring-boot-starter-data-cassandra/whatap-spring-boot-starter-data-cassandra-2.4.0) |
| kafka | spring-cloud-stream-binder-kafka | spring-cloud-stream-binder-kafka-3.0.5.RELEASE 이상 | [whatap-spring-kafka-stream-2.2.0](weaving/kafka/spring-kafka-stream/whatap-spring-kafka-stream-2.2.0) |
| log4j | spring-boot-starter-log4j2 | spring-boot-starter-log4j2-1.5.0 이상 | [whatap-spring-boot-starter-log4j2-1.5.0](weaving/log4j/spring-boot-starter-log4j2/whatap-spring-boot-starter-log4j2-1.5.0) |
| ^     | ^                          | spring-boot-starter-log4j2-2.1.3 이상 | [whatap-spring-boot-starter-log4j2-2.1.3](weaving/log4j/spring-boot-starter-log4j2/whatap-spring-boot-starter-log4j2-2.1.3) |
| ^     | ^                          | spring-boot-starter-log4j2-2.6.3 이상 | [whatap-spring-boot-starter-log4j2-2.6.3](weaving/log4j/spring-boot-starter-log4j2/whatap-spring-boot-starter-log4j2-2.6.3) |
| logback | spring-boot-starter-logging | spring-boot-starter-logging-2.6.2 이상 | [whatap-spring-boot-starter-logging-2.6.2](weaving/logback/spring-boot-starter-logging/whatap-spring-boot-starter-logging-2.6.2) |
| mongodb | spring-boot-starter-data-mongodb | spring-boot-starter-data-mongodb-2.3.0 이상 | [whatap-spring-boot-starter-data-mongodb-2.3.0](weaving/mongodb/spring-boot-starter-data-mongodb/whatap-spring-boot-starter-data-mongodb-2.3.0) |
| ^       | ^                                | spring-boot-starter-data-mongodb-2.4.0 이상 | [whatap-spring-boot-starter-data-mongodb-2.4.0](weaving/mongodb/spring-boot-starter-data-mongodb/whatap-spring-boot-starter-data-mongodb-2.4.0) |
| ^       | ^                                | spring-boot-starter-data-mongodb-2.4.4 이상 | [whatap-spring-boot-starter-data-mongodb-2.4.4](weaving/mongodb/spring-boot-starter-data-mongodb/whatap-spring-boot-starter-data-mongodb-2.4.4) |
| mongodb-reactive | spring-boot-starter-data-mongodb-reactive | spring-boot-starter-data-mongodb-reactive-2.1.0 이상 | [whatap-spring-boot-starter-data-mongodb-reactive-2.1.0](weaving/mongodb/spring-boot-starter-data-mongodb-reactive/whatap-spring-boot-starter-data-mongodb-reactive-2.1.0) |
| ^                | ^                                         | spring-boot-starter-data-mongodb-reactive-2.3.0 이상 | [whatap-spring-boot-starter-data-mongodb-reactive-2.3.0](weaving/mongodb/spring-boot-starter-data-mongodb-reactive/whatap-spring-boot-starter-data-mongodb-reactive-2.3.0) |
| ^                | ^                                         | spring-boot-starter-data-mongodb-reactive-2.6.0 이상 | [whatap-spring-boot-starter-data-mongodb-reactive-2.6.0](weaving/mongodb/spring-boot-starter-data-mongodb-reactive/whatap-spring-boot-starter-data-mongodb-reactive-2.6.0) |
| ^                | ^                                         | spring-boot-starter-data-mongodb-reactive-3.0.0 이상 | [whatap-spring-boot-starter-data-mongodb-reactive-3.0.0](weaving/mongodb/spring-boot-starter-data-mongodb-reactive/whatap-spring-boot-starter-data-mongodb-reactive-3.0.0) |
| rabbitmq | spring-cloud-starter-stream-rabbit | spring-cloud-starter-stream-rabbit-3.0.0 이상 | [whatap-spring-cloud-stream-rabbit-3.0.0](weaving/rabbitmq/whatap-spring-cloud-stream-rabbit/whatap-spring-cloud-stream-rabbit-3.0.0) |
| redis | spring-boot-starter-data-redis | spring-boot-starter-data-redis-2.2.0 이상 | [whatap-spring-boot-starter-data-redis-2.2.0](weaving/redis/spring-boot-starter-data-redis/whatap-spring-boot-starter-data-redis-2.2.0) |
| ^     | ^                              | spring-boot-starter-data-redis-2.3.0 이상 | [whatap-spring-boot-starter-data-redis-2.3.0](weaving/redis/spring-boot-starter-data-redis/whatap-spring-boot-starter-data-redis-2.3.0) |
| ^     | ^                              | spring-boot-starter-data-redis-2.4.0 이상 | [whatap-spring-boot-starter-data-redis-2.4.0](weaving/redis/spring-boot-starter-data-redis/whatap-spring-boot-starter-data-redis-2.4.0) |
| ^     | ^                              | spring-boot-starter-data-redis-2.5.0 이상 | [whatap-spring-boot-starter-data-redis-2.5.0](weaving/redis/spring-boot-starter-data-redis/whatap-spring-boot-starter-data-redis-2.5.0) |
| solr | spring-data-solr | spring-data-solr-2.0.0 ~ 2.4.x | [whatap-spring-data-solr-2.0.0](weaving/solr/spring-data-solr/whatap-spring-data-solr-2.0.0) |
| webflux | spring-boot-starter-webflux | spring-boot-starter-webflux-2.1.0 이상 | [whatap-spring-boot-starter-webflux-2.1.0](weaving/spring-boot-starter-webflux/whatap-spring-boot-starter-webflux-2.1.0) |
| ^       | ^                           | spring-boot-starter-webflux-2.2.0 이상 | [whatap-spring-boot-starter-webflux-2.2.0](weaving/spring-boot-starter-webflux/whatap-spring-boot-starter-webflux-2.2.0) |
| ^       | ^                           | spring-boot-starter-webflux-3.0.0 이상 | [whatap-spring-boot-starter-webflux-3.0.0](weaving/spring-boot-starter-webflux/whatap-spring-boot-starter-webflux-3.0.0) |
| websocket | spring-boot-starter-websocket | spring-boot-starter-websocket-1.5.6.RELEASE 이상 (sockjs 사용) | [whatap-spring-boot-starter-websocket-sockjs-1.5.6](weaving/spring-boot-websocket/whatap-spring-boot-starter-websocket-sockjs-1.5.6) |
| ^         | ^                             | spring-boot-starter-websocket-1.5.6.RELEASE 이상 (stomp 사용) | [whatap-spring-boot-websocket-stomp-messaging-1.5.6](weaving/spring-boot-websocket/whatap-spring-boot-websocket-stomp-messaging-1.5.6) |
| gateway | spring-cloud-gateway | spring-cloud-starter-gateway-2.0.0 이상 | [whatap-spring-cloud-starter-gateway-2.0.0](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.0.0) |
| ^       | ^                    | spring-cloud-starter-gateway-2.0.1 이상 | [whatap-spring-cloud-starter-gateway-2.0.1](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.0.1) |
| ^       | ^                    | spring-cloud-starter-gateway-2.0.2 이상 | [whatap-spring-cloud-starter-gateway-2.0.2](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.0.2) |
| ^       | ^                    | spring-cloud-starter-gateway-2.0.3 이상 | [whatap-spring-cloud-starter-gateway-2.0.3](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.0.3) |
| ^       | ^                    | spring-cloud-starter-gateway-2.0.4 이상 | [whatap-spring-cloud-starter-gateway-2.0.4](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.0.4) |
| ^       | ^                    | spring-cloud-starter-gateway-2.1.0 이상 | [whatap-spring-cloud-starter-gateway-2.1.0](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.1.0) |
| ^       | ^                    | spring-cloud-starter-gateway-2.1.1 이상 | [whatap-spring-cloud-starter-gateway-2.1.1](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.1.1) |
| ^       | ^                    | spring-cloud-starter-gateway-2.1.2 이상 | [whatap-spring-cloud-starter-gateway-2.1.2](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.1.2) |
| ^       | ^                    | spring-cloud-starter-gateway-2.1.3 이상 | [whatap-spring-cloud-starter-gateway-2.1.3](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.1.3) |
| ^       | ^                    | spring-cloud-starter-gateway-2.1.4 이상 | [whatap-spring-cloud-starter-gateway-2.1.4](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.1.4) |
| ^       | ^                    | spring-cloud-starter-gateway-2.1.5 이상 | [whatap-spring-cloud-starter-gateway-2.1.5](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.1.5) |
| ^       | ^                    | spring-cloud-starter-gateway-2.2.0 이상 | [whatap-spring-cloud-starter-gateway-2.2.0](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.2.0) |
| ^       | ^                    | spring-cloud-starter-gateway-2.2.1 이상 | [whatap-spring-cloud-starter-gateway-2.2.1](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.2.1) |
| ^       | ^                    | spring-cloud-starter-gateway-2.2.2 이상 | [whatap-spring-cloud-starter-gateway-2.2.2](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.2.2) |
| ^       | ^                    | spring-cloud-starter-gateway-2.2.9 이상 | [whatap-spring-cloud-starter-gateway-2.2.9](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-2.2.9) |
| ^       | ^                    | spring-cloud-starter-gateway-3.0.0 이상 | [whatap-spring-cloud-starter-gateway-3.0.0](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-3.0.0) |
| ^       | ^                    | spring-cloud-starter-gateway-3.0.2 이상 | [whatap-spring-cloud-starter-gateway-3.0.2](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-3.0.2) |
| ^       | ^                    | spring-cloud-starter-gateway-3.0.3 이상 | [whatap-spring-cloud-starter-gateway-3.0.3](weaving/spring-cloud-gateway/whatap-spring-cloud-starter-gateway/whatap-spring-cloud-starter-gateway-3.0.3) |
