package com.api.redesocial.repository;

import com.api.redesocial.entity.post.Share;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShareRepository extends JpaRepository<Share, UUID> {
}
