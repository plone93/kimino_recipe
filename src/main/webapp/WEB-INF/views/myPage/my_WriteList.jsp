<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">내글목록</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-light">내정보</button>
                        <a href="edit_Profile?user_id=${loginUser.user_id }" class="list-group-item list-group-item-action list-group-item-light">개인정보수정</a>
                        <a href="my_WriteList?user_id=${loginUser.user_id }" class="list-group-item list-group-item-action list-group-item-success">내글목록</a>
                        <a href="cancel_User" class="list-group-item list-group-item-action list-group-item-light">회원탈퇴</a>                                    
                    </div>
                </div>
                
                <div class="col-9 mt-5">                        
                    <table class="table table-striped">                                                          
                    	<!-- 게시판 목록 -->                                                      
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>  
                             
                        <!-- 게시판 -->                           
                        <tbody>
                         <c:forEach var="boardList" items="${boardList}" varStatus="status" begin="0" end="9" step="1" >
                            <tr>
                            	<!-- {해당게시판 총게시글 수 - 0~9 - ((시작페이지-1) * 한페이지에 보여질 수)}-->
                                <th>${boardCount-status.index-((pageVO.page-1)*pageVO.displayRow)}</th>
                                <td><a style="color:#666;" href="boardView?board_num=${boardList.board_num}&board_id=${board_id}&page=${pageVO.page}">${boardList.title }</a>
                                &nbsp;&nbsp;<span class="btn btn-outline-success">${boardList.commentcount}</span></td>
                                <td>${boardList.user_name }</td>
                                <td><fmt:formatDate value="${boardList.writedate }"/></td>
                                <td>${boardList.readcount }</td>
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


<%@ include file ="../footer.jsp" %>   