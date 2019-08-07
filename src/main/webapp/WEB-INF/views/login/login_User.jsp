<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file ="../header.jsp" %>    

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center">
                <div class="col-5 p-3 bg-success text-white rounded mt-5">
                
                    <h1 class="text-center mt-2">君のレシピ</h1>
                    
                    <form action="logined_User" method="POST" name="form" onsubmit="return login()">
                        <div class="form-group">
                            <label for="exampleInputEmail1">ID</label>
                            <input type="text" class="form-control" name="user_id" id="user_id" placeholder="ID入力">      
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" name="user_pass" id="user_pass" placeholder="パスワード入力">
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-4 text-center">
                                <button type="submit" class="btn btn-dark">ローグイン</button>
                            </div>
                            <div class="col-5 text-center">
                                <a href="insert_User" class="btn btn-dark">アカウント登録</a>
                            </div>
                        </div>    
                    </form>
                    
                    <div class="row my-2">
                        <div class="col">
                            <a href="#" class="text-decoration-none text-light">お忘れですか？</a>
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

	<!-- 회원가입 체크 -->
	<script>
		function login() {
			if(document.form.user_id.value=="") {
				alert("IDを入力してください。");
				form.user_id.focus();
				return false;
			}
			if(document.form.user_id.value.length<6) {
				alert("IDは6字以上入力してください。");
				form.user_id.focus();
				return false;
			}
			if(document.form.user_pass.value.length==0) {
				alert("パスワードを入力してください。");
				form.user_pass.focus();
				return false;
			}
			if(document.form.user_pass.value.length<5) {
				alert("パスワードは6字以上入力してください。");
				form.user_pass.focus();
				return false;
			} 
				 	
			if(document.form.user_pass.value!=document.form.pass1.value) {
				alert("パスワードが一致していません。");
				form.user_pass.focus();
				return false;
			}
			
			return true;
	}
	</script>           