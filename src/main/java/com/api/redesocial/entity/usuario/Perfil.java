package com.api.redesocial.entity.usuario;

import com.api.redesocial.entity.post.Publicacao;
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
    private List<Publicacao> comentario;
}
