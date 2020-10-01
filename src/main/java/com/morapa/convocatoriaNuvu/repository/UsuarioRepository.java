package com.morapa.convocatoriaNuvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morapa.convocatoriaNuvu.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByLoginName(String loginName);
	
}
