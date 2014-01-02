import org.junit.Test;
import returnobjects.Jednostka;
import sqlqueries.BaseGetMethods;
import webengine.Application;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Rafal Zawadzki
 */
public class DateFormatTest {

    @Test
    public void testGetCurrent() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Hej: " +dateFormat.format(date));
    }

    @Test
    public void testGetCurrentFromBase() {
        Connection conn = Application.connectH2Memory();
        ArrayList<Jednostka> DT = BaseGetMethods.getAllJednWhere(conn, "ID=1");
        System.out.println(DT.get(0).getDataAktualizacji());

    }
}