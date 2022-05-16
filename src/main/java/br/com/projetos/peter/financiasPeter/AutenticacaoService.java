package br.com.projetos.peter.financiasPeter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.projetos.peter.financiasPeter.controller.repository.UsuarioRepository;
import br.com.projetos.peter.financiasPeter.modelo.Usuario;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	public UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByDsEmail(username);
		if ( usuario.isPresent() ) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos"); 
	}
}
