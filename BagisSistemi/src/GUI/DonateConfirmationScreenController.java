package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DonateConfirmationScreenController implements Initializable{
	
	@FXML
	private Label kod;
	@FXML
	private TextField kodGir;
	@FXML
	private Button devamEt;
	
	public void devamEtClick() throws IOException, SQLException {
		if(kodGir.getText().equals(kod.getText())) {
			MySqlHelper.sqlInsert("donations", "donate_amount, donate_type, user_id", 3, Donations.currentDonate);
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
			Stage window = (Stage) devamEt.getScene().getWindow();
			window.setScene(new Scene(root, 500, 300));
		}
		else {
			JOptionPane.showMessageDialog(null, "Kod Yanlýþ Girildiði Ýçin Baðýþ Yapýlamadý!");
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonateScreen.fxml"));
			Stage window = (Stage) devamEt.getScene().getWindow();
			window.setScene(new Scene(root, 400, 300));
		}
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(kod.getText()=="") {
		int x = (int) ( Math.random()*900)+100;
		kod.setText("" + x);
		}
		
	}

}
