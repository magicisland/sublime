package server;


import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import model.Pojo;

@Path("/servicio")

public class Service {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response createProduct(Object object) {
		// TODO Auto-generated method stub
		
	
		
		/**
		 * 
		 if the response doesn't contain body, I must return 204 code ( it means : client shouldn't look )
		  In counterpart, we return 200 code; it means .. everything is OK 
		*/
		
		String body = " POST ";
		int productId = 0;
		
		ResponseBuilder responseBuilder = Response.created(URI.create("/products/"+productId));
		responseBuilder.header("Content-type", MediaType.APPLICATION_JSON);
		responseBuilder.entity(body);
		responseBuilder.status(Status.CREATED);
		Response response=responseBuilder.build();
		
		return response;
	
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pojo getProduct(@PathParam("id")int id) {
		// TODO Auto-generated method stub
		
		Pojo pojo = new Pojo();
		pojo.setId(1);
		pojo.setName("Marcelo");
		return pojo;
		
			
	}

}
