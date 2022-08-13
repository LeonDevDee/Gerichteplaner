import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        TextdateienVerwaltung textdateienVerwaltung = new TextdateienVerwaltung("gerichte.txt");
        Gerichtsplaner gerichtsplaner = new Gerichtsplaner(erzeugeGerichte(textdateienVerwaltung),true,true,true,true,true,false,false);
        List<Woche> wochen= gerichtsplaner.getWochen();

        for(int i = 0; i < wochen.size(); i++){
            List<Tag> tage = wochen.get(i).getTage();
            System.out.println("Woche " + i);
            for(int j = 0; j< tage.size(); j++){
                System.out.println(tage.get(j).getTagNr() + ":" + tage.get(j).getGerichtsname());
            }
        }
    }

    public static List<Gericht> erzeugeGerichte(TextdateienVerwaltung tv){
        List<Gericht> gerichte = new ArrayList<>();

        List<String> gerichteRaw = tv.DateiLesen();
        for(int i = 0; i < gerichteRaw.size(); i++){
            String gerichtRaw = gerichteRaw.get(i);
            String[] gerichtArray = gerichtRaw.split(",");
            String name = gerichtArray[0];
            int dauer = Integer.parseInt(gerichtArray[1]);
            boolean montag, dienstag, mittwoch, donnerstag, freitag, samstag, sonntag;
            montag = dienstag = mittwoch = donnerstag = freitag = samstag = sonntag = false;

            for(int j = 0 ; j + 2< gerichtArray.length; j++){
                switch (gerichtArray[j + 2]){
                    case "Mo":
                        montag = true;
                        break;
                    case "Di":
                        dienstag = true;
                        break;
                    case "Mi":
                        mittwoch = true;
                        break;
                    case "Do":
                        donnerstag = true;
                        break;
                    case "Fr":
                        freitag = true;
                        break;
                    case "Sa":
                        samstag = true;
                        break;
                    case "So":
                        sonntag = true;
                        break;
                }
            }

            gerichte.add(new Gericht(name, dauer, montag, dienstag, mittwoch, donnerstag, freitag, samstag, sonntag));

        }

        return gerichte;
    }
}
