package OO;

public class Ordonance {

	private String nom;
	private int nbprise;
	private int nbboite;
	private int conscode;
	public Ordonance() {
		// TODO Auto-generated constructor stub
	}
	


	public Ordonance(String nom, int nbprise, int nbboite, int conscode) {
		super();
		this.nom = nom;
		this.nbprise = nbprise;
		this.nbboite = nbboite;
		this.conscode = conscode;
	}



	public Ordonance(String nom, int nbprise, int nbboite) {
		super();
		this.nom = nom;
		this.nbprise = nbprise;
		this.nbboite = nbboite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbprise() {
		return nbprise;
	}
	public void setNbprise(int nbprise) {
		this.nbprise = nbprise;
	}
	public int getNbboite() {
		return nbboite;
	}
	public void setNbboite(int nbboite) {
		this.nbboite = nbboite;
	}
	public int getConscode() {
		return conscode;
	}

	public void setConscode(int conscode) {
		this.conscode = conscode;
	}
	
	
	
}
