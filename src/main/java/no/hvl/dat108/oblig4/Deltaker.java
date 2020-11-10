package no.hvl.dat108.oblig4;

import javax.persistence.EntityManagerFactory;

public class Deltaker {

    private String fornavn;
    private String etternavn;
    private int mobilnr;
    private String passord;
    private String kjonn;

    public Deltaker(String fornavn, String etternavn, int mobilnr, String passord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobilnr = mobilnr;
        this.passord = passord;
        this.kjonn = kjonn;
    }

    public String getFornavn() { return fornavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }

    public String getEtternavn() { return etternavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }

    public int getMobilnr() { return mobilnr; }
    public void setMobilnr(int mobilnr) { this.mobilnr = mobilnr; }

    public String getPassord() { return passord; }
    public void setPassord(String passord) { this.passord = passord; }

    public String getKjonn() { return kjonn; }
    public void setKjonn(String kjonn) { this.kjonn = kjonn; }
}
