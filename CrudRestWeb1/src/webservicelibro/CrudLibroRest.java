package webservicelibro;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import com.sun.xml.internal.txw2.Document;

import servicio.ServicioLibro;
import modelo.Libro;

@Path("crudLibroRest")
@Produces("application/json")
public class CrudLibroRest {

	ServicioLibro servicioLibro = new ServicioLibro();

	// CONSULTAR LIBRO
	@GET
	@Path("consultarLibro")
	public Libro consultarLibro(@QueryParam("varId") int idLibro) {
		Libro libro = servicioLibro.findByIdLibro(idLibro);
		return libro;

	}

	@POST
	@Path("registrarLibro")
	public void registrarLibro(@FormParam("txtAutor") String autor,
			@FormParam("txtTitulo") String titulo,
			@FormParam("txtStock") int stock) {
		Libro nuevoLibro = new Libro(autor, titulo, stock);
		servicioLibro.crearLibro(nuevoLibro);
		System.out.println("Libro creado successfully");
	}

	// ACTUALIZAR LIBRO
	@GET
	@Path("actualizarLibro/id/{varId}/autor/{varAutor}/titulo/{varTitulo}/stock/{varStock}")
	public void ActualizarLibro(@PathParam("varId") int id,
			@PathParam("varAutor") String autor,
			@PathParam("varTitulo") String titulo,
			@PathParam("varStock") int stock) {
		Libro libro = new Libro(id, autor, titulo, stock);
		servicioLibro.editarLibro(libro);
		System.out.println("libro actualizado correctamente");
	}

	// ELIMINAR LIBRO
	@GET
	@Path("eliminarLibro/id/{varId}")
	public void eliminarLibro(@PathParam("varId") int id) {
		Libro libro = servicioLibro.findByIdLibro(id);
		servicioLibro.eliminarLibro(libro);
		System.out.println("libro eliminado correctamente");
	}
}