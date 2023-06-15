package modele;

import java.util.ArrayList;
import presentation.Client;

public class AccesInfo 
{
	private static ArrayList<Client> listeClients = new ArrayList<Client>();
	
	
	static public void connexion()
	{
		//Ajout des clients au préalable
		listeClients.add(new Client("Monsieur","Le Gall","Elouan","3 rue Jean Savidan","27 rue des programmeurs","22300","Lannion","07 84 15 55 60","elouan.legall@univ-rennes1.fr"));
		listeClients.add(new Client("Monsieur","Léon--Plévert","Glenn","1 rue du mouton noi","","22300","Lannion","07 70 11 06 26","Glenn.léon--plévert@univ-rennes1.fr"));
		listeClients.add(new Client("Monsieur","Huger","Pierre","36 rue d'erling Haaland","","M40","Manchester","441 782 493 985","pierre.huger@univ-rennes1.fr"));
		listeClients.add(new Client("Madame","Stacy","Gwenn","7409 Woodland Ave. Flushing","","11355","New York","202-555-0192","Gwen.stacy@gmail.com"));
		listeClients.add(new Client("Monsieur","Gosling","Ryan","LLC 9100 Wilshire Blvd Suite 1000 West Beverly Hills","","33004","Los Angeles","213-555-012-254","Renez.jean@gaymail.com"));
		listeClients.add(new Client("Autre","Leto","Jared","rue des alysées","77 voie de la voie","77800","Fontanno","02 85 68 95 47","Jared.Leto@orange.fr"));
		listeClients.add(new Client("Monsieur","Buckel","Angely","Crous de Lannion","","22300","Lannion","07 85 69 14 60","Angely.buckel@etudiant.univ-rennes1.fr"));
		listeClients.add(new Client("Madame","De Bretagne","Anne","4 Pl. Marc Elder","","44000","Nantes","06 06 06 06 06","Anne_de_Bretagne@reine.bzh"));
		listeClients.add(new Client("Madame","Taylor-Joy","Anya","6 chess road","","33014","Los Angeles","254-782-225-698","Taylor-Joy-Anya@hollywood.mail"));
		listeClients.add(new Client("Monsieur","Parker","Peter","20 Ingram Street","","10001","New York","014-521-254-748","PeterParker29@gmail.com"));
		listeClients.add(new Client("Madame","Paradis","Vanessa","3 avenue des Marais","4 rd California st","75003","Paris","05 45 74 85 96","Vanessa.Paradis@starmail.com"));
		listeClients.add(new Client("Monsieur","Menes","Pierre","5 avenue des burgers","","75003","Paris","08 95 47 52 45","Burger.PierreMenes@Macdonald.fr"));
		listeClients.add(new Client("Madame","aboubou","Fatima","6 rue des bananes","","69691","Dakar","01 25 65 47 41","jspquoimettre@pierre.com"));
		listeClients.add(new Client("Autre","Chevalier","Benoit","5 rue des lgbtqia+","","54100","Toulouse","04 54 26 85 94","benoit.chevalier@gayMail.com"));
	}
	
	
	
	static public ArrayList<Client> getDonnees()
	{
		return listeClients;
	}
	
	static public void supprimerClient(Client e) 
	{
		boolean trouve = false;
		int i=0;
		while (!trouve && i<listeClients.size()) 
		{
			if (listeClients.get(i).getNumero()==e.getNumero())
			{
				listeClients.remove(i);
				trouve = true;
			}
			i++;
		}
	}
	
	static public void ajouterClient(Client e) 
	{
		listeClients.add(e);
	}
	
	static public void modifierClient(Client e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<listeClients.size()) {
			if (listeClients.get(i).getNumero()==e.getNumero()){
				listeClients.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
	
	static public Client getClient(int numeroClient)
	{
		Client resultat = null;
		boolean trouve = false;
		int i=0;
		while (!trouve && i<listeClients.size()) {
			if (listeClients.get(i).getNumero()==numeroClient){
				trouve = true;
				resultat = listeClients.get(i);
			}
			i++;
		}
		return resultat;
	}
	
	
}
