package com.api.redesocial.entity.usuario;

import com.api.redesocial.entity.amigos.Amizade;
import com.api.redesocial.entity.post.Comentario;
import com.api.redesocial.entity.post.Publicacao;
import com.api.redesocial.requestdto.usuario.CriarPerfilRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String biografia;
    private String foto;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "perfil")
    private List<Publicacao> publicacoes;

    @OneToMany(mappedBy = "perfil")
    private List<Comentario> comentario;
    
    @OneToMany(mappedBy = "perfil")
    private List<Amizade> amigos;

    public Perfil(CriarPerfilRequestDTO data){
        this.nome = data.nome();
        this.biografia = data.biografia();
        this.foto = data.foto();
        this.usuario = data.usuario();
    }
}
