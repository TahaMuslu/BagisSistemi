package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import DefaultPackage.LinkedList;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Stack;
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

public class DonationsScreenController implements Initializable{

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
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		donateId.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("donate_id"));
		amount.setCellValueFactory(new PropertyValueFactory<Donations , Double>("donateAmount"));
		type.setCellValueFactory(new PropertyValueFactory<Donations , String>("donationType"));
		userId.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("user_id"));
		
	if((table.getItems().isEmpty())) {
		LinkedList donations = new LinkedList();
		try {
			donations=MySqlHelper.sqlPullDonations();
		}catch (Exception e) {
			
		}

		for(int i=0;i<donations.elementCount();i++) {
			table.getItems().add(donations.get(i));
		}}
		else {
		}
		
	}	
	
	
}
