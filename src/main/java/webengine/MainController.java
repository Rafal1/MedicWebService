package webengine;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import returnobjects.Jednostka;
import sqlqueries.BaseGetMethods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import returnobjects.Greeting;

@Controller
public class MainController {

    @RequestMapping("/search")
    public
    @ResponseBody
    ArrayList search(
            @RequestParam(value = "phrase", required = true) String phrase) {

        Connection conn = Application.connectH2Memory();
        //todo mul-iple search in the same units
        //todo limit on fetch rows
        ArrayList<?> colField;
        ArrayList<Integer> matchesResultID = new ArrayList<Integer>();
        ArrayList<Jednostka> listOfResults = null;

        colField = BaseGetMethods.getStrColumnJedn(conn, "Nazwa");
        for (Object s : colField) {
            Pattern pat = Pattern.compile(phrase);
            Matcher m = pat.matcher((String) s);
            if (m.find() && !matchesResultID.contains(colField.indexOf(s) + 1)) { //one match is enough
                matchesResultID.add(colField.indexOf(s) + 1); //array index 0, sql idex = 1
            }
        }

        String[] AdrCol = {"Ulica", "Miasto", "NRDOMU", "KODPOCZTOWY", "Dopisek"};
        for (int i = 0; i < AdrCol.length; i++) {
            //todo validation of telehone, email on client side
            colField = BaseGetMethods.getStrColumnAdr(conn, AdrCol[i]);
            for (Object s : colField) {
                Pattern pat = Pattern.compile(phrase);
                Matcher m = pat.matcher((String) s);
                if (m.find() && !matchesResultID.contains(s)) {
                    matchesResultID.add(colField.indexOf(s) + 1);
                }
            }
        }

        String[] JednCol = {"Specjalizacja1", "Specjalizacja2", "Specjalizacja3", "Opis", "Www", "Telefon", "Email"};
        for (int i = 0; i < JednCol.length; i++) {
            //todo validation of telehone, email on client side
            colField = BaseGetMethods.getStrColumnJedn(conn, JednCol[i]);
            for (Object s : colField) {
                Pattern pat = Pattern.compile(phrase);
                Matcher m = pat.matcher((String) s);
                if (m.find() && !matchesResultID.contains(s)) {
                    matchesResultID.add(colField.indexOf(s) + 1);
                }
            }
        }

        String putID = "";
        for (int i = 0; i < matchesResultID.size(); i++) {
            //todo check if '' are required
            if (i == (matchesResultID.size() - 1)) {
                putID += "ID=" + matchesResultID.get(i);
                break;
            }
            putID += "ID=" + matchesResultID.get(i) + " OR ";
        }

        if( !putID.isEmpty() ){
            listOfResults = BaseGetMethods.getAllJednWhere(conn, putID);
        }

        Application.closeConnectionH2Memory(conn);
        //if empty - return nothing
        return listOfResults;
    }

    //todo przyspieszenie wyszukiwania aby sprawdzal czy zdefinoway zostal typ wprowadzanego stringa

}