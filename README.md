# To-Do List

## 기능 요구사항
- [x] 할 일 추가: 제목과 마감일을 입력받아서 추가.
  - [x] 자료구조를 Map<String, LocalDate>에서 Map<String, TodoItem>으로 변경. -> 이유: 확장성을 높이기 위해서.
- [x] 할 일 조회: 전체 할 일을 출력.
- [x] 할 일 수정: 특정 할 일의 제목, 마감일 수정.
  - [x] property로 "title", "deadLine"등 속성을 받아서 새로운 값으로 변경
- [x] 할 일 삭제: 특정 할 일을 삭제.
- [x] 파일 저장: 프로그램 종료 후에도 데이터 유지.
  - [x] jackson 라이브러리를 사용해서 json 파일로 저장.
- [x] 파일 로드: 저장한 Map 불러오기
  - [x] json 파일을 불러와서 변환한 Map 자료구조를 TodoImpl 객체에 넣기.
