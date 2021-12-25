package GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	@FXML
	private Label label;
	
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
	
	public void labelText() throws SQLException {
		ArrayList<String> isimler = MySqlHelper.sqlPull("users", "user_name");
		label.setText(isimler.get(User.current_id-1));
	}
	
	
	
	
	public void cikisYap() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
		User.current_id=0;
		User.current_type_id=0;
	}

}
