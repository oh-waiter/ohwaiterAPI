package br.com.valhalla.ohwaiter.model.Enums;

public enum CategoriaProduto {
    INGREDIENTE("Ingrediente"), UTILITARIO("Utilitario"), BEBIDA("Bebida");

    private String descricao = null;

    CategoriaProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CategoriaProduto getEnum(String categoria) {
        if (categoria.equals("Ingrediente")) {
            return INGREDIENTE;
        } else if (categoria.equals("Utilitario")) {
            return UTILITARIO;
        }
        return BEBIDA;
    }
}
