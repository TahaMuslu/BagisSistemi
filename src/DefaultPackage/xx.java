//package DefaultPackage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//
//
//public class xx {
//
//	public static void main(String[] args) throws SQLException {
//		
//		try {
//			Connection connect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
//			Statement myStat = (Statement) connect.createStatement();
//			ResultSet myRs = myStat.executeQuery("select * from country");
//			while(myRs.next()) {
//				System.out.println(myRs.getString("Name") + " - "+ myRs.getString("Region"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
