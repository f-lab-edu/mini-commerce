# mini-commerce
미니 커머스 서비스

# 상세
## 사용 기술 및 환경
`Java 11`
`Spring Boot`
`Spring Security`
`JPA(Hibernate)`
`Swagger`
`Jenkins`
`MySQL`

## Life Cycle
![KakaoTalk_Photo_2023-03-25-14-03-30](https://user-images.githubusercontent.com/63723145/227697366-22618a27-c325-4e63-aeec-daad627bf49b.jpeg)
- 회원 가입 / 로그인을 한다.
  - 일반 유저와 판매자를 구분한다.
- 판매자의 입장에서 상품을 등록한다.
- 카테고리별 혹은 검색어로 상품을 검색한다.
- 상품리스트에서 선택된 상품은 상세를 표시한다.
- 상품은 장바구니 혹은 바로구매를 할 수 있다.
- 주문한다. 금액은 상품 및 수량에 따라 결정된다.
- 결제한다.
- 사용자는 상품에 대해서 피드백한다.

## 기능정의
- 회원 가입 / 로그인을 한다.
  - 가입된 유저의 권한을 구분할 수 있다.
  
- 판매자의 입장에서 상품을 등록한다.
  - 판매자가 상품을 등록할 수 있는 별도의 기능이 필요하다.
  - 판매자는 가격에 대하여 정의할 수 있어야 한다.

- 카테고리별 혹은 검색어로 상품을 검색한다.
  - 상품명으로 검색이 가능하다.
  - 카테고리를 지정하여, 검색이 가능하다.
  
- 상품리스트에서 선택된 상품은 상세를 표시한다.
  - 수량 선택이 가능해야 한다.
  - 해당 상품의 리뷰를 볼수 있다.

- 상품은 장바구니 혹은 바로구매를 할 수 있다.
  - 유저는 개별의 장바구니를 가진다.

- 주문한다. 금액은 상품 및 수량에 따라 결정된다.
  - 주문 정보 & 배송 정보를 입력한다.
  - 멤버쉽에 따른 할인 정보를 보여준다.
  
- 결제한다. 
  - PG 서비스를 이용하여 결제 한다.
  
- 사용자는 상품에 대해서 피드백한다.
  - 구매한 상품에 대해서만 리뷰 작성이 가능하다.
  - 상품의 별점을 추가할수 있다.
  
## 어플리케이션 아키텍쳐 스케치
![KakaoTalk_Photo_2023-03-25-15-26-24](https://user-images.githubusercontent.com/63723145/227700848-5df4b3da-c6c5-4c83-88f5-036832bc8be8.jpeg)


## 배포
<img width="680" alt="be" src="https://user-images.githubusercontent.com/63723145/227700741-edf759f7-2f53-470c-a435-fea484d72b26.png">

- GitHub Action과 젠킨스를 활용하여 배포를 진행한다.

## WBS
- https://trello.com/b/did1peQK/mini-commerce

