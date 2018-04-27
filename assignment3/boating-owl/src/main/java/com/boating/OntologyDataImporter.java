package com.boating;

import com.boating.cs.OntFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
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


	 //Change to your own ontology.
	 public static final String ontology="boats_owl2.owl";
	 public static final String ontology_saved="boats_owl2_saved.owl";

	public static final String dbpedia_url = "http://dbpedia.org/page/Boat";


	 public OntologyDataImporter(){

		 try{

		  manager = OWLManager.createOWLOntologyManager();

		  File ontFile=new File(ontology);
          IRI iri = IRI.create(ontFile);
          ont= manager.loadOntologyFromOntologyDocument(iri);
          System.out.println("Loaded ontology: " + ont);

		 }catch(Exception ex){
			 ex.printStackTrace();
		 }

	 }


	 /**
	 * Part 3
	 *
	 * populate()
	 *
	 * Query RDF store(s) via their
	 * SPARQL endpoints using Jena API. Use the data
	 * obtained to populate your ontology
	 * (adding instances).
	 */

	public void populate(){

		 //Part 3

//		 //DBpedia SPARQL endpoint
//		 String sparqlEndpoint="http://dbpedia.org/sparql";
//		 //use your own SPARQL
//		 String sparql = "SELECT ?s ?p ?o WHERE {?s ?p ?o} LIMIT 10";
//		 Query query = QueryFactory.create(sparql);
//		 QueryExecution qexec = null;
//
//
//		try {
//			qexec =  QueryExecutionFactory.sparqlService(sparqlEndpoint, query);
//			//Complete this method....
//			//Model resultModel = qexec.execDescribe() ;
//			//application/sparql-results+json
//			ResultSet results = qexec.execSelect();
//
//			for (; results.hasNext(); ) {
//				QuerySolution soln = results.nextSolution();
//				RDFNode x = soln.get("s");       // Get a result variable by name.
//				Resource r = soln.getResource("s"); // Get a result variable - must be a resource
//				Literal l = soln.getLiteral("s");   // Get a result variable - must be a literal
//			}
//		}finally{
//			qexec.close();
//		}

//		String queryStr = "SELECT ?prop ?place WHERE { <http://dbpedia.org/resource/%C3%84lvdalen> ?prop ?place .}";
//		Query query = QueryFactory.create(queryStr);
//
//		// Remote execution.
//		try ( QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query) ) {
//			// Set the DBpedia specific timeout.
//			((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;
//
//			// Execute.
//			ResultSet rs = qexec.execSelect();
//			ResultSetFormatter.out(System.out, rs, query);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		FoafExample f = new FoafExample();
//		f.doExample();

//		BirthPlaceExample bpe = new BirthPlaceExample();
//		bpe.doExample();

		BoatExample be = new BoatExample();
		be.doExample();

	 }




	 /**
	  *
	  *  Question 3
	  *
	  *  createRelationships()
	  *
	  *  Set Datatype/Object Property values
	  *
	  *
	  */
	public void createRelationships(){

		 try{

          OntFactory factory=new OntFactory (ont);

		 //complete this method ...


		 }catch(Exception ex){
			 ex.printStackTrace();
		 }

	 }


	 public void save(){

			try{

			File file=new File(ontology_saved);
			 manager.saveOntology(ont, IRI.create(file.toURI()));
			 System.out.println("Saved ontology: " + ont);

			}catch(Exception ex){
				ex.printStackTrace();
			}

		}


	 public static void main(String[] args){

		 OntologyDataImporter app=new OntologyDataImporter();
		 app.populate();
		 app.createRelationships();
		 app.save();

	 }

	 private static class FoafExample{

	 	public void doExample(){

			FileManager.get().addLocatorClassLoader(OntologyDataImporter.FoafExample.class.getClassLoader());
			Model model = FileManager.get().loadModel("data.ttl", null, "TURTLE");

			StmtIterator iter = model.listStatements();
			try {
				while ( iter.hasNext() ) {
					Statement stmt = iter.next();

					Resource s = stmt.getSubject();
					Resource p = stmt.getPredicate();
					RDFNode o = stmt.getObject();

					if ( s.isURIResource() ) {
						System.out.print("URI");
					} else if ( s.isAnon() ) {
						System.out.print("blank");
					}

					if ( p.isURIResource() )
						System.out.print(" URI ");

					if ( o.isURIResource() ) {
						System.out.print("URI");
					} else if ( o.isAnon() ) {
						System.out.print("blank");
					} else if ( o.isLiteral() ) {
						System.out.print("literal");
					}

					System.out.println();
				}
			} finally {
				if ( iter != null ) iter.close();
			}
		}
	 }

	 private static class BirthPlaceExample{

	 	public void doExample(){

			String service="http://dbpedia.org/sparql";
			String query="PREFIX dbo:<http://dbpedia.org/ontology/>"
					+ "PREFIX : <http://dbpedia.org/resource/>"
					+ "PREFIX foaf:<http://xmlns.com/foaf/0.1/>"
					+ "select ?person ?name where {?person dbo:birthPlace :Eindhoven."
					+ "?person foaf:name ?name}";
			QueryExecution qe= QueryExecutionFactory.sparqlService(service, query);
			ResultSet rs=qe.execSelect();
			while (rs.hasNext()){
				QuerySolution s=rs.nextSolution();
				Resource r=s.getResource("?person");
				Literal name=s.getLiteral("?name");
				System.out.println(s.getResource("?person").toString());
				System.out.println(s.getLiteral("?name").getString());
			}
				//03/28/11
		}
	 }

	 private static class BoatExample{

	 	//http://brunodias.space/2016/06/29/scraping-for-fun-and-corpora/index.html
		 //http://mappings.dbpedia.org/index.php/OntologyClass:Ship
		 //http://dbpedia.org/ontology/Ship

		 public void doExample() {

			 String service = "http://dbpedia.org/sparql";
			 String query = "PREFIX dbo:<http://dbpedia.org/ontology/>"
					// + PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
					 + "PREFIX : <http://dbpedia.org/resource/>"
					 + "PREFIX foaf:<http://xmlns.com/foaf/0.1/>"
					 + "select ?ship where {?ship rdf:type dbo:Ship }";
			 QueryExecution qe= QueryExecutionFactory.sparqlService(service, query);
			 ResultSet rs=qe.execSelect();
			 while (rs.hasNext()){
				 QuerySolution s=rs.nextSolution();
				 Resource r=s.getResource("?ship");
				 //Literal name=s.getLiteral("?name");
				 System.out.println(s.getResource("?person").toString());
				 System.out.println(s.getLiteral("?name").getString());
			 }
			 //03/28/11
		 }
	 }

}