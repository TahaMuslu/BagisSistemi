package GUI;


import java.io.IOException;

import DefaultPackage.Donor;
import DefaultPackage.InNeed;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpScreenController {
	@FXML
	private Button btn;
	@FXML
	private RadioButton bagisci;
	@FXML
	private RadioButton ihtiyac;
	@FXML
	private TextField ad;
	@FXML
	private TextField email;
	@FXML
	private TextField telefon;
	@FXML
	private TextArea adres;
	@FXML
	private TextField sifre;
	@FXML
	private TextField sifreTekrar;
	
	
	
	
	public void btnClick() throws Exception {
		
		if ((bagisci.isSelected()==false && ihtiyac.isSelected()==false) || 
				ad.getText()=="" || email.getText()=="" || telefon.getText()=="" || 
				adres.getText()=="" || sifre.getText()=="" || sifreTekrar.getText()=="" || !(sifre.getText().equals(sifreTekrar.getText()))){
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Kayýt oluþturulamadý!");
			alert.setContentText("Lütfen boþ alan býrakmayýnýz.");
			alert.showAndWait();
			}
		else if(bagisci.isSelected()) {
			Donor.register(ad, email, telefon, adres, sifre);
			
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
			Stage window = (Stage) btn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 400));
		}
		else {
			InNeed.register(ad, email, telefon, adres, sifre);
			
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
			Stage window = (Stage) btn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 400));
		}
		
		
		}
	
	public void bagisciClick() {
		if (ihtiyac.isSelected())
			ihtiyac.setSelected(false);
	}
	
	public void ihtiyacClick() {
		if ( bagisci.isSelected()) 
			bagisci.setSelected(false);
		
	}

	public void menuClick() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) btn.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
}
