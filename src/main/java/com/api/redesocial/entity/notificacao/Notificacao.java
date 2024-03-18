package com.api.redesocial.entity.notificacao;

import com.api.redesocial.entity.post.Comentario;
import com.api.redesocial.entity.post.Like;
import com.api.redesocial.entity.post.Publicacao;
import com.api.redesocial.entity.post.Share;
import com.api.redesocial.entity.usuario.Perfil;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Mensagem tipo "fulano curtiu sua publicacao"
    private String mensagem;

    //Tipo do comentario, fiquei pensando que nao teria como informar qual ação foi realizada
    //pois sempre teriamos que informar o comentario, a curtida e o compartilhamento.
    // se voce achar uma solução pode trocar essa funcionalidade!!
    @Enumerated
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;

    //Atributo para informar se leu ou nao
    private boolean lida;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private Comentario comentario;

    @ManyToOne
    @JoinColumn(name = "like_id")
    private Like like;

    @ManyToOne
    @JoinColumn(name = "share_id")
    private Share compartilhamento;



}
