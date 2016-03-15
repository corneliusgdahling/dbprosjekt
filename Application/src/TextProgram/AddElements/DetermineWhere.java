package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Innendørs eller ute?
 */


public class DetermineWhere {
	private int forhold;
	private Scanner sc = new Scanner(System.in);
	
	
	public DetermineWhere(){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		System.out.println("Enter if the session was completed outside or inside");
		setForhold_id();
		try {
	
			PreparedStatement determineWhere = myConnection.prepareStatement(getSQLStatement());
			determineWhere.setInt(1, getForhold_id());
			if (getForhold_id() < 100){
				Ute ute = new Ute();
			} else{
				Inne inne = new Inne();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public String getSQLStatement(){
		String sqlStatement = "INSERT INTO Innendørs (Forhold_id) VALUES " + "(?) ";
		return sqlStatement;
	}
	
	
	
	public void setForhold_id(){
		System.out.println("\nEnter the forhold_id");
		forhold = Integer.parseInt(sc.nextLine());
	}
	public int getForhold_id(){
		return this.forhold;
	}
	
	
	
	
}
