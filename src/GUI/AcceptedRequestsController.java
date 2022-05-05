package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.BinaryTree;
import DefaultPackage.BinaryTreeNode;
import DefaultPackage.MySqlHelper;
import DefaultPackage.Queue;
import DefaultPackage.Requests;
import DefaultPackage.Stack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AcceptedRequestsController  implements Initializable{
	
	
	@FXML
	private Button menu;
	@FXML
	private TableView table;
	@FXML
	private TableColumn id;
	@FXML
	private TableColumn date;
	@FXML
	private TableColumn amount;
	@FXML
	private TableColumn status;
	@FXML
	private CheckBox nisanOnce;
	@FXML
	private CheckBox fazla1000;
	@FXML
	private ToggleButton redKabul;
	
	
	
	
	public void menuClick() throws Exception {
		Parent root = Stack.pop();
		Stage window = (Stage) menu.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		yenile();
		
	}
	
	
	public void yenile() {
		table.getItems().clear();
		id.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestId"));
		date.setCellValueFactory(new PropertyValueFactory<Requests , String>("requestDate"));
		amount.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestAmount"));
		status.setCellValueFactory(new PropertyValueFactory<Requests , Integer>("requestStatus"));
		
		BinaryTree tree = new BinaryTree();
		if((table.getItems().isEmpty())) {
			String query="";
			if(fazla1000.isSelected())
				query+="1";
			else
				query+="0";
			if(nisanOnce.isSelected())
				query+="1";
			else
				query+="0";
			if(redKabul.isSelected())
				query+="1";
			else
				query+="0";
			ArrayList<Requests> requests = tree.executeQuery(query);
			for(int i=0;i<requests.size();i++)
				table.getItems().add(requests.get(i));
			
			
		}
		else {
		}
		
	}
	

}
