package fr.eni;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CREATION DE LA CLASSE ARCHE
 */
public class Arche {
    private Animal[] animaux = new Animal[8];

    //********************************************CONSTRUCTEUR**************************************************************
    public Arche(Animal[] animaux) {
        this.animaux = animaux;
    }

    public Arche() {
    }

    //********************************************METHODES******************************************************************
    public void ajouterAnimal(Animal nouvelAnimal) {
        for (int i = 0; i < this.animaux.length; i++) {
            if (this.animaux[i] == null) {
                this.animaux[i] = nouvelAnimal;
                break;
            }
        }
    }
//********************************************METHODE-AFFICHAGE*********************************************************


    @Override
    public String toString() {
        return "Arche{" +
                "animaux=" + Arrays.toString(animaux) +
                '}';
    }

}