package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.valhalla.ohwaiter.repository.CategoriasRepository;

@Entity
public class Cardapio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String descItem;
	private double valorItem;
	private String tipoItem;
	private String imgItem;
	CategoriasRepository IDCategoria;
	
	
	
	

	public Cardapio() {}
	public Cardapio(Long iD, CategoriasRepository categoriaItem, String descItem, double valorItem, String tipoItem, String imgItem) {
		
		ID = iD;
		this.IDCategoria = categoriaItem;
		this.descItem = descItem;
		this.valorItem = valorItem;
		this.tipoItem = tipoItem;
		this.imgItem = imgItem;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long codItem) {
		this.ID = codItem;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}

	public double getValorItem() {
		return valorItem;
	}

	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getImgItem() {
		return imgItem;
	}

	public void setImgItem(String imgItem) {
		this.imgItem = imgItem;
	}
	
	
	
	

}
