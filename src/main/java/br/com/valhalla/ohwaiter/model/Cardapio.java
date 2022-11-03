package br.com.valhalla.ohwaiter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "Item", nullable = false, length = 60)
	private String descItem;
	@Column(name = "Valor", nullable = false, length = 6)
	private double valorItem;
	@Column(name = "Imagem", nullable = false, length = 50)
	private String imgItem;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categorias categoria;

	

}
