import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        Gerichtsplaner gerichtsplaner = new Gerichtsplaner(erzeugeGerichte(),true,true,true,false,false,false,false);
        List<Woche> wochen= gerichtsplaner.getWochen();
        for(int i = 0; i < wochen.size(); i++){
            List<Tag> tage = wochen.get(i).getTage();
            System.out.println("Woche " + i);
            for(int j = 0; j< tage.size(); j++){
                System.out.println(tage.get(j).getTagNr() + ":" + tage.get(j).getGerichtsname());
            }
        }
    }

    public static List<Gericht> erzeugeGerichte(){
        List<Gericht> gerichte = new ArrayList<>();

        gerichte.add(new Gericht("Pelmeni",1,true,false,false,false,false,false,false));
        gerichte.add(new Gericht("Plow",2,false,true,true,false,false,false,false));
        gerichte.add(new Gericht("Tifteli",2,false,true,true,false,false,false,false));


        return gerichte;
    }
}
