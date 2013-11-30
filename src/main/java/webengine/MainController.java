package webengine;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import returnobjects.Jednostka;
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
        //BaseService.createExampleTable(conn); // nowa tabela
        //BaseLoad.LoadDataAdresy(conn); // adresy
        BaseLoad.LoadDataMainJednostki(conn); //jednostki
        Application.closeConnectionH2Memory(conn);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/search")
    public
    @ResponseBody
    String search( //ArrayList<Jednostka>
                   @RequestParam(value = "phrase", required = true) String phrase)

    {
        //using search engine
        //sql queries
//        ArrayList<Jednostka> listOfResults = new ArrayList<Jednostka>();
//        listOfResults.add()
        return new String(phrase);
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