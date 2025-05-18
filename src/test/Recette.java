package test;

import Couple.Couple;
import Couple.MathsCouple;
import Ensemble.Ensemble;
import Ensemble.MathsEnsemble;
import RelationBinaire.MathsRelation;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * This class is used to test the classes MathsEnsemble, MathsCouple and MathsRelation.
 * It contains the main method that runs the tests.
 * @author Nolann L
 * @author Matthieu G
 * @version 1.0
 */
public class Recette {
    /**
     * The main method that runs the tests.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TEST DE MATHSENSEMBLE()
        System.out.println("********* TEST DE MATHSENSEMBLE() ********* ");
        // Création d'une arraylist de type collection
        Collection<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);

        // Création d'un ensemble
        MathsEnsemble<Integer> ensemble = new MathsEnsemble<>(elements);
        System.out.println(ensemble.toString()); // affichage

        System.out.println();

        // test méthode contient()
        System.out.println("ensemble.contains(1) : \t" + ensemble.contient(1));
        System.out.println("ensemble.contains(5) : \t" + ensemble.contient(5));

        // test méthode cardinal()
        System.out.println("ensemble.cardinal() : \t" + ensemble.cardinal());

        // test de elements()
        Set<Integer> content;
        content = ensemble.elements();
        System.out.println("content = " + content.toString());

        System.out.println();

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

        System.out.println();

        // test méthode union, intersection, produit cartesien, difference
        System.out.println("ensemble.union(ensemble1) = \t" + ensemble.union(ensemble1));
        System.out.println("ensemble.intersection(ensemble1) = \t" + ensemble.intersection(ensemble1));
        System.out.println("ensemble.produitCartesien(ensemble1) = \t" + ensemble.produitCartesien(ensemble1));
        System.out.println("ensemble.difference(ensemble1) = \t" + ensemble.difference(ensemble1));
        System.out.println("ensemble1.difference(ensemble) = \t" + ensemble1.difference(ensemble));

        System.out.println();

        // pour aller plus loin...
        System.out.println();
        System.out.println("Pour aller plus loin...");
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

        System.out.println();

        System.out.println("ensemble1.union(ensemble2) = \t" + ens1.union(ens2));
        System.out.println("ensemble1.intersection(ensemble2) = \t" + ens1.intersection(ens2));
        System.out.println("ensemble1.produitCartesien(ensemble2) = \t" + ens1.produitCartesien(ens2));
        System.out.println("ensemble1.difference(ensemble2) = \t" + ens1.difference(ens2));
        System.out.println("ensemble2.difference(ensemble1) = \t" + ens2.difference(ens1));

        System.out.println();

        // TEST DE MATHSCOUPLE()
        System.out.println();
        System.out.println("********* TEST DE MATHSCOUPLE() ********* ");
        MathsCouple<String> cpl1 = new MathsCouple<>("rouge", "orange");
        MathsCouple<String> cpl2 = new MathsCouple<>("rouge", "jaune");
        MathsCouple<String> cpl3 = new MathsCouple<>("orange", "rouge");
        MathsCouple<String> cpl4 = new MathsCouple<>("rouge", "orange");
        MathsCouple<String> cpl5 = new MathsCouple<>("rouge", "orange");

        System.out.println(cpl1.toString());

        System.out.println();

        System.out.println("cpl1.getPremier() : \t" + cpl1.getPremier());
        System.out.println("cpl1.getDeuxieme() : \t" + cpl1.getDeuxieme());

        System.out.println();

        System.out.println("Tests égalité : ");
        System.out.println("cpl1 = " + cpl1.toString());
        System.out.println("cpl2 = " + cpl2.toString());
        System.out.println("cpl3 = " + cpl3.toString());
        System.out.println("cpl4 = " + cpl4.toString());
        System.out.println("cpl1.equals(cpl2) : \t" + cpl1.equals(cpl2));
        System.out.println("cpl1.equals(cpl3) : \t" + cpl1.equals(cpl3));
        System.out.println("cpl1.equals(cpl4) : \t" + cpl1.equals(cpl4));

        System.out.println();

        // Test de la méthode hashcode
        System.out.println("HashCode cpl1 : " + cpl1.hashCode());
        System.out.println("HashCode cpl3 : " + cpl3.hashCode());
        System.out.println("HashCode cpl5 : " + cpl5.hashCode());

        System.out.println("cpl1 equals cpl2 ? " + cpl1.equals(cpl5)); // true
        System.out.println("cpl1 equals cpl3 ? " + cpl1.equals(cpl3)); // false

        System.out.println("cpl1 hash == cpl2 hash ? " + (cpl1.hashCode() == cpl5.hashCode())); // true
        System.out.println("cpl1 hash == cpl3 hash ? " + (cpl1.hashCode() == cpl3.hashCode())); // false

        System.out.println();

        // Test de mathsrelation
        System.out.println();
        System.out.println("********* TEST DE MATHSRELATION() *********");

        // Test de constructeur avec des nombres
        MathsRelation relationN = new MathsRelation(new MathsEnsemble<>(Set.of(
                new MathsCouple<>(2, 3),
                new MathsCouple<>(2, 4)


        )));
        System.out.println(relationN.toString());

        // Test du constructeur avec des chaînes
        MathsRelation relationC = new MathsRelation(new MathsEnsemble<>(Set.of(
                new MathsCouple<>("rouge", "orange"),
                new MathsCouple<>("orange", "bleu"),
                new MathsCouple<>("bleu", "bleu")
        )));
        System.out.println(relationC.toString());

        // Une relation réflexive
        MathsRelation relationR = new MathsRelation(new MathsEnsemble<>(Set.of(
                new MathsCouple<>("rouge", "rouge"),
                new MathsCouple<>("orange", "orange"),
                new MathsCouple<>("rouge", "orange")
        )));
        System.out.println(relationR.toString());

        System.out.println();

        // Test de est Reflexive
        System.out.println("relationR estReflexive : " + relationR.estReflexive()); // true
        System.out.println("relationC estRflexive : " + relationC.estReflexive()); // false

        // une relation symetrique
        MathsRelation relationS = new MathsRelation(new MathsEnsemble<>(Set.of(
                new MathsCouple<>("rouge", "orange"),
                new MathsCouple<>("orange", "rouge")
        )));
        System.out.println(relationR.toString());

        System.out.println();

        // Test de est Symetrique
        System.out.println("relationS estSymetrique : " + relationS.estSymetrique()); // true
        System.out.println("relationC estSymetrique : " + relationC.estSymetrique()); // false

        System.out.println();

        // Test de est Antisymetrique
        System.out.println("relationR estAntisymetrique : " + relationR.estAntisymetrique()); // true
        System.out.println("relationS estAntisymetrique : " + relationS.estAntisymetrique()); // false

        System.out.println();

        // une relation transitive
        MathsRelation relationT = new MathsRelation(new MathsEnsemble<>(Set.of(
                new MathsCouple<>("rouge", "orange"),
                new MathsCouple<>("orange", "bleu"),
                new MathsCouple<>("rouge", "bleu")
        )));
        System.out.println(relationT.toString());

        // Test de estTransitive
        System.out.println("relationT estTransitive : " + relationT.estTransitive()); // true
        System.out.println("relationC estTransitive : " + relationC.estTransitive()); // false

        System.out.println();

        // Test de contient
        System.out.println("relationT contient : " + relationT.contient(new MathsCouple("rouge", "orange"))); // true
        System.out.println("relationT contient : " + relationT.contient(new MathsCouple("rouge", "vert"))); // false
    }
}