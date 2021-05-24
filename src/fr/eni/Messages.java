package fr.eni;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Messages {

    private final String demandeNom = "Quel est ton nom ?";
    private final String demandeSexe = "Quel est ton sexe ? 0-MASCULIN 1-FEMININ";
    private final String demandeEspece = "Quel est ton espèce ? 0-CHAT 1-CHIEN 2-GORILLE 3-LAPIN";
    Scanner scanner = new Scanner(System.in);

//********************************************METHODES******************************************************************
/**
* Méthode saisieNom permettant à l'utilisateur de saisir le nom d'un animal.
*/
    public String saisieNom(){

        System.out.println(demandeNom);
        String nom = scanner.nextLine();
        return nom;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "demandeNom='" + demandeNom + '\'' +
                '}';
    }

    /**
* Méthode saisieSexe permettant à l'utilisateur de saisir le sexe d'un animal.
*/
    public int saisieSexe(){

        System.out.println(demandeSexe);
        Scanner saisieSexe = new Scanner(System.in);
        int sexe = saisieSexe.nextInt();
        return sexe;
    }

/**
 * Méthode saisieEspece permettant à l'utilisateur de saisir l'espèce d'un animal.
 */

    public int saisieEspece(String nom, int sexe){
        Sexe[] sexes = Sexe.values();
        Animal nouvelAnimal = new Animal(null, null);

        System.out.println(demandeEspece);
        Scanner saisieEspece = new Scanner(System.in);
        int espece = saisieEspece.nextInt();
        //Stockage des saisies en créant des animaux qui correspondent
        switch (espece) {
            case 0:
                nouvelAnimal = new Chat(nom, sexes[sexe]);
                System.out.println("Nouvel Animal Chat : " + nouvelAnimal);
                return espece;
            case 1:
                nouvelAnimal = new Chien(nom, sexes[sexe]);
                System.out.println("Nouvel Animal Chien : " + nouvelAnimal);
                return espece;
            case 2:
                nouvelAnimal = new Gorille(nom, sexes[sexe]);
                System.out.println("Nouvel Animal Gorille : " + nouvelAnimal);
                return espece;
            case 3:
                nouvelAnimal = new Lapin(nom, sexes[sexe]);
                System.out.println("Nouvel Animal Lapin : " + nouvelAnimal);
                return espece;
        }
        return espece;
    }

    //Affichage des message
}




