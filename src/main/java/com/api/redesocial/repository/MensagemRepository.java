package com.api.redesocial.repository;

import com.api.redesocial.entity.mensagem.Mensagem;
import com.api.redesocial.entity.usuario.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    List<Mensagem> findByRemetenteIdAndDestinatarioIdOrderByDataEnvio(UUID remetenteId, UUID destinatarioId);
}
