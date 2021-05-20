package fr.eni;

/**
 * CREATION DE LA CLASSE ANIMAL
 */
public class Animal {
    protected String nom;
    protected Sexe sexe;


//***********************************************CONSTRUCTEUR***********************************************************
    public Animal(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
    }
//*************************************************GETTERS**************************************************************
    public String getNom() {
        return nom;
    }

//********************************************METHODE-AFFICHAGE*********************************************************

    @Override
    public String toString() {
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", sexe=" + sexe +
                '}';
    }
}
