<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">作成</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            <form action="edited_Board?board_id=${board_id }&board_num=${boardVO.board_num }" method="POST">
            	 <input type="hidden"  name="user_id"  value="${loginUser.user_id }">
            	 <input type="hidden"  name="user_name" value="${loginUser.user_name }">
            	 <input type="hidden"  name="page" value="${page }">
            	
                <div class="row justify-content-center my-2">
                    <div class="col-8">
                        <input type="text" class="form-control" name="title" placeholder="題目を入力してください。" value="${boardVO.title }">
                    </div>
                </div>
                <div class="row justify-content-center my-2">
                        <div class="col-8">
                            <textarea class="form-control" rows="10" name="content" placeholder="内容を入力してください。">${boardVO.content }</textarea>
                        </div>
                    </div>
                <div class="row justify-content-center my-2">
                    <div class="col-8">
                        <div class="input-group mb-3">                    
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="inputGroupFile01" name="image" aria-describedby="inputGroupFileAddon01">
                                <label class="custom-file-label" for="inputGroupFile01">アップロード</label>
                            </div>
                        </div>
                    </div>
                </div>                
                <div class="row justify-content-center mt-4">
                    <div class="col-2 text-center">
                        <button type="submit" class="btn btn-success">作成</button>
                    </div>
                    <div class="col-2 text-center">
                        <button type="button" class="btn btn-success">取り消し</button>
                    </div>
                </div>
            </form>
        </div>     
    </body> 
</html>

  
<%@ include file ="../footer.jsp" %>  