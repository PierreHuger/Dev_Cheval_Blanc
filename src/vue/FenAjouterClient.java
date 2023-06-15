/**************************/
/**********DEBUT***********/
/**************************/
package vue;

/**************************/
/********IMPORTS***********/
/**************************/

import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.Client;
import presentation.Principale;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/***************************************************/
/***DÉCLARATION DE TOUS LES COMPOSANTS DE LA PAGE***/
/***************************************************/


public class FenAjouterClient extends Stage {
	Button bnOk= new Button("Ok");
	Button bnAnnuler= new Button("Annuler");
	
	private HBox boxGenre = new HBox();
	
	private HBox boutons = new HBox();
	
	private HBox nomprenom = new HBox();
	private VBox prenomBox= new VBox();
	private VBox nomBox= new VBox();
	
	private HBox codeVille = new HBox();
	private VBox codeBox= new VBox();
	private VBox villeBox= new VBox();

	private VBox racine= new VBox();
		
	
	private RadioButton monsieur= new RadioButton("Monsieur");
	private  RadioButton madame= new RadioButton ("Madame");
	private  RadioButton autre= new RadioButton ("Autre");


	private Label titreprenom= new Label("Prénom*");
	private TextField prenom= new TextField();
	
	private Label titrenom= new Label("Nom*");
	private TextField nom= new TextField();
	
	private Label titreAdresse= new Label("Adresse*");
	private TextField adresse= new TextField();
	private Label titreAdresse2= new Label("Adresse 2");
	private TextField adresse2= new TextField();
	
	private Label titreCodePostal= new Label("Code Postal*");
	private TextField codePostal= new TextField();
	
	private Label titreVille= new Label("Ville*");
	private TextField ville= new TextField();
	
	private Label titreTel= new Label("Téléphone*");
	private TextField tel= new TextField();
	
	private Label titreMail= new Label("Mail");
	private TextField mail= new TextField();
	
	
	ToggleGroup civilite = new ToggleGroup();
	
	private Tooltip infoTel = new Tooltip("Numéro au format standard ou international");
	private Tooltip infoAdresse = new Tooltip("Adresse française ou étrangère");
	private Tooltip infoMail = new Tooltip("Adresse email de n'importe quel pays");
	
	/*******************************************/
	/**********PARAMÉTRAGE DE LA PAGE***********/
	/*******************************************/
	
	
	
	public FenAjouterClient()
	{
		

		this.setTitle("Formulaire d'inscription");
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinWidth(400);
		this.setMinHeight(330);
		this.setResizable(false);
		Scene s = new Scene (creerRacine());
		this.setScene(s);

		//CHANGEMENT DE COULEUR DES BOUTONS LORSQUE LA SOURIS LES SURVOLE//
		
		bnAnnuler.setOnMouseEntered(e -> {bnAnnuler.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px");});
		bnAnnuler.setOnMouseExited(e -> {bnAnnuler.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");});
		bnOk.setOnMouseEntered(e -> {bnOk.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px");});
		bnOk.setOnMouseExited(e -> {bnOk.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");});
		
		
		bnOk.setOnAction(e -> 
		{
			//Variable civilite pour stocker la genre dans un String
			String civilite;
			if (monsieur.isSelected())
			{
				civilite = "Monsieur";
			}
			else if (madame.isSelected())
			{
				civilite = "Madame";
			}
			else
			{
				civilite = "Autre";
			}
			
			if (nom.getText().isEmpty() | prenom.getText().isEmpty() | adresse.getText().isEmpty() | codePostal.getText().isEmpty() | ville.getText().isEmpty() | tel.getText().isEmpty())
			{
				Alert erreurChampsVide = new Alert(AlertType.ERROR, "Aucun champs obligatoire ne doit rester vide. Veuillez modifier ces champs", ButtonType.OK);
				erreurChampsVide.setTitle("informations : Champs obligatoire manquant");
				erreurChampsVide.showAndWait();
			}
			else if (!prenom.getText().matches("^[a-zA-Z]*-?[a-zA-Z]*$"))
			{
				Alert erreurPrenom = new Alert(AlertType.ERROR, "Le prénom ne doit pas contenir de chiffre(s) ou d'espace(s). Veuillez modifier ce champs", ButtonType.OK);
				erreurPrenom.setTitle("Prénom : Format incorrecte");
				erreurPrenom.showAndWait();
			}
			else if (!nom.getText().matches("^[a-zA-Z]*-? ?[a-zA-Z]*$"))
			{
				Alert erreurNom = new Alert(AlertType.ERROR, "Le nom ne doit pas contenir de chiffre(s). Veuillez modifier ce champs", ButtonType.OK);
				erreurNom.setTitle("Nom : Format incorrecte");
				erreurNom.showAndWait();
			}
			else if (!ville.getText().matches("^[a-zA-Z]*-? ?[a-zA-Z]*$"))
			{
				Alert erreurVille = new Alert(AlertType.ERROR, "La ville ne doit pas contenir de chiffre(s). Veuillez modifier ce champs", ButtonType.OK);
				erreurVille.setTitle("Ville : Format incorrecte");
				erreurVille.showAndWait();
			}
			else if (!mail.getText().isEmpty() & !mail.getText().contains("@"))
			{
				Alert erreurMail = new Alert(AlertType.ERROR, "L'adresse email doit contenir un @ pour être valide. Veuillez modifier ce champs", ButtonType.OK);
				erreurMail.setTitle("Mail : Format incorrecte");
				erreurMail.showAndWait();
			}
			else if (!tel.getText().matches("(0|\\+33)[1-9]( *[0-9]{2}){4}"))
			{
				Alert erreurTel = new Alert(AlertType.ERROR, "Le numéro de téléphone ne doit contenit que des numéro ou être au format international. Veuillez modifier ce champs", ButtonType.OK);
				erreurTel.setTitle("Téléphone : Format incorrecte");
				erreurTel.showAndWait();
			}
			else
			{
			Principale.ajouterClient(new Client(civilite,nom.getText(),prenom.getText(),adresse.getText(),adresse2.getText(),codePostal.getText(),ville.getText(),tel.getText(),mail.getText()));
			Alert alerteCreation = new Alert(AlertType.INFORMATION, "Le client a bien été créé", ButtonType.OK);
			alerteCreation.setTitle("Confirmation de création");
			nom.clear();
			prenom.clear();
			adresse.clear();
			adresse2.clear();
			codePostal.clear();
			ville.clear();
			tel.clear();
			mail.clear();
			monsieur.setSelected(true);
			this.close();
			Principale.rechercherClient();
			alerteCreation.showAndWait();
			}
			
		});
		
		
	}
	
	
	/******************************************************************************/
	/**********PLACEMENT DES BOUTONS, CRÉATION DES EXCPETIONS, DES DÉCOS***********/
	/******************************************************************************/
	
	
	
	
	
	public Parent creerRacine()
	{
		//PLACEMENT DES BOUTONS EN BAS À DROIT DE LA PAGE//
		
		boutons.getChildren().addAll(bnOk, bnAnnuler);
		boutons.setAlignment(Pos.BOTTOM_RIGHT);
		boutons.setSpacing(10);
		boutons.setPadding(new Insets(5));
		
		
		//VÉRIFICATIONS ÉVITANTS LE DÉPASSEMENT DE LA TAILLE DE TEXTFIELD//
				
		prenom.setOnKeyReleased(e ->{
			 while (prenom.getText().length() >=20)
			 {
			prenom.deletePreviousChar();
			
			 }
			 });
		
		nom.setOnKeyReleased(e ->{
			 while (nom.getText().length() >=20)
			 {
			nom.deletePreviousChar();
			 }
			 });
		
		//MISE EN ÉVIDENCE D'EEREUR EN CAS DE MAUVAIS REMPLISSAGE DU FORMULAIRE //
		
		
		this.ville.setOnKeyReleased(e -> {
			if (ville.getText().length() >= 32) {
			this.ville.deletePreviousChar();;
			Alert erreur = new Alert(AlertType.ERROR, "La ville ne peut pas dépasser 32 caractères. Veuillez modifier ce champ.", ButtonType.OK);
			erreur.setTitle("Ville : format incorrect");
			erreur.showAndWait();
			}
			});
		
		
		this.adresse.setOnKeyTyped(e -> {
			if (adresse.getText().length() >= 32) {
			this.adresse.deletePreviousChar();;
			Alert erreur = new Alert(AlertType.ERROR, "L'adresse 1 et 2 doivent être sur 32 caractères. Veuillez modifier ce champ.", ButtonType.OK);
			erreur.setTitle("Adresse 1 : format incorrect");
			erreur.showAndWait();
			}
			});
		
		this.adresse2.setOnKeyTyped(e -> {
			if (adresse2.getText().length() >= 32) {
			this.adresse2.deletePreviousChar();;
			Alert erreur = new Alert(AlertType.ERROR, "L'adresse 1 et 2 doivent être sur 32 caractères. Veuillez modifier ce champ.", ButtonType.OK);
			erreur.setTitle("Adresse 2 : format incorrect");
			erreur.showAndWait();
			}
			});
		
		this.codePostal.setOnKeyTyped(e -> {
			if (codePostal.getText().length() > 5) {
			this.codePostal.deletePreviousChar();;
			Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 chiffres. Veuillez modifier ce champ.", ButtonType.OK);
			erreur.setTitle("Code postal : format incorrect");
			erreur.showAndWait();
			}
			});
		
		this.mail.setOnKeyTyped(e -> {
			if (mail.getText().length() >= 50) {
			this.mail.deletePreviousChar();;
			Alert erreur = new Alert(AlertType.ERROR, "Le mail doit être sur 50 caractères. Veuillez modifier ce champ.", ButtonType.OK);
			erreur.setTitle("Mail : format incorrect");
			erreur.showAndWait();
			}
			});
		
		//PROGRAMMATION DE LA FONCTION DES BOUTONS BNOK ET BNANNULER//
		
		bnAnnuler.setOnAction(e -> this.close() );
		bnOk.setOnAction(e -> {} );
		
		//RÉGLAGE DE LA TAILLE DE LA RACINE CONTENANT TOUT SAUF LES BOUTONS//
		
		racine.minHeight(150);
		racine.minWidth(400);
		
		//MISE EN FORME DE LA RACINE AVEC UNE BORDURE NOIRE GRASSE ET UN FOND BLEU//
		
		//BORDURE//
		racine.setBorder((new Border(new BorderStroke(
				Color.BLACK, //couleur du contour
				BorderStrokeStyle.SOLID, //forme du contour
				new CornerRadii(0), //taille d’arrondi des angles
				new BorderWidths(1) //épaisseur du contour
				))));
		
		//FONDS//
		racine.setBackground(new Background(new BackgroundFill(
				Color.WHITE, //couleur du fond
				new CornerRadii(0), //taille d’arrondi des angles
				new Insets(0) // taille du padding du fond
				)));
		
		//MISE EN COULEUR DE CHAQUE ÉLÉMENTS DE LA PAGE//
		
		racine.setStyle("-fx-background-color: #1D2244;");
        titreprenom.setStyle("-fx-text-fill: white;");
        monsieur.setStyle("-fx-text-fill: white;");
        madame.setStyle("-fx-text-fill: white;");
        autre.setStyle("-fx-text-fill: white;");
        titrenom.setStyle("-fx-text-fill: white;");
        titreAdresse.setStyle("-fx-text-fill: white;");
        titreAdresse2.setStyle("-fx-text-fill: white;");
        titreCodePostal.setStyle("-fx-text-fill: white;");
        titreVille.setStyle("-fx-text-fill: white;");
        titreTel.setStyle("-fx-text-fill: white;");
        titreMail.setStyle("-fx-text-fill: white;");
        
        
        prenom.setStyle("-fx-control-inner-background: #816d62;");
        nom.setStyle("-fx-control-inner-background: #816d62;");
        adresse.setStyle("-fx-control-inner-background: #816d62;");
        adresse.setTooltip(infoAdresse);
        adresse2.setStyle("-fx-control-inner-background: #816d62;");
        codePostal.setStyle("-fx-control-inner-background: #816d62;");
        ville.setStyle("-fx-control-inner-background: #816d62;");
        tel.setStyle("-fx-control-inner-background: #816d62;");
        tel.setTooltip(infoTel);
        mail.setStyle("-fx-control-inner-background: #816d62;");
        mail.setTooltip(infoMail);


        //TAILLE DE CHAQUE LABELS// 
		
		titrenom.setPrefWidth(75);
		titreprenom.setPrefWidth(75);
		titreAdresse.setPrefWidth(75);
		adresse2.setPrefWidth(75);
		titreCodePostal.setPrefWidth(125);
		titreVille.setPrefWidth(75);
		titreTel.setPrefWidth(75);
		titreMail.setPrefWidth(75);
		
		//TAILLE DES TEXTFIELDS//

		prenom.setMaxWidth(175);
		nom.setMaxWidth(175);
		adresse.setMaxWidth(375);
		adresse2.setMaxWidth(375);
		codePostal.setMaxWidth(60);
		ville.setMinWidth(275);
		ville.setMaxWidth(275);
		tel.setMaxWidth(375);
		mail.setMaxWidth(375);
		codeBox.setMaxWidth(110);

		
		//CRÉATION DU GROUPE DE BOUTONS MADAME MONSIEUR ET AUTRE//
		
		
		//IMPLANTATION DES BOUTONS DANS LE GROUPEMENT ET CHOIX PAR DÉFAUT//
		
		civilite.getToggles().addAll(monsieur, madame, autre);
		monsieur.setSelected(true);
		
		//IMPLANTATION DE CHAQUE ÉLÉMENTS DANS LEURS HBOX/VBOX RESPECTIVES//
		
		boxGenre.getChildren().addAll(monsieur, madame, autre);
		prenomBox.getChildren().addAll(titreprenom,prenom);
		nomBox.getChildren().addAll(titrenom,nom);
		codeBox.getChildren().addAll(titreCodePostal,codePostal);
		villeBox.getChildren().addAll(titreVille,ville);
		nomprenom.getChildren().addAll(prenomBox, nomBox);
		codeVille.getChildren().addAll(codeBox, villeBox);
		racine.getChildren().addAll(boxGenre,nomprenom,titreAdresse,adresse,titreAdresse2,adresse2,codeVille,titreTel,tel,titreMail,mail, boutons);

		
		//MISE EN OEUVRE D'ESPACE ENTRE LES ÉLÉMENTS
		
		monsieur.setPadding(new Insets(0,10,0,0));
		madame.setPadding(new Insets(0,10,0,0));
		autre.setPadding(new Insets(0,10,0,0));
		nomBox.setPadding(new Insets(0, 0, 0, 30));
		villeBox.setPadding(new Insets(0, 0, 0, -15));
		racine.setPadding(new Insets(5));

		//DESIGN DES BOUTONS OK ET ANNULER//

		bnAnnuler.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		bnAnnuler.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");
		bnAnnuler.setPrefHeight(50);
		
		bnOk.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		bnOk.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");
		bnOk.setPrefHeight(50);
		
		return racine;
	}
	
}





