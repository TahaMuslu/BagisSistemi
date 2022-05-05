package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.management.Query;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Queue;
import DefaultPackage.Requests;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InNeedRequestsScreenController implements Initializable{
	
	
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
	
	
	public void menuClick() throws IOException {
		Parent root = Stack.pop();
		Stage window = (Stage) tablo.getScene().getWindow();
		window.setScene(new Scene(root, 500, 300));
	}






	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestId"));
		tarih.setCellValueFactory(new PropertyValueFactory<Requests , String>("requestDate"));
		durum.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestStatus"));
		miktar.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestAmount"));
		
	if((tablo.getItems().isEmpty())) {
		
			Queue requests = new Queue();
			requests = MySqlHelper.sqlPullRequests(""+User.current_id);

			
		for(int i=0;i<requests.elementCount();i++) {
			tablo.getItems().add(requests.get(i).getRequest());
		}}
		else {
		}
		
	}

}
