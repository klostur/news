package vp.spring.rcs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vest {
	@Id
	@GeneratedValue
	private Long id;
	private String naslov;
	@Column(columnDefinition = "TEXT")
	private String opis;
	@Column(columnDefinition = "TEXT")
	private String sadrzaj;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Kategorija kategorija;
	
//	@OneToMany
////	@ElementCollection(targetClass=Komentar.class)
//	private List<Komentar> komentari;

	public Vest(String naslov, String opis, String sadrzaj, Kategorija kategorija) {
		super();
		this.naslov = naslov;
		this.opis = opis;
		this.sadrzaj = sadrzaj;
		this.kategorija = kategorija;
	}

	public Vest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	
	
}
