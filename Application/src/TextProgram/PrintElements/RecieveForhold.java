package TextProgram.PrintElements;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveForhold {
	
	public RecieveForhold(int økt_id){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();

		try {
			Statement st = myConnection.createStatement();
			String sql = ("SELECT * FROM Forhold WHERE Økt_id = '"+ økt_id +"'");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				System.out.print("     Prestasjon (1-100): " + rs.getString(2) + "     ");
				System.out.print("Personlig form: " + rs.getString(3) + "    ");
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
