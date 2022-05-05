package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import DefaultPackage.LinkedList;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DonationsMadeScreenController implements Initializable{

	
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
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("donate_id"));
		tip.setCellValueFactory(new PropertyValueFactory<Donations , Double>("donationType"));
		miktar.setCellValueFactory(new PropertyValueFactory<Donations , String>("donateAmount"));
		
	if((tablo.getItems().isEmpty())) {
		LinkedList donations = null;
		try {
			donations=MySqlHelper.sqlPullDonations(""+User.current_id);
		}catch (Exception e){
			
		}			
		for(int i=0;i<donations.elementCount();i++) {
			tablo.getItems().add(donations.get(i));
		}}
		
	}

	
}
