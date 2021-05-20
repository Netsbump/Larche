package fr.eni;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * CREATION DE LA CLASSE MAIN
 */
public class Main {
    public static void main(String[] args) {

//*************************************AFFICHAGE DU MENU***************************************************************

        //Je crée deux tableaux pour stocker les enum d'Espèce et Sexe
        Espece[] especes = Espece.values();
        Sexe[] sexes = Sexe.values();
        int cpt = 0;
        Arche archeDeNoe = new Arche();
        Animal nouvelAnimal = new Animal(null, null);

        while (cpt < 9){

            //Creation d'une instance d'animal qui sera valorisé par la suite

            //Debut de l'affichage
            System.out.println("Quel est ton nom ?");
            Scanner saisieNom = new Scanner(System.in);
            String nom = saisieNom.nextLine();

            System.out.println("Quel est ton sexe ? 0-MASCULIN 1-FEMININ");
            Scanner saisieSexe = new Scanner(System.in);
            int sexe1 = saisieSexe.nextInt();

            System.out.println("Quel est ton espèce ? 0-CHAT 1-CHIEN 2-GORILLE 3-LAPIN");
            Scanner saisieEspece = new Scanner(System.in);
            int espece1 = saisieEspece.nextInt();
            //Stockage des saisies en créant des animaux qui correspondent
            switch (espece1)    {
                case 0 :
                    nouvelAnimal = new Chat(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal : " + nouvelAnimal);break;
                case 1 :
                    nouvelAnimal = new Chien(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal : " + nouvelAnimal);break;
                case 2 :
                    nouvelAnimal = new Gorille(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal : " + nouvelAnimal);break;
                case 3 :
                    nouvelAnimal = new Lapin(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal : " + nouvelAnimal);break;
                default:
                    System.out.println("Erreur saisie.");

            }
//*************************************STOCKAGE-DE-L-ANIMAL-DANS-L-ARCHE************************************************

            //Faire appel à la méthode ajouterAnimal de la classe Arche afin d'ajouter l'animal dans un tableau d'animaux.
            archeDeNoe.ajouterAnimal(nouvelAnimal);
            System.out.println(archeDeNoe);

            cpt ++;
        }


    }

}
