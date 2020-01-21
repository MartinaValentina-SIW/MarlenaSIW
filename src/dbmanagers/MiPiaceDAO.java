package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MiPiaceDAO {
    static Connection con;
    static PreparedStatement ps;

    public ArrayList<ArrayList<MiPiace>> getMiPiace()
    {
        ArrayList<ArrayList<MiPiace>> mipiace = null;
        try
        {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM MiPiace");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                if(mipiace == null)
                    mipiace = new ArrayList<ArrayList<MiPiace>>();

                if(mipiace.size() < rs.getInt(1))
                    for(int i = mipiace.size(); i<=rs.getInt(1); i++)
                    {
                        mipiace.add(new ArrayList<MiPiace>());
                    }

                mipiace.get(rs.getInt(1)).add(new MiPiace(rs.getInt(1),rs.getString(1)));
            }
            con.close();
        }
        catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return mipiace;
    }
}
