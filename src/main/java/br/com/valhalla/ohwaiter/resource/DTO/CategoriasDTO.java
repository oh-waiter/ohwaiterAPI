package br.com.valhalla.ohwaiter.resource.DTO;

import java.io.Serializable;

import br.com.valhalla.ohwaiter.model.Categorias;

public class CategoriasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long ID;
	private String nomeCategoria;
	
	public CategoriasDTO() {}

	public CategoriasDTO(Categorias obj) {
		super();
		ID = obj.getID();
		this.nomeCategoria=obj.getNomeCategoria();
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
	
	
	
	

}
