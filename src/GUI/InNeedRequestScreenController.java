package GUI;

import java.util.Date;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InNeedRequestScreenController implements Initializable{

	
	@FXML
	private Button menu;
	@FXML
	private Button istek;
	@FXML
	private TextField iban;
	@FXML
	private TextField yardimTipi;
	@FXML
	private TextArea aciklama;
	@FXML
	private TextField miktar;
	
	public void istekClick() throws Exception {
		if(iban.getText()=="" || aciklama.getText()=="" || miktar.getText()=="") {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uyarý");
			alert.setHeaderText("Ýstek Oluþturulamadý!");
			alert.setContentText("Zorunlu alanlar boþ býrakýlamaz.");
			alert.showAndWait();
		}
		else {
			ArrayList<String> datas = new ArrayList<String>();
			Date date = new Date();
			int x= date.getYear()+1900;
			String currentTime = "" + x + "-";
			int y = date.getMonth()+1;
			currentTime += y + "-";
			currentTime += date.getDate() + " ";
			currentTime += date.getHours() + ":";
			currentTime += date.getMinutes() + ":";
			currentTime += date.getSeconds();
			datas.add(currentTime);
			if(yardimTipi.getText()=="") {
				datas.add("Null");
				datas.add(aciklama.getText());
				datas.add(iban.getText());
				datas.add("Beklemede");
				datas.add(""+User.current_id);
				datas.add("0");
			MySqlHelper.sqlInsert("requests","request_date, request_type, request_details, request_iban, request_status, user_id, request_amount",7,datas);
			
			} 
			else {
				datas.add(yardimTipi.getText());
				datas.add(aciklama.getText());
				datas.add(iban.getText());
				datas.add("Beklemede");
				datas.add(""+User.current_id);
				datas.add("" + miktar.getText());
			MySqlHelper.sqlInsert("requests","request_date, request_type, request_details, request_iban, request_status, user_id, request_amount",7,datas);
			}
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
		}
	}
	
	
	public void menuClick() throws Exception {
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		aciklama.setWrapText(true);
		
	}
	
}
