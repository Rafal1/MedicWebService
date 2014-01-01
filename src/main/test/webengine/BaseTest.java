package webengine;

import junit.framework.Assert;
import org.h2.jdbc.JdbcSQLException;
import org.junit.Test;
import sqlqueries.BaseGetMethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Rafal Zawadzki
 */
public class BaseTest {
    @Test
    public void testConnectToBase() throws SQLException {
        Connection conn = Application.connectH2Memory();

        try {
            if(conn.getCatalog().equals("MEMBASE")){
                assertTrue(true);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(false);
    }

    @Test
    public void testCloseConnectToBase(){
        Connection conn = Application.connectH2Memory();
        Application.closeConnectionH2Memory(conn);
        try {
            String cat = conn.getCatalog();
            System.out.println("HEJ"+cat);

        } catch (SQLException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);
    }

}
