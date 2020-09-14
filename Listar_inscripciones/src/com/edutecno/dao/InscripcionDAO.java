package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.conexion.Conexion;
import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.InscripcionDTO;

public class InscripcionDAO{
	
	private Connection cnx;
	private final String SQL_INSCRIPCIONES_SELECT_ALL = "select id_insc, nombre, clave,rol,celular, id_curso, id_forma_de_pago from inscripcion";
	private final String SQL_INSERT_INSCRIPCIONES="insert into inscripciones(id_insc, nombre, clave, rol, celular, id_curso, id_forma_de_pago) values(?, ?, ?, ?, ?, ?, ?)";

	public List<InscripcionDTO> obtieneInscripciones() {
		//se crea una lista para almacenar la información obtenida desde la BD
		List<InscripcionDTO> inscripciones = new ArrayList<InscripcionDTO>();
		// se instancia PrepareStatment
		PreparedStatement ps;
		// se instancia Resultset
		ResultSet rs;
		try {
			cnx = Conexion.obtenerConexion().getConexion(); // Se conecta al servidor
			ps = cnx.prepareStatement(SQL_INSCRIPCIONES_SELECT_ALL); //Se prepara la consulta SQL_INSCRIPCIONES_SELECT_ALL
			rs = ps.executeQuery(); // Se ejecuta la consulta
			while(rs.next()) { // Se recorren los elementos de la tabla inscripciones mientras no tenga valores vacíos
				InscripcionDTO inscpDto = new InscripcionDTO(); // se crea un objeto de la clase InscripcionDTO
				inscpDto.setIdInsc(rs.getInt("id_insc")); // se pobla los valores de dicho objeto
				inscpDto.setNombre(rs.getString("nombre"));
				inscpDto.setClave(rs.getString("clave"));
				inscpDto.setRol(rs.getString("rol"));
				inscpDto.setCelular(rs.getString("celular"));
				inscpDto.setIdCurso(rs.getInt("id_curso"));
				inscpDto.setIdFormaDePago(rs.getInt("id_forma_de_pago"));
				inscripciones.add(inscpDto); // se agrega cada línea del objeto a una lista, mientras el ciclo while permanezca activo
			}
			Conexion.cerrarConexion(cnx); // se cierra la conexion
			return inscripciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertar_inscripciones(InscripcionDTO nueva_inscripcion) {
		
		// se instancia PrepareStatment
		PreparedStatement ps;
		// se crea un objeto para almacenar la información ingresada del usuario,
		// que posteriormente se insertará en la BD

		try {
			cnx = Conexion.obtenerConexion().getConexion();
			ps = cnx.prepareStatement(SQL_INSERT_INSCRIPCIONES);
			ps.setInt(1, nueva_inscripcion.getId_insc());
			ps.setString(2, nueva_inscripcion.getDescripcion());
			ps.setDouble(3, nueva_inscripcion.getPrecio());
			ps.setDouble(3, nueva_inscripcion.getPrecio());
			ps.setDouble(3, nueva_inscripcion.getPrecio());
			ps.setDouble(3, nueva_inscripcion.getPrecio());
			ps.setDouble(3, nueva_inscripcion.getPrecio());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
