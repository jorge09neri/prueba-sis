package mx.ipn.upiicsa.poo._2019600721.practica_05.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionUtil {
	private static ComboPooledDataSource comboPooledDataSource;
	
	static {
		try {
			comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setDriverClass("org.postgresql.Driver"); //carga la clase del conector para postgres
			comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/pizarron"); //funciona solo para postgres
			comboPooledDataSource.setUser("postgres");
			comboPooledDataSource.setPassword("postgres");
			
//			acquireIncrement
//			initialPoolSize
//			maxPoolSize
//			maxIdleTime
//			minPoolSize
			comboPooledDataSource.setAcquireIncrement(5);
			comboPooledDataSource.setInitialPoolSize(5);
			comboPooledDataSource.setMaxPoolSize(20);
			comboPooledDataSource.setMaxIdleTime(0);
			comboPooledDataSource.setMinPoolSize(5);
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		return comboPooledDataSource.getConnection();
	}
}
