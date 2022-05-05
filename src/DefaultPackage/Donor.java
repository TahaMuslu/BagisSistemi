package DefaultPackage;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Donor extends User{
	public static int current_card_id;
	
	private static boolean isHaveCard = false;
	
	public static int donorOfNumbers=0;
	
	
	public static void register(TextField ad, TextField email, TextField telefon, TextArea adres, TextField sifre) throws SQLException {

		ArrayList<String> datas = new ArrayList<String>();
		datas.add(email.getText());
		datas.add(sifre.getText());
		datas.add(ad.getText());
		datas.add(telefon.getText());
		datas.add(adres.getText());
		datas.add("2");
		String sql="user_email,user_pass,user_name,user_tel,user_adress,user_type_id";
		MySqlHelper.sqlInsert("users",sql, 6, datas);
	}

	public static void register(TextField ad, TextField email, TextField telefon, TextField sifre) throws SQLException {

		ArrayList<String> datas = new ArrayList<String>();
		datas.add(email.getText());
		datas.add(sifre.getText());
		datas.add(ad.getText());
		datas.add(telefon.getText());
		datas.add("2");
		String sql="user_email,user_pass,user_name,user_tel,user_adress,user_type_id";
		MySqlHelper.sqlInsert("users",sql, 6, datas);
	}
	
	
	
	
	
	

	public static boolean isHaveCard() {
		return isHaveCard;
	}


	public static void setHaveCard(boolean isHaveCard) {
		Donor.isHaveCard = isHaveCard;
	}
	
	
	
	
	
}
