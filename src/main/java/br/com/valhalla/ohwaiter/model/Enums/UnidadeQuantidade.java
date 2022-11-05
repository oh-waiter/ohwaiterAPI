package br.com.valhalla.ohwaiter.model.Enums;

public enum UnidadeQuantidade {
    CAIXA("Caixa"), CENTO("Cento"), KILOGRAMA("Kilograma"), PACOTE("Pacote"), PECA("Peça"), LT("Litro");

    private String descricao = null;

    UnidadeQuantidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static UnidadeQuantidade getEnum(String quantidade) {
        if (quantidade.equals("Caixa")) {
            return CAIXA;
        } else if (quantidade.equals("Cento")) {
            return CENTO;
        } else if (quantidade.equals("Kilograma")) {
            return KILOGRAMA;
        } else if (quantidade.equals("Pacote")) {
            return PACOTE;
        } else if (quantidade.equals("Litro")) {
            return LT;
        }
        return PECA;
    }
}
