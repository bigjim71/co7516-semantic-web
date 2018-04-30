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
    @Path("competency1")
    @Produces(MediaType.TEXT_PLAIN)
    public String competency1(@FormParam("search_terms") String searchTerms){
        return "update1: searchTerms: "+searchTerms;
    }

    @POST
    @Path("competency2")
    @Produces(MediaType.TEXT_PLAIN)
    public String competency2(@FormParam("search_terms") String searchTerms){
        return "update1: searchTerms: "+searchTerms;
    }

    @POST
    @Path("competency3")
    @Produces(MediaType.TEXT_PLAIN)
    public String competency3(@FormParam("search_terms") String searchTerms){
        return "update1: searchTerms: "+searchTerms;
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(){
        return "not supported";
    }
}
