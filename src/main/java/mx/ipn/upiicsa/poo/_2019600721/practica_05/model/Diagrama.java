package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.util.Date;
import java.util.List;

public class Diagrama {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Date creacion;
	private Date actualizacion;
	private String json;
	private List<Figura> figuras;

	public Diagrama(Integer id, String nombre, String descripcion, Date creacion, Date actualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.creacion = creacion;
		this.actualizacion = actualizacion;
	}

	public Diagrama(Integer id, String nombre, String descripcion, Date creacion, Date actualizacion, String json) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.creacion = creacion;
		this.actualizacion = actualizacion;
		this.json = json;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getCreacion() {
		return creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public Date getActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(Date actualizacion) {
		this.actualizacion = actualizacion;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(List<Figura> figuras) {
		this.figuras = figuras;
	}

}
