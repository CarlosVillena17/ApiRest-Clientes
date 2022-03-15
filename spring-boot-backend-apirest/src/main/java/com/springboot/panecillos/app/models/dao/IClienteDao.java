package com.springboot.panecillos.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.panecillos.app.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
}
