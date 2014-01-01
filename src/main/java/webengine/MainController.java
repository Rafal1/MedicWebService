package webengine;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import returnobjects.Adres;
import returnobjects.Jednostka;
import searchengine.MainControllerService;
import sqlqueries.BaseGetMethods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sqlqueries.BaseLoad;

@Controller
public class MainController {

    @RequestMapping("/search")
    public
    @ResponseBody
    ArrayList<Jednostka> search(
            @RequestParam(value = "phrase", required = true) String phrase,
            @RequestParam(value = "wholeWord", required = false) Boolean wholeWord) {
        //todo trivial: minimum 2 signs to search
        //todo przyspieszenie wyszukiwania aby sprawdzal czy zdefinoway zostal typ wprowadzanego stringa
        Connection conn = Application.connectH2Memory();
//        BaseLoad.loadDataSecondJednostki(conn);
//        BaseLoad.loadDataFirstJednostki(conn);
//        BaseLoad.loadDataFirstAdresy(conn);
//        BaseLoad.loadDataSecondAdresy(conn);

//        ArrayList<?> colField; //if we search for different types
        LinkedHashMap<String, String> colFieldMap = new LinkedHashMap<String, String>();
        ArrayList<Integer> colFieldID;
        ArrayList<String> colField;
        ArrayList<Integer> matchesResultID = new ArrayList<Integer>();
        ArrayList<Jednostka> listOfResults = new ArrayList<Jednostka>();
        String patSearch = phrase;
        if (wholeWord != null && wholeWord == true) { //todo test it
            patSearch = " " + phrase + " " + "|" + "^" + phrase + " " + "|" + phrase + "$";
        }
        Pattern pat = Pattern.compile(patSearch, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        colFieldID = BaseGetMethods.getIntColumnJedn(conn, "ID");
        colField = BaseGetMethods.getStrColumnJedn(conn, "Nazwa"); // ID correspond to row (with Nazwa)
        for (Integer i = 0; i < colField.size(); i++) {
            if (colField.get(i) == null || colField.get(i).isEmpty()) {
                break;
            }
            Matcher m = pat.matcher(colField.get(i));
            if (m.find() && !matchesResultID.contains(colFieldID.get(i))) { //one match is enough
                matchesResultID.add(colFieldID.get(i));
            }
        }

        colFieldID = BaseGetMethods.getIntColumnAddr(conn, "ID");
        String[] AdrCol = {"ULICA", "MIASTO", "NRDOMU", "KODPOCZTOWY", "DOPISEK"};
        for (int j = 0; j < AdrCol.length; j++) {
            //todo validation of telehone, email on client side
            colField = BaseGetMethods.getStrColumnAdr(conn, AdrCol[j]);
            for (Integer i = 0; i < colField.size(); i++) {
                if (colField.get(i) == null || colField.get(i).isEmpty()) {
                    break;
                }
                Matcher m = pat.matcher(colField.get(i));
                if (m.find() && !matchesResultID.contains(colFieldID.get(i))) { //one match is enough
                    matchesResultID.add(colFieldID.get(i));
                }
            }
        }
        colFieldID = BaseGetMethods.getIntColumnJedn(conn, "ID");
        String[] JednCol = {"Specjalizacja1", "Specjalizacja2", "Specjalizacja3", "Opis", "Www", "Telefon", "Email"};
        for (int j = 0; j < JednCol.length; j++) {
            colField = BaseGetMethods.getStrColumnJedn(conn, JednCol[j]);
            for (Integer i = 0; i < colField.size(); i++) {
                if (colField.get(i) == null || colField.get(i).isEmpty()) {
                    break;
                }
                Matcher m = pat.matcher(colField.get(i));
                if (m.find() && !matchesResultID.contains(colFieldID.get(i))) { //one match is enough
                    matchesResultID.add(colFieldID.get(i));
                }
            }
        }

        String putID = "";
        for (int i = 0; i < matchesResultID.size(); i++) {
            if (i == (matchesResultID.size() - 1)) {
                putID += "ID=" + matchesResultID.get(i);
                break;
            }
            putID += "ID=" + matchesResultID.get(i) + " OR ";
        }

        if (!putID.isEmpty()) {
            listOfResults = BaseGetMethods.getAllJednWhere(conn, putID);
        }
        Application.closeConnectionH2Memory(conn);

        //todo put to proper place
        if (listOfResults.isEmpty()) {
            Jednostka lack = new Jednostka();
            lack.setNazwa("Brak Wynikow");
            listOfResults.add(lack);
        }

        return listOfResults;
    }

    @RequestMapping("/address")
    public
    @ResponseBody
    Adres getAddress(
            @RequestParam(value = "adresID", required = true) Integer JednID) {
        //todo validation adresID?
        Connection conn = Application.connectH2Memory();
        Integer idAdres = BaseGetMethods.getIDAddrWhereIdJedn(conn, JednID);
        Adres searchedAddr = BaseGetMethods.getAllAddWhere(conn, "ID=" + idAdres);
        //todo null? what in GUI?
        Application.closeConnectionH2Memory(conn);
        return searchedAddr;
    }

    @RequestMapping("/overunit")
    public
    @ResponseBody
    Jednostka getOverUnit(
            @RequestParam(value = "unitID", required = true) String unitID) {
        //todo validation unitID?
        Connection conn = Application.connectH2Memory();
        Jednostka searchedOverUnit = BaseGetMethods.getNadrzJednWhere(conn, "ID=" + unitID);
        //todo null? what in GUI?
        Application.closeConnectionH2Memory(conn);
        return searchedOverUnit;
    }
}