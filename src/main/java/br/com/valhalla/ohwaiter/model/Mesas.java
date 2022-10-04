package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class Mesas {
	@Positive(message = "A quantidade deve ser maior que zero!")
	private int qtdCadeiras;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private Boolean dispoMesa;
	
	
	
	public Mesas(int qtdCadeiras, Long ID, Boolean dispoMesa) {
		this.qtdCadeiras = qtdCadeiras;
		this.ID = ID;
		this.dispoMesa = dispoMesa;
	}
	public int getQtdCadeiras() {
		return qtdCadeiras;
	}
	public void setQtdCadeiras(int qtdCadeiras) {
		this.qtdCadeiras = qtdCadeiras;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long ID) {
		this.ID = ID;
	}
	public Boolean getDispoMesa() {
		return dispoMesa;
	}
	public void setDispoMesa(Boolean dispoMesa) {
		this.dispoMesa = dispoMesa;
	}
	
	public Boolean DisponibilidadeMesa(Boolean dispoMesa) {
		if (dispoMesa = true) {
			return false;
		}else {
			return false;
		}
		
		
	}
	
	
	

}
