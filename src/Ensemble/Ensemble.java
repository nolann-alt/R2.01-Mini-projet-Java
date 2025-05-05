package Ensemble;

import java.util.Set;

interface Ensemble<T> extends Set {

    static int cardinal() {

    }

    public boolean contient(T element) {

    }

    Ensemble<T> union(Ensemble<T> autre) {

    }

    Ensemble<T> intersection(Ensemble<T> autre) {

    }
    /*
    Ensemble<T> difference(Ensemble<T> autre) {

    }

    Ensemble<T> difference(Ensemble<T> autre) {

    }

    Ensemble<Couple<T, T» produitCartesien(Ensemble<T> autre) {

    }

    Set<T> elements() {

    }
    */

    /*
    @Override
    void equals() {

    }

    @Override
    String toString() {

    }

    @Override
    int hashCode() {

    }

     */


}