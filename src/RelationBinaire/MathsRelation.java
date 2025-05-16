package RelationBinaire;

import Couple.Couple;
import Couple.MathsCouple;
import Ensemble.Ensemble;

import java.util.LinkedHashSet;
import java.util.Set;

public class MathsRelation<T> {

    private Set<Couple<T, T>> relabi;

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

    public boolean estTransitive() {
        boolean transitive = true;
        T first;
        T second;
        T third;
        for (Couple<T, T> cpl : this.relabi) {
            first = cpl.getPremier();
            second = cpl.getDeuxieme();
            if (!this.relabi.contains(new MathsCouple<T, T>(first, third)) && !this.relabi.contains(new MathsCouple<T, T>(third, second))) {
                transitive = false;
            }
        }
        return transitive;
    }
}