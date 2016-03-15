package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Ute {
	
	private Scanner sc = new Scanner(System.in);
	
	
	public Ute(int økt_id){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		
		try {
	
			PreparedStatement ps = myConnection.prepareStatement(getSQLStatement());
            ps.setInt(1, økt_id);
            ps.setString(2, getVærtype());
            ps.setInt(3, getTemperature());
            ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getSQLStatement(){
		String sqlStatement = "INSERT INTO Utendørs (Økt_id, Værtype, Temperatur) VALUES (?, ?, ?)";
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
