package DefaultPackage;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.TextField;

public abstract class User {
	
	public static int current_id;
	public static int current_type_id;
	public String password;
	public String email;
	public String phoneNumber;
	public String adress;
	public String name;
	public static int userOfNumbers;
	
	
	
	public static void verifyLogin(TextField email, TextField sifre) throws SQLException {
		ArrayList<String> emails = MySqlHelper.sqlPull("users", "user_email");
		ArrayList<String> passwords = MySqlHelper.sqlPull("users", "user_pass");
		ArrayList<String> userTypes = MySqlHelper.sqlPull("users", "user_type_id");
		for(int i=0;i<emails.size();i++) {
			if(emails.get(i).equals(email.getText())) {
				if(passwords.get(i).equals(sifre.getText())) {
					User.current_id=i+1;
					User.current_type_id=Integer.parseInt(userTypes.get(i)) ;
				}
				
				
			}}
	}
	
	
	

}
