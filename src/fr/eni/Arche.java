package fr.eni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CREATION DE LA CLASSE ARCHE
 */
public class Arche {
    private List<Animal> animaux = new ArrayList<>();

    //********************************************CONSTRUCTEUR**************************************************************

    public Arche(List<Animal> animaux) {
        this.animaux = animaux;
    }

    public Arche() {
    }

    //********************************************METHODES******************************************************************
    public void ajouterAnimal(Animal nouvelAnimal) {
        animaux.add(nouvelAnimal);


    }
//********************************************METHODE-AFFICHAGE*********************************************************


    @Override
    public String toString() {
        return "Arche{" +
                "animaux=" + animaux +
                '}';
    }

}