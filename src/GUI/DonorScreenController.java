package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DonorScreenController {
	
	@FXML
	private Button cikis;
	@FXML
	private Button bagisYap;
	@FXML
	private Button bagisGör;
	@FXML
	private Button kart;
	
	public void bagisYap() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonateScreen.fxml"));
		Stage window = (Stage) bagisYap.getScene().getWindow();
		window.setScene(new Scene(root, 400, 300));
	}
	
	public void bagisGör() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonationsMadeScreen.fxml"));
		Stage window = (Stage) bagisGör.getScene().getWindow();
		window.setScene(new Scene(root, 400, 300));
	}
	
	public void kartEkle() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorAddCardScreen.fxml"));
		Stage window = (Stage) kart.getScene().getWindow();
		window.setScene(new Scene(root, 400, 250));
	}
	
	public void cikisYap() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}

}
