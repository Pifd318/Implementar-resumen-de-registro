package cl.talentodigital.facade;

import java.sql.SQLException;
import java.util.ArrayList;

import cl.talentodigital.daos.CursoDAO;
import cl.talentodigital.daos.FormaDePagoDAO;
import cl.talentodigital.daos.InscripcionDAO;
import cl.talentodigital.entidades.CursoDTO;
import cl.talentodigital.entidades.FormaDePagoDTO;
import cl.talentodigital.entidades.InscripcionDTO;

public class Facade {

	public ArrayList<CursoDTO> obtenerCursos() throws ClassNotFoundException, SQLException {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.obtieneCursos();
	}

	public ArrayList<FormaDePagoDTO> obtenerFormasDePago() throws ClassNotFoundException, SQLException {
		FormaDePagoDAO formaDePagoDao = new FormaDePagoDAO();
		return formaDePagoDao.obtieneFormasDePago();
	}

	public void registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		dao.insertarInscripcion(dto);
	}
	
	public ArrayList<InscripcionDTO> obtieneInscripciones() throws ClassNotFoundException, SQLException{
		InscripcionDAO dao = new InscripcionDAO();
		return dao.obtieneInscripciones();
	}
}
