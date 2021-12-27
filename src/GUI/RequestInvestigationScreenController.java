package GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Requests;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RequestInvestigationScreenController {
	
	
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
	
	
	
	public void dataView() throws SQLException {
		ArrayList<String> datas1 = MySqlHelper.sqlPull("requests", "request_id");
		ArrayList<String> datas2 = MySqlHelper.sqlPull("requests", "request_date");
		ArrayList<String> datas3 = MySqlHelper.sqlPull("requests", "request_type");
		ArrayList<String> datas4 = MySqlHelper.sqlPull("requests", "request_amount");
		ArrayList<String> datas5 = MySqlHelper.sqlPull("requests", "request_details");
		
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
	
	
	public void acceptClick() throws SQLException, IOException {
		ArrayList<String> datas = MySqlHelper.sqlPull("requests", "user_id");
		ArrayList<String> datas2 = MySqlHelper.sqlPull("requests", "request_id");
		
		for(int i=0;i<datas.size();i++) {
			if(Integer.parseInt(datas2.get(i))==Requests.currentRequestId) {
				MySqlHelper.sqlStatusUpdate("requests", "Kabul Edildi", datas2.get(i), datas.get(i));
			}
				
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

}
