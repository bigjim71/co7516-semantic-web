package uk.ac.le.ac.demo;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import uk.ac.le.cs.CO7216.Lecturer;
import uk.ac.le.cs.CO7216.Module;
import uk.ac.le.cs.CO7216.OntFactory;
import uk.ac.le.cs.CO7216.Student;

public class OWLAPI {
	
	 OWLOntologyManager manager;
	 OWLOntology ont; 
	  public static final String ontology="University.owl";
	  public static final String ontology_save="University_saved.owl";
	 
	 public static void main(String[] args){
		 OWLAPI app= new OWLAPI();
		 app.ontologyDemo();
		 app.save(ontology_save);
		 
	 }
	 
	 public void ontologyDemo(){
		 
		 try{
		 
		  manager = OWLManager.createOWLOntologyManager();

		  File ontFile=new File(ontology);
          IRI iri = IRI.create(ontFile);           	 	            
          ont= manager.loadOntologyFromOntologyDocument(iri);
          System.out.println("Loaded ontology: " + ont);
         
          OntFactory factory=new OntFactory (ont);       
          String prefix="http://www.cs.le.ac.uk/rdf#";
          
          //create an instances of the class Student
          Student s4=factory.createStudent(prefix+"s4");
             //add DatatypeProperty values
	          s4.addHas_full_name("Linda");
	          s4.addHas_age(new Integer(25));
	          s4.addHas_email("linda@student.le.ac.uk");
	          
	      //create an instances of the class Lecturer   
          Lecturer l4=factory.createLecturer(prefix+"lecture4");
             //add DatatypeProperty values
	          l4.addHas_full_name("Thomas");
	          s4.addHas_age(new Integer(35));
	          s4.addHas_email("thomas@le.ac.uk");
	          
	      //create an instance of the class Module    
	      Module co7216=factory.createModule(prefix+"CO7216");       
	      //set ObjectProperty "hasFriend"
	         l4.addHasFriend(s4); 
		  //set ObjectProperty "teach"   
	         l4.addTeach(co7216);
		  //set ObjectProperty "study"   
	         s4.addStudy(co7216);
	             
	         
	     //get an existing individual http://www.cs.le.ac.uk/rdf#s4
	      Student someone=factory.getStudent(prefix+"s4");
	      
	      for(Module m: someone.getStudy()){
	    	  //getOwlIndividual return a named individual. See http://owlapi.sourceforge.net/javadoc/org/semanticweb/owlapi/model/OWLNamedIndividual.html
	    	  System.out.println(m.getOwlIndividual());
	      }
	       
         
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
		 
	 }
	 
	 public void save(String filepath){
			
			try{
			
			File file=new File(filepath);
			 manager.saveOntology(ont, IRI.create(file.toURI()));
			 System.out.println("Saved ontology: " + ont);
			 
			}catch(Exception ex){
				ex.printStackTrace();
			}
			 
		}		
		
	 
	 

}
