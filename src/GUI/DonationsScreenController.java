package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
import DefaultPackage.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class DonationsScreenController {

	@FXML
	private Button menu;
	@FXML
	private TableView table;
	@FXML
	private TableColumn donateId;
	@FXML
	private TableColumn amount;
	@FXML
	private TableColumn type;
	@FXML
	private TableColumn userId;
	
	
	public void menuClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	public void tableView() throws SQLException {
		
		donateId.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("donate_id"));
		amount.setCellValueFactory(new PropertyValueFactory<Donations , Double>("donateAmount"));
		type.setCellValueFactory(new PropertyValueFactory<Donations , String>("donationType"));
		userId.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("user_id"));
		
	if((table.getItems().isEmpty())) {
			ArrayList<String> datas1 = MySqlHelper.sqlPull("donations", "donate_id");
			ArrayList<String> datas2 = MySqlHelper.sqlPull("donations", "donate_amount");
			ArrayList<String> datas3 = MySqlHelper.sqlPull("donations", "donate_type");
			ArrayList<String> datas4 = MySqlHelper.sqlPull("donations", "user_id");
		for(int i=0;i<datas1.size();i++) {
			table.getItems().add(new Donations(Integer.parseInt(datas1.get(i)),Integer.parseInt(datas4.get(i)),Double.parseDouble(datas2.get(i)),datas3.get(i)));
		}}
		else {
		}}	
	
	
}
