package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.Donations;
import DefaultPackage.MySqlHelper;
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
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonorScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id.setCellValueFactory(new PropertyValueFactory<Donations , Integer>("donate_id"));
		tip.setCellValueFactory(new PropertyValueFactory<Donations , Double>("donationType"));
		miktar.setCellValueFactory(new PropertyValueFactory<Donations , String>("donateAmount"));
		
	if((tablo.getItems().isEmpty())) {
		ArrayList<String> datas1 = null;
		ArrayList<String> datas2 = null;
		ArrayList<String> datas3 = null;
		ArrayList<String> datas4 = null;
		try {
			datas1 = MySqlHelper.sqlPull("donations", "donate_id");
			datas2 = MySqlHelper.sqlPull("donations", "donate_type");
			datas3 = MySqlHelper.sqlPull("donations", "donate_amount");
			datas4 = MySqlHelper.sqlPull("donations", "user_id");
		}catch (Exception e){
			
		}

						
		for(int i=0;i<datas1.size();i++) {
			if(Integer.parseInt(datas4.get(i))==User.current_id) {
			tablo.getItems().add(new Donations(Integer.parseInt(datas1.get(i)), datas2.get(i).toString(), Double.parseDouble(datas3.get(i))));
		}
		else {
		}
		}}
		
	}

	
}
