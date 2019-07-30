<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html> 
    <head> 
        <meta charset="utf-8"/> 
        <meta name="viewport" content="width=device-width">
        <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>君のレシピ</title> 
        
     <!-- css 파일 -->
  	  <%-- <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">  --%>
     <%-- <link href="${pageContext.request.contextPath}/resources/js/bootstrap.js" rel="stylesheet"> --%>
     <%-- <link href="${pageContext.request.contextPath}/resources/jquery/jquery.min.js" rel="stylesheet"> --%>   
        
    
    <!-- 컨트롤러에서 넘어오는 메세지창을 띄움 -->    
    <%String message = (String)request.getAttribute("message");%>
	<c:if test="${message ne null}">
		<script>
			alert("<%=message%>");
		</script>
	</c:if>
    </head> 
    
    <body>         
        <header class="alert alert-success" style="margin-bottom: 0 !important;">         
            <div class="container">
                <div class="row">
                    <div class="col-2 text-center pt-4 font-weight-bold">
                        <a class="navbar-brand text-dark" href="main">    
                            <img src="resources/images/cook.png" width="40" height="40" class="d-inline-block align-top">
                      		      君のレシピ
                        </a>            
                    </div> 
                    
                <form action="search_Board_Total" method="post" name="" class="col-6">     
                    <div class="row my-4">
                        <div class="col-9">
                            <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="レシピを検索" aria-label="Search">
                        </div>
                        <div class="col-3">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">検索</button>
                        </div>
                    </div>                                
                </form>  
                    
                <c:if test="${loginUser eq null and loginAdmin eq null}">
                    <div class="col-4 pt-4">
                  	    <a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="insert_User">ID新規取得</a> 
                        <a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="login_User">ログイン</a>                  
                    </div> 
				</c:if>
				<c:if test="${loginUser ne null or loginAdmin ne null}">
                    <div class="col-4 pt-4">
                    	<c:if test="${loginUser ne null }">
                    	   <a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="cartList?user_id=${loginUser.user_id }">카트</a>  
                    	   <a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="edit_Profile?user_id=${loginUser.user_id }">회원정보수정</a>                  
                    	   <a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="logout">로그아웃</a>  
                    	</c:if>
                    	<c:if test="${loginAdmin ne null }">
                    		<a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="admin_Page?admin_id=${loginAdmin.admin_id }">사이트관리</a>            	  
                    		<a class="btn btn-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="logout">로그아웃</a>  
                    	</c:if>

                    </div> 
				</c:if>	
                             
                </div>
            </div>                                                    
        </header>
        <ul class="nav justify-content-center bg-success">
        
            <li class="nav-item dropdown mx-5">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">계절요리</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              		<c:set var="spring" value="봄"/><a class="dropdown-item" href="boardList?board_id=${spring}">봄</a>
                    <c:set var="summer" value="여름"/><a class="dropdown-item" href="boardList?board_id=${summer}">여름</a>
                    <c:set var="fall" value="가을"/><a class="dropdown-item" href="boardList?board_id=${fall}">가을</a>
                    <c:set var="winter" value="겨울"/><a class="dropdown-item" href="boardList?board_id=${winter}">겨울</a>
                </div>
            </li>
            
            <li class="nav-item dropdown mx-5">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">외국요리</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:set var="cook_kr" value="한국요리"/><a class="dropdown-item" href="boardList?board_id=${cook_kr}">한국요리</a>
                    <c:set var="cook_jp" value="일본요리"/><a class="dropdown-item" href="boardList?board_id=${cook_jp}">일본요리</a>
                    <c:set var="cook_ws" value="서양요리"/><a class="dropdown-item" href="boardList?board_id=${cook_ws}">서양요리</a>
                </div>
            </li>
            
            <li class="nav-item dropdown mx-5">
             <c:set var="cook_single" value="자취"/>
                <a class="nav-link text-white" href="boardList?board_id=${cook_single}" id="navbarDropdown" role="button">자취</a>                
            </li>
            
            <li class="nav-item dropdown mx-5">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">쇼핑</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:set var="vegetable" value="야채"/><a class="dropdown-item" href="productList?board_id=${vegetable}">야채</a>
                    <c:set var="fruit" value="과일"/><a class="dropdown-item" href="productList?board_id=${fruit}">과일</a>
                    <c:set var="fish" value="생선"/><a class="dropdown-item" href="productList?board_id=${fish}">생선</a>
                    <c:set var="meet" value="육류"/><a class="dropdown-item" href="productList?board_id=${meet}">육류</a>
                    <c:set var="hukusima" value="후쿠시마산"/><a class="dropdown-item" href="productList?board_id=${hukusima}">후쿠시마</a>
                </div>
            </li>
            
            <li class="nav-item mx-5">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">게시판</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                	<c:set var="notice" value="공지사항"/><a class="dropdown-item" href="noticeList?board_id=${notice}">공지사항</a>
                	<c:set var="free" value="자유게시판"/><a class="dropdown-item" href="boardList2?board_id=${free}">자유게시판</a>                
                </div>
            </li>
        </ul>  