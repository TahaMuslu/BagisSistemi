package GUI;

import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DonorAddCardScreenController {
	
	@FXML
	private Button kartEkle;
	@FXML
	private Button menu;
	@FXML
	private TextField kartNumara;
	@FXML
	private TextField sonAy;
	@FXML
	private TextField sonYil;
	@FXML
	private TextField cvc;
	
	public void kartEkleClick() throws Exception {
		if(kartNumara.getText().length()==16 && sonAy.getText().length()==2 && sonYil.getText().length()==2 && cvc.getText().length()==3){
			ArrayList<String> datas = new ArrayList<String>();
			datas.add(kartNumara.getText());
			String expDate ="" + sonAy.getText();
			expDate += sonYil.getText();
			datas.add(expDate);
			datas.add(cvc.getText());
			datas.add(""+User.current_id);
			
			MySqlHelper.sqlInsert("cards", "card_number,exp_date,cvc,user_id", 4, datas);
			
			Parent root = Stack.pop();
			Stage window = (Stage) kartEkle.getScene().getWindow();
			window.setScene(new Scene(root, 500, 300));
			
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Kart Eklenemedi!");
			alert.setContentText("Lütfen bilgileri eksiksiz ve doðru doldurun.");
			alert.showAndWait();
		}
	}

	public void menuClick() throws Exception {
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
}
