package br.com.valhalla.ohwaiter.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column(name="Categorias", nullable = false, length = 15)
	private String nomeCategoria;
	
	

	public Categorias() {
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

	@Override
	public int hashCode() {
		return Objects.hash(ID, nomeCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorias other = (Categorias) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(nomeCategoria, other.nomeCategoria);
	}
	
	
	
	

}
