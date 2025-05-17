package Couple;

/**
 * Classe implémentant un couple d'objet
 * @param <T> premier objet
 * @param <T> second objet
 */
public class MathsCouple<T> implements Couple<T> {

    /**
     * attributs du couple (final car ils sont immuable --> on ne peut modifier un couple)
     */
    private final T gauche;
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
     * Getter du premier membre
     * @return le premier membre du couple
     */
    @Override
    public T getPremier() {
        return this.gauche;
    }

    /**
     * Getter du deuxième membre
     * @return le second membre du couple
     */
    public T getDeuxieme() {
        return this.droite;
    }

    /**
     * Test l'égalité entre 2 couples
     * @param otherCpl second couple à comparer
     * @return true si les 2 couples sont égaux, false sinon
     */
    public boolean equals(MathsCouple<T> otherCpl) {
        boolean ret = false;
        if (this.hashCode() == otherCpl.hashCode()) {
            ret = true;
        }
        return ret;
    }

    /**
     * Redéfinition de la méthode toString adaptée aux couples
     * @return un affichage du couple
     */
    @Override
    public String toString() {
        String display = "(" + this.getPremier() + ", " + this.getDeuxieme() + ")";
        return display;
    }

    /**
     * Redéfinition de la méthode hashcode
     * @return le code de hachage du couple
     */
    @Override
    public int hash() {
        return this.hashCode();
    }
}