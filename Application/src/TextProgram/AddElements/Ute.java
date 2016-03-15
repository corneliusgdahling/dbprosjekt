package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Ute {
	
	private Scanner sc = new Scanner(System.in);
	
	
	public Ute(int forhold_id){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		
		try {
	
			PreparedStatement ps = myConnection.prepareStatement(getSQLStatement());
            ps.setString(1, getVærtype());
            ps.setInt(2, getTemperature());
            ps.setInt(3, forhold_id);
            ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getSQLStatement(){
		String sqlStatement = "INSERT INTO Utendørs (Værtype, Temperatur, Forhold_id) VALUES (?, ?, ?)";
		return sqlStatement;
	}
	
	
	
	public int getTemperature(){
		System.out.println("\nEnter temperature (Required).");
		int temperature = Integer.parseInt(sc.nextLine());
		return temperature;
	}
	
	public String getVærtype(){
		System.out.println("\nEnter weather type.");
		String type = sc.nextLine();
		if (type.length() < 1){
			type = null;
		}
		return type;
	}
	
		
}
