package GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.Donor;
import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DonorScreenController {
	
	@FXML
	private Button cikis;
	@FXML
	private Button bagisYap;
	@FXML
	private Button bagisGör;
	@FXML
	private Button kart;
	@FXML
	private Label label;
	
	public void bagisYap() throws IOException, SQLException {
		ArrayList<String> cardIds = MySqlHelper.sqlPull("cards", "card_id");
		ArrayList<String> userIds = MySqlHelper.sqlPull("cards", "user_id");
		boolean isUserHaveCard = false;
		for (int i=0;i<cardIds.size();i++) {
			if(userIds.get(i).equals("" + Donor.current_id)) {
				Donor.current_card_id = Integer.parseInt(cardIds.get(i));
				isUserHaveCard=true;
			}
		}
		if(!isUserHaveCard) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Kart bulunamadý!");
			alert.setContentText("Lütfen önce kart ekleyin.");
			alert.showAndWait();
		}
		else {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonateScreen.fxml"));
		Stage window = (Stage) bagisYap.getScene().getWindow();
		window.setScene(new Scene(root, 400, 300));
		}
	}
	
	public void bagisGör() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonationsMadeScreen.fxml"));
		Stage window = (Stage) bagisGör.getScene().getWindow();
		window.setScene(new Scene(root, 400, 300));
	}
	
	public void kartEkle() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorAddCardScreen.fxml"));
		Stage window = (Stage) kart.getScene().getWindow();
		window.setScene(new Scene(root, 400, 250));
	}
	
	public void cikisYap() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
		User.current_id=0;
		User.current_type_id=0;
	}
	
	public void labelText() throws SQLException {
		ArrayList<String> isimler = MySqlHelper.sqlPull("users", "user_name");
		label.setText(isimler.get(User.current_id-1));
	}

}
