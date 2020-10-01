package com.morapa.convocatoriaNuvu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morapa.convocatoriaNuvu.model.Cliente;
import com.morapa.convocatoriaNuvu.model.TarjetaCredito;
import com.morapa.convocatoriaNuvu.repository.TarjetaCreditoRepository;

@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService{
	
	@Autowired
	private TarjetaCreditoRepository tarjetaCreditoRepository;
	
	@Override
	public TarjetaCredito guardarTarjetaCredito(TarjetaCredito tarjetaCredito) {
		
		Long id = tarjetaCredito.getId();
		if(null != id && tarjetaCreditoRepository.existsById(id)) {
			throw new RuntimeException("Ya existe una tarjeta de crédito con el id " + id +".");
		}
		
		return tarjetaCreditoRepository.save(tarjetaCredito);
	}

	@Override
	public List<TarjetaCredito> listarTarjetasCredito() {
		return tarjetaCreditoRepository.findAll();
	}

	@Override
	public TarjetaCredito buscarTarjetaCredito(Long idTarjetaCredito) {
		
		Optional<TarjetaCredito> opTarjetaCreditos = tarjetaCreditoRepository.findById(idTarjetaCredito);
		if(!opTarjetaCreditos.isPresent()) {
			throw new RuntimeException("No existe ningúna tarjeta de crédito con el id "+ idTarjetaCredito + "."); 
		}
		
		return opTarjetaCreditos.get();
	}

	@Override
	public TarjetaCredito actualizarTarjetaCredito(TarjetaCredito tarjetaCredito) {
		
		Long idTarjetaCredito = tarjetaCredito.getId();
		Optional<TarjetaCredito> opTarjetaCreditos = tarjetaCreditoRepository.findById(idTarjetaCredito);
		if(!opTarjetaCreditos.isPresent()) {
			throw new RuntimeException("No existe ningúna tarjeta de crédito con el id "+ idTarjetaCredito + "."); 
		} 
		
		return tarjetaCreditoRepository.save(tarjetaCredito);
	}

	@Override
	public List<TarjetaCredito> listarTarjetasCliente(Cliente cliente) {
		
		return tarjetaCreditoRepository.findByCliente(cliente);
	}
	
	

	
	

}
