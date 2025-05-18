package Couple;

/**
 * This interface represents a mathematical couple (pair).
 * It is used to represent a pair of objects.
 * @param <T> the type of the elements of the couple
 */
public interface Couple<T> {

    /**
     * This method returns the first element of the couple
     * @return the first element of the couple
     */
    public abstract T getPremier();

    /**
     * This method returns the second element of the couple
     * @return the second element of the couple
     */
    public abstract T getDeuxieme();

    /**
     * This method checks if the couple is equal to another couple
     * @param otherCpl the other couple to compare to
     * @return true if the couples are equal, false otherwise
     */
    public abstract boolean equals(Object otherCpl);

    /**
     * This method returns a string representation of the couple
     * @return a string representation of the couple
     */

    /**
     * This method returns a string representation of the couple
     * @return a string representation of the couple
     */
    public abstract String toString();

    /**
     * This method returns the hash code of the couple
     * @return the hash code of the couple
     */
    public abstract int hashCode();
}
