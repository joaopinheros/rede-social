package com.api.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<ComentarioRepository, UUID> {
}
