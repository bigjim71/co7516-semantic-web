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
 * Source Class: DefaultTug <br>
 * @version generated on Mon Apr 16 16:18:00 CEST 2018 by fh231
 */
public class DefaultTug extends WrappedIndividualImpl implements Tug {

    public DefaultTug(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#boatType
     */
     
    public Collection<? extends WrappedIndividual> getBoatType() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_BOATTYPE,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasBoatType() {
	   return !getBoatType().isEmpty();
    }

    public void addBoatType(WrappedIndividual newBoatType) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_BOATTYPE,
                                       newBoatType);
    }

    public void removeBoatType(WrappedIndividual oldBoatType) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_BOATTYPE,
                                          oldBoatType);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#engine
     */
     
    public Collection<? extends Engine> getEngine() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ENGINE,
                                               DefaultEngine.class);
    }

    public boolean hasEngine() {
	   return !getEngine().isEmpty();
    }

    public void addEngine(Engine newEngine) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ENGINE,
                                       newEngine);
    }

    public void removeEngine(Engine oldEngine) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ENGINE,
                                          oldEngine);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#isBiggerThan
     */
     
    public Collection<? extends Boat> getIsBiggerThan() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ISBIGGERTHAN,
                                               DefaultBoat.class);
    }

    public boolean hasIsBiggerThan() {
	   return !getIsBiggerThan().isEmpty();
    }

    public void addIsBiggerThan(Boat newIsBiggerThan) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ISBIGGERTHAN,
                                       newIsBiggerThan);
    }

    public void removeIsBiggerThan(Boat oldIsBiggerThan) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ISBIGGERTHAN,
                                          oldIsBiggerThan);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#isCommercial
     */
     
    public Collection<? extends WrappedIndividual> getIsCommercial() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ISCOMMERCIAL,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIsCommercial() {
	   return !getIsCommercial().isEmpty();
    }

    public void addIsCommercial(WrappedIndividual newIsCommercial) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ISCOMMERCIAL,
                                       newIsCommercial);
    }

    public void removeIsCommercial(WrappedIndividual oldIsCommercial) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ISCOMMERCIAL,
                                          oldIsCommercial);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#isLeisure
     */
     
    public Collection<? extends WrappedIndividual> getIsLeisure() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ISLEISURE,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIsLeisure() {
	   return !getIsLeisure().isEmpty();
    }

    public void addIsLeisure(WrappedIndividual newIsLeisure) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ISLEISURE,
                                       newIsLeisure);
    }

    public void removeIsLeisure(WrappedIndividual oldIsLeisure) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ISLEISURE,
                                          oldIsLeisure);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#motors
     */
     
    public Collection<? extends MotorBoat> getMotors() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_MOTORS,
                                               DefaultMotorBoat.class);
    }

    public boolean hasMotors() {
	   return !getMotors().isEmpty();
    }

    public void addMotors(MotorBoat newMotors) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_MOTORS,
                                       newMotors);
    }

    public void removeMotors(MotorBoat oldMotors) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_MOTORS,
                                          oldMotors);
    }


    /* ***************************************************
     * Object Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#sails
     */
     
    public Collection<? extends SailingBoat> getSails() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_SAILS,
                                               DefaultSailingBoat.class);
    }

    public boolean hasSails() {
	   return !getSails().isEmpty();
    }

    public void addSails(SailingBoat newSails) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_SAILS,
                                       newSails);
    }

    public void removeSails(SailingBoat oldSails) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_SAILS,
                                          oldSails);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#boatLength
     */
     
    public Collection<? extends Integer> getBoatLength() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_BOATLENGTH, Integer.class);
    }

    public boolean hasBoatLength() {
		return !getBoatLength().isEmpty();
    }

    public void addBoatLength(Integer newBoatLength) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_BOATLENGTH, newBoatLength);
    }

    public void removeBoatLength(Integer oldBoatLength) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_BOATLENGTH, oldBoatLength);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#boatName
     */
     
    public Collection<? extends String> getBoatName() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_BOATNAME, String.class);
    }

    public boolean hasBoatName() {
		return !getBoatName().isEmpty();
    }

    public void addBoatName(String newBoatName) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_BOATNAME, newBoatName);
    }

    public void removeBoatName(String oldBoatName) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_BOATNAME, oldBoatName);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#color
     */
     
    public Collection<? extends Object> getColor() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COLOR, Object.class);
    }

    public boolean hasColor() {
		return !getColor().isEmpty();
    }

    public void addColor(Object newColor) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COLOR, newColor);
    }

    public void removeColor(Object oldColor) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COLOR, oldColor);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#engineSize
     */
     
    public Collection<? extends Integer> getEngineSize() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ENGINESIZE, Integer.class);
    }

    public boolean hasEngineSize() {
		return !getEngineSize().isEmpty();
    }

    public void addEngineSize(Integer newEngineSize) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ENGINESIZE, newEngineSize);
    }

    public void removeEngineSize(Integer oldEngineSize) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ENGINESIZE, oldEngineSize);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#hasBoat
     */
     
    public Collection<? extends Integer> getHasBoat() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASBOAT, Integer.class);
    }

    public boolean hasHasBoat() {
		return !getHasBoat().isEmpty();
    }

    public void addHasBoat(Integer newHasBoat) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASBOAT, newHasBoat);
    }

    public void removeHasBoat(Integer oldHasBoat) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASBOAT, oldHasBoat);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#hasEngine
     */
     
    public Collection<? extends Boolean> getHasEngine() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASENGINE, Boolean.class);
    }

    public boolean hasHasEngine() {
		return !getHasEngine().isEmpty();
    }

    public void addHasEngine(Boolean newHasEngine) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASENGINE, newHasEngine);
    }

    public void removeHasEngine(Boolean oldHasEngine) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASENGINE, oldHasEngine);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#requiresCrew
     */
     
    public Collection<? extends Integer> getRequiresCrew() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_REQUIRESCREW, Integer.class);
    }

    public boolean hasRequiresCrew() {
		return !getRequiresCrew().isEmpty();
    }

    public void addRequiresCrew(Integer newRequiresCrew) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_REQUIRESCREW, newRequiresCrew);
    }

    public void removeRequiresCrew(Integer oldRequiresCrew) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_REQUIRESCREW, oldRequiresCrew);
    }


    /* ***************************************************
     * Data Property http://www.co7516coursework1.com/jl571/OntologyJl571.rdf#sleepingSpaces
     */
     
    public Collection<? extends Integer> getSleepingSpaces() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SLEEPINGSPACES, Integer.class);
    }

    public boolean hasSleepingSpaces() {
		return !getSleepingSpaces().isEmpty();
    }

    public void addSleepingSpaces(Integer newSleepingSpaces) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SLEEPINGSPACES, newSleepingSpaces);
    }

    public void removeSleepingSpaces(Integer oldSleepingSpaces) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SLEEPINGSPACES, oldSleepingSpaces);
    }


}
