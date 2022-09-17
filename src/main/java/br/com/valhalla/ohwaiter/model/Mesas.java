package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mesas {
	private int qtdCadeiras;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numMesa;
	private Boolean dispoMesa;
	
	
	
	public Mesas(int qtdCadeiras, int numMesa, Boolean dispoMesa) {
		super();
		this.qtdCadeiras = qtdCadeiras;
		this.numMesa = numMesa;
		this.dispoMesa = dispoMesa;
	}
	public int getQtdCadeiras() {
		return qtdCadeiras;
	}
	public void setQtdCadeiras(int qtdCadeiras) {
		this.qtdCadeiras = qtdCadeiras;
	}
	public int getNumMesa() {
		return numMesa;
	}
	public void setNumMesas(int numMesas) {
		this.numMesa = numMesas;
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
