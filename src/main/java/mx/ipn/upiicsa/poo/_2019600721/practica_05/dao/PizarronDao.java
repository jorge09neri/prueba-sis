package mx.ipn.upiicsa.poo._2019600721.practica_05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Diagrama;

public class PizarronDao {

	public static void main(String[] args) {
		PizarronDao pizarronDao = new PizarronDao();
		List<Diagrama> diagramas = pizarronDao.obtenerDiagramas();
		System.out.println("Existen: " + diagramas);
		for (Diagrama diagrama : diagramas) {
			pizarronDao.obtenerDiagrama(diagrama.getId());
			System.out.println();
		}
	}

	public List<Diagrama> obtenerDiagramas() {
		List<Diagrama> diagramas = new ArrayList<>();

		try {
			Connection connection = ConnectionUtil.getConnection();
			// son suseptibles a SQL Injection, por eso se trabaja con prepared statements
			PreparedStatement statement = connection.prepareStatement(
					"select id_diagrama, tx_nombre, tx_descripcion, fh_creacion, fh_modificacion from diagrama");
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			while (resultado.next()) {
				Integer idDiagrama = resultado.getInt("id_diagrama");
				String nombre = resultado.getString("tx_nombre");
				String descripcion = resultado.getString("tx_nombre");
				Date creacion = new Date(resultado.getDate("fh_creacion").getTime());
				Date modificacion = new Date(resultado.getDate("fh_modificacion").getTime());
				Diagrama diagrama = new Diagrama(idDiagrama, nombre, descripcion, creacion, modificacion);
				diagramas.add(diagrama);
			}
		} catch (SQLException e) {
			System.out.println("-> Error en la consulta de diagramas");
		}
		return diagramas;
	}

	public Diagrama obtenerDiagrama(Integer id) {
		Diagrama diagrama = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			// son suseptibles a SQL Injection, por eso se trabaja con prepared statements
			PreparedStatement statement = connection.prepareStatement("select * from diagrama where id_diagrama=?");
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			if (resultado.next()) {
				Integer idDiagrama = resultado.getInt("id_diagrama");
				String nombre = resultado.getString("tx_nombre");
				String descripcion = resultado.getString("tx_nombre");
				Date creacion = new Date(resultado.getDate("fh_creacion").getTime());
				Date modificacion = new Date(resultado.getDate("fh_modificacion").getTime());
				String json = resultado.getString("tx_json");
				diagrama = new Diagrama(idDiagrama, nombre, descripcion, creacion, modificacion, json);
			}
		} catch (SQLException e) {
			System.out.println("-> Error en la consulta de diagramas");
		}
		return diagrama;
	}

	public Diagrama borrarDiagrama(Integer id) {
		Diagrama diagrama = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			// son suseptibles a SQL Injection, por eso se trabaja con prepared statements
			PreparedStatement statement = connection.prepareStatement("delete * from diagrama where id_diagrama=?");
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			if (resultado.next()) {
				Integer idDiagrama = resultado.getInt("id_diagrama");
				String nombre = resultado.getString("tx_nombre");
				String descripcion = resultado.getString("tx_nombre");
				Date creacion = new Date(resultado.getDate("fh_creacion").getTime());
				Date modificacion = new Date(resultado.getDate("fh_modificacion").getTime());
				String json = resultado.getString("tx_json");
				diagrama = new Diagrama(idDiagrama, nombre, descripcion, creacion, modificacion, json);
			}
		} catch (SQLException e) {
			System.out.println("-> Error en la consulta de diagramas");
		}
		return diagrama;
	}

	public Diagrama guardarDiagrama(Integer id) {
		Diagrama diagrama = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			// son suseptibles a SQL Injection, por eso se trabaja con prepared statements
			PreparedStatement statement = connection.prepareStatement("insert * into diagrama");
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			if (resultado.next()) {
				Integer idDiagrama = resultado.getInt("id_diagrama");
				String nombre = resultado.getString("tx_nombre");
				String descripcion = resultado.getString("tx_nombre");
				Date creacion = new Date(resultado.getDate("fh_creacion").getTime());
				Date modificacion = new Date(resultado.getDate("fh_modificacion").getTime());
				String json = resultado.getString("tx_json");
				diagrama = new Diagrama(idDiagrama, nombre, descripcion, creacion, modificacion, json);
			}
		} catch (SQLException e) {
			System.out.println("-> Error en la consulta de diagramas");
		}
		return diagrama;
	}
	public Diagrama actualizarDiagrama(Integer id) {
		Diagrama diagrama = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			// son suseptibles a SQL Injection, por eso se trabaja con prepared statements
			PreparedStatement statement = connection.prepareStatement("update * from diagrama where id_diagrama=?");
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			if (resultado.next()) {
				Integer idDiagrama = resultado.getInt("id_diagrama");
				String nombre = resultado.getString("tx_nombre");
				String descripcion = resultado.getString("tx_nombre");
				Date creacion = new Date(resultado.getDate("fh_creacion").getTime());
				Date modificacion = new Date(resultado.getDate("fh_modificacion").getTime());
				String json = resultado.getString("tx_json");
				diagrama = new Diagrama(idDiagrama, nombre, descripcion, creacion, modificacion, json);
			}
		} catch (SQLException e) {
			System.out.println("-> Error en la consulta de diagramas");
		}
		return diagrama;
	}
}
