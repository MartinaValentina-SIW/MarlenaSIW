package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PremioDAO {
    static Connection con;
    static PreparedStatement ps;
    ArrayList<Premio> premi = null;

    public Premio getPremio(int id)
    {
        Premio p = null;
        try {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM Premio WHERE id = ?");
            ps.setString(1,""+id);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                p = new Premio(rs.getInt(1), rs.getInt(3),rs.getString(2));
            }

        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return p;

    }

    public ArrayList<Premio> getPremi()
    {
        if(premi == null)
        {
            premi = new ArrayList<Premio>();
            try {
                con = MyConnection.getConnection();
                ps = con.prepareStatement("SELECT * FROM Premio");

                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {
                    premi.add(new Premio(rs.getInt(1), rs.getInt(3),rs.getString(2)));
                }

            }catch (SQLException | NullPointerException e)
            {
                e.printStackTrace();
            }
        }
        return premi;
    }
}
