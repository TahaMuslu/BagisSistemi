package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginScreenController {
	@FXML
	private Hyperlink hyplink = new Hyperlink();
	@FXML
	private Button loginBtn;

	public void loginBtnClick() throws Exception {
		if (1 == 0) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
			Stage window = (Stage) loginBtn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 400));
		} else if (1 == 1) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
			Stage window = (Stage) loginBtn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 300));
		} else if (1 == 0) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("InNeedScreen.fxml"));
			Stage window = (Stage) loginBtn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 300));
		}
	}

	public void hyplinkUnderlineT() {
		hyplink.setUnderline(true);
	}

	public void hyplinkUnderlineF() {
		hyplink.setUnderline(false);
	}
	
	public void hyplinkClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("SignUpScreen.fxml"));
		Stage window = (Stage) loginBtn.getScene().getWindow();
		window.setScene(new Scene(root, 400, 500));
	}

}
