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
	protected int trackId;
	
	@Column
	protected String name;
	
	@Column
	protected String detalle;

	public int gettrackId() {
		return trackId;
	}

	public void settrackId(int trackId) {
		this.trackId = trackId;
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
		return "Track [trackId=" + trackId + ", name=" + name + ", detalle=" + detalle + "]";
	}

	public Track(int trackId, String name, String detalle) {
		super();
		this.trackId = trackId;
		this.name = name;
		this.detalle = detalle;
	}
	
	public Track(){
		
	}
	
}
