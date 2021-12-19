package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class SignUpScreenController {
	@FXML
	private Button btn;
	@FXML
	private RadioButton bagisci;
	@FXML
	private RadioButton ihtiyac;
	
	public void btnClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) btn.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
		}
	
	public void bagisciClick() {
		if (ihtiyac.isSelected())
			ihtiyac.setSelected(false);
	}
	
	public void ihtiyacClick() {
		if ( bagisci.isSelected()) 
			bagisci.setSelected(false);
		
	}

}
