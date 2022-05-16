package br.com.projetos.peter.financiasPeter.controller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetos.peter.financiasPeter.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByDsEmail (String dsEmail);
}
