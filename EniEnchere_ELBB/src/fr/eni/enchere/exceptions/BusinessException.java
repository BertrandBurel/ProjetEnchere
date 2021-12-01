package fr.eni.enchere.exceptions;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<Integer> listErrorCodes;

	public BusinessException() {
		super();
		this.listErrorCodes = new ArrayList<>();
	}

	public void addError(int errorCode) {
		if (!this.listErrorCodes.contains(errorCode)) {
			this.listErrorCodes.add(errorCode);
		}
	}

	public boolean hasErrors() {
		return this.listErrorCodes.size() > 0;
	}

	public List<Integer> getListErrorCodes() {
		return this.listErrorCodes;
	}
}
