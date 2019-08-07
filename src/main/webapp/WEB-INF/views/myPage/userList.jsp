<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">ユーザ管理</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-success">アカウント情報</button>
                        <a href="userList" class="list-group-item list-group-item-action list-group-item-success">ユーザー管理</a>
                        <a href="reportList" class="list-group-item list-group-item-action list-group-item-light">申告管理</a>
                        <a href="orderList" class="list-group-item list-group-item-action list-group-item-light">注文管理</a>                                    
                    </div>
                </div>
                
                <div class="col-9 mt-5">                        
                    <table class="table table-striped">                                                          
                    	<!-- 게시판 목록 -->                                                      
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>ユーザーID</th>
                                <th>ニックネーム</th>
                                <th>ユーザーEmail</th>
                                <th>登録日</th>
                                <th>削除</th>
                            </tr>
                        </thead>  
                             
                        <!-- 게시판 -->                           
                        <tbody>
                         <c:forEach var="userList" items="${userList}" varStatus="status" begin="0" end="9" step="1" >
                            <tr>
                            	<!-- {해당게시판 총게시글 수 - 0~9 - ((시작페이지-1) * 한페이지에 보여질 수)}-->
                                <th>${boardCount-status.index-((pageVO.page-1)*pageVO.displayRow)}</th>
                                <td><a style="color:#666;">${userList.user_id }</a>
                                <td>${userList.user_name}</td>
                                <td>${userList.user_email }</td>
                                <td><fmt:formatDate value="${userList.signdate }"/></td>
                                <td><span class="btn btn-outline-danger"><a href="user_Delete" style="color:#dc3545;" data-toggle="modal" data-target="#user_Delete">削除</a></span>
                                
                                	<!-- Modal -->
                                    <div class="modal fade" id="user_Delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">レシピを削除</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body text-left">
                                                 	   削除しますか?<br>
                                                    (消し後、戻れません。)
                                                </div>
                                                <div class="modal-footer">
                                             	    <a href="delete_User?user_num=${userList.user_num }&page=${pageVO.page } " class="btn btn-secondary">Yes</a>
                                               	    <a class="btn btn-outline-secondary" data-dismiss="modal">No</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>  
                                
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
			 
                <!-- 검색 -->
                <div class="col-4">
                    <form action="search_Board_User" method="post">
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
                                  
                </div>
            </div>
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   