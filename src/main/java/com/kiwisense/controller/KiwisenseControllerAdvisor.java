package com.kiwisense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.kiwisense.exception.ResourceNotFoundException;

@ControllerAdvice
public class KiwisenseControllerAdvisor {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Error handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
		BindingResult result = ex.getBindingResult();

		List<String> errorList = new ArrayList<>();
		result.getFieldErrors().forEach((fieldError) -> {
			errorList.add(fieldError.getObjectName() + "." + fieldError.getField() + " : "
					+ fieldError.getDefaultMessage() + " : rejected value [" + fieldError.getRejectedValue() + "]");
		});
		result.getGlobalErrors().forEach((fieldError) -> {
			errorList.add(fieldError.getObjectName() + " : " + fieldError.getDefaultMessage());
		});

		return new Error(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorWithoutFields handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
		return new ErrorWithoutFields(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorWithoutFields handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		return new ErrorWithoutFields(HttpStatus.NOT_FOUND, ex.getMessage());
	}
	
	public static class ErrorWithoutFields{
		private int errorCode;
		private String error;
		private String errorMessage;

		public ErrorWithoutFields(HttpStatus status, String message) {
			this.errorCode = status.value();
			this.error = status.name();
			this.errorMessage = message;

		}

		public ErrorWithoutFields(HttpStatus status, String message, List<String> fieldErrors) {
			this.errorCode = status.value();
			this.error = status.name();
			this.errorMessage = message;
		}

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

	}
	
	public static class Error {
		private int errorCode;
		private String error;
		private String errorMessage;
		private List<String> fieldErrors = new ArrayList<>();

		public Error(HttpStatus status, String message) {
			this.errorCode = status.value();
			this.error = status.name();
			this.errorMessage = message;

		}

		public Error(HttpStatus status, String message, List<String> fieldErrors) {
			this.errorCode = status.value();
			this.error = status.name();
			this.errorMessage = message;
			this.fieldErrors = fieldErrors;
		}

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public List<String> getFieldErrors() {
			return fieldErrors;
		}

		public void setFieldErrors(List<String> fieldErrors) {
			this.fieldErrors = fieldErrors;
		}
	}
}