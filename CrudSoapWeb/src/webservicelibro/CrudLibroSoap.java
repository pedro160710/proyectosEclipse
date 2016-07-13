package webservicelibro;

import javax.jws.WebMethod;
import javax.jws.WebService;

import servicio.ServicioLibro;
import modelo.Libro;

@WebService()
public class CrudLibroSoap {

	ServicioLibro servicioLibro = new ServicioLibro();

	@WebMethod()
	public String sayHello(String name) {
		System.out.println("Hello: " + name);
		return "Hello " + name + "!";
	}

	@WebMethod()
	public String crearLibro(String autor, String titulo, int stock) {

		Libro nuevoLibro = new Libro(autor, titulo, stock);
		servicioLibro.crearLibro(nuevoLibro);

		return "Libro creado successfully";
	}

	@WebMethod()
	public String editarLibro(int idLibro, String autor, String titulo,
			int stock) {

		Libro libro = servicioLibro.findByIdLibro(idLibro);

		if (!autor.equals(null)) {
			libro.setAutor(autor);
		}
		if (!titulo.equals(null)) {
			libro.setTitulo(titulo);
			;
		}
		if (stock >= 0) {
			libro.setStock(stock);
			;
		}

		servicioLibro.editarLibro(libro);
		return "Libro editado";
	}

	@WebMethod()
	public String eliminarLibro(int idLibro) {

		Libro libro = servicioLibro.findByIdLibro(idLibro);

		servicioLibro.eliminarLibro(libro);

		return "Libro eliminado";
	}

	@WebMethod()
	public String buscarLibro(int idLibro) {
		Libro libro = servicioLibro.findByIdLibro(idLibro);
		return libro.getAutor();

	}

}
