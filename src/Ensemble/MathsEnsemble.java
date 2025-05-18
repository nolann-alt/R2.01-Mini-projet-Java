package Ensemble;

import Couple.Couple;
import Couple.MathsCouple;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class implements a mathematical set of objects.
 * It implements the Ensemble interface.
 * It uses a LinkedHashSet to store the elements of the set.
 * @param <T> the type of the elements of the set
 */
public class MathsEnsemble<T> implements Ensemble<T> {
    /** The set of elements that this class implements */
    private Set<T> ens;

    /**
     * Constructor of the class
     * @param elements the elements to add to the set
     */
    public MathsEnsemble(Collection<T> elements) {
        if (elements == null) {
            throw new NullPointerException("Les elements ne doivent pas être null !");
        }

        this.ens = new LinkedHashSet<>();
        for (T elt : elements) {
            if (elt == null) {
                throw new IllegalArgumentException("Les ensembles ne peuvent pas contenir des éléments null !");
            }
            this.ens.add(elt);
        }
    }

    @Override
    /**
     * This method returns the cardinal of the set (the number of elements in the set).
     * @return the cardinal of the set
     */
    public int cardinal() {
        return this.ens.size();
    }

    @Override
    /**
     * This method checks if the set contains a given element, true if it does, false otherwise.
     * @param element the element to check
     * @return true if the set contains the element, false otherwise
     */
    public boolean contient(T element) {
        return this.ens.contains(element);
    }

    @Override
    /**
     * This method returns the union of the set with another set.
     * It creates a new set that contains all the elements of both sets.
     * @param autre the other set to union with
     * @return a new set that contains all the elements of both sets
     */
    public Ensemble<T> union(Ensemble<T> autre) {
        MathsEnsemble<T> ret = new MathsEnsemble<>(this.ens);

        // On vérifie si l'autre ensemble est de type MathsEnsemble, si oui on l'ajoute à l'ensemble
        if (autre instanceof MathsEnsemble<T> autreEnsemble) {
            ret.ens.addAll(autreEnsemble.ens);
        }
        return ret;
    }

    @Override
    /**
     * This method returns the intersection of the set with another set.
     * It creates a new set that contains only the elements that are in both sets.
     * @param autre the other set to intersect with
     * @return a new set that contains only the elements that are in both sets
     */
    public Ensemble<T> intersection(Ensemble<T> autre) {
        LinkedHashSet<T> result = new LinkedHashSet<>();
        MathsEnsemble<T> autreEnsemble = (MathsEnsemble<T>) autre;
        for (T elt : autreEnsemble.ens) {
            if (this.ens.contains(elt)) {
                result.add(elt);
            }
        }
        Ensemble<T> inter = new MathsEnsemble<>(result);
        return inter;
    }

    @Override
    /**
     * This method returns the difference of the set with another set.
     * It creates a new set that contains only the elements that are in this set but not in the other set.
     * @param autre the other set to difference with
     * @return a new set that contains only the elements that are in this set but not in the other set
     */
    public Ensemble<T> difference(Ensemble<T> autre) {
        LinkedHashSet<T> leHset = new LinkedHashSet<>();
        MathsEnsemble<T> autreEnsemble = (MathsEnsemble<T>) autre;
        for (T elt : this.ens) {
            if ( ! autreEnsemble.contient(elt)) {
                leHset.add(elt);
            }
        }
        Ensemble<T> ret = new MathsEnsemble<>(leHset);
        return ret;
    }

    @Override
    /**
     * This method returns the symmetric difference of the set with another set.
     * It creates a new set that contains only the elements that are in either set but not in both.
     * @param autre the other set to symmetric difference with
     * @return a new set that contains only the elements that are in either set but not in both
     */
    public Ensemble<T> diffSymetrique(Ensemble<T> autre) {
        LinkedHashSet<T> leHset = new LinkedHashSet<>();
        MathsEnsemble<T> autreEnsemble = (MathsEnsemble<T>) autre;
        for (T elt : this.ens) {
            if ( !autreEnsemble.contient(elt)) {
                leHset.add(elt);
            }
        }
        for (T elt : autreEnsemble.ens) {
            if ( !this.contient(elt)) {
                leHset.add(elt);
            }
        }
        Ensemble<T> ret = new MathsEnsemble<>(leHset);
        return ret;
    }

    @Override
    /**
     * This method returns the Cartesian product of the set with another set.
     * It creates a new set that contains all the pairs of elements from both sets.
     * @param autre the other set to product with
     * @return a new set that contains all the pairs of elements from both sets
     */
    public Ensemble<Couple<T>> produitCartesien(Ensemble<T> autre) {
        Set<Couple<T>> ret = new LinkedHashSet<>();
        for (T elt1 : this.elements()) {
            for (T elt2 : autre.elements()) {
                ret.add(new MathsCouple<T>(elt1, elt2));
            }
        }
        return new MathsEnsemble<>(ret);
    }

    @Override
    /**
     * This method allow to the user to see the elements of the set as he wants
     * @return a set of elements
     */
    public Set<T> elements() {
        LinkedHashSet<T> ret = new LinkedHashSet<>();
        for (T elt : this.ens) {
            ret.add(elt);
        }
        return ret;
    }

    /**
     * This method returns a string representation of the set
     * @return the set as a string
     */
    @Override
    public String toString() {
        String ret = "L'ensemble est le suivant : " + this.ens;
        return ret;
    }
}