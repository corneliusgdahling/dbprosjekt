package TextProgram.PrintElements;


import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveInnendørs {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public RecieveInnendørs(int økt_id){
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Innendørs WHERE Økt_id = '"+ økt_id +"'");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                System.out.print("     " + rs.getString(1) + "     ");
                System.out.print(rs.getString(2) + "    ");
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}