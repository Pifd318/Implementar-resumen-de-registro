package cl.talentodigital.entidades;

public class FormaDePagoDTO {
   //son los atributos que estan en la tabla forma de pago
	private int idFormaDePago;
	private String descripcion;
	private String recargo;
	
	//constructor sin parametros
	public FormaDePagoDTO() {
		
	}

      //getters y setters
	public int getIdFormaDePago() {
		return idFormaDePago;
	}


	public void setIdFormaDePago(int idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getRecargo() {
		return recargo;
	}


	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}
	
	
	
}
