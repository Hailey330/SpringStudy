# Spring Security OAuth2.0 Version.2

- 페이스북, 구글 로그인 및 기본 시큐리티 연동

### Spring Security 기본 Version.1 참고

- https://github.com/Hailey330/Spring_Security

### JPA method names 참고

![blog](https://postfiles.pstatic.net/MjAyMDA4MDRfMTU1/MDAxNTk2NTA2ODAyMTgx.Qoff6FQ1RJyGw83meuDXT5J5e-Ac1WwSJMH2wf1l1Swg.KinVePXqdUOeyDYYRp4aguwTsxF0OBQB64LNUYTJRRgg.PNG.getinthere/Screenshot_26.png?type=w773)

### application.yml 설정

```yml
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/security?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234

  mvc:
    view:
      prefix: /templates/
      suffix: .mustache

  jpa:
    hibernate:
      ddl-auto: update #create update none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true

  security:
    oauth2:
      client:
        registration:
          google: # /oauth2/authorization/google 이 주소를 동작하게 한다.
            client-id: 어쩌구저쩌구
            client-secret: 어쩌구저쩌구
            scope:
              - email
              - profile
          facebook:
            client-id: 어쩌구저쩌구
            client-secret: 어쩌구저쩌구
            scope:
              - email
          # 네이버, 카카오는 OAuth2.0 공식 지원대상이 아니라서 provider 설정이 필요하다.
          naver:
            client-id: 어쩌구저쩌구
            client-secret: 어쩌구저쩌구
            redirect-uri: '{baseUrl}/{action}/oauth2/code/{registrationId}'
            authorization-grant-type: authorization_code
            client-authentication-method: POST
            scope:
              - name
              - email
            client-name: Naver # 대문자로 시작 (구글, 페이스북도 마찬가지)
          kakao:
            client-id: 어쩌구저쩌구
            client-secret: 어쩌구저쩌구
            redirect-uri: '{baseUrl}/{action}/oauth2/code/{registrationId}'
            authorization-grant-type: authorization_code
            client-authentication-method: POST
            scope:
              - profile
              - account_email
            client-name: Kakao
        provider:
          naver:
            authorization-uri: https://nid.naver.com/oauth2.0/authorize
            token-uri: https://nid.naver.com/oauth2.0/token
            user-info-uri: https://openapi.naver.com/v1/nid/me
            user-name-attribute: response # 회원정보를 json의 response 키 값으로 리턴
          kakao:
            authorization-uri: https://kauth.kakao.com/oauth/authorize
            token-uri: https://kauth.kakao.com/oauth/token
            user-info-uri: https://kapi.kakao.com/v2/user/me
            user-name-attribute: id
```
