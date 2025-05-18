package RelationBinaire;

import Couple.Couple;
import java.util.Set;

/**
 * This interface represents a binary relation in mathematics.
 * It is used to represent a relation between two sets of objects.
 * @param <T> the type of the elements of the relation
 */
public interface Relation<T> {

    /**
     * This method checks if the binary relation is reflexive.
     * A relation R is reflexive if for all (a, b) in R, (a, a) and (b, b) is also in R.
     * @return true if reflexive, false otherwise
     */
    public abstract boolean estReflexive();

    /**
     * This method checks if the binary relation is symmetric.
     * A relation R is symmetric if for all (a, b) in R, (b, a) is also in R.
     * @return true if symmetric, false otherwise
     */
    public abstract boolean estSymetrique();

    /**
     * This method checks if the binary relation is antisymmetric.
     * A relation R is antisymmetric if for all (a, b) and (b, a) in R, a == b.
     * @return true if antisymmetric, false otherwise
     */
    public abstract boolean estAntisymetrique();

    /**
     * This method checks if the binary relation is transitive.
     * A relation R is transitive if for all (a, b) and (b, c) in R, (a, c) is also in R.
     * @return true if transitive, false otherwise
     */
    public abstract boolean estTransitive();

    /**
     * This method returns the cardinal of the relation (the number of elements in the relation).
     * @param cpl the couple to check
     * @param <T> the type of the elements of the relation
     * @return the cardinal of the relation
     */
    public abstract <T> boolean contient(Couple<T> cpl);

    /**
     * This method returns the elements of the relation.
     * @param <T> the type of the elements of the relation
     * @return the elements of the relation
     */
    public abstract <T> Set<Couple<T>> elements();

    /**
     * This method returns the hash code of the relation.
     * @return the hash code of the relation
     */
    public abstract String toString();
}
