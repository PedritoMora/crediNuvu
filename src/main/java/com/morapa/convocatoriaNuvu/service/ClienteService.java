package com.morapa.convocatoriaNuvu.service;

import java.util.List;

import com.morapa.convocatoriaNuvu.model.Cliente;
import com.morapa.convocatoriaNuvu.model.TarjetaCredito;

public interface ClienteService {
	
	Cliente guardarCliente(Cliente cliente);
		
	List<Cliente> listarClientes();
	
	Cliente buscarCliente(Long idCliente);
	
	Cliente actualizarCliente(Cliente cliente);

	List<TarjetaCredito> listarTarjetasCliente(Long idCliente);
	
}
