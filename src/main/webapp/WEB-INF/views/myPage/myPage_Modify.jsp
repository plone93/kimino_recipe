<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">개인정보수정</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-success">내정보</button>
                        <a href="myPage_Modify" class="list-group-item list-group-item-action list-group-item-light">개인정보수정</a>
                        <a href="myPage_List" class="list-group-item list-group-item-action list-group-item-light">내글목록</a>
                        <a href="cancel_User" class="list-group-item list-group-item-action list-group-item-light">회원탈퇴</a>                                    
                    </div>
                </div>
                <div class="col-9">
                
                    <form method="POST" action="#">
                    
                    <div class="form-group">
						<input type="hidden" name="user_num" value="${loginUser.user_num }">
					</div>	
					
                        <div class="row justify-content-center mt-5 py-2">
                            <div class="col-2">
                                <label for="Email">Email</label>
                            </div>
                            <div class="col-3">
                                <input type="email" class="form-control"  value="${userVO.user_email }" id="email">
                            </div>
                            <div class="col-1"></div>
                        </div>
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">ニックネーム</label>
                            </div>
                            <div class="col-3">
                                <input type="text" class="form-control"  value="${userVO.user_name }" id="name">
                            </div>
                            <div class="col-1">
                                <div class="btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-secondary">
                                        <input type="checkbox" checked autocomplete="off"> Check
                                    </label>
                                </div>                            
                            </div>
                            
  
                        </div>
                        
                        
                        <div class="row justify-content-center py-2">
                            
                            <div class="col-2">
                                <label for="password">비밀번호</label>
                            </div>
                            <div class="col-3">
                                <input type="password" class="form-control" id="password" placeholder="문자, 숫자, 특수문자 잘 스까서">
                            </div>
                            <div class="col-1"></div>
                        </div>
                        <div class="row justify-content-center py-2">
                            <div class="col-2">
                                <label for="passwordCheck">비밀번호 재확인</label>
                            </div>
                            <div class="col-3">
                                <input type="password" class="form-control" id="passwordCheck">
                            </div>
                            <div class="col-1"></div>                
                        </div>                                  
                        <div class="row justify-content-center mt-5">
                            <div class="col text-center">
                                <button type="submit" class="btn btn-secondary">保存する</button>
                            </div>
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   