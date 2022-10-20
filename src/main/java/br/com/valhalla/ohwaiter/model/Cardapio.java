package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
