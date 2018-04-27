package com.boating.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("boats")
public class BoatsService {

    /**
     * CRUD REST interface
     */

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String create(){
        return "create";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String read() {
        return "Read!";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String update(){
        return "update";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(){
        return "not supported";
    }
}
