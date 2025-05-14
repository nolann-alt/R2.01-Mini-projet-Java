package Couple;

/**
 * Classe implémentant un couple d'objet
 * @param <A> premier objet
 * @param <B> second objet
 */
public class MathsCouple<A, B> implements Couple<A, B> {

    /**
     * attributs du couple (final car ils sont immuable --> on ne peut modifier un couple)
     */
    private final A gauche;
    private final B droite;

    /**
     * Constructeur de MathsCouple
     * @param first premier membre
     * @param second second membre
     */
    public MathsCouple(A first, B second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Erreur MathsCouple : les 2 membres du couple doivent être non null !");
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
    public A getPremier() {
        return this.gauche;
    }

    /**
     * Getter du deuxième membre
     * @return le second membre du couple
     */
    public B getDeuxieme() {
        return this.droite;
    }

    /**
     * Test l'égalité entre 2 couples
     * @param otherCpl second couple à comparer
     * @return true si les 2 couples sont égaux, false sinon
     */
    public boolean equals(MathsCouple<A, B> otherCpl) {
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
    public int hashCode() {
        return this.hashCode();
    }
}