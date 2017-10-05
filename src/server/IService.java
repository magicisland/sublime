package server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/servicio")
public interface IService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProduct(Object object);
	
	
}
