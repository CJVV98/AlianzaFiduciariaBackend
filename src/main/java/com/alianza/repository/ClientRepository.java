package com.alianza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alianza.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	List<Client> findByEmailStartingWith(String key);
}
