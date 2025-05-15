package Couple;

public interface Couple<A, B> {

    public abstract A getPremier();

    public abstract B getDeuxieme();

    public abstract boolean equals(MathsCouple<A, B> otherCpl);

    @Override
    public abstract String toString();

    public abstract int hash();
}
