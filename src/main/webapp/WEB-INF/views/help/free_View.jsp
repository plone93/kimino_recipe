<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file ="../header.jsp" %> 

       <div class="container">
            <div class="row"><div class="col py-3"></div></div>  
            <div class="row  mt-1 mb-5">
                <div class="col-3"></div>
            </div>          
            <div class="row">
                <div class="col py-3">
                    <h3>자유게시판제목데스네</h3>
                </div>
            </div>  
            <div class="row">
                <div class="col-2 py-3">
                    <img src="../imgs/man-user.png" width="20" height="20" class="d-inline-block align-top">작성자
                </div>
                <div class="col-2 py-3">
                    <img src="../imgs/calendar.png" width="20" height="20" class="d-inline-block align-top"> 작성일
                </div>
                <div class="col-2 py-3">
                    <img src="../imgs/view.png" width="20" height="20" class="d-inline-block align-top">조회수
                </div>
            </div>   
            <div class="row">
                <div class="col py-3">
                    Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way. On her way she met a copy. The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country. But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their
                </div>
            </div>  
            <div class="row my-3"><div class="col"></div></div>
            <div class="row justify-content-center">
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="#" role="button">수정</a>                            
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="#" role="button" data-toggle="modal" data-target="#confirmDelete">삭제</a>       
                    <!-- Modal -->
                    <div class="modal fade" id="confirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">レシピを消し</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body text-left">
                                    정말로 삭제하시겠습니까?<br>
                                    (삭제 후 되돌릴 수 없습니다.)
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Yes</button>
                                    <button type="button" class="btn btn-outline-secondary">No</button>
                                </div>
                            </div>
                        </div>
                    </div>                     
                </div>
                <div class="col-1 py-3">
                    <a class="btn btn-success" href="recipe_list.html" role="button">목록</a>                            
                </div>
            </div> 
        </div>     
    </body> 
</html>


<%@ include file ="../footer.jsp" %>   
