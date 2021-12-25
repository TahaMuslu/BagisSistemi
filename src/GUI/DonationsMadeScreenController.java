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

public class DonationsMadeScreenController {

	
	@FXML
	private Button menu;
	@FXML
	private ListView listView1;
	@FXML
	private ListView listView2;
	@FXML
	private ListView listView3;
	
	
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
	
	public void listview() throws SQLException {
		if((listView1.getItems().isEmpty())) {
		ArrayList<String> datas1 = MySqlHelper.sqlPull("donations", "donate_id");
		ArrayList<String> datas2 = MySqlHelper.sqlPull("donations", "donate_amount");
		ArrayList<String> datas3 = MySqlHelper.sqlPull("donations", "donate_type");
		ArrayList<String> ids = MySqlHelper.sqlPull("donations", "user_id");
		for(int i=0;i<ids.size();i++) {
			if(ids.get(i).equals("" + User.current_id)) {
				listView1.getItems().add(datas1.get(i));
				listView2.getItems().add(datas2.get(i));
				listView3.getItems().add(datas3.get(i));
		}}}
		else {
			
		}
	}
}
