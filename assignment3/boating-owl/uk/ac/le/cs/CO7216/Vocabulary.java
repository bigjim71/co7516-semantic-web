package uk.ac.le.cs.CO7216;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * Vocabulary class to provide access to the Manchester OWL API representatives for 
 * various entities in the ontology used to generate this code.<p> 
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: ${javaClass}
 *
 * @version generated on Tue Mar 15 14:27:49 GMT 2016 by admin
 */

public class Vocabulary {

	private static final OWLDataFactory factory = OWLManager.createOWLOntologyManager().getOWLDataFactory();

    /* ***************************************************
     * Class http://www.cs.le.ac.uk/rdf#Lecturer
     */

    /**
     * A constant to give access to the Manchester OWL api representation of the class LECTURER.<p>
     * 
     */
    public static final OWLClass CLASS_LECTURER = factory.getOWLClass(IRI.create("http://www.cs.le.ac.uk/rdf#Lecturer"));

    /* ***************************************************
     * Class http://www.cs.le.ac.uk/rdf#Module
     */

    /**
     * A constant to give access to the Manchester OWL api representation of the class MODULE.<p>
     * 
     */
    public static final OWLClass CLASS_MODULE = factory.getOWLClass(IRI.create("http://www.cs.le.ac.uk/rdf#Module"));

    /* ***************************************************
     * Class http://www.cs.le.ac.uk/rdf#Person
     */

    /**
     * A constant to give access to the Manchester OWL api representation of the class PERSON.<p>
     * 
     */
    public static final OWLClass CLASS_PERSON = factory.getOWLClass(IRI.create("http://www.cs.le.ac.uk/rdf#Person"));

    /* ***************************************************
     * Class http://www.cs.le.ac.uk/rdf#Student
     */

    /**
     * A constant to give access to the Manchester OWL api representation of the class STUDENT.<p>
     * 
     */
    public static final OWLClass CLASS_STUDENT = factory.getOWLClass(IRI.create("http://www.cs.le.ac.uk/rdf#Student"));

    /* ***************************************************
     * Object Property http://www.cs.le.ac.uk/rdf#hasFriend
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the object property HASFRIEND.<p>
     * 
     */
    public static final OWLObjectProperty OBJECT_PROPERTY_HASFRIEND = factory.getOWLObjectProperty(IRI.create("http://www.cs.le.ac.uk/rdf#hasFriend"));

    /* ***************************************************
     * Object Property http://www.cs.le.ac.uk/rdf#knows
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the object property KNOWS.<p>
     * 
     */
    public static final OWLObjectProperty OBJECT_PROPERTY_KNOWS = factory.getOWLObjectProperty(IRI.create("http://www.cs.le.ac.uk/rdf#knows"));

    /* ***************************************************
     * Object Property http://www.cs.le.ac.uk/rdf#study
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the object property STUDY.<p>
     * 
     */
    public static final OWLObjectProperty OBJECT_PROPERTY_STUDY = factory.getOWLObjectProperty(IRI.create("http://www.cs.le.ac.uk/rdf#study"));

    /* ***************************************************
     * Object Property http://www.cs.le.ac.uk/rdf#teach
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the object property TEACH.<p>
     * 
     */
    public static final OWLObjectProperty OBJECT_PROPERTY_TEACH = factory.getOWLObjectProperty(IRI.create("http://www.cs.le.ac.uk/rdf#teach"));

    /* ***************************************************
     * Data Property http://www.cs.le.ac.uk/rdf#has_age
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the data property HAS_AGE.<p>
     * 
     */
    public static final OWLDataProperty DATA_PROPERTY_HAS_AGE = factory.getOWLDataProperty(IRI.create("http://www.cs.le.ac.uk/rdf#has_age"));

    /* ***************************************************
     * Data Property http://www.cs.le.ac.uk/rdf#has_email
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the data property HAS_EMAIL.<p>
     * 
     */
    public static final OWLDataProperty DATA_PROPERTY_HAS_EMAIL = factory.getOWLDataProperty(IRI.create("http://www.cs.le.ac.uk/rdf#has_email"));

    /* ***************************************************
     * Data Property http://www.cs.le.ac.uk/rdf#has_full_name
     */
     
    /**
     * A constant to give access to the Manchester OWL API representation of the data property HAS_FULL_NAME.<p>
     * 
     */
    public static final OWLDataProperty DATA_PROPERTY_HAS_FULL_NAME = factory.getOWLDataProperty(IRI.create("http://www.cs.le.ac.uk/rdf#has_full_name"));


}
