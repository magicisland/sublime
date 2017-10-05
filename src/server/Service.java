package server;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public class Service implements IService{

	@Override
	public Response createProduct(Object object) {
		// TODO Auto-generated method stub
		
	
		
		/**
		 * 
		 if the response doesn't contain body, I must return 204 code ( it means : client shouldn't look )
		  In counterpart, we return 200 code; it means .. everything is OK 
		*/
		
		String body = "";
		int productId = 0;
		
		ResponseBuilder responseBuilder = Response.created(URI.create("/products/"+productId));
		responseBuilder.header("Content-type", MediaType.APPLICATION_JSON);
		responseBuilder.entity(body);
		responseBuilder.status(Status.CREATED);
		Response response=responseBuilder.build();
		
		return response;
	
	}

}
