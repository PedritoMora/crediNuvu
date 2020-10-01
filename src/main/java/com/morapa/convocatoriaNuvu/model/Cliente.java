/**
 * Modelo Cliente
 * 
 * @author Pedro Mora
 * @date 30/09/2020
 */
package com.morapa.convocatoriaNuvu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 30, nullable = false)
	private String apellido;
	
	@Column(name = "tipo_identificacion", length = 2, nullable = false)
	private String tipoIdentificacion;
	
	@Column(name = "num_identificacion", length = 20, nullable = false)
	private String numIdentificacion;
	
	@Column(name = "fecha_nacimiento", nullable = true)
	private Date fechaNacimiento;
	
	@Column(name = "categoria", length = 1, nullable = false)
	private String categoria;
	
	@Column(name = "direccion", length = 100, nullable = true)
	private String direccion;
	
	@Column(name = "celular", length = 20, nullable = true)
	private String celular;
	
	@Column(name = "correo", length = 50, nullable = true)
	private String correo;
	
	@Column(name = "estado_activo", nullable = false)
	private Boolean estadoActivo;

}
