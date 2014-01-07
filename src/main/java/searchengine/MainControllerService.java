package searchengine;

import sqlqueries.BaseLoad;
import java.sql.Connection;

/**
 * @author Rafal Zawadzki
 */
public class MainControllerService {

    public static String duplicateQuota(String s) {
        String tmp = "";
        for (Integer i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\'') {
                tmp += '\'';
            }
            tmp += s.charAt(i);
        }
        return tmp;
    }

    public static String backslashQuota(String s) {
        String tmp = "";
        for (Integer i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\') {
                tmp += '\\';
            }
            tmp += s.charAt(i);
        }
        return tmp;
    }

    public static void loadInitData(Connection conn){
        BaseLoad.LoadDataMainJednostki(conn);
        BaseLoad.loadDataMainAdresy(conn);
        BaseLoad.loadDataFirstJednostki(conn);
        BaseLoad.loadDataFirstAdresy(conn);
        BaseLoad.loadDataSecondJednostki(conn);
        BaseLoad.loadDataSecondAdresy(conn);
    }
}
