package DefaultPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MySqlHelper {

	private static String dbUrl = "jdbc:mysql://localhost:3306/bagis_sistemi";
	private static String username = "root";
	private static String password = "1234";
	

	
	public static Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection(dbUrl,username,password);
			}
		 catch (SQLException e) {
			showError(e);
		}
		return null;
	}
	
	
	
	public static Statement getStatement() {
		try {
			return (Statement) getConnection().createStatement();
			}
		 catch (SQLException e) {
			showError(e);
		}
		return null;
	}
	
	
	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			return (PreparedStatement) getConnection().prepareStatement(sql);
			}
		 catch (SQLException e) {
			showError(e);
		}
		return null;
	}
	
	
	public static void showError(SQLException e) {
		System.out.println("Error: " + e.getMessage());
		System.out.println("Error Code: " + e.getErrorCode());
	}

	
	public static void sqlStatusUpdate(String table, String result, String request_id, String user_id) throws SQLException{
		
		PreparedStatement statement = null;
		try {
		String sql = "UPDATE bagis_sistemi." + table + " SET request_status = '" + 
		result + "' Where (request_id = " + request_id + " ) and (user_id = " + user_id + " );";
		statement = getPreparedStatement(sql);
		statement.executeUpdate();		
		} catch (SQLException e) {
			showError(e);
		}
		finally {
			statement.close();
			getConnection().close();
		}
	}
	
	
	
	public static void sqlInsert(String table, String tableColumnsName,int howManyData,ArrayList<String> getTextFields) throws SQLException{
		PreparedStatement statement = null;
		String datas="?";
		for (int i=1;i<howManyData;i++) {
			datas = datas + ",?";
		}
		try {
		String sql = "INSERT INTO bagis_sistemi." + table + " (" + tableColumnsName + ") "+
				"VALUES (" + datas +")";
		statement = getPreparedStatement(sql);
		for (int j=1;j<=howManyData;j++) {
			statement.setString(j, getTextFields.get(j-1));
		}
		statement.executeUpdate();
		JOptionPane.showMessageDialog(null, "Kayýt Baþarýyla Eklendi");
		
		} catch (SQLException e) {
			showError(e);
		}
		finally {
			statement.close();
			getConnection().close();
		}
	}
	
	
	
	public static ArrayList<String> sqlPull(String table, String tableColumnsName) throws SQLException {
		try {
			String sql = "select * from bagis_sistemi." + table;
			ResultSet myRs = getStatement().executeQuery(sql);
			ArrayList<String> results = new ArrayList<String>();
			while(myRs.next()) {
				results.add(myRs.getString(tableColumnsName));
			}
			return results;
		} catch (SQLException e) {
			showError(e);
		}
		finally {
			getConnection().close();		}
		return null;
		}
	
	
	
	
	public static Queue sqlPullRequests() {
		try {
			String sql = "select * from bagis_sistemi.requests";
			ResultSet myRs = getStatement().executeQuery(sql);
			ArrayList<String> request_id = new ArrayList<String>();
			ArrayList<String> request_date = new ArrayList<String>();
			ArrayList<String> request_type = new ArrayList<String>();
			ArrayList<String> request_details = new ArrayList<String>();
			ArrayList<String> request_iban = new ArrayList<String>();
			ArrayList<String> request_status = new ArrayList<String>();
			ArrayList<String> user_id = new ArrayList<String>();
			ArrayList<String> request_amount = new ArrayList<String>();
			Queue results = new Queue();
			Requests request;
			while(myRs.next()) {
				request_id.add(myRs.getString("request_id"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_date.add(myRs.getString("request_date"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_type.add(myRs.getString("request_type"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_details.add(myRs.getString("request_details"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_iban.add(myRs.getString("request_iban"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_status.add(myRs.getString("request_status"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				user_id.add(myRs.getString("user_id"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_amount.add(myRs.getString("request_amount"));
			}
			for(int i=0;i<request_amount.size();i++) {
				request = new Requests(Integer.parseInt(request_id.get(i)),
												request_date.get(i),
												request_type.get(i),
												request_details.get(i),
												request_iban.get(i),
												request_status.get(i),
												Integer.parseInt(user_id.get(i)),
												Double.parseDouble(request_amount.get(i)));
				results.push(request);
			}
			return results;
		} catch (SQLException e) {
			showError(e);
		}
		return null;
	}
	
	public static Queue sqlPullRequests(String userId) {
		try {
			String sql = "SELECT * FROM bagis_sistemi.requests WHERE user_id=" + userId;
			ResultSet myRs = getStatement().executeQuery(sql);
			ArrayList<String> request_id = new ArrayList<String>();
			ArrayList<String> request_date = new ArrayList<String>();
			ArrayList<String> request_type = new ArrayList<String>();
			ArrayList<String> request_details = new ArrayList<String>();
			ArrayList<String> request_iban = new ArrayList<String>();
			ArrayList<String> request_status = new ArrayList<String>();
			ArrayList<String> user_id = new ArrayList<String>();
			ArrayList<String> request_amount = new ArrayList<String>();
			Queue results = new Queue();
			Requests request;
			while(myRs.next()) {
				request_id.add(myRs.getString("request_id"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_date.add(myRs.getString("request_date"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_type.add(myRs.getString("request_type"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_details.add(myRs.getString("request_details"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_iban.add(myRs.getString("request_iban"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_status.add(myRs.getString("request_status"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				user_id.add(myRs.getString("user_id"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				request_amount.add(myRs.getString("request_amount"));
			}
			for(int i=0;i<request_amount.size();i++) {
				request = new Requests(Integer.parseInt(request_id.get(i)),
												request_date.get(i),
												request_type.get(i),
												request_details.get(i),
												request_iban.get(i),
												request_status.get(i),
												Integer.parseInt(user_id.get(i)),
												Double.parseDouble(request_amount.get(i)));
				results.push(request);
			}
			return results;
		} catch (SQLException e) {
			showError(e);
		}
		return null;
	}
	
	
	public static LinkedList sqlPullDonations(String userId) throws SQLException {
		try {
			String sql = "SELECT * FROM bagis_sistemi.donations WHERE user_id=" + userId;
			ResultSet myRs = getStatement().executeQuery(sql);
			ArrayList<String> donate_id = new ArrayList<String>();
			ArrayList<String> donate_amount = new ArrayList<String>();
			ArrayList<String> donate_type = new ArrayList<String>();
			ArrayList<String> user_id = new ArrayList<String>();
			LinkedList results = new LinkedList();
			Donations donate;
			while(myRs.next()) {
				donate_id.add(myRs.getString("donate_id"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				donate_amount.add(myRs.getString("donate_amount"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				donate_type.add(myRs.getString("donate_type"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				user_id.add(myRs.getString("user_id"));
			}
			for(int i=0;i<donate_id.size();i++) {
				donate = new Donations(Integer.parseInt(donate_id.get(i)),
										Integer.parseInt(user_id.get(i)),
										Double.parseDouble(donate_amount.get(i)),
										donate_type.get(i));
				results.addLast(donate);
			}
			return results;
		} catch (SQLException e) {
			showError(e);
		}
		finally {
			getConnection().close();		}
		return null;
		
		}
	
	
	public static LinkedList sqlPullDonations() throws SQLException{
		try {
			String sql = "select * from bagis_sistemi.donations";
			ResultSet myRs = getStatement().executeQuery(sql);
			ArrayList<String> donate_id = new ArrayList<String>();
			ArrayList<String> donate_amount = new ArrayList<String>();
			ArrayList<String> donate_type = new ArrayList<String>();
			ArrayList<String> user_id = new ArrayList<String>();
			LinkedList results = new LinkedList();
			Donations donate;
			while(myRs.next()) {
				donate_id.add(myRs.getString("donate_id"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				donate_amount.add(myRs.getString("donate_amount"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				donate_type.add(myRs.getString("donate_type"));
			}
			myRs = getStatement().executeQuery(sql);
			while(myRs.next()) {
				user_id.add(myRs.getString("user_id"));
			}
			for(int i=0;i<donate_id.size();i++) {
				donate = new Donations(Integer.parseInt(donate_id.get(i)),
										Integer.parseInt(user_id.get(i)),
										Double.parseDouble(donate_amount.get(i)),
										donate_type.get(i));
				results.addLast(donate);
			}
			System.out.println(results.elementCount());
			return results;
		} catch (SQLException e) {
			showError(e);
		}
		return null;
		}
	
	
	
	
	}


