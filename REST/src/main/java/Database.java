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
    public String addRecord(@PathParam("id")String id, @PathParam("mark")String mark) {
        // Add a record using id as key and mark as value
        table.put(id,String.valueOf(mark));
    }

    @GET
	@Produces(MediaType.TEXT_PLAIN)
    public String getMark() {
    // Retrieve a record using id as key
    }

    public String updateRecord() {
    // Update a record using id as key and mark as value
    }
}
