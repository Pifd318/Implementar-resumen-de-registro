package cl.talentodigital.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.talentodigital.entidades.InscripcionDTO;


@WebServlet("/preConfirmacion")
public class PreConfirmacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//capturo los parámetros ingresados a los input del formulario,
		String nombre= request.getParameter("nombre");
		String telefono= request.getParameter("telefono");
		String idCurso= request.getParameter("idCurso");
		String idFormaPago= request.getParameter("idFormaPago");	
		
		
		//vamos a setear atributos y enviarlos mediante el request hacia la pagina confirmacion jsp
		request.setAttribute("nombreAtt", nombre);
		request.setAttribute("telefonoAtt", telefono);
		request.setAttribute("idCursoAtt", idCurso);
		request.setAttribute("idFormaPagoAtt", idFormaPago);
		
		
		request.getRequestDispatcher("Confirmacion.jsp").forward(request, response);
		
		
		
	}

}
