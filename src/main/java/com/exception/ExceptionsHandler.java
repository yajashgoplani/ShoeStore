package com.exception;

/////////////////////////////////////////////////////////////////////////////
//CAL-TECH FULL STACK DEVELOPMENT COURSE -- SPOPRTY SHOES ASSESSMENT ---
//
//DEVELOPER/STUDENT:   Kevin Casey
//ORIGINATION DATE:  20 JULY
//LAST UPDATED  ON:  20 JULY
/////////////////////////////////////////////////////////////////////////////

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	

	@ExceptionHandler(value=Exception.class)
	
	public String handleAnyException() {
		return "Error";
	}
}
