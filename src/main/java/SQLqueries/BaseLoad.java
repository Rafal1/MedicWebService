package sqlqueries;

/**
 * @author Rafal Zawadzki
 */

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseLoad {

    public static void loadDataMainAdresy(Connection conn) {
        String que1 =
                "INSERT INTO MEMBASE.PUBLIC.Adres VALUES(1, 'Wołoska', 137, '02-507', 'Warszawa', 'wjazd także od ul. Miłobędzkiej')";
        String que2 =
                "INSERT INTO MEMBASE.PUBLIC.Adres VALUES(2, 'Lindleya', 4, '02-005', 'Warszawa', '')";

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

    public static void loadDataFirstAdresy(Connection conn) {
        String que2 =
                "INSERT INTO MEMBASE.PUBLIC.Adres VALUES(4, 'Koszykowa', '82A', '02-005', 'Warszawa', '')";

        Statement STMque2 = null;

        try {
            STMque2 = conn.createStatement();

            STMque2.executeUpdate(que2);

        } catch (SQLException e) {
            System.out.println("Błąd przy przetwarzaniu zapytania");
            e.printStackTrace();
        } finally {
            if (que2 != null) {
                try {
                    STMque2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loadDataSecondAdresy(Connection conn) {
        String que1 =
                "INSERT INTO MEMBASE.PUBLIC.Adres VALUES(5, 'Wołoska', 137, '02-507', 'Warszawa', '')";

        Statement STMque1 = null;

        try {
            STMque1 = conn.createStatement();

            STMque1.executeUpdate(que1);

        } catch (SQLException e) {
            System.out.println("Błąd przy przetwarzaniu zapytania");
            e.printStackTrace();
        } finally {
            if (que1 != null) {
                try {
                    STMque1.close();
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
                        "Jesteśmy szpitalem wieloprofilowym, co oznacza, że zapewniamy kompleksową opiekę w całym procesie leczenia – od diagnostyki, do ewentualnej hospitalizacji. Ma to ogromne znaczenie dla komfortu pacjenta i skrócenia czasu pobytu w szpitalu', '', '', '', '', null, '" + dateFormat.format(date) + "')";

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
                        "Jesteśmy szpitalem wieloprofilowym, co oznacza, że zapewniamy kompleksową opiekę w całym procesie leczenia – od diagnostyki, do ewentualnej hospitalizacji. Ma to ogromne znaczenie dla komfortu pacjenta i skrócenia czasu pobytu w szpitalu', '', 'transplantacja', '', '', null, '" + dateFormat.format(date) + "')";

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

    public static void loadDataFirstJednostki(Connection conn) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        Integer id1 = 3;
        Integer adres1 = 2;
        String nazwa1 = "Klinika Anestezjologii i Intensywnej Terapii";
        String www1 = "";
        String telefon1 = "022 502-17-21";
        String telefonOpis1 = "022 502-17-24 \n" +
                "              fax: 022 502-21-03";
        String email1 = "1.klin.anest@wum.edu.pl";
        String godz1 = "";
        String opis1 = "Leczenie chorych w stanie bezpośredniego zagrożenia życia z niewydolnością oddechową, krążeniową, zatruciami, cieżkimi urazami, znieczulenia do operacji ogólnochirurgicznych oraz opieka pooperacyjna wraz z aktywnym leczeniem bólu, znieczulenie zewnątrzoponowe porodu, konsultacje dla pacjentów z całej Polski, podejrzanych o występowanie zespołu hipertermii złośliwej w następstwie anestezji.";
        String infoDod1 = "Kierownik: Dr hab. n. med. Tomasz Łazowski";
        String spec11 = "";
        String spec21 = "";
        String spec31 = "";
        Integer jnadrz1 = 2;
        String data1 = dateFormat.format(date);

        String que1 =
                "INSERT INTO MEMBASE.PUBLIC.Jednostka " +
                        "VALUES(" + id1 + "," + adres1 + ",'" + nazwa1 + "','" + www1 + "','" + telefon1 + "','" + telefonOpis1 + "','"
                        + email1 + "','" + godz1 + "','" + opis1 + "','" + infoDod1 + "','" + spec11 + "','" + spec21 + "','" + spec31 + "','" + jnadrz1 + "', '" + data1 + "')";

        Integer id2 = 4;
        Integer adres2 = 4;
        String nazwa2 = "Klinika Chorób Wenerycznych";
        String www2 = "";
        String telefon2 = "022 502-13-13";
        String telefonOpis2 = "";
        String email2 = "wenerologia@wp.pl";
        String godz2 = "";
        String opis2 = "Kierownik: Prof. dr hab. med. Sławomir Majewski \n Diagnostyka i leczenie wszystkich chorób przenoszonych drogą płciową, takich jak: kiła, rzeżączka, nierzeżączkowe zakażenie dróg moczowych (NGU), zmiany wywołane przez wirusa brodawczaka (HPV) oraz przez HIV, specjalistyczne laboratorium jest ośrodkiem referencyjnym w zakresie diagnostyki HIV i kiły dla całego regionu.";

        String infoDod2 = "budynek nr 27";
        String spec12 = "";
        String spec22 = "";
        String spec32 = "";
        Integer jnadrz2 = 2;
        String data2 = dateFormat.format(date);

        String que2 =
                "INSERT INTO MEMBASE.PUBLIC.Jednostka " +
                        "VALUES(" + id2 + "," + adres2 + ",'" + nazwa2 + "','" + www2 + "','" + telefon2 + "','" + telefonOpis2 + "','"
                        + email2 + "','" + godz2 + "','" + opis2 + "','" + infoDod2 + "','" + spec12 + "','" + spec22 + "','" + spec32 + "','" + jnadrz2 + "','" + data2 + "')";

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

    public static void loadDataSecondJednostki(Connection conn) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        Integer id1 = 5;
        Integer adres1 = 5;
        String nazwa1 = "Klinika Chirurgii Gastroenterologicznej i Transplantologii";
        String www1 = "";
        String telefon1 = "22 508 12 17";
        String telefonOpis1 = "022 502-17-24 \n" +
                "              fax: 022 502-21-03";
        String email1 = "transplantologia@cskmswia.pl";
        String godz1 = "";
        String opis1 = "Klinika świadczy usługi w ramach umowy podpisanej z NFZ oraz usługi komercyjne wg cennika Centralnego Szpitala Klinicznego  MSWiA w Warszawie.\n" +
                "Wysoki poziom świadczonych usług zapewnia wyszkolony personel medyczny oraz wykorzystanie w diagnostyce i terapii najnowszych osiągnięć medycyny zarówno w zakresie technik operacyjnych (zaawansowana chirurgia trzustki oraz małoinwazyjne leczenie chorób zapalnych jelit) jak i prowadzenia leczenia w okresie przed- i pooperacyjnym. W klinice wykonuje się unikatowe w Polsce laparoskopowe zabiegi w chorobach zapalnych jelit, małoinwazyjne operacje trzustki oraz operacje układu chłonnego. 1. Chirurgia gastroenterologiczna i ogólna z wybranymi operacjami z zakresu chirurgii onkologicznej\n" +
                "\n" +
                "operacje trzustki (nowotwory, PZT, OZT), w tym laparoskopowa resekcja dystalna trzustki,\n" +
                "chirurgiczne leczenie chorób zapalnych jelit (również z użyciem technik małoinwazyjnych),\n" +
                "operacje w zakresie narządów jamy brzusznej, także z wykorzystaniem technik małoinwazyjnych (np. operacje laparoskopowe pęcherzyka żółciowego, przepuklin rozworu przełykowego przepony, przepuklin pachwinowych),\n" +
                "zabiegi bariatryczne chirurgiczne leczenie otyłości,\n" +
                "torakoskopowe usuwanie nerwów trzewnych,\n" +
                "operacje tarczycy,\n" +
                "operacje piersi,\n" +
                "operacje proktologiczne ( także operacje żylaków odbytu sposobem Longo),\n" +
                "operacje przepuklin (m.in. pachwinowych z użyciem dwuwarstwowej siatki typu PHS),\n" +
                "inne operacje ogólnochirurgiczne w pełnym zakresie.\n" +
                "przeszczep nerki,\n" +
                "przeszczep trzustki,\n" +
                "przeszczep skojarzony trzustki i nerki.";
        String infoDod1 = "Lokalizacja: Klinika Chirurgii: IV piętro, Nowy Budynek, Blok Operacyjny Kliniki Chirurgii: III piętro, Nowy Budynek";
        String spec11 = "transplantologia";
        String spec21 = "";
        String spec31 = "";
        Integer jnadrz1 = 1;
        String data1 = dateFormat.format(date);

        String que1 =
                "INSERT INTO MEMBASE.PUBLIC.Jednostka " +
                        "VALUES(" + id1 + "," + adres1 + ",'" + nazwa1 + "','" + www1 + "','" + telefon1 + "','" + telefonOpis1 + "','"
                        + email1 + "','" + godz1 + "','" + opis1 + "','" + infoDod1 + "','" + spec11 + "','" + spec21 + "','" + spec31 + "','" + jnadrz1 + "', '" + data1 + "')";
        Integer id2 = 6;
        Integer adres2 = 5;
        String nazwa2 = "Klinika Kardiologii Zachowawczej i Nadciśnienia Tętniczego";
        String www2 = "";
        String telefon2 = "(22) 508 16 70";
        String telefonOpis2 = "fax (22) 508 16 80";
        String email2 = "kardiologia.zachowawcza@cskmswia.pl";
        String godz2 = "";
        String opis2 = "Do Kliniki kierowani są chorzy z chorobą niedokrwienną serca, wadami serca, zaburzeniami rytmu, niewydolnością serca oraz nadciśnieniem tętniczym." +
                "Jedną ze specjalności Kliniki jest leczenie chorych z infekcyjnym zapaleniem wsierdzia i z ciężkimi postaciami niewydolności krążenia. Klinika ściśle współpracuje z Kliniką Kardiologii Inwazyjnej w zakresie badań i metod leczenia inwazyjnego,a także Zakładem Diagnostyki Radiologicznej  w zakresie nieinwazyjnych badań serca metodą rezonansu magnetycznego oraz  wielonarządowej spiralnej tomografii komputerowej( MSCT).";
        String infoDod2 = "Kierownik Kliniki:  dr hab. n. med. Dariusz Kosior";
        String spec12 = "Poradnia Kardiologiczna";
        String spec22 = "Poradnia Nadciśnienia Tętniczego i Bezdechu Sennego";
        String spec32 = "";
        Integer jnadrz2 = 1;
        String data2 = dateFormat.format(date);

        String que2 =
                "INSERT INTO MEMBASE.PUBLIC.Jednostka " +
                        "VALUES(" + id2 + "," + adres2 + ",'" + nazwa2 + "','" + www2 + "','" + telefon2 + "','" + telefonOpis2 + "','"
                        + email2 + "','" + godz2 + "','" + opis2 + "','" + infoDod2 + "','" + spec12 + "','" + spec22 + "','" + spec32 + "','" + jnadrz2 + "','" + data2 + "')";


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

}