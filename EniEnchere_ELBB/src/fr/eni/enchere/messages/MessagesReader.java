package fr.eni.enchere.messages;

import java.util.ResourceBundle;

public abstract class MessagesReader {

	private static ResourceBundle rb;
	
	static {
		try {
			rb = ResourceBundle.getBundle("fr.eni.enchere.messages.messagesErreur");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMessageErreur(int codeErreur) {
		String message ="";
		
		try {
			if (rb != null) {
				message = rb.getString(String.valueOf(codeErreur));
			} else {
				message = "Une erreur est survenue lors de la lecture du fichier messages d'erreur.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Erreur inconnue.";
		}
		return message;
	}
}
