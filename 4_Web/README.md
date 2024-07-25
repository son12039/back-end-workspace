# Web Server와 WAS

## 웹 서버(Wdb Server)

- 웹에서 서버 기능을 수행하는 프로그램으로 HTML 문서나 JPG, PNG 같은 이미지를 HTTP 프로토콜을 통해 웹 브라우저에 제공하는 서버
- 서버 내부의 이미 만들어져 있는 정적인 요소들을 화면에 제공하는 역할
- Apache : Apache Software Foundation에서 만든 웹 서버로 HTTP 통신에 대한 여러 라이브러리 제공

## 웹 애플리케이션 서버(WAS, Web Application Server)

- 웹 서버가 할 수 없는 다양한 비즈니스 로직을 수행하고 동적인 페이지를 만들어 제공하는 서버
- 웹 애플리케이션 서버는 웹 서버와 컨테이너로 구성
- Tomcat : Apache Software Foundation에서 Servlet과 JSP를 통한 동적인 웹 문서를 처리하기 위해 만든 웹 애플리케이션 서버

# 서블릿(Servlet)

- 웹 서비스를 위한 자바 클래스를 말하며 자바를 사용해서 웹을 만들기 위한 기술
- 웹 브라우저로부터 요청을 받아 처리하고 결과를 다시 웹 브라우저로 응답하는 역할
