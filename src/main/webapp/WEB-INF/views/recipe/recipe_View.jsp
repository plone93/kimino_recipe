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
 			  	${boardVO.content }
 			   </div>
            </div>  
            
            <div class="row justify-content-center my-2">
                <div class="col-2 py-3 text-center">
                    <a href="board_Up?board_id=${board_id }&board_num=${boardVO.board_num}" class="btn btn-outline-success">+${boardVO.up }</a>
                </div>
                
                <div class="col-2 py-3 text-center">
                	<a href="board_Down?board_id=${board_id }&board_num=${boardVO.board_num}" class="btn btn-outline-danger">-${boardVO.down }</a>
                </div>
            </div>  
            
            <div class="border-top border-dark">
                <div class="row my-2">
                    <div class="col-2">댓작성자</div>
                    <div class="col-6">댁글내용</div>
                    <div class="col-2">작성날짜</div>                    
                    <div class="col-2">
                        <div class="row">
                            <div class="col text-right">
                                <a href="#" class="badge badge-success">수정</a>                        
                            </div>
                            <div class="col text-left">
                                <a href="#" class="badge badge-danger">삭제</a>                                       
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
	                        <div class="row">
	                            <div class="col text-right">
	                                <a href="edit_Comment?comment_num=${commentList.comment_num }&board_num=${boardVO.board_num}&board_id=${board_id}" class="badge badge-success">수정</a>                        
	                            </div>
	                            <div class="col text-left">
	                                <a href="delete_Comment?comment_num=${commentList.comment_num }&board_num=${boardVO.board_num}&board_id=${board_id}" class="badge badge-danger" data-toggle="modal" data-target="#confirmDelete">삭제</a>
	                                
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
                                                <button type="button" class="btn btn-success" data-dismiss="modal">Yes</button>
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">No</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
	                            </div>
	                        </div>
                 	   </div>
	                </div>
                </c:forEach>
                
            </div>
            
            <c:if test="${loginUser eq null or Admin eq null}">
			</c:if>
			<c:if test="${loginUser ne null or Admin ne null}">  
            <form method="post" action="insert_Comment">
                <div class="row">
                    <div class="col-12 py-3">
                        <div class="input-group mb-3">
                            <input type="text" name="content" class="form-control" placeholder="코멘토" aria-label="Recipient's username" aria-describedby="button-addon2">
                            <input type="hidden" name="board_num" value="${boardVO.board_num}">
							<input type="hidden" name="board_id" value="${board_id}">
							<input type="hidden" name="user_id" value="${loginUser.user_id }">
							<input type="hidden" name="user_name" value="${loginUser.user_name }">
                            <div class="input-group-append">
                                <button class="btn btn-outline-success" type="submit" id="button-addon2">작성</button>
                            </div>
                        </div>
                    </div>
                </div> 
            </form>
            
            
            </c:if>
            
            
                <c:if test="${loginUser eq null or Admin eq null}">
				</c:if>
				<c:if test="${loginUser ne null or Admin ne null}">
                <div class="row justify-content-center">
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="edit_Board?board_id=${boardVO.board_id }&board_num=${boardVO.board_num}" role="button">수정</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="#" role="button" data-toggle="modal" data-target="#confirmDelete">삭제</a>       
                    <!-- Modal -->
                    <div class="modal fade" id="confirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">レシピを消し</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body text-left">
                                 	   정말로 삭제하시겠습니까?<br>
                                    (삭제 후 되돌릴 수 없습니다.)
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Yes</button>
                                    <button type="button" class="btn btn-outline-secondary">No</button>
                                </div>
                            </div>
                        </div>
                    </div>                     
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="boardList?board_id=${board_id}" role="button">목록</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-danger" href="board_Report?board_id=${board_id }&board_num=${boardVO.board_num}" role="button">신고</a>                            
                </div>
            </div> 
            
				</c:if>	
				

        </div>     
    </body> 
</html>

<%@ include file ="../footer.jsp" %>  