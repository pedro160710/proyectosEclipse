package ec.edu.epn;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
////ESTE ES UN SERVICIO REST
@Path (value="HolaRest")
@Produces(value="application/json")
// que tipo de contenido va a generear
// el value no es indispensable
public class HolaREST {
	
	/*@PersistenceContext(unitName="")
	EntityManager em;
//	inyeccion de dependencias
//	el servidor va  a crear el 
*/	
	@GET
	@Path(value="sumar")
//	colocar la URL para este metodo, en este caso es sumar
	public int sumar()
	{
		return 10;
	}

	@GET
	@Path("sumarPost/a/{varA}/b/{varB}")
//	colocar la URL para este metodo, en este caso es sumar
	public int sumarPost(@PathParam("varA") int a,@PathParam("varB") int b)
	{
		return a+b;
	}
	@GET
	@Path("consultarLibro")
	public Libro consultarLibro(@QueryParam ("varId")int id){
		
		
		/*em.createQuery("",Libro.class);
//		o
		em.find(Libro.class,id);*/
		return new Libro(id,"J.K.Rowling","Harry Potter",5);
		
	}
	
	@GET
	@Path("crearLibro")
	public Libro consultarLibro(@QueryParam ("varId")int id, @QueryParam("varAutor") String autor, @QueryParam("varTitulo")String titulo, @QueryParam("varStock") int stock){
		return new Libro(id,autor,titulo,stock);
		
	}
	

}
