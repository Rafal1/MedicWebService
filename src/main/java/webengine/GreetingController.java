package webengine;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicLong;

import sqlqueries.BaseLoad;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import returnobjects.Greeting;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public
    @ResponseBody
    Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Connection conn = Application.connectH2Memory();
        //BaseService.createExampleTable(conn); // nowa tabela
        //BaseLoad.LoadDataAdresy(conn); // adresy
        BaseLoad.LoadDataMainJednostki(conn); //jednostki
        Application.closeConnectionH2Memory(conn);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}