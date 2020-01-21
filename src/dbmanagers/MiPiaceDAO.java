package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MiPiaceDAO {
    static Connection con;
    static PreparedStatement ps;

    public int getMiPiace(int articolo)
    {
        int n = 0;
        try
        {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT COUNT(*) FROM MiPiace AS mp WHERE mp.articolo = ?");

            ps.setString(1,""+articolo);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
                n = rs.getInt(1);

            con.close();
        }
        catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return n;
    }
}
