package com.elaine.projeto.atualizacao.model;

public enum TipoAtendimento {

    PILATES("Pilates"),
    PILATES_INDIVIDUAL("Pilates individual"),
    PILATES_KIDS("Pilates Kids"),
    FISIOTERAPIA("Fisioterapia"),
    MASSAGEM("Massagem"),
    AVALIACAO("Avaliação");

    private final String descricao;

    TipoAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
