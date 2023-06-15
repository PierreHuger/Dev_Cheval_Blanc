package presentation;

import javafx.beans.property.*;

public class Client 
{
	static private int compteur_numero = 1;
	private SimpleStringProperty civilite;
	private SimpleIntegerProperty numero;
	private SimpleStringProperty nom;
	private SimpleStringProperty prenom;
	private SimpleStringProperty adresse1;
	private SimpleStringProperty adresse2;
	private SimpleStringProperty code_postal;
	private SimpleStringProperty ville;
	private SimpleStringProperty numero_de_telephone;
	private SimpleStringProperty email;
	
	public Client(String civilite,String nom,String prenom,String adresse1,String adresse2,String code_postale,String ville,String numero_de_telephone,String email)
	{
		this.civilite = new SimpleStringProperty(civilite);
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.adresse1 = new SimpleStringProperty(adresse1);
		this.adresse2 = new SimpleStringProperty(adresse2);
		this.code_postal = new SimpleStringProperty(code_postale);
		this.ville = new SimpleStringProperty(ville);
		this.numero_de_telephone = new SimpleStringProperty(numero_de_telephone);
		this.email = new SimpleStringProperty(email);
		this.numero = new SimpleIntegerProperty(Client.compteur_numero);
		Client.compteur_numero++;
	}
	

	public static int getCompteur_numero() {
		return compteur_numero;
	}

	public static void setCompteur_numero(int compteur_numero) {
		Client.compteur_numero = compteur_numero;
	}
	

	public String getCivilite() {
		return civilite.get();
	}

	public void setCivilite(String civilite) {
		this.civilite.set(civilite);;
	}
	
	public StringProperty getCiviliteProperty()
	{
		return this.civilite;
	}

	public int getNumero() {
		return numero.get();
	}

	public void setNumero(int numero) {
		this.numero.set(numero);;
	}
	
	public StringProperty getNumeroProperty()
	{
		return this.numero_de_telephone;
	}

	public String getNom() {
		return nom.get();
	}

	public void setNom(String nom) {
		this.nom.set(nom);;
	}
	
	public StringProperty getNomProperty()
	{
		return this.nom;
	}

	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
	
	public StringProperty getPrenomProperty()
	{
		return this.prenom;
	}

	public String getAdresse1() {
		return adresse1.get();
	}

	public void setAdresse1(String adresse1) {
		this.adresse1.set(adresse1);
	}
	
	public StringProperty getAdresse1Property()
	{
		return this.adresse1;
	}

	public String getAdresse2() {
		return adresse2.get();
	}

	public void setAdresse2(String adresse2) {
		this.adresse2.set(adresse2);
	}
	
	public StringProperty getAdresse2Property()
	{
		return this.adresse2;
	}

	public String getCode_postale() {
		return code_postal.get();
	}

	public void setCode_postale(String code_postale) {
		this.code_postal.set(code_postale);;
	}
	
	public StringProperty getCode_PostaleProperty()
	{
		return this.code_postal;
	}

	public String getVille() {
		return ville.get();
	}

	public void setVille(String ville) {
		this.ville.set(ville);;
	}
	
	public StringProperty getVilleProperty()
	{
		return this.ville;
	}

	public String getNumero_de_telephone() {
		return numero_de_telephone.get();
	}

	public void setNumero_de_telephone(String numero_de_telephone) {
		this.numero_de_telephone.set(numero_de_telephone);;
	}
	
	public StringProperty getNumero_de_telephoneProperty()
	{
		return this.numero_de_telephone;
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);;
	}
	
	public StringProperty getEmailProperty()
	{
		return this.email;
	}
	
	public void setClient(String civilite,String nom,String prenom,String adresse1,String adresse2,String code_postal,String ville,String numero_de_telephone,String email)
	{
		this.civilite.set(civilite);
		this.nom.set(nom);
		this.prenom.set(prenom);
		this.adresse1.set(adresse1);
		this.adresse2.set(adresse2);
		this.code_postal.set(code_postal);
		this.ville.set(ville);
		this.numero_de_telephone.set(numero_de_telephone);
		this.email.set(email);
	}
	
	
}
