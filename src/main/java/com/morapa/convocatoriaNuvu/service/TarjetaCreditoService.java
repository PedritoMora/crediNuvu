package com.morapa.convocatoriaNuvu.service;

import java.util.List;

import com.morapa.convocatoriaNuvu.model.Cliente;
import com.morapa.convocatoriaNuvu.model.TarjetaCredito;

public interface TarjetaCreditoService {
	
	TarjetaCredito guardarTarjetaCredito(TarjetaCredito tarjetaCredito);
		
	List<TarjetaCredito> listarTarjetasCredito();
	
	TarjetaCredito buscarTarjetaCredito(Long idTarjetaCredito);
	
	TarjetaCredito actualizarTarjetaCredito(TarjetaCredito tarjetaCredito);

	List<TarjetaCredito> listarTarjetasCliente(Cliente cliente);
}
