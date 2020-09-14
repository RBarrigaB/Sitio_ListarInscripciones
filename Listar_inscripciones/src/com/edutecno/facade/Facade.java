package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.CursoDAO;
import com.edutecno.dao.InscripcionDAO;
import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.InscripcionDTO;

public class Facade {

	public List<CursoDTO> findAll(){
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.findAll();
	}
	
	public CursoDTO findById(Object id) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.findById(id);
	}
	
	public boolean create(CursoDTO cursoDto) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.create(cursoDto);
	}
	
	public boolean update(CursoDTO cursoDto) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.update(cursoDto);
	}
	
	public boolean delete(CursoDTO cursoDto) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.detele(cursoDto);
	}
	
	public List<InscripcionDTO> obtieneInscripciones(){ // se declara el método obtieneInscripciones
		InscripcionDAO inscripcionDao= new InscripcionDAO(); // se instancia InscripcionDAO con un objeto
		return inscripcionDao.obtieneInscripciones(); //se retorna la lista que tiene como retorno el método obtieneInscripciones
	}
}
