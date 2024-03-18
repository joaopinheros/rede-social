package com.api.redesocial.repository;

import com.api.redesocial.entity.amigos.Amizade;
import com.api.redesocial.entity.usuario.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    Amizade findByRemetenteAndDestinatario(Perfil remetente, Perfil destinatario);
}
