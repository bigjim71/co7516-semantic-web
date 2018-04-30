package com.boating;

import com.boating.cs.*;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import java.io.File;

//import org.apache.jena.query.*;

//import org.apache.jena.query.*;


public class OntologyDataImporter {

    OWLOntologyManager manager;
    OWLOntology ont;
    OntModelSpec spec;
    OntModel model;


    //Change to your own ontology.
    public static final String ontology = "boats_owl2.owl";
    public static final String ontology_saved = "boats_owl2_saved.owl";

    public static final String dbpedia_url = "http://dbpedia.org/page/Boat";


    public OntologyDataImporter() {

        try {

            manager = OWLManager.createOWLOntologyManager();

            File ontFile = new File(ontology);
            IRI iri = IRI.create(ontFile);
            ont = manager.loadOntologyFromOntologyDocument(iri);
            System.out.println("Loaded ontology: " + ont);

            spec = new OntModelSpec(OntModelSpec.OWL_DL_MEM);
            model = ModelFactory.createOntologyModel(spec);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    /**
     * Part 3
     * <p>
     * populate()
     * <p>
     * Query RDF store(s) via their
     * SPARQL endpoints using Jena API. Use the data
     * obtained to populate your ontology
     * (adding instances).
     */

    public void populate() {

        String service = "http://dbpedia.org/sparql";
        String queryString = "PREFIX dbp: <http://dbpedia.org/property/>\n" +
                "PREFIX dbr: <http://dbpedia.org/resource/>\n" +
                "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
                "\n" +
                "select ?ship ?shipPower ?shipName ?shipOwner ?builder ?location ?crew\n" +
                "where \n" +
                "{\n" +
                "?ship a dbo:MeanOfTransportation .\n" +
                "?ship a dbo:Ship .\n" +
                "?ship foaf:name ?shipName.\n" +
                "?ship dbp:shipCrew ?shipCrew.\n" +
                "?ship dbp:shipOperator ?shipOperator. \n" +
                "?ship dbp:shipOwner ?shipOwner.\n" +
                "?ship dbo:builder ?builder.\n" +
                "?builder dbo:location ?location.\n" +
                "?ship dbp:shipPower ?shipPower.\n" +
                "?ship dbp:shipCrew ?crew\n" +
                "}\n" +
                "LIMIT 5000";

        System.out.println(queryString);

        QueryExecution qe = QueryExecutionFactory.sparqlService(service, queryString);
        //Model resultModel = qe.execDescribe() ;
        ResultSet rs = qe.execSelect();
        while (rs.hasNext()) {
            QuerySolution s = rs.nextSolution();
            Resource ship = s.getResource("?ship");
            Literal name = s.getLiteral("?shipName");
            Literal owner = s.getLiteral("?shipOwner");
            Literal power = s.getLiteral("?shipPower");
            Literal crew = s.getLiteral("?crew");
            Resource location = s.getResource("?location");
            Resource builder = s.getResource("?builder");

//			System.out.println("owner: "+owner.toString());
//			System.out.println("name: "+name.toString());
//			System.out.println("power: "+power.toString());
//			System.out.println("location: "+location.getLocalName().toString());
//			System.out.println("builder: "+builder.getLocalName().toString());

            /**
             * It's not been possible to retrieve data which fits correctly with the competency questions from Assignment 1.
             * There isn't seemingly a good source of data for *leisure* boats.
             * Whereas there is quite alot of data for commercial *ships*.
             * Consequently, I've "massaged" the commercial data for ships as retrieved, to create instances of leisure
             * boat types which are required for the competency questions.
             */

            OntFactory ontFactory = new OntFactory(ont);

            BoatRentalProvider boatRentalProvider = ontFactory.createBoatRentalProvider(owner.toString().replaceAll("[^A-Za-z0-9]", ""));
            Haven homeHaven = ontFactory.createHaven(location.getLocalName().toString().replaceAll("[^A-Za-z0-9]", ""));
            boatRentalProvider.addRentalProviderHomeHaven(homeHaven);

            //split across different boat types ie. for one Ship retrieved, create 2 leisure boat instances, albeit with the same name (different type).
            CabinCruiser cabinCruiser = ontFactory.createCabinCruiser(name.toString().replaceAll("[^A-Za-z0-9]", ""));
            cabinCruiser.addHasEngine(true);
            cabinCruiser.addRequiresCrew(this.getIntegerValue(crew.toString().replaceAll("[^A-Za-z0-9]", "")));
            cabinCruiser.addSleepingSpaces(10);

            Cutter cutter = ontFactory.createCutter(name.toString().replaceAll("[^A-Za-z0-9]", ""));
            cutter.addHasSails(true);
            cutter.addRequiresCrew(this.getIntegerValue(crew.toString().replaceAll("[^A-Za-z0-9]", "")));
            cutter.addSleepingSpaces(10);

            Engine engine = ontFactory.createEngine(power.toString().replaceAll("[^A-Za-z0-9]", ""));

            //add engine to boats
            ontFactory.as(cabinCruiser, Boat.class).addEngineSize(getIntegerValue(power.toString().replaceAll("[^A-Za-z0-9]", "")));
            ontFactory.as(cutter, Boat.class).addEngineSize(getIntegerValue(power.toString().replaceAll("[^A-Za-z0-9]", "")));


            //set contact details on boatrentalprovider
            Contact contact = ontFactory.createContact(builder.getLocalName().toString().replaceAll("[^A-Za-z0-9]", ""));

            boatRentalProvider.addBelongsTo((Boat) cabinCruiser);
            boatRentalProvider.addBelongsTo((Boat) cutter);
            boatRentalProvider.addContact(contact);

            String ql = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                    "PREFIX boat: <http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#>\n" +
                    "SELECT * " +
                    "WHERE" +
                    "{ ?s ?p ?o" +
                    //"?brp :boatRentalProviders ?boat ." +
                    "}" ;
            Query query = QueryFactory.create(ql);
            QueryExecution ex = QueryExecutionFactory.create(ql, model);
            ResultSet rs1 = qe.execSelect();
            while (rs1.hasNext()) {
                QuerySolution s1 = rs.nextSolution();
                Resource brp = s1.getResource("?s");
                System.out.println(brp.toString());

            }

        }

    }


    /**
     * Question 3
     * <p>
     * createRelationships()
     * <p>
     * Set Datatype/Object Property values
     */
    public void createRelationships() {

        //see relationships created above.


    }


    public void save() {

        try {

            File file = new File(ontology_saved);
            manager.saveOntology(ont, IRI.create(file.toURI()));
            System.out.println("Saved ontology: " + ont);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {

        OntologyDataImporter app = new OntologyDataImporter();
        app.populate();
        app.createRelationships();
        app.save();

    }

    private Integer getIntegerValue(String intValue) {

        try {
            return Integer.valueOf(intValue);
        } catch (Exception e) {
            return new Integer(1);
        }
    }


}