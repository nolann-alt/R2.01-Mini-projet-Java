package Ensemble;

import Couple.Couple;
import java.util.Objects;
import java.util.Set;

public interface Ensemble<T> {

    public abstract int cardinal();

    public abstract boolean contient(T element);

    public abstract Ensemble<T> union(Ensemble<T> autre);

    public abstract Ensemble<T> intersection(Ensemble<T> autre);

    public abstract Ensemble<T> difference(Ensemble<T> autre);

    public abstract Ensemble<Couple<T, T>> produitCartesien(Ensemble<T> autre);

    public abstract Set<T> elements();

    public abstract String toString();
}