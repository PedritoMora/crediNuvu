package com.morapa.convocatoriaNuvu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morapa.convocatoriaNuvu.model.Usuario;
import com.morapa.convocatoriaNuvu.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		Long id = usuario.getId();
		if(null != id && usuarioRepository.existsById(id)) {
			throw new RuntimeException("Ya existe un usuario con el id " + id +".");
		}
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarUsuario(Long idUsuario) {
		
		Optional<Usuario> opUsuarios = usuarioRepository.findById(idUsuario);
		if(!opUsuarios.isPresent()) {
			throw new RuntimeException("No existe ningún usuario con el id "+ idUsuario + "."); 
		}
		
		return opUsuarios.get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		
		Long idUsuario = usuario.getId();
		Optional<Usuario> opUsuarios = usuarioRepository.findById(idUsuario);
		if(!opUsuarios.isPresent()) {
			throw new RuntimeException("No existe ningún usuario con el id "+ idUsuario + "."); 
		} 
		
		return usuarioRepository.save(usuario);
	}

}
