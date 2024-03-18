package com.api.redesocial.service.usuario;

import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.entity.usuario.Roles;
import com.api.redesocial.entity.usuario.Usuario;
import com.api.redesocial.repository.PerfilRepository;
import com.api.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Perfil criarNovoUsuario(String nome, String biografia, String foto, String login, String senha, Roles role){
        Usuario usuario = new Usuario(login, senha, role);
        usuario = usuarioRepository.save(usuario);

        Perfil novoPerfil = new Perfil();
        novoPerfil.setNome(nome);
        novoPerfil.setBiografia(biografia);
        novoPerfil.setFoto(foto);
        novoPerfil.setUsuario(usuario);

        // Salva a pessoa no banco de dados
        return perfilRepository.save(novoPerfil);
    }
}
