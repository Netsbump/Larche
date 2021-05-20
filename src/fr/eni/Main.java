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
        int cptChat = 0;
        int cptChien = 0;
        int cptGorille = 0;
        int cptLapin = 0;
        Arche archeDeNoe = new Arche();
        Animal nouvelAnimal = new Animal(null, null);

        //Boucle pour remplir le tableau d'animaux jusqu'à 8
        while (cpt < 9) {

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
            switch (espece1) {
                case 0:
                    nouvelAnimal = new Chat(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal Chat : " + nouvelAnimal);
                    cptChat ++;
                    break;
                case 1:
                    nouvelAnimal = new Chien(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal Chien : " + nouvelAnimal);
                    cptChien++;
                    break;
                case 2:
                    nouvelAnimal = new Gorille(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal Gorille : " + nouvelAnimal);
                    cptGorille++;
                    break;
                case 3:
                    nouvelAnimal = new Lapin(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal Lapin : " + nouvelAnimal);
                    cptLapin++;
                    break;
                default:
                    System.out.println("Erreur saisie.");

            }
//*************************************STOCKAGE-DE-L-ANIMAL-DANS-L-ARCHE************************************************

            //Faire appel à la méthode ajouterAnimal de la classe Arche afin d'ajouter l'animal dans un tableau d'animaux.
            archeDeNoe.ajouterAnimal(nouvelAnimal);
            System.out.println(archeDeNoe);
            System.out.println("L'animal " + nouvelAnimal.nom + " est dans l'arche.");
            cpt++;
            //Demander s'il y a d'autres animaux à ajouter (possible de ne pas en mettre 8)
            System.out.println("Un autre animal à ajouter ? (o/N)");
            Scanner saisieFin = new Scanner(System.in);
            String saisieFinal = saisieFin.nextLine();
            if (!saisieFinal.equals("o")) {
                break;
            }

        }
        System.out.println("Remplissage du tableau terminée.");
        System.out.println("L'arche possède à son bord, " + cptChat + " chats, " + cptChien + " chiens, " + cptGorille + " gorilles, " + cptLapin + " lapins.");

//*******************************************************TEMPETE********************************************************

        int viande = 0;
        if(cptChat > 0 || cptChien > 0){
            viande = (cptChat *(30*10)) + (cptChien *(30*10));
        }

        int vegetaux = 0;
        if(cptGorille > 0 || cptLapin > 0) {
            vegetaux = (cptGorille * (10 * 10)) + (cptLapin * (10 * 10));
        }

        System.out.println("Le commis doit donc avoir à bord, " + vegetaux + " végétaux" + " et " + viande + "kg de viande.");

    }



}
