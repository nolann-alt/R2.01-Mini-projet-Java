package RelationBinaire;

import Couple.Couple;
import Couple.MathsCouple;
import Ensemble.Ensemble;

import java.util.LinkedHashSet;
import java.util.Set;

public class MathsRelation<T> {

    private final Set<Couple<T, T>> relabi;

    public MathsRelation(Ensemble<Couple<T, T>> uneRelation) {
        this.relabi = new LinkedHashSet<>();

        try {
            for (Couple<T, T> cpl : uneRelation.elements()) {
                this.relabi.add(cpl);
            }
        } catch (NullPointerException err) {
            System.out.println(err.getMessage());
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    public boolean estReflexive() {
        boolean reflexif = true;
        T first;
        T second;
        for (Couple<T, T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if ( ! this.relabi.contains(new MathsCouple<>(first, first)) ) { // if the relation doesn't contains the couple (x, x) then it's not reflexive
                reflexif = false;
            } else if ( ! this.relabi.contains(new MathsCouple<>(second, second)) ) {
                reflexif = false;
            }
        }
        return reflexif;
    }

    public boolean estSymetrique() {
        boolean symetrique = true;
        T first;
        T second;
        for (Couple<T, T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if ( ! this.relabi.contains(new MathsCouple<T, T>(second, first))) {
                symetrique = false;
            }
        }
        return symetrique;
    }

    /**
     * Checks if the binary relation is antisymmetric
     * A relation R is antisymmetric if for all (a, b) and (b, a) in R, a == b
     * @return true if antisymmetric, false otherwise
     */
    public boolean estAntisymetrique() {
        boolean antisymetrique = true;
        T first;
        T second;
        for (Couple<T, T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if (this.relabi.contains(new MathsCouple<T, T>(second, first)) && ! first.equals(second)) {
                antisymetrique = false;
            }
        }
        return antisymetrique;
    }

    /**
     * Checks if the binary relation is transitive
     * A relation R is transitive if for all (a, b) and (b, c) in R then (a, c) is also in R.
     * @return true if transitive, false otherwise
     */
    public boolean estTransitive() {
        boolean transitive = true;
        T first, second, third; // a, b, c
        for (Couple<T, T> cpl : this.relabi) { // couple (a, b)
            first = cpl.getPremier(); // a
            second = cpl.getDeuxieme(); // b
            for (Couple<T, T> cpl1 : this.relabi) {
                if ( cpl1.getPremier().equals(second) ) { // couple (b, x)
                    third = cpl1.getDeuxieme(); // c = x
                    MathsCouple<T, T> coupleTransitif = new MathsCouple<>(first, third); // (a, x) --> chemin "raccourcis"
                    if ( ! this.relabi.contains(coupleTransitif) ) {
                        transitive = false;
                    }
                }
            }
        }
        return transitive;
    }


    /**
     * Check if the relation contains a specific pair
     * @param cpl the pair
     * @return true if the relation contains the pair in parameters
     */
    public boolean contient(Couple<T, T> cpl) {
        return this.relabi.contains(cpl);
    }

    /**
     * Send to user the binary relation
     * @return a copy of the binary relation
     */
    public Set<Couple<T, T>> elements() {
        LinkedHashSet<Couple<T, T>> ret = new LinkedHashSet<>();
        for (Couple<T, T> cpl : this.relabi) {
            ret.add(cpl);
        }
        return ret;
    }
}