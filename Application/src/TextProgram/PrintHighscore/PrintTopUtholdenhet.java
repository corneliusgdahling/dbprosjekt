package TextProgram.PrintHighscore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PrintTopUtholdenhet {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public PrintTopUtholdenhet(int øvelse_id){
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Utholdenhetstrening WHERE Øvelse_id = '"+ øvelse_id + "' ORDER BY Lengde DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                System.out.print("    Økt id: " + rs.getDouble(4) + "    ");
                System.out.print("Distanse: " + rs.getDouble(2) + "(km)    ");
                System.out.print("Varighet: " + rs.getDouble(3) + "    ");
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
