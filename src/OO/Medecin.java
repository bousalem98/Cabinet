package OO;

public class Medecin {
	
	private int code;
	private String nom;
	private String prenom;
	private String password;
	private String spécialité;
	public Medecin(int code, String nom, String prenom, String password, String spécialité) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.spécialité = spécialité;
	}
	public Medecin() {
		// TODO Auto-generated constructor stub
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpécialité() {
		return spécialité;
	}
	public void setSpécialité(String spécialité) {
		this.spécialité = spécialité;
	}
}
