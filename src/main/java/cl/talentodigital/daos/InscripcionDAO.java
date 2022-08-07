package cl.talentodigital.daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.talentodigital.entidades.InscripcionDTO;

public class InscripcionDAO {
	
	public void insertarInscripcion(InscripcionDTO dto) throws ClassNotFoundException, SQLException {
		
		//insert sql oracle
		String insertInscripcionSql = "INSERT INTO inscripcion(id_inscripcion, nombre, telefono, id_curso, id_forma_pago) "
				+ "VALUES (inscripcion_sec.NEXTVAL, ?,?,?,?)";
		
		
		//conexion a la bd
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =null;
		String url ="jdbc:oracle:thin:@//localhost:1521/ORCL";
		//getConnection(url,"nombre de usuario","contraseña")
		con=DriverManager.getConnection(url,"ADMIN_INSCRIPCION","1234");
		
		try {
			//setea los valores del parametro de entrada de tipo InscripcionDTO, en mi insert (insertInscripcionSql)
			PreparedStatement ps= con.prepareStatement(insertInscripcionSql);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getCelular());
			ps.setInt(3, dto.getIdCurso());
			ps.setInt(4, dto.getIdFormaDePago());
			//ejecuta el insert llenando con los valores el registro en la tabla de la BD
			if(ps.executeUpdate()!=1) {
				System.out.println("Error al insertar inscripción");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<InscripcionDTO> obtieneInscripciones() throws ClassNotFoundException, SQLException{
		ArrayList<InscripcionDTO> inscripciones = new ArrayList<InscripcionDTO>();
		
		//crear consulta a la bd
		String consultaSql= "select id_inscripcion, nombre, telefono, id_curso, id_forma_pago from inscripcion order by id_inscripcion";
		
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
				InscripcionDTO inscripcion= new InscripcionDTO();
				inscripcion.setIdInsc(resultado.getInt("id_inscripcion"));
				inscripcion.setNombre(resultado.getString("nombre"));
				inscripcion.setCelular(resultado.getString("telefono"));
				inscripcion.setIdCurso(resultado.getInt("id_curso"));
				inscripcion.setIdFormaDePago(resultado.getInt("id_curso"));
				inscripciones.add(inscripcion);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return inscripciones;
	}
	
	
}
