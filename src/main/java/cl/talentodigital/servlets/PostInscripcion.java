package cl.talentodigital.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.talentodigital.entidades.InscripcionDTO;
import cl.talentodigital.facade.Facade;


@WebServlet("/postInscripcion")
public class PostInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//capturamos los parametros que vienen del formulario de Inscripcion.jsp
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String idCurso = request.getParameter("idCurso");
		String idFormaPago = request.getParameter("idFormaPago");
		
		//creamos una instancia del InscripcionDTO, para setearle los datos ingresados por el usuario mediante el formulario
		InscripcionDTO inscripcionDTO= new InscripcionDTO();
		inscripcionDTO.setNombre(nombre);
		inscripcionDTO.setCelular(telefono);
		inscripcionDTO.setIdCurso(Integer.parseInt(idCurso));
		inscripcionDTO.setIdFormaDePago(Integer.parseInt(idFormaPago));
		
		//invocamos el facade, para pasarle el objeto InscripcionDTO como parámetro al método registrarInscripcion y de esta manera agregar la inscripcion a la BD
		Facade facade = new Facade();
		
		try {
			facade.registrarInscripcion(inscripcionDTO);
			request.getRequestDispatcher("/preConfirmacion").forward(request,response);
			System.out.println("inscripcion agregada correctamente"+ inscripcionDTO);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
