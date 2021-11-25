package fr.eni.enchere.exceptions;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<Integer> listeCodesErreur;

	public BusinessException() {
		super();
		this.listeCodesErreur = new ArrayList<>();
	}
	
	public void ajouterErreur(int codeErreur) {
		if (!this.listeCodesErreur.contains(codeErreur)) {
			this.listeCodesErreur.add(codeErreur);
		}
	}
	
	public boolean contientErreurs() {
		return this.listeCodesErreur.size() > 0;
	}

	public List<Integer> getListeCodesErreur() {
		return this.listeCodesErreur;
	}
	
}
