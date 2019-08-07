<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 



       <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">注文ページ</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>
            
            <c:if test="${boardCount == '0' }">
	            <div class="row justify-content-center mt-1 mb-5">
	                <div class="col-7">
	                    <h1 class="text-center">保存された商品はありません。</h1>
	                </div>
	            </div>      
            </c:if>
            <c:if test="${boardCount != '0'}">  
            <div class="row">
                <div class="col mt-5"> 
                    <h4>総${boardCount }件</h4>              
                    <table class="table table-striped">    
                    	<!-- 게시판 목록 -->                                                      
                        <thead>
                            <tr>                  
                                <th>#</th>
                                <th>商品イメージ</th>
                                <th>商品</th>
                                <th>価格</th>
                                <th>数</th>
                                <th>総計</th>
                                <th>削除</th>
                            </tr>
                        </thead>  
                                     
                             
                        <!-- 게시판 -->                           
                        <tbody>
                         <c:forEach var="boardList" items="${boardList}" varStatus="status" begin="0" end="9" step="1" >
                            <tr>
                            	<!-- {해당게시판 총게시글 수 - 0~9 - ((시작페이지-1) * 한페이지에 보여질 수)}-->
                                <td style="vertical-align: middle;"><input type="checkbox" class="checkBox" checked="checked" name="check" id="id" value="${boardList.price * boardList.amount}"></td>
                                <td scope="row"><img src="resources/images/${boardList.image }" class="img-thumbnail" style="width: 4rem; height:3.5rem;"></td>
                                <td style="vertical-align: middle;"><a style="color:#666;">${boardList.product_name }</a></td>
                                <td style="vertical-align: middle;">${boardList.price}</td>
                                <td style="vertical-align: middle;">${boardList.amount }
								<a class="glyphicon glyphicon-triangle-top" href="amount_Up?cart_num=${boardList.cart_num }&user_id=${loginUser.user_id}" aria-hidden="true">▲</a>
                                <a class="glyphicon glyphicon-triangle-bottom" href="amount_Down?cart_num=${boardList.cart_num }&user_id=${loginUser.user_id}&amount=${boardList.amount}" aria-hidden="true">▼</a></td>
                                <td style="vertical-align: middle;"><fmt:formatNumber pattern="###,###,###" value="${boardList.price * boardList.amount}"/></td>
                            	<td style="vertical-align: middle;"><span class="btn btn-outline-danger"><a href="cart_Delete?cart_num=${boardList.cart_num }&user_id=${loginUser.user_id}" style="color:#dc3545;">削除</a></span></td>
                            </tr>
                         </c:forEach>   
                        </tbody>                                  
                    </table>
                    
                     <div class="row justify-content-end">
                        <div class="col-2">合計　:　 </div>
                        <div class="col-1 total_Price" id="total_Price">   
                            <input class="total_Price"  style="border: 0 none;" readonly>
                            <span><strong class="total_Price"></strong></span>
                        </div>
                    </div> 
                    <div class="row justify-content-end mt-3">
                    	 <form action="order" method="post" style="text-align:center;">
	              			<input type="hidden" name="user_id" value="${loginUser.user_id }">
	              			<button type="submit" class="btn btn-success">購入</button>
              			</form>
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
                </div>
            </div>
           </c:if> 
            
        </div>     
    </body> 
</html>

<script>
	$('#amount_Up').click(function(){
		var user_id = "${loginUser.user_id}"
		var product_num = $(this).val();
		alert(product_num);
		
		var allData = { "user_id": user_id, 
						"product_num": product_num };//여러개의 변수를  배열에 저장
	 		$.ajax({
	 			url:"amount_Up",
	 			type:"post",
	 			data:allData,
	 			dataType:"json",
	 			success:function(data){
	 				if(data != 1){
	 					//alert("使用可能なニックネームです。");
	 				} else {
	 				//	alert("既に使用されているニックネームです。");
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