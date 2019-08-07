<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  


        <div class="container">
            <div class="row my-5"><div class="col"></div></div>
            <div class="row">
                <div class="col-6">
               		<c:if test="${productVO.image eq null}">
				       	<img src="resources/images/food-1932466_640.jpg" class="card-img-top" style="width: 30rem; height: 29rem;">
				    </c:if>
				    <c:if test="${productVO.image ne null}">
				        <img src="resources/images/${productVO.image }" class="img-fluid" style="width: 30rem; height: 29rem;">
				    </c:if>	

                </div>
                <div class="col-6">
                    <div class="row mb-5">
                        <div class="col border border-secondary border-top-0 border-right-0 border-left-0">
                            <h3 class="product_name">${productVO.product_name }</h3>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                          <h5>${productVO.price }</h5>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                          <p>${productVO.content }</p>
                        </div>
                    </div>                    
                    <div class="row mb-3">
                        <div class="col">
                       	   商品の種類
                        </div>
                    </div>
                    
                    <form action="" method="POST" name="form">

                    	
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">数</label>
                                    <select class="form-control" id="amount" name="amount">
                                        <c:forEach var="number" begin="1" end="10" step="1" >
                                        	<option value="${number }">${number }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>                         
                            <div class="col pt-4">
                                <a class="btn btn-success btn-lg" style="color:white;" role="button" data-toggle="modal" data-target="#addCart_Modal">カートに入れる</a>                                     
                                <!-- Modal -->
                                <div class="modal fade" id="addCart_Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">カートに入れる</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                 	   カートページに移動いますか。
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-outline-success" data-dismiss="modal" id="addCart">はい</button>
                                    				<button type="button" class="btn btn-outline-danger" data-dismiss="modal">いいえ</button>                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                  
                                </div>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>        
    </body> 
</html>

<script>
	$('#addCart').click(function(){
		/*자바스크립트에서 변수에  표현식을 표현할때 앞뒤에 ""를  붙여야함*/
		var user_id = "${loginUser.user_id}"
		var product_id = "${productVO.product_id}"
		var product_name = "${productVO.product_name}"
		var price = "${productVO.price}"
		var content = "${productVO.content}"
		var image = "${productVO.image}"
		var amount = $('#amount').val();
		
	    var allData = { "user_id": user_id,
	    				"product_id": product_id,
	    				"product_name": product_name,
	    				"price": price,
	    				"content": content,
	    				"image": image,
	    				"amount": amount};//여러개의 변수를  배열에 저장
	    
	 		$.ajax({
	 			url:"addCart",
	 			type:"post",
	 			data:allData, //변수들이 저장된 배열을 넘김, 배열의 경우 변수 지정없이 배열에서 지정한 변수이름을 그대로 사용
	 			dataType:"json",
	 			success:function(data){
	 				if(data == 1){
	 					alert("カートに入れました。");
	 				} else {
	 					alert("エラーが発生しました。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("에러러");
	 			}
	 		});
	});
</script>

<%@ include file ="../footer.jsp" %>  
