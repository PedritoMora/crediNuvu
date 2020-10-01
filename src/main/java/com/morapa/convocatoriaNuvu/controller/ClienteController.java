package com.morapa.convocatoriaNuvu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morapa.convocatoriaNuvu.model.Cliente;
import com.morapa.convocatoriaNuvu.model.TarjetaCredito;
import com.morapa.convocatoriaNuvu.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	public ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{idCliente}")
	public Cliente buscarCliente(@PathVariable("idCliente") Long idCliente) {
		return clienteService.buscarCliente(idCliente);
	}
	
	@GetMapping("/{idCliente}/tarjetas")
	public List<TarjetaCredito> listaTarjetasCliente(@PathVariable("idCliente") Long idCliente){
		return clienteService.listarTarjetasCliente(idCliente);
	}
	
	@PostMapping()
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return clienteService.guardarCliente(cliente);
	}
	
	@PutMapping("/{idCliente}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente) {
		return clienteService.actualizarCliente(cliente);
	}
	
}
