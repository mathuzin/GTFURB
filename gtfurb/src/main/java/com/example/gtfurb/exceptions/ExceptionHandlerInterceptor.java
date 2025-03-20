package com.example.gtfurb.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerInterceptor {

	@Autowired
	private MessageSource messageSource;

	@org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(NotFoundException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> BadRequestException(BadRequestException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

//	@org.springframework.web.bind.annotation.ExceptionHandler(UsernameNotFoundException.class)
//	public ResponseEntity<StandardError> authorization(UsernameNotFoundException e, HttpServletRequest request) {
//
//		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(),
//				HttpStatus.FORBIDDEN.value(), System.currentTimeMillis());
//		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
//	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NotAuthorizationException.class)
	public ResponseEntity<StandardError> authorization(NotAuthorizationException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage(),
				HttpStatus.UNAUTHORIZED.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), -1,
				System.currentTimeMillis());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), getMessage(x.getDefaultMessage()));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ConflictedException.class)
	public ResponseEntity<StandardError> emailExistsException(ConflictedException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), HttpStatus.CONFLICT.value(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> zuulException(Exception e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				getMessage("erro.inesperado"),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
		e.printStackTrace();
		System.err.println(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(InternalServerException.class)
	public ResponseEntity<StandardError> zuulException(InternalServerException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
		e.printStackTrace();
		System.err.println(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}

	String getMessage(String message) {
		return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
	}
}
