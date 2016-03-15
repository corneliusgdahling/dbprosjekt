package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Inne {
	
	private Scanner sc = new Scanner(System.in);
	
	
	public Inne(int økt_id){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		
		try {
	
			PreparedStatement ps = myConnection.prepareStatement(getSQLStatement());
            ps.setInt(1, økt_id);
            ps.setString(2, getAtmosfære());
            ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getSQLStatement(){
		String sqlStatement = "INSERT INTO Innendørs (Økt_id, Atmosfære) VALUES (?, ?) ";
		return sqlStatement;
	}
	
	
	public String getAtmosfære(){
		System.out.println("\nEnter information about the training atmosphere.");
		String atmosfære = sc.nextLine();
		if (atmosfære.length() < 1){
			atmosfære = null;
		}
		return atmosfære;
	}
	
		
}








