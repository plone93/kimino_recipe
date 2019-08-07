<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row  mt-1 mb-5">
                <div class="col-3"></div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row">
                <div class="col py-3">
                    <h3>${boardVO.title }</h3>
                </div>
            </div>  
            <div class="row">
                <div class="col-2 py-3">
                    <img src="resources/images/man-user.png" width="20" height="20" class="d-inline-block align-top">
                    ${boardVO.user_name }
                </div>
                <div class="col-2 py-3">
                    <img src="resources/images/calendar.png" width="20" height="20" class="d-inline-block align-top">
                    <fmt:formatDate value="${boardVO.writedate }"/>
                </div>
                <div class="col-2 py-3">
                    <img src="resources/images/view.png" width="20" height="20" class="d-inline-block align-top">
                    ${boardVO.readcount }
                </div>
            </div>   
            <div class="row">
                <div class="col py-3">
	                <c:if test="${boardVO.image ne null}">
				       <img src="resources/images/${boardVO.image}" class="card-img-top" style="width:30rem; height: 29rem">
				    </c:if>	
                <br>     
 			  	${boardVO.content }
 			   </div>
            </div>  
            
            <div class="row justify-content-center my-2">
                <div class="col-2 py-3 text-center">
                    <a href="board_Up?board_id=${board_id }&board_num=${boardVO.board_num}&page=${page}" class="btn btn-outline-success">+${boardVO.up }</a>
                </div>
                
                <div class="col-2 py-3 text-center">
                	<a href="board_Down?board_id=${board_id }&board_num=${boardVO.board_num}&page=${page}" class="btn btn-outline-danger">-${boardVO.down }</a>
                </div>
            </div>  
            
            <div class="border-top border-dark">
                <div class="row my-2">
                    <div class="col-2">コメント作成者</div>
                    <div class="col-6">コメント内容</div>
                    <div class="col-2">日付</div>                    
                    <div class="col-2">
                        <div class="row">
                            <div class="col text-right">
                                <a href="#" class="badge badge-success">修正</a>                        
                            </div>
                            <div class="col text-left">
                                <a href="#" class="badge badge-danger">削除</a>                                       
                            </div>
                        </div>
                    </div>
                </div>
                
                <c:forEach var="commentList" items="${commentList }">
	                <div class="row my-2">
	                    <div class="col-2">${commentList.user_name }</div>
	                    <div class="col-6">${commentList.content }</div>
	                    <div class="col-2"><fmt:formatDate value="${commentList.writedate }"></fmt:formatDate></div>
	                	<div class="col-2">
	                	
	                	<c:if test="${loginUser.user_id eq commentList.user_id or loginAdmin ne null}" >
	                        <div class="row">                 
	                            <div class="col text-right">
	                                <a href="edit_Comment?comment_num=${commentList.comment_num }&board_num=${boardVO.board_num}&board_id=${board_id}&page=${page}" class="badge badge-success">修正</a>                        
	                            </div>
	                            <div class="col text-left">
	                                <a href="delete_Comment?comment_num=${commentList.comment_num }&board_num=${boardVO.board_num}&board_id=${board_id}&page=${page}" class="badge badge-danger" data-toggle="modal" data-target="#confirmDelete">削除</a>
	                                
	                            <!-- Modal -->
                                <div class="modal fade" id="confirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">コメント消し</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body text-left">
                                        	        ㄹㅇ?<br>
                                            </div>
                                            <div class="modal-footer">
                                                 <a href="delete_Comment?board_id=${boardVO.board_id }&board_num=${boardVO.board_num}&comment_num=${commentList.comment_num }" class="btn btn-secondary">Yes</a>
                                                 <a class="btn btn-outline-secondary" data-dismiss="modal">No</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
	                            </div>
	                        </div>
	                   </c:if>
	                        
                 	   </div>  
	                </div>
                </c:forEach>
                
            </div>
            
            <c:if test="${loginUser eq null or loginAdmin eq null}">
			</c:if>
			<c:if test="${loginUser ne null or loginAdmin ne null}">  
            <form method="post" action="insert_Comment">
                <div class="row">
                    <div class="col-12 py-3">
                        <div class="input-group mb-3">
                            <input type="text" name="content" class="form-control" placeholder="" aria-label="Recipient's username" aria-describedby="button-addon2">

							<c:if test="${loginUser ne null and loginAdmin eq null}">
				            	<input type="hidden" name="board_num" value="${boardVO.board_num}">
								<input type="hidden" name="board_id" value="${board_id}">
								<input type="hidden" name="user_id" value="${loginUser.user_id }">
								<input type="hidden" name="user_name" value="${loginUser.user_name }">
								<input type="hidden" name="page" value="${page}">
				            </c:if>
				            <c:if test="${loginAdmin ne null and loginUser eq null}">
				            	<input type="hidden" name="board_num" value="${boardVO.board_num}">
								<input type="hidden" name="board_id" value="${board_id}">
								<input type="hidden" name="user_id" value="${loginAdmin.admin_id }">
								<input type="hidden" name="user_name" value="${loginAdmin.admin_name }">
								<input type="hidden" name="page" value="${page}">
				            </c:if>
							
                            <div class="input-group-append">
                                <button class="btn btn-outline-success" type="submit" id="button-addon2">作成</button>
                            </div>
                        </div>
                    </div>
                </div> 
            </form>        
            </c:if>
            
	            <c:if test="${loginUser.user_id ne writer}">
				</c:if>
				
                <div class="row justify-content-center">
                <!-- 댓글작성자를 리스트로 받아와서  댓글에 뿌려야함 -->
                <c:if test="${loginUser.user_id eq writer or loginAdmin ne null}">
                
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="edit_Board?board_id=${boardVO.board_id }&board_num=${boardVO.board_num}&page=${page}" role="button">修正</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="delete_Board?board_id=${boardVO.board_id }&board_num=${boardVO.board_num}&page=${page}" role="button">削除</a>                         
                </div>
                </c:if>
                
				<c:if test="${loginUser.user_id ne writer and loginAdmin eq null}" >
				</c:if>
				
                <div class="col-2 py-3">
                    <a class="btn btn-success" href="boardList?board_id=${board_id}&page=${page}" role="button">リスト</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-danger" href="board_Report?board_id=${board_id }&board_num=${boardVO.board_num}&page=${page}" role="button">申告</a>                            
                </div>
            </div> 
            
        </div>     
    </body> 
</html>

<%@ include file ="../footer.jsp" %>  