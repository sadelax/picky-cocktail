package com.sadelax.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preparaciones")
public class Preparacion {

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idPreparacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preparacion other = (Preparacion) obj;
		return Objects.equals(descripcion, other.descripcion) && idPreparacion == other.idPreparacion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_preparacion")
	private int idPreparacion;
	
	private String descripcion;

	public int getIdPreparacion() {
		return idPreparacion;
	}

	public void setIdPreparacion(int idPreparacion) {
		this.idPreparacion = idPreparacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
