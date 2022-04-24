package OO;

public class Medicament {

	
	private String nom;
	private String form;
	private String Dosage;
	
	public Medicament() {
		// TODO Auto-generated constructor stub
	}

	public Medicament(String nom, String form, String dosage) {
		super();
		this.nom = nom;
		this.form = form;
		Dosage = dosage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}
	
	
}
