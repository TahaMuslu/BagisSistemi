package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InNeedScreenController {
	@FXML
	private Button cikis;
	@FXML
	private Button yardim;
	
	public void yardimClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("InNeedRequestScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 400, 300));
	}
	
	public void cikisYap() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}

}
