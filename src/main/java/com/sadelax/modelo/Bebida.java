package com.sadelax.modelo;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bebidas")
public class Bebida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bebida")
	private int idBebida;
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_ingrediente_principal")
	private Ingrediente principal;
	
	@ManyToOne
	@JoinColumn(name = "id_vaso")
	private Vaso vaso;
	
	@ManyToOne
	@JoinColumn(name = "id_preparacion")
	private Preparacion preparacion;
	
	private String tags;
	
	@Column(name = "included")
	private boolean popular;
	
	@OneToMany(mappedBy = "ingrediente")
	private Set<CantidadPorBebida> ingredientes;

	
	public int getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ingrediente getPrincipal() {
		return principal;
	}

	public void setPrincipal(Ingrediente principal) {
		this.principal = principal;
	}

	public Vaso getVaso() {
		return vaso;
	}

	public void setVaso(Vaso vaso) {
		this.vaso = vaso;
	}

	public Preparacion getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(Preparacion preparacion) {
		this.preparacion = preparacion;
	}

//	public Set<CantidadPorBebida> getIngredientes() {
//		return ingredientes;
//	}
//
//	public void setIngredientes(Set<CantidadPorBebida> ingredientes) {
//		this.ingredientes = ingredientes;
//	}
	
	public String getTag() {
		return tags;
	}

	public void setTag(String tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idBebida, nombre, preparacion, principal, vaso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		return Objects.equals(descripcion, other.descripcion) && idBebida == other.idBebida
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(preparacion, other.preparacion) && Objects.equals(principal, other.principal)
				&& Objects.equals(vaso, other.vaso);
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Bebida {");
	    sb.append("\n  Nombre: ").append(nombre);
	    sb.append("\n  Ingrediente principal: ").append(principal.getNombre());
	    sb.append("\n  Vaso: ").append(vaso.getNombre());
	    sb.append("\n  Preparacion: ").append(preparacion.getDescripcion());
	    sb.append("\n}");
	    return sb.toString();
	}
	
	
	
	
}
