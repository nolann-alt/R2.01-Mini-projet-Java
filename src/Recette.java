import Ensemble.MathsEnsemble;

import java.util.ArrayList;
import java.util.Collection;

public class Recette {
    public static void main(String[] args) {

        // Création d'une arraylist de type collection
        Collection<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);

        // Création d'un ensemble
        MathsEnsemble<Integer> ensemble = new MathsEnsemble<>(elements);
        System.out.println(ensemble.toString());
    }

}
