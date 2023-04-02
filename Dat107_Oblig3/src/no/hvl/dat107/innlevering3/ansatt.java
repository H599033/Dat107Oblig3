package no.hvl.dat107.innlevering3;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "Oblig3")

public class ansatt {
	
	@Id //Primary key annotiation. Called @Id no matter what the variable is called
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@ManyToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name = "avdelingId", referencedColumnName= "avdelingId")
	private Integer Ansattid;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate datoAnsatt;
	private String stilling;
	private int monedslonn;
	private Integer avdelingId;

	
	
	public ansatt() {}
	
	public ansatt(Integer ansattid,String brukernavn,String fornavn,String etternavn,LocalDate datoAnsatt,
			String stilling,int monedslonn, Integer avdelingId) {
		
		this.Ansattid= ansattid;
		this.brukernavn=brukernavn;
		this.fornavn=fornavn;
		this.etternavn=etternavn;
		this.datoAnsatt=datoAnsatt;
		this.stilling=stilling;
		this.monedslonn=monedslonn;
		this.avdelingId = avdelingId;
		
	}

	public Integer getAvdelingId() {
		return avdelingId;
	}

	public void setAvdelingId(Integer avdelingId) {
		this.avdelingId = avdelingId;
	}

	public Integer getAnsattid() {
		return Ansattid;
	}

	public void setAnsattid(Integer ansattid) {
		Ansattid = ansattid;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getDatoAnsatt() {
		return datoAnsatt;
	}

	public void setDatoAnsatt(LocalDate datoAnsatt) {
		this.datoAnsatt = datoAnsatt;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMonedslonn() {
		return monedslonn;
	}

	public void setMonedslonn(int monedslonn) {
		this.monedslonn = monedslonn;
	}
	
	public void skrivUt() {
		System.out.println("AnsattID: " + Ansattid + " BrukerNavn: " +brukernavn + " Fornavn: " + fornavn +" Etternavn: "+ etternavn 
				+ " Dato ansatt: " + datoAnsatt+" Stilling: " + stilling + " Månedslønn: " + monedslonn);
	}

	@Override
	public String toString() {
		return "ansatt [Ansattid=" + Ansattid + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", datoAnsatt=" + datoAnsatt + ", stilling=" + stilling + ", monedslonn=" + monedslonn
				+",avdelingID=]" + avdelingId  +"\n";
	}

}
