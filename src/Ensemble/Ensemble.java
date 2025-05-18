package Ensemble;

import Couple.Couple;
import java.util.Set;

/**
 * This interface represents a mathematical set of objects.
 * It is used to represent a set of objects.
 * @param <T> the type of the elements of the set
 */
public interface Ensemble<T> {

    /**
     * This method returns the cardinal of the set (the number of elements in the set).
     * @return the cardinal of the set
     */
    public abstract int cardinal();

    /**
     * This method checks if the set contains a given element, true if it does, false otherwise.
     * @param element the element to check
     * @return true if the set contains the element, false otherwise
     */
    public abstract boolean contient(T element);

    /**
     * This method returns the union of the set with another set.
     * It creates a new set that contains all the elements of both sets.
     * @param autre the other set to union with
     * @return the union of the two sets
     */
    public abstract Ensemble<T> union(Ensemble<T> autre);

    /**
     * This method returns the intersection of the set with another set.
     * It creates a new set that contains only the elements that are in both sets.
     * @param autre the other set to intersect with
     * @return the intersection of the two sets
     */
    public abstract Ensemble<T> intersection(Ensemble<T> autre);

    /**
     * This method returns the difference of the set with another set.
     * It creates a new set that contains only the elements that are in this set but not in the other set.
     * @param autre the other set to difference with
     * @return the difference of the two sets
     */
    public abstract Ensemble<T> difference(Ensemble<T> autre);

    /**
     * This method returns the Cartesian product of the set with another set.
     * It creates a new set that contains all the pairs of elements from both sets.
     * @param autre the other set to product with
     * @return the Cartesian product of the two sets
     */
    public abstract Ensemble<Couple<T>> produitCartesien(Ensemble<T> autre);

    /**
     * This method returns the elements of the set.
     * @return the elements of the set
     */
    public abstract Set<T> elements();

    /**
     * This method returns a string representation of the set.
     * @return a string representation of the set
     */
    public abstract String toString();
}