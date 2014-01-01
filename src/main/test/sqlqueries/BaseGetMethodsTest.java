package sqlqueries;

import org.junit.Test;
import returnobjects.Jednostka;
import webengine.Application;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Rafal Zawadzki
 */
public class BaseGetMethodsTest {

    @Test
    public void testGetAllJednWhere() throws Exception {
        Connection conn = Application.connectH2Memory();
        ArrayList<Jednostka> listOfResults = BaseGetMethods.getAllJednWhere(conn, "ID=1");
        assertEquals(1, listOfResults.size());
        assertEquals(new Integer(1), listOfResults.get(0).getID());
    }

}
