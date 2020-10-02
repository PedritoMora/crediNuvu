package com.morapa.convocatoriaNuvu.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morapa.convocatoriaNuvu.model.Usuario;
import com.morapa.convocatoriaNuvu.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("login")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> getUsers(){
		return usuarioService.listarUsuarios();
	}
	
	@PostMapping
	public String obtenerToken(@RequestParam("usuario") String username, @RequestParam("klav3") String klav3) {
		
		Usuario usuario = null;
		try {
			usuario = usuarioService.buscarUsuario(username, klav3);
			
			if(null != usuario) {
				if(!usuario.getContrasenia().equals(klav3)) {
					return "El usuario '"+ username + "' tiene otra contraseña";
				} else {
				
					String token = getJwtToken(username);
					usuario.setToken(token);
					usuarioService.actualizarToken(usuario);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		return usuario.getToken();
	}
	
	private String getJwtToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000*5))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
}
