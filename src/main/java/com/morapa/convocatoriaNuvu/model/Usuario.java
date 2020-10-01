package com.morapa.convocatoriaNuvu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nombre_completo", length = 60, nullable = false)
	private String nombreCompleto;
	
	@Column(name = "login_name", length = 20, nullable = false)
	private String loginName;
	
	@Column(name = "contrasenia", length = 20, nullable = false)
	private String contrasenia;
	
	@Column(name = "token", length = 500, nullable = true)
	private String token;
	
}
