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
                </div>
            </div>
            <div class="row justify-content-start mb-3">
            <!-- 검색 -->
                <div class="col-8">
                    <form action="search_Board2?board_id=${board_id}" method="post">
                        <div class="row">
                            <div class="col-6">
                                <input name="keyword" class="form-control mr-sm-2" type="text" placeholder="検索" aria-label="Search">
                            </div>
                            <div class="col-3">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">検索</button>
                            </div>
                        </div>                        
                    </form>   
                </div>
                <div class="col-1"></div>
				<c:if test="${board_id eq 'お知らせ' }">
					<c:if test="${loginAdmin eq null }">
					</c:if>
					<c:if test="${loginAdmin ne null }">
						<div class="col-2 text-right">
		                	<a class="btn btn-success" href="insert_Notice?board_id=${board_id }" role="button">作成</a>
		                </div>
	               	</c:if>
	            </c:if>
				<div class="col-2"></div>
                <!-- 메뉴 -->
                <div class="col-1">
                    <div class="dropdown">
                        <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       		    分類
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="noticeList_Comment?board_id=${board_id }">コメント</a>
                            <a class="dropdown-item" href="noticeList_ReadCount?board_id=${board_id }">ビュー</a>
                            <a class="dropdown-item" href="noticeList_Up?board_id=${board_id }">共感順</a>
                            <a class="dropdown-item" href="noticeList_Down?board_id=${board_id }">非共感順</a>
                        </div>
                    </div>
                </div>
            </div> 
                    <table class="table" style="margin-bottom:50px;">    
                    	<!-- 게시판 목록 -->                                                      
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>題目</th>
                                <th>作成者</th>
                                <th>日付</th>
                                <th>ビュー</th>
                            </tr>
                        </thead>  
                        
                    <!-- 공지사항  -->   	                                      
                        <tbody>
                         <c:forEach var="noticeList" items="${noticeList}" varStatus="status" begin="0" end="2" step="1" >
                            <tr>
                                <td><span class="badge badge-danger" style="color:white;">お知らせ</span></td>
                                <td><a style="color:#666;" href="boardView2?board_num=${noticeList.board_num}&board_id=${board_id}&page=${pageVO.page}">${noticeList.title }</a>
                                &nbsp;&nbsp;<span class="btn btn-outline-success">${noticeList.commentcount}</span></td>
                                <td>${noticeList.user_name }</td>
                                <td><fmt:formatDate value="${noticeList.writedate }"/></td>
                                <td>${noticeList.readcount }</td>
                            </tr>
                         </c:forEach>   
                        </tbody>                                  
              
                             
                        <!-- 게시판 -->                           
                        <tbody>
                         <c:forEach var="boardList" items="${boardList}" varStatus="status" begin="0" end="9" step="1" >
                            <tr>
                            	<!-- {해당게시판 총게시글 수 - 0~9 - ((시작페이지-1) * 한페이지에 보여질 수)}-->
                                <td>${boardCount-status.index-((pageVO.page-1)*pageVO.displayRow)}</td>
                                <td><a style="color:#666;" href="boardView2?board_num=${boardList.board_num}&board_id=${board_id}&page=${pageVO.page}">${boardList.title }</a>
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
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   