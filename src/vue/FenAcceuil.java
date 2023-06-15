package vue;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import presentation.Client;
import presentation.Principale;
import java.util.Optional;


public class FenAcceuil extends Stage
{
	static private ObservableList<Client> lesClients = FXCollections.observableArrayList();
	static private ObservableList<Client> lesClientsRecherche = FXCollections.observableArrayList();

	//Les composants de la fenêtre
	private TableView<Client> tableClients = new TableView<Client>();
	
	//Les Panes
	private VBox racine = new VBox();
	private HBox sanslogo = new HBox();
	private VBox rechercheNumero = new VBox();
	private VBox rechercheNom = new VBox();
	private VBox recherchePrenom = new VBox();
	private HBox champsRecherche = new HBox();
	
	private VBox informationsClients = new VBox();
	
	private VBox informationsCivilite = new VBox();
	private VBox informationsAdresse = new VBox();
	private VBox informationsCode_postale = new VBox();
	private VBox informationsVille = new VBox();
	private VBox informationsEmail = new VBox();
	private HBox informationsVilleAndCode_postale = new HBox();
	private HBox informationsCiviliteAndEmail = new HBox();
	
	private AnchorPane boxBoutons = new AnchorPane();
	private VBox rassemblement = new VBox();
	
	
	//Les boutons
	private Button bnFermer = new Button("Fermer");
	private Button bnAjouter = new Button("Ajouter");
	private Button bnModifier = new Button("Modifier");
	private Button bnSupprimer = new Button("Supprimer");
	
	//Les textFields
	private TextField numeroTextField = new TextField();
	private TextField nomTextField = new TextField();
	private TextField prenomTextField = new TextField();
	
	//Les textFields pour afficher des informations
	private TextField civiliteTextFieldAffichage = new TextField();
	private TextField adresse1TextFieldAffichage = new TextField();
	private TextField adresse2TextFieldAffichage = new TextField();
	private TextField villeTextFieldAffichage = new TextField();
	private TextField code_postaleTextFieldAffichage = new TextField();
	private TextField emailTextFieldAffichage = new TextField();
	
	//Les labels
	private Label numeroLabel = new Label("Id");
	private Label nomLabel = new Label("Nom");
	private Label prenomLabel = new Label("Prénom");
	private Label civiliteLabel = new Label("Civilité");
	private Label adresseLabel = new Label("Adresse");
	private Label code_postaleLabel = new Label("Code Postal");
	private Label emailLabel = new Label("Mail");
	private Label villeLabel = new Label("Ville");
	
	private MenuItem optionAjouter = new MenuItem("Ajouter");
	private MenuItem optionModifier = new MenuItem("Modifier");
	private MenuItem optionSupprimer = new MenuItem("Supprimer");
	
	private ContextMenu menu = new ContextMenu( optionAjouter,new SeparatorMenuItem(),optionModifier,new SeparatorMenuItem(),optionSupprimer);
	
	//Les images
	Image logo = new Image(this.getClass().getResourceAsStream("logo.png"));
	private ImageView logoView = new ImageView(logo);
	
	public FenAcceuil()
	{
		//Paramètres de la fenêtre
		this.setTitle("Gestion des clients");
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));
		
		//Écouteurs de la fenêtre
		bnFermer.setOnAction(e ->  System.exit(0) );
		
		bnAjouter.setOnMouseEntered(e -> {bnAjouter.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px");});
		bnAjouter.setOnMouseExited(e -> {bnAjouter.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");});
		
		bnModifier.setOnMouseEntered(e -> {bnModifier.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px");});
		bnModifier.setOnMouseExited(e -> {bnModifier.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");});
		
		bnSupprimer.setOnMouseEntered(e -> {bnSupprimer.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px");});
		bnSupprimer.setOnMouseExited(e -> {bnSupprimer.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");});
		
		bnFermer.setOnMouseEntered(e -> {bnFermer.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px");});
		bnFermer.setOnMouseExited(e -> {bnFermer.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");});
		
		//Ajouter un client
		bnAjouter.setOnAction(e -> {Principale.ouvrirFenAjouterClient();});
		
		optionAjouter.setOnAction(e -> {Principale.ouvrirFenAjouterClient();});
		
		//Modifier un client
		bnModifier.setOnAction(e -> {Principale.ouvrirFenModifierClient(tableClients.getSelectionModel().getSelectedItem());});
		
		optionModifier.setOnAction(e -> {Principale.ouvrirFenModifierClient(tableClients.getSelectionModel().getSelectedItem());});
		
		
		//Supprimer un client
		bnSupprimer.setOnAction(e -> supprimerClient(e));
		
		optionSupprimer.setOnAction(e -> supprimerClient(e));
		
		//Affichage des clients
		tableClients.setOnMouseClicked(e -> 
		{
			if (tableClients.getSelectionModel().getSelectedItem() != null)
			{
				civiliteTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getCivilite());
				emailTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getEmail());
				adresse1TextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getAdresse1());
				adresse2TextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getAdresse2());
				code_postaleTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getCode_postale());
				villeTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getVille());
			}

			
			if ( e.getClickCount()==2 && e.getButton()==MouseButton.PRIMARY && e.getTarget() instanceof Text)
			{
					Principale.ouvrirFenModifierClient(tableClients.getSelectionModel().getSelectedItem());
			}
		});
		
		//Recherche des clients
		numeroTextField.setOnKeyTyped(e -> {rechercherClient();});
		
		nomTextField.setOnKeyTyped(e -> {rechercherClient();});
		
		prenomTextField.setOnKeyTyped(e -> {rechercherClient();});
	}
	
	public void supprimerClient(ActionEvent e)
	{
		Alert confirmationSupprimer = new Alert(AlertType.CONFIRMATION, "Voulez-vous supprimer ce client ?", ButtonType.YES,ButtonType.NO);
		confirmationSupprimer.setTitle("Confirmation de suppression");
		Optional<ButtonType> resultat = confirmationSupprimer.showAndWait();
		if (resultat.isPresent() && resultat.get() == ButtonType.YES)
		{
			Principale.supprimerClient(tableClients.getSelectionModel().getSelectedItem());
		}
		civiliteTextFieldAffichage.clear();
		emailTextFieldAffichage.clear();
		adresse1TextFieldAffichage.clear();
		adresse2TextFieldAffichage.clear();
		code_postaleTextFieldAffichage.clear();
		villeTextFieldAffichage.clear();
	}
	
	public void actualiserDonnes()
	{
		if (tableClients.getSelectionModel().getSelectedItem() != null)
		{
			civiliteTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getCivilite());
			emailTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getEmail());
			adresse1TextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getAdresse1());
			adresse2TextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getAdresse2());
			code_postaleTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getCode_postale());
			villeTextFieldAffichage.setText(tableClients.getSelectionModel().getSelectedItem().getVille());
		}
	}
	
	public void rechercherClient()
	{
		lesClientsRecherche.clear();
		if (numeroTextField.getText().isEmpty() & nomTextField.getText().isEmpty() & prenomTextField.getText().isEmpty())
		{
			tableClients.setItems(lesClients);
		}
		else
		{
			for (int i = 0;i<lesClients.size();i++)
			{
				if (String.valueOf(lesClients.get(i).getNumero()).toUpperCase().contains(numeroTextField.getText().toUpperCase()) & lesClients.get(i).getNom().toUpperCase().contains(nomTextField.getText().toUpperCase()) & lesClients.get(i).getPrenom().toUpperCase().contains(prenomTextField.getText().toUpperCase()))
				{
					lesClientsRecherche.add(lesClients.get(i));
				}
			}
			tableClients.setItems(lesClientsRecherche);
		}
	}
	
	
	
	public void supprimerClient(Client e) {
		lesClients.remove(e);
	}
	
	public Parent creerContenu()
	{
		
		
		//Modification des images
		logoView.setPreserveRatio(true);
		logoView.setFitWidth(100);
		logoView.setFitHeight(50);
		
		//Initialisation du TableView
		TableColumn<Client,Integer> colonne1 = new TableColumn<Client,Integer>("ID");
		colonne1.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numero"));	
		tableClients.getColumns().add(colonne1);
		
		TableColumn<Client,String> colonne2 = new TableColumn<Client,String>("NOM");
		colonne2.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));	
		tableClients.getColumns().add(colonne2);
		
		TableColumn<Client,String> colonne3 = new TableColumn<Client,String>("PRENOM");
		colonne3.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));	
		tableClients.getColumns().add(colonne3);
		
		TableColumn<Client,String> colonne4 = new TableColumn<Client,String>("NUMERO DE TELEPHONE");
		colonne4.setCellValueFactory(new PropertyValueFactory<Client,String>("numero_de_telephone"));	
		tableClients.getColumns().add(colonne4);
		
		tableClients.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableClients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tableClients.setContextMenu(menu);
		
		tableClients.setStyle("-fx-background-color: #50575a");
		
		//Elements de champ de recherche
		rechercheNumero.getChildren().addAll(numeroLabel,numeroTextField);
		rechercheNom.getChildren().addAll(nomLabel,nomTextField);
		recherchePrenom.getChildren().addAll(prenomLabel,prenomTextField);
		champsRecherche.getChildren().addAll(rechercheNumero,rechercheNom,recherchePrenom);
		champsRecherche.setPadding(new Insets(10));
		champsRecherche.setSpacing(80);
		champsRecherche.setAlignment(Pos.CENTER);
		champsRecherche.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		champsRecherche.setBackground(new Background(new BackgroundFill(Color.rgb(129, 109, 98),new CornerRadii(0),new Insets(0))));
		
		//Modification des TextFields
		numeroTextField.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(3))));
		nomTextField.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(3))));
		prenomTextField.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(3))));
		civiliteTextFieldAffichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		adresse1TextFieldAffichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		adresse2TextFieldAffichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		code_postaleTextFieldAffichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		emailTextFieldAffichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		villeTextFieldAffichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		
		numeroLabel.setTextFill(Color.WHITE);
		nomLabel.setTextFill(Color.WHITE);
		prenomLabel.setTextFill(Color.WHITE);
		civiliteLabel.setTextFill(Color.WHITE);
		adresseLabel.setTextFill(Color.WHITE);
		villeLabel.setTextFill(Color.WHITE);
		emailLabel.setTextFill(Color.WHITE);
		code_postaleLabel.setTextFill(Color.WHITE);
		
		
		
		
		//Affichage des informations du client (interface Master-Detail)
		civiliteTextFieldAffichage.setMaxWidth(100);
		code_postaleTextFieldAffichage.setMaxWidth(60);
		villeTextFieldAffichage.setMinWidth(400);
		emailTextFieldAffichage.setMinWidth(400);
		adresse1TextFieldAffichage.setMaxWidth(560);
		adresse2TextFieldAffichage.setMaxWidth(560);
		civiliteTextFieldAffichage.setEditable(false);
		adresse1TextFieldAffichage.setEditable(false);
		adresse2TextFieldAffichage.setEditable(false);
		villeTextFieldAffichage.setEditable(false);
		code_postaleTextFieldAffichage.setEditable(false);
		emailTextFieldAffichage.setEditable(false);
		
		
		informationsClients.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		informationsClients.setBackground(new Background(new BackgroundFill(Color.rgb(129, 109, 98),new CornerRadii(0),new Insets(0))));
		
		informationsCivilite.getChildren().addAll(civiliteLabel,civiliteTextFieldAffichage);
		informationsCivilite.setPadding(new Insets(10));
		informationsAdresse.setPadding(new Insets(10));
		informationsAdresse.getChildren().addAll(adresseLabel,adresse1TextFieldAffichage,adresse2TextFieldAffichage);
		informationsVille.setPadding(new Insets(10));
		informationsVille.getChildren().addAll(villeLabel,villeTextFieldAffichage);
		informationsCode_postale.setPadding(new Insets(10));
		informationsCode_postale.getChildren().addAll(code_postaleLabel,code_postaleTextFieldAffichage);
		informationsEmail.getChildren().addAll(emailLabel,emailTextFieldAffichage);
		informationsEmail.setPadding(new Insets(10));
		informationsVilleAndCode_postale.setSpacing(40);
		informationsVilleAndCode_postale.getChildren().addAll(informationsCode_postale,informationsVille);
		informationsCiviliteAndEmail.getChildren().addAll(informationsCivilite,informationsEmail);
		informationsCiviliteAndEmail.setSpacing(40);
		informationsAdresse.setSpacing(10);
		
		//Mise au milieu des éléments
		informationsCiviliteAndEmail.setAlignment(Pos.CENTER);
		VBox.setMargin(adresse1TextFieldAffichage, new Insets(0,0,0,100));
		VBox.setMargin(adresse2TextFieldAffichage, new Insets(0,0,0,100));
		VBox.setMargin(adresseLabel, new Insets(0,0,0,100));
		VBox.setMargin(informationsVilleAndCode_postale, new Insets(0,0,0,100));
		informationsClients.getChildren().addAll(informationsCiviliteAndEmail,informationsAdresse,informationsVilleAndCode_postale);
		
		//Boutons de gestion de la fenêtre
		bnFermer.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		bnFermer.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");
		bnFermer.setPrefHeight(50);
		
		bnAjouter.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		bnAjouter.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");
		bnAjouter.setPrefHeight(50);
		
		bnModifier.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		bnModifier.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");
		bnModifier.setPrefHeight(50);
		
		bnSupprimer.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(1))));
		bnSupprimer.setStyle("-fx-background-color: #816d62; -fx-text-fill: white; -fx-font-size: 16px");
		bnSupprimer.setPrefHeight(50);

		
		AnchorPane.setBottomAnchor(bnFermer,10.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		AnchorPane.setLeftAnchor(bnFermer, 10.0);
		
		AnchorPane.setTopAnchor(bnAjouter,100.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setLeftAnchor(bnAjouter, 10.0);
		
		AnchorPane.setTopAnchor(bnModifier,160.0);
		AnchorPane.setRightAnchor(bnModifier, 10.0);
		AnchorPane.setLeftAnchor(bnModifier, 10.0);
		
		AnchorPane.setTopAnchor(bnSupprimer,220.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setLeftAnchor(bnSupprimer, 10.0);
		
		boxBoutons.setMinWidth(100);
		boxBoutons.setStyle("-fx-background-color : #50575a");
		boxBoutons.getChildren().addAll(bnFermer,bnModifier,bnAjouter,bnSupprimer);
		
		
		
		
		
		
		//Bindings
		BooleanBinding rien = Bindings.equal(tableClients.getSelectionModel().selectedIndexProperty(), -1);
		bnSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnModifier.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		optionSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		optionModifier.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		
		
		
		
		
		
		
		rassemblement.setMinWidth(780);
		rassemblement.getChildren().addAll(champsRecherche,tableClients,informationsClients);
		tableClients.setPadding(new Insets(10));
		racine.setPadding(new Insets(10));
		racine.setSpacing(25);
		racine.setBackground(new Background(new BackgroundFill(Color.web("1D2244"),new CornerRadii(0),new Insets(0))));
		sanslogo.getChildren().addAll(rassemblement,boxBoutons);
		racine.getChildren().addAll(logoView,sanslogo);
		return racine;
	}
	
	public void init(ArrayList<Client> liste) 
	{
		lesClients.clear();
		for (int i=0; i<liste.size() ; i++) 
		{
			lesClients.add(liste.get(i));
		}
		tableClients.setItems(lesClients);
	}
	
	public void ajouterClient(Client e) {
		lesClients.add(e);
	}
	
	public void modifierClient(Client e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesClients.size()) {
			if (lesClients.get(i).getNumero()==e.getNumero()){
				lesClients.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
}
