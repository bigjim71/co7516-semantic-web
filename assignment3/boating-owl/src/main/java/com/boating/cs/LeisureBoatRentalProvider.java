package com.boating.cs;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: LeisureBoatRentalProvider <br>
 * @version generated on Mon Apr 16 16:18:00 CEST 2018 by fh231
 */

public interface LeisureBoatRentalProvider extends BoatRentalProvider {

    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#belongsTo
     */
     
    /**
     * Gets all property values for the belongsTo property.<p>
     * 
     * @returns a collection of values for the belongsTo property.
     */
    Collection<? extends Boat> getBelongsTo();

    /**
     * Checks if the class has a belongsTo property value.<p>
     * 
     * @return true if there is a belongsTo property value.
     */
    boolean hasBelongsTo();

    /**
     * Adds a belongsTo property value.<p>
     * 
     * @param newBelongsTo the belongsTo property value to be added
     */
    void addBelongsTo(Boat newBelongsTo);

    /**
     * Removes a belongsTo property value.<p>
     * 
     * @param oldBelongsTo the belongsTo property value to be removed.
     */
    void removeBelongsTo(Boat oldBelongsTo);


    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#contact
     */
     
    /**
     * Gets all property values for the contact property.<p>
     * 
     * @returns a collection of values for the contact property.
     */
    Collection<? extends Contact> getContact();

    /**
     * Checks if the class has a contact property value.<p>
     * 
     * @return true if there is a contact property value.
     */
    boolean hasContact();

    /**
     * Adds a contact property value.<p>
     * 
     * @param newContact the contact property value to be added
     */
    void addContact(Contact newContact);

    /**
     * Removes a contact property value.<p>
     * 
     * @param oldContact the contact property value to be removed.
     */
    void removeContact(Contact oldContact);


    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#rentalProviderBoats
     */
     
    /**
     * Gets all property values for the rentalProviderBoats property.<p>
     * 
     * @returns a collection of values for the rentalProviderBoats property.
     */
    Collection<? extends Boat> getRentalProviderBoats();

    /**
     * Checks if the class has a rentalProviderBoats property value.<p>
     * 
     * @return true if there is a rentalProviderBoats property value.
     */
    boolean hasRentalProviderBoats();

    /**
     * Adds a rentalProviderBoats property value.<p>
     * 
     * @param newRentalProviderBoats the rentalProviderBoats property value to be added
     */
    void addRentalProviderBoats(Boat newRentalProviderBoats);

    /**
     * Removes a rentalProviderBoats property value.<p>
     * 
     * @param oldRentalProviderBoats the rentalProviderBoats property value to be removed.
     */
    void removeRentalProviderBoats(Boat oldRentalProviderBoats);


    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#rentalProviderHomeHaven
     */
     
    /**
     * Gets all property values for the rentalProviderHomeHaven property.<p>
     * 
     * @returns a collection of values for the rentalProviderHomeHaven property.
     */
    Collection<? extends Haven> getRentalProviderHomeHaven();

    /**
     * Checks if the class has a rentalProviderHomeHaven property value.<p>
     * 
     * @return true if there is a rentalProviderHomeHaven property value.
     */
    boolean hasRentalProviderHomeHaven();

    /**
     * Adds a rentalProviderHomeHaven property value.<p>
     * 
     * @param newRentalProviderHomeHaven the rentalProviderHomeHaven property value to be added
     */
    void addRentalProviderHomeHaven(Haven newRentalProviderHomeHaven);

    /**
     * Removes a rentalProviderHomeHaven property value.<p>
     * 
     * @param oldRentalProviderHomeHaven the rentalProviderHomeHaven property value to be removed.
     */
    void removeRentalProviderHomeHaven(Haven oldRentalProviderHomeHaven);


    /* ***************************************************
     * Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#providerName
     */
     
    /**
     * Gets all property values for the providerName property.<p>
     * 
     * @returns a collection of values for the providerName property.
     */
    Collection<? extends String> getProviderName();

    /**
     * Checks if the class has a providerName property value.<p>
     * 
     * @return true if there is a providerName property value.
     */
    boolean hasProviderName();

    /**
     * Adds a providerName property value.<p>
     * 
     * @param newProviderName the providerName property value to be added
     */
    void addProviderName(String newProviderName);

    /**
     * Removes a providerName property value.<p>
     * 
     * @param oldProviderName the providerName property value to be removed.
     */
    void removeProviderName(String oldProviderName);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
