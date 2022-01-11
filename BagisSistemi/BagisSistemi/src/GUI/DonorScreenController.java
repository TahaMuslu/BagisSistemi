package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.Donor;
import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DonorScreenController implements Initializable{
	
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
		for (int i=0;i<cardIds.size();i++) {
			if(userIds.get(i).equals("" + Donor.current_id)) {
				Donor.current_card_id = Integer.parseInt(cardIds.get(i));
				Donor.setHaveCard(true);
			}
		}
		if(!Donor.isHaveCard()) {
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
	
	public void kartEkle() throws IOException,SQLException {
		ArrayList<String> cardIds = MySqlHelper.sqlPull("cards", "card_id");
		ArrayList<String> userIds = MySqlHelper.sqlPull("cards", "user_id");
		for (int i=0;i<cardIds.size();i++) {
			if(userIds.get(i).equals("" + Donor.current_id)) {
				Donor.current_card_id = Integer.parseInt(cardIds.get(i));
				Donor.setHaveCard(true);
			}}
		if(Donor.isHaveCard()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Kart Kayýtlý!");
			alert.setContentText("Zaten halihazýrda eklenmiþ bir kartýnýz var.");
			alert.showAndWait();
		}
		else {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorAddCardScreen.fxml"));
		Stage window = (Stage) kart.getScene().getWindow();
		window.setScene(new Scene(root, 400, 250));
		}
	}
	
	public void cikisYap() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
		User.current_id=0;
		User.current_type_id=0;
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<String> isimler=null;
		try {
			isimler = MySqlHelper.sqlPull("users", "user_name");
		} catch (SQLException e) {
			System.out.println(e);
		}
		label.setText(isimler.get(User.current_id-1));
		
	}

}
