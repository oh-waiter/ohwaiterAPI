package br.com.valhalla.ohwaiter.model.Enums;

public enum UnidadeQuantidade {
    CAIXA("CX"), CENTO("CENTO"), KILOGRAMA("KG"), PACOTE("PACOTE"), PECA("PC"), LT("LT");

    private String descricao = null;

    UnidadeQuantidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
