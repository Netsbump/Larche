package fr.eni;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CREATION DE LA CLASSE MAIN
 */
public class Main {
    public static void main(String[] args) {

//*************************************AFFICHAGE DU MENU****************************************************************

        //Je crée deux tableaux pour stocker les enum d'Espèce et Sexe
        //Sexe[] sexes = Sexe.values();
        int cpt = 0;
        int cptChat = 0;
        int cptChien = 0;
        int cptGorille = 0;
        int cptLapin = 0;
        int cptMasculin = 0;
        int cptFeminin = 0;
        String nom = null;
        int sexe = -1;
        int espece = -1;

        Arche archeDeNoe = new Arche();


        //Boucle pour remplir le tableau d'animaux jusqu'à 8
        while (cpt < 9) {
//**********************************************DEMANDE-DU-NOM**********************************************************
            Messages saisieDuNom = new Messages();
            nom = saisieDuNom.saisieNom();
//*******************************************DEMANDE-DU-GENRE***********************************************************
            Messages saisieDuSexe = new Messages();
            sexe = saisieDuSexe.saisieSexe();
            try{
                switch (sexe) {
                case 0 : cptMasculin++;break;
                case 1 : cptFeminin++;break;
                }
            } catch (InputMismatchException e){
                    System.err.println("Saisie incorrecte");
                }
//*******************************************DEMANDE-DE-L-ESPECE********************************************************
            Messages saisieEspece = new Messages();
            espece = saisieEspece.saisieEspece(nom,sexe);
                switch (espece) {
                    case 0 : cptChat ++;break;
                    case 1 : cptChien ++;break;
                    case 2 : cptGorille ++;break;
                    case 3 : cptLapin ++;break;
                }
//*********************************VERIFICATION-GENRE-DEJA-PRESENT-DANS-LARCHE******************************************
            int retourGenreExistant = -1;
            Arche VerificationGenre = new Arche();
            retourGenreExistant = VerificationGenre.genrePresent(cptMasculin,cptFeminin,cptChat,cptChien,cptGorille,cptLapin);
            // Si il existe déjà un animal du même genre dans l'arche, on demande si l'utilisateur souhaite ajouter un
            // autre animal
            if (retourGenreExistant == 1){
                autreAnimal();
                if (autreAnimal() == false){
                    break;
                }
            }
//*********************************VERIFICATION-ESPECE-ET-NB-DEJA-PRESENT-DANS-LARCHE***********************************
            int retourNbEspece = -1;
            Arche VerificationNbEspece = new Arche();
            retourNbEspece = VerificationNbEspece.nombreEspeceAbord(cptChat,cptChien,cptGorille,cptLapin);
            // Si il existe déjà un nb maximal d'un genre d'animal dans l'arche, on demande si l'utilisateur souhaite
            // ajouter un autre animal
            if (retourNbEspece == 1){
              autreAnimal();
                if (autreAnimal() == false){
                      break;
                    }
            }
//*************************************STOCKAGE-DE-L-ANIMAL-DANS-L-ARCHE************************************************
            if (retourGenreExistant == 0 && retourNbEspece == 0){
             //Faire appel à la méthode ajouterAnimal de la classe Arche afin d'ajouter l'animal dans un tableau d'animaux.
                Sexe[] sexes = Sexe.values();
                Animal nouvelAnimal = new Animal(nom,sexes[sexe]);
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
