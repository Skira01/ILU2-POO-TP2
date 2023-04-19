package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean isV = controlLibererEtal.isVendeur(nomVendeur);
		if (isV != true) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
			}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donneesEtal[0];
			if(etalOccupe == ("true")) {
				StringBuilder lib = new StringBuilder();
				lib.append("Vous avez vendu "+donneesEtal[4]+" sur "+donneesEtal[3]+" "+donneesEtal[2]+"\n");
				lib.append("Au revoir, "+nomVendeur+", passez une bonne journée.");
				System.out.println(lib);
			}
		}
	}

}
