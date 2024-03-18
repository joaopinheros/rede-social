package com.api.redesocial.entity.amigos;

import com.api.redesocial.entity.usuario.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "amizade")
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "somos_amigos")
    private boolean somosAmigos;
    private boolean aceita;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Perfil remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Perfil destinatario;


}
