import java.net.ResponseCache;
import java.util.Hashtable;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;

// Database.java
@Singleton
@Path("/mark")

public class Database {
    
    private Hashtable<String,Integer> table = new Hashtable<String,Integer>();

    @POST
	@Path("{id},{mark}")
    public Response addRecord(@PathParam("id")String id, @PathParam("mark")String mark) {
        // Add a record using id as key and mark as value
        table.put(id,Integer.parseInt(mark));
        System.out.println("ID: "+id);
        System.out.println("Mark: "+mark);
        return Response.status(200).build();
    }

    @GET
	@Produces(MediaType.TEXT_PLAIN)
    public Response getMark(@QueryParam("id") String id) {
        // Retrieve a record using id as key
        Integer mark = table.get(id);
        if (mark==null){
            System.out.println("The ID does not exist.");
            return "";
        } else {
            System.out.println("The mark is: "+mark);
            return mark;
        }
        
    }

    @POST
	@Path("{id},{mark}")
    public String updateRecord(@PathParam("id")String id, @PathParam("mark")String mark) {
        // Update a record using id as key and mark as value
        Integer result = table.replace(id,mark);
        if (result==null){
            System.out.println("The ID does not exist");
            return Response.status(404).build();
        } else {
            System.out.println("The record with ID "+id+" has been updated with value "+mark);
            return Response.status(200).build();
        }
    }
}
