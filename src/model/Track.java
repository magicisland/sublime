package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Track {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;
	
	@Column
	
	protected String name;
	
	@Column
	protected String detalle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	
	public Track(int id, String name, String detalle) {
		super();
		this.id = id;
		this.name = name;
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", name=" + name + ", detalle=" + detalle + "]";
	}

	public Track(){
		
	}
	
}
