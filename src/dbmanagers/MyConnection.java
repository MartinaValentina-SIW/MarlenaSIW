package dbmanagers;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection implements MyProvider{

    static Connection con = null;

    public static Connection getConnection()
    {
            try {
                Class.forName("org.mysql.Driver");
                con = DriverManager.getConnection(connUrl,username,psw);

            } catch (Exception e) {
                e.printStackTrace();
            }
        return MyConnection.con;
    }
}
