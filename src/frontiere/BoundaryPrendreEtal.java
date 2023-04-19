package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)!=true) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici");
		}
		else {
			StringBuilder talkToUser = new StringBuilder();
			talkToUser.append("Bonjour! "+nomVendeur+" je vais regarder si je peut vous trouver un étal\n");
			if(controlPrendreEtal.resteEtals()== false) {
				System.out.println("Je suis désolé "+nomVendeur+" je n'ai plus d'etals qui ne soit pas déjà occupé\n");
				
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder request = new StringBuilder();
		request.append("C'est parfait, il me reste un étal pour vous\n");
		request.append("Il me faudrais quelques renseignement\n");
		request.append("Quel produit souhaitez-vous vendre ?");
		System.out.println(request.toString());
		String produit = scan.nextLine();
		request.delete(0, request.length());
		request.append("Combien voulez-vous en vendre ?");
		int quantite = Clavier.entrerEntier(request.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		if(numeroEtal != -1) {
			System.out.println(
					"Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numeroEtal
					);
		}
		
}
}
