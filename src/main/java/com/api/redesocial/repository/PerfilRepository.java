package com.api.redesocial.repository;

import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PerfilRepository extends JpaRepository<Perfil, UUID> {

    @Query("SELECT p FROM Perfil p WHERE p.usuario.login = :login")
    Optional<Perfil> findByUsuarioLogin(@Param("login") String login);
}
