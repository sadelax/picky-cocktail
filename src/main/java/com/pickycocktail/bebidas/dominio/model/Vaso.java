package com.pickycocktail.bebidas.dominio.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vasos")
public class Vaso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vaso")
	private int idVaso;
	
	private String nombre;
	
	@OneToMany(mappedBy = "vaso")
	private Set<Bebida> bebidas;

	
	public int getIdVaso() {
		return idVaso;
	}

	public void setIdVaso(int idVaso) {
		this.idVaso = idVaso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idVaso, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaso other = (Vaso) obj;
		return idVaso == other.idVaso && Objects.equals(nombre, other.nombre);
	}
}
