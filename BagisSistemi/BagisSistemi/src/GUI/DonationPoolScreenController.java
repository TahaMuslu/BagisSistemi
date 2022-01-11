package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DonationPoolScreenController implements Initializable{

	@FXML
	private Button menu;
	@FXML
	private Label label;
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		label.setText("" + Donations.getDonationPool());
		
	}
	
}
