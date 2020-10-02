package com.morapa.convocatoriaNuvu.service;

import java.util.List;

import com.morapa.convocatoriaNuvu.model.Usuario;

public interface UsuarioService {

	Usuario buscarUsuario(String login, String pass) throws Exception;

	List<Usuario> listarUsuarios();
	
	Usuario actualizarToken(Usuario usuario);
	
}
