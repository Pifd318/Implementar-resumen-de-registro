package cl.talentodigital.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.talentodigital.entidades.InscripcionDTO;
import cl.talentodigital.facade.Facade;


@WebServlet("/preListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		
		try {
			ArrayList<InscripcionDTO> inscripciones = facade.obtieneInscripciones();
			request.setAttribute("inscripcionesAtt", inscripciones);
			
			request.getRequestDispatcher("ListarInscripciones.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}


