package com.boating.rest;

import com.boating.OntologyDataImporter;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST service accepts search terms for competency questions with @POST
 */
@Path("boats")
public class BoatsService {

    OntologyDataImporter dataImporter;

    public BoatsService(){
        dataImporter = new OntologyDataImporter();
        dataImporter.populate();
        dataImporter.createRelationships();
        //this.ontology = dataImporter.save();
    }

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

        String ql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX boat: <http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#>\n" +
                "SELECT ?brp ?boat ?sleepSpaces ?homeHaven\n" +
                "WHERE {\n" +
                "?brp boat:rentalProviderBoats ?boat.\n" +
                "?boat boat:sleepingSpaces ?sleepSpaces.\n"+
                "?boat a boat:CabinCruiser."+
                "?brp boat:rentalProviderHomeHaven ?homeHaven"+
        "FILTER (?sleepSpaces = 3)";

        Query query = QueryFactory.create(ql);

        QueryExecution ex = QueryExecutionFactory.create(ql, dataImporter.getModel());
        ResultSet rs1 = ex.execSelect();
        while (rs1.hasNext()) {
            QuerySolution s1 = rs1.nextSolution();
            Resource brp = s1.getResource("?s");
            return brp.toString();

        }
        return Response.noContent().toString();
    }

    @POST
    @Path("competency2")
    @Produces(MediaType.TEXT_PLAIN)
    public String competency2(@FormParam("search_terms") String searchTerms){

        String ql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX boat: <http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#>\n" +
                "SELECT ?haven ?berth ?berthLength ?boat\n" +
                "WHERE {\n" +
                "?boat a boat:Cutter.\n" +
                "?boat boat:boatLength ?cutterLength.\n" +
                "?haven boat:havenBerths ?berth.\n" +
                "?berth boat:berthMaxLength ?berthLength.\n" +
                "FILTER (?berthLength = ?cutterLength)\n" +
                "}";

        Query query = QueryFactory.create(ql);
        QueryExecution ex = QueryExecutionFactory.create(ql, dataImporter.getModel());
        ResultSet rs1 = ex.execSelect();
        while (rs1.hasNext()) {
            QuerySolution s1 = rs1.nextSolution();
            Resource haven = s1.getResource("?haven");
            return haven.toString();

        }
        return Response.noContent().toString();

    }

    @POST
    @Path("competency3")
    @Produces(MediaType.TEXT_PLAIN)
    public String competency3(@FormParam("search_terms") String searchTerms){
        String ql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX boat: <http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#>\n" +
                "SELECT ?boat\n" +
                "WHERE\n" +
                "{\n" +
                "{\n" +
                "?route boat:routeHavens ?haven.\n" +
                "?haven boat:havenName ?havenName.\n" +
                "?haven boat:havenBerths ?berth.\n" +
                "?berth boat:berthMaxLength ?berthLength.\n" +
                "?boat boat:boatLength ?boatLength.\n" +
                "?boat boat:requiresCrew ?crewNum.\n" +
                "OPTIONAL { ?boat boat:color ?color }.\n" +
                "FILTER (?berthLength >= ?boatLength)\n" +
                "FILTER (?crewNum = 0)\n" +
                "FILTER regex(?havenName, \"Poole\")\n" +
                "}\n" +
                "UNION\n" +
                "{\n" +
                "?route boat:routeHavens ?haven.\n" +
                "?haven boat:havenName ?havenName.\n" +
                "?haven boat:havenBerths ?berth.\n" +
                "?berth boat:berthMaxLength ?berthLength.\n" +
                "?boat boat:boatLength ?boatLength.\n" +
                "?boat boat:requiresCrew ?crewNum.\n" +
                "?boat boat:boatName ?boatName.\n" +
                "OPTIONAL { ?boat boat:color ?color }.\n" +
                "FILTER (?berthLength >= ?boatLength)\n" +
                "FILTER (?crewNum = 0)\n" +
                "FILTER regex(?havenName, \"Swanage\")\n" +
                "}}";

        Query query = QueryFactory.create(ql);
        QueryExecution ex = QueryExecutionFactory.create(ql, dataImporter.getModel());
        ResultSet rs1 = ex.execSelect();
        while (rs1.hasNext()) {
            QuerySolution s1 = rs1.nextSolution();
            Resource boat = s1.getResource("?boat");
            return boat.toString();

        }
        return Response.noContent().toString();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(){
        return "not supported";
    }

    public static void main(String[]  args){
        BoatsService s = new BoatsService();
        s.competency1("some search term");
    }
}
