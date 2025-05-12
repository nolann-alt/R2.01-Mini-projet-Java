package Ensemble;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class MathsEnsemble<T> implements Ensemble<T> {
    private Set<T> ens;

    public MathsEnsemble(Collection<T> elements) {
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
        return this.ens.contains(element);
    }


    @Override
    public Ensemble<T> union(Ensemble<T> autre) {
        MathsEnsemble<T> ret = new MathsEnsemble<>(this.ens);

        // On vérifie si l'autre ensemble est de type MathsEnsemble, si oui on l'ajoute à l'ensemble
        if (autre instanceof MathsEnsemble<T> autreEnsemble) {
            ret.ens.addAll(autreEnsemble.ens);
        }
        return ret;
    }

    @Override
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
    public Ensemble<T> difference(Ensemble<T> autre) {
        LinkedHashSet<T> leHset = new LinkedHashSet<>();
        MathsEnsemble<T> autreEnsemble = (MathsEnsemble<T>) autre;
        for (T elt : autreEnsemble.ens) {
            if (this.ens.contains(elt)) {
                leHset.remove(elt);
            }
        }
        Ensemble<T> ret = new MathsEnsemble<>(leHset);
        return ret;
    }

    /*
    public Ensemble<Couple<T, T>> produitCartesien(Ensemble<T> autre) {

    }
    */

    public Set<T> elements() {
        LinkedHashSet<T> ret = new LinkedHashSet<>();
        for (T elt : this.ens) {
            ret.add(elt);
        }
        return ret;
    }
}