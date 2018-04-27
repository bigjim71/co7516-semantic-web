package uk.ac.le.cs.CO7216;

import java.io.File;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class OntologyAlignment {
	
	 OWLOntologyManager manager;
	 OWLOntology ont; 
	 
	 
	 //Change to your own ontology.
	 public static final String ontology="your_ontology.owl";
	 public static final String ontology_saved="your_ontology_saved.owl"; 
	 
	 
	 public OntologyAlignment(){
		 
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
	 * Question 3
	 * 
	 * propulate()
	 * 
	 * Query one or several RDF store(s) via their
	 * SPARQL endpoints using Jena API. Use the data 
	 * obtained to populate your ontology 
	 * (adding instances). 
	 */
	 
	public void propulate(){

		 //Question 2.1
		
		 //DBpedia SPARQL endpoint 
		 String sparqlEndpoint="http://dbpedia.org/sparql";		 
		 //use your own SPARQL
		 String sparql = "SELECT ?s ?p ?o WHERE {?s ?p ?o} LIMIT 10";		 
		 Query query = QueryFactory.create(sparql);
	     QueryExecution qexec =  QueryExecutionFactory.sparqlService(sparqlEndpoint, query);
	     
	     //Complete this method....
		 
	 }
	
	
	
	 
	 /**
	  * 
	  *  Question 3
	  * 
	  *  createRelationships()
	  * 
	  *  Adding Datatype/Object Property values to
	  *  the individuals
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
		 
		 OntologyAlignment app=new OntologyAlignment();
		 app.propulate();
		 app.createRelationships();
		 app.save();	 
		 
	 }

	  
	  
	  
}
