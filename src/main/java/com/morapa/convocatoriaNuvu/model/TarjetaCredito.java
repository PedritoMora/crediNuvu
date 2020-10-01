package com.morapa.convocatoriaNuvu.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarjeta_credito")
@Getter
@Setter
public class TarjetaCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "num_tarjeta", length = 20, nullable = false)
	private String numTarjeta;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Cliente cliente;
	
	@Column(name = "fecha_expedicion", nullable = false)
	private Date fechaExpedicion;
	
	@Column(name = "saldo_disponible", length = 1, nullable = false)
	private BigDecimal saldoDisponible;
	
	@Column(name = "estado_activo", nullable = false)
	private Boolean estadoActivo;
}
