<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">注文履歴</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-success">アカウント情報</button>
                        <a href="userList" class="list-group-item list-group-item-action list-group-item-light">ユーザー管理</a>
                        <a href="reportList" class="list-group-item list-group-item-action list-group-item-light">申告管理</a>
                        <a href="orderList" class="list-group-item list-group-item-action list-group-item-success">注文管理</a>                                 
                    </div>
                </div>
                
                <div class="col-9 mt-5">                        
                    <table class="table table-striped">                                                          
                    	<!-- 게시판 목록 -->                                                      
                        <thead>
                            <tr>
                                <th>日付</th>
                                <th>注文番号</th>
                                <th>注文者</th>
                                <th>商品名</th>
                                <th>金額</th>
                                <th>状況</th>
                                <th></th>   
                            </tr>
                        </thead>  
                             
                        <!-- 게시판 -->                           
                        <tbody>
                         <c:forEach var="orderList" items="${orderList}" varStatus="status" begin="0" end="9" step="1" >
                            <tr>
                            	<!-- {해당게시판 총게시글 수 - 0~9 - ((시작페이지-1) * 한페이지에 보여질 수)}-->
                            	<td><fmt:formatDate value="${orderList.orderdate }"/></td>
                                <td><a style="color:#666;" href="orderView_Admin?order_id=${orderList.order_id}&page=${pageVO.page}">${orderList.order_id}</a></td>
                                <td>${orderList.user_id }</td>
                                <td><a style="color:#666;" href="productView?product_id=${orderList.product_id}&page=${pageVO.page}">${orderList.product_name }</a></td>
                                <td>${orderList.price }</td>
                                <td>
                                	<c:if test="${orderList.delivery eq '0'}"><span class="badge btn-warning" style="color:white;">未入金</span></c:if>
	                                <c:if test="${orderList.delivery eq '1'}"><span class="badge btn-primary" style="color:white;">入金済</span></c:if>
	                                <c:if test="${orderList.delivery eq '2'}"><span class="badge btn-info" style="color:white;">発送準備中</span></c:if>
	                                <c:if test="${orderList.delivery eq '3'}"><span class="badge btn-success" style="color:white;">発送済</span></c:if>
	                          	</td>
	                          	<td>
		                          	<form action="deliveryUpdate" method="post">
	                                	<input type="hidden" name="order_id" value="${orderList.order_id}">
	                                	<input type="hidden" name="page" value="${pageVO.page }">
										<select class="form-control" name="deliveryValue" style="display:table-cell;  width:40%;">
										　<option value="1">入金済</option>
		                                  <option value="2">発送準備中</option>
		                                  <option value="3">発送済</option>
		                          	 　  </select>
		                          	 	<input type="submit" class="btn btn-dark" value="更新"> 
		                          	</form>	
	                          	</td>
                            </tr>           
                         </c:forEach>   
                        </tbody>                                  
                    </table>  
                         
			 <!-- 페이지 -->
			  <ul class="pagination justify-content-center" style="margin-top:50px;">
			  
				  <c:if test="${pageVO.prev}">
				    <li class="page-item">
				      <a class="page-link" href="Page?page=${pageVO.beginPage-1}&user_id=${loginUser.user_id }" aria-label="Previous">
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
			    	  		 <a class="page-link" href="my_WriteList?page=${i}&user_id=${loginUser.user_id }">${i}</a>
			    	  	 </li>  
			         </c:otherwise>
				</c:choose>
			 </c:forEach>
			    
			  <c:if test="${pageVO.next}">
			    <li class="page-item">
			      <a class="page-link" href="Page?page=${pageVO.beginPage+1}&user_id=${loginUser.user_id }" aria-label="Next">
			            <span aria-hidden="true">&raquo;</span>
			            <span class="sr-only">Next</span>
			          </a>
			    </li>
			  </c:if> 	  
			  </ul> 
			 <!-- 페이지 끝 --> 
                    
                                  
                </div>
            </div>
        </div>     
    </body> 
</html>

<!-- 연락처 갱신 -->
<script>
	$('#deliveryUpdate').click(function(){
		var phone_num = $('#phone_num').val();
		var user_num = "${loginUser.user_num}"
		
		var count = 0;
		
		var size = "${fn:length(orderList)}"
		for(var i =0; i<size; i++){
				count = document.getElementsByName("price")[i].value; 
		}
		
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

<%@ include file ="../footer.jsp" %>   