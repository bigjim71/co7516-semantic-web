package com.boating;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;

/**
 * Created by fh231 on 4/30/2018.
 */
public class ShipQuery {

    private String service = "http://dbpedia.org/sparql";
    private String queryString = "PREFIX dbp: <http://dbpedia.org/property/>\n" +
            "PREFIX dbr: <http://dbpedia.org/resource/>\n" +
            "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
            "\n" +
            "select ?ship ?builder ?location ?shipPower \n" +
            "where \n" +
            "{\n" +
            "?ship a dbo:MeanOfTransportation .\n" +
            "?ship a dbo:Ship .\n" +
            "?ship dbp:shipCrew ?shipCrew.\n" +
            "?ship dbp:shipOperator ?shipOperator. \n" +
            "?ship dbp:shipOwner ?shipOwner.\n" +
            "?ship dbo:builder ?builder.\n" +
            "?builder dbo:location ?location.\n" +
            "?ship dbp:shipPower ?shipPower\n" +
            "}\n" +
            "LIMIT 5000";


    public void query() {

        QueryExecution qe = QueryExecutionFactory.sparqlService(service, queryString);
        //Model resultModel = qe.execDescribe() ;
        ResultSet rs = qe.execSelect();
        while (rs.hasNext()) {
            QuerySolution s = rs.nextSolution();
            Resource ship = s.getResource("?ship");

            //CommercialBoat commercialBoat =  new OntFactory();
        }
    }
}
