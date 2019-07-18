package com.kimino_recipe.desktop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class ExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception......"+ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		//파라미터(값)이 잘못됐을 때 예외처리
		//경로의 메서드의 매개변수 타입이 안맞을 경우
		return "error_page"; //jsp 파일 이름	
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		//경로가 잘못 됐을 때 예외처리
		//컨트롤러에서 RequestMapping("경로")가 안맞는경우
		return "custom404";
	}
}
