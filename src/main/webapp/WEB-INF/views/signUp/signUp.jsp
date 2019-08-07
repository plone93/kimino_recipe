<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file ="../header.jsp" %> 

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center">
                <div class="col-7 pt-4 bg-success text-white rounded mt-5">
                    <h1 class="text-center mb-4">ID新規取得</h1>
                    <form action="inserted_User" method="post" name="form" onsubmit="return signCheck()">
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="ID">ID</label>
                            </div>
                            <div class="col-6">
                                <input type="text" class="form-control" name="user_id" id="id">
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-dark" value="0" id="idCheck">Check</button>
                            </div>
                        </div>
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="name">ニックネーム</label>
                            </div>
                            <div class="col-6">
                                <input type="text" class="form-control" name="user_name" id="name">
                            </div>
                            <div class="col-2">
                            	<button type="button" class="btn btn-dark" value="0" id="nameCheck">Check</button>
                            </div>
                        </div>
                        
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="password">パスワード</label>
                            </div>
                            <div class="col-6">
                                <input type="password" class="form-control" id="password" name="user_pass" placeholder="">
                            </div>
                            <div class="col-2"></div>
                        </div>
                        
                        <div class="row my-3 pl-5">
                            <div class="col-3">
                                <label for="passwordCheck">パスワード確認</label>
                            </div>
                            <div class="col-6">
                                <input type="password" class="form-control" id="passwordCheck" name="user_pass1" id="pass" placeholder="">
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

   
<script>
	$('#idCheck').click(function(){
		var idValue = $('#id').val();
	    var idCheck = /^[a-zA-Z]+[a-z0-9A-Z]{5,19}$/g;
	    
	    if(!idCheck.test(idValue)){
	 		alert("IDはローマ字、またはローマ字＋数字で始まる6～２０字の合わせのみ可能です。");
	 		
	 	} else {
	 		$.ajax({
	 			url:"idCheck",
	 			type:"post",
	 			data:{id:idValue},
	 			dataType:"json",
	 			success:function(data){
	 				if(data != 1){
	 					$('#idCheck').val('1');
	 					alert("使用可能なIDです。");
	 				} else {
	 					$('#idCheck').val('0');
	 					alert("既に使用されているIDです。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		});
	 	}
	});
</script>

<script>
	$('#nameCheck').click(function(){
		var value = $('#name').val();
	    var valueCheck = /^[a-zA-Z]+[a-z0-9A-Z]{1,19}$/g;
	    
	    if(!valueCheck.test(value)){
	 		alert("ニックネームはローマ字、またはローマ字＋数字で始まる2～２０字の合わせのみ可能です。");
	 	} else {
	 		$.ajax({
	 			url:"nameCheck",
	 			type:"post",
	 			data:{name:value},
	 			dataType:"json",
	 			success:function(data){
	 				if(data != 1){
	 					$('#nameCheck').val('1');
	 					alert("使用可能なニックネームです。");
	 				} else {
	 					$('#nameCheck').val('0');
	 					alert("既に使用されているニックネームです。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		});
	 	}
	});
</script>

	<!-- 회원가입 체크 -->
	<script>
		function signCheck() {
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
			if(form.idCheck.value==0) {
				alert("IDチェックをしてください。");
				form.user_id.focus;
				return false;
			}
			if(document.form.user_name.value=="") {
				alert("名前を入力してください。");
				form.user_name.focus();
				return false;
			}			
		    
			if(form.nameCheck.value==0) {
				alert("IDチェックをしてください。");
				form.user_id.focus;
				return false;
			}
			if(document.form.user_pass.value.length==0) {
				alert("パスワードを入力してください。");
				form.user_pass.focus();
				return false;
			}
			
			if(document.form.user_pass.value.length<6) {
				alert("パスワードは6字以上入力してください。");
				form.user_pass.focus();
				return false;
			} 
				 	
			if(document.form.user_pass.value!=document.form.user_pass1.value) {
				alert("パスワードが一致していません。");
				form.user_pass.focus();
				return false;
			}
			
		    var passValue = $('#pass').val();
		    // var passCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{5,16}$/;
		    var passCheck = /^[a-zA-Z]+[a-z0-9A-Z]{4,19}$/g;
		    if(!valueCheck.test(passValue)){
				alert("パスワードはローマ字＋数字で始まる５～２０字の合わせのみ可能です。");
				form.user_pass.focus();
				return false;
		    }

			return true;
	}
	</script>           