package com.Merces.cadastro_usuario.repository;

import com.Merces.cadastro_usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

}
