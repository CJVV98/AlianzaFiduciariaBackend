package com.alianza.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {	
	@ApiModelProperty(notes = "Variable que contiene la fecha de la excepcion.", required = true, position = 0)
	private LocalDateTime timestamp;
	@ApiModelProperty(notes = "Variable que contiene el status de la excepcion.", required = true, position = 1)
	private String status;
	@ApiModelProperty(notes = "Variable que contiene en detalle el error de la excepcion.", required = true, position = 2)
	private String error;
	@ApiModelProperty(notes = "Variable que contiene el mensaje de la excepcion.", required = true, position = 3)
	private Object message;
	@ApiModelProperty(notes = "Variable que contiene el path de la excepcion.", required = true, position = 4)
	private String path;
}
