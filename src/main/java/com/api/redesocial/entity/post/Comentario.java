package com.api.redesocial.entity.post;

import com.api.redesocial.entity.usuario.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String legendaComentario;
    private String imagemComentario;
    private LocalDateTime dataComentario;

    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @OneToMany(mappedBy = "comentario")
    private List<Share> shares;

    @OneToMany(mappedBy = "comentario")
    private List<Like> likes;

}
