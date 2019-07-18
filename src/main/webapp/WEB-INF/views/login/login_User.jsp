<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file ="../header.jsp" %>    

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center">
                <div class="col-5 p-3 bg-success text-white rounded mt-5">
                
                    <h1 class="text-center mt-2">君のレシピ</h1>
                    
                    <form action="logined_User" method="POST">
                        <div class="form-group">
                            <label for="exampleInputEmail1">ID</label>
                            <input type="text" class="form-control" name="user_id" id="" placeholder="아뒤 입력 ">      
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" name="user_pass" id="" placeholder="비번 입ㅂ력">
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-4 text-center">
                                <button type="submit" class="btn btn-dark">ローグイン</button>
                            </div>
                            <div class="col-4 text-center">
                                <a href="insert_User" class="btn btn-dark">회원가입</a>
                            </div>
                        </div>    
                    </form>
                    
                    <div class="row my-2">
                        <div class="col">
                            <a href="#" class="text-decoration-none text-light">Forgot Password?</a>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col">
                            <a href="login_Admin" class="text-decoration-none text-light">管理者IDでログイン</a>
                        </div>
                    </div>      
                </div>
            </div>
        </div>
    </body> 
</html>