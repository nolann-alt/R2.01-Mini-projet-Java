package Couple;

public interface Couple<T> {

    public abstract T getPremier();

    public abstract T getDeuxieme();

    public abstract boolean equals(MathsCouple<T> otherCpl);

    @Override
    public abstract String toString();

    public abstract int hash();
}
