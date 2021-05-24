package fr.eni;

/**
 * CREATION DE LA CHAT
 */
public class Chat extends Animal{

    private String espece = "Chat";

//***********************************************CONSTRUCTEUR***********************************************************

    public Chat(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public String getEspeceChat() {
        return espece;
    }
}
