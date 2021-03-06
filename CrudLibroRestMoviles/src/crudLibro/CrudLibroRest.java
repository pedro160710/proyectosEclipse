package crudLibro;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexion.ConexionBaseDatos;
import entidad.*;

@Path("crudLibroRest")
@Consumes("application/json")
@Produces("application/json")
public class CrudLibroRest {
	// ConexionBaseDatos conexion = new ConexionBaseDatos();
//CONSULTAR LIBRO POR NOMBRE
	@GET
	@Path("consultarLibroTitulo")
	public List<Libro> consultarLibroNombre(@QueryParam("varTitulo") String tituloLibro) {
		Connection con = (Connection) ConexionBaseDatos.crearConexion();
		Libro libro = new Libro();
		List<Libro> librosRetorno = new ArrayList<Libro>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from libro where titulo=? ");
			ps.setString(1, tituloLibro);
			ResultSet libros = ps.executeQuery();
			while (libros.next()) {
				libro.setAutor(libros.getString("autor"));
				libro.setTitulo(libros.getString("titulo"));
				libro.setStock(libros.getInt("stock"));
				libro.setId(libros.getInt("id"));
				librosRetorno.add(libro);
			}
			ConexionBaseDatos.cerrarConexion(con);
		} catch (Exception e) {
			System.out.println("no se pudo consultar el libro " + e);
			e.printStackTrace();
		}
		return librosRetorno;
	}
	// CONSULTAR LIBRO
	@GET
	@Path("consultarLibro")
	public List<Libro> consultarLibro(@QueryParam("varId") String idLibro) {
		Connection con = (Connection) ConexionBaseDatos.crearConexion();
		Libro libro = new Libro();
		List<Libro> librosRetorno = new ArrayList<Libro>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from libro where id=? ");
			ps.setInt(1, Integer.parseInt(idLibro));
			ResultSet libros = ps.executeQuery();
			while (libros.next()) {
				libro.setAutor(libros.getString("autor"));
				libro.setTitulo(libros.getString("titulo"));
				libro.setStock(libros.getInt("stock"));
				libro.setId(libros.getInt("id"));
				librosRetorno.add(libro);
			}
			ConexionBaseDatos.cerrarConexion(con);
		} catch (Exception e) {
			System.out.println("no se pudo consultar el libro " + e);
			e.printStackTrace();
		}
		return librosRetorno;
	}

	// CONSULTAR LIBROS
	@GET
	@Path("consultarLibros")
	public List<Libro> consultarLibros() {
		Connection con = (Connection) ConexionBaseDatos.crearConexion();
		List<Libro> librosConsultados = new ArrayList<Libro>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from libro");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setAutor(rs.getString("autor"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setStock(rs.getInt("stock"));
				libro.setId(rs.getInt("id"));
				librosConsultados.add(libro);
			}
			ConexionBaseDatos.cerrarConexion(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return librosConsultados;

	}

	// REGISTRAR LIBRO
	@GET
	@Path("registrarLibro")
	public String registrarLibro(@QueryParam("varAutor") String autor,
			@QueryParam("varTitulo") String titulo,
			@QueryParam("varStock") int stock) {
		Connection con = (Connection) ConexionBaseDatos.crearConexion();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into libro(titulo,autor,stock) values(?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, autor);
			ps.setInt(3, stock);
			ps.execute();
			ps.close();
			ConexionBaseDatos.cerrarConexion(con);
		} catch (Exception e) {
			System.out.println("error al crear " + e);
			e.printStackTrace();
		}
		return "LIbro creado exitosamente";
	}

	// ACTUALIZAR LIBRO
	@GET
	@Path("actualizarLibro/id/{varId}/autor/{varAutor}/titulo/{varTitulo}/stock/{varStock}")
	public String actualizarLibro(@PathParam("varId") int id,
			@PathParam("varAutor") String autor,
			@PathParam("varTitulo") String titulo,
			@PathParam("varStock") int stock) {
		Connection con = (Connection) ConexionBaseDatos.crearConexion();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("update libro set titulo=?, autor=?, stock=? where id=?");
			ps.setString(1, titulo);
			ps.setString(2, autor);
			ps.setInt(3, stock);
			ps.setInt(4, id);
			ps.execute();
			ps.close();
			ConexionBaseDatos.cerrarConexion(con);
		} catch (Exception e) {
			System.out.println("error al actualizar libro " + e);
			e.printStackTrace();
		}
		return "Libro actualizado correctamente";
	}

	@GET
	@Path("eliminarLibro/idLibro/{varId}")
	public String eliminarLibro(@PathParam("varId") String idLibro) {
		Connection con = (Connection) ConexionBaseDatos.crearConexion();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("delete from libro where id=?");
			ps.setInt(1, Integer.parseInt(idLibro));
			ps.execute();
			ps.close();
			ConexionBaseDatos.cerrarConexion(con);
		} catch (Exception e) {
			System.out.println("no se pudo eliminar el libro " + e);
			e.printStackTrace();
		}

		return "se elimino el libro";
	}

}
