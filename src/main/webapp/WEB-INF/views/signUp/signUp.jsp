<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file ="../header.jsp" %> 

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center">
                <div class="col-7 pt-4 bg-success text-white rounded mt-5">
                    <h1 class="text-center mb-4">ID新規取得</h1>
                    <form action="inserted_User" method="post">
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="ID">ID</label>
                            </div>
                            <div class="col-6">
                                <input type="text" class="form-control" name="user_id" id="ID">
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-dark">Check</button>
                            </div>
                        </div>
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="name">ニックネーム</label>
                            </div>
                            <div class="col-6">
                                <input type="text" class="form-control" name="user_name" id="name">
                            </div>
                            <div class="col-2"></div>
                        </div>
                        
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="password">パスワード</label>
                            </div>
                            <div class="col-6">
                                <input type="password" class="form-control" id="password" name="user_pass" placeholder="10자이상">
                            </div>
                            <div class="col-2"></div>
                        </div>
                        
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="passwordCheck">パスワード確認</label>
                            </div>
                            <div class="col-6">
                                <input type="password" class="form-control" id="passwordCheck" name="user_pass1" placeholder="">
                            </div>
                            <div class="col-2"></div>
                        </div>
                        
                         <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="password">E-Mail</label>
                            </div>
                            <div class="col-6">
                                <input type="email" class="form-control" id="email" name="user_email" placeholder="">
                            </div>
                            <div class="col-2"></div>
                        </div>
                        
                        <div class="row my-3 justify-content-center">
                            <div class="col-3 text-center">
                                <button type="submit" class="btn btn-dark">ID登録</button>
                            </div>
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </body> 
</html>       