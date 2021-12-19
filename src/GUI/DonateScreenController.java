package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DonateScreenController {

	@FXML
	private Button menu;
	@FXML
	private Button bagis;
	
	public void bagisClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) bagis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
}
