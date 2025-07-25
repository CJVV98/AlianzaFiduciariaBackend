package com.alianza.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ClientDto {

	private String user;
	private String name;
	private String email;
	private String phone;
	private LocalDate dateAdd;
	private LocalDate startDate;
	private LocalDate endDate;
}
