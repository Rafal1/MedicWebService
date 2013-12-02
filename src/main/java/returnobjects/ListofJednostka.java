package returnobjects;

import java.util.ArrayList;

/**
 * @author Rafal Zawadzki
 */
public class ListofJednostka {
    ArrayList<Jednostka> ResList;

    public ListofJednostka(ArrayList exList) {
        ResList = exList;
    }

    public ArrayList<Jednostka> getResList() {
        return ResList;
    }

    public void setResList(ArrayList<Jednostka> resList) {
        ResList = resList;
    }
}
