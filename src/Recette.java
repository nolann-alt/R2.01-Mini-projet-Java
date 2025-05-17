import Ensemble.Ensemble;
import Ensemble.MathsEnsemble;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Recette {
    public static void main(String[] args) {

        // TEST DE MATHSENSEMBLE()
        System.out.println("********* TEST DE MATHSENSEMBLE()");
        // Création d'une arraylist de type collection
        Collection<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);

        // Création d'un ensemble
        MathsEnsemble<Integer> ensemble = new MathsEnsemble<>(elements);
        System.out.println(ensemble.toString()); // affichage

        // test méthode contient()
        System.out.println("ensemble.contains(1) : \t" + ensemble.contient(1));
        System.out.println("ensemble.contains(5) : \t" + ensemble.contient(5));

        // test méthode cardinal()
        System.out.println("ensemble.cardinal() : \t" + ensemble.cardinal());

        // test de elements()
        Set<Integer> content;
        content = ensemble.elements();
        System.out.println("content = " + content.toString());

        // ajout d'un second ensemble() + test de la programmation défensive
        elements.clear();
        System.out.println(ensemble.toString()); // --> l'ensemble n'a pas été modifié suite au nettoyage de l'arraylist utilisée pour sa création
        elements.add(5);
        elements.add(0);
        elements.add(3);
        elements.add(1);
        elements.add(10);
        elements.add(-1);
        MathsEnsemble<Integer> ensemble1 = new MathsEnsemble<>(elements);
        System.out.println(ensemble1.toString());

        // test méthode union
        System.out.println("ensemble.union(ensemble1) = \t" + ensemble.union(ensemble1));
        System.out.println("ensemble.intersection(ensemble1) = \t" + ensemble.intersection(ensemble1));
        System.out.println("ensemble.produitCartesien(ensemble1) = \t" + ensemble.produitCartesien(ensemble1));
        System.out.println("ensemble.difference(ensemble1) = \t" + ensemble.difference(ensemble1));
        System.out.println("ensemble1.difference(ensemble) = \t" + ensemble1.difference(ensemble));

        // pour aller plus loin...
        System.out.println();
        System.out.println("pour aller plus loin...");
        ArrayList<String> content1 = new ArrayList<>();
        ArrayList<String> content2 = new ArrayList<>();
        content1.add("rouge");
        content1.add("violet");
        content1.add("vert");
        content1.add("orange");
        content1.add("noir");
        content1.add("jaune");

        content2.add("beige");
        content2.add("jaune");
        content2.add("rose");
        content2.add("noir");
        content2.add("gris");
        content2.add("orange");

        MathsEnsemble<String> ens1 = new MathsEnsemble<>(content1);
        MathsEnsemble<String> ens2 = new MathsEnsemble<>(content2);


        System.out.println("ensemble 1 : " + ens1.toString());
        System.out.println("ensemble 2 : " + ens2.toString());

        System.out.println("ensemble1.union(ensemble2) = \t" + ens1.union(ens2));
        System.out.println("ensemble1.intersection(ensemble2) = \t" + ens1.intersection(ens2));
        System.out.println("ensemble1.produitCartesien(ensemble2) = \t" + ens1.produitCartesien(ens2));
        System.out.println("ensemble1.difference(ensemble2) = \t" + ens1.difference(ens2));
        System.out.println("ensemble2.difference(ensemble1) = \t" + ens2.difference(ens1));
    }
}
