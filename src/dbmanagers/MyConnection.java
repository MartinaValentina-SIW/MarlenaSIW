package dbmanagers;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

public class MyConnection implements MyProvider{

    static Connection con = null;

    public static Connection getConnection()
    {
        // so che la connessione andrebbe sempre chiusa, ma il db va veramente lento se apro e chiudo
        if(con == null)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                MyConnection.con = DriverManager.getConnection(connUrl,username,psw);

            } catch (Exception e) {
                e.printStackTrace();
            }
        return MyConnection.con;
    }
}
