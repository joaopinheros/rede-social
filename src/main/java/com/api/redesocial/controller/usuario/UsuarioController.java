package com.api.redesocial.controller.usuario;

import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.entity.usuario.Usuario;
import com.api.redesocial.repository.PerfilRepository;
import com.api.redesocial.requestdto.usuario.LoginRequestDTO;
import com.api.redesocial.responsedto.usuario.PerfilResponseDTO;
import com.api.redesocial.responsedto.usuario.TokenResponseDTO;
import com.api.redesocial.security.TokenService;
import com.api.redesocial.service.usuario.PerfilService;
import com.api.redesocial.requestdto.usuario.CriarPerfilRequestDTO;
import com.api.redesocial.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private PerfilService perfilService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;


    // CADASTRAR UM NOVO USUARIO
    @PostMapping("/cadastrar")
    public ResponseEntity<Perfil> registrarUsuario(@RequestBody @Valid CriarPerfilRequestDTO data) {
        if(this.usuarioRepository.findByLogin(data.usuario().getLogin()) != null){
            return ResponseEntity.badRequest().build();
        }
        // Codificando senha para segurança no banco de dados;
        String senhaCriptografada = new BCryptPasswordEncoder().encode(data.usuario().getSenha());
        data.usuario().setSenha(senhaCriptografada);

        Perfil perfil = perfilService.criarNovoUsuario(data.nome(), data.biografia(), data.foto(),
                data.usuario().getLogin(), senhaCriptografada, data.usuario().getRole());
        return ResponseEntity.ok(perfil);

    }

    // ENTRAR COMO USUARIO
    @PostMapping("/login")
    public ResponseEntity<?> entrarComoUsuario(@RequestBody @Valid LoginRequestDTO data) {
        var loginUsuario = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var autenticacao = authenticationManager.authenticate(loginUsuario);
        var token = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }

    // DELETAR PERFIL COMPLETO
    @DeleteMapping("/excluir-conta/{id}")
    public ResponseEntity<Void> DeletarUsuario(@PathVariable UUID id){
        Optional<Perfil> optionalPerfil = perfilRepository.findById(id);
        if (optionalPerfil.isPresent()){
            perfilRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //FUNÇÃO PARA BUSCAR AMIGO PELO NOME DE USUARIO
    @GetMapping("/perfil/{login}")
    public ResponseEntity<Perfil> listarPerfil(@PathVariable String login){
        Optional<Perfil> optionalUsuario = perfilRepository.findByUsuarioLogin(login);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    // LISTAR TODOS OS PERFIS (APENAS PARA FACILITAR OS TESTES)
    @GetMapping
    public List<PerfilResponseDTO> listarTodosOsPerfis(){
        return perfilRepository.findAll()
                .stream()
                .map(PerfilResponseDTO::new)
                .collect(Collectors.toList());
    }


}

