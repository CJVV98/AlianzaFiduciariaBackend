package com.alianza.repository;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alianza.entity.Client;

import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class )
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClientsRepositoryTest {

	@Autowired
	ClientRepository clientRepository;
	
	
	 @Test
	 @Transactional
	 public void createClient() {
		Client client=new Client();		
		client.setDateAdd(Date.valueOf(LocalDate.now()));
		client.setEndDate(Date.valueOf(LocalDate.now()));
		client.setStartDate(Date.valueOf(LocalDate.now()));
		client.setEmail("daet@gmail.com");
		client.setName("Ramiro");
		client.setPhone("314324324");
		clientRepository.save(client);
		assertTrue(client.getId()!=null);
		
	}
	 
	 @Test
	 public void getClients() {
		int count= clientRepository.findAll().size();
		assertTrue(count>0);
	 }
}
