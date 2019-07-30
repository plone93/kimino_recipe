<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file ="header.jsp" %>    

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>
            <div class="row mt-3">
                <div class="col">
                    <h4>게시판별 좋아요 랭킹</h4>
                </div>
            </div>
            
            <div class="row mt-5"><div class="col"><h5>계절요리</h5></div></div>
            <div class="row">
                <div class="col">
                    <img src="resources/images/medal-first.png" width="30" height="30" class="d-inline-block align-top">
                </div>
                <div class="col">
                    <img src="resources/images/medal-second.png" width="30" height="30" class="d-inline-block align-top">
                </div>                
                <div class="col">
                    <img src="resources/images/medal-third.png" width="30" height="30" class="d-inline-block align-top">
                </div>                    
            </div>
            
            <div class="row">
          	  <c:forEach var="season" items="${season}" varStatus="status" begin="0" end="3" step="1">
                	<div class="col" style="flex-grow:0;">
	                    <div class="card" style="width: 15rem;">
	                        <a href="#">
				                <c:if test="${season.image eq null}">
				               		 <img src="resources/images/food-1932466_640.jpg" class="card-img-top">
				                </c:if>
				                <c:if test="${season.image ne null}">
				               		 <img src="resources/images/${season.image }" class="card-img-top">
				                </c:if>	
	                        </a>
	                        <div class="card-body">
	                            <h5 class="card-title">${fn:substring(season.title,0,9)}</h5>                                    
	                        </div>
	                    </div>
               		 </div>   
              </c:forEach>                                      
            </div>
            
            
            <div class="row mt-5"><div class="col"><h5>외국요리</h5></div></div>
            <div class="row">
                <div class="col">
                    <img src="resources/images/medal-first.png" width="30" height="30" class="d-inline-block align-top">
                </div>
                <div class="col">
                    <img src="resources/images/medal-second.png" width="30" height="30" class="d-inline-block align-top">
                </div>                
                <div class="col">
                    <img src="resources/images/medal-third.png" width="30" height="30" class="d-inline-block align-top">
                </div>                    
            </div>
            
            <div class="row">
          	  <c:forEach var="country" items="${country}" varStatus="status" begin="0" end="3" step="1">
                	<div class="col" style="flex-grow:0;">
	                    <div class="card" style="width: 15rem;">
	                        <a href="#">
				                <c:if test="${country.image eq null}">
				               		 <img src="resources/images/food-1932466_640.jpg" class="card-img-top">
				                </c:if>
				                <c:if test="${country.image ne null}">
				               		 <img src="resources/images/${country.image }" class="card-img-top">
				                </c:if>	
	                        </a>
	                        <div class="card-body">
	                            <h5 class="card-title">${fn:substring(country.title,0,9)}</h5>                                    
	                        </div>
	                    </div>
               		 </div>   
              </c:forEach>                                      
            </div>
            
            <div class="row mt-5"><div class="col"><h5>자취</h5></div></div>
            <div class="row">
                <div class="col">
                    <img src="resources/images/medal-first.png" width="30" height="30" class="d-inline-block align-top">
                </div>
                <div class="col">
                    <img src="resources/images/medal-second.png" width="30" height="30" class="d-inline-block align-top">
                </div>                
                <div class="col">
                    <img src="resources/images/medal-third.png" width="30" height="30" class="d-inline-block align-top">
                </div>                    
            </div>
            <div class="row">
          	  <c:forEach var="single" items="${single}" varStatus="status" begin="0" end="3" step="1">
                	<div class="col" style="flex-grow:0;">
	                    <div class="card" style="width: 15rem;">
	                        <a href="#">
				                <c:if test="${single.image eq null}">
				               		 <img src="resources/images/food-1932466_640.jpg" class="card-img-top">
				                </c:if>
				                <c:if test="${single.image ne null}">
				               		 <img src="resources/images/${single.image }" class="card-img-top">
				                </c:if>	
	                        </a>
	                        <div class="card-body">
	                            <h5 class="card-title">${fn:substring(single.title,0,9)}</h5>                                    
	                        </div>
	                    </div>
               		 </div>   
              </c:forEach>                                      
            </div>
            
        </div>     
    </body> 
</html>

<%@ include file ="footer.jsp" %>   