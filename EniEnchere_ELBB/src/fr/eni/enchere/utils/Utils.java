package fr.eni.enchere.utils;

public class Utils {

	 public static final String REGEX_PSEUDO = "[a-zA-Z0-9]+";
	 // https://emailregex.com
	 public static final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
	 		+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@"
	 		+ "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]"
	 		+ "?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:("
	 		+ "?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	 public static final String REGEX_PHONE = "(0|\\+33|0033)[1-9][0-9]{8}";
	 public static final String REGEX_TEXT = "^[\\u00C0-\\u017Fa-zA-Z']+([- ][\\u00C0-\\u017Fa-zA-Z']+)*";
	 public static final String REGEX_ADDRESS = "^[\\w'\\-,]*[^._!¡?÷?¿\\/\\\\+=@#$%ˆ&*(){}|~<>;:\\[\\]]*$";
	 public static final String REGEX_POSTAL_CODE = "^\\d{5,10}$";
	 public static final String REGEX_PASSWORD = "[a-zA-Z0-9-*!@#]{1,30}$";
	 
}
