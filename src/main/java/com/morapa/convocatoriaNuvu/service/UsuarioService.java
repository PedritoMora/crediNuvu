package com.morapa.convocatoriaNuvu.service;

import java.util.List;

import com.morapa.convocatoriaNuvu.model.Usuario;

public interface UsuarioService {
	
	Usuario guardarUsuario(Usuario usuario);
		
	List<Usuario> listarUsuarios();
	
	Usuario buscarUsuario(Long idUsuario);
	
	Usuario actualizarUsuario(Usuario usuario);
	
}
