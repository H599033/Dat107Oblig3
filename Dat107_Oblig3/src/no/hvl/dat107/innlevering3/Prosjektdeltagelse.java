package no.hvl.dat107.innlevering3;



public class Prosjektdeltagelse {
	
	private Integer ansattId;
	private Integer prosjektId;
	private int prosjektTid;
	
	public Prosjektdeltagelse(Integer ansattId, Integer prosjektId, int prosjektTid) {
		this.ansattId=ansattId;
		this.prosjektId=prosjektId;
		this.prosjektTid=prosjektTid;
	}

	public Integer getAnsattId() {
		return ansattId;
	}

	public void setAnsattId(Integer ansattId) {
		this.ansattId = ansattId;
	}

	public Integer getProsjektId() {
		return prosjektId;
	}

	public void setProsjektId(Integer prosjektId) {
		this.prosjektId = prosjektId;
	}

	public int getProsjektTid() {
		return prosjektTid;
	}

	public void setProsjektTid(int prosjektTid) {
		this.prosjektTid = prosjektTid;
	}

	@Override
	public String toString() {
		return "Prosjektdeltagelse [ansattId=" + ansattId + ", prosjektId=" + prosjektId + ", prosjektTid="
				+ prosjektTid + "]";
	}
	
	public void skrivUt() {
		System.out.println(toString());
	}
	
}