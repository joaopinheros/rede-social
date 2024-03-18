package com.api.redesocial.entity.mensagem;

import com.api.redesocial.entity.usuario.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String conteudo;
    private String emogi;
    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;
    private boolean lida;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Perfil remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Perfil destinatario;

}
