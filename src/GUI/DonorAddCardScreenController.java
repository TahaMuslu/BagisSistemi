package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DonorAddCardScreenController {
	
	@FXML
	private Button kartEkle;
	@FXML
	private Button menu;
	public void kartEkleClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) kartEkle.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}

	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
}
