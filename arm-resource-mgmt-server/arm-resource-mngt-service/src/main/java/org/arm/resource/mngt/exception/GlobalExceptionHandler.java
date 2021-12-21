package org.arm.resource.mngt.exception;

import java.time.LocalDateTime;

import org.arm.resource.mngt.entity.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Method not allowed";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Invalid media type";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status.value()).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Path variable is missing  ";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Requesting parameter is missing ";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Type mismatch";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	// Custom Exceptions

	// ID NOT found Exception
	@ExceptionHandler(IDNotFoundException.class)
	protected ResponseEntity<Object> handleIDNotFound(IDNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "ID not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	// Campaign Not found Exception
	@ExceptionHandler(CampaignNotFoundException.class)
	protected ResponseEntity<Object> handle(CampaignNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Campaign is not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	// Project Not found Exception
	@ExceptionHandler(ProjectNotFoundException.class)
	protected ResponseEntity<Object> handle(ProjectNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Project is not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	// Task Not found Exception
	@ExceptionHandler(TaskNotFoundException.class)
	protected ResponseEntity<Object> handleTaskNotFound(TaskNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Task is not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	// Resource Not found Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Resource is not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	// other Exceptions

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleOther(Exception ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "other exception";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.BAD_GATEWAY.value(), error);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);

	}

}
