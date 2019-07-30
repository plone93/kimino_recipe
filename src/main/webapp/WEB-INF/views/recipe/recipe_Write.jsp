<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">레시피 작성</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            
            <form action="inserted_Board?board_id=${board_id }" method="POST" enctype="multipart/form-data">
            	 <input type="hidden"  name="user_id"  value="${loginUser.user_id }">
            	  <input type="hidden"  name="user_name" value="${loginUser.user_name }">
            	
                <div class="row justify-content-center my-2">
                    <div class="col-8">
                        <input type="text" class="form-control" name="title" placeholder="레시피이름을 입력하세요">
                    </div>
                </div>
                <div class="row justify-content-center my-2">
                        <div class="col-8">
                            <textarea class="form-control" rows="10" name="content" placeholder="맛있는 레시피를 작성해 주세요"></textarea>
                        </div>
                    </div>
                <div class="row justify-content-center my-2">
                    <div class="col-8">
                        <div class="input-group mb-3" style="display: flex;">                    
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="inputGroupFile01" name="file" aria-describedby="inputGroupFileAddon01">
                                <label class="custom-file-label" for="inputGroupFile01">사진올리기</label>
                            </div>
                        </div>
                    </div>
                </div>                
                <div class="row justify-content-center mt-4">
                    <div class="col-2 text-center">
                        <button type="submit" class="btn btn-success">저장</button>
                    </div>
                    <div class="col-2 text-center">
                        <button type="button" class="btn btn-success">취소</button>
                    </div>
                </div>
            </form>
            
        </div>     
    </body> 
</html>

  
<%@ include file ="../footer.jsp" %>  