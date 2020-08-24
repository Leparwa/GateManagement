import java.sql.*;
import javax.swing.*;
public class MyConD {
	Connection conection=null;
	public static Connection dbCon() {
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hp\\Downloads\\ActiveData.sqlite");
			JOptionPane.showMessageDialog(null, "connected succefully");
			return connection;
			
		}catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}
