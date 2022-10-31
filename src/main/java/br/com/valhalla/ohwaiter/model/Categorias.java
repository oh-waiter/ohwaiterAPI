package br.com.valhalla.ohwaiter.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
=======

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Data;
@Data
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nomeCategoria;

	@OneToMany(mappedBy = "categoria")
	private List<Cardapio> cardapio = new ArrayList<Cardapio>();
	
	

	public Categorias() {
	}
	

	public Categorias(Long iD, String nomeCategoria) {

		ID = iD;
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
	
	

	public List<Cardapio> getCardapio() {
		return cardapio;
	}


	public void setCardapio(List<Cardapio> cardapio) {
		this.cardapio = cardapio;
	}


	public void setID(Long iD) {
		ID = iD;
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
