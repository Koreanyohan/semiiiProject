*templates 구조
=> layout폴더 - index.html이 뼈대.  같은 폴더의 fragment.html로부터 조각 3개(frag1, frag2, frag3)받아옴. 각각 탭, 화면 상단, 사이드바 부분. 전부 어떤페이지에도 나타나게 함.
			& index.html의 39행에서 다른 html로 부터 조각을 받아옴. 메인은 start.html을 조각으로 해서 받아옴.
=> 제품은, 메인 창에서 쇼핑 버튼-> 모든카테고리  & 패션의류 / 잡화만 구현됨

* crud 구현한 것

1. 아이템 => 화면 메인 페이지(http://localhost:8080/items/start) => 우측 상단 아이템 등록하기 버튼

=> controller 폴더 - controller.java 
=> dto 폴더 - ItemDto.java
=> entity 폴더 - Item.java
=> repository 폴더 - ItemRepository.java
=> service 폴더 - ItemService.java & ItemServiceImpl.java

// template 폴더 - items 폴더
   1) 목록 : register.html
   2) 등록 : register_items.html
   3) 상세조회 : infoRead.html
   4) 조회&삭제 : modify.html
   
   

2. 리뷰(품목 각자는 못함) => 품목 눌렀을때 리뷰 버튼을 누르면 (http://localhost:8080/review/register)로 이동됨.

=> controller 폴더 - ReviewController.java 
=> dto 폴더 - ReviewDto.java
=> entity 폴더 - Review.java
=> repository 폴더 - ReviewRepository.java
=> service 폴더 - ReviewService.java & ReviewServiceImpl.java

// template 폴더 - review 폴더
   1) 목록 : register.html
   2) 등록 : register_reviews.html
   3) 상세조회 : infoRead.html
   4) 조회&삭제 : modify.html
  
  
  
  
3. 장바구니 (만드는 법을 몰라서 조악하게 만듬. 위에 것과 기능 거의 유사.)  
	/ 화면 메인 페이지(http://localhost:8080/items/start) => 우측 상단에 있음. (담긴 제품 갯수 표기 기능 구현 예정)

=> controller 폴더 - CartController.java 
=> dto 폴더 - ItemDto_Cart.java
=> entity 폴더 - Item_Cart.java
=> repository 폴더 - Item_CartRepository.java
=> service 폴더 - CartService.java & CartServiceImpl.java

// template 폴더 - cart 폴더
// template 폴더 - review 폴더
   1) 목록 : cart_list.html
   2) 등록 : 품목 창에서 밑에 장바구니로 버튼 누르면 등록
   3) 상세조회 : infoRead.html
   4) 조회&삭제 : modify.html




* 문제점 - 페이지 옮겨지면
상단의 쇼핑버튼을 눌러도 목록이 안뜸.

피드백
: 부트스트랩 css기능 - 리소스폴더 -> static폴더에서 css폴더-styles.css에서 찾아보기 class="생소한것"부분에서 생소한것 복사해서 검색해보기
: template 구조 파악 제대로 하기


 
