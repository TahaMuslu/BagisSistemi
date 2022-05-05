package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import DefaultPackage.HashTable;
import DefaultPackage.LinkedList;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UsersController implements Initializable{
	
	@FXML
	Button geriDon;
	@FXML
	TableView tablo;
	@FXML
	TableColumn id;
	@FXML
	TableColumn tip;
	@FXML
	TableColumn email;
	@FXML
	TableColumn ad;
	@FXML
	TableColumn telefon;
	@FXML
	TableColumn hash;
	
	
	public void geriDonClick() {
		Parent root = Stack.pop();
		Stage window = (Stage) geriDon.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id.setCellValueFactory(new PropertyValueFactory<User , String>("user_id"));
		email.setCellValueFactory(new PropertyValueFactory<User , String>("user_email"));
		ad.setCellValueFactory(new PropertyValueFactory<User , String>("user_name"));
		telefon.setCellValueFactory(new PropertyValueFactory<User , String>("user_tel"));
		tip.setCellValueFactory(new PropertyValueFactory<User , String>("user_type_id"));
		hash.setCellValueFactory(new PropertyValueFactory<User , String>("user_hash"));
		
	if((tablo.getItems().isEmpty())) {
		HashTable table = new HashTable();
		try {
			for(int i=0;i<MySqlHelper.sqlPull("users","user_id").size();i++) {
				
				tablo.getItems().add(table.getHashTable()[i]);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}}
		
	}
	

}
