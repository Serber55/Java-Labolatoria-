package cwiczenia.test;

import cwiczenia.MyDB;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args){
        MyDB db = new MyDB("localhost","myDB", 3306);
        db.setUser("User123");
        db.setPassword("Haslo123!@!");
        Connection conn = db.getConection();
        if(conn != null){
            System.out.println("Connected to database");
        db.closeConnection();
        System.out.println("Zakończono połączenie z bazą zakończone.");
        }
    }
}