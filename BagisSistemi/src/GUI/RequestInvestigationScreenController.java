package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Requests;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RequestInvestigationScreenController implements Initializable{
	
	
	@FXML
	private Button menu;
	@FXML
	private TextField id;
	@FXML
	private TextField date;
	@FXML
	private TextField type;
	@FXML
	private TextField amount;
	@FXML
	private TextArea detail;
	
	
	
	public void acceptClick() throws SQLException, IOException {
		ArrayList<String> datas = MySqlHelper.sqlPull("requests", "user_id");
		ArrayList<String> datas2 = MySqlHelper.sqlPull("requests", "request_id");
		if(Donations.getDonationPool()>Double.parseDouble(amount.getText())) {
		for(int i=0;i<datas.size();i++) {
			if(Integer.parseInt(datas2.get(i))==Requests.currentRequestId) {
				MySqlHelper.sqlStatusUpdate("requests", "Kabul Edildi", datas2.get(i), datas.get(i));
			}
				
		}
	}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Ýstek Kabul Edilemedi!");
			alert.setContentText("Baðýþ havuzunda yeteli miktar yok.");
			alert.showAndWait();
		}
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestsScreen.fxml"));
		Stage window = (Stage) id.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}
	
	public void declineClick() throws SQLException, IOException {
		ArrayList<String> datas = MySqlHelper.sqlPull("requests", "user_id");
		ArrayList<String> datas2 = MySqlHelper.sqlPull("requests", "request_id");
		
		for(int i=0;i<datas.size();i++) {
			if(Integer.parseInt(datas2.get(i))==Requests.currentRequestId) {
				MySqlHelper.sqlStatusUpdate("requests", "Red Edildi", datas2.get(i), datas.get(i));
			}
				
		}
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestsScreen.fxml"));
		Stage window = (Stage) id.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}
	
	
	
	public void menuClick() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestsScreen.fxml"));
		Stage window = (Stage) id.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<String> datas1 = null;
		ArrayList<String> datas2 = null;
		ArrayList<String> datas3 = null;
		ArrayList<String> datas4 = null;
		ArrayList<String> datas5 = null;
		try {
			datas1 = MySqlHelper.sqlPull("requests", "request_id");
			datas2 = MySqlHelper.sqlPull("requests", "request_date");
			datas3 = MySqlHelper.sqlPull("requests", "request_type");
			datas4 = MySqlHelper.sqlPull("requests", "request_amount");
			datas5 = MySqlHelper.sqlPull("requests", "request_details");
		} catch (SQLException e) {
			System.out.println(e);
		}

		
		for(int i=0;i<datas1.size();i++) {
			if(id.getText()=="") {
			if(Integer.parseInt(datas1.get(i))==Requests.currentRequestId) {
				id.setText(datas1.get(i));
				date.setText(datas2.get(i));
				type.setText(datas3.get(i));
				amount.setText(datas4.get(i));
				detail.setText(datas5.get(i));
			}}}
		
		
	}

}
