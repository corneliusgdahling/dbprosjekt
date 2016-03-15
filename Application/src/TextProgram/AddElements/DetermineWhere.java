package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Innendørs eller ute?
 */


public class DetermineWhere {
	private int forhold;
	private Scanner sc = new Scanner(System.in);
	
	
//	public DetermineWhere(){
//		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
//		Connection myConnection = mysql.getConnection();
//		System.out.println("Enter if the session was completed outside or inside");
//		setForhold_id();
//		try {
//
//			PreparedStatement determineWhere = myConnection.prepareStatement(getSQLStatement());
//			determineWhere.setInt(1, getForhold_id());
//			if (getForhold_id() < 100){
//				Ute ute = new Ute();
//			} else{
//				Inne inne = new Inne();
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//
//	}
//
//
//	public String getSQLStatement(){
//		String sqlStatement = "INSERT INTO Innendørs (Forhold_id, Atmonsfær) VALUES (?)";
//		return sqlStatement;
//	}
//
//
//
//	public void setForhold_id(){
//		System.out.println("\nEnter the forhold_id");
//		forhold = Integer.parseInt(sc.nextLine());
//	}
//	public int getForhold_id(){
//		return this.forhold;
//	}


	public DetermineWhere(){
		inneOrUte();
	}

	public int getForhold_id(){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		ResultSet rs;
		String getForhold_id_statement = "SELECT Forhold_id FROM Forhold ORDER BY Økt_id DESC";
		try {
			PreparedStatement ps = myConnection.prepareStatement(getForhold_id_statement);
			rs = ps.executeQuery();
			int forhold_id;
			if (rs.next()){
				forhold_id = rs.getInt(1);
				return forhold_id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 1;
	}

	public void inneOrUte(){
		System.out.println("\nWas your exercise indoors or outside? 1. Inside 2. Outside (Required)");
		int answer = Integer.parseInt(sc.nextLine());
		if (answer == 1){
			Inne inne = new Inne(getForhold_id());
		}
		else{
			Ute ute = new Ute(getForhold_id());
		}
	}
	
	
	
	
}
