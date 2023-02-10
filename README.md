# Spring Boilerplate

드림포라에서 Spring 을 개발하기 위한 보일러 플레이트이다.  
다음 조건을 만족해야한다.

1. 인수 테스트와 단위 테스트 환경을 세팅해야한다.
2. API 문서화를 위한 환경이 세팅되어야 한다.

## 스크립트

```
# 빌드 및 실행
./gradlew build
java -jar build/libs/*.jar

# API 문서 생성
# build/docs/asciidoc/index.html
./gradlew asciidoctor

# API 문서를 resources 로 이동
./gradlew copyDocument
```

## Reference

- [우아한 형제들 기술 블로그: Rest Docs 적용](https://techblog.woowahan.com/2597)
