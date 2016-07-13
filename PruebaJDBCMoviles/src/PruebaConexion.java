import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class PruebaConexion {
	private static Connection con = null;

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/movilesdb?useSSL=false",
					"moviles", "pwd");
			System.out.println("conexion establecida ");

/*			PreparedStatement preparedStatement = con.prepareStatement(""
					+ "insert into libro (titulo, autor, stock)"
					+ "values(?,?,?)");
			preparedStatement.setString(1, "Harry Potter");
			preparedStatement.setString(2, "J.K. Rowling");
			preparedStatement.setInt(3, 50);
			boolean ejecutado = preparedStatement.execute();*/
			
			PreparedStatement ps = con.prepareStatement("select * from libro");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			e.printStackTrace();
		}
		try {
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
