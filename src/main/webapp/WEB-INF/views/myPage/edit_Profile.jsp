<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">アカウント管理</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-success">アカウント情報</button>
                        <a href="edit_Profile?user_id=${loginUser.user_id }" class="list-group-item list-group-item-action list-group-item-success">情報修正</a>
                        <a href="my_WriteList?user_id=${loginUser.user_id }" class="list-group-item list-group-item-action list-group-item-light">作成履歴</a>
                        <a href="cancel_User" class="list-group-item list-group-item-action list-group-item-light">アカウント脱退</a>                                    
                    </div>
                </div>
                <div class="col-9">
                
                    <form method="POST" action="#" name="form" onsubmit="return userUpdate()">
                    
                    <div class="form-group">
						<input type="hidden" name="user_num" value="${loginUser.user_num }">
					</div>	
					
                        <div class="row justify-content-center mt-5 py-2">
                            <div class="col-2">
                                <label for="Email">メール</label>
                            </div>
                            <div class="col-3">
                                <input type="email" class="form-control"  value="${userVO.user_email }" name="user_email" id="user_email">
                            </div>
                            <div class="col-1">
                            	<button type="button" class="btn btn-dark" id="emailUpdate">更新</button>  
                            </div>
                        </div>
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">ニックネーム</label>
                            </div>
                            <div class="col-3">
                                <input type="text" class="form-control"  value="${userVO.user_name }" name="user_name" id="user_name">
                            </div>
                            <div class="col-1">
                                <button type="button" class="btn btn-dark" id="nameUpdate">更新</button>                            
                            </div>
                        </div>
                                         
                        <div class="row justify-content-center py-2">
                            
                            <div class="col-2">
                                <label for="password">パスワード</label>
                            </div>
                            <div class="col-3">
                                <input type="password" class="form-control"  placeholder="ローマ字＋数字">
                            </div>
                            <div class="col-1"></div>
                        </div>
                        <div class="row justify-content-center py-2">
                            <div class="col-2">
                                <label for="passwordCheck">パスワード確認</label>
                            </div>
                            <div class="col-3">
                                <input type="password" class="form-control" name="user_pass" id="user_pass">
                            </div>
                            <div class="col-1">
                            	<button type="button" class="btn btn-dark" id="passUpdate">更新</button> 
                            </div>                
                        </div>                                  

                    </form>
                    
                </div>
            </div>
        </div>     
    </body> 
</html>

<script>
	$('#emailUpdate').click(function(){
		var user_email = $('#user_email').val();
		var user_num = "${loginUser.user_num}"
	    
	    var allData = { "user_email": user_email, 
	    				"user_num": user_num };//여러개의 변수를  배열에 저장
	    
	 		$.ajax({
	 			url:"emailUpdate",
	 			type:"post",
	 			data:allData, //변수들이 저장된 배열을 넘김, 배열의 경우 변수 지정없이 배열에서 지정한 변수이름을 그대로 사용
	 			dataType:"json",
	 			success:function(data){
	 				if(data != 1){
	 					alert("更新完了。");
	 				} else {
	 					alert("既に使用されているIDです。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		});
	});
</script>


<script>
	$('#nameUpdate').click(function(){
		var user_name = $('#user_name').val();
		var user_num = ${loginUser.user_num}
	    var valueCheck = /^[a-zA-Z]+[a-z0-9A-Z]{3,19}$/g;
	    
	    var allData = { "user_name": user_name, "user_num": user_num };//여러개의 변수를  배열에 저장
	    
	    if(!valueCheck.test(user_name)){
	 		alert("닉네임은 영어 영어+숫자 한글 ");
	 	} else {
	 		$.ajax({
	 			url:"nameUpdate",
	 			type:"post",
	 			data:allData, //변수들이 저장된 배열을 넘김, 배열의 경우 변수 지정없이 배열에서 지정한 변수이름을 그대로 사용
	 			dataType:"json",
	 			success:function(data){
	 				if(data != 1){
	 					alert("更新完了。");
	 				} else {
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
	$('#passUpdate').click(function(){
		var user_pass = $('#user_pass').val();
		var user_num = ${loginUser.user_num}
	    var valueCheck = /^[a-zA-Z]+[a-z0-9A-Z]{5,19}$/g;
	    
	    var allData = { "user_pass": user_pass, "user_num": user_num };//여러개의 변수를  배열에 저장
	    
	    if(!valueCheck.test(user_pass)){
	 		alert("비번はローマ字、またはローマ字＋数字で始まる6～２０字の合わせのみ可能です。");
	 	} else {
	 		$.ajax({
	 			url:"passUpdate",
	 			type:"post",
	 			data:allData, //변수들이 저장된 배열을 넘김, 배열의 경우 변수 지정없이 배열에서 지정한 변수이름을 그대로 사용
	 			dataType:"json",
	 			success:function(data){
	 				if(data != 1){
	 					alert("更新完了。");
	 				} else {
	 					alert("既に使用されているIDです。");
	 				}
	 			}, error:function(request, status, error){
	 				alert("エラーが発生しました。");
	 			}
	 		});
	 	}
	});
</script>

<%@ include file ="../footer.jsp" %>   