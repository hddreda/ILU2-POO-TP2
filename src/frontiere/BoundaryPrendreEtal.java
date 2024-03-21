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
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}

		StringBuilder message = new StringBuilder();

		message.append("Bonjour ");
		message.append(nomVendeur);
		message.append(", je vais regarder si je peux vous trouver un étal.\n");

		if (controlPrendreEtal.resteEtals()) {
			installerVendeur(nomVendeur);
		} else {
			message.append("Désolée ");
			message.append(nomVendeur);
			message.append(", je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
		}

		System.out.println(message.toString());
	}

	private void installerVendeur(String nomVendeur) {
		 StringBuilder message = new StringBuilder();
		 message.append("C'est parfait, il me reste un étal pour vous !\n");
         message.append("Il me faudrait quelques renseignements :\n");
         message.append("Quel produit souhaitez-vous vendre ?\n");

         System.out.println(message.toString());
         StringBuilder message2 = new StringBuilder();
         String produit = scan.nextLine();
         message2.append("Combien souhaitez-vous en vendre ?\n");
         int quantite = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
         
         int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
         if (numEtal != -1) {
             message2.append("Le vendeur ");
             message2.append(nomVendeur);
             message2.append(" s'est installé à l'étal n°");
             message2.append(numEtal);
         }
         System.out.println(message2.toString());
	}
}
