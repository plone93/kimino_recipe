<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">공지사항 쓰기</h1>
                </div>
            </div>          
            <form action="#" method="POST">
                <div class="row justify-content-center my-2">
                    <div class="col-8">
                        <input type="text" class="form-control" placeholder="제목">
                    </div>
                </div>
                <div class="row justify-content-center my-2 mb-3">
                    <div class="col-8">
                        <textarea class="form-control" rows="10" placeholder="내용"></textarea>
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