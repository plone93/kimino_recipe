<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>  

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">재료올리기</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center">
                <div class="col-4">
                                        재료명
                </div>
                <div class="col-4">
               	     가격
                </div>
            </div>
            
            <form action="inserted_Product_Board?board_id=${board_id }" method="POST" enctype="multipart/form-data">
                <div class="row justify-content-center my-2">
                    <div class="col-4">
                        <input type="text" name="product_name" class="form-control" placeholder="제모쿠입료쿠">
                    </div>
                    <div class="col-4">
                        <input type="text" name="price" class="form-control" placeholder="가교쿠입료쿠">
                    </div>
                </div>
                <div class="row justify-content-center my-2">
                        <div class="col-8">
                            <textarea class="form-control" rows="10" name="content" placeholder="재료설명"></textarea>
                        </div>
                    </div>
                    
                <div class="row justify-content-center my-2">
                    <div class="col-8">
                        <div class="input-group mb-3">                    
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" name="file" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
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