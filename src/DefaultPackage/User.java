package DefaultPackage;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.TextField;

public class User {
	
	public static int current_id;
	public static int current_type_id;
	public static int userOfNumbers;
	private String user_id="null";
	private String user_email="";
	private String user_name="";
	private String user_tel="";
	private String user_type_id="";
	private String user_hash="";
	
	
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
	
	
	
	public User(String user_id, String user_email, String user_name, String user_tel, String user_type_id,
			String user_hash) {
		super();
		this.user_id = user_id;
		this.user_email = user_email;
		this.user_name = user_name;
		this.user_tel = user_tel;
		this.user_type_id = user_type_id;
		this.user_hash = user_hash;
	}
	
	public User() {
		
	}

	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_tel() {
		return user_tel;
	}


	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}


	public String getUser_type_id() {
		return user_type_id;
	}


	public void setUser_type_id(String user_type_id) {
		this.user_type_id = user_type_id;
	}


	public String getUser_hash() {
		return user_hash;
	}


	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}
	
	
	

}
