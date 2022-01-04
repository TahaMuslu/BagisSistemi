package GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Requests;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InNeedRequestsScreenController {
	
	
	@FXML
	private TableView tablo;
	@FXML
	private TableColumn id;
	@FXML
	private TableColumn tarih;
	@FXML
	private TableColumn durum;
	@FXML
	private TableColumn miktar;
	
	
	public void tableView() throws SQLException, NumberFormatException {
		
		id.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestId"));
		tarih.setCellValueFactory(new PropertyValueFactory<Requests , String>("requestDate"));
		durum.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestStatus"));
		miktar.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestAmount"));
		
	if((tablo.getItems().isEmpty())) {
			ArrayList<String> datas1 = MySqlHelper.sqlPull("requests", "request_id");
			ArrayList<String> datas2 = MySqlHelper.sqlPull("requests", "request_date");
			ArrayList<String> datas3 = MySqlHelper.sqlPull("requests", "request_status");
			ArrayList<String> datas4 = MySqlHelper.sqlPull("requests", "request_amount");
			
			ArrayList<String> datas5 = MySqlHelper.sqlPull("requests", "user_id");
			
		for(int i=0;i<datas1.size();i++) {
			if(Integer.parseInt(datas5.get(i))==User.current_id) {
			tablo.getItems().add(new Requests(Integer.parseInt(datas1.get(i)), datas2.get(i).toString(), datas3.get(i).toString(), Double.parseDouble(datas4.get(i))));
			}
		}}
		else {
		}}	
	
	
	
	
	
	
	public void menuClick() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("InNeedScreen.fxml"));
		Stage window = (Stage) tablo.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}

}
