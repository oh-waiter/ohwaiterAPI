package br.com.valhalla.ohwaiter.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cardapio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column(name="Item", nullable = false, length = 30)
	private String descItem;
	@Column(name="Valor", nullable = false, length = 6)
	private double valorItem;
	@Column(name="Tipo_item", nullable = false, length = 20)
	private String tipoItem;
	@Column(name="Imagem", nullable = false, length = 50)
	private String imgItem;
	@Column(name="Categoria", nullable = false, length = 4)
	private Categorias IDCategoria;
	
	public Cardapio() {}

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

	public Categorias getIDCategoria() {
		return IDCategoria;
	}

	public void setIDCategoria(Categorias iDCategoria) {
		IDCategoria = iDCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, IDCategoria, descItem, imgItem, tipoItem, valorItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardapio other = (Cardapio) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(IDCategoria, other.IDCategoria)
				&& Objects.equals(descItem, other.descItem) && Objects.equals(imgItem, other.imgItem)
				&& Objects.equals(tipoItem, other.tipoItem)
				&& Double.doubleToLongBits(valorItem) == Double.doubleToLongBits(other.valorItem);
	}
	
	

	
	
	
	
	

}
