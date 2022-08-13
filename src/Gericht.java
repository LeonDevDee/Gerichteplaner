import java.util.ArrayList;
import java.util.List;

public class Gericht {
    String name = "";
    int genutzt = 0;
    int dauer = 0;
    List<Integer> tagNrs;

    public Gericht(String name, int dauer, boolean Montag, boolean Dienstag, boolean Mittwoch, boolean Donnerstag, boolean Freitag,
                   boolean Samstag, boolean Sonntag){
        this.name = name;
        this.dauer = dauer;

        tagNrs = new ArrayList<>();

        if(Montag){
            tagNrs.add(0);
        }
        if(Dienstag){
            tagNrs.add(1);
        }
        if(Mittwoch){
            tagNrs.add(2);
        }
        if(Donnerstag){
            tagNrs.add(3);
        }
        if(Freitag){
            tagNrs.add(4);
        }
        if(Samstag){
            tagNrs.add(5);
        }
        if(Sonntag){
            tagNrs.add(6);
        }
    }

    public void erhoeheGenutzt(){
        genutzt++;
    }

    public int getGenutzt(){
        return genutzt;
    }

    public int getDauer(){
        return dauer;
    }

    public String getName(){
        return name;
    }

    public boolean anTag(int tagNr){
        boolean anTag = false;
        for(int i = 0; i < tagNrs.size(); i++){
            if(tagNrs.get(i) == tagNr){
                anTag = true;
            }
        }
        return anTag;
    }
}
