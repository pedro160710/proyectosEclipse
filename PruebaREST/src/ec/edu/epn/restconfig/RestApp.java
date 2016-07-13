package ec.edu.epn.restconfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//ESTA ES LA CONFIGURACION DEL SERVICIO REST
//TIENE QUE EXTENDER DE APPLICATION

@ApplicationPath("rest")
//esta notacion crea una especie de servlet, no se puede aplicar a cualquier clase
public class RestApp extends Application{

	
}
