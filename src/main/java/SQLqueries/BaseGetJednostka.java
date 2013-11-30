package sqlqueries;

import returnobjects.Jednostka;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Rafal Zawadzki
 */
public class BaseGetJednostka {
    //todo getID where parametr =
    //todo get all where parametr

    public static ArrayList<Jednostka> getAllJednWhere(Connection conn, String params){
        Statement stmt = null;
        ArrayList<Jednostka> resJedn = new ArrayList<Jednostka>();

        String query = "select *" + "from " + "PUBLIC.Jednostka" + "where " + params;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jednostka oneRes = new Jednostka();
                oneRes.setID( rs.getInt("ID") );
                oneRes.setAdres( rs.getInt("Adres") );
                oneRes.setNazwa( rs.getString("Nazwa") );
                oneRes.setWww( rs.getString("Www") );
                oneRes.setTelefon( rs.getString("Telefon") );
                oneRes.setTelOpis( rs.getString("telOpis") );
                oneRes.setEmail( rs.getString("Email") );
                oneRes.setGodzinyPracy( rs.getString("godzinyPracy") );
                oneRes.setOpis( rs.getString("Opis") );
                oneRes.setInfoDodatkowe( rs.getString("InfoDodatkowe") );
                oneRes.setSpecjalizacja1( rs.getString("Specjalizacja1") );
                oneRes.setSpecjalizacja2( rs.getString("Specjalizacja2") );
                oneRes.setSpecjalizacja3( rs.getString("Specjalizacja3") );
                oneRes.setNadrzednaJednostka( rs.getInt("nadrzednaJednostka") );
                oneRes.setPodrzedneJednostki( rs.getString("podrzedneJednostki") );
                oneRes.setDataAktualizacji( rs.getDate("dataAktualizacji") );
                oneRes.setLokalizacja( rs.getString("Lokalizacja") );
                resJedn.add(oneRes);
            }
        } catch (SQLException e ) {
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

}
