package br.com.valhalla.ohwaiter.model.Enums;

public enum CategoriaProduto {
    INGREDIENTE("Ingrediente"), UTILITARIO("Utilitario"), BEBIDA("Bebida");

    private String descricao = null;

    CategoriaProduto(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
