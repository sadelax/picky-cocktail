package com.pickycocktail.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes_por_bebida")
@IdClass(CantidadPorBebidaPK.class)
public class CantidadPorBebida {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_bebida")
	private Bebida bebida;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_ingrediente")
	private Ingrediente ingrediente;
	
	@ManyToOne
	@JoinColumn(name = "id_uso")
	private UsoIngrediente uso;
	
	private double cantidad;
	
	@Column(name = "cantidad_string")
	private String unidad;

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public UsoIngrediente getUso() {
		return uso;
	}

	public void setUso(UsoIngrediente uso) {
		this.uso = uso;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bebida, cantidad, ingrediente, unidad, uso);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CantidadPorBebida other = (CantidadPorBebida) obj;
		return Objects.equals(bebida, other.bebida)
				&& Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Objects.equals(ingrediente, other.ingrediente) && Objects.equals(unidad, other.unidad)
				&& Objects.equals(uso, other.uso);
	}
}
