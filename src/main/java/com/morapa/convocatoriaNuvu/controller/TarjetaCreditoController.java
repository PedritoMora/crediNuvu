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

import com.morapa.convocatoriaNuvu.model.TarjetaCredito;
import com.morapa.convocatoriaNuvu.service.TarjetaCreditoService;

@RestController
@RequestMapping("tarjetaCredito")
public class TarjetaCreditoController {
	
	@Autowired
	public TarjetaCreditoService tarjetaCreditoService;
	
	@GetMapping
	public List<TarjetaCredito> listarTarjetasCredito(){
		return tarjetaCreditoService.listarTarjetasCredito();
	}
	
	@GetMapping("/{idTarjetaCredito}")
	public TarjetaCredito buscarTarjetaCredito(@PathVariable("idTarjetaCredito") Long idTarjetaCredito) {
		return tarjetaCreditoService.buscarTarjetaCredito(idTarjetaCredito);
	}
	
	@PostMapping()
	public TarjetaCredito guardarTarjetaCredito(@RequestBody TarjetaCredito tarjetaCredito) {
		return tarjetaCreditoService.guardarTarjetaCredito(tarjetaCredito);
	}
	
	@PutMapping("/{idTarjetaCredito}")
	public TarjetaCredito actualizarTarjetaCredito(@RequestBody TarjetaCredito tarjetaCredito) {
		return tarjetaCreditoService.actualizarTarjetaCredito(tarjetaCredito);
	}

}
