package personnages;

public class Druide {

	private String nom;
	private int force;
	private Chaudron chaudron;

	public Druide(String nom, int force) {
		this.nom = nom;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concoté " + quantite + " doses de portion magique. Elle a une force de " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		if (!chaudron.resterPotion()) {
			parler("Désolé " + gaulois.getNom() + " il n'y a plus une seule goutte de potion.");

		} else if (gaulois.getNom().equals(" Obélix ")) {
			parler("Non, " + gaulois.getNom() + " Non !... Et tu le sais très bien !");

		} else {
			int forcePotion = chaudron.prendreLouche();
			gaulois.boirePotion(forcePotion);
			parler("Tien " + gaulois.getNom() + " un peu de potion magique.");
		}
	}
}
