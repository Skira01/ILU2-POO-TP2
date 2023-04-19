package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infos = controlAfficherMarche.donnerInfosMArche();
		if (infos.length == 0){
			System.out.println("Le marché est vide, revenez plus tard");
		}
		else {
			System.out.println(nomAcheteur+", vous trouverez au marché :");
			int i = 0;
			while(i<infos.length) {
				StringBuilder talkToUser = new StringBuilder();
				talkToUser.append("-"+infos[i]+" qui vends ");
				i++;
				talkToUser.append(infos[i]+" ");
				i++;
				talkToUser.append(infos[i]);
				System.out.println(talkToUser);
				i++;
			}
		}
	}
}
