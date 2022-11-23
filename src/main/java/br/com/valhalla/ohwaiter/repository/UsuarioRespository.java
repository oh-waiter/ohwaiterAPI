package br.com.valhalla.ohwaiter.repository;

import br.com.valhalla.ohwaiter.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, String> {
}
