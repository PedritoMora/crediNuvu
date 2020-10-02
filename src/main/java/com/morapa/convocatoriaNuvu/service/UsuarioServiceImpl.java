package com.morapa.convocatoriaNuvu.service;

import java.util.ArrayList;
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
	public Usuario buscarUsuario(String login, String pass) throws Exception {
		List<Usuario> usuarioList = new ArrayList<>();
		
		usuarioList = usuarioRepository.findByLoginName(login);
		
		if(usuarioList.size() == 0) {
			throw new Exception("No existe un usuario con el login "+login+".");
		}
		
		return usuarioList.get(0);
				
	}
	
	@Override
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return  usuarios;
	}

	@Override
	public Usuario actualizarToken(Usuario usuario) {
		Long id = usuario.getId();
		
		if(!usuarioRepository.existsById(id)) {
			throw new RuntimeException("El usuario con id "+ id + " no existe.");
		}
		
		return usuarioRepository.save(usuario);
	}

}
