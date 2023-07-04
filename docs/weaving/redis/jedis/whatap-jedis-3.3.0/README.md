---
title: whatap-jedis-3.3.0 plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-jedis-3.3.0 플러그인 입니다.

## Current Version

---

현재 버전은 2022년 12월 16일 배포된 버전 입니다. [v1.0]

:::note

와탭 자바 에이전트 v2.1.2 이후의 버전에서 사용할 수 있습니다.

jedis-3.3.0 버전을 추적합니다.

jedis 버전과 와탭의 whatap-jedis-3.3.0 플러그인 버전 관계를 [아래](#jedis-and-whatap-jedis-plugin-compatibility)에서 확인할 수 있습니다.

:::

## Release Note

---

## v1.0

Release on: 2022-12-16

Init release

## How to use

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

whatap.conf 파일 설정을 통해 플러그인 기능을 활성화 할 수 있습니다. 설정 예시는 [아래](#whatapconf)에서 확인할 수 있습니다.

## Configuration

---

| 에이전트 설정            | 초기값    | 설명                        |
| --------------------- | :-----: | :------------------------- |
| jedis_basetime        | 100     | 소요시간이 jedis_basetime을 넘는 경우에 트랜잭션 데이터 수집 |

### whatap.conf

```ini title='whatap.conf'
# whatap-jedis (default) 
jedis_basetime=100
```

## jedis and whatap-jedis-plugin compatibility

---

jedis 버전과 whatap-jedis-3.3.0 플러그인의 의존 관계 확인할 수 있습니다.

### jedis-3.3.0 ~

---
    jedis-3.3.0
        whatap-jedis-3.3.0-v1.0.jar (16-December-2022)
---
