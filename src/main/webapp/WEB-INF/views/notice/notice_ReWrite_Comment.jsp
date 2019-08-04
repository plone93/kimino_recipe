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
                    <div class="col-2"></div>
                    <div class="col-6">댁글내용</div>
                    <div class="col-2"></div>                    
                    <div class="col-2"></div>
                </div>
            </div>
                

            <form method="post" action="edited_Comment">
                <div class="row">
                    <div class="col-12 py-3">
                        <div class="input-group mb-3">
                            <input type="text" name="content" class="form-control" placeholder="코멘토" aria-label="Recipient's username" aria-describedby="button-addon2" value="${commentVO.content }">
                            <input type="hidden" name="board_num" value="${boardVO.board_num}">
							<input type="hidden" name="board_id" value="${board_id}">
							<input type="hidden" name="user_id" value="${loginUser.user_id }">
							<input type="hidden" name="user_name" value="${loginUser.user_name }">
							<input type="hidden" name="comment_num" value="${commentVO.comment_num }">
							<input type="hidden" name="page" value="${page }">
                            <div class="input-group-append">
                                <button class="btn btn-outline-success" type="submit" id="button-addon2">작성</button>
                            </div>
                        </div>
                    </div>
                </div> 
            </form>
            
                <div class="row justify-content-center">
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="edit_Board?board_id=${boardVO.board_id }&board_num=${boardVO.board_num}" role="button">수정</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="boardList?board_id=${board_id}" role="button">목록</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-danger" href="board_Report?board_id=${board_id }&board_num=${boardVO.board_num}" role="button">신고</a>                            
                </div>
            </div> 

		</div>
    
    </body> 
</html>

<%@ include file ="../footer.jsp" %>  