package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Inne {
	
	private Scanner sc = new Scanner(System.in);
	
	
	public Inne(int forhold_id){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		
		try {
	
			PreparedStatement ps = myConnection.prepareStatement(getSQLStatement());
			ps.setString(1, getAtmosfære());
			ps.setInt(2, forhold_id);
            ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getSQLStatement(){
		String sqlStatement = "INSERT INTO Innendørs (Atmosfære, Forhold_id) VALUES (?, ?) ";
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








