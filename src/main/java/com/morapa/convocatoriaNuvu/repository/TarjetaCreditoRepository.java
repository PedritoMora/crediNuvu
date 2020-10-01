package com.morapa.convocatoriaNuvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morapa.convocatoriaNuvu.model.Cliente;
import com.morapa.convocatoriaNuvu.model.TarjetaCredito;

@Repository
public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long> {

	List<TarjetaCredito> findByCliente(Cliente cliente);
}
