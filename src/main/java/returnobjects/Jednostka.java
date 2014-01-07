package returnobjects;

import java.io.Serializable;

/**
 * @author Rafal Zawadzki
 */
public class Jednostka implements Serializable {
    Integer ID;
    Integer Adres;
    String Nazwa;
    String Www;
    String Telefon;
    String TelOpis;
    String Email;
    String GodzinyPracy;
    String Opis;
    String InfoDodatkowe;
    String Specjalizacja1;
    String Specjalizacja2;
    String Specjalizacja3;
    Integer NadrzednaJednostka;
    String DataAktualizacji;

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public void setWww(String Www) {
        this.Www = Www;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public void setTelOpis(String telOpis) {
        TelOpis = telOpis;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGodzinyPracy(String godzinyPracy) {
        GodzinyPracy = godzinyPracy;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public void setInfoDodatkowe(String infoDodatkowe) {
        InfoDodatkowe = infoDodatkowe;
    }

    public void setSpecjalizacja1(String specjalizacja1) {
        Specjalizacja1 = specjalizacja1;
    }

    public void setSpecjalizacja2(String specjalizacja2) {
        Specjalizacja2 = specjalizacja2;
    }

    public void setSpecjalizacja3(String specjalizacja3) {
        Specjalizacja3 = specjalizacja3;
    }

    public void setNadrzednaJednostka(Integer nadrzednaJednostka) {
        NadrzednaJednostka = nadrzednaJednostka;
    }

    public void setDataAktualizacji(String dataAktualizacji) {
        DataAktualizacji = dataAktualizacji;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public String getWww() {
        return Www;
    }

    public String getDataAktualizacji() {
        return DataAktualizacji;
    }

    public Integer getNadrzednaJednostka() {
        return NadrzednaJednostka;
    }

    public String getSpecjalizacja3() {
        return Specjalizacja3;
    }

    public String getSpecjalizacja2() {
        return Specjalizacja2;
    }

    public String getSpecjalizacja1() {
        return Specjalizacja1;
    }

    public String getInfoDodatkowe() {
        return InfoDodatkowe;
    }

    public String getOpis() {
        return Opis;
    }

    public String getGodzinyPracy() {
        return GodzinyPracy;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelOpis() {
        return TelOpis;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setID(Integer ID){
        this.ID = ID;
    }

    public Integer getID(){
        return this.ID;
    }

    public void setAdres(Integer Adres){
        this.Adres = Adres;
    }

    public Integer getAdres(){
        return Adres;
    }
}
