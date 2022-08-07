package cl.talentodigital.entidades;

public class CursoDTO {
	//son los mismos atributos que estan en la tabla curso
	private int idCurso;
	private String descripcion;
	private double precio;
	
	
	//constructor sin parametros
	public CursoDTO() {
		
	}
    //constructor con parametros esto no es necesario
	public CursoDTO(int idCurso, String descripcion, double precio) {
		super();
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.precio = precio;
	}
     // getters y setters
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
     // to String no es necesario
	
	
	

}
