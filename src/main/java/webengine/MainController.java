package webengine;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import returnobjects.Jednostka;
import sqlqueries.BaseGetMethods;
import sqlqueries.BaseLoad;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import returnobjects.Greeting;

@Controller
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public
    @ResponseBody
    Greeting test(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Connection conn = Application.connectH2Memory();
        //BaseLoad.LoadDataAdresy(conn); // adresy
        //BaseLoad.LoadDataMainJednostki(conn); //jednostki
        Application.closeConnectionH2Memory(conn);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/search")
    public
    @ResponseBody
    ArrayList search(
            @RequestParam(value = "phrase", required = true) String phrase) {

        Connection conn = Application.connectH2Memory();
        phrase = "iniczny"; //!!
        //todo multiple search in the same units
        //todo limit on fetch rows
        ArrayList<?> colField;
        ArrayList<Integer> matchesResultID = new ArrayList<Integer>();

        colField = BaseGetMethods.getStrColumnJedn(conn, "Nazwa");
        for (Object s : colField) {
            Pattern pat = Pattern.compile(phrase);
            Matcher m = pat.matcher((String) s);
            if (m.find() && !matchesResultID.contains(s)) { //one match is enough
                matchesResultID.add(colField.indexOf(s) + 1); //array index 0, sql idex = 1
            }
        }
//        String[] AdrCol = {"Ulica", "Miasto", "NRDOMU", "KODPOCZTOWY", "Dopisek"};
//        for (int i = 0; i < AdrCol.length; i++) {
//            //todo validation of telehone, email on client side
//            colField = BaseGetMethods.getStrColumnAdr(conn, AdrCol[i]);
//            for (Object s : colField) {
//                Pattern pat = Pattern.compile(phrase);
//                Matcher m = pat.matcher((String) s);
//                if (m.find() && !matchesResultID.contains(s)) {
//                    matchesResultID.add(colField.indexOf(s) + 1);
//                }
//            }
//        }

//        String[] JednCol = {"Specjalizacja1", "Specjalizacja2", "Specjalizacja3", "Opis", "Www", "Telefon", "Email"};
//        for (int i = 0; i < JednCol.length; i++) {
//            //todo validation of telehone, email on client side
//            colField = BaseGetMethods.getStrColumnJedn(conn, JednCol[i]);
//            for (Object s : colField) {
//                Pattern pat = Pattern.compile(phrase);
//                Matcher m = pat.matcher((String) s);
//                if (m.find() && !matchesResultID.contains(s)) {
//                    matchesResultID.add(colField.indexOf(s) + 1);
//                }
//            }
//        }

        String putID = "";
        for (int i = 0; i < matchesResultID.size(); i++) {
            //todo check if '' are required
            putID += "ID = " + matchesResultID.get(i) + " AND ";
            if (i == (matchesResultID.size() - 1)) {
                putID += "ID = " + matchesResultID.get(i);
            }
            System.out.print(putID);
        }

        ArrayList<Jednostka> listOfResults = BaseGetMethods.getAllJednWhere(conn, putID);
        Application.closeConnectionH2Memory(conn);
        return listOfResults;
    }


//    @RequestMapping("/")
//    public
//    @ResponseBody
//    boolean ifSpecial(
//            @RequestParam(value = "attribute", required = true) String att)
//   {
    //todo przyspieszenie wyszukiwania aby sprawdzal czy zdefinoway zostal typ wprowadzanego stringa
//       return false;
//   }

}