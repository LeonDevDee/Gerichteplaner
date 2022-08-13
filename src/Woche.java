import java.util.ArrayList;
import java.util.List;

public class Woche {
    List<Tag> tage;

    public Woche(boolean Montag, boolean Dienstag, boolean Mittwoch, boolean Donnerstag, boolean Freitag,
                 boolean Samstag, boolean Sonntag){
        tage = new ArrayList<>();

        if(Montag){
            tage.add(new Tag(0));
        }
        if(Dienstag){
            tage.add(new Tag(1));
        }
        if(Mittwoch){
            tage.add(new Tag(2));
        }
        if(Donnerstag){
            tage.add(new Tag(3));
        }
        if(Freitag){
            tage.add(new Tag(4));
        }
        if(Samstag){
            tage.add(new Tag(5));
        }
        if(Sonntag){
            tage.add(new Tag(6));
        }
    }

    public boolean istVoll(){
        boolean voll = true;
        for(int i = 0; i < tage.size(); i++){
            if(!tage.get(i).getBesetzt()){
                voll = false;
            }
        }
        return voll;
    }

    public List<Tag> getTage() {
        return tage;
    }

    public List<Integer> getLeereTagNrs(){
        List<Integer> tagNrs = new ArrayList<>();
        for(int i = 0; i < tage.size(); i++){
            if(!tage.get(i).getBesetzt()){
                tagNrs.add(tage.get(i).getTagNr());
            }
        }
        return tagNrs;
    }

    public void fuegeGerichtHinzu(int tagNr, Gericht gericht){
        int tagID = -1;
        for(int i = 0; i < tage.size(); i++){
            if (tage.get(i).getTagNr() == tagNr){
                tagID = i;
            }
        }

        if(tagID != -1){
            tage.get(tagID).setGerichtsname(gericht.getName());
            for(int i = 0; i < gericht.getDauer(); i++) {
                if(tagID + i <tage.size()) {
                    tage.get(tagID + i).setBesetzt(true);
                }else {
                    System.out.println("Fehler in Woche /2");
                }
            }
        }else{
            System.out.println("Fehler in Woche /1");
        }

    }
}
