<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../header.jsp" %> 

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row justify-content-center mt-1 mb-5">
                <div class="col-3">
                    <h1 class="text-center">자유게시판</h1>
                </div>
            </div>          
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row">
                <div class="col mt-5">                        
                    <table class="table">                                                          
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>제목</th>
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>                                  
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>오늘은 딸랑방구를 위해 낭낭하게 만들어 봤오요 ^^</td>
                                <td>Moss</td>
                                <td>23</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>USA / The United Kingdom / China / Russia </td>
                                <td>Wintour</td>                                      
                                <td>36</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>USA / The United Kingdom / China / Russia </td>
                                <td>Horwitz</td>                                      
                                <td>41</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>USA / The United Kingdom / China / Russia </td>
                                <td>Horwitz</td>                                      
                                <td>41</td>
                            </tr>
                        </tbody>                                  
                    </table>        
                    <div class="row justify-content-center mt-5">
                        <div class="col-3 text-center">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   