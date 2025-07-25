package com.alianza.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.slf4j.Logger;
import com.alianza.dto.ErrorDto;

@ControllerAdvice
@RestController
public class RespondeExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(RespondeExceptionHandler.class);

	@ExceptionHandler(value = { NullPointerException.class })
	public final ResponseEntity<ErrorDto> filtroNullPointerException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(LocalDateTime.now(),String.valueOf(status.value()), status.name(), "Objeto no inicializado",
				request.getDescription(false));
		logger.error(ex.getMessage());
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = { ArithmeticException.class })
	public final ResponseEntity<ErrorDto> filtroArithmeticException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(LocalDateTime.now(),String.valueOf(status.value()), status.name(), "Operación matematica incorrecta",
				request.getDescription(false));
		logger.error(ex.getMessage());
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = { NumberFormatException.class })
	public final ResponseEntity<ErrorDto> filtroNumberFormatException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorDto error = new ErrorDto(LocalDateTime.now(),String.valueOf(status.value()), status.name(), "Error en casteo de numero",
				request.getDescription(false));
		logger.error(ex.getMessage());
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = { FileNotFoundException.class })
	public final ResponseEntity<ErrorDto> filtroFileNotFoundException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(LocalDateTime.now(),String.valueOf(status.value()), status.name(),
				"Archivo incorrecto o no encontrado", request.getDescription(false));
		logger.error(ex.getMessage());
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = { IOException.class })
	public final ResponseEntity<ErrorDto> filtroIOException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(LocalDateTime.now(),String.valueOf(status.value()), status.name(), "El archivo contiene errores",
				request.getDescription(false));
		logger.error(ex.getMessage());
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = { ArrayIndexOutOfBoundsException.class })
	public final ResponseEntity<ErrorDto> filtroArrayIndexException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDto error = new ErrorDto(LocalDateTime.now(),String.valueOf(status.value()), status.name(),
				"Error el indice es ilegal, ya que supera el tramaño de la matriz", request.getDescription(false));
		logger.error(ex.getMessage());
		return new ResponseEntity<>(error, status);
	}
	

}
