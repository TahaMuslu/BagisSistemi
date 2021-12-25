package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DefaultPackage.Donations;
import DefaultPackage.Donor;
import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		ArrayList<String> datas = new ArrayList<String>();
		datas.add(miktar.getText());
		datas.add(bagisTip.getText());
		datas.add(""+User.current_id);
		MySqlHelper.sqlInsert("donations", "donate_amount, donate_type, user_id", 3, datas);
		
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
