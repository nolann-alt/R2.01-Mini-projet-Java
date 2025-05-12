package Ensemble;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class MathsEnsemble<T> implements Ensemble<T> {
    private Set<T> ens;

    public MathsEnsemble(T[] elements) {
        ens = new LinkedHashSet<>();

        try {
            for (T elt : elements) {
                ens.add(elt);
            }
        } catch (NullPointerException err) {
            System.out.printf(err.getMessage());
        }
    }

    @Override
    public int cardinal() {
        return this.ens.size();
    }

    @Override
    public boolean contient(T element) {
        boolean ret = false;

        for (T elt : this.ens) {
            if (elt == element) {
                ret = true;
            }
        }
        return ret;
    }



    @Override
    public Ensemble<T> union(Ensemble<T> autre) {
        LinkedHashSet<T> ret = new LinkedHashSet<>(ens);
        for (T element : this.ens) {
            ret.add(autre);
        }


        return ret;
    }

    @Override
    public Ensemble<T> intersection(Ensemble<T> autre) {
        LinkedHashSet<T> intersection = new LinkedHashSet<>();
        for (T elt : autre.ens) {
            if (this.ens.contains(elt)) {
                intersection.add(elt);
            }
        }
    }


}