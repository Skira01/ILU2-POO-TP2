package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;


	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		System.out.println("Quel produit voulez-vous acheter ?\n");
		String produit = scan.nextLine();
		Gaulois[] vendeurs = controlAcheterProduit.trouveVendeurs(produit);
		System.out.println("Chez quel commenrçant voulez-vous acheter des "+produit+" ?\n");
		String nomVendeur = scan.nextLine();
		Gaulois vendeur = controlAcheterProduit.trouverGaulois(nomVendeur);
		boolean ok = false;
		for (int i = 0; i<vendeurs.length;i++) {
			if (vendeur == vendeurs[i]) {
				ok = true;
				break;
			}
			else {
				System.out.println("Désolé mais ce vendeur ne vends pas ce produit.");
				return;
			}
		}
		System.out.println(nomAcheteur+" se déplace jusqu'è l'étal du vendeur "+vendeur+"\n");
		int quantite = Clavier.entrerEntier("Bonjour, "+nomAcheteur+"\nCombien de "+produit+" voulez-vous acheter ?\n");
		controlAcheterProduit.acheterProduit(quantite,vendeur);
		System.out.println(nomAcheteur+" achète "+quantite+" "+produit+" à "+nomVendeur);
		
	}
}
