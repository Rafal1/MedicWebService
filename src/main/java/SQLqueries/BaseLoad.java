package sqlqueries;

/**
 * @author Rafal Zawadzki
 */

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseLoad {

    public static void LoadDataMainAdresy(Connection conn) {
        String que1 =
                "INSERT INTO MEMBASE.PUBLIC.Adresy VALUES(1, 'Wołoska', 137, '02-507', 'Warszawa', 'wjazd także od ul. Miłobędzkiej')";
        String que2 =
                "INSERT INTO MEMBASE.PUBLIC.Adresy VALUES(2, 'Lindleya', 4, '02-005', 'Warszawa', '')";

        Statement STMque1 = null;
        Statement STMque2 = null;

        try {
            STMque1 = conn.createStatement();
            STMque2 = conn.createStatement();

            STMque1.executeUpdate(que1);
            STMque2.executeUpdate(que2);

        } catch (SQLException e) {
            System.out.println("Błąd przy przetwarzaniu zapytania");
            e.printStackTrace();
        } finally {
            if (que1 != null && que2 != null) {
                try {
                    STMque1.close();
                    STMque2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void LoadDataMainJednostki(Connection conn) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        String que1 =
                "INSERT INTO MEMBASE.PUBLIC.Jednostka " +
                        "VALUES(1, 1, 'Centralny Szpital Kliniczny MSW w Warszawie', 'www.cskmswia.pl', '22 508 20 20', 'rejestracja: 22 508 15 52', '', ''," +
                        "'Zapraszamy do korzystania z usług Centralnego Szpitala Klinicznego MSW przy ulicy Wołoskiej 137 w Warszawie." +
                        "W naszym działaniu łączymy wieloletnie doświadczenie z najnowszymi osiągnięciami naukowymi. Zatrudniamy wybitnych specjalistów  wielu dziedzin medycyny, którzy w swej pracy wykorzystują nowocześnie wyposażone pracownie diagnostyczne, laboratoria i gabinety lekarskie." +
                        "Posiadamy Polikliniki w Warszawie, Ciechanowie, Płocku, Radomiu, Siedlcach oraz Ośrodki Rehabilitacyjne w Konstancinie i Wesołej." +
                        "Jesteśmy szpitalem wieloprofilowym, co oznacza, że zapewniamy kompleksową opiekę w całym procesie leczenia – od diagnostyki, do ewentualnej hospitalizacji. Ma to ogromne znaczenie dla komfortu pacjenta i skrócenia czasu pobytu w szpitalu', 'dodatkowe', 'Spec1', 'Spec2', 'Spec3', '2', null, '" + dateFormat.format(date) +"', null)";

        String que2 =
                "INSERT INTO MEMBASE.PUBLIC.Jednostka " +
                        "VALUES(2, 2, 'Szpital Kliniczny Dzieciątka Jezus przy ul. Lindley''a', 'www.dzieciatkajezus.pl', '022 502-20-00', '', '', ''," +
                        "'Szpital Kliniczny Dzieciątka Jezus przy ul. Lindley''a w Warszawie udziela ambulatoryjnych i stacjonarnych, wysokospecjalistycznych świadczeń w zakresie opieki zdrowotnej, " +
                        "w ramach specjalności reprezentowanych przez kliniki, oddziały, zakłady i poradnie szpitalne. W szpitalu znajdują się 683 łóżka. to nowocześnie wyposażona placówka, której wizytówką jest wysoko wykwalifikowana kadra medyczna. " +
                        "Udzielanie świadczeń zdrowotnych łączy z działalnością naukową i dydaktyczną. Tu kształcą się studenci i lekarze rezydenci." +
                        "Szpital jest wiodącą placówką w medycynie transplantacyjnej i urazowej, szczególnie urazów wielonarządowych, włącznie z jatrogennymi. " +
                        "Wyróżnia się doskonałymi wynikami leczenia stanów do niedawna nieuleczalnych i opornych na leczenie, a związanych z istotną poprawą jakości życia i sprawności pacjenta. Placówka opiera leczenie pacjentów na modelu medycyny interdyscyplinarnej i zintegrowanej." +
                        "W naszym działaniu łączymy wieloletnie doświadczenie z najnowszymi osiągnięciami naukowymi. Zatrudniamy wybitnych specjalistów  wielu dziedzin medycyny," +
                        " którzy w swej pracy wykorzystują nowocześnie wyposażone pracownie diagnostyczne, laboratoria i gabinety lekarskie." +
                        "Posiadamy Podkliniki w Warszawie, Ciechanowie, Płocku, Radomiu, Siedlcach oraz Ośrodki Rehabilitacyjne w Konstancinie i Wesołej." +
                        "Jesteśmy szpitalem wieloprofilowym, co oznacza, że zapewniamy kompleksową opiekę w całym procesie leczenia – od diagnostyki, do ewentualnej hospitalizacji. Ma to ogromne znaczenie dla komfortu pacjenta i skrócenia czasu pobytu w szpitalu', '', 'transplantacja', '', '', null, null, '" + dateFormat.format(date) +"', null)";

        Statement STMque1 = null;
        Statement STMque2 = null;

        try {
            STMque1 = conn.createStatement();
            STMque2 = conn.createStatement();

            STMque1.executeUpdate(que1);
            STMque2.executeUpdate(que2);

        } catch (SQLException e) {
            System.out.println("Błąd przy przetwarzaniu zapytania");
            e.printStackTrace();
        } finally {
            if (que1 != null && que2 != null) {
                try {
                    STMque1.close();
                    STMque2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void LoadDataFirstJednostki(Connection conn){
        //todo impl kliniki
    }

    public static void LoadDataSecondJednostki(Connection conn){
        //todo impl kliniki
    }

}