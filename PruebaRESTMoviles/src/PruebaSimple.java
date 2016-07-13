import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

@Path("PruebaSimpleR")
@Produces("application/json")
public class PruebaSimple {

	@GET
	@Path("pruebaH")
	public String prueba() {
		return "Hola mundo";
	}

	@GET
	@Path("echo/mensaje/{varMen}")
	public String echo(@PathParam("varMen") String mensaje) {
		return mensaje.toUpperCase();
	}
}
