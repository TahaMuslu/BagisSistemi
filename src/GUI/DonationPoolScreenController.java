package GUI;

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

public class DonationPoolScreenController {

	@FXML
	private Button menu;
	@FXML
	private Label label;
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	public void labelText() throws SQLException {
		ArrayList<String> bagislar = MySqlHelper.sqlPull("donations", "donate_amount");
		ArrayList<String> istekler = MySqlHelper.sqlPull("requests", "request_status");
		ArrayList<String> istekMiktar = MySqlHelper.sqlPull("requests", "request_amount");
		double donation_pool=0;
		for(int i=0;i<bagislar.size();i++) {
			donation_pool+=Double.parseDouble(bagislar.get(i));
		}
		
		for(int i=0;i<istekler.size();i++) {
			if(istekler.get(i).equals("Beklemede")) {
				donation_pool-=Double.parseDouble(istekMiktar.get(i));
			}
		}
		
		
		
		label.setText("" + donation_pool);
	}
	
}
