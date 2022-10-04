package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String nomeCategoria;
	
	

	public Categorias(Long codCategoria, String nomeCategoria) {
		super();
		this.ID = codCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	public Long getID() {
		return ID;
	}

	public void setCodCategoria(Long codCategoria) {
		this.ID = codCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	

}
