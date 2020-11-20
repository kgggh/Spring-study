# 배달서비스



<h2>언택트(Untact): 접촉하지 않고 연결하는 디지털 기술 – 언택트 소비</h2>
<br><br><br><br><br>


집에서 지내는 시간이 늘면서 눈에 띄게 증가한 것은 바로 스마트폰 사용 시간입니다.
  
특히, 모바일 TV나 동영상 스트리밍 시청 등 미디어 접속 시간이 확연하게 늘어났습니다.

그 중에서도 배달 음식이나 신선 식품 등의 판매량이 증가 하는 모습을 보며,

배달 웹서비스를 주제로 삼아보는게 어떨까란 생각으로 프로젝트를 진행했습니다.

도중에 인원이 두명 빠져 결제기능까지는 구현 하지 못하였습니다.

맡은 역할은 관리자로선 이벤트 및 쿠폰 CRUD 기능을 구현하였고,

사용자로선 이벤트를 참여하여 쿠폰 발급 및 발급받은 쿠폰 조회(사용 유무,기한,적용구분(금액))기능을 구현했습니다.

java,Spring,javaScript,mybatis,tomcat,jquery,ajax 를 사용해 프로젝트를 진행하였고, slack,aquerytool,googlemeet,zum-us등 각종 툴을 사용하며 프로젝트를 진행했습니다.

<br><br><br><br><br>

Home 화면
-----------------------------

<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757710-4a037880-2b33-11eb-89b2-6a89d7db4700.jpg">

Home화면에서 접근하려는 유저의 편의를 위해 구분을 고객,점주로 나눴습니다.
<br><br><br><br><br>






Main 
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757610-1d4f6100-2b33-11eb-9601-d9efcd939506.png">

배달 지역을 설정해 배달 가능 한 점포를 표현했습니다.

<br><br><br><br><br>









Event List(이벤트 목록)
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99759142-d020be80-2b35-11eb-80a3-4a770af92340.jpg">


등록된 이벤트 목록을 표현했습니다. 유저일땐 이벤트 조회만 가능 하고 등록 버튼이 표시 되지 않고, 관리자로 접속시에만 접근 해두게 했습니다.  
 


<br><br><br><br><br>






Event View(이벤트 상세페이지, 발급)
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99762078-fd23a000-2b3a-11eb-9da6-b38eb8d396b1.jpg">

<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757651-335d2180-2b33-11eb-83c2-b7642650ffbb.jpg">

진행 중인 이벤트의 상세 내용을 담고 있으며, 하단부분에 유저가 쿠폰 발급을 받을 수 있도록 발급 버튼이 존재하며 수정 삭제 버튼은 접근 제한을 두어,

관리자일때만 수정,삭제 할 수 있도록 하였습니다.




<br><br><br><br><br>







Event Write(이벤트 등록) 
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757637-2c361380-2b33-11eb-86fd-16752593d8ba.jpg">

하단부에 관리자가 등록해둔 쿠폰리스트를 표현 해두어, 이베트 등록시 선택해 적용 할수 있도록 했습니다. 


<br><br><br><br><br>








Coupon List(쿠폰함)
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99761080-8eddde00-2b38-11eb-98d5-a69afc1df596.jpg">

<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757677-4112a700-2b33-11eb-8711-d89f8dd376c2.jpg">

유저로 접근시엔 이벤트 참여시 발급 받은 쿠폰을 조회만 가능 하도록, 관리자로선 전체 쿠폰에 대해 등록,수정,삭제,조회 할 수있는 

쿠폰함 입니다.

<br><br><br><br><br>










Coupon View(쿠폰 상세)
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757658-39530280-2b33-11eb-94ff-8a34eeae3691.jpg">

등록 및 발급받은 쿠폰의 상세페이지입니다. 쿠폰번호, 적용금액,기한,업종 구분을 화면에 데이터로 나타냈습니다. 


<br><br><br><br><br>









Coupon Write(쿠폰 등록)
---------------------------------
<img width ="100%" src="https://user-images.githubusercontent.com/68227318/99757648-31935e00-2b33-11eb-8d0d-2c3274caf411.jpg">

등록 및 발급받은 쿠폰의 상세페이지입니다. 쿠폰번호, 적용금액,기한,업종 구분을 화면에 데이터로 나타냈습니다. 
<br><br><br><br><br>
