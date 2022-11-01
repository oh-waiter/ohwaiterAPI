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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "Item", nullable = false, length = 30)
	private String descItem;
	@Column(name = "Valor", nullable = false, length = 6)
	private double valorItem;
	@Column(name = "Imagem", nullable = false, length = 50)
	private String imgItem;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categorias categoria;
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
