package com.alianza.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianza.dto.ClientDto;
import com.alianza.entity.Client;
import com.alianza.mapper.ClientMapper;
import com.alianza.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	ClientRepository clientRepository;
	
	
	
	public String saveClient(ClientDto clientDto) {
		clientDto.setDateAdd(LocalDate.now());
		Client client=ClientMapper.INSTANCIA.convertEntity(clientDto);
		clientRepository.save(client);
		return "Registro Exitoso";	
	}
	
	
	public List<ClientDto> getAll() {
		List<Client> clients=clientRepository.findAll();
		return clients.stream().map(c->ClientMapper.INSTANCIA.convertDto(c)).collect(Collectors.toList());	
	}
	

	public List<ClientDto> getSearchSharedKey(String key) {
		List<Client> clients=clientRepository.findByEmailStartingWith(key+"@");
		return clients.stream().map(c->ClientMapper.INSTANCIA.convertDto(c)).collect(Collectors.toList());	
	}
	
}
