# 📖 KnowledgeForest
지식의 숲
##### 📆 2025.01.06 ~ 2025.01.23
<br>

## 📢 IT 개발 & 보안 스터디 모집 사이트 - ‘지식의 숲’
#### 스터디 모집 플랫폼
개인의 부족한 역량을 보완하기 위한 스터디 또는 프로젝트 단위 팀 구성을 목표로, 사용자가 직접 스터디 그룹을 생성하거나 기존 그룹에 참여할 수 있도록 돕는 웹 서비스입니다.

## 🔧 개발 환경
![JSP Tool 이미지](https://github.com/soooohyeon/soooohyeon/blob/main/assets/image/kdt/tools.png?raw=true)

## 📌 맡은 업무
### [퍼블리싱]
- 관리자 페이지
  
### [백엔드]
#### ① 회원가입
  - 비밀번호 유효성 검사 추가

#### ② 로그인 / 로그아웃
  - 로그인 실패시 alert 창 출력
  - 로그아웃시 alert 창 출력

#### ③ 비밀번호 변경
  - 아이디 및 휴대폰 인증을 통한 계정 찾기
  - 비밀번호 수정

#### ④ 관리자 페이지
0. 메인
    - 사용자, 자유 게시판, 스터디, 공지사항 최신 순 5개씩 출력
1. 사용자 관리
    - 모든 사용자 리스트 출력
    - 필터 검색, 페이징 처리
    - 사용자 탈퇴 (삭제)
2.  스터디 관리
    - 모든 스터디 리스트 출력
    - 필터 검색, 페이징 처리
    - 마감일 또는 스터디 신청인원에 다른 상태 출력
    - 스터디 글 삭제 (확정 인원 1명 이상일 시 삭제 불가)
3. 스터디 댓글 관리
    - 모든 스터디 댓글 리스트 출력
    - 필터 검색, 페이징 처리
    - 스터디 댓글 삭제
4. 스터디 신청자 관리
    - 모든 신청자 리스트 출력
    - 필터 검색, 페이징 처리
    - 스터디 신청 상세 내역 확인
    - 현재 상태가 대기 중인 신청 글 삭제
6. 자유 게시판 관리
    - 모든 게시판 글 리스트 출력
    - 필터 검색, 페이징 처리
    - 게시판 글 삭제
7. 자유 게시판 댓글 관리
    - 모든 게시판 댓글 리스트 출력
    - 필터 검색, 페이징 처리
    - 스터디 댓글 삭제
8. 공지사항 관리
    - 공지사항 작성, 수정, 삭제
    - 모든 공지 글 리스트 출력
    - 필터 검색, 페이징
    - 단일 첨부파일 추가
9. 배너 관리
    - 배너 작성, 수정, 삭제
    - 모든 배너 리스트 출력
    - 필터 검색, 페이징
    - 단일 배너 이미지 등록 가능

## 📚 ERD
![JSP Tool 이미지](https://github.com/soooohyeon/soooohyeon/blob/main/assets/image/kdt/erd1.png?raw=true)
![JSP Tool 이미지](https://github.com/soooohyeon/soooohyeon/blob/main/assets/image/kdt/erd2.png?raw=true)

## 👀 메뉴트리
#### [사용자 WEB - Login]
![JSP Tool 이미지](https://github.com/soooohyeon/soooohyeon/blob/main/assets/image/kdt/menu_tree_login.png?raw=true)

#### [사용자 WEB - Logout]
![JSP Tool 이미지](https://github.com/soooohyeon/soooohyeon/blob/main/assets/image/kdt/menu_tree_logout.png?raw=true)

#### [관리자 WEB]
![JSP Tool 이미지](https://github.com/soooohyeon/soooohyeon/blob/main/assets/image/kdt/menu_tree_admin.png?raw=true)

## 😃 느낀점
고객용 게시판은 검색 후 페이지 이동 기능이나, 다양한 외부 API 연동 등 좀 더 정교한 기능을 구현해보고 싶었지만, 실제로 경험해보지 못한 점이 아쉬움으로 남습니다.
또한 직접 사용자의 입장에서 사이트를 이용해보았을 때, UI 측면에서 불편할 수 있는 부분이 분명 존재한다고 느꼈습니다.
추후 프로젝트를 다시 점검하고 정리하면서 이러한 부분들을 개선하고, 기능적으로도 업그레이드해볼 수 있으면 좋을 것 같습니다.

## 😥 아쉬운점
프로젝트를 진행하며 가장 어려웠던 점은 개발 기간이 짧았던 것도 있었지만, IDE 환경 설정이나 서버 이슈 해결에 대부분의 시간이 소요된 부분이 가장 힘들었던 것 같습니다.
특히 협업이 중심이 되는 프로젝트였던 만큼, 세세한 부분까지 맞춰가며 진행해야 했고, 제 PC에서는 정상적으로 작동하던 기능이 다른 환경에서는 오류를 발생시키는 경우도 있어 이를 해결해나가는 과정이 가장 힘들었습니다.
