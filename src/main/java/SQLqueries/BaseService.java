package sqlqueries;

/**
 * @author Rafal Zawadzki
 */

import java.sql.*;

public class BaseService {
    public static void createExampleTable(Connection conn) {
        String createString =
                "CREATE TABLE PUBLIC.table_name(column_1 INT NOT NULL);";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException e) {

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Bład przy kończeniu zapytania tworzenia tabeli");
                    e.printStackTrace();
                }
            }
        }
    }
}
