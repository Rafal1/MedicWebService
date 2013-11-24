package webengine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.*;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static Connection connectH2Memory() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Bład przy połączeniu do bazy H2");
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:~/MemBase", "rafador", "komputer");
        } catch (SQLException e) {
            System.out.println("Bład przy połączeniu do bazy H2");
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean closeConnectionH2Memory(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Bład przy zamykaniu połączenia do bazy H2");
            e.printStackTrace();
        }
        return true;
    }

}