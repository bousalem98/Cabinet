package OO;

import java.util.Calendar;
import java.util.Date;

public class Patient {
    private int code;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse,Age;
    private Date  dateNaissance;
    private String tel;
    private String gS;
    private int poids;
    private int taille;
    
    public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int code, String nom, String prenom, String sexe, String adresse, Date dateNaissance, String tel, String gS,
			int poids, int taille) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
	    this.sexe = sexe;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.gS = gS;
		this.poids = poids;
		this.taille = taille;
	}
	public Patient( String nom, String prenom, String sexe, String adresse, Date dateNaissance, String tel, String gS,
			int poids, int taille) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	    this.sexe = sexe;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.gS = gS;
		this.poids = poids;
		this.taille = taille;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public Date getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getgS() {
		return gS;
	}



	public void setgS(String gS) {
		this.gS = gS;
	}



	public int getPoids() {
		return poids;
	}



	public void setPoids(int poids) {
		this.poids = poids;
	}



	public int getTaille() {
		return taille;
	}



	public void setTaille(int taille) {
		this.taille = taille;
	}

//ces methode en dessous sont pour l'importation de donner de classe PatientPanel vers ConsulPanel il n y a pas de field age dans base de donnee
	public Patient(int code, String nom, String prenom, String sexe, String Age) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.Age = Age;

	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}


	

   
}
