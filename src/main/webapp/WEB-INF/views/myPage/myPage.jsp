<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

        <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">登録情報</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-success">내정보</button>
                        <a href="myPage_modify.html" class="list-group-item list-group-item-action list-group-item-light">개인정보수정</a>
                        <a href="myPage_list.html" class="list-group-item list-group-item-action list-group-item-light">내글목록</a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light">회원탈퇴</a>                                    
                    </div>
                </div>
                <div class="col-9">
                    <div class="row justify-content-center mt-5 py-2">
                        <div class="col-2">
                            <label for="Email">Email</label>
                        </div>
                        <div class="col-4">
                            <h4>email</h4>
                        </div>
                        <div class="col-1"></div>
                    </div>
                    <div class="row justify-content-center py-3">
                        <div class="col-2">
                            <label for="name">Name</label>
                        </div>
                        <div class="col-4">
                            <h4>ニックネーム</h4>
                        </div>
                        <div class="col-1"></div>
                    </div>
                    <div class="row justify-content-center py-3">
                        <div class="col-2">
                            <label for="password">加入日</label>
                        </div>
                        <div class="col-4">
                            <h4>1993-08-27</h4>
                        </div>
                        <div class="col-1">
                        </div>
                    </div>
                    <div class="row justify-content-center py-3">
                        <div class="col-2">
                            <label for="passwordCheck">気に入った料理</label>
                        </div>
                        <div class="col-4">
                            <h4>韓国料理、家庭料理</h4>
                        </div>
                        <div class="col-1">
                        </div>
                    </div>                            
                </div>
            </div>
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   