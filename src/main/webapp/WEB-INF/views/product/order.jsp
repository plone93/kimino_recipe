<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 



       <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">${board_id }</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row">
                <div class="col mt-5"> 
                    <h4>総${boardCount }件</h4>              
                    <table class="table table-striped">    
                    	<!-- 게시판 목록 -->                                                      
                        <thead>
                            <tr>                  
                                <th>商品イメージ</th>
                                <th>商品</th>
                                <th>価格</th>
                                <th>数</th>
                                <th>総計</th>
                            </tr>
                        </thead>  
                                     
                             
                        <!-- 주문리스트 -->                           
                        <tbody>
                         <c:forEach var="boardList" items="${boardList}" varStatus="status" begin="0" end="9" step="1" >
                            <tr>
                            	<!-- {해당게시판 총게시글 수 - 0~9 - ((시작페이지-1) * 한페이지에 보여질 수)}-->
                                <td scope="row"><img src="resources/images/${boardList.image }" class="img-thumbnail" style="width: 4rem; height:3.5rem;"></td>
                                <td style="vertical-align: middle;"><a style="color:#666;">${boardList.product_name }</a></td>
                                <td style="vertical-align: middle;">${boardList.price}</td>
                                <td style="vertical-align: middle;">${boardList.amount }</td>
                                <td style="vertical-align: middle;"><fmt:formatNumber pattern="###,###,###" value="${boardList.price * boardList.amount}"/></td>
                            </tr>
                         </c:forEach>   
                        </tbody>                                  
                    </table>
                    
                     <div class="row justify-content-end">
                        <div class="col-1">合計　:　 </div>
                        <div class="col-1 total_Price" id="total_Price">   
                            <input class="total_Price"  style="border: 0 none;" readonly>
                            <span><strong class="total_Price"></strong></span>
                        </div>
                    </div> 
                    
			 <!-- 페이지 -->
			  <ul class="pagination justify-content-center" style="margin-top:50px;">
			  
				  <c:if test="${pageVO.prev}">
				    <li class="page-item">
				      <a class="page-link" href="Page?page=${pageVO.beginPage-1}&board_id=${board_id}" aria-label="Previous">
				            <span aria-hidden="true">&laquo;</span>
				            <span class="sr-only">Previous</span>
				          </a>     
				    </li>
				  </c:if>
			
			 <c:forEach var="i" begin="${pageVO.beginPage}" end="${pageVO.endPage}" step="1">
				<c:choose>    
				     <c:when test="${pageVO.page eq i}">
				     	<li class="page-item">
				     		 <a class="page-link">${i}</a> 
				      	</li>  
				     </c:when>
			    	 <c:otherwise>
			    		 <li class="page-item">
			    	  		 <a class="page-link" href="boardList2?page=${i}&board_id=${board_id}">${i}</a>
			    	  	 </li>  
			         </c:otherwise>
				</c:choose>
			 </c:forEach>
			    
			  <c:if test="${pageVO.next}">
			    <li class="page-item">
			      <a class="page-link" href="Page?page=${pageVO.beginPage+1}&board_id=${board_id}" aria-label="Next">
			            <span aria-hidden="true">&raquo;</span>
			            <span class="sr-only">Next</span>
			          </a>
			    </li>
			  </c:if> 	  
			  </ul> 
			 <!-- 페이지 끝 --> 
			 
			 <!-- 주소 -->
				<form method="POST" action="ordered" name="form" onsubmit="return userUpdate()">

					<c:forEach var="boardList" items="${boardList}" varStatus="status">
						<input type="hidden" name="product_id" value="${boardList.product_id}">
						<input type="hidden" name="product_name" value="${boardList.product_name}">
						<input type="hidden" name="price" value="${boardList.price}">
						<input type="hidden" name="amount" value="${boardList.amount}">
						<input type="hidden" name="cart_num" value="${boardList.cart_num }">
						<input type="hidden" name="image" value="${boardList.image}">
					</c:forEach>
					<input type="hidden" name="user_id" value="${loginUser.user_id }">	 					 		 	  	                 
					
                        <div class="row justify-content-center mt-5 py-2">
                            <div class="col-2">
                                <label for="Email">お名前</label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control"  value="${userVO.name }" name="name" id="name">
                            </div>
                            <div class="col-1">
                            	<button type="button" class="btn btn-dark" id="nameUpdate">更新</button>  
                            </div>
                        </div>
                        
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">アドレス1</label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control"  value="${userVO.address1 }" name="address1" id="address1">
                            </div>
                            <div class="col-1">                         
                            </div>
                        </div>
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">アドレス2</label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control"  value="${userVO.address2 }" name="address2" id="address2">
                            </div>
                            <div class="col-1">
                                <button type="button" class="btn btn-dark" id="addressUpdate">更新</button>                            
                            </div>
                        </div>
                                         
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">連絡先</label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control"  value="${userVO.phone_num }" name="phone_num" id="phone_num">
                            </div>
                            <div class="col-1">
                                <button type="button" class="btn btn-dark" id="phoneUpdate">更新</button>                            
                            </div>
                        </div>
                        
                         <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">発送メッセージ</label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control"  value="" name="message" id="message">
                            </div>
                            <div class="col-1">                           
                            </div>
                        </div>
                        <!-- 계좌선택 -->	
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">口座</label>
                            </div>
                            <div class="col-8">
                               <select class="form-control" name="bank_account" id="bank_account">
                                  <option value="UJF 0000-11111-22222">UJF 0000-11111-22222</option>
                                  <option value="みずほ 0000-11111-22222">みずほ 0000-11111-22222</option>
                                  <option value="三菱 0000-11111-22222">三菱 0000-11111-22222</option>
                          	　  </select>
                            </div>
                            <div class="col-1">                    
                            </div>
                        </div>
                        
                        <div class="row justify-content-center py-3" style="text-align:center;">
                            <div class="col-2">
                                <label for=""></label>
                            </div>
                            <div class="col-8">
                            	<button type="submit" class="btn btn-success">注文完了</button>
                            </div>
                            <div class="col-1">                    
                            </div>
                        </div>  
                                                               	
                    </form>
						                
                </div>
            </div>
        </div>     
    </body> 
</html>

<!-- 이름 갱신 -->
<script>
	$('#nameUpdate').click(function(){
		var name = $('#name').val();
		var user_num = "${loginUser.user_num}"
		
		var allData = { "name": name, 
						"user_num": user_num };//여러개의 변수를  배열에 저장
	 		$.ajax({
	 			url:"update_Name",
	 			type:"post",
	 			data:allData,
	 			dataType:"json",
	 			success:function(data){
	 				if(data == 1){
	 					alert("更新しました。");
	 				} else {
	 					alert("更新に失敗しました。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		}); 	
	});
</script>

<!-- 주소 갱신 -->
<script>
	$('#addressUpdate').click(function(){
		var address1 = $('#address1').val();
		var address2 = $('#address2').val();
		var user_num = "${loginUser.user_num}"
		
		var allData = { "address1": address1, 
						"address2": address2,
						"user_num": user_num };//여러개의 변수를  배열에 저장
	 		$.ajax({
	 			url:"update_Address",
	 			type:"post",
	 			data:allData,
	 			dataType:"json",
	 			success:function(data){
	 				if(data == 1){
	 					alert("更新しました。");
	 				} else {
	 					alert("更新に失敗しました。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		}); 	
	});
</script>

<!-- 연락처 갱신 -->
<script>
	$('#phoneUpdate').click(function(){
		var phone_num = $('#phone_num').val();
		var user_num = "${loginUser.user_num}"
		
		var allData = { "phone_num": phone_num, 
						"user_num": user_num };//여러개의 변수를  배열에 저장
	 		$.ajax({
	 			url:"update_Phone_num",
	 			type:"post",
	 			data:allData,
	 			dataType:"json",
	 			success:function(data){
	 				if(data == 1){
	 					alert("更新しました。");
	 				} else {
	 					alert("更新に失敗しました。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		}); 	
	});
</script>


<script>
	/*페이지가 전부 로드되면  해당 함수를 자동으로 실행*/
	 window.onload = function total(){
		
/* 		//해당 id에 해당하는 이름 가져오기
		var size = document.getElementsByName("c").length;
		for(var i = 0; i<size; i++){
			console.log(document.getElementsByName("c")[i].value);
		} */
		var total = 0;
		
		//체크된 값만 가져오기
		var size = document.getElementsByName("check").length;
		for(var i =0; i<size; i++){
			if(document.getElementsByName("check")[i].checked == true){
				total += Number(document.getElementsByName("check")[i].value); // Number()  int로 형변환 대소문자 구분 중요
				
			}
		}
		/*total_Price라는 클래스이름을 가진 곳에 속성(value에, total을 집어넣음) */
		$('.total_Price').attr('value', total);
		
	}
</script>



<%@ include file ="../footer.jsp" %>   