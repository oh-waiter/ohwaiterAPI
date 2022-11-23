package br.com.valhalla.ohwaiter.model.Enums;

public enum Status {
    FINALIZADO("Finalizado"), ABERTO("Aberto"), CANCELADO("Cancelado"), PREPARANDO("Preparando");

    private String descricao = null;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status getEnum(String status) {
        if (status.equals("FINALIZADO")) {
            return FINALIZADO;
        } else if (status.equals("ABERTO")) {
            return ABERTO;
        } else if (status.equals("PREPARANDO")) {
            return PREPARANDO;
        }
        return CANCELADO;
    }
}
