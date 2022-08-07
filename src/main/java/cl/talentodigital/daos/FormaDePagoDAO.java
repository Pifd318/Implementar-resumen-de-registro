package cl.talentodigital.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.talentodigital.entidades.FormaDePagoDTO;

public class FormaDePagoDAO {
	
	public ArrayList<FormaDePagoDTO> obtieneFormasDePago() throws ClassNotFoundException, SQLException{
		
		//declarar lista que contiene las formas de pago
		ArrayList<FormaDePagoDTO> listaFormasPago = new ArrayList<FormaDePagoDTO>();
		
		//crear consulta a la bd
		String consultaSql= "select id_forma_pago, descripcion, recargo from forma_pago";
				
		//conexion a la bd
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =null;
		String url ="jdbc:oracle:thin:@//localhost:1521/ORCL";
		//getConnection(url,"nombre de usuario","contraseña")
		con=DriverManager.getConnection(url,"ADMIN_INSCRIPCION","1234");
		
		try {
			PreparedStatement ps = con.prepareStatement(consultaSql);//preparando la consulta (select)
			ResultSet resultado = ps.executeQuery();// acá ya se ejecutó el select y está guardando el resultado
			
			while(resultado.next()) {
				//creamos una instancia de FormaDePagoDTO para llenar con el registro traido de la BD
				FormaDePagoDTO formaDePago = new FormaDePagoDTO();
				formaDePago.setIdFormaDePago(resultado.getInt("id_forma_pago"));
				formaDePago.setDescripcion(resultado.getString("descripcion"));
				formaDePago.setRecargo(resultado.getString("recargo"));
				listaFormasPago.add(formaDePago);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaFormasPago;
	}

}
