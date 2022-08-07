package cl.talentodigital.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.talentodigital.entidades.CursoDTO;

public class CursoDAO {

	//método para obtener listado de cursos disponibles (los que están en la tabla curso)
	public ArrayList<CursoDTO> obtieneCursos() throws ClassNotFoundException, SQLException{
		//declaracion lista que retornará los resultados
		ArrayList<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		//crear consulta a la bd
		String consultaSql= "select id_curso, descripcion, precio from curso";
		
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
				//creamos una instancia de CursoDTO para llenar con elregistro traido de la BD
				CursoDTO curso= new CursoDTO();
				curso.setIdCurso(resultado.getInt("id_curso"));
				curso.setDescripcion(resultado.getString("descripcion"));
				curso.setPrecio(resultado.getDouble("precio"));
				
				//una vez seteados los campos en el objeto, lo agregamos a la lista
				cursos.add(curso);
			}		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cursos;	
	}
	
}
