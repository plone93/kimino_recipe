<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  


       <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center">
                <div class="col-5 p-3 bg-success text-white rounded mt-5">
                    <h1 class="text-center mt-2">管理者ログイン</h1>
                    
                    <form action="Logined_Admin" method="POST">
                        <div class="form-group">
                            <label for="exampleInputEmail1">ID</label>
                            <input type="text" name="admin_id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="ID入力">      
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">パスワード</label>
                            <input type="password" name="admin_pass" class="form-control" id="exampleInputPassword1" placeholder="パスワード入力">
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-4 text-center">
                                <button type="submit" class="btn btn-dark">ローグイン</button>
                            </div>                        
                        </div>    
                    </form>         
                                                   
                </div>
            </div>
        </div>
    </body> 
</html>

<%@ include file ="../footer.jsp" %>   