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
import com.kimino_recipe.desktop.domain.orderVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.domain.productVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.service.productService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class productController {
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	private productService product;
	private userService user;
	
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
						 @RequestParam("amount")String amount,
						 Model model) {
		
		String url = "redirect:/cartList";
		System.out.println(amount);
		
		if(Integer.parseInt(amount) == 1) {
			model.addAttribute("message", "最低数量は一つ以上です。");
		} else {
			product.amount_Down(user_id, cart_num);
		}
		
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
	
	
	/*주문 처리*/
	
	/*주문페이지*/
	@PostMapping("/order")
	public String order(@RequestParam("user_id")String user_id,
						HttpServletRequest request,
						Model model) {
		String url = "product/order";
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		/*주문한 리스트*/
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
		
		userVO userVO = user.get_User(user_id);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("userVO", userVO);
		
		/*주소*/
		
		return url;
	}
	
	/*주문완료*/
	@PostMapping("/ordered")
	public String ordered(orderVO orderVO,
						  Model model) {
		
		String url = "redirect:/main";
		int result = 0;
		String product_id = orderVO.getProduct_id(); // VO에 저장되있는 변수를  꺼내옴
		String product_name = orderVO.getProduct_name(); // VO에 저장되있는 변수를  꺼내옴
		String price = orderVO.getPrice(); // VO에 저장되있는 변수를  꺼내옴
		String amount = orderVO.getAmount(); // VO에 저장되있는 변수를  꺼내옴
		String cart_num = orderVO.getCart_num(); //주문 완료된 카트 아이템을 제거하기 위한 변수
	
		String[] product_id_Array = product_id.split(","); // 꺼내온 변수를 ,를 기준으로  끊어서 배열에 차례대로 저장
		String[] product_name_Array = product_name.split(","); // 꺼내온 변수를 ,를 기준으로  끊어서 배열에 차례대로 저장
		String[] price_Array = price.split(","); // 꺼내온 변수를 ,를 기준으로  끊어서 배열에 차례대로 저장
		String[] amount_Array = amount.split(","); // 꺼내온 변수를 ,를 기준으로  끊어서 배열에 차례대로 저장
		String[] cart_num_Array = cart_num.split(","); // 꺼내온 변수를 ,를 기준으로  끊어서 배열에 차례대로 저장
		
		/*주문번호 생성*/
		String order_id_char1 = Integer.toString((int) ((Math.random() * 26) + 65)); //전역변수 선언
		String order_id_char2 = Integer.toString((int) ((Math.random() * 26) + 65)); //전역번수에 null을 선언하면  nullABCD순으로  생성됨, 전역변수에서 초기값 선언 필요
		
		for(int i = 0; i < 3; i++) {// 3개의 문자를 생성함
			char char1 = (char) ((Math.random() * 26) + 65); // 주문번호 영문 대문자 문자열 생성1
			char char2 = (char) ((Math.random() * 26) + 65); // 주문번호 영문 대문자 문자열 생성2
			
			order_id_char1 = order_id_char1 + char1; //랜덤 생성된 문자열을 누적
			order_id_char2 = order_id_char2 + char2; 
		}

		String order_id_num = Integer.toString((int) (Math.random()*999));//주문번호 숫자 생성
		
		String order_id = "19-"+order_id_char1+order_id_num+order_id_char2; //주문번호 결합 생성, 원래는 생성후 데이터베이스 중복검사가 필요하나 일시적 생략
		
		for(int i = 0; i <= (product_id_Array.length-1); i++) {
			result = product.insert_OrderList(orderVO, product_id_Array[i], product_name_Array[i], price_Array[i], amount_Array[i], order_id); // 주문 완료후 주문 리스트에 저장
		}
		
		if(result >= 1) {
			for(int i = 0; i <=(cart_num_Array.length-1); i++) {
				product.cart_Delete(cart_num_Array[i]);
			}
			model.addAttribute("message", "注文完了");
		} else {
			model.addAttribute("message", "エラーが発生しました。");
		}
		
		return url;
	}
	
	/*주문내역에서 주문id를 클릭했을 때  해당 id와 동일한 상품 표기 (같이 주문한 상품의 주문id는 전부 동일함)*/
	@GetMapping("/orderView")
	public String orderView(HttpServletRequest request,
							@RequestParam("order_id")String order_id,
							@RequestParam("user_id")String user_id,
							Model model) {
		String url = "product/orderView";
		
		List<productVO> boardList = new ArrayList<productVO>();
		
		/*주문한 리스트*/
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		boardList = product.orderView(page, order_id);
		pageVO.setTotalCount(product.get_orderCount(order_id));
		boardCount = pageVO.getTotalCount();
		
		userVO userVO = user.get_User(user_id);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("userVO", userVO);
		
		return url;
	}
	

}
