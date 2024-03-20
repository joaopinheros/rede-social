package com.api.redesocial.responsedto.usuario;

import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.entity.usuario.Usuario;

import java.util.UUID;

public record PerfilResponseDTO(UUID id, String nome, String biografia, String foto, Usuario usuario) {

        public PerfilResponseDTO(Perfil perfil){
            this(
                    perfil.getId(),
                    perfil.getNome(),
                    perfil.getBiografia(),
                    perfil.getFoto(),
                    perfil.getUsuario());
        }
}
