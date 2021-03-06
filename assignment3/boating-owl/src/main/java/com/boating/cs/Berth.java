package com.boating.cs;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Berth <br>
 * @version generated on Mon Apr 16 16:18:00 CEST 2018 by fh231
 */

public interface Berth extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#locatedIn
     */
     
    /**
     * Gets all property values for the locatedIn property.<p>
     * 
     * @returns a collection of values for the locatedIn property.
     */
    Collection<? extends Haven> getLocatedIn();

    /**
     * Checks if the class has a locatedIn property value.<p>
     * 
     * @return true if there is a locatedIn property value.
     */
    boolean hasLocatedIn();

    /**
     * Adds a locatedIn property value.<p>
     * 
     * @param newLocatedIn the locatedIn property value to be added
     */
    void addLocatedIn(Haven newLocatedIn);

    /**
     * Removes a locatedIn property value.<p>
     * 
     * @param oldLocatedIn the locatedIn property value to be removed.
     */
    void removeLocatedIn(Haven oldLocatedIn);


    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#berthMaxLength
     */
     
    /**
     * Gets all property values for the berthMaxLength property.<p>
     * 
     * @returns a collection of values for the berthMaxLength property.
     */
    Collection<? extends Integer> getBerthMaxLength();

    /**
     * Checks if the class has a berthMaxLength property value.<p>
     * 
     * @return true if there is a berthMaxLength property value.
     */
    boolean hasBerthMaxLength();

    /**
     * Adds a berthMaxLength property value.<p>
     * 
     * @param newBerthMaxLength the berthMaxLength property value to be added
     */
    void addBerthMaxLength(Integer newBerthMaxLength);

    /**
     * Removes a berthMaxLength property value.<p>
     * 
     * @param oldBerthMaxLength the berthMaxLength property value to be removed.
     */
    void removeBerthMaxLength(Integer oldBerthMaxLength);



    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#berthName
     */
     
    /**
     * Gets all property values for the berthName property.<p>
     * 
     * @returns a collection of values for the berthName property.
     */
    Collection<? extends String> getBerthName();

    /**
     * Checks if the class has a berthName property value.<p>
     * 
     * @return true if there is a berthName property value.
     */
    boolean hasBerthName();

    /**
     * Adds a berthName property value.<p>
     * 
     * @param newBerthName the berthName property value to be added
     */
    void addBerthName(String newBerthName);

    /**
     * Removes a berthName property value.<p>
     * 
     * @param oldBerthName the berthName property value to be removed.
     */
    void removeBerthName(String oldBerthName);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
