package no.hvl.dat108.oblig4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;


public class Hashing {
	
	private int iteration = 0;
	private String hashAlgoritme = "SHA-1";
	
	private String passordHash;
	private byte[] passordSalt;
	
	public static final String SHA1 = "SHA-1";
	public static final String SHA256 = "SHA-256";
	
	public Hashing() {
		
	}

	public Hashing(String hashAlgoritme) {
		this.hashAlgoritme = hashAlgoritme;
	}
	
	public String genererHashUtenSalt(final String password) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance(hashAlgoritme);
		byte[] passbytes = password.getBytes();
		md.update(passbytes);
		byte[] passhash = md.digest();
		
		String hexOfHash = DatatypeConverter.printHexBinary(passhash);
		
		passordHash = hexOfHash;
		
		return hexOfHash;
		
	}
	
	public void genererHashMedSalt(final String passord, byte[] salt) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance(hashAlgoritme);
		md.update(salt);
		byte[] passbytes = passord.getBytes();
		byte[] passhash = md.digest(passbytes);
		String hexOfHash = DatatypeConverter.printHexBinary(passhash);
		passordHash = hexOfHash;
	}

	public void genererHashMedSaltOgIteration(final String passord, byte[] salt, int keylength, int iteration) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		char[] passchar = passord.toCharArray();
		
		PBEKeySpec pks = new PBEKeySpec(passchar, salt, iteration, keylength);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] keyhash = skf.generateSecret(pks).getEncoded();
		
		passordHash = DatatypeConverter.printHexBinary(keyhash);
		
	}
	
	public boolean validerPassordUtenSalt(final String passord, final String hashedPassword) throws NoSuchAlgorithmException {
		
		genererHashUtenSalt(passord);
		
		boolean equal = passordHash.equalsIgnoreCase(hashedPassword);
		
		return equal;
	}
	
	public boolean validerPasswordMedSalt(final String passord, final String salt, final String hashPassord) throws NoSuchAlgorithmException {
		
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
		
		genererHashMedSalt(passord, saltbytes);
		
		boolean equal = passordHash.equalsIgnoreCase(hashPassord);
		
		return equal;	
		
	}
	
	public boolean validerPassordMedSaltOgIteration(final String passord, final String salt, final String hashPassord, int keylength, int iteration) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);	
		
		genererHashMedSaltOgIteration(passord, saltbytes, keylength, iteration);
		
		boolean equal = passordHash.equalsIgnoreCase(hashPassord);
		
		return equal;
	}
	
	public byte[] getSalt() {
		
		
	    SecureRandom sr;
	    byte[] salt = new byte[16];
	    
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		    
		    sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.passordSalt = salt;
	    return salt;
	}
	
	public String getPassordHashiHex() {
		return passordHash;
	}
	
	public String getPassordSalt() {
		return DatatypeConverter.printHexBinary(passordSalt);
	}
	
	public int getIteration() {
		return iteration;
	}
	
	public String getHashAlgoritme() {
		return hashAlgoritme;
	}

}
