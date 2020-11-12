import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import no.hvl.dat108.oblig4.Validator;
import org.junit.Test;

public class ValidatorTest {

	@Test
	public void erGyldigFornavn() {
		assertTrue(Validator.gyldigFornavn("Olav"));
		assertTrue(Validator.gyldigFornavn("Jan-Anders"));
		assertTrue(Validator.gyldigFornavn("Synn�ve Andersen"));
		assertTrue(Validator.gyldigFornavn("Po"));

	}

	@Test
	public void erUgyldigFornavn() {
		assertFalse(Validator.gyldigFornavn("Q"));
		assertFalse(Validator.gyldigFornavn("pang"));
		assertFalse(Validator.gyldigFornavn("�sop"));

	}

	@Test
	public void erGyldigEtternavn() {
		assertTrue(Validator.gyldigEtternavn("Amundsen"));
		assertTrue(Validator.gyldigEtternavn("Amundsen-Wilhelmsen"));
		assertTrue(Validator.gyldigEtternavn("Bo"));

	}

	@Test
	public void erUgyldigEtternavn() {
		assertFalse(Validator.gyldigEtternavn("Amundsen Wilhelmsen"));
		assertTrue(Validator.gyldigEtternavn("Amundsen-wilhelmsen"));
		assertFalse(Validator.gyldigEtternavn("zq"));
		assertFalse(Validator.gyldigEtternavn("Q"));
	}

	@Test
	public void erGyldigMobil() {
		assertTrue(Validator.gyldigMobil("00000000"));
		assertTrue(Validator.gyldigMobil("12345678"));
	}

	@Test
	public void erUgyldigMobil() {
		assertFalse(Validator.gyldigMobil("1234567 "));
		assertFalse(Validator.gyldigMobil("123456789"));
		assertFalse(Validator.gyldigMobil("112 1234"));
	}
	
	@Test
	public void erGyldigPassord() {
		assertTrue(Validator.gyldigPassord("swag420"));
		assertTrue(Validator.gyldigPassord("DABONH8TERS"));
		assertTrue(Validator.gyldigPassord("���password123"));
	}
	
	@Test
	public void erUgyldigPassord() {
		assertFalse(Validator.gyldigPassord("olav"));
		assertFalse(Validator.gyldigPassord("-�-.'swag"));
		assertFalse(Validator.gyldigPassord("okboomer..."));
		assertFalse(Validator.gyldigPassord("2+2er4"));
		assertFalse(Validator.gyldigPassord("<<__//....."));
	}

}
