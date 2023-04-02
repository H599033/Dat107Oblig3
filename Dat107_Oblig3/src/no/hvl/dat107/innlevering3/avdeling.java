package no.hvl.dat107.innlevering3;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "Oblig3")

public class avdeling {
	@Id //Primary key annotiation. Called @Id no matter what the variable is called
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer avdelingId;
	private String navn;
	private Integer sjef;
	
	public avdeling(Integer avdelingId, String navn, Integer sjef) {
		this.avdelingId=avdelingId;
		this.sjef=sjef;
		this.navn=navn;
	}

	@Override
	public String toString() {
		return "avdeling [avdelingId=" + avdelingId + ", navn=" + navn + ", sjef=" + sjef + "]"+ "\n";
	}

	public Integer getAvdelingId() {
		return avdelingId;
	}

	public void setAvdelingId(Integer avdelingId) {
		this.avdelingId = avdelingId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getSjef() {
		return sjef;
	}

	public void setSjef(Integer sjef) {
		this.sjef = sjef;
	}

}
