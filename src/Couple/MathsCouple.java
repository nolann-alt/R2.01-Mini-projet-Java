package Couple;

/**
 * Class which simulate the pair behaviors in mathematics
 * @param <T> frist object of the pair and second object of the pair
 */
public class MathsCouple<T> implements Couple<T> {

    /**
     * members of the pair --> final because there are immutable
     */
    private final T gauche;
    /**
     * members of the pair --> final because there are immutable
     */
    private final T droite;

    /**
     * Constructor of MathsCouple
     * @param first premier membre
     * @param second second membre
     */
    public MathsCouple(T first, T second) {
        if (first == null || second == null) {
            throw new NullPointerException("Erreur MathsCouple : les 2 membres du couple doivent être non null !");
        } else {
            this.gauche = first;
            this.droite = second;
        }
    }

    /**
     * Getter method of the first member
     * @return first member of the pair
     */
    @Override
    public T getPremier() {
        return this.gauche;
    }

    /**
     * Getter method of the second member
     * @return second member of the pair
     */
    public T getDeuxieme() {
        return this.droite;
    }

    /**
     * Test of the equality of the twice
     * @param otherCpl other pair to test
     * @return true if the twice are the same, false otherwise
     */
    public boolean equals(Object otherCpl) {
        boolean ret = false;
        // Vérifie si c’est le même objet
        if (this == otherCpl) {
            ret = true;
        } else if (otherCpl == null) {
            ret = false;
        } else if (!(otherCpl instanceof MathsCouple)) {
            ret =  false; // ce n'est pas un MathsCouple, donc pas égal
        }

        MathsCouple autre = (MathsCouple) otherCpl;

        // Compare les deux premiers et les deux deuxièmes éléments de chaque couples
        if (this.getPremier().equals(autre.getPremier()) && this.getDeuxieme().equals(autre.getDeuxieme())) {
            ret = true;
        }

        return ret;
    }

    /**
     * Redefinition of the toString method for the pair
     * @return a display of the pair
     */
    @Override
    public String toString() {
        String display = "Le couple : " + "(" + this.getPremier() + ", " + this.getDeuxieme() + ")";
        return display;
    }

    /**
     * Redefinition of the hashcode method
     * @return hashcode of the pair
     */
    @Override
    public int hashCode() {
        int result = 17; // nombre premier pour réduire le risque de collision dans la table de hachage
        result = 31 * result + (this.getPremier() != null ? this.getPremier().hashCode() : 0);
        result = 31 * result + (this.getDeuxieme() != null ? this.getDeuxieme().hashCode() : 0);
        return result;
    }
}