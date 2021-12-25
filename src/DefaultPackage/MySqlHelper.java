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

	static String dbUrl = "jdbc:mysql://localhost:3306/bagis_sistemi";
	static String username = "root";
	static String password = "1234";
	

	
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

}
