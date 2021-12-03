package fr.eni.enchere.bll;

public abstract class ErrorCodesBLL {

	public static final int PSEUDO_LENGTH_ERROR = 20000;
	public static final int PSEUDO_REGEX_ERROR = 20001;

	public static final int LASTNAME_LENGTH_ERROR = 20002;
	public static final int LASTNAME_REGEX_ERROR = 20003;

	public static final int FIRSTSTNAME_LENGTH_ERROR = 20004;
	public static final int FIRSTSTNAME_REGEX_ERROR = 20005;

	public static final int EMAIL_LENGTH_ERROR = 20006;
	public static final int EMAIL_REGEX_ERROR = 20007;

	public static final int PHONE_LENGTH_ERROR = 20008;
	public static final int PHONE_REGEX_ERROR = 20009;

	public static final int ADDRESS_LENGTH_ERROR = 20010;
	public static final int ADDRESS_REGEX_ERROR = 20011;

	public static final int POSTALCODE_LENGTH_ERROR = 20012;
	public static final int POSTALCODE_REGEX_ERROR = 20013;

	public static final int CITY_LENGTH_ERROR = 20014;
	public static final int CITY_REGEX_ERROR = 20015;

	public static final int PASSWORD_LENGTH_ERROR = 20016;
	public static final int CONFIRM_PASSWORD_ERROR = 20017;
	public static final int PASSWORD_REGEX_ERROR = 20018;

	public static final int UNICITY_ERROR = 20019;

	public static final int ARTICLE_NAME_LENGHT_ERROR = 20100;
	public static final int ARTICLE_DESCRIPTION_LENGHT_ERROR = 20101;
	public static final int NO_CATEGORY_ERROR = 20102;
	public static final int NEGATIVE_PRICE_ERROR = 20103;
	public static final int PAST_STARTING_DATE_ERROR = 20104;
	public static final int ENDING_DATE_BEFORE_START_ERROR = 20105;

	public static final int ARTICLE_NAME_NULL_ERROR = 20106;
	public static final int ARTICLE_DESCRIPTION_NULL_ERROR = 20107;
	public static final int PRICE_NULL_ERROR = 20108;
	public static final int STARTING_DATE_NULL_ERROR = 20109;
	public static final int ENDING_DATE_NULL_ERROR = 20110;

	public static final int BID_INFERIOR_TO_PRICE_ERROR = 20200;
}
