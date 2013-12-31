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
//                    tmp +='\\'; //todo what's right?
                }
                tmp += s.charAt(i);
            }
            return tmp;
        }
}
