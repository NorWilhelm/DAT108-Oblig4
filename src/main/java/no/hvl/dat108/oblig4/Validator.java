package no.hvl.dat108.oblig4;

public class Validator {

	public static final String MOBIL = "^[0-9]{8}$";
	public static final String ETTERNAVN = "^[A-Z���][a-z���A-Z���-]{1,20}$";
	public static final String FORNAVN = "^[A-Z���][a-z���A-Z��� -]{1,20}$";
	public static final String PASSORD = "^[a-z���A-Z���0-9]{6,}$";

	public static boolean gyldigFornavn(String fornavn) {
		if (fornavn == null) {
			return false;
		}

		return fornavn.matches(FORNAVN);

	}

	public static boolean gyldigEtternavn(String etternavn) {
		if (etternavn == null) {
			return false;
		}

		return etternavn.matches(ETTERNAVN);
	}

	public static boolean gyldigMobil(String mobil) {
		if (mobil == null) {
			return false;
		}
		
		return mobil.matches(MOBIL);
	}

	public static boolean gyldigKjonn(String kjonn) {
		if (kjonn == null) {
			return false;
		}

		return kjonn.equals("mann") || kjonn.equals("kvinne");
	}

	public static boolean gyldigPassord(String passord) {
		if (passord == null) {
			return false;
		}

		return passord.matches(PASSORD);
	}

}