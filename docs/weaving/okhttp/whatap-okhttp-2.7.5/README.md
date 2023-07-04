---
title: whatap-okhttp-2.7.5 Plugin
---

와탭랩스의 자바 어플리케이션 모니터링을 위한 whatap-okhttp-2.7.5 플러그인 입니다.

## Current Version

---

현재 버전은 2023년 03월 15일 배포된 버전 입니다 [v1.1]

:::note

다음 와탭 자바 에이전트 이후의 버전이 필요합니다.

```
whatap.agent-2.1.3.jar
```

okhttp3 버전과 와탭의 whatap-okhttp3 플러그인 버전 관계를 [아래](#okhttp3-and-whatap-okhttp3-plugin-compatibility)에서 확인할 수 있습니다.

:::

## Release Note

---

### v1.1

Release on: 2023-03-15

#### Update

와탭자바에이전트 버전을 v2.1.1에서 v2.2.0으로 수정

### v1.0

Release on: 2021-06-07

Init release

## How to

---

whatap.conf 파일이 있는 위치에 있는 instrument 폴더(없는 경우 폴더 생성)에 whatap-xxx.jar 파일 추가합니다.

## okhttp-and-whatap-okhttp-plugin-compatibility

### com.squareup.okhttp-2.7.5

---
    com.squareup.okhttp3-2.7.5
        whatap-okhttp-2.7.5-v1.1.jar
---
