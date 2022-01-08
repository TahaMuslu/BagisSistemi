package GUI;

import java.util.ArrayList;

import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {
	@FXML
	private Hyperlink hyplink = new Hyperlink();
	@FXML
	private Button loginBtn;
	@FXML
	private TextField email;
	@FXML
	private TextField sifre;

	public void loginBtnClick() throws Exception {
		User.verifyLogin(email,sifre);
		
		if (User.current_type_id == 1) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
			Stage window = (Stage) loginBtn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 400));
		} else if (User.current_type_id == 2) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
			Stage window = (Stage) loginBtn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 300));
		} else if (User.current_type_id == 3) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("InNeedScreen.fxml"));
			Stage window = (Stage) loginBtn.getScene().getWindow();
			window.setScene(new Scene(root, 500, 300));
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Giriþ Yapýlamadý!");
			alert.setContentText("Böyle bir kullancý bulunamadý.");
			alert.showAndWait();
		}
		
		ArrayList<String> requestsStatus = MySqlHelper.sqlPull("requests", "request_status");
		ArrayList<String> requestsAmounts = MySqlHelper.sqlPull("requests", "request_amount");
		ArrayList<String> donations = MySqlHelper.sqlPull("donations", "donate_amount");
		double x = 0;
		for (int i=0;i<donations.size();i++) {
			x+=Double.parseDouble(donations.get(i));
		}
		
		for (int i=0;i<requestsAmounts.size();i++) {
			if(requestsStatus.get(i).equals("Kabul Edildi"))
				x-=Double.parseDouble(requestsAmounts.get(i));
		}
		Donations.setDonationPool(x);
		
		
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
