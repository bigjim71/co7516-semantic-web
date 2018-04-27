package com.boating.cs.impl;

import com.boating.cs.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultLeisureBoatRentalProvider <br>
 * @version generated on Mon Apr 16 16:18:00 CEST 2018 by fh231
 */
public class DefaultLeisureBoatRentalProvider extends WrappedIndividualImpl implements LeisureBoatRentalProvider {

    public DefaultLeisureBoatRentalProvider(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#belongsTo
     */
     
    public Collection<? extends Boat> getBelongsTo() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_BELONGSTO,
                                               DefaultBoat.class);
    }

    public boolean hasBelongsTo() {
	   return !getBelongsTo().isEmpty();
    }

    public void addBelongsTo(Boat newBelongsTo) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_BELONGSTO,
                                       newBelongsTo);
    }

    public void removeBelongsTo(Boat oldBelongsTo) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_BELONGSTO,
                                          oldBelongsTo);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#contact
     */
     
    public Collection<? extends Contact> getContact() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_CONTACT,
                                               DefaultContact.class);
    }

    public boolean hasContact() {
	   return !getContact().isEmpty();
    }

    public void addContact(Contact newContact) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_CONTACT,
                                       newContact);
    }

    public void removeContact(Contact oldContact) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_CONTACT,
                                          oldContact);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#rentalProviderBoats
     */
     
    public Collection<? extends Boat> getRentalProviderBoats() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_RENTALPROVIDERBOATS,
                                               DefaultBoat.class);
    }

    public boolean hasRentalProviderBoats() {
	   return !getRentalProviderBoats().isEmpty();
    }

    public void addRentalProviderBoats(Boat newRentalProviderBoats) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_RENTALPROVIDERBOATS,
                                       newRentalProviderBoats);
    }

    public void removeRentalProviderBoats(Boat oldRentalProviderBoats) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_RENTALPROVIDERBOATS,
                                          oldRentalProviderBoats);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#rentalProviderHomeHaven
     */
     
    public Collection<? extends Haven> getRentalProviderHomeHaven() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_RENTALPROVIDERHOMEHAVEN,
                                               DefaultHaven.class);
    }

    public boolean hasRentalProviderHomeHaven() {
	   return !getRentalProviderHomeHaven().isEmpty();
    }

    public void addRentalProviderHomeHaven(Haven newRentalProviderHomeHaven) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_RENTALPROVIDERHOMEHAVEN,
                                       newRentalProviderHomeHaven);
    }

    public void removeRentalProviderHomeHaven(Haven oldRentalProviderHomeHaven) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_RENTALPROVIDERHOMEHAVEN,
                                          oldRentalProviderHomeHaven);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#providerName
     */
     
    public Collection<? extends String> getProviderName() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_PROVIDERNAME, String.class);
    }

    public boolean hasProviderName() {
		return !getProviderName().isEmpty();
    }

    public void addProviderName(String newProviderName) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_PROVIDERNAME, newProviderName);
    }

    public void removeProviderName(String oldProviderName) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_PROVIDERNAME, oldProviderName);
    }


}