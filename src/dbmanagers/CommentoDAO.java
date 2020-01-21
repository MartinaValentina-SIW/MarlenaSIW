package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentoDAO {
    static Connection con;
    static PreparedStatement ps;

    public ArrayList<ArrayList<Commento>> getCommenti()
    {
        ArrayList<ArrayList<Commento>> commenti = null;
        try
        {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM Commento");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                if(commenti == null)
                    commenti = new ArrayList<ArrayList<Commento>>();

                if(commenti.size() < rs.getInt(1))
                    for(int i = commenti.size(); i<=rs.getInt(1); i++)
                    {
                        commenti.add(new ArrayList<Commento>());
                    }

                commenti.get(rs.getInt(1)).add(new Commento(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            con.close();
        }
        catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return commenti;
    }
}
