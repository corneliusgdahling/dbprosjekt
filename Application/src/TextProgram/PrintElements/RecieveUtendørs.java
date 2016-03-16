package TextProgram.PrintElements;


import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveUtendørs {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public RecieveUtendørs(int økt_id){
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Utendørs WHERE Økt_id = '"+ økt_id +"'");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                System.out.print("     Værtype: " + rs.getString(2) + "    ");
                System.out.print("Temperatur: " + rs.getString(3) + "    ");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
