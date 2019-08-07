<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">${board_id}</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            
            <div class="row justify-content-start">
            <!-- 검색 -->
                <div class="col-4">
                    <form action="search_Product?board_id=${board_id}" method="post">
                        <div class="row">
                            <div class="col-9">
                                <input name="keyword" class="form-control mr-sm-2" type="text" placeholder="検索" aria-label="Search">
                            </div>
                            <div class="col-3">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">検索</button>
                            </div>
                        </div>                        
                    </form>   
                </div>
                
                <div class="col-5"></div>
                
                <c:if test="${loginAdmin eq null}">
				</c:if>
				<c:if test="${loginAdmin ne null}">
					<div class="col-2 text-right">
	                    <a class="btn btn-success" href="insert_Product_Board?board_id=${board_id }" role="button">作成</a>
	                </div>
				</c:if>	
            </div>  
            	  <!-- 게시판 리스트ㅡ -->	
          		  <div class="row mt-5">
		            <c:forEach var="boardList" items="${boardList}" varStatus="status" begin="0" end="9" step="1" >
		            
		                <div class="col" style="flex-grow:0; margin-left:25px; margin-bottom:30px;" >
		                    <div class="card" style="width: 18rem;">
		                        <a href="product_View?product_num=${boardList.product_num}&board_id=${board_id}&page=${pageVO.page}">
			                        <c:if test="${boardList.image eq null}">
			                        	<img src="resources/images/food-1932466_640.jpg" class="card-img-top" style="height: 12rem;">
			                        </c:if>
			                        <c:if test="${boardList.image ne null}">
			                        	<img src="resources/images/${boardList.image}" class="card-img-top" style="height: 12rem;">
			                        </c:if>	
		                        </a>
		                        
		                        <div class="card-body">
		                            <h5 class="card-title">${fn:substring(boardList.product_name,0,9)}</h5>
		                            <p class="card-text"><a href="product_View?product_num=${boardList.product_num}&board_id=${board_id}&page=${pageVO.page}" class="text-dark">${fn:substring(boardList.content,0,15)}</a></p>	                            	      
		                        </div>
		                        
		                    </div>
		                </div>
		                
		           	</c:forEach>    
                </div>
                       
			 <!-- 페이지 -->
			  <ul class="pagination justify-content-center">
			  
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
			    	  		 <a class="page-link" href="productList?page=${i}&board_id=${board_id}">${i}</a>
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
    </body> 
</html>


<%@ include file ="../footer.jsp" %>  