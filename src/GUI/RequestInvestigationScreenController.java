package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Queue;
import DefaultPackage.Requests;
import DefaultPackage.Stack;
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
		Parent root = Stack.pop();
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
		Parent root = Stack.pop();
		Stage window = (Stage) id.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}
	
	
	
	public void menuClick() throws IOException {
		Parent root = Stack.pop();
		Stage window = (Stage) id.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Queue requests = new Queue();
		requests = MySqlHelper.sqlPullRequests();

		

				id.setText(""+requests.find(Requests.currentRequestId).getRequestId());
				date.setText(requests.find(Requests.currentRequestId).getRequestDate());
				type.setText(requests.find(Requests.currentRequestId).getRequestType());
				amount.setText(""+requests.find(Requests.currentRequestId).getRequestAmount());
				detail.setText(requests.find(Requests.currentRequestId).getRequestDetails());
			}
		
		
	}


