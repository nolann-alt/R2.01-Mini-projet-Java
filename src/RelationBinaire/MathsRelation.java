package RelationBinaire;

import Couple.Couple;
import Couple.MathsCouple;
import Ensemble.Ensemble;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class offering basic operations on binary relations in maths
 * @param <T> generic type
 */
public class MathsRelation<T> implements Relation<T> {

    /**
     * relabi --> the binary relation (final)
     */
    private final Set<Couple<T>> relabi;

    /**
     * Constructor of MathsRelation
     * @param uneRelation a set of pairs
     */
    public MathsRelation(Ensemble<Couple<T>> uneRelation) {
        if (uneRelation == null) {
            throw new NullPointerException("La relation ne peut pas être null !");
        }
        this.relabi = new LinkedHashSet<>();
        // Vérification des éléments avant l'ajout pour éviter les null
        for (Couple<T> cpl : uneRelation.elements()) {
            if (cpl == null) {
                throw new IllegalArgumentException("Les relations ne peuvent pas contenir des éléments null !");
            }
            this.relabi.add(cpl);
        }
    }

    @Override
    /**
     * Checks if the binary relation is reflexive
     * A relation R is reflexive if for all (a, b) in R, (a, a) and (b, b) is also in R
     * @return true if reflexive, false otherwise
     */
    public boolean estReflexive() {
        boolean reflexif = true;
        T first;
        T second;
        for (Couple<T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if ( ! this.relabi.contains(new MathsCouple<T>(first, first)) ) { // if the relation doesn't contain the couple (x, x) then it's not reflexive
                reflexif = false;
            } else if ( ! this.relabi.contains(new MathsCouple<T>(second, second)) ) {
                reflexif = false;
            }
        }
        return reflexif;
    }

    @Override
    /**
     * Checks if the binary relation is symmetric
     * A relation R is symmetric if for all (a, b) in R, (b, a) is also in R
     * @return true if symmetric, false otherwise
     */
    public boolean estSymetrique() {
        boolean symetrique = true;
        T first;
        T second;
        for (Couple<T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if ( ! this.relabi.contains(new MathsCouple<T>(second, first))) {
                symetrique = false;
            }
        }
        return symetrique;
    }

    @Override
    /**
     * Checks if the binary relation is antisymmetric
     * A relation R is antisymmetric if for all (a, b) and (b, a) in R, a == b
     * @return true if antisymmetric, false otherwise
     */
    public boolean estAntisymetrique() {
        boolean antisymetrique = true;
        T first;
        T second;
        for (Couple<T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if (this.relabi.contains(new MathsCouple<T>(second, first)) && ! first.equals(second)) {
                antisymetrique = false;
            }
        }
        return antisymetrique;
    }

    @Override
    /**
     * Checks if the binary relation is transitive
     * A relation R is transitive if for all (a, b) and (b, c) in R then (a, c) is also in R.
     * @return true if transitive, false otherwise
     */
    public boolean estTransitive() {
        boolean transitive = true;
        T first, second, third; // a, b, c
        for (Couple<T> cpl : this.relabi) { // couple (a, b)
            first = cpl.getPremier(); // a
            second = cpl.getDeuxieme(); // b
            for (Couple<T> cpl1 : this.relabi) {
                if ( cpl1.getPremier().equals(second) ) { // couple (b, x)
                    third = cpl1.getDeuxieme(); // c = x
                    MathsCouple<T> coupleTransitif = new MathsCouple<T>(first, third); // (a, x) --> chemin "raccourcis"
                    if ( ! this.relabi.contains(coupleTransitif) ) {
                        transitive = false;
                    }
                }
            }
        }
        return transitive;
    }

    @Override
    /**
     * This method checks whether the pair is in relabi
     * @param cpl the couple to check
     * @return true if the pair is in relabi, false otherwise
     */
    public <T> boolean contient(Couple<T> cpl) {
        return this.relabi.contains(cpl);
    }

    @Override
    /**
     * Send to user the binary relation
     * @return a copy of the binary relation
     */
    public Set<Couple<T>> elements() {
        LinkedHashSet<Couple<T>> ret = new LinkedHashSet<>();
        for (Couple<T> cpl : this.relabi) {
            ret.add(cpl);
        }
        return ret;
    }

    @Override
    /**
     * Redefinition of the toString method for the binary relation
     * @return a display of the binary relation
     */
    public String toString() {
        String ret =  "La relation binaire : " + this.relabi;
        return ret;
    }
}