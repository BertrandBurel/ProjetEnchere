package fr.eni.enchere.dal;

public abstract class ErrorCodesDAL {

	public static final int INSERT_OBJECT_NULL = 10000;
	
	public static final int INSERT_OBJECT_FAILED = 10001;
	
	public static final int SELECT_BY_ID_FAILED = 10002;
	
	public static final int SELECT_BY_PSEUDO_FAILED = 10003;
	
	public static final int SELECT_BY_EMAIL_FAILED = 10004;
}
