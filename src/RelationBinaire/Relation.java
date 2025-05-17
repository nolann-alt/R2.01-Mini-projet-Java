package RelationBinaire;

import Couple.Couple;
import java.util.Set;


public interface Relation {

    public abstract boolean estReflexive();

    public abstract boolean estSymetrique();

    public abstract boolean estAntisymetrique();

    public abstract boolean estTransitive();

    public abstract <T> boolean contient(Couple<T> cpl);

    public abstract <T> Set<Couple<T>> elements();
}
