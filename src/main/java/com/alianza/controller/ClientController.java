package com.alianza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.alianza.dto.ClientDto;
import com.alianza.service.ClientServices;

@Controller
public class ClientController {
	@Autowired
	ClientServices clientService;

    @MutationMapping
    public String createClient(@Argument ClientDto clientDto) {
    	return clientService.saveClient(clientDto);
    }
    
    @QueryMapping
    public List<ClientDto> findAll() {
    	return clientService.getAll();
    }
    
    @QueryMapping
    public List<ClientDto> searchSharedKey(@Argument String key) {
    	return clientService.getSearchSharedKey(key);
    }
    
}
