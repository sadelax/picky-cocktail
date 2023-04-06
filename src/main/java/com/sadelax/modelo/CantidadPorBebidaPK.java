package com.sadelax.modelo;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class CantidadPorBebidaPK implements Serializable {

	private Integer bebida;
	
	private Integer ingrediente;

	public Integer getBebida() {
		return bebida;
	}

	public void setBebida(Integer bebida) {
		this.bebida = bebida;
	}

	public Integer getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Integer ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bebida, ingrediente);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CantidadPorBebidaPK other = (CantidadPorBebidaPK) obj;
		return Objects.equals(bebida, other.bebida) && Objects.equals(ingrediente, other.ingrediente);
	}
	
}
