package TextProgram.PrintElements;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveForhold {
	
	public RecieveForhold(){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		
		try {
			Statement st = myConnection.createStatement();
			String sql = ("SELECT * FROM Forhold");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.print("     " + rs.getString(1) + "     ");
				System.out.print(rs.getString(2) + "    ");
				System.out.print(rs.getString(3) + "    ");
				System.out.print(rs.getString(4) + "    ");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
