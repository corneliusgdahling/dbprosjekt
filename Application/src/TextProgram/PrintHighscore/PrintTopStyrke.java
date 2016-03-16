package TextProgram.PrintHighscore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PrintTopStyrke {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public PrintTopStyrke(int øvelse_id){
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Styrke WHERE Øvelse_id = '"+ øvelse_id + "'ORDER BY Belastning DESC;");
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("    Økt id: " + rs.getDouble(5) + "    ");
                System.out.print("Belastning: " + rs.getDouble(2) + "    ");
                System.out.print("Repetisjoner: " + rs.getString(3) + "    ");
                System.out.print("Sett: " + rs.getString(4) + "    ");
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
