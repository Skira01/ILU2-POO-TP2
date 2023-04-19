package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;
					
				case 2:
					StringBuilder qV = new StringBuilder();
					qV.append("Bienvenue villageois"+nomVisiteur+"\n");
					qV.append("Quelle est votre force ?");
					int forceV = Clavier.entrerEntier(qV.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,forceV);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder qD = new StringBuilder();
		qD.append("Bienvenue villageois"+nomVisiteur+"\n");
		qD.append("Quelle est votre force ?");
		int forceD = Clavier.entrerEntier(qD.toString());
		int effetPotionMin = 0;
		int effetPotionMax = -1;
		do {
			 effetPotionMin = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?\n");
			 effetPotionMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?\n");
			 if (effetPotionMin < effetPotionMax) {
				 break;
			 }
			 else {
				 System.out.println("Attention Druide, vous vous êtes trompés entre le maximum et le minimum !");
			 }
		
		}while(effetPotionMin > effetPotionMax);
		controlEmmenager.ajouterDuide(nomVisiteur, forceD, effetPotionMin, effetPotionMax);
	}
}
