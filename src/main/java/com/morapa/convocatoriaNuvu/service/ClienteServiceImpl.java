package com.morapa.convocatoriaNuvu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morapa.convocatoriaNuvu.model.Cliente;
import com.morapa.convocatoriaNuvu.model.TarjetaCredito;
import com.morapa.convocatoriaNuvu.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TarjetaCreditoService tarjetaCreditoService;
	
	@Override
	public Cliente guardarCliente(Cliente cliente) {
		
		Long id = cliente.getId();
		if(null != id && clienteRepository.existsById(id)) {
			throw new RuntimeException("Ya existe un cliente con el id " + id +".");
		}
		
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarCliente(Long idCliente) {
		
		Optional<Cliente> opClientes = clienteRepository.findById(idCliente);
		if(!opClientes.isPresent()) {
			throw new RuntimeException("No existe ningún cliente con el id "+ idCliente + "."); 
		}
		
		return opClientes.get();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		
		Long idCliente = cliente.getId();
		Optional<Cliente> opClientes = clienteRepository.findById(idCliente);
		if(!opClientes.isPresent()) {
			throw new RuntimeException("No existe ningún cliente con el id "+ idCliente + "."); 
		} 
		
		return clienteRepository.save(cliente);
	}
	
	@Override
	public List<TarjetaCredito> listarTarjetasCliente(Long idCliente) {
		
		try {
			Cliente cliente = buscarCliente(idCliente);
			
			if(null != cliente) {
				return tarjetaCreditoService.listarTarjetasCliente(cliente);
			} else {
				throw new RuntimeException("El cliente no exite.");
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error al consultar servicio de clientes.");
			
		}
		
	}
	
}
