package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
	static Connection con = null;

	public static void main(String args[]) {

	}

	public static Connection crearConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/movilesdb?useSSL=false",
					"moviles", "pwd");
			System.out.println("conexion establecida ");
		} catch (Exception e) {
			System.out.println("error al conectar " + e);
		}
		/*
		 * try { con.close(); } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		return con;
	}
/**
 * Metodo que permite cerrar una conexion, si no puede cerrar \
 * la conexion entonces mostrara las razones por la que no se puede realizar.
 * N cierra la conexion si tiene alguna transaccion pendiente
 * @param con
 */
	public static void cerrarConexion(Connection con) {
		try {
			con.close();
			System.out.println("conexion establecida ");
		} catch (Exception e) {
			System.out.println("error al conectar " + e);
		}

	}
}
