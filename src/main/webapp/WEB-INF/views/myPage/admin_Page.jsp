<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container-fluid">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">管理</h1>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row">
                <div class="col-2 ml-2 mt-5">
                    <div class="list-group">
                        <button type="button" class="list-group-item list-group-item-action active list-group-item-success">アカウント情報</button>
                        <a href="userList" class="list-group-item list-group-item-action list-group-item-success">ユーザー管理</a>
                        <a href="reportList" class="list-group-item list-group-item-action list-group-item-light">申告管理</a>
                        <a href="orderList" class="list-group-item list-group-item-action list-group-item-light">注文管理</a>                                  
                    </div>
                </div>
                <div class="col-9">
                
                    <form method="POST" action="#" name="form" onsubmit="return userUpdate()">
                    
                    <div class="form-group">
						<input type="hidden" name="admin_num" value="${loginAdmin.admin_num }">
					</div>	
					
                        <div class="row justify-content-center mt-5 py-2">
                            <div class="col-2">
                                <label for="Email">メール</label>
                            </div>
                            <div class="col-3">
                                <input type="email" class="form-control"  value="${adminVO.admin_email }" name="admin_email" id="admin_email">
                            </div>
                            <div class="col-1">
                            	<button type="button" class="btn btn-dark" id="emailUpdate_Admin">更新</button>  
                            </div>
                        </div>
                        <div class="row justify-content-center py-3">
                            <div class="col-2">
                                <label for="name">ニックネーム</label>
                            </div>
                            <div class="col-3">
                                <input type="text" class="form-control"  value="${adminVO.admin_name }" name="admin_name" id="admin_name">
                            </div>
                            <div class="col-1">
                                <button type="button" class="btn btn-dark" id="nameUpdate_Admin">更新</button>                            
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
                            	<button type="button" class="btn btn-dark" id="passUpdate_Admin">更新</button> 
                            </div>   
                        </div>                                  

                    </form>
                    
                </div>
            </div>
        </div>     
    </body> 
</html>

<script>
	$('#emailUpdate_Admin').click(function(){
		var admin_email = $('#admin_email').val();
		var admin_num = "${loginAdmin.admin_num}"
	    
	    var allData = { "admin_email": admin_email, 
	    				"admin_num": admin_num };//여러개의 변수를  배열에 저장
	    
	 		$.ajax({
	 			url:"emailUpdate_Admin",
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
	$('#nameUpdate_Admin').click(function(){
		var admin_name = $('#admin_name').val();
		var admin_num = "${loginAdmin.admin_num}"
	    var valueCheck = /^[a-zA-Z]+[a-z0-9A-Z]{3,19}$/g;
	    
	    var allData = { "admin_name": admin_name,
	    				"admin_num": admin_num };//여러개의 변수를  배열에 저장
	    
	    if(!valueCheck.test(admin_name)){
	 		alert("IDはローマ字、またはローマ字＋数字で始まる4～２０字の合わせのみ可能です。");
	 	} else {
	 		$.ajax({
	 			url:"nameUpdate_Admin",
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
	$('#passUpdate_Admin').click(function(){
		var admin_pass = $('#admin_pass').val();
		var admin_num = "${loginAdmin.admin_num}"
	    var valueCheck = /^[a-zA-Z]+[a-z0-9A-Z]{5,19}$/g;
	    
	    var allData = { "admin_pass": admin_pass,
	    				"admin_num": admin_num };//여러개의 변수를  배열에 저장
	    
	    if(!valueCheck.test(admin_pass)){
	 		alert("비번はローマ字、またはローマ字＋数字で始まる6～２０字の合わせのみ可能です。");
	 	} else {
	 		$.ajax({
	 			url:"passUpdate_Admin",
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