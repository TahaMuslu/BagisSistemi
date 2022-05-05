package GUI;


import DefaultPackage.Donations;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DonateScreenController {

	@FXML
	private Button menu;
	@FXML
	private Button bagis;
	@FXML
	private TextField miktar;
	@FXML
	private TextField bagisTip;

	public void bagisClick() throws Exception {
		
		Donations.currentDonate.add(miktar.getText());
		Donations.currentDonate.add(bagisTip.getText());
		Donations.currentDonate.add(""+User.current_id);
		
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonateConfirmationScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("DonateScreen.fxml")));
		Stage window = (Stage) bagis.getScene().getWindow();
		window.setScene(new Scene(root, 300, 200));
	}
	
	public void menuClick() throws Exception {
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
	

}
