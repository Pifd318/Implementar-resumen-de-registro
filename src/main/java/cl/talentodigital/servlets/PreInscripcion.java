package cl.talentodigital.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.talentodigital.entidades.*;
import cl.talentodigital.facade.Facade;


@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instancia de Facade para usar sus métodos
		Facade facade = new Facade();
		try {
			
			ArrayList<CursoDTO> cursos =facade.obtenerCursos();
			ArrayList<FormaDePagoDTO> formasDePago =facade.obtenerFormasDePago();
			
			//vamos a setear attributos para entregar el jsp
			request.setAttribute("cursosAtt", cursos);
			request.setAttribute("formasDePagoAtt", formasDePago);
			
			request.getRequestDispatcher("Inscripcion.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
