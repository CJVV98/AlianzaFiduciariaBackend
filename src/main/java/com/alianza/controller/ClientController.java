package com.alianza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.alianza.dto.ClientDto;
import com.alianza.service.ClientServices;

import io.swagger.annotations.ApiOperation;

@Controller
public class ClientController {
	@Autowired
	ClientServices clientService;


	@ApiOperation(value = "Crear cliente", notes = "El metodo se usa para crear cliente",response = String.class,
			httpMethod = "POST")
    @MutationMapping
    public String createClient(@Argument ClientDto clientDto) {
    	return clientService.saveClient(clientDto);
    }
    

	@ApiOperation(value = "Listar Clientes", notes = "El metodo obtiene los clientes.",response = List.class,
			httpMethod = "GET")
    @QueryMapping
    public List<ClientDto> findAll() {
    	return clientService.getAll();
    }
    @ApiOperation(value = "Consultar clientes por palabra clave ", notes = "Se obtiene el listado de clientes de acuerdo a una palabra clave",response = List.class,
    		httpMethod = "GET")
    @QueryMapping
    public List<ClientDto> searchSharedKey(@Argument String key) {
    	return clientService.getSearchSharedKey(key);
    }
    
}
