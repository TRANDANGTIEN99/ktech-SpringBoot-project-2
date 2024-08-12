# ktech-SpringBoot-project-2
# Spring Basic - 웹사이트 구축

사용자들이 자기 자신의 정보를 직접 드러낼 필요 없이 의견을 교환할 수 있는 웹 페이지를 만들어보자.

자신이 누군지를 드러낼 필요는 없지만 작성한 사람이 원한다면 수정하거나 삭제는 가능해야 한다.

##
## 필수 과제

- 게시판 관련 기능
- 게시글 관련 기능
- 댓글 관련 기능

## 도전 과제

- 게시글 추가기능
- 헤시태그 기능
- 검색 관련 기능

## 필수 과제 요구사항

### 게시판 기능

- 게시판은 같은 주제의 게시글을 모아둔 단위를 의미한다.
- 게시판의 목록과, 선택된 게시판의 게시글 목록을 볼 수 있는 화면이 필요하다.
    - 게시판 목록의 링크를 선택하면, 해당 게시판에 작성된 게시글 제목만 목록으로 출력되는 화면으로 이동한다.
    - 또한 전체 게시글을 위한 전체 게시판이 존재한다.
    - 게시글 제목은 링크로, 해당 게시글의 정보를 전부 조회할 수 있는 페이지로 이동된다.
    - 조회되는 게시글들은 항상 나중에 작성된 게시글이 최상단에 작성된다.
- 자유 게시판, 개발 게시판, 일상 게시판, 사건사고 게시판이 존재한다.
### 게시글 기능

- 게시글은 하나의 주제에 대한 의견을 교환하기 위한 글을 의미한다.
    - 제목, 내용으로 구성되어 있다.
    - 게시글이 작성되는 게시판이 존재한다.
- 게시글을 작성할 수 있다.
    - 게시글을 작성하는 페이지가 필요하다.
    - 게시글을 작성하는 페이지에서 어떤 게시판에 작성할지를 선택 가능하다.
    - 게시글의 제목과 내용을 작성한다.
    - 게시글의 내용 자체는 Plain Text로만 구성된다.
    - 게시글을 작성할때는 작성자가 자신임을 증명할 수 있는 비밀번호를 추가해서 작성한다.
- 게시글 단일 조회 화면이 필요하다.
    - 댓글과 관련된 기능은 이 화면에 포함된다.
        - 댓글 목록
        - 댓글 추가하기
        - 댓글 삭제하기
    - 게시글 삭제를 위한 UI가 여기 존재한다.
- 게시글을 수정할 수 있다.
    - 게시글을 수정하는 페이지가 필요하다.
    - 게시글을 수정하는 페이지에는, 게시글의 본래 제목, 글이 존재한다.
    - 게시글 수정을 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 게시글 작성 당시의 비밀번호와 일치해야 실제로 수정이 이뤄진다.
- 게시글을 삭제할 수 있다.
- 단일 게시글 조회 페이지에 있는 삭제를 위한 UI를 이용해 삭제한다.
- 게시글 삭제를 위해 비밀번호를 제출할 수 있어야 한다.
    - 이 비밀번호가 게시글 작성 당시의 비밀번호와 일치해야 실제로 삭제가 이뤄진다.

### 댓글 기능

- 댓글을 작성할 수 있다.
    - 댓글의 작성은 게시글 단일 조회 페이지에서 이뤄진다.
    - 댓글을 작성할때는 작성자가 자신임을 증명할 수 있는 비밀번호를 추가해서 작성한다.
- 댓글의 목록은 게시글 단일 조회 페이지에서 확인이 가능하다.
- 댓글의 삭제는 게시글 단일 조회 페이지에서 가능하다.
    - 댓글 삭제를 하기 위한 UI가 존재해야 한다.
    - 댓글 삭제를 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 댓글 작성 당시의 비밀번호와 일치해야 실제로 삭제가 이뤄진다.
        ## 필수 기능 엔드포인트 (제안)

- 게시판 보기: `/boards/{boardId}/`
- 게시글 작성하기: `/boards/{boardId}/article/`
- 게시글 보기: `/articles/{articleId}`
- 게시글 수정하기: `/articles/{articleId}/update/`
- 게시글 삭제하기: `/articles/{articleId}/delete/`
- 댓글 작성하기: `/articles/{articleId}/comments/`
- 댓글 삭제하기: `/articles/{articleId}/comments/{commentId}/delete/`
## 도전 과제 요구사항

### 게시글 추가 기능

- 게시글 단일 조회 페이지에 이전글 다음글 기능이 추가된다.
    - 이전글 링크를 클릭하면 같은 게시판의 게시글 중, 현재 게시글보다 나중에 작성된 게시글 중 가장 일직 작성된 게시글 단일 조회 페이지로 이동한다.
    - 다음글 링크를 클릭하면 같은 게시판의 게시글 중, 현재 게시글보다 먼저 작성된 게시글 중 가장 늦게 작성된 게시글 단일 조회 페이지로 이동한다.
    - 전체 게시판에서 게시글을 조회하는 경우, 게시판 구분 없이 동일한 기준으로 동작한다.

### 해시태그 기능

- 게시글을 작성할때, 사용자가 입력한 내용을 바탕으로 해시태그를 추출한다.
    - 해시태그는 사용자가 작성한 내용 중, `#` 으로 시작하는 단어를 의미한다.
- 특정 해시태그를 가진 게시글 목록을 볼수 있는 화면이 필요하다.
- 게시글 단일 조회 페이지의 내용 뒤쪽에 사용된 해시태그 목록이 표기된다.
    - 링크로서 동작하며, 클릭시 해당 해시태그가 포함된 게시글 목록을 보는 화면으로 이동된다.

### 검색 기능

- 게시글 목록을 확인할 수 있는 페이지에, 검색을 위한 UI가 추가된다.
    - 사용자가 검색어를 입력해서 검색을 할 수 있다.
- 검색을 하면서 검색 기준을 선택할 수 있다.
    - 제목
    - 내용
- 개별 게시판이 선택된 상태론 해당 게시판 내에서, 전체 게시판이 선택된 상태론 전체 게시글 중 검색한다.
## 주의사항

- 자신이 완성한 프로젝트에 대한 설명이 담긴 [`README.md`](http://README.md) 를 반드시 첨부한다.
    - 필수 요구사항을 구현한 방식에 대한 기초적인 설명을 첨부한다.
    - 진행중 발생한 어려움에 대한 기록을 첨부한다.
    - 완성된 프로젝트를 어떻게 실행하고 테스트 하는지에 대한 기록을 첨부한다.
- 프로젝트를 실행 중 만든 데이터(게시글, 댓글 등)는 프로젝트를 종료해도 기록이 남아 있어야 한다.
- 완성된 프로젝트는 `github`에서 `clone`을 했을때, 특별한 설정 없이 실행이 가능한 프로젝트여야 한다.
    - `clone`을 받은 폴더를 Intellij로 프로젝트로 열면 바로 실행이 가능한 상태여야 한다.
    - 정상적인 실행을 위해 추가적인 코드의 수정이 필요하지 않아야 한다.
    - 실행을 위해 실행하는 컴퓨터에 추가적인 프로그램의 설치 또는 설정이 필요하지 않아야 한다.