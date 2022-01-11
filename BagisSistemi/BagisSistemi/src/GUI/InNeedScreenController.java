package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InNeedScreenController implements Initializable{
	@FXML
	private Button cikis;
	@FXML
	private Button yardim;
	@FXML
	private Label label;
	@FXML
	private AnchorPane Anchor_Pane;
	
	public void yardimClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("InNeedRequestScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 400, 300));
	}
	
	public void cikisYap() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
		User.current_id=0;
		User.current_type_id=0;
	}

	public void yardimGorClick() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("InNeedRequestsScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<String> isimler = null;
		try {
			isimler = MySqlHelper.sqlPull("users", "user_name");
		} catch (SQLException e) {
			System.out.println(e);
		}
		label.setText(isimler.get(User.current_id-1));
	}
}
