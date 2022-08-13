import java.util.ArrayList;
import java.util.List;

public class Gerichtsplaner {

    List<Gericht> gerichte;
    List<Woche> wochen;
    public Gerichtsplaner(List<Gericht> gerichte, boolean Montag, boolean Dienstag, boolean Mittwoch, boolean Donnerstag, boolean Freitag,
                          boolean Samstag, boolean Sonntag){
        wochen = new ArrayList<>();
        this.gerichte = gerichte;


        do{
            if(!alleWochenVoll()){
                int wochenID = sucheLeereWochenID();
                List<Integer> tagNrs = wochen.get(wochenID).getLeereTagNrs();
                int passendeGerichtsID;
                if(tagNrs.size() > 1 && tagNrs.get(1) - 1 == tagNrs.get(0)){
                    passendeGerichtsID = suchePassendeGerichtID(tagNrs.get(0), 2);
                }else {
                    passendeGerichtsID = suchePassendeGerichtID(tagNrs.get(0), 1);
                }
                wochen.get(wochenID).fuegeGerichtHinzu(tagNrs.get(0),gerichte.get(passendeGerichtsID));
                gerichte.get(passendeGerichtsID).erhoeheGenutzt();
            }else{
                wochen.add(new Woche(Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, Sonntag));
            }

        }while (!alleGerichteGenutzt());



    }

    public boolean alleWochenVoll(){
        boolean alleVoll = true;
        for(int i = 0; i < wochen.size(); i++){
            if(!wochen.get(i).istVoll()){
                alleVoll = false;
            }
        }
        return alleVoll;
    }
    public boolean alleGerichteGenutzt(){
        boolean alleGenutzt = true;
        for(int i = 0; i < gerichte.size(); i++){
            if(gerichte.get(i).getGenutzt() < 1){
                alleGenutzt = false;
            }
        }
        return alleGenutzt;
    }

    public int sucheLeereWochenID(){
        for(int i = 0; i < wochen.size(); i++){
            if(!wochen.get(i).istVoll()){
                return i;
            }
        }
        System.out.println("Fehler in Gerichtsplaner /1");
        return -1;
    }

    public int suchePassendeGerichtID(int tagNr, int dauer){
        int gerichtMinGenutzt = 99999;
        for(int i = 0; i < gerichte.size(); i++){
            if(gerichte.get(i).anTag(tagNr) && gerichte.get(i).getDauer()<= dauer){
                if(gerichte.get(i).getGenutzt() < gerichtMinGenutzt){
                    gerichtMinGenutzt = gerichte.get(i).getGenutzt();
                }
            }
        }

        for(int i = 0; i < gerichte.size(); i++){
            if(gerichte.get(i).anTag(tagNr) && gerichte.get(i).getDauer()<= dauer &&
                    gerichte.get(i).getGenutzt() == gerichtMinGenutzt){
                return i;
            }
        }

        System.out.println("Fehler in Gerichtlaner /2");
        return -1;
    }

    public List<Woche> getWochen() {
        return wochen;
    }

}
