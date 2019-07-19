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
                    <table class="table">                                                          
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>                                  
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>${boardList.title }</td>
                                <td>${boardList.user_name }</td>
                                <td><fmt:formatDate value="${boardList.writedate }"/></td>
                                <td>${boardList.readcount }</td>
                            </tr>
                        </tbody>                                  
                    </table>  
                          
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
            </div>
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   