package br.com.valhalla.ohwaiter.model.Enums;

public enum Funcao {
    GARCOM("Garçom"), COORDENADOR("Coordenador"), COZINHEIRO("Cozinheiro");

    private String descricao = null;

    Funcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Funcao getEnum(String funcao) {
        if (funcao.equals("GARCOM")) {
            return GARCOM;
        } else if (funcao.equals("COORDENADOR")) {
            return COORDENADOR;
        }
        return COZINHEIRO;
    }
}
