package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Requests;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DonationsMadeScreenController {

	
	@FXML
	private Button menu;
	@FXML
	private TableView tablo;
	@FXML
	private TableColumn id;
	@FXML
	private TableColumn tip;
	@FXML
	private TableColumn miktar;
	
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
	
	
	public void tableView() throws SQLException, NumberFormatException {
		
		id.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("donate_id"));
		tip.setCellValueFactory(new PropertyValueFactory<Donations , Double>("donationType"));
		miktar.setCellValueFactory(new PropertyValueFactory<Donations , String>("donateAmount"));
		
	if((tablo.getItems().isEmpty())) {
			ArrayList<String> datas1 = MySqlHelper.sqlPull("donations", "donate_id");
			ArrayList<String> datas2 = MySqlHelper.sqlPull("donations", "donate_type");
			ArrayList<String> datas3 = MySqlHelper.sqlPull("donations", "donate_amount");
			ArrayList<String> datas4 = MySqlHelper.sqlPull("donations", "user_id");
						
		for(int i=0;i<datas1.size();i++) {
			if(Integer.parseInt(datas4.get(i))==User.current_id) {
			tablo.getItems().add(new Donations(Integer.parseInt(datas1.get(i)), datas2.get(i).toString(), Double.parseDouble(datas3.get(i))));
		}
		else {
		}
		}}}

	
}
