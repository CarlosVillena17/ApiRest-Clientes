package com.springboot.panecillos.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.panecillos.app.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> listar(); 
	public Page<Cliente> listar(Pageable pageable); 
	public Cliente save(Cliente cliente);
	public void delete(Long id); 
	public Cliente findById(Long id);
}
