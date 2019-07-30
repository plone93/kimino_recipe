<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">회원탈퇴</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-light">내정보</button>
                        <a href="edit_Profile?user_id=${loginUser.user_id }" class="list-group-item list-group-item-action list-group-item-light">개인정보수정</a>
                        <a href="my_WriteList?user_id=${loginUser.user_id }" class="list-group-item list-group-item-action list-group-item-light">내글목록</a>
                        <a href="cancel_User" class="list-group-item list-group-item-action list-group-item-success">회원탈퇴</a>                                    
                    </div>
                </div>
                <div class="col-9 mt-5">
                
                    <form method="post" action="canceled_User?user_num=${loginUser.user_num }&user_pass=${loginUser.user_pass}"> 
                        <div class="row justify-content-center">
                            <div class="col-3">
                                <input type="password" class="form-control" name="intput_pass" placeholder="비밀번호입력">                                
                            </div>
                            <div class="col-1">
                                <button type="submit" class="btn btn-success">확인</button>                            
                        </div>
                        </div>                 
                    </form>
                    
                </div>
            </div>
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>  