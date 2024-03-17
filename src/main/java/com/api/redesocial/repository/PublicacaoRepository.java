package com.api.redesocial.repository;

import com.api.redesocial.entity.post.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublicacaoRepository extends JpaRepository<Publicacao, UUID> {
}
