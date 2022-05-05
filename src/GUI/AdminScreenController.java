package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DefaultPackage.MySqlHelper;
import DefaultPackage.Stack;
import DefaultPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminScreenController implements Initializable{
	
	@FXML
	private Button cikis;
	@FXML
	private Button bagis;
	@FXML
	private Button havuz;
	@FXML
	private Button yardim;
	@FXML
	private Button onaylanan;
	@FXML
	private Button kullaniciGor;
	@FXML
	private Label label;
	@FXML
	private TextField donor;
	@FXML
	private TextField inNeed;
	@FXML
	private TextField admin;
	
	public void bagisClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonationsScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml")));
		Stage window = (Stage) bagis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
	}
	
	public void havuzClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("DonationPoolScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml")));
		Stage window = (Stage) havuz.getScene().getWindow();
		window.setScene(new Scene(root, 350, 250));
	}
	
	public void yardimClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RequestsScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml")));
		Stage window = (Stage) yardim.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}
	
	public void kullaniciClick() throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("UsersScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml")));
		Stage window = (Stage) yardim.getScene().getWindow();
		window.setScene(new Scene(root, 500, 500));
	}
	
	public void onaylananClick() throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("AcceptedRequestsScreen.fxml"));
		Stack.push((Parent) FXMLLoader.load(getClass().getResource("AdminScreen.fxml")));
		Stage window = (Stage) bagis.getScene().getWindow();
		window.setScene(new Scene(root, 600, 500));
	}
	
	
	public void cikisYap() throws IOException {
		Parent root = Stack.pop();
		Stage window = (Stage) cikis.getScene().getWindow();
		window.setScene(new Scene(root, 500, 400));
		User.current_id=0;
		User.current_type_id=0;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<String> isimler = null;
		ArrayList<String> tipler = null;
		try {
			isimler = MySqlHelper.sqlPull("users", "user_name");
			tipler = MySqlHelper.sqlPull("users", "user_type_id");
		} catch (Exception e) {
			System.out.println(e);
		}

		if(label.getText()=="")
		label.setText(isimler.get(User.current_id-1));
		int donors=0;
		int inNeeds=0;
		int admins=0;
		if(admin.getText().equals(" ")) {
		for(int i=0;i<tipler.size();i++) {

			if(tipler.get(i).equals("1")) {
				admins++;
			}
			if(tipler.get(i).equals("2")) {
				donors++;
			}
			if(tipler.get(i).equals("3")) {
				inNeeds++;
			}
			
		}
		donor.setText(""+donors);
		admin.setText(""+admins);
		inNeed.setText(""+inNeeds);
		}
		
		
	}

}
