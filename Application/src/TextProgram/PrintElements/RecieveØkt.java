package TextProgram.PrintElements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class RecieveØkt {
	
	public RecieveØkt(){
		TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
		Connection myConnection = mysql.getConnection();
		
		try {
			Statement st = myConnection.createStatement();
			String sql = ("SELECT * FROM Treningsøkt");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
