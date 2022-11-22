package br.com.valhalla.ohwaiter.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mesas {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column(name="QTD_Cadeiras", nullable = false, length = 2)
	private int qtdCadeiras;
	@Column(name="Disp_Mesa", nullable = false, length = 5)
	private Boolean dispoMesa;
	
	
	
	
	public Mesas() {} 
	
	
	
	public Mesas(Long iD, int qtdCadeiras, Boolean dispoMesa) {
		super();
		ID = iD;
		this.qtdCadeiras = qtdCadeiras;
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

	@Override
	public int hashCode() {
		return Objects.hash(ID, dispoMesa, qtdCadeiras);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesas other = (Mesas) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(dispoMesa, other.dispoMesa)
				&& qtdCadeiras == other.qtdCadeiras;
	}
	
	
	
	
	

}
