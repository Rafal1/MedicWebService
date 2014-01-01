package searchengine;

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
}
