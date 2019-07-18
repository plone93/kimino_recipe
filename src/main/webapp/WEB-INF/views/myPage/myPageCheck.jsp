<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

        <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row"><div class="col py-3"></div></div>
            <div class="row justify-content-center">
                <div class="col text-center">
                    <h3>パスワード確認</h3>
                </div>
            </div>
            <div class="row"><div class="col py-3"></div></div>
            <form action="#" method="POST">
                <div class="row justify-content-center">
                    <div class="col-3 text-center">
                        <input type="password" class="form-control" placeholder="パスワード入力">
                    </div>
                    <div class="col-2 text-center">
                        <button type="submit" class="btn btn-success" role="button">チェック</button>                            
                    </div>
                </div>
            </form>
        </div>
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   