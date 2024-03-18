package com.api.redesocial.entity.notificacao;

public enum TipoEvento {
    COMENTARIO("Comentário"),
    CURTIDA("Curtida"),
    COMPARTILHAMENTO("Compartilhamento"),
    AMIZADE("amizade");

    private String descricao;

    TipoEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
