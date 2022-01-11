package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Requests;
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
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	
	public void inceleClick() throws IOException {
		
		Requests.currentRequestId= Integer.parseInt(istekId.getText());
		
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestInvestigationScreen.fxml"));
		Stage window = (Stage) incele.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		requestId.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestId"));
		requestDate.setCellValueFactory(new PropertyValueFactory<Requests , String>("requestDate"));
		requestAmount.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestAmount"));
		
	if((table.getItems().isEmpty())) {
			ArrayList<String> datas1 = null;
			ArrayList<String> datas2 = null;
			ArrayList<String> datas3 = null;
			ArrayList<String> datas4 = null;
			try {
				datas1 = MySqlHelper.sqlPull("requests", "request_id");
				datas2 = MySqlHelper.sqlPull("requests", "request_date");
				datas3 = MySqlHelper.sqlPull("requests", "request_amount");
				datas4 = MySqlHelper.sqlPull("requests", "request_status");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		for(int i=0;i<datas1.size();i++) {
			if(datas4.get(i).equals("Beklemede")) {
			table.getItems().add(new Requests(Integer.parseInt(datas1.get(i)),datas2.get(i).toString(),Double.parseDouble(datas3.get(i))));
			}
		}}
		else {
		}
		
	}
	
}
