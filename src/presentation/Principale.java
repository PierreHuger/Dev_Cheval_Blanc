package presentation;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modele.AccesInfo;
import vue.FenAcceuil;
import vue.FenAjouterClient;
import vue.FenModifierClient;

public class Principale extends Application
{
	static private FenAcceuil fenAcceuil = new FenAcceuil();
	static private FenAjouterClient fenAjouterClient = new FenAjouterClient();
	static private FenModifierClient fenModifierClient = new FenModifierClient();
	
	public void start(Stage f) throws Exception
	{
		AccesInfo.connexion();
		fenAcceuil.init(AccesInfo.getDonnees());
		fenAcceuil.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
		fenAjouterClient.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
		fenModifierClient.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
		fenAcceuil.show();
	}
	
	static public void main(String[] args) 
	{ 
		Application.launch(args); 
	}
	
	
	static public void ouvrirFenAjouterClient()
	{
		fenAjouterClient.show();
	}
	
	static public void ouvrirFenModifierClient(Client e)
	{
		fenModifierClient.init(e);
		fenModifierClient.show();
	}
	
	
	
	static public void supprimerClient(Client e) 
	{
		fenAcceuil.supprimerClient(e);
		AccesInfo.supprimerClient(e);
	}
	
	static public void ajouterClient(Client e) 
	{
		fenAcceuil.ajouterClient(e);
		AccesInfo.ajouterClient(e);
	}
	
	static public void modifierClient(Client e) {
		AccesInfo.modifierClient(e);
		// actualiser l'ObservableList dans la fenetre liste des employes
		fenAcceuil.modifierClient(e);	
	}
	
	static public Client getClient(int numeroClient)
	{
		return AccesInfo.getClient(numeroClient);
	}
	
	static public void rechercherClient()
	{
		fenAcceuil.rechercherClient();
	}
	
	static public void actualiserDonnees()
	{
		fenAcceuil.actualiserDonnes();
	}
	
	
	
}
