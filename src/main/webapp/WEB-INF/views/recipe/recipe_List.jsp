<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">${board_id} 게시판</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-start">
            
            <!-- 검색 -->
                <div class="col-4">
                    <form action="search_Board?board_id=${board_id}" method="post">
                        <div class="row">
                            <div class="col-9">
                                <input name="keyword" class="form-control mr-sm-2" type="text" placeholder="지금 게시판에서 検索" aria-label="Search">
                            </div>
                            <div class="col-3">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">検索</button>
                            </div>
                        </div>                        
                    </form>   
                </div>
                
                <div class="col-4"></div>
                
                <c:if test="${loginUser eq null or Admin eq null}">
				</c:if>
				<c:if test="${loginUser ne null or Admin ne null}">
					<div class="col-2 text-right">
	                    <a class="btn btn-success" href="insert_Board?board_id=${board_id }" role="button">글스기</a>
	                </div>
				</c:if>	

                
                <div class="col-1">
                    <div class="dropdown">
                        <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       		     분류
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">댓글순</a>
                            <a class="dropdown-item" href="#">조회순</a>
                            <a class="dropdown-item" href="#">최신순</a>
                            <a class="dropdown-item" href="#">추천순</a>
                            <a class="dropdown-item" href="#">비추천수</a>
                        </div>
                    </div>
                </div>
            </div>  
            
          		  <div class="row mt-5">
		            <c:forEach var="boardList" items="${boardList}" varStatus="status" begin="0" end="9" step="1" >
		            
		                <div class="col" style="flex-grow:0; margin-left:25px; margin-bottom:30px;" >
		                    <div class="card" style="width: 18rem;">
		                        <a href="boardView?board_num=${boardList.board_num}&board_id=${board_id}&page=${pageVO.page}">
			                        <c:if test="${boardList.image eq null}">
			                        	<img src="resources/images/food-1932466_640.jpg" class="card-img-top">
			                        </c:if>
			                        <c:if test="${boardList.image ne null}">
			                        	<img src="resources/images/${boardList.image }.jpg" class="card-img-top">
			                        </c:if>	
		                        </a>
		                        
		                        <div class="card-body">
		                            <h5 class="card-title">${fn:substring(boardList.title,0,10)}</h5>
		                            <p class="card-text"><a href="boardView?board_num=${boardList.board_num}&board_id=${board_id}" class="text-dark">${fn:substring(boardList.content,0,15)}</a></p>
		                            <p class="card-text"><fmt:formatDate value="${boardList.writedate }"/></p>	      
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
			    	  		 <a class="page-link" href="boardList?page=${i}&board_id=${board_id}">${i}</a>
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