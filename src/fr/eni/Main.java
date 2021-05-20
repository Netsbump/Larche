package fr.eni;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * CREATION DE LA CLASSE MAIN
 */
public class Main {
    public static void main(String[] args) {

//*************************************AFFICHAGE DU MENU****************************************************************

        //Je crée deux tableaux pour stocker les enum d'Espèce et Sexe
        Sexe[] sexes = Sexe.values();
        int cpt = 0;
        int cptChat = 0;
        int cptChien = 0;
        int cptGorille = 0;
        int cptLapin = 0;
        int cptMasculin = 0;
        int cptFeminin = 0;

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
            if (sexe1 == 0){
                cptMasculin++;
            } else {
                cptFeminin++;
            }

            System.out.println("Quel est ton espèce ? 0-CHAT 1-CHIEN 2-GORILLE 3-LAPIN");
            Scanner saisieEspece = new Scanner(System.in);
            int espece1 = saisieEspece.nextInt();
            //Stockage des saisies en créant des animaux qui correspondent
            switch (espece1) {
                case 0:
                    nouvelAnimal = new Chat(nom, sexes[sexe1]);
                    System.out.println("Nouvel Animal Chat : " + nouvelAnimal);
                    cptChat++;
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
//*********************************VERIFICATION-GENRE-DEJA-PRESENT-DANS-LARCHE******************************************
            if (cptMasculin > 1 && cptChat > 1){
                System.out.println("Désolé nous avons déjà un Chat masculin à bord");
                cptChat--;
                if (autreAnimal() == false){
                    break;
                }
            }
            if (cptFeminin > 1 && cptChat > 1){
                System.out.println("Désolé nous avons déjà un Chat féminin à bord");
                cptChat--;
                if (autreAnimal() == false){
                    break;
                }
            }

            if (cptMasculin > 1 && cptChien > 1){
                System.out.println("Désolé nous avons déjà un Chien masculin à bord");
                cptChien--;
                if (autreAnimal() == false){
                    break;
                }
            }
            if (cptFeminin > 1 && cptChien > 1){
                System.out.println("Désolé nous avons déjà un Chien féminin à bord");
                cptChien--;
                if (autreAnimal() == false){
                    break;
                }
            }

            if (cptMasculin > 1 && cptGorille > 1){
                System.out.println("Désolé nous avons déjà un Gorille masculin à bord");
                cptGorille--;
                if (autreAnimal() == false){
                    break;
                }
            }
            if (cptFeminin > 1 && cptGorille > 1){
                System.out.println("Désolé nous avons déjà un Gorille féminin à bord");
                cptGorille--;
                if (autreAnimal() == false){
                    break;
                }
            }

            if (cptMasculin > 1 && cptLapin > 1){
                System.out.println("Désolé nous avons déjà un Lapin masculin à bord");
                cptLapin--;
                if (autreAnimal() == false){
                    break;
                }
            }
            if (cptFeminin > 1 && cptLapin > 1){
                System.out.println("Désolé nous avons déjà un Lapin féminin à bord");
                cptLapin--;
                if (autreAnimal() == false){
                    break;
                }
            }

//*********************************VERIFICATION-ESPECE-ET-NB-DEJA-PRESENT-DANS-LARCHE***********************************
            if (cptChat > 2) {
                System.out.println("Désolé nous avons déjà " + cptChat + " Chats à bord ! ");
                if (autreAnimal() == false){
                    break;
                }
            } else if (cptChien > 2) {
                System.out.println("Désolé nous avons déjà " + cptChien + " Chiens à bord ! ");
                if (autreAnimal() == false){
                    break;
                }
            } else if (cptGorille > 2) {
                System.out.println("Désolé nous avons déjà " + cptGorille + " Gorille à bord ! ");
                if (autreAnimal() == false){
                    break;
                }
            } else if (cptLapin > 2) {
                System.out.println("Désolé nous avons déjà " + cptLapin + " Lapins à bord ! ");
                if (autreAnimal() == false){
                    break;
                }
            } else {
//*************************************STOCKAGE-DE-L-ANIMAL-DANS-L-ARCHE************************************************

                //Faire appel à la méthode ajouterAnimal de la classe Arche afin d'ajouter l'animal dans un tableau d'animaux.
                archeDeNoe.ajouterAnimal(nouvelAnimal);
                System.out.println(archeDeNoe);
                cpt++;
                System.out.println("L'animal " + nouvelAnimal.nom + " est dans l'arche.(capacité " + cpt + "/" + 8 + ")");
                //Demander s'il y a d'autres animaux à ajouter (possible de ne pas en mettre 8)
                if (autreAnimal() == false){
                    break;
                }
            }
        }
        System.out.println("Remplissage du tableau terminée.");
        System.out.println("L'arche possède à son bord, " + cptChat + " chats, " + cptChien + " chiens, " + cptGorille + " gorilles, " + cptLapin + " lapins.");

//****************************************************TEMPETE***********************************************************

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

//**************************************METHODE-REQUETE-AUTRE-ANIMAL-A-AJOUTER******************************************

    public static boolean autreAnimal(){
        System.out.println("Un autre animal à ajouter ? (o/N)");
        Scanner saisieFin = new Scanner(System.in);
        String saisieFinal = saisieFin.nextLine();
        if (!saisieFinal.equals("o")) {
            return false;
        } else {
            return true;
        }
    }

}
