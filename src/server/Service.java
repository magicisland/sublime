package server;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;


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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import model.Pojo;
import model.Track;
import utils.HibernateUtils;

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
	@Path("/{table}-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("table") String table,@PathParam("id")int id) {
		// TODO Auto-generated method stub

		
		//HibernateUtils hbUtils = new HibernateUtils();
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		Session sess= sessionFactory.openSession();
		
		Transaction tx= (Transaction) sess.beginTransaction();
		
		Query query =  sess.createSQLQuery("select * from " +  table  +  " where id = "  + id );
		
		List<Object[]> queryList=query.list();
		Track track = new Track();
		
		track.setDetalle(" ESto es un detalle !!! ");
		
		if (!queryList.isEmpty()){
			
			track.setId((int)queryList.get(0)[0]);
			track.setName((String)queryList.get(0)[1]);
			track.setDetalle((String)queryList.get(0)[2]);
		}
		
		
		Gson gson = new Gson();
		String entity = gson.toJson(track);
		
		ResponseBuilder responseBuilder = Response.ok(entity);
		responseBuilder.header("Content-Type", "application/json");
		responseBuilder.entity(entity);
		
		Response response = responseBuilder.build();
		return response;
		
	}

}
