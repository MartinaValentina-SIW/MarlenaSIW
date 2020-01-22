package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentoDAO {
    static Connection con;
    static PreparedStatement ps;

    public void inserisciCommento(String articolo, String utente, String testo)
    {
        try {
            ArticoloDAO.con = MyConnection.getConnection();

            ps = ArticoloDAO.con.prepareStatement("INSERT INTO Commento(articolo,utente,testo) VALUES (?,?,?)");

            ps.setString(1,articolo);
            ps.setString(2,utente);
            ps.setString(3,testo);

            ps.executeUpdate();

        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
    }

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

                if(commenti.size() < rs.getInt(2))
                    for(int i = commenti.size(); i<=rs.getInt(2); i++)
                    {
                        commenti.add(new ArrayList<Commento>());
                    }

                commenti.get(rs.getInt(2)).add(new Commento(rs.getInt(2),rs.getString(3),rs.getString(4)));
            }
        }
        catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return commenti;
    }
}
