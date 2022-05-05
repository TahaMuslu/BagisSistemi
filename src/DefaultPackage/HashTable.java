package DefaultPackage;

import java.util.ArrayList;

public class HashTable {
	
	
	public User[] getHashTable() {
				
		ArrayList<String> id = null;
		ArrayList<String> email = null;
		ArrayList<String> ad = null;
		ArrayList<String> telefon = null;
		ArrayList<String> tip = null;
		
		try {
		id=MySqlHelper.sqlPull("users", "user_id");
		email=MySqlHelper.sqlPull("users", "user_email");
		ad=MySqlHelper.sqlPull("users", "user_name");
		telefon=MySqlHelper.sqlPull("users", "user_tel");
		tip=MySqlHelper.sqlPull("users", "user_type_id");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		User[] users = new User[ad.size()];
		for(int i=0;i<users.length;i++) {
			users[i]=new User("","","null","","","");
		}
		int x;
		for(int i=0;i<tip.size();i++) {
			x = Integer.parseInt(getHash(ad.get(i), ad.size()));
			while(!users[x].getUser_name().equals("null")) {
				x++;
				if(x==ad.size())
					x=0;
			}
			users[x].setUser_id(id.get(i));
			users[x].setUser_email(email.get(i));
			users[x].setUser_name(ad.get(i));
			users[x].setUser_tel(telefon.get(i));
			users[x].setUser_type_id(tip.get(i));
			users[x].setUser_hash(getHash(ad.get(i), ad.size()));
		}
		
		return users;
	}
	
	
	private String getHash(String data,int length) {
		
		return ""+Character.getNumericValue(data.charAt(0))%length;
	}
	
	
}
