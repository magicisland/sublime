package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int productId;
	
	@Column
	protected String name;
	
	@Column
	protected String detalle;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "Track [productId=" + productId + ", name=" + name + ", detalle=" + detalle + "]";
	}

	public Track(int productId, String name, String detalle) {
		super();
		this.productId = productId;
		this.name = name;
		this.detalle = detalle;
	}
	
	public Track(){
		
	}
	
}
