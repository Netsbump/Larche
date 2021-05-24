package fr.eni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CREATION DE LA CLASSE ARCHE
 */
public class Arche {
    //Attribut d'instance
    private List<Animal> animaux = new ArrayList<>();
    private final int TAILLE_MAX_ARCHE = 8;
    private int cpt_nb_animaux = 0;
    private final String limite_atteinte = "Désolé impossible d'ajouter un animal supplémentaire, la capacité maximal à été atteinte.";

    //********************************************CONSTRUCTEUR**************************************************************

    public Arche(List<Animal> animaux) {
        this.animaux = animaux;
    }

    public Arche() {
    }

    //********************************************METHODES**************************************************************

/**
* Méthode permettant l'ajout d'un nouvelAnimal dans la une ArrayList (l'arche)
* @param nouvelAnimal
*/
    public void ajouterAnimal(Animal nouvelAnimal) {
        if(cpt_nb_animaux <= TAILLE_MAX_ARCHE) {
        animaux.add(nouvelAnimal);
        cpt_nb_animaux ++;
        } else {
            System.out.println(limite_atteinte);
        }
    }

/**
* Methode pour vérifier le genre d'animaux présent dans l'arche
*
*/
    public int genrePresent(int cptMasculin, int cptFeminin, int cptChat, int cptChien, int cptGorille, int cptLapin){
        int genreExistant = 0;

        if (cptMasculin > 1 && cptChat > 1){
            System.out.println("Désolé nous avons déjà un Chat masculin à bord");//remplacer sout par throw new  MemeSexeException, par contre faire une methode ajouterAnimal throws MemeSexeException
            genreExistant = 1;
            return genreExistant;
        }
        if (cptFeminin > 1 && cptChat > 1){
            System.out.println("Désolé nous avons déjà un Chat féminin à bord");
            genreExistant = 1;
            return genreExistant;
        }

        if (cptMasculin > 1 && cptChien > 1){
            System.out.println("Désolé nous avons déjà un Chien masculin à bord");
            genreExistant = 1;
            return genreExistant;
        }
        if (cptFeminin > 1 && cptChien > 1){
            System.out.println("Désolé nous avons déjà un Chien féminin à bord");
            genreExistant = 1;
            return genreExistant;
        }

        if (cptMasculin > 1 && cptGorille > 1){
            System.out.println("Désolé nous avons déjà un Gorille masculin à bord");
            genreExistant = 1;
            return genreExistant;
        }
        if (cptFeminin > 1 && cptGorille > 1){
            System.out.println("Désolé nous avons déjà un Gorille féminin à bord");
            genreExistant = 1;
            return genreExistant;
        }
        if (cptMasculin > 1 && cptLapin > 1){
            System.out.println("Désolé nous avons déjà un Lapin masculin à bord");
            genreExistant = 1;
            return genreExistant;
        }
        if (cptFeminin > 1 && cptLapin > 1){
            System.out.println("Désolé nous avons déjà un Lapin féminin à bord");
            genreExistant = 1;
            return genreExistant;
        }

        else {
            return genreExistant;
        }
    }

    public int nombreEspeceAbord(int cptChat, int cptChien, int cptGorille, int cptLapin){
        int nbAbord = 0;
        if (cptChat > 2) {
            System.out.println("Désolé nous avons déjà " + cptChat + " Chats à bord ! ");
            return nbAbord = 1;
            }
        if (cptChien > 2) {
            System.out.println("Désolé nous avons déjà " + cptChien + " Chiens à bord ! ");
            return nbAbord = 1;
            }
        if (cptGorille > 2) {
            System.out.println("Désolé nous avons déjà " + cptGorille + " Gorille à bord ! ");
            return nbAbord = 1;
            }
        if (cptLapin > 2) {
            System.out.println("Désolé nous avons déjà " + cptLapin + " Lapins à bord ! ");
            return nbAbord = 1;
            }

        else {
            return nbAbord;
        }
    }


//********************************************METHODE-AFFICHAGE*********************************************************

    @Override
    public String toString() {
        return "Arche{ " +
                "animaux=" + animaux +
                '}';
    }

}