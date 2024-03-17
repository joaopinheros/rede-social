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
@Table(name = "publicacao")
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String legendaPublicacao;
    private String imagemPublicacao;
    private LocalDateTime dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @OneToMany(mappedBy = "share")
    private List<Share> shares;

    @OneToMany(mappedBy = "like")
    private List<Like> likes;
}
