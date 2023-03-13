package com.spring.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

/* �ش� ��ü�� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� ó���ϴ� �������� ����ϴ� �뵵�� ��� */
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	/* @ExceptionHandler�� �ش� �޼��尡 () ���� ���� Ÿ���� ó�� */
	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception ex, Model model) {
		log.error("Exception ....." + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error/error_page";
	}
	
	/* ���� ������ ������ ã�� ������ ��쿡 ���� ���� ó�� - 404error */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "error/custom404";
	}
}
