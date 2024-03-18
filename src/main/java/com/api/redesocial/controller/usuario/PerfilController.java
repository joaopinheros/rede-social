package com.api.redesocial.controller.usuario;

import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.service.usuario.PerfilService;
import com.api.redesocial.repository.PerfilRepository;
import com.api.redesocial.requestdto.usuario.CriarPerfilRequestDTO;
import com.api.redesocial.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    PerfilService perfilService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Perfil> registrarUsuario(@RequestBody @Valid CriarPerfilRequestDTO data){
        Perfil perfil = perfilService.criarNovoUsuario(data.nome(), data.biografia(), data.foto(),
                data.usuario().getLogin(), data.usuario().getSenha(), data.usuario().getRole());
        return ResponseEntity.ok(perfil);

    }
}
