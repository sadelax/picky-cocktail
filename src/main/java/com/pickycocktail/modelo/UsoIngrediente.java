package com.pickycocktail.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uso_ingrediente")
public class UsoIngrediente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_uso")
	private int idUso;
	
	@Column(name = "nombre")
	private String descripcion;

	
	public int getIdUso() {
		return idUso;
	}

	public void setIdUso(int idUso) {
		this.idUso = idUso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idUso);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsoIngrediente other = (UsoIngrediente) obj;
		return Objects.equals(descripcion, other.descripcion) && idUso == other.idUso;
	}
}
