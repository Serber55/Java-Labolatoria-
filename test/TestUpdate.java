package cwiczenia.test;

import cwiczenia.MyDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        MyDB db = new MyDB("localhost", "mydb", 3306);
        db.setUser("root");
        db.setPassword("User123!@!");
        Connection conn = db.getConection();
        if (conn != null) {
            Statement polecenie = conn.createStatement();
            Number dostawa = 100;
            polecenie.executeQuery("UPDATE coffee_houses SET COFFEE = COFFEE + " + dostawa + " WHERE CITY = 'SF'");

            System.out.printf("%10s%20s%7s%7s%7s\n", "STORE_ID", "CITY", "COFFEE", "MERCH", "TOTAL");
            ResultSet res = polecenie.executeQuery("SELECT * FROM coffee_houses");
            while (res.next()) {
                System.out.printf("%10s%20s%7s%7s%7s\n", res.getString("STORE_ID"), res.getString("CITY"), res.getInt(3), res.getInt(4), res.getInt(5));
            }
            db.closeConnection();
            System.out.println("Połączenie z bazą zakończone");
        }
    }
}