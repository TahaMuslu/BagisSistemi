package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RequestsScreenController {

	
	@FXML
	private Button menu;
	@FXML
	private ListView id;
	@FXML
	private ListView tarih;
	@FXML
	private ListView miktar;

	
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	public void listView() throws SQLException {
		if((id.getItems().isEmpty())) {
			ArrayList<String> datas1 = MySqlHelper.sqlPull("requests", "request_id");
			ArrayList<String> datas2 = MySqlHelper.sqlPull("requests", "request_date");
			ArrayList<String> datas3 = MySqlHelper.sqlPull("requests", "request_amount");
		for(int i=0;i<datas1.size();i++) {
				id.getItems().add(datas1.get(i));
				tarih.getItems().add(datas2.get(i));
				miktar.getItems().add(datas3.get(i));
		}}
		else {
			
		}
	}
	
	
}
