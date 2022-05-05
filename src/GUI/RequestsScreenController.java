package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Queue;
import DefaultPackage.Requests;
import DefaultPackage.Stack;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RequestsScreenController implements Initializable{

	
	@FXML
	private Button menu;
	@FXML
	private Button incele;
	@FXML
	private TextField istekId;
	@FXML
	private TableView table;
	@FXML
	private TableColumn requestId;
	@FXML
	private TableColumn requestDate;
	@FXML
	private TableColumn requestAmount;

	
	
	public void menuClick() throws Exception {
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	
	public void inceleClick() throws IOException {
		if(istekId.getText().equals("")) {
			
		}
		else {
		Requests.currentRequestId= Integer.parseInt(istekId.getText());
		
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestInvestigationScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("RequestsScreen.fxml")));
		Stage window = (Stage) incele.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		requestId.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestId"));
		requestDate.setCellValueFactory(new PropertyValueFactory<Requests , String>("requestDate"));
		requestAmount.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestAmount"));
		table.getItems().clear();
	if((table.getItems().isEmpty())) {
			Queue requests = new Queue();
			requests = MySqlHelper.sqlPullRequests();

		for(int i=0;i<requests.elementCount();i++) {
			if(requests.get(i).getRequest().getRequestStatus().equals("Beklemede")) {
			table.getItems().add(requests.get(i).getRequest());
			}
		}}
		else {
		}
		
	}
	
	public void yenile() {
		requestId.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestId"));
		requestDate.setCellValueFactory(new PropertyValueFactory<Requests , String>("requestDate"));
		requestAmount.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestAmount"));
		table.getItems().clear();
	if((table.getItems().isEmpty())) {
			Queue requests = new Queue();
			requests = MySqlHelper.sqlPullRequests();

		for(int i=0;i<requests.elementCount();i++) {
			if(requests.get(i).getRequest().getRequestStatus().equals("Beklemede")) {
			table.getItems().add(requests.get(i).getRequest());
			}
		}}
		else {
		}
		
	}
	

	
}
