package com.api.redesocial.entity.post;

import com.api.redesocial.entity.usuario.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "share")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private boolean compartilhar;
    @Column(name = "legenda_compartilhacao")
    private String legendaCompartilhacao;

    @Column(name = "imagem_compartilhacao")
    private String imagemCompartilhacao;

    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private Comentario comentario;

}
