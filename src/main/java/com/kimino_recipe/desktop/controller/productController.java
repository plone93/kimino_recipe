package com.kimino_recipe.desktop.controller;





import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.cartVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.domain.productVO;
import com.kimino_recipe.desktop.service.productService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class productController {
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	private productService product;
	
	/*구매게시판 리스트*/
	@GetMapping("/productList")
	public String productList(@RequestParam("board_id")String board_id,
							  HttpServletRequest request,							  
							  Model model) {
		
		String url = "product/product_List";
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		boardList = product.select_AllBoard(page, board_id);
		pageVO.setTotalCount(product.get_BoardCount(board_id));
		boardCount = pageVO.getTotalCount();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("board_id", board_id);
		model.addAttribute("pageVO", pageVO);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		
		return url;	
	}
	
	/*글쓰기 화면*/
	@GetMapping("/insert_Product_Board")
	public String insert_Product_Board(@RequestParam("board_id")String board_id,
										Model model) {
		
		String url = "product/product_Write";
		model.addAttribute("board_id", board_id);
		
		return url;
	}
	
	/*글쓰기 완료*/
	@PostMapping("/inserted_Product_Board")
	public String inserted_Product_Board(productVO productVO,
										String board_id,
										MultipartFile file,
										Model model){
		String url = "redirect:/productList";
		
		try {
			/*파일 업로드*/
			if(file.getOriginalFilename() != null) { //파일이 업로드 되어서  이름이 가져와지는 경우
				String image = file.getOriginalFilename();
				productVO.setImage(image);
				File target = new File(uploadPath, image);
				FileCopyUtils.copy(file.getBytes(), target);//파일 액세스 권한오류가 발생하나 무시
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		product.insert_Board(productVO, board_id);
		model.addAttribute("board_id", board_id);
		
		return url;	
	}
	
	/*클릭한 게시글 보기*/
	@GetMapping("/product_View")
	public String product_View(HttpServletRequest request,
							   @RequestParam("product_num")String product_num,
							   @RequestParam("board_id")String board_id,
							   Model model) {
		String url = "product/product_View";
		
		/*뒤로가기를 눌렀을 때 이전 페이지를 전달하기 위한 기능*/
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			model.addAttribute("page", page); 
		}
		
		/*검색한 페이지로 들어왔을때 검색한 키워드를 전달하기 위한 기능*/
		String keyWord = null;
		if(request.getParameter("keyWord") != null) {
			keyWord = request.getParameter("keyWord");
			model.addAttribute("keyWord", keyWord);
		}
		
		productVO productVO = product.boardView(product_num);
			
		/*줄바꿈*/
		String content = productVO.getContent();
		content = content.replace("\r\n", "<br>");
		productVO.setContent(content);;

		model.addAttribute("productVO", productVO);
		model.addAttribute("board_id", board_id);
	
			
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
	return url;
	}
	
	/*장바구니에 담기*/
	@ResponseBody
	@PostMapping("/addCart")
	public int addCart(cartVO cartVO) {
		int result = 0;
		result = product.addCart(cartVO);
		
		return result;
	}
	
	/*장바구니 보기*/
	@GetMapping("/cartList")
	public String cartList(@RequestParam("user_id")String user_id,
			 				HttpServletRequest request,
			 				Model model) {
		String url = "product/cart_List";
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		boardList = product.select_Cart(page, user_id);
		pageVO.setTotalCount(product.get_CartCount(user_id));
		boardCount = pageVO.getTotalCount();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}
	
	@GetMapping("/amount_Up")
	public String amount_Up(@RequestParam("user_id")String user_id,
						 @RequestParam("cart_num")String cart_num,
						 Model model) {
		
		String url = "redirect:/cartList";
		
		product.amount_Up(user_id, cart_num);
		model.addAttribute("user_id", user_id);
		
		return url;
		
	}
	
	@GetMapping("/amount_Down")
	public String amount_Down(@RequestParam("user_id")String user_id,
						 @RequestParam("cart_num")String cart_num,
						 Model model) {
		
		String url = "redirect:/cartList";
		
		product.amount_Down(user_id, cart_num);
		model.addAttribute("user_id", user_id);
		
		return url;
		
	}
	
	/*카트에서 상품 삭제*/
	@GetMapping("/cart_Delete")
	public String cart_Delete(@RequestParam("user_id")String user_id,
							  @RequestParam("cart_num")String cart_num,
							  Model model) {
		
		String url = "redirect:/cartList";
		product.cart_Delete(cart_num);
		
		model.addAttribute("user_id", user_id);
		return url;
	}
	
	

}
