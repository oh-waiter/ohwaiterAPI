package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name="Item", nullable = false, length = 30)
	private String descItem;
	@Column(name="Valor", nullable = false, length = 6)
	private double valorItem;
	@Column(name="Imagem", nullable = false, length = 50)
	private String imgItem;
	@ManyToOne
	@JoinColumn(name= "categoria_id")
	private Categorias categoria;
	
	public Cardapio() {}
	
	public Cardapio(Long iD, String descItem, double valorItem, String imgItem, Categorias categoria) {
		ID = iD;
		this.descItem = descItem;
		this.valorItem = valorItem;
		this.imgItem = imgItem;
		this.categoria = categoria;
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

	public String getImgItem() {
		return imgItem;
	}

	public void setImgItem(String imgItem) {
		this.imgItem = imgItem;
	}

	public Categorias getCategoria() {
		return categoria;
	}



	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}



	@Override
	public int hashCode() {
		return Objects.hash(ID);
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
		return Objects.equals(ID, other.ID);
	}

	

	
	
	

	
	
	
	
	


	@Column(name = "descricao", nullable = false, length = 60)
	private String descricao;
	@Column(name = "valor", nullable = false, length = 6)
	private BigDecimal valor;
	@Column(name = "imagem", nullable = false)
	private String imagem;
	@Column(name = "Categoria", nullable = false, length = 4)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Categorias> IDCategoria;

}
