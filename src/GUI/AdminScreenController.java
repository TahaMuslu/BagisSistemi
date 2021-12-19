package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminScreenController {
	
	@FXML
	private Button cikis;
	@FXML
	private Button bagis;
	@FXML
	private Button havuz;
	@FXML
	private Button yardim;
	
	public void bagisClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonationsScreen.fxml"));
		Stage window = (Stage) bagis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	public void havuzClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonationPoolScreen.fxml"));
		Stage window = (Stage) havuz.getScene().getWindow();
		window.setScene(new Scene(root, 350, 250));
	}
	
	public void yardimClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestsScreen.fxml"));
		Stage window = (Stage) yardim.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}
	
	
	
	
	public void cikisYap() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}

}
