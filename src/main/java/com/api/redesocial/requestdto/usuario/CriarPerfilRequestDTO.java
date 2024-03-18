package com.api.redesocial.requestdto.usuario;

import com.api.redesocial.entity.usuario.Usuario;

public record CriarPerfilRequestDTO(String nome, String biografia, String foto, Usuario usuario) {
}
