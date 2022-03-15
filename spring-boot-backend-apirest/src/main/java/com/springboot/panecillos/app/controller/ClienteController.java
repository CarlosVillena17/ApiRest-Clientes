package com.springboot.panecillos.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.panecillos.app.models.entity.Cliente;
import com.springboot.panecillos.app.models.service.IClienteService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.listar();
	}
	
	@GetMapping("/clientes/page/{pag}")
	public Page<Cliente> index(@PathVariable Integer pag){
		return clienteService.listar(PageRequest.of(pag, 4));
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente=null;
		
		Map<String, Object> response=new HashMap<String, Object>();
		try {
			cliente=clienteService.findById(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Hubo un error en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(cliente==null) {
			response.put("mensaje", "No existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK );
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		Cliente clienteNew=null;
		Map<String, Object> response=new HashMap<String, Object>();
		
		if(result.hasErrors()) {
			//List<String> errores=new ArrayList<String>();
			//for(FieldError err: result.getFieldErrors()) {
				//errores.add(err.getDefaultMessage());
			//}
			List<String> errores=result.getFieldErrors()
					.stream()
					.map( err-> 
						err.getField()+" "+  err.getDefaultMessage()
					)
					.collect(Collectors.toList());
			
			return new ResponseEntity<List<String>>(errores, HttpStatus.BAD_REQUEST);
		}
		try {
			clienteNew=clienteService.save(cliente);
		}catch (DataAccessException e) {
			response.put("mensaje", "Hubo un error en realizar el insert en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//response.put("mensaje", "Cliente creado con exito");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(code = HttpStatus.CREATED) //201
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual=null;
		Cliente clienteUpdate=null;
		clienteActual=clienteService.findById(id);
		
		Map<String, Object> response=new HashMap<String, Object>();
		
		if(clienteActual==null) {
			response.put("mensaje", "No se encontró el cliente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			clienteActual.setNombre(cliente.getNombre()); 
			clienteActual.setEmail(cliente.getEmail()); 
			clienteActual.setApellido(cliente.getApellido());
			clienteUpdate=clienteService.save(clienteActual);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Hubo un error al actualizar el cliente ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//response.put("mensaje", "Cliente actualizado con exito");
		response.put("cliente", clienteUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT) //204
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response=new HashMap<String, Object>();
		try {
			clienteService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Hubo un error al eliminar en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cliente eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
