package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DonationsScreenController {

	@FXML
	private Button menu;
	@FXML
	private ListView did;
	@FXML
	private ListView miktar;
	@FXML
	private ListView tip;
	@FXML
	private ListView uid;
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	public void listView() throws SQLException {
		if((did.getItems().isEmpty())) {
			ArrayList<String> datas1 = MySqlHelper.sqlPull("donations", "donate_id");
			ArrayList<String> datas2 = MySqlHelper.sqlPull("donations", "donate_amount");
			ArrayList<String> datas3 = MySqlHelper.sqlPull("donations", "donate_type");
			ArrayList<String> datas4 = MySqlHelper.sqlPull("donations", "user_id");
		for(int i=0;i<datas1.size();i++) {
				did.getItems().add(datas1.get(i));
				miktar.getItems().add(datas2.get(i));
				tip.getItems().add(datas3.get(i));
				uid.getItems().add(datas4.get(i));
		}}
		else {
			
		}
	}
	
	
	
}
