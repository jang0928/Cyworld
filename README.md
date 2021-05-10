# Myworld 


### 프로젝트 기획 의도 
한때 많이 이용했던 싸이월드 미니홈피를 요즘의 감성에 맞게 새롭게 구축을 하여
추억을 되살리고자 간단한 미니홈피를 기획
### 프로젝트 기간
  +  2021.02.26 ~ 2021.03.25 
###  데이터 베이스 구조 

![image](https://user-images.githubusercontent.com/59501566/117623778-2e5a6000-b1af-11eb-88a6-efd301b3c1b1.png)

### 로그인 기능  
---
**[ 권한에 따른 페이지 전환 ]**




![image](https://user-images.githubusercontent.com/59501566/117626036-a45fc680-b1b1-11eb-8fac-eced0cf2f502.png)
 
  + 로그인 페이지에서의 id,passward 를 받아와 권한에 따라 관리자페이지, 메인 페이지로 이동합니다. 
  + 아이디의 권한이 master, staff 라면 관리자 페이지로 이동합니다. 
 
### 회원 기능  
---
**[ 메인 화면  ]**
![image](https://user-images.githubusercontent.com/59501566/117628869-8cd60d00-b1b4-11eb-828f-d2e4448a36b5.png)



1. 게시글 작성
   > 게시물 버튼을 통한 게시글 작성 file 업로드 버튼을 통한 사진 추가
![image](https://user-images.githubusercontent.com/59501566/117629022-b4c57080-b1b4-11eb-919e-16f01d9c741a.png)




2. 프로필 작성
   > 프로필 버튼을 통한 프로필 사진 , 소개글 작성
3. 사진첩 , 게시글 조회
   > 사진이 포함된 게시물과 포함되지 않은 게시글 상세보기
   ![image](https://user-images.githubusercontent.com/59501566/117629248-f0f8d100-b1b4-11eb-8e89-5e87f803e27d.png)


4. 댓글 작성
   > 게시글 및 사진첩에 댓글 달기를 통한 소통
5. 방명록 작성
   > 단순 댓글로만의 소통 기능
6. Total 방문자
   > 본인이 아닌 다른 회원이 방문시 total 횟수 증가
7. 친구 목록
   > 나를 팔로우한 친구와 내가 팔로잉한 친구 조회
   >> 새 친구 찾기를 통한 모든 회원 검색 
   >>> 친구 더블 클릭 시 해당 친구의 미니홈피로 이동
  ![image](https://user-images.githubusercontent.com/59501566/117629339-066dfb00-b1b5-11eb-9a84-86b3bac79b85.png)
8. 최신순으로 페이징 처리
   > 최근 게시글 날짜 순서로 페이징 처리 


### 관리자 기능  
---
**[ 메인 화면  ]**
 
![image](https://user-images.githubusercontent.com/59501566/117629752-73819080-b1b5-11eb-87bd-c0be6abf713f.png)



1. 정보 카운트
  > 전체 회원 수 , 게시글 , 폰트 및 배경화면 갯수를 카운트하여 조회함
2. 회원 관리
  > 전체 회원의 간단한 정보 출력
  >> 회원 검색 기능
  >>> 회원 이름 더블 클릭하여 상세정보 조회 -> 삭제 기능 
 ![image](https://user-images.githubusercontent.com/59501566/117630277-fefb2180-b1b5-11eb-90b6-1d5c8cdbe8d4.png)
 >>>![image](https://user-images.githubusercontent.com/59501566/117630358-13d7b500-b1b6-11eb-876a-f7ac88997b2e.png)
 
3. 게시글 관리 
  > 회원 전체의 게시글 조회 
  >> 게시글 검색 기능 
  >>> 게시글  더블 클릭하여 상세정보 조회 -> 삭제 기능 
  >>> ![image](https://user-images.githubusercontent.com/59501566/117630815-89438580-b1b6-11eb-9996-bcfbb90081dd.png)
  >>> ![image](https://user-images.githubusercontent.com/59501566/117630836-8ea0d000-b1b6-11eb-8446-18202973e6f5.png)


4. 배경 관리
 > 배경 url 및  배경 이름 등록
 >> 배경 목록을 통한 등록된 배경 정보 조회 및 카운트 
5. 폰트 관리 
 > 폰트 이름 , url , font- family 등록
 >> 폰트 목록을 통한 등록된 폰트 정보 조회 및 카운트






