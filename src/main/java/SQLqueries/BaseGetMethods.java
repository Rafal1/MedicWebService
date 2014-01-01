package sqlqueries;

import returnobjects.Adres;
import returnobjects.Jednostka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Rafal Zawadzki
 */
public class BaseGetMethods {
    private static final Integer MAX_FETCH = 150; //todo move to the xml with parameters

    public static ArrayList<Date> getDateColumnJedn(Connection conn, String column) {
        Statement stmt = null;
        ArrayList<Date> resultContainer = new ArrayList<Date>();
        String query = "select " + column + " from " + "PUBLIC.Jednostka";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                resultContainer.add(rs.getDate(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultContainer;
    }

    public static ArrayList<Integer> getIntColumnJedn(Connection conn, String column) {
        Statement stmt = null;
        ArrayList<Integer> resultContainer = new ArrayList<Integer>();
        String query = "select " + column + " from " + "PUBLIC.Jednostka";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                resultContainer.add(rs.getInt(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultContainer;
    }

    public static ArrayList<Integer> getIntColumnAddr(Connection conn, String column) {
        Statement stmt = null;
        ArrayList<Integer> resultContainer = new ArrayList<Integer>();
        String query = "select " + column + " from " + "PUBLIC.Adres";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                resultContainer.add(rs.getInt(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultContainer;
    }

    public static ArrayList<String> getStrColumnAdr(Connection conn, String column) {
        Statement stmt = null;

        ArrayList<String> resultContainer = new ArrayList<String>();
        // array subscript is the same as ID in database

        String query = "select " + column + " from " + "PUBLIC.Adres";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                resultContainer.add(rs.getString(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultContainer;
    }

    public static ArrayList<String> getStrColumnJedn(Connection conn, String column) {
        //todo many columns
        //columns ex: Nazwa, Ulica
        Statement stmt = null;

        ArrayList<String> resultContainer = new ArrayList<String>();
        // array subscript is the same as ID in database

//        todo more types Integer String Date, maybe container

        String query = "select " + column + " from " + "PUBLIC.Jednostka";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                resultContainer.add(rs.getString(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultContainer;
    }

    public static Jednostka getNadrzJednWhere(Connection conn, String params) {
        Statement stmt = null;
        Jednostka partUnit = null;

        String query = "select " + "NADRZEDNAJEDNOSTKA" + " from " + "PUBLIC.Jednostka" + " where " + params;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                Jednostka tmp = new Jednostka();
                tmp.setNadrzednaJednostka(rs.getInt("nadrzednaJednostka"));
                partUnit = tmp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //may be null
        return partUnit;
    }

    public static Integer getIDJednWhere(Connection conn, String params) {
        Statement stmt = null;
        Integer id = null;
        String query = "select ID" + " from " + "PUBLIC.Jednostka" + " where " + params;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) { //todo 1result! -> if (now we get the last one
                id = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    public static Integer getIDAddrWhereIdJedn(Connection conn, Integer param) {
        Statement stmt = null;
        Integer id = null;
        String query = "select Adres" + " from " + "PUBLIC.Jednostka" + " where ID=" + param;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                id = rs.getInt("Adres");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    public static Integer getIDAddrWhere(Connection conn, String params) {
        Statement stmt = null;
        Integer id = null;
        String query = "select ID" + " from " + "PUBLIC.Adres" + " where " + params;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) { //todo 1result! -> if (now we get the last one
                id = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    public static ArrayList<Jednostka> getAllJednWhere(Connection conn, String params) {
        Statement stmt = null;
        ArrayList<Jednostka> resJedn = new ArrayList<Jednostka>();

        String query = "select *" + " from " + "PUBLIC.Jednostka" + " where " + params;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                Jednostka oneRes = new Jednostka();
                oneRes.setID(rs.getInt("ID"));
                oneRes.setAdres(rs.getInt("Adres"));
                oneRes.setNazwa(rs.getString("Nazwa"));
                oneRes.setWww(rs.getString("Www"));
                oneRes.setTelefon(rs.getString("Telefon"));
                oneRes.setTelOpis(rs.getString("telOpis"));
                oneRes.setEmail(rs.getString("Email"));
                oneRes.setGodzinyPracy(rs.getString("godzinyPracy"));
                oneRes.setOpis(rs.getString("Opis"));
                oneRes.setInfoDodatkowe(rs.getString("InfoDodatkowe"));
                oneRes.setSpecjalizacja1(rs.getString("Specjalizacja1"));
                oneRes.setSpecjalizacja2(rs.getString("Specjalizacja2"));
                oneRes.setSpecjalizacja3(rs.getString("Specjalizacja3"));
                oneRes.setNadrzednaJednostka(rs.getInt("nadrzednaJednostka"));
                oneRes.setDataAktualizacji(rs.getDate("dataAktualizacji").toString()); //todo Date format
                resJedn.add(oneRes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resJedn;
    }

    public static Adres getAllAddWhere(Connection conn, String params) {
        Statement stmt = null;
        Adres resAdr = null;
        String query = "select *" + " from " + "PUBLIC.Adres" + " where " + params;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.setFetchSize(MAX_FETCH);
            while (rs.next()) {
                Adres oneRes = new Adres();
                oneRes.setID(rs.getInt("ID"));
                oneRes.setUlica(rs.getString("Ulica"));
                oneRes.setKodPocztowy(rs.getString("KodPocztowy"));
                oneRes.setDopisek(rs.getString("Dopisek"));
                oneRes.setMiasto(rs.getString("Miasto"));
                oneRes.setNrDomu(rs.getString("NrDomu"));
                resAdr = oneRes;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resAdr;
    }

    public static Integer getMaxFetch() {
        return MAX_FETCH;
    }
}